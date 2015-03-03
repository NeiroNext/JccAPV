package jcc2.lib.controllib;

import jcc2.common.ClassContainer;
import jcc2.common.MethodContainer;
import jcc2.common.Type;
import jcc2.lib.RTObject;


/***
 * 
 * @author NeiroNext
 *
 */




public class VolumeControl extends RTObject
{
  static ClassContainer ctClass = null;
  static boolean bInit = false;
  public javax.microedition.media.control.VolumeControl vc;

  public static ClassContainer getClassContainer()
  {
    if (ctClass != null)
      return ctClass;
    ClassContainer container = new ClassContainer("VolumeControl");
    container.className = "jcc2/lib/controllib/VolumeControl";
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
    args[0] = Type.TYPE_INT;
    method = new MethodContainer("setMute", Type.TYPE_VOID, args, null, mid++);
    container.addMethod(method);

    args = new Type[0];
    method = new MethodContainer("isMuted", Type.TYPE_BOOL, args, null, mid++);
    container.addMethod(method);

    args = new Type[1];
    args[0] = Type.TYPE_INT;
    method = new MethodContainer("setLevel", Type.TYPE_VOID, args, null, mid++);
    container.addMethod(method);

    args = new Type[0];
    method = new MethodContainer("getLevel", Type.TYPE_INT, args, null, mid++);
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
	    case 1: //setMute(bool)
	    {
	      int arg = ((int[])args[0])[0];
	      if (arg == 1)
	        setMute(true);
	      else
	        setMute(false);
	      return Type.TYPE_VOID;
	    }
	    case 2: //isMute()
	    {
	      int[] ret = new int[1];
	      if (isMuted())
	        ret[0] = 1;
	      else
	        ret[0] = 0;
	      return ret;
	    }
	    case 3: //setLevel(int)
	    {
	      setLevel(((int[])args[0])[0]);
	      return Type.TYPE_VOID;
	    }
	    case 4: //getLevel()
	    {
	      int[] ret = { getLevel() };
	      return ret;
	    }
    }

    throw new Exception("VideoControl[" + iMethod + "]");
  }

  
  
  
  
  
  
  
  
// ---------------------------- Methods ------------------------------ //
  
  public void setMute(boolean arg){
    vc.setMute(arg);
  }

  public boolean isMuted() {
    return vc.isMuted();
  }

  public void setLevel(int lev) {
    vc.setLevel(lev);
  }

  public int getLevel() {
    return vc.getLevel();
  }
 
}