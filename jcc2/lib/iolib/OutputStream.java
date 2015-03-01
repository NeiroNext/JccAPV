package jcc2.lib.iolib;

import java.io.DataOutputStream;
import jcc2.common.ClassContainer;
import jcc2.common.MethodContainer;
import jcc2.common.Type;
import jcc2.lib.RTObject;

/**
 * 
 * @author note173@gmail.com
 *
 */

public class OutputStream extends RTObject
{
  static ClassContainer ctClass = null;
  static boolean bInit = false;
  public DataOutputStream os;

  public static ClassContainer getClassContainer()
  {
    if (ctClass != null) {
      return ctClass;
    }
    ClassContainer container = new ClassContainer("OutputStream");
    container.className = "jcc2/lib/iolib/OutputStream";
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
    method = new MethodContainer("flush", Type.TYPE_VOID, args, null, mid++);
    container.addMethod(method);

    args = new Type[1];
    args[0] = Type.TYPE_INT;
    method = new MethodContainer("write", Type.TYPE_VOID, args, null, mid++);
    container.addMethod(method);

    args = new Type[3];
    args[0] = Type.TYPE_ABYTE;
    args[1] = Type.TYPE_INT;
    args[2] = Type.TYPE_INT;
    method = new MethodContainer("write", Type.TYPE_VOID, args, null, mid++);
    container.addMethod(method);

    args = new Type[1];
    args[0] = Type.TYPE_INT;
    method = new MethodContainer("writeByte", Type.TYPE_VOID, args, null, mid++);
    container.addMethod(method);

    args = new Type[1];
    args[0] = Type.TYPE_INT;
    method = new MethodContainer("writeChar", Type.TYPE_VOID, args, null, mid++);
    container.addMethod(method);

    args = new Type[1];
    args[0] = Type.TYPE_INT;
    method = new MethodContainer("writeShort", Type.TYPE_VOID, args, null, mid++);
    container.addMethod(method);

    args = new Type[1];
    args[0] = Type.TYPE_INT;
    method = new MethodContainer("writeInt", Type.TYPE_VOID, args, null, mid++);
    container.addMethod(method);

    args = new Type[1];
    args[0] = Type.TYPE_LONG;
    method = new MethodContainer("writeLong", Type.TYPE_VOID, args, null, mid++);
    container.addMethod(method);

    args = new Type[1];
    args[0] = Type.TYPE_FLOAT;
    method = new MethodContainer("writeFloat", Type.TYPE_VOID, args, null, mid++);
    container.addMethod(method);

    args = new Type[1];
    args[0] = Type.TYPE_DOUBLE;
    method = new MethodContainer("writeDouble", Type.TYPE_VOID, args, null, mid++);
    container.addMethod(method);

    args = new Type[1];
    args[0] = Type.TYPE_STRING;
    method = new MethodContainer("writeUTF", Type.TYPE_VOID, args, null, mid++);
    container.addMethod(method);

    args = new Type[1];
    args[0] = Type.TYPE_ABYTE;
    method = new MethodContainer("writeByteArray", Type.TYPE_VOID, args, null, mid++);
    container.addMethod(method);
  }

  
  
  
  
  
  
  public Object rtInvoke(int iMethod, Object[] args)
    throws Exception
  {
    switch (iMethod)
    {
	    case 0: //	flush()
	    {
	      flush();
	      return Type.TYPE_VOID;
	    }
	    case 1: //	write(int)
	    {
	      write(((int[])args[0])[0]);
	      return Type.TYPE_VOID;
	    }
	    case 2: //	write(byte[], int, int)
	    {
	      write((byte[])((Object[])args[0])[0], ((int[])args[1])[0], ((int[])args[2])[0]);
	      return Type.TYPE_VOID;
	    }
	    case 3: //	writeByte(int)
	    {
	      writeByte(((int[])args[0])[0]);
	      return Type.TYPE_VOID;
	    }
	    case 4: //	writeChar(char)
	    {
	      writeChar(((int[])args[0])[0]);
	      return Type.TYPE_VOID;
	    }
	    case 5: //	writeShort(int)
	    {
	      writeShort(((int[])args[0])[0]);
	      return Type.TYPE_VOID;
	    }
	    case 6: //	writeInt(int)
	    {
	      writeInt(((int[])args[0])[0]);
	      return Type.TYPE_VOID;
	    }
	    case 7: //	writeLong(long)
	    {
	      writeLong(((long[])args[0])[0]);
	      return Type.TYPE_VOID;
	    }
	    case 8: //	writeFloat(float)
	    {
	      writeFloat(((float[])args[0])[0]);
	      return Type.TYPE_VOID;
	    }
	    case 9: //	writeDouble(double)
	    {
	      writeDouble(((double[])args[0])[0]);
	      return Type.TYPE_VOID;
	    }
	    case 10: //	writeUTF(String)
	    {
	      writeUTF((String)args[0]);
	      return Type.TYPE_VOID;
	    }
	    case 11: //	writeByteArray(byte[])
	    {
	      writeByteArray((byte[])((Object[])args[0])[0]);
	      return Type.TYPE_VOID;
	    }
    }

    throw new Exception("OutputStream[" + iMethod + "]");
  }

  
  
  
  
  
  
// ----------------------------- Methods ------------------------ //
  
  public void flush()
  {
    try
    {
      os.flush();
    } catch (Exception localException) {}
  }

  public void write(int v) {
    try {
      os.write(v);
    } catch (Exception localException) {}
  }

  public void write(byte[] data, int offset, int length) {
    try {
      os.write(data, offset, length);
    } catch (Exception localException) {}
  }

  public void writeByte(int v) {
    try {
      os.writeByte(v);
    } catch (Exception localException) {}
  }

  public void writeChar(int v) {
    try {
      os.writeChar(v);
    } catch (Exception localException) {}
  }

  public void writeChars(String v) {
    try {
      os.writeChars(v);
    } catch (Exception localException) {}
  }

  public void writeShort(int v) {
    try {
      os.writeShort(v);
    } catch (Exception localException) {}
  }

  public void writeInt(int v) {
    try {
      os.writeInt(v);
    } catch (Exception localException) {}
  }

  public void writeLong(long v) {
    try {
      os.writeLong(v);
    } catch (Exception localException) {}
  }

  public void writeFloat(float v) {
    try {
      os.writeFloat(v);
    } catch (Exception localException) {}
  }

  public void writeDouble(double v) {
    try {
      os.writeDouble(v);
    } catch (Exception localException) {}
  }

  public void writeUTF(String str) {
    try {
      os.writeUTF(str);
    } catch (Exception localException) {}
  }

  public void writeByteArray(byte[] b) {
    try {
      os.write(b);
    }
    catch (Exception localException){}
  }
}