package jcc2.lib.graphlib;

import jcc2.lib.stdlib.*;
import java.util.Enumeration;
import java.util.Hashtable;
import jcc2.common.ClassContainer;
import jcc2.common.MethodContainer;
import jcc2.common.Type;
import jcc2.common.JccException;
import jcc2.lib.Library;
import jcc2.lib.RTCallbackCaller;

/**
 *
 * @author note173@gmail.com
 */

public class library extends Library
{
    public static library singleton;
    static boolean bInit = false;

    Hashtable htClasses;
    Hashtable htMethods;

    RTCallbackCaller callbackCaller;
    int iOnKeyPressed;
    int iOnKeyReleased;

    public static library getSingleton ()
    {
        if (singleton == null)
            singleton = new library ();
        return singleton;
    }

    public static library getSingleton (RTCallbackCaller caller)
    {
        if (singleton == null)
            singleton = new library ();
        singleton.callbackCaller = caller;
        return singleton;
    }

    public library ()
    {
        init (false);
    }

    public void init(boolean compileTime)
    {
        if (compileTime)
        {
            htClasses = new Hashtable ();
            htMethods = new Hashtable ();

            int cid = 0;
            Image.initClassContainer();
            Graphics.initClassContainer();
            Canvas.initClassContainer();

            ClassContainer ctImage = Image.getClassContainer();
            ctImage.id = cid++;
            ctImage.libHost = this;
            ClassContainer ctGraphics = Graphics.getClassContainer();
            ctGraphics.id = cid++;
            ctGraphics.libHost = this;
            ClassContainer ctCanvas = Canvas.getClassContainer();
            ctCanvas.id = cid++;
            ctCanvas.libHost = this;

            htClasses.put("Image", ctImage);
            htClasses.put("Graphics", ctGraphics);
            htClasses.put("Canvas", ctCanvas);

            Type[] args;
            MethodContainer method;
            int mid = 0;

            args = new Type[1];
            args[0] = Type.TYPE_CALLBACK;
            method = new MethodContainer ("onKeyPressed", Type.TYPE_VOID, args, this, mid++);
            htMethods.put(method.spec, method);

            args = new Type[1];
            args[0] = Type.TYPE_CALLBACK;
            method = new MethodContainer ("onKeyReleased", Type.TYPE_VOID, args, this, mid++);
            htMethods.put(method.spec, method);
        }
        else
        {
            singleton = this;
            iOnKeyPressed = -1;
            iOnKeyReleased = -1;
        }
    }

    public String getDesc ()
    {
        return "jcc2/lib/graphlib/library";
    }

    public String getName ()
    {
        return "graphlib";
    }

    public ClassContainer ctGetClass(String name)
    {
        return (ClassContainer)htClasses.get(name);
    }

    public MethodContainer ctGetMethod(String desc)
    {
        return (MethodContainer)htMethods.get(desc);
    }

    public Object rtNewObject (int id) throws Exception
    {
        switch (id)
        {
            case 0:
                return new Image ();
            case 1:
                return new Graphics ();
            case 2:
                return new Canvas ();
            default:
                throw new Exception ("object not found");
        }
    }

    public Object rtNewArray (int id, int len) throws Exception
    {
        switch (id)
        {
            case 0:
                return new Image[len];
            case 1:
                return new Graphics[len];
            case 2:
                return new Canvas[len];
            default:
                throw new Exception ("object not found");
        }
    }

    public Object rtInvokeMethod(int id, Object[] args, RTCallbackCaller caller) throws Exception
    {
        callbackCaller = caller;
        switch (id)
        {
            case 0: //onKeyPressed
            {
                onKeyPressed(((int[])args[0])[0]);
                return Type.TYPE_VOID;
            }
            case 1: //onKeyReleased
            {
                onKeyReleased(((int[])args[0])[0]);
                return Type.TYPE_VOID;
            }
            default:
                throw new Exception ("method not found");
        }
    }

    public Enumeration ctGetAllClasses()
    {
        return htClasses.elements();
    }

    public Enumeration ctGetAllMethods()
    {
        return htMethods.elements();
    }

    public void onKeyPressed (int iMethod)
    {
        iOnKeyPressed = iMethod;
    }

    public void onKeyReleased (int iMethod)
    {
        iOnKeyReleased = iMethod;
    }
}
