package jcc2.lib.controllib;

import jcc2.common.ClassContainer;
import jcc2.common.MethodContainer;
import jcc2.common.Type;
import jcc2.lib.RTObject;
import jcc2.lib.graphlib.Canvas;
import jcc2.midlet.Midlet;

/***
 * 
 * @author NeiroNext
 *
 */




public class VideoControl extends RTObject
{
  static ClassContainer ctClass = null;
  static boolean bInit = false;
  public javax.microedition.media.control.VideoControl vc;

  public static ClassContainer getClassContainer()
  {
    if (ctClass != null)
      return ctClass;
    ClassContainer container = new ClassContainer("VideoControl");
    container.className = "jcc2/lib/controllib/VideoControl";
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
    args[0] = new Type(Canvas.getClassContainer(), 0);
    method = new MethodContainer("initDisplay", Type.TYPE_VOID, args, null, mid++);
    container.addMethod(method);

    args = new Type[1];
    args[0] = Type.TYPE_BOOL;
    method = new MethodContainer("show", Type.TYPE_VOID, args, null, mid++);
    container.addMethod(method);

    args = new Type[0];
    method = new MethodContainer("getDisplayWidth", Type.TYPE_INT, args, null, mid++);
    container.addMethod(method);

    args = new Type[0];
    method = new MethodContainer("getDisplayHeight", Type.TYPE_INT, args, null, mid++);
    container.addMethod(method);

    args = new Type[0];
    method = new MethodContainer("getDisplayX", Type.TYPE_INT, args, null, mid++);
    container.addMethod(method);

    args = new Type[0];
    method = new MethodContainer("getDisplayY", Type.TYPE_INT, args, null, mid++);
    container.addMethod(method);

    args = new Type[0];
    method = new MethodContainer("getSourceWidth", Type.TYPE_INT, args, null, mid++);
    container.addMethod(method);

    args = new Type[0];
    method = new MethodContainer("getSourceHeight", Type.TYPE_INT, args, null, mid++);
    container.addMethod(method);

    args = new Type[2];
    args[0] = Type.TYPE_INT;
    args[1] = Type.TYPE_INT;
    method = new MethodContainer("setDisplayPos", Type.TYPE_VOID, args, null, mid++);
    container.addMethod(method);

    args = new Type[2];
    args[0] = Type.TYPE_INT;
    args[1] = Type.TYPE_INT;
    method = new MethodContainer("setDisplaySize", Type.TYPE_VOID, args, null, mid++);
    container.addMethod(method);

    args = new Type[1];
    args[0] = Type.TYPE_BOOL;
    method = new MethodContainer("setFullScreen", Type.TYPE_VOID, args, null, mid++);
    container.addMethod(method);

    args = new Type[1];
    args[0] = Type.TYPE_STRING;
    method = new MethodContainer("getSnapshot", Type.TYPE_ABYTE, args, null, mid++);
    container.addMethod(method);

    args = new Type[0];
    method = new MethodContainer("getSnapshot", Type.TYPE_ABYTE, args, null, mid++);
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
	    case 1: //initDisplay(Canvas)
	    {
	      initDisplay((Canvas)args[0]);
	      return Type.TYPE_VOID;
	    }
	    case 2: //show(bool)
	    {
	      if (((int[])args[0])[0] == 1)
	        show(true);
	      else
	        show(false);
	      return Type.TYPE_VOID;
	    }
	    case 3: //getDisplayWidth()
	    {
	      int[] ret = { getDisplayWidth() };
	      return ret;
	    }
	    case 4: //getDisplayHeight()
	    {
	      int[] ret = { getDisplayHeight() };
	      return ret;
	    }
	    case 5: //getDisplayX()
	    {
	      int[] ret = { getDisplayX() };
	      return ret;
	    }
	    case 6: //getDisplayY()
	    {
	      int[] ret = { getDisplayY() };
	      return ret;
	    }
	    case 7: //getSourceWidth()
	    {
	      int[] ret = { getSourceWidth() };
	      return ret;
	    }
	    case 8: //getSourceHeight()
	    {
	      int[] ret = { getSourceHeight() };
	      return ret;
	    }
	    case 9: //setDisplayPos(int, int)
	    {
	      setDisplayPos(((int[])args[0])[0], ((int[])args[1])[0]);
	      return Type.TYPE_VOID;
	    }
	    case 10: //setDisplaySize(int, int)
	    {
	      setDisplaySize(((int[])args[0])[0], ((int[])args[1])[0]);
	      return Type.TYPE_VOID;
	    }
	    case 11: //setFullScreen(bool)
	    {
	      if (((int[])args[0])[0] == 1)
	        setFullScreen(true);
	      else
	        setFullScreen(false);
	      return Type.TYPE_VOID;
	    }
	    case 12: //getSnapshot(string)
	    {
	      Object[] ret = { getSnapshot((String)args[0]) };
	      return ret;
	    }
	    case 13: //getSnapshot()
	    {
	      Object[] ret = { getSnapshot() };
	      return ret;
	    }
    }

    throw new Exception("VideoControl[" + iMethod + "]");
  }

  
  
  
  
  
  
  
  
// ----------------------- Methods --------------------- //

  
  public void initDisplay(Canvas c)
  {
    vc.initDisplayMode(vc.USE_DIRECT_VIDEO, c.canvas);
  }

  public void show(boolean bb) {
    vc.setVisible(bb);
  }

  public int getDisplayWidth() {
    return vc.getDisplayWidth();
  }

  public int getDisplayHeight() {
    return vc.getDisplayHeight();
  }

  public int getDisplayX() {
    return vc.getDisplayX();
  }

  public int getDisplayY() {
    return vc.getDisplayY();
  }

  public int getSourceWidth() {
    return vc.getSourceWidth();
  }

  public int getSourceHeight() {
    return vc.getSourceHeight();
  }

  public void setDisplayPos(int x, int y) {
    vc.setDisplayLocation(x, y);
  }

  public void setDisplaySize(int width, int height) {
    try {
      vc.setDisplaySize(width, height);
    } catch (Exception e) {
      e.printStackTrace();
      Midlet.midlet.f.append("\nVideoControl method setDisplaySize: " + e.getMessage());
    }
  }

  public void setFullScreen(boolean b) {
    try {
      vc.setDisplayFullScreen(b);
    } catch (Exception e) {
      e.printStackTrace();
      Midlet.midlet.f.append("\nVideoControl method setFullScreen: " + e.getMessage());
    }
  }

  public byte[] getSnapshot(String encode) {
    try {
      return vc.getSnapshot(encode);
    } catch (Exception e) {
      e.printStackTrace();
      Midlet.midlet.f.append("\nVideoControl method getSnapshot: " + e.getMessage());
    }return null;
  }

  public byte[] getSnapshot()
  {
    return getSnapshot(null);
  }
  
}