package jcc2.lib.vmlib;

import java.util.Enumeration;
import java.util.Hashtable;
import jcc2.common.ClassContainer;
import jcc2.common.MethodContainer;
import jcc2.lib.*;

/**
 *
 * @author NeiroNext
 */

public class library extends Library
{
    public static library singleton;
    static boolean bInit = false;
    Hashtable htClasses;
    Hashtable htMethods;
    RTCallbackCaller callbackCaller;

    
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

            ClassContainer ct;
            int cid = 0;

            VM.initClassContainer();

            ct = VM.getClassContainer();
            ct.id = (cid++);
            ct.libHost = this;
            htClasses.put(ct.name, ct);
            
        }
        else
        {
            singleton = this;
        }
    }

    public String getDesc ()
    {
        return "jcc2/lib/vmlib/library";
    }

    public String getName ()
    {
        return "vmlib";
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
    	switch(id){
    		case 0:
    			return new VM();
    		default:
    		    throw new Exception ("object not found");
    	}
    }

    public Object rtNewArray (int id, int len) throws Exception
    {
        switch (id)
        {
    		case 0:
    			return new VM[len];
            default:
                throw new Exception ("object not found");
        }
    }

    public Object rtInvokeMethod(int id, Object[] args, RTCallbackCaller caller) throws Exception
    {
        switch (id)
        {
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

}