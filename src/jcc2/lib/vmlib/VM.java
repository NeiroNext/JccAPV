package jcc2.lib.vmlib;

import java.io.IOException;

import jcc2.common.ClassContainer;
import jcc2.common.JccException;
import jcc2.common.MethodContainer;
import jcc2.common.Type;
import jcc2.lib.RTObject;
import jcc2.lib.iolib.InputStream;
import jcc2.runtime.JccRuntime;

/***
 * 
 * @author NeiroNext
 *
 */




public class VM extends RTObject
{
  static ClassContainer ctClass = null;
  static boolean bInit = false;
  JccRuntime jr;

  public static ClassContainer getClassContainer()
  {
    if (ctClass != null)
      return ctClass;
    ClassContainer container = new ClassContainer("VM");
    container.className = "jcc2/lib/controllib/VM";
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
    args[0] = new Type(jcc2.lib.iolib.InputStream.getClassContainer(), 0);
    method = new MethodContainer("setCode", Type.TYPE_VOID, args, null, mid++);
    container.addMethod(method);
    
    args = new Type[1];
    args[0] = Type.TYPE_ABYTE;
    method = new MethodContainer("setCode", Type.TYPE_VOID, args, null, mid++);
    container.addMethod(method);
    
    args = new Type[1];
    args[0] = Type.TYPE_STRING;
    method = new MethodContainer("setCode", Type.TYPE_VOID, args, null, mid++);
    container.addMethod(method);
    
    args = new Type[0];
    method = new MethodContainer("start", Type.TYPE_VOID, args, null, mid++);
    container.addMethod(method);
    
    args = new Type[1];
    args[0] = Type.TYPE_STRING;
    method = new MethodContainer("start", Type.TYPE_VOID, args, null, mid++);
    container.addMethod(method);
    
  }

  
  
  
  
  public Object rtInvoke(int iMethod, Object[] args) throws Exception
  {
    switch (iMethod)
    {
	    case 0: //<init>
	    {
	      return Type.TYPE_VOID;
	    }
	    case 1: //setCode(InputStream)
	    {
	      setCode((jcc2.lib.iolib.InputStream)args[0]);
	      return Type.TYPE_VOID;
	    }
	    case 2: //setCode(byte[])
	    {
	      setCode((byte[])((Object[])args[0])[0]);
	      return Type.TYPE_VOID;
	    }
	    case 3: //setCode(string)
	    {
	      setCode((String)args[0]);
	      return Type.TYPE_VOID;
	    }
	    case 4: //start()
	    {
	      start();
	      return Type.TYPE_VOID;
	    }
	    case 5: //start(string)
	    {
	      start((String)args[0]);
	      return Type.TYPE_VOID;
	    }
	    
	}

    throw new Exception("RecordControl[" + iMethod + "]");
  }

  
  
  
  
  
  
// --------------------------- Methods --------------------------- //
  
  public VM(){}
  
  public void setCode(jcc2.lib.iolib.InputStream is){
	  try {
		jr = new JccRuntime(is.readByteArray());
	  } catch (Exception e) {
		e.printStackTrace();
	  }
  }
  
  public void setCode(byte[] bytecode){
	  try {
		jr = new JccRuntime(bytecode);
	  } catch (Exception e) {
		e.printStackTrace();
	  }
  }
  
  public void setCode(String url){
	  try {
		jcc2.lib.iolib.InputStream is = jcc2.lib.iolib.library.singleton.openInputStream(url);
		jr = new JccRuntime(is.readByteArray());	  } catch (Exception e) {
		e.printStackTrace();
	  }
  }
  
  public void start(){
	  try {
		jr.startApp("main()V");
	  } catch (JccException e) {
		e.printStackTrace();
	  }
  }
  
  public void start(String name){
	  try {
		jr.startApp(name);
	  } catch (JccException e) {
		e.printStackTrace();
	  }
  }
  
}