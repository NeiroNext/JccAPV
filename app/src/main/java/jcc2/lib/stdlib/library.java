package jcc2.lib.stdlib;

import java.util.Calendar;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Random;
import jcc2.midlet.Midlet;

import javax.wireless.messaging.MessageConnection;
import javax.wireless.messaging.TextMessage;

import jcc2.common.ClassContainer;
import jcc2.common.MethodContainer;
import jcc2.common.Type;
import jcc2.lib.Library;
import jcc2.lib.RTCallbackCaller;

/**
 *
 * @author NeiroNext
 */

public class library extends Library
{
    public static library singleton;

    Hashtable htClasses;
    Hashtable htMethods;
    RTCallbackCaller callbackCaller;

    private String lastError;
    Random rnd;
    Calendar calendar;

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
            ClassContainer ct;
            Time.initClassContainer();
             
            ct = Time.getClassContainer();
            ct.id = cid++;
            ct.libHost = this;
            htClasses.put(ct.name, ct);
            
            
            
            Type[] args;
            MethodContainer method;
            int mid = 0;

            args = new Type[1];
            args[0] = Type.TYPE_STRING;
            method = new MethodContainer ("print", Type.TYPE_VOID, args, this, mid++);
            htMethods.put(method.spec, method);
            
            args = new Type[1];
            args[0] = Type.TYPE_STRING;
            method = new MethodContainer ("println", Type.TYPE_VOID, args, this, mid++);
            htMethods.put(method.spec, method);

            args = new Type[1];
            args[0] = Type.TYPE_STRING;
            method = new MethodContainer ("setLastError", Type.TYPE_VOID, args, this, mid++);
            htMethods.put(method.spec, method);

            args = new Type[0];
            method = new MethodContainer ("getLastError", Type.TYPE_STRING, args, this, mid++);
            htMethods.put(method.spec, method);
            
            args = new Type[0];
            method = new MethodContainer ("yield", Type.TYPE_VOID, args, this, mid++);
            htMethods.put(method.spec, method);
            
            args = new Type[1];
            args[0] = Type.TYPE_INT;
            method = new MethodContainer ("sleep", Type.TYPE_VOID, args, this, mid++);
            htMethods.put(method.spec, method);
            
            args = new Type[0];
            method = new MethodContainer ("time", Type.TYPE_LONG, args, this, mid++);
            htMethods.put(method.spec, method);
            
            args = new Type[0];
            method = new MethodContainer ("freeMemory", Type.TYPE_INT, args, this, mid++);
            htMethods.put(method.spec, method);
            
            args = new Type[0];
            method = new MethodContainer ("totalMemory", Type.TYPE_INT, args, this, mid++);
            htMethods.put(method.spec, method);
            
            args = new Type[0];
            method = new MethodContainer ("usedMemory", Type.TYPE_INT, args, this, mid++);
            htMethods.put(method.spec, method);
             
            args = new Type[0];
            method = new MethodContainer ("gc", Type.TYPE_VOID, args, this, mid++);
            htMethods.put(method.spec, method);
            
            args = new Type[1];
            args[0] = Type.TYPE_STRING;
            method = new MethodContainer ("platformRequest", Type.TYPE_BOOL, args, this, mid++);
            htMethods.put(method.spec, method);
            
            args = new Type[1];
            args[0] = Type.TYPE_STRING;
            method = new MethodContainer ("getProperty", Type.TYPE_STRING, args, this, mid++);
            htMethods.put(method.spec, method);
            
            args = new Type[1];
            args[0] = Type.TYPE_STRING;
            method = new MethodContainer ("getAppProperty", Type.TYPE_STRING, args, this, mid++);
            htMethods.put(method.spec, method);
            
            args = new Type[2];
            args[0] = Type.TYPE_INT;
            args[1] = Type.TYPE_STRING;
            method = new MethodContainer ("sendSMS", Type.TYPE_BOOL, args, this, mid++);
            htMethods.put(method.spec, method);   

            args = new Type[0];
            method = new MethodContainer("exit", Type.TYPE_VOID, args, this, mid++);
            htMethods.put(method.spec, method);

            args = new Type[1];
            args[0] = Type.TYPE_INT;
            method = new MethodContainer("vibra", Type.TYPE_VOID, args, this, mid++);
            htMethods.put(method.spec, method);

            args = new Type[1];
            args[0] = Type.TYPE_INT;
            method = new MethodContainer("toHex", Type.TYPE_STRING, args, this, mid++);
            htMethods.put(method.spec, method);

            args = new Type[1];
            args[0] = Type.TYPE_STRING;
            method = new MethodContainer("fromHex", Type.TYPE_INT, args, this, mid++);
            htMethods.put(method.spec, method);
            
            args = new Type[1];
            args[0] = Type.TYPE_INT;
            method = new MethodContainer("random", Type.TYPE_INT, args, this, mid++);
            htMethods.put(method.spec, method);
            
            args = new Type[0];
            method = new MethodContainer("random", Type.TYPE_INT, args, this, mid++);
            htMethods.put(method.spec, method);
            
            args = new Type[1];
            args[0] = Type.TYPE_INT;
            method = new MethodContainer("getTime", Type.TYPE_INT, args, this, mid++);
            htMethods.put(method.spec, method);

            args = new Type[0];
            method = new MethodContainer("getTimeString", Type.TYPE_STRING, args, this, mid++);
            htMethods.put(method.spec, method);
            
            args = new Type[1];
            args[0] = Type.TYPE_CALLBACK;
            method = new MethodContainer("startThread", Type.TYPE_VOID, args, this, mid++);
            htMethods.put(method.spec, method);
                 
        }
        else
        {
            singleton = this;
            rnd = new Random();
        }
    }

    
    
    
    
    
    
    
    public String getDesc ()
    {
        return "jcc2/lib/stdlib/library";
    }

    public String getName ()
    {
        return "stdlib";
    }

    public ClassContainer ctGetClass(String name)
    {
        return (ClassContainer)htClasses.get(name);
    }

    public MethodContainer ctGetMethod(String desc)
    {
        return (MethodContainer)htMethods.get(desc);
    }

    
    
    
    
    
    
    
    public Object rtInvokeMethod(int id, Object[] args,  RTCallbackCaller caller) throws Exception
    {
        switch (id)
        {
            case 0: //	print(String)
            {
                print ((String)args[0]);
                return Type.TYPE_VOID;
            }
            case 1: //	println(String)
            {
                println((String)args[0]);
                return Type.TYPE_VOID;
            }
            case 2: //	setLastError(String)
            {
            	setLastError((String)args[0]);
                return Type.TYPE_VOID;
            }
            case 3: //	getLastError()
            {
                return getLastError ();
            }
            case 4: //	yield()
            {
            	yield();
            	return Type.TYPE_VOID;
            }
            case 5: //	sleep(int)
            {
            	sleep(((int[])args[0])[0]);
            	return Type.TYPE_VOID;
            }
            case 6: //	time()
            {
            	return new long[]{ time() };
            }
            case 7: //	freeMemory()
            {
            	return new int[]{ freeMemory() };
            }
            case 8: //	totalMemory()
            {
            	return new int[]{ totalMemory() };
            }
            case 9: //	usedMemory()
            {
            	return new int[]{ usedMemory() };
            }
            case 10: //	gc()
            {
            	gc();
            	return Type.TYPE_VOID;
            }
            case 11: //	platformRequest(String)
            {
            	int[] ret = new int[1];
            	ret[0] = 0;
            	if (platformRequest((String)args[0]))
            		ret[0] = 1;
            	return ret;		
            }
            case 12: // getProperty(String)
            {
            	return getProperty((String)args[0]);
            }
            case 13: // getAppProperty(String)
            {
            	return getAppProperty((String)args[0]);
            } 
            case 14: //	sendSMS(int, String)
            {
            	int[] ret = new int[1];
            	ret[0] = 0;
            	if (sendSMS(((int[])args[0])[0], (String)args[1]))
            		ret[0] = 1;
            	return ret;		
            }
            case 15: //	exit()
            {
                 exit();
                 return Type.TYPE_VOID;
            }
            case 16: //	vibra(int)
            {
                 vibra(((int[])args[0])[0]);
                 return Type.TYPE_VOID;
            }
            case 17: //	toHex(int)
            {
                 return toHex(((int[])args[0])[0]);
            }
            case 18: //	fromHex(String)
            {
                 int[] ret = { fromHex((String)args[0]) };
                 return ret;
            }
            case 19: //	random(int)
            {
                int[] ret = new int[1];
                ret[0] = random(((int[])args[0])[0]);
                return ret;
            }
            case 20: //	random()
            {
                int[] ret = new int[1];
                ret[0] = random();
                return ret;
            }
            case 21: // getTime(int)
            {
                int[] ret = new int[1];
                ret[0] = getTime(((int[])args[0])[0]);
                return ret;
            }
            case 22: // getTimeString()
            {
                return getTimeString();
            }
            case 23: //	startThread(Callback)
            {
                callbackCaller = caller;
                startThread (((int[])args[0])[0]);
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
    
    public Object rtNewObject(int id) throws Exception
    {
        throw new Exception ("object not found");
    }

    public Object rtNewArray (int id, int len) throws Exception
    {
        throw new Exception ("object not found");
    }

    
    
    
    
    
    
    
    
    
    
//-------------------- Methods -----------------------//
    
    
    public void print (String s)
    {
        System.out.print(s);
        try {
            Midlet.midlet.f.append(s);
        } catch (Exception e){}
    }
    
    public void println (String s)
    {
        System.out.println(s);
        try {
            Midlet.midlet.f.append(s+"\n");
        } catch (Exception e){}
    }
    
    public void setLastError (String message)
    {
        lastError = message;
    }

    public String getLastError ()
    {
        return lastError;
    }
    
    public void yield (){
    	Thread.yield();
    }
    
    public void sleep (int time0){
    	try{
    		Thread.sleep(time0);
    	} catch(Exception exc) {}
    }
    
    public long time (){
    	return System.currentTimeMillis();
    }
    
    public int freeMemory (){
    	return (int)Runtime.getRuntime().freeMemory();
    }
    
    public int totalMemory (){
    	return (int)Runtime.getRuntime().totalMemory();
    }
    
    public int usedMemory (){
    	return totalMemory() - freeMemory();
    }
    
    public void gc(){
    	System.gc();
    }
    
    public boolean platformRequest (String str){
    	boolean ret = false;
    	try{
    		ret = Midlet.midlet.platformRequest(str);
    	} catch(Exception exc){
    		ret = false;
    	}
    	return ret;
    }
    
    public String getProperty (String str){
    	return System.getProperty(str);
    }
    
    public String getAppProperty(String str){
    	return Midlet.midlet.getAppProperty(str);
    }
    
	public boolean sendSMS(int number,String text){
		boolean ret = false;
		
		try{
			MessageConnection msc=(MessageConnection)javax.microedition.io.Connector.open("sms://"+number);
			TextMessage msg =(TextMessage) msc.newMessage(msc.TEXT_MESSAGE);
			msg.setPayloadText(text);
			msc.send(msg);
			ret = true;
		} catch(Exception exc) {}
		
		return ret;
	}

	public void exit() {
	    Midlet.midlet.destroyApp(true);
	}

    public void vibra(int time) {
	    Midlet.midlet.display.vibrate(time);
	}
	
	
	public String toHex(int hex) {
		return Integer.toHexString(hex);
	}

	public int fromHex(String hex) {
		return Integer.parseInt(hex, 16);
	}
	
	public int random(int arg) {
	    return rnd.nextInt() % (arg+1);
	}
	
	public int random() {
	    return rnd.nextInt();
	}
	
	public int getTime(int arg) {
	    calendar = Calendar.getInstance();
	    return calendar.get(arg);
	}

	public String getTimeString() {
	    calendar = Calendar.getInstance();
	    return calendar.getTime().toString();
	}
	
    public void startThread (int callback)
    {
        new MyThread (callback).start();
    }
	
    class MyThread extends Thread
    {
        int iMethod;

        public MyThread (int iMethod)
        {
            this.iMethod = iMethod;
        }

        public void run ()
        {
            try
            {
                callbackCaller.$callCallback(null, iMethod);
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
        }
    }
    
}
