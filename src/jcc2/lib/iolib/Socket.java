package jcc2.lib.iolib;

import java.io.IOException;
import javax.microedition.io.SocketConnection;
import jcc2.common.ClassContainer;
import jcc2.common.MethodContainer;
import jcc2.common.Type;
import jcc2.lib.RTObject;
import jcc2.lib.stdlib.library;

/**
 * 
 * @author note173@gmail.com
 */

public class Socket extends RTObject
{
  static ClassContainer ctClass = null;
  static boolean bInit = false;
  SocketConnection socket;

  public static ClassContainer getClassContainer()
  {
    if (ctClass != null)
      return ctClass;
    ClassContainer container = new ClassContainer("Socket");
    container.className = "jcc2/lib/iolib/Socket";
    ctClass = container;
    return ctClass;
  }

  
  
  
  public static void initClassContainer()
  {
    if (bInit)
      return;
    bInit = true;

    ClassContainer container = getClassContainer();

    container.addStatic("DELAY", new Integer(0), Type.TYPE_BYTE);
    container.addStatic("KEEPALIVE", new Integer(2), Type.TYPE_BYTE);
    container.addStatic("LINGER", new Integer(1), Type.TYPE_BYTE);
    container.addStatic("RCVBUF", new Integer(3), Type.TYPE_BYTE);
    container.addStatic("SNDBUF", new Integer(4), Type.TYPE_BYTE);

    Type[] args;
    MethodContainer method;
    int mid = 0;

    args = new Type[0];
    method = new MethodContainer("openInputStream", new Type(InputStream.getClassContainer(), 0), args, null, mid++);
    container.addMethod(method);

    args = new Type[0];
    method = new MethodContainer("openOutputStream", new Type(OutputStream.getClassContainer(), 0), args, null, mid++);
    container.addMethod(method);

    args = new Type[0];
    method = new MethodContainer("close", Type.TYPE_VOID, args, null, mid++);
    container.addMethod(method);

    args = new Type[0];
    method = new MethodContainer("getAddress", Type.TYPE_STRING, args, null, mid++);
    container.addMethod(method);

    args = new Type[0];
    method = new MethodContainer("getLocalAddress", Type.TYPE_STRING, args, null, mid++);
    container.addMethod(method);

    args = new Type[0];
    method = new MethodContainer("getPort", Type.TYPE_INT, args, null, mid++);
    container.addMethod(method);

    args = new Type[0];
    method = new MethodContainer("getLocalPort", Type.TYPE_INT, args, null, mid++);
    container.addMethod(method);

    args = new Type[1];
    args[0] = Type.TYPE_BYTE;
    method = new MethodContainer("getSocketOption", Type.TYPE_INT, args, null, mid++);
    container.addMethod(method);

    args = new Type[2];
    args[0] = Type.TYPE_BYTE;
    args[1] = Type.TYPE_INT;
    method = new MethodContainer("setSocketOption", Type.TYPE_VOID, args, null, mid++);
    container.addMethod(method);
  }

  
  
  
  
  
  
// ------------------------------ Methods ------------------------------- //
  
  
  public Object rtInvoke(int iMethod, Object[] args) throws Exception
  {
    switch (iMethod)
    {
	    case 0: //	openInputStream()
	    {
	      return openInputStream();
	    }
	    case 1: //	openOutputStream()
	    {
	      return openOutputStream();
	    }
	    case 2: //	close()
	    {
	      close();
	      return Type.TYPE_VOID;
	    }
	    case 3: //	getAddress()
	    {
	      return getAddress();
	    }
	    case 4: //	getLocalAddress()
	    {
	      return getLocalAddress();
	    }
	    case 5: //	getPort()
	    {
	      int[] v = { getPort() };
	      return v;
	    }
	    case 6: //	getLocalPort()
	    {
	      int[] v = { getLocalPort() };
	      return v;
	    }
	    case 7: //	getSocketOption(byte)
	    {
	      int[] v = { getSocketOption((byte)((int[])args[0])[0]) };
	      return v;
	    }
	    case 8: //	getSocketOption(byte, int)
	    {
	      setSocketOption((byte)((int[])args[0])[0], ((int[])args[1])[0]);
	      return Type.TYPE_VOID;
	    }
    }
    throw new Exception("Socket[" + iMethod + "]");
  }

  
  
  
  
  
  
// --------------------------- Methods ------------------------------- //
  
  public InputStream openInputStream()
  {
    try
    {
      InputStream is = new InputStream();
      is.is = socket.openDataInputStream();
      library.getSingleton().setLastError(null);
      return is;
    }
    catch (IOException e)
    {
      library.getSingleton().setLastError(e.toString());
    }	return null;
  }

  public OutputStream openOutputStream()
  {
    try
    {
      OutputStream os = new OutputStream();
      os.os = socket.openDataOutputStream();
      library.getSingleton().setLastError(null);
      return os;
    }
    catch (IOException e)
    {
      library.getSingleton().setLastError(e.toString());
    }	return null;
  }

  public void close()
  {
    try
    {
      socket.close();
      library.getSingleton().setLastError(null);
    }
    catch (IOException e)
    {
      library.getSingleton().setLastError(e.toString());
    }
  }

  public String getAddress()
  {
    try
    {
      library.getSingleton().setLastError(null);
      return socket.getAddress();
    }
    catch (IOException e)
    {
      library.getSingleton().setLastError(e.toString());
    }	return null;
  }

  public String getLocalAddress()
  {
    try
    {
      library.getSingleton().setLastError(null);
      return socket.getLocalAddress();
    }
    catch (IOException e)
    {
      library.getSingleton().setLastError(e.toString());
    }	return null;
  }

  public int getPort()
  {
    try
    {
      library.getSingleton().setLastError(null);
      return socket.getPort();
    }
    catch (IOException e)
    {
      library.getSingleton().setLastError(e.toString());
    }	return -1;
  }

  public int getLocalPort()
  {
    try
    {
      library.getSingleton().setLastError(null);
      return socket.getLocalPort();
    }
    catch (IOException e)
    {
      library.getSingleton().setLastError(e.toString());
    }	return -1;
  }

  public int getSocketOption(byte option)
  {
    try
    {
      library.getSingleton().setLastError(null);
      return socket.getSocketOption(option);
    }
    catch (IOException e)
    {
      library.getSingleton().setLastError(e.toString());
    }	return -1;
  }

  public void setSocketOption(byte option, int val)
  {
    try
    {
      library.getSingleton().setLastError(null);
      socket.setSocketOption(option, val);
    }
    catch (IOException e)
    {
      library.getSingleton().setLastError(e.toString());
    }
  }
  
}