package jcc2.lib.utillib;

import java.io.UnsupportedEncodingException;
import jcc2.common.ClassContainer;
import jcc2.common.MethodContainer;
import jcc2.common.Type;
import jcc2.lib.RTObject;

/***
 * 
 * @author NeiroNext
 *
 */

public class Base64 extends RTObject
{
  static ClassContainer ctClass = null;
  static boolean bInit = false;
  private static byte[] __bytes;

  private static final byte[] _NATIVE_ALPHABET = { 
    65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 
    75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 
    85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 
    101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 
    111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 
    121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 
    56, 57, 43, 47 };

  private static final byte[] DECODABET = { 
    -9, -9, -9, -9, -9, -9, -9, -9, -9, -5, 
    -5, -9, -9, -5, -9, -9, -9, -9, -9, -9, 
    -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, 
    -9, -9, -5, -9, -9, -9, -9, -9, -9, -9, 
    -9, -9, -9, 62, -9, -9, -9, 63, 52, 53, 
    54, 55, 56, 57, 58, 59, 60, 61, -9, -9, 
    -9, -1, -9, -9, -9, 0, 1, 2, 3, 4, 
    5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 
    15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 
    25, -9, -9, -9, -9, -9, -9, 26, 27, 28, 
    29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 
    39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 
    49, 50, 51, -9, -9, -9, -9 };

  
  static
  {
    try
    {
      __bytes = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/".getBytes("UTF-8");
    }
    catch (UnsupportedEncodingException use)
    {
      __bytes = _NATIVE_ALPHABET;
    }
  }
  private static final byte[] ALPHABET = __bytes;
  
  
  
  public static ClassContainer getClassContainer()
  {
    if (ctClass != null)
      return ctClass;
    ClassContainer container = new ClassContainer("Base64");
    container.className = "jcc2/lib/utillib/Base64";
    ctClass = container;
    return ctClass;
  }

  
  public static void initClassContainer()
  {
    if (bInit)
      return;
    bInit = true;

    ClassContainer container = getClassContainer();

    Type[] args;
    MethodContainer method;
    int mid = 0;

    args = new Type[0];
    method = new MethodContainer("<init>", Type.TYPE_VOID, args, null, mid++);
    container.addMethod(method);

    args = new Type[1];
    args[0] = Type.TYPE_STRING;
    method = new MethodContainer("encode", Type.TYPE_STRING, args, null, mid++);
    container.addMethod(method);

    args = new Type[1];
    args[0] = Type.TYPE_STRING;
    method = new MethodContainer("decode", Type.TYPE_STRING, args, null, mid++);
    container.addMethod(method);
  }

  
  
  public Object rtInvoke(int iMethod, Object[] args) throws Exception
  {
    switch (iMethod)
    {
	    case 0: //	init
	    {
	      return Type.TYPE_VOID;
	    }
	    case 1: //	encode(String)
	    {
	      return encode((String)args[0]);
	    }
	    case 2: //	decode(String)
	    {
	      return decode((String)args[0]);
	    }
    }

    throw new Exception("Base64[" + iMethod + "]");
  }

  
  
  
  
// ------------------------------ Methods ----------------------- //
  
  private static byte[] encode3to4(byte[] source, int srcOffset, int numSigBytes, byte[] destination, int destOffset)
  {
    int inBuff = (numSigBytes <= 0 ? 0 : source[srcOffset] << 24 >>> 8) | (numSigBytes <= 1 ? 0 : source[(srcOffset + 1)] << 24 >>> 16) | (numSigBytes <= 2 ? 0 : source[(srcOffset + 2)] << 24 >>> 24);
    switch (numSigBytes)
    {
    case 3:
      destination[destOffset] = ALPHABET[(inBuff >>> 18)];
      destination[(destOffset + 1)] = ALPHABET[(inBuff >>> 12 & 0x3F)];
      destination[(destOffset + 2)] = ALPHABET[(inBuff >>> 6 & 0x3F)];
      destination[(destOffset + 3)] = ALPHABET[(inBuff & 0x3F)];
      return destination;
    case 2:
      destination[destOffset] = ALPHABET[(inBuff >>> 18)];
      destination[(destOffset + 1)] = ALPHABET[(inBuff >>> 12 & 0x3F)];
      destination[(destOffset + 2)] = ALPHABET[(inBuff >>> 6 & 0x3F)];
      destination[(destOffset + 3)] = 61;
      return destination;
    case 1:
      destination[destOffset] = ALPHABET[(inBuff >>> 18)];
      destination[(destOffset + 1)] = ALPHABET[(inBuff >>> 12 & 0x3F)];
      destination[(destOffset + 2)] = 61;
      destination[(destOffset + 3)] = 61;
      return destination;
    }
    return destination;
  }

  private static String encodeBytes(byte[] source, int off, int len, int options)
  {
    int dontBreakLines = options & 0x8;
    boolean breakLines = dontBreakLines == 0;
    int len43 = len * 4 / 3;
    byte[] outBuff = new byte[len43 + (len % 3 <= 0 ? 0 : 4) + (breakLines ? len43 / 76 : 0)];

    int d = 0;
    int e = 0;
    int len2 = len - 2;
    int lineLength = 0;
    while (d < len2)
    {
      encode3to4(source, d + off, 3, outBuff, e);
      lineLength += 4;
      if ((breakLines) && (lineLength == 76))
      {
        outBuff[(e + 4)] = 10;
        e++;
        lineLength = 0;
      }
      d += 3;
      e += 4;
    }
    if (d < len)
    {
      encode3to4(source, d + off, len - d, outBuff, e);
      e += 4;
    }
    try
    {
      return new String(outBuff, 0, e, "UTF-8");
    }
    catch (UnsupportedEncodingException uue) {
    }
    return new String(outBuff, 0, e);
  }

  private static int decode4to3(byte[] source, int srcOffset, byte[] destination, int destOffset)
  {
    try
    {
      if (source[(srcOffset + 2)] == 61)
      {
        int outBuff = (DECODABET[source[srcOffset]] & 0xFF) << 18 | (DECODABET[source[(srcOffset + 1)]] & 0xFF) << 12;
        destination[destOffset] = ((byte)(outBuff >>> 16));
        return 1;
      }
      if (source[(srcOffset + 3)] == 61)
      {
        int outBuff = (DECODABET[source[srcOffset]] & 0xFF) << 18 | (DECODABET[source[(srcOffset + 1)]] & 0xFF) << 12 | (DECODABET[source[(srcOffset + 2)]] & 0xFF) << 6;
        destination[destOffset] = ((byte)(outBuff >>> 16));
        destination[(destOffset + 1)] = ((byte)(outBuff >>> 8));
        return 2;
      }
      int outBuff = (DECODABET[source[srcOffset]] & 0xFF) << 18 | (DECODABET[source[(srcOffset + 1)]] & 0xFF) << 12 | (DECODABET[source[(srcOffset + 2)]] & 0xFF) << 6 | DECODABET[source[(srcOffset + 3)]] & 0xFF;
      destination[destOffset] = ((byte)(outBuff >> 16));
      destination[(destOffset + 1)] = ((byte)(outBuff >> 8));
      destination[(destOffset + 2)] = ((byte)outBuff);
      return 3;
    }
    catch (Exception e)
    {
      System.out.println(source[srcOffset] + ": " + DECODABET[source[srcOffset]]);
      System.out.println(source[(srcOffset + 1)] + ": " + DECODABET[source[(srcOffset + 1)]]);
      System.out.println(source[(srcOffset + 2)] + ": " + DECODABET[source[(srcOffset + 2)]]);
      System.out.println(source[(srcOffset + 3)] + ": " + DECODABET[source[(srcOffset + 3)]]);
    }return -1;
  }

  private static byte[] decode(byte[] source, int off, int len)
  {
    int len34 = len * 3 / 4;
    byte[] outBuff = new byte[len34];
    int outBuffPosn = 0;
    byte[] b4 = new byte[4];
    int b4Posn = 0;
    int i = 0;
    byte sbiCrop = 0;
    byte sbiDecode = 0;
    for (i = off; i < off + len; i++)
    {
      sbiCrop = (byte)(source[i] & 0x7F);
      sbiDecode = DECODABET[sbiCrop];
      if (sbiDecode >= -5)
      {
        if (sbiDecode >= -1)
        {
          b4[(b4Posn++)] = sbiCrop;
          if (b4Posn > 3)
          {
            outBuffPosn += decode4to3(b4, 0, outBuff, outBuffPosn);
            b4Posn = 0;
            if (sbiCrop == 61)
              break; 
          }
        }
      } else { System.err.println("Bad Base64 input character at " + i + ": " + source[i] + "(decimal)");
        return null;
      }
    }

    byte[] out = new byte[outBuffPosn];
    System.arraycopy(outBuff, 0, out, 0, outBuffPosn);
    return out;
  }

  public static String decode(String data)
  {
    byte[] d = null;
    d = data.getBytes();
    d = decode(d, 0, d.length);
    return new String(d);
  }

  public static String encode(String data)
  {
    byte[] d = null;
    d = data.getBytes();
    return encodeBytes(d, 0, d.length, 8);
  }
  
}