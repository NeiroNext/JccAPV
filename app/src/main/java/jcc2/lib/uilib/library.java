package jcc2.lib.uilib;

import java.util.Enumeration;
import java.util.Hashtable;
import javax.microedition.lcdui.CommandListener;
import javax.microedition.lcdui.Displayable;
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

public class library extends Library implements CommandListener
{
    public static library singleton;
    static boolean bInit = false;

    Hashtable htClasses;
    Hashtable htMethods;

    RTCallbackCaller callbackCaller;
    int iOnMenuAction;
    boolean bContinue;
    Object vArg;
    javax.microedition.lcdui.Command CMD_OK;
    javax.microedition.lcdui.Command CMD_CANCEL;

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

            TextField.initClassContainer();

            ClassContainer ctTextField = TextField.getClassContainer();
            ctTextField.id = cid++;
            ctTextField.libHost = this;

            htClasses.put("TextField", ctTextField);



            Type[] args;
            MethodContainer method;
            int mid = 0;

            args = new Type[1];
            args[0] = Type.TYPE_CALLBACK;
            method = new MethodContainer ("onMenuAction", Type.TYPE_VOID, args, this, mid++);
            htMethods.put(method.spec, method);

            args = new Type[4];
            args[0] = Type.TYPE_STRING;
            args[1] = Type.TYPE_STRING;
            args[2] = Type.TYPE_STRING;
            args[3] = Type.TYPE_ASTRING;
            method = new MethodContainer ("choiceform", Type.TYPE_INT, args, this, mid++);
            htMethods.put(method.spec, method);

            args = new Type[4];
            args[0] = Type.TYPE_STRING;
            args[1] = Type.TYPE_STRING;
            args[2] = Type.TYPE_STRING;
            args[3] = Type.TYPE_ASTRING;
            method = new MethodContainer ("selectform", Type.TYPE_INT, args, this, mid++);
            htMethods.put(method.spec, method);

            args = new Type[4];
            args[0] = Type.TYPE_STRING;
            args[1] = Type.TYPE_STRING;
            args[2] = Type.TYPE_STRING;
            args[3] = Type.TYPE_ASTRING;
            method = new MethodContainer ("mulchoiceform", Type.TYPE_ABOOL, args, this, mid++);
            htMethods.put(method.spec, method);

            args = new Type[6];
            args[0] = Type.TYPE_STRING;
            args[1] = Type.TYPE_STRING;
            args[2] = Type.TYPE_STRING;
            args[3] = Type.TYPE_STRING;
            args[4] = Type.TYPE_INT;
            args[5] = Type.TYPE_INT;
            method = new MethodContainer ("editform", Type.TYPE_STRING, args, this, mid++);
            htMethods.put(method.spec, method);

            args = new Type[4];
            args[0] = Type.TYPE_STRING;
            args[1] = Type.TYPE_STRING;
            args[2] = Type.TYPE_STRING;
            args[3] = Type.TYPE_STRING;
            method = new MethodContainer ("messagebox", Type.TYPE_INT, args, this, mid++);
            htMethods.put(method.spec, method);
        }
        else
        {
            singleton = this;
            iOnMenuAction = -1;
        }
    }

    public String getDesc ()
    {
        return "jcc2/lib/uilib/library";
    }

    public String getName ()
    {
        return "uilib";
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
            case 0: //TextField
                return new TextField ();
            default:
                throw new Exception ("object not found");
        }
    }

    public Object rtNewArray (int id, int len) throws Exception
    {
        switch (id)
        {
            case 0: //TextField
                return new TextField[len];
            default:
                throw new Exception ("object not found");
        }
    }

    public Object rtInvokeMethod(int id, Object[] args, RTCallbackCaller caller) throws Exception
    {
        callbackCaller = caller;
        switch (id)
        {
            case 0: //onMenuAction
            {
                onMenuAction(((int[])args[0])[0]);
                return Type.TYPE_VOID;
            }
            case 1: //choiceform
            {
                int[] v = {choiceform((String)args[0], (String)args[1], (String)args[2], (String[])(((Object[])args[3])[0]))};
                return v;
            }
            case 2: //selectform
            {
                int[] v = {selectform((String)args[0], (String)args[1], (String)args[2], (String[])(((Object[])args[3])[0]))};
                return v;
            }
            case 3: //mulchoiceform
            {
                Object[] arr = {mulchoiceform((String)args[0], (String)args[1], (String)args[2], (String[])(((Object[])args[3])[0]))};
                return arr;
            }
            case 4: //editform
            {
                return editform ((String)args[0], (String)args[1], (String)args[2],
                        (String)args[3], ((int[])args[4])[0], ((int[])args[5])[0]);
            }
            case 5: //messagebox
            {
                int[] v = {messagebox((String)args[0], (String)args[1], (String)args[2], (String)args[3])};
                return v;
            }
            default:
                throw new Exception ("uilib[" + id + "] method not found");
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

    public void commandAction (javax.microedition.lcdui.Command c, Displayable d)
    {
        if (d instanceof javax.microedition.lcdui.List)
        {
            javax.microedition.lcdui.List list = (javax.microedition.lcdui.List)d;
            int type = ((int[])vArg)[0];
            if (c == CMD_OK)
            {
                if (type == javax.microedition.lcdui.List.EXCLUSIVE ||
                        type == javax.microedition.lcdui.List.IMPLICIT)
                {
                    ((int[])vArg)[0] = list.getSelectedIndex();
                    bContinue = true;
                }
                else if (type == javax.microedition.lcdui.List.MULTIPLE)
                {
                    vArg = new byte[list.size()];
                    boolean[] vSel = new boolean[list.size()];
                    list.getSelectedFlags(vSel);
                    for (int i = 0; i < vSel.length; i++)
                        ((byte[])vArg)[i] = (byte)(vSel[i]?1:0);
                    bContinue = true;
                }
            }
            else if (c == CMD_CANCEL)
            {
                if (type == javax.microedition.lcdui.List.EXCLUSIVE ||
                        type == javax.microedition.lcdui.List.IMPLICIT)
                {
                    ((int[])vArg)[0] = -1;
                    bContinue = true;
                }
                else if (type == javax.microedition.lcdui.List.MULTIPLE)
                {
                    vArg = null;
                    bContinue = true;
                }
            }
            else if (c == javax.microedition.lcdui.List.SELECT_COMMAND)
            {
                ((int[])vArg)[0] = list.getSelectedIndex();
                bContinue = true;
            }
        }
        else if (d instanceof javax.microedition.lcdui.TextBox)
        {
            javax.microedition.lcdui.TextBox textbox = (javax.microedition.lcdui.TextBox)d;
            if (c == CMD_OK)
            {
                vArg = textbox.getString();
                bContinue = true;
            }
            else if (c == CMD_CANCEL)
            {
                vArg = null;
                bContinue = true;
            }
        }
        else if (d instanceof javax.microedition.lcdui.Alert)
        {
            if (c == CMD_OK)
            {
                vArg = new int[1];
                ((int[])vArg)[0] = 1;
                bContinue = true;
            }
            else if (c == CMD_CANCEL)
            {
                vArg = new int[1];
                ((int[])vArg)[0] = 0;
                bContinue = true;
            }
            else if (c == javax.microedition.lcdui.Alert.DISMISS_COMMAND)
            {
                vArg = new int[1];
                ((int[])vArg)[0] = 0;
                bContinue = true;
            }
        }
    }

    public void onMenuAction (int iMethod)
    {
        iOnMenuAction = iMethod;
    }

    public int choiceform (String sTitle, String sOk, String sCancel, String[] vElements)
    {
        javax.microedition.lcdui.List list = new javax.microedition.lcdui.List(sTitle,
                javax.microedition.lcdui.List.EXCLUSIVE, vElements, null);
        Displayable prev = jcc2.application.Main.singleton.display.getCurrent();
        CMD_OK = new javax.microedition.lcdui.Command (sOk, javax.microedition.lcdui.Command.OK, 1);
        CMD_CANCEL = new javax.microedition.lcdui.Command (sCancel, javax.microedition.lcdui.Command.CANCEL, 1);
        list.addCommand(CMD_OK);
        list.addCommand(CMD_CANCEL);
        list.setCommandListener(this);
        bContinue = false;
        vArg = new int[1];
        ((int[])vArg)[0] = javax.microedition.lcdui.List.EXCLUSIVE;
        jcc2.application.Main.singleton.display.setCurrent(list);
        while (!bContinue)
            Thread.yield();
        jcc2.application.Main.singleton.display.setCurrent(prev);
        return ((int[])vArg)[0];
    }

    public int selectform (String sTitle, String sOk, String sCancel, String[] vElements)
    {
        javax.microedition.lcdui.List list = new javax.microedition.lcdui.List(sTitle,
                javax.microedition.lcdui.List.IMPLICIT, vElements, null);
        Displayable prev = jcc2.application.Main.singleton.display.getCurrent();
        CMD_OK = new javax.microedition.lcdui.Command (sOk, javax.microedition.lcdui.Command.OK, 1);
        CMD_CANCEL = new javax.microedition.lcdui.Command (sCancel, javax.microedition.lcdui.Command.CANCEL, 1);
        list.addCommand(CMD_OK);
        list.addCommand(CMD_CANCEL);
        list.setCommandListener(this);
        bContinue = false;
        vArg = new int[1];
        ((int[])vArg)[0] = javax.microedition.lcdui.List.IMPLICIT;
        jcc2.application.Main.singleton.display.setCurrent(list);
        while (!bContinue)
            Thread.yield();
        jcc2.application.Main.singleton.display.setCurrent(prev);
        return ((int[])vArg)[0];
    }

    public byte[] mulchoiceform (String sTitle, String sOk, String sCancel, String[] vElements)
    {
        javax.microedition.lcdui.List list = new javax.microedition.lcdui.List(sTitle,
                javax.microedition.lcdui.List.MULTIPLE, vElements, null);
        Displayable prev = jcc2.application.Main.singleton.display.getCurrent();
        CMD_OK = new javax.microedition.lcdui.Command (sOk, javax.microedition.lcdui.Command.OK, 1);
        CMD_CANCEL = new javax.microedition.lcdui.Command (sCancel, javax.microedition.lcdui.Command.CANCEL, 1);
        list.addCommand(CMD_OK);
        list.addCommand(CMD_CANCEL);
        list.setCommandListener(this);
        bContinue = false;
        vArg = new int[1];
        ((int[])vArg)[0] = javax.microedition.lcdui.List.MULTIPLE;
        jcc2.application.Main.singleton.display.setCurrent(list);
        while (!bContinue)
            Thread.yield();
        jcc2.application.Main.singleton.display.setCurrent(prev);
        return (byte[])vArg;
    }

    public String editform (String sTitle, String sOk, String sCancel, String sText, int maxlen,  int mode)
    {
        javax.microedition.lcdui.TextBox textbox = new javax.microedition.lcdui.TextBox (sTitle, sText, maxlen, mode);
        Displayable prev = jcc2.application.Main.singleton.display.getCurrent();
        CMD_OK = new javax.microedition.lcdui.Command (sOk, javax.microedition.lcdui.Command.OK, 1);
        CMD_CANCEL = new javax.microedition.lcdui.Command (sCancel, javax.microedition.lcdui.Command.CANCEL, 1);
        textbox.addCommand(CMD_OK);
        textbox.addCommand(CMD_CANCEL);
        textbox.setCommandListener(this);
        bContinue = false;
        jcc2.application.Main.singleton.display.setCurrent(textbox);
        while (!bContinue)
            Thread.yield();
        jcc2.application.Main.singleton.display.setCurrent(prev);
        return (String)vArg;
    }

    public int messagebox (String sTitle, String sOk, String sCancel, String sText)
    {
        javax.microedition.lcdui.Alert alert = new javax.microedition.lcdui.Alert (sTitle, sText,
                null, javax.microedition.lcdui.AlertType.INFO);
        alert.setTimeout(javax.microedition.lcdui.Alert.FOREVER);
        CMD_OK = new javax.microedition.lcdui.Command (sOk, javax.microedition.lcdui.Command.OK, 1);
        CMD_CANCEL = new javax.microedition.lcdui.Command (sCancel, javax.microedition.lcdui.Command.CANCEL, 1);
        alert.addCommand(CMD_OK);
        alert.addCommand(CMD_CANCEL);
        alert.setCommandListener(this);
        Displayable prev = jcc2.application.Main.singleton.display.getCurrent();
        jcc2.application.Main.singleton.display.setCurrent(alert);
        bContinue = false;
        while (!bContinue)
            Thread.yield();
        jcc2.application.Main.singleton.display.setCurrent(prev);
        return ((int[])vArg)[0];
    }
}
