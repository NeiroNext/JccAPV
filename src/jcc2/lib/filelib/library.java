package jcc2.lib.filelib;

import java.util.Enumeration;
import java.util.Hashtable;
import jcc2.common.ClassContainer;
import jcc2.common.MethodContainer;
import jcc2.common.Type;
import jcc2.io.fs.FilePtr;
import jcc2.io.fs.FileSystem;
import jcc2.lib.Library;
import jcc2.lib.RTCallbackCaller;
import jcc2.lib.iolib.InputStream;


/**
 * 
 * @author note173@gmail.com
 *
 */
/**
 * 
 * @fixed NeiroNext
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

  public library()
  {
    init(false);
  }

  
  public String getDesc()
  {
    return "jcc2/lib/filelib/library";
  }

  public String getName()
  {
    return "filelib";
  }

  public ClassContainer ctGetClass(String name)
  {
    return (ClassContainer)htClasses.get(name);
  }

  public MethodContainer ctGetMethod(String desc)
  {
    return (MethodContainer)htMethods.get(desc);
  }

  public Object rtNewObject(int id) throws Exception
  {
    throw new Exception("object not found");
  }

  public Object rtNewArray(int id, int len) throws Exception
  {
    switch (id)
    {
    case 0:
      return new File[len];
    }

    throw new Exception("object not found");
  }
  
  public Enumeration ctGetAllClasses()
  {
    return htClasses.elements();
  }

  public Enumeration ctGetAllMethods()
  {
    return htMethods.elements();
  }
  
  
  
  
  public void init(boolean compileTime)
  {
    if (compileTime)
    {
      htClasses = new Hashtable();
      htMethods = new Hashtable();

      ClassContainer ct;
      int cid = 0;
      
      File.initClassContainer();

      ct = File.getClassContainer();
      ct.id = (cid++);
      ct.libHost = this;
      htClasses.put(ct.name, ct);
      

      Type[] args;
      MethodContainer method;
      int mid = 0;

      args = new Type[2];
      args[0] = Type.TYPE_STRING;
      args[1] = Type.TYPE_INT;
      method = new MethodContainer("fileOpen", new Type(File.getClassContainer(), 0), args, this, mid++);
      htMethods.put(method.spec, method);

      args = new Type[1];
      args[0] = Type.TYPE_STRING;
      method = new MethodContainer("fileSize", Type.TYPE_INT, args, this, mid++);
      htMethods.put(method.spec, method);

      args = new Type[1];
      args[0] = Type.TYPE_STRING;
      method = new MethodContainer("listDir", Type.TYPE_ASTRING, args, this, mid++);
      htMethods.put(method.spec, method);

      args = new Type[1];
      args[0] = Type.TYPE_STRING;
      method = new MethodContainer("fileExists", Type.TYPE_BOOL, args, this, mid++);
      htMethods.put(method.spec, method);

      args = new Type[1];
      args[0] = Type.TYPE_STRING;
      method = new MethodContainer("fileOpenInputStream", new Type(InputStream.getClassContainer(), 0), args, this, mid++);
      htMethods.put(method.spec, method);
    }
    else
    {
      singleton = this;
    }
  }

  
  
  
 

  public Object rtInvokeMethod(int id, Object[] args, RTCallbackCaller caller)
    throws Exception
  {
    switch (id)
    {
	    case 0: //	fileOpen(String, int)
	    {
	      return fileOpen((String)args[0], ((int[])args[1])[0]);
	    }
	    case 1: //	fileSize(String)
	    {
	      int[] v = { fileSize((String)args[0]) };
	      return v;
	    }
	    case 2: //	listDir(String)
	    {
	      Object[] v = { listDir((String)args[0]) };
	      return v;
	    }
	    case 3: //	fileExist(String)
	    {
	      int[] ret = new int[1];
	      if (fileExists((String)args[0]))
	        ret[0] = 1;
	      else
	        ret[0] = 0;
	      return ret;
	    }
	    case 4: //	fileOpenInputStream()
	    {
	      return fileOpenInputStream((String)args[0]);
	    }
    }

    throw new Exception("method not found");
  }


  
  
  
  
  
// ----------------------------- Methods --------------------------- //

  public File fileOpen(String path, int mode) {
    path = path.startsWith("file:///") ? path.substring(7) : path;
    try
    {
      File file = new File();
      file.file = FileSystem.GetInstance().Open(path, mode);
      jcc2.lib.stdlib.library.getSingleton().setLastError(null);
      return file;
    }
    catch (Exception e)
    {
      jcc2.lib.stdlib.library.getSingleton().setLastError(e.getMessage());
    }return null;
  }

  public int fileSize(String path) {
    path = path.startsWith("file:///") ? path.substring(7) : path;
    try
    {
      jcc2.lib.stdlib.library.getSingleton().setLastError(null);
      return FileSystem.GetInstance().Size(path);
    }
    catch (Exception e)
    {
      jcc2.lib.stdlib.library.getSingleton().setLastError(e.getMessage());
    }return -1;
  }

  public String[] listDir(String path) {
    path = path.startsWith("file:///") ? path.substring(7) : path;
    try
    {
      jcc2.lib.stdlib.library.getSingleton().setLastError(null);
      return FileSystem.GetInstance().List(path);
    }
    catch (Exception e)
    {
      jcc2.lib.stdlib.library.getSingleton().setLastError(e.getMessage());
    }return null;
  }

  public boolean fileExists(String path) {
    path = path.startsWith("file:///") ? path.substring(7) : path;
    try
    {
      jcc2.lib.stdlib.library.getSingleton().setLastError(null);
      return FileSystem.GetInstance().Exists(path);
    }
    catch (Exception e)
    {
      jcc2.lib.stdlib.library.getSingleton().setLastError(e.toString());
    }return false;
  }

  public InputStream fileOpenInputStream(String path) {
    path = path.startsWith("file:///") ? path.substring(7) : path;
    try {
      InputStream is = new InputStream();
      FilePtr fs = FileSystem.GetInstance().Open(path, 1);
      is.is = fs.GetDataInputStream();
      jcc2.lib.stdlib.library.getSingleton().setLastError(null);
      return is;
    } catch (Exception e) {
      jcc2.lib.stdlib.library.getSingleton().setLastError(e.toString());
    }return null;
  }
  
}