package jcc2.lib.utillib;

import java.util.Enumeration;
import jcc2.common.ClassContainer;
import jcc2.common.MethodContainer;
import jcc2.common.Type;
import jcc2.lib.Library;
import jcc2.lib.RTCallbackCaller;
import jcc2.lib.stdlib.Time;

/**
 *
 * @author NeiroNext
 */

public class library extends Library
{
    public static library singleton;
    java.util.Hashtable htClasses;
    java.util.Hashtable htMethods;
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

    public Enumeration ctGetAllClasses()
    {
        return htClasses.elements();
    }

    public Enumeration ctGetAllMethods()
    {
        return htMethods.elements();
    }
    
    public ClassContainer ctGetClass(String name)
    {
        return (ClassContainer)htClasses.get(name);
    }

    public MethodContainer ctGetMethod(String desc)
    {
        return (MethodContainer)htMethods.get(desc);
    }
    
    public String getDesc ()
    {
        return "jcc2/lib/utillib/library";
    }

    public String getName ()
    {
        return "utillib";
    }
  
    
    
    public Object rtNewObject(int id) throws Exception
    {
      switch (id) {
      case 0:
          return new Vector();
      case 1:
          return new Hashtable();
      case 2:
    	  return new Base64();
      case 3:
    	  return new MD5();
      }
      throw new Exception("object not found");
    }

    public Object rtNewArray(int id, int len) throws Exception
    {
      switch (id){
      case 0:
          return new Vector[len];
      case 1:
          return new Hashtable[len];
      case 2:
          return new Base64[len];
      case 3:
    	  return new MD5[len];
      }
      throw new Exception("object not found");
    }
    
    
    
    
    
    
    
    public void init(boolean compileTime)
    {
        if (compileTime)
        {
            htClasses = new java.util.Hashtable ();
            htMethods = new java.util.Hashtable ();
        	
        	int cid = 0;
        	ClassContainer ct;
        	
        	Vector.initClassContainer();
        	Hashtable.initClassContainer();
        	Base64.initClassContainer();
        	MD5.initClassContainer();
        	
            ct = Vector.getClassContainer();
            ct.id = cid++;
            ct.libHost = this;
            htClasses.put(ct.name, ct);
            
            ct = Hashtable.getClassContainer();
            ct.id = cid++;
            ct.libHost = this;
            htClasses.put(ct.name, ct);
            
            ct = Base64.getClassContainer();
            ct.id = cid++;
            ct.libHost = this;
            htClasses.put(ct.name, ct);
            
            ct = MD5.getClassContainer();
            ct.id = cid++;
            ct.libHost = this;
            htClasses.put(ct.name, ct);
            
        }
        else
        {
            singleton = this;
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
    
    
    
// ----------------------- Methods ------------------------- //

    
    
}