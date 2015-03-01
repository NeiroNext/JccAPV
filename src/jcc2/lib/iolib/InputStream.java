package jcc2.lib.iolib;

import java.io.DataInputStream;
import jcc2.common.ClassContainer;
import jcc2.common.MethodContainer;
import jcc2.common.Type;
import jcc2.lib.RTObject;
import javax.microedition.lcdui.*;


/**
 * 
 * @author note173@gmail.com
 *
 */

public class InputStream extends RTObject
{
  static ClassContainer ctClass = null;
  static boolean bInit = false;
  public DataInputStream is;

  public static ClassContainer getClassContainer()
  {
    if (ctClass != null) {
      return ctClass;
    }
    ClassContainer container = new ClassContainer("InputStream");
    container.className = "jcc2/lib/iolib/InputStream";
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
    method = new MethodContainer("read", Type.TYPE_INT, args, null, mid++);
    container.addMethod(method);

    args = new Type[0];
    method = new MethodContainer("readChar", Type.TYPE_CHAR, args, null, mid++);
    container.addMethod(method);

    args = new Type[0];
    method = new MethodContainer("readShort", Type.TYPE_SHORT, args, null, mid++);
    container.addMethod(method);

    args = new Type[0];
    method = new MethodContainer("readInt", Type.TYPE_INT, args, null, mid++);
    container.addMethod(method);

    args = new Type[0];
    method = new MethodContainer("readLong", Type.TYPE_LONG, args, null, mid++);
    container.addMethod(method);

    args = new Type[0];
    method = new MethodContainer("readFloat", Type.TYPE_FLOAT, args, null, mid++);
    container.addMethod(method);

    args = new Type[0];
    method = new MethodContainer("readDouble", Type.TYPE_DOUBLE, args, null, mid++);
    container.addMethod(method);

    args = new Type[0];
    method = new MethodContainer("readUTF", Type.TYPE_STRING, args, null, mid++);
    container.addMethod(method);

    args = new Type[0];
    method = new MethodContainer("readByteArray", Type.TYPE_ABYTE, args, null, mid++);
    container.addMethod(method);
  }

  
  
  
  
  public Object rtInvoke(int iMethod, Object[] args) throws Exception
  {
    switch (iMethod)
    {
	    case 0: //	read()
	    {
	      int[] ret = { read() };
	      return ret;
	    }
	    case 1: //	readChar()
	    {
	      char[] ret = { readChar() };
	      return ret;
	    }
	    case 2: //	readShort()
	    {
	      short[] ret = { readShort() };
	      return ret;
	    }
	    case 3: //	readInt()
	    {
	      int[] ret = { readInt() };
	      return ret;
	    }
	    case 4: //	readLong()
	    {
	      long[] ret = { readLong() };
	      return ret;
	    }
	    case 5: //	readFloat()
	    {
	      float[] ret = { readFloat() };
	      return ret;
	    }
	    case 6: //	readDouble()
	    {
	      double[] ret = { readDouble() };
	      return ret;
	    }
	    case 7: //	readUTF()
	    {
	      String ret = readUTF();
	      return ret;
	    }
	    case 8: //	readByteArray()
	    {
	      Object[] ret = { readByteArray() };
	      return ret;
	    }
    }

    throw new Exception("InputStream[" + iMethod + "]");
  }

  
  
  
  
  
  
// ----------------------------- Methods --------------------- //
  
  
  public int read()
  {
    try
    {
      return is.read(); } catch (Exception e) {
    }
    return -1;
  }

  public char readChar()
  {
    try
    {
      return is.readChar(); } catch (Exception e) {
    }
    return (char)-1;
  }

  public short readShort()
  {
    try
    {
      return is.readShort(); } catch (Exception e) {
    }
    return -1;
  }

  public int readInt()
  {
    try
    {
      return is.readInt(); } catch (Exception e) {
    }
    return -1;
  }

  public long readLong()
  {
    try
    {
      return is.readLong(); } catch (Exception e) {
    }
    return -1L;
  }

  public float readFloat()
  {
    try
    {
      return is.readFloat(); } catch (Exception e) {
    }
    return -1.0F;
  }

  public double readDouble()
  {
    try
    {
      return is.readDouble(); } catch (Exception e) {
    }
    return -1.0D;
  }

  public String readUTF()
  {
    try
    {
      return is.readUTF(); } catch (Exception e) {
    }
    return null;
  }

  public byte[] readByteArray()
  {
    byte[] ret;
    try {
      ret = new byte[is.available()];
      for (int i = 0; i < ret.length; i++)
        ret[i] = is.readByte();
    } catch (Exception e) {
      e.printStackTrace();
      ret = null;
    }
    return ret;
  }
}