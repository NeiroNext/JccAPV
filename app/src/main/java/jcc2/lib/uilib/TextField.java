package jcc2.lib.uilib;

import jcc2.common.ClassContainer;

/**
 *
 * @author note173@gmail.com
 */

import jcc2.common.MethodContainer;
import jcc2.common.Type;
import jcc2.lib.RTObject;

public class TextField extends RTObject
{
    static ClassContainer ctClass = null;
    static boolean bInit = false;

    public javax.microedition.lcdui.TextField field;

    public TextField ()
    {
    }

    public TextField (String label, String text, int maxlen, int constrains)
    {
        init (label, text, maxlen, constrains);
    }

    public void init (String label, String text, int maxlen, int constrains)
    {
        field = new javax.microedition.lcdui.TextField (label, text, maxlen, constrains);
    }

    public static ClassContainer getClassContainer ()
    {
        if (ctClass != null)
            return ctClass;

        ClassContainer container = new ClassContainer ("TextField");
        container.className = "jcc2/lib/uilib/TextField";
        ctClass = container;
        return ctClass;
    }

    public static void initClassContainer ()
    {
        if (bInit)
            return;
        bInit = true;
        ClassContainer container = getClassContainer ();
        Type[] args;
        MethodContainer method;
        int mid = 0;

        container.addStatic("ANY", new Integer(javax.microedition.lcdui.TextField.ANY), Type.TYPE_INT);
        container.addStatic("DECIMAL", new Integer(javax.microedition.lcdui.TextField.DECIMAL), Type.TYPE_INT);
        container.addStatic("EMAILADDR", new Integer(javax.microedition.lcdui.TextField.EMAILADDR), Type.TYPE_INT);
        container.addStatic("NON_PREDICTIVE", new Integer(javax.microedition.lcdui.TextField.NON_PREDICTIVE), Type.TYPE_INT);
        container.addStatic("NUMERIC", new Integer(javax.microedition.lcdui.TextField.NUMERIC), Type.TYPE_INT);
        container.addStatic("PASSWORD", new Integer(javax.microedition.lcdui.TextField.PASSWORD), Type.TYPE_INT);
        container.addStatic("PHONENUMBER", new Integer(javax.microedition.lcdui.TextField.PHONENUMBER), Type.TYPE_INT);
        container.addStatic("URL", new Integer(javax.microedition.lcdui.TextField.URL), Type.TYPE_INT);

        args = new Type[4];
        args[0] = Type.TYPE_STRING;
        args[1] = Type.TYPE_STRING;
        args[2] = Type.TYPE_INT;
        args[3] = Type.TYPE_INT;
        method = new MethodContainer ("<init>", Type.TYPE_VOID, args, null, mid++);
        container.addMethod(method);

        args = new Type[0];
        method = new MethodContainer ("getHeight", Type.TYPE_INT, args, null, mid++);
        container.addMethod(method);
    }

    public Object rtInvoke(int iMethod, Object[] args) throws Exception
    {
        switch (iMethod)
        {
            case 0: //<init>
            {
                init ((String)(args[0]), (String)(args[1]), ((int[])args[2])[0], ((int[])args[3])[0]);
                return Type.TYPE_VOID;
            }
            default:
                throw new Exception ("TextField[" + iMethod + "]");
        }
    }
}
