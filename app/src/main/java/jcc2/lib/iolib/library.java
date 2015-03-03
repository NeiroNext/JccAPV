package jcc2.lib.iolib;

import java.io.DataInputStream;
import java.util.Enumeration;
import java.util.Hashtable;
import javax.microedition.io.Connector;
import javax.microedition.io.SocketConnection;
import jcc2.common.ClassContainer;
import jcc2.common.MethodContainer;
import jcc2.common.Type;
import jcc2.lib.Library;
import jcc2.lib.RTCallbackCaller;


/***
 * 
 * @author note173@gmail.com
 *
 */



public class library extends Library
{
  public static library singleton;
  static boolean bInit = false;
  Hashtable htClasses;
  Hashtable htMethods;
  RTCallbackCaller callbackCaller;

  public static library getSingleton(RTCallbackCaller caller)
  {
    if (singleton == null)
      singleton = new library();
    singleton.callbackCaller = caller;
    return singleton;
  }

  public library(){
    init(false);
  }

  public String getDesc()
  {
    return "jcc2/lib/iolib/library";
  }

  public String getName()
  {
    return "iolib";
  }

  public ClassContainer ctGetClass(String name)
  {
    return (ClassContainer)htClasses.get(name);
  }

  public MethodContainer ctGetMethod(String desc)
  {
    return (MethodContainer)htMethods.get(desc);
  }
  
  public Enumeration ctGetAllClasses()
  {
    return htClasses.elements();
  }

  public Enumeration ctGetAllMethods()
  {
    return htMethods.elements();
  }
  
  public Object rtNewObject(int id)
    throws Exception
  {
    switch (id)
    {
    case 0:
      return new InputStream();
    case 1:
      return new OutputStream();
    case 2:
      return new Socket();
    case 3:
      return new ByteEdit();
    }

    throw new Exception("object not found");
  }

  public Object rtNewArray(int id, int len)
    throws Exception
  {
    switch (id)
    {
    case 0:
      return new InputStream[len];
    case 1:
      return new OutputStream[len];
    case 2:
      return new Socket[len];
    case 3:
      return new ByteEdit[len];
    }

    throw new Exception("object not found");
  }
  
  
  
  
  
  public void init(boolean compileTime)
  {
    if (compileTime)
    {
      htClasses = new Hashtable();
      htMethods = new Hashtable();

      ClassContainer ct;
      int cid = 0;
      
      InputStream.initClassContainer();
      OutputStream.initClassContainer();
      Socket.initClassContainer();
      ByteEdit.initClassContainer();

      ct = InputStream.getClassContainer();
      ct.id = (cid++);
      ct.libHost = this;
      htClasses.put(ct.name, ct);
      
      ct = OutputStream.getClassContainer();
      ct.id = (cid++);
      ct.libHost = this;
      htClasses.put(ct.name, ct);
      
      ct = Socket.getClassContainer();
      ct.id = (cid++);
      ct.libHost = this;
      htClasses.put(ct.name, ct);
      
      ct = ByteEdit.getClassContainer();
      ct.id = (cid++);
      ct.libHost = this;
      htClasses.put(ct.name, ct);

      
      
      
      Type[] args;
      MethodContainer method;
      int mid = 0;
      
      args = new Type[1];
      args[0] = Type.TYPE_STRING;
      method = new MethodContainer("socketOpen", new Type(Socket.getClassContainer(), 0), args, this, mid++);
      htMethods.put(method.spec, method);

      args = new Type[1];
      args[0] = Type.TYPE_STRING;
      method = new MethodContainer("openInputStream", new Type(InputStream.getClassContainer(), 0), args, this, mid++);
      htMethods.put(method.spec, method);
    }
    else
    {
      singleton = this;
    }
  }

  
  
  

  public Object rtInvokeMethod(int id, Object[] args, RTCallbackCaller caller) throws Exception
  {
    switch (id)
    {
    	case 0: //	socetOpen(String)
	    {
	      return socketOpen((String)args[0]);
	    }
	    case 1: //	openInputStream(String)
	    {
	      return openInputStream((String)args[0]);
	    }
    }

    throw new Exception("method not found");
  }

  
  
  
  
  
  
// ------------------------------- Methods --------------------------------- //
  
  public Socket socketOpen(String url)
  {
    try
    {
      Socket socket = new Socket();
      socket.socket = ((SocketConnection)Connector.open("socket://" + url));
      jcc2.lib.stdlib.library.getSingleton().setLastError(null);
      return socket;
    }
    catch (Exception e)
    {
      jcc2.lib.stdlib.library.getSingleton().setLastError(e.toString());
    }
    return null;
  }

  public InputStream openInputStream(String url)
  {
    InputStream is = new InputStream();
    try {
      DataInputStream dis = new DataInputStream(getClass().getResourceAsStream(url));
      is.is = dis;
      jcc2.lib.stdlib.library.getSingleton().setLastError(null);
      return is;
    } catch (Exception e) {
      jcc2.lib.stdlib.library.getSingleton().setLastError(e.toString());
    }
    return null;
  }
}