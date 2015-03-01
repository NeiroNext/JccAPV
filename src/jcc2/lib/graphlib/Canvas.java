package jcc2.lib.graphlib;

import jcc2.common.ClassContainer;

/**
 *
 * @author note173@gmail.com
 */

import jcc2.common.MethodContainer;
import jcc2.common.Type;
import jcc2.lib.RTObject;

public class Canvas extends RTObject
{
    static ClassContainer ctClass = null;
    static boolean bInit = false;

    public MyCanvas canvas;

    public Canvas ()
    {
        canvas = new MyCanvas (this);
    }

    public static ClassContainer getClassContainer ()
    {
        if (ctClass != null)
            return ctClass;

        ClassContainer container = new ClassContainer ("Canvas");
        container.className = "jcc2/lib/graphlib/Canvas";
        ctClass = container;
        return ctClass;
    }

    public static void initClassContainer ()
    {
        if (bInit)
            return;
        bInit = true;
        ClassContainer container = getClassContainer ();

        container.addStatic("DOWN", new Integer(javax.microedition.lcdui.Canvas.DOWN), Type.TYPE_INT);
        container.addStatic("FIRE", new Integer(javax.microedition.lcdui.Canvas.FIRE), Type.TYPE_INT);
        container.addStatic("GAME_A", new Integer(javax.microedition.lcdui.Canvas.GAME_A), Type.TYPE_INT);
        container.addStatic("GAME_B", new Integer(javax.microedition.lcdui.Canvas.GAME_B), Type.TYPE_INT);
        container.addStatic("GAME_B", new Integer(javax.microedition.lcdui.Canvas.GAME_C), Type.TYPE_INT);
        container.addStatic("GAME_D", new Integer(javax.microedition.lcdui.Canvas.GAME_D), Type.TYPE_INT);
        container.addStatic("KEY_NUM0", new Integer(javax.microedition.lcdui.Canvas.KEY_NUM0), Type.TYPE_INT);
        container.addStatic("KEY_NUM1", new Integer(javax.microedition.lcdui.Canvas.KEY_NUM1), Type.TYPE_INT);
        container.addStatic("KEY_NUM2", new Integer(javax.microedition.lcdui.Canvas.KEY_NUM2), Type.TYPE_INT);
        container.addStatic("KEY_NUM3", new Integer(javax.microedition.lcdui.Canvas.KEY_NUM3), Type.TYPE_INT);
        container.addStatic("KEY_NUM4", new Integer(javax.microedition.lcdui.Canvas.KEY_NUM4), Type.TYPE_INT);
        container.addStatic("KEY_NUM5", new Integer(javax.microedition.lcdui.Canvas.KEY_NUM5), Type.TYPE_INT);
        container.addStatic("KEY_NUM6", new Integer(javax.microedition.lcdui.Canvas.KEY_NUM6), Type.TYPE_INT);
        container.addStatic("KEY_NUM7", new Integer(javax.microedition.lcdui.Canvas.KEY_NUM7), Type.TYPE_INT);
        container.addStatic("KEY_NUM8", new Integer(javax.microedition.lcdui.Canvas.KEY_NUM8), Type.TYPE_INT);
        container.addStatic("KEY_NUM9", new Integer(javax.microedition.lcdui.Canvas.KEY_NUM9), Type.TYPE_INT);
        container.addStatic("KEY_POUND", new Integer(javax.microedition.lcdui.Canvas.KEY_POUND), Type.TYPE_INT);
        container.addStatic("KEY_STAR", new Integer(javax.microedition.lcdui.Canvas.KEY_STAR), Type.TYPE_INT);
        container.addStatic("LEFT", new Integer(javax.microedition.lcdui.Canvas.LEFT), Type.TYPE_INT);
        container.addStatic("RIGHT", new Integer(javax.microedition.lcdui.Canvas.RIGHT), Type.TYPE_INT);
        container.addStatic("UP", new Integer(javax.microedition.lcdui.Canvas.UP), Type.TYPE_INT);

        Type[] args;
        MethodContainer method;
        int mid = 0;

        args = new Type[0];
        method = new MethodContainer ("<init>", Type.TYPE_VOID, args, null, mid++);
        container.addMethod(method);

        args = new Type[0];
        method = new MethodContainer ("getGraphics", new Type(Graphics.getClassContainer(), 0), args, null, mid++);
        container.addMethod(method);

        args = new Type[0];
        method = new MethodContainer ("getHeight", Type.TYPE_INT, args, null, mid++);
        container.addMethod(method);

        args = new Type[0];
        method = new MethodContainer ("getWidth", Type.TYPE_INT, args, null, mid++);
        container.addMethod(method);

        args = new Type[1];
        args[0] = Type.TYPE_BOOL;
        method = new MethodContainer ("fullscreen", Type.TYPE_VOID, args, null, mid++);
        container.addMethod(method);

        args = new Type[0];
        method = new MethodContainer ("show", Type.TYPE_VOID, args, null, mid++);
        container.addMethod(method);

        args = new Type[0];
        method = new MethodContainer ("repaint", Type.TYPE_VOID, args, null, mid++);
        container.addMethod(method);

        args = new Type[1];
        args[0] = Type.TYPE_INT;
        method = new MethodContainer ("gameAction", Type.TYPE_INT, args, null, mid++);
        container.addMethod(method);
        
        args = new Type[0];
        method = new MethodContainer("getKeyStates", Type.TYPE_INT, args, null, mid++);
        container.addMethod(method);

        args = new Type[0];
        method = new MethodContainer("getKey", Type.TYPE_INT, args, null, mid++);
        container.addMethod(method);

        args = new Type[0];
        method = new MethodContainer("releaseKey", Type.TYPE_VOID, args, null, mid++);
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
            case 1: //getGraphics
            {
                return getGraphics();
            }
            case 2: //getHeight
            {
                int[] val = {getHeight()};
                return val;
            }
            case 3: //getWidth
            {
                int[] val = {getWidth()};
                return val;
            }
            case 4: //fullscreen
            {
                fullscreen(((int[])args[0])[0]==0?false:true);
                return Type.TYPE_VOID;
            }
            case 5: //show
            {
                show ();
                return Type.TYPE_VOID;
            }
            case 6: //repaint
            {
                repaint ();
                return Type.TYPE_VOID;
            }
            case 7: //gameAction
            {
                int[] v = {gameAction(((int[])args[0])[0])};
                return v;
            }
	        case 8: //	getKeyStates()
	        {
	            int[] ret = { getKeyStates() };
	            return ret;
	        }
	        case 9: //	getKey()
	        {
	        	int[] ret = { getKey() };
	        	return ret;
	        }
	        case 10: //	releaseKey()
	        {
	        	releaseKey();
	        	return Type.TYPE_VOID;
	        }
            default:
                throw new Exception ("Canvas[" + iMethod + "]");
        }
    }

    
    
    
    
// ------------------------ Methods ---------------------------- //
    
    public Graphics getGraphics ()
    {
        Graphics graphics = new Graphics ();
        graphics.graphics = canvas.getCanvasGraphics();
        return graphics;
    }

    public int getHeight ()
    {
        return canvas.getHeight();
    }

    public int getWidth ()
    {
        return canvas.getWidth();
    }

    public void fullscreen (boolean mode)
    {
        canvas.setFullScreenMode(mode);
    }

    public void show ()
    {
        jcc2.midlet.Midlet.midlet.display.setCurrent(canvas);
    }

    public void repaint ()
    {
        canvas.flush();
    }

    public int gameAction (int key)
    {    	
        return canvas.getGameAction(key);
    }
    
    public int getKeyStates() {
        return canvas.getKeyStates();
    }

    public int getKey() {
    	return canvas.KEY;
    }

    public void releaseKey() {
    	canvas.KEY = 0;
    }
    
}











// ---------------------- New Class -------------------------- //

class MyCanvas extends javax.microedition.lcdui.game.GameCanvas
{
    Canvas canvas;
    int KEY = 0;

    public MyCanvas (Canvas canvas)
    {
        super(false);
        this.canvas = canvas;
    }

    public javax.microedition.lcdui.Graphics getCanvasGraphics ()
    {
        return getGraphics ();
    }

    public void flush ()
    {
        flushGraphics ();
    }

    public void keyPressed (int key)
    {
    	KEY = key;
        try
        {
            int[] vkey = {key};
            Object[] args = {vkey, canvas};
            if (jcc2.lib.graphlib.library.getSingleton().iOnKeyPressed != -1)
                jcc2.lib.graphlib.library.getSingleton().callbackCaller.$callCallback(args,
                        jcc2.lib.graphlib.library.getSingleton().iOnKeyPressed);
        }
        catch (Exception e)
        {
            jcc2.lib.stdlib.library.getSingleton().setLastError(e.getMessage());
            e.printStackTrace();
        }
    }

    public void keyReleased (int key)
    {
    	KEY = 0;
        try
        {
            int[] vkey = {key};
            Object[] args = {vkey, canvas};
            if (jcc2.lib.graphlib.library.getSingleton().iOnKeyReleased != -1)
                jcc2.lib.graphlib.library.getSingleton().callbackCaller.$callCallback(args,
                        jcc2.lib.graphlib.library.getSingleton().iOnKeyReleased);
        }
        catch (Exception e)
        {
            jcc2.lib.stdlib.library.getSingleton().setLastError(e.getMessage());
            e.printStackTrace();
        }
    }
    
    public void keyRepeated(int key) {
      KEY = key;
    }
    
}
