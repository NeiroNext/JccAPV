package jcc2.lib.filelib;

import jcc2.common.ClassContainer;
import jcc2.common.MethodContainer;
import jcc2.common.Type;
import jcc2.io.fs.FilePtr;
import jcc2.lib.RTObject;
import jcc2.lib.iolib.InputStream;
import jcc2.lib.iolib.OutputStream;

/**
 * 
 * @author note173@gmail.com
 *
 */

public class File extends RTObject
{
  static ClassContainer ctClass = null;
  static boolean bInit = false;
  FilePtr file;

  public static ClassContainer getClassContainer()
  {
    if (ctClass != null)
      return ctClass;
    ClassContainer container = new ClassContainer("File");
    container.className = "jcc2/lib/filelib/File";
    ctClass = container;
    return ctClass;
  }

  
  
  
  public static void initClassContainer()
  {
    if (bInit)
      return;
    bInit = true;

    ClassContainer container = getClassContainer();

    container.addStatic("READ", new Integer(1), Type.TYPE_INT);
    container.addStatic("WRITE", new Integer(2), Type.TYPE_INT);

    int mid = 0;

    Type[] args = new Type[0];
    MethodContainer method = new MethodContainer("openInputStream", new Type(InputStream.getClassContainer(), 0), args, null, mid++);
    container.addMethod(method);

    args = new Type[0];
    method = new MethodContainer("openOutputStream", new Type(OutputStream.getClassContainer(), 0), args, null, mid++);
    container.addMethod(method);

    args = new Type[0];
    method = new MethodContainer("close", Type.TYPE_VOID, args, null, mid++);
    container.addMethod(method);
  }

  
  
  public Object rtInvoke(int iMethod, Object[] args) throws Exception
  {
    switch (iMethod)
    {
	    case 0: //	openInputStream()
	    {
	      return openInputStream();
	    }
	    case 1: // openOutputStream()
	    {
	      return openOutputStream();
	    }
	    case 2: //	close()
	    {
	      close();
	      return Type.TYPE_VOID;
	    }
    }

    throw new Exception("File[" + iMethod + "]");
  }

  
  
  
  
  
// ----------------------- Methods ----------------------- //
  
  public InputStream openInputStream(){
    InputStream is = new InputStream();
    try {
      is.is = file.GetDataInputStream(); 
    } catch (Exception localException) {
    	return null;
    }
    return is;
  }

  public OutputStream openOutputStream(){
    OutputStream os = new OutputStream();
    try {
      os.os = file.GetDataOutputStream();
    } catch (Exception localException) {
    	return null;
    }
    return os;
  }

  public void close(){
    try {
      file.Close();
    }
    catch (Exception localException){}
  }
  
}