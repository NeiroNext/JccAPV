package jcc2.lib.strlib;

import java.util.Enumeration;
import java.util.Hashtable;
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
            
            Type[] args;
            MethodContainer method;
            int mid = 0;
            
            args = new Type[1];
            args[0] = Type.TYPE_ABYTE;
            method = new MethodContainer("byteToStr", Type.TYPE_STRING, args, this, mid++);
            htMethods.put(method.spec, method);

            args = new Type[2];
            args[0] = Type.TYPE_STRING;
            args[1] = Type.TYPE_STRING;
            method = new MethodContainer("strStartsWith", Type.TYPE_BOOL, args, this, mid++);
            htMethods.put(method.spec, method);

            args = new Type[2];
            args[0] = Type.TYPE_STRING;
            args[1] = Type.TYPE_STRING;
            method = new MethodContainer("strEndsWith", Type.TYPE_BOOL, args, this, mid++);
            htMethods.put(method.spec, method);

            args = new Type[1];
            args[0] = Type.TYPE_STRING;
            method = new MethodContainer("strToBytes", Type.TYPE_ABYTE, args, this, mid++);
            htMethods.put(method.spec, method);

            args = new Type[2];
            args[0] = Type.TYPE_STRING;
            args[1] = Type.TYPE_INT;
            method = new MethodContainer("substr", Type.TYPE_STRING, args, this, mid++);
            htMethods.put(method.spec, method);

            args = new Type[3];
            args[0] = Type.TYPE_STRING;
            args[1] = Type.TYPE_INT;
            args[2] = Type.TYPE_INT;
            method = new MethodContainer("substr", Type.TYPE_STRING, args, this, mid++);
            htMethods.put(method.spec, method);

            args = new Type[2];
            args[0] = Type.TYPE_STRING;
            args[1] = Type.TYPE_CHAR;
            method = new MethodContainer("indexOf", Type.TYPE_INT, args, this, mid++);
            htMethods.put(method.spec, method);

            args = new Type[3];
            args[0] = Type.TYPE_STRING;
            args[1] = Type.TYPE_CHAR;
            args[2] = Type.TYPE_INT;
            method = new MethodContainer("indexOf", Type.TYPE_INT, args, this, mid++);
            htMethods.put(method.spec, method);

            args = new Type[2];
            args[0] = Type.TYPE_STRING;
            args[1] = Type.TYPE_STRING;
            method = new MethodContainer("indexOf", Type.TYPE_INT, args, this, mid++);
            htMethods.put(method.spec, method);

            args = new Type[3];
            args[0] = Type.TYPE_STRING;
            args[1] = Type.TYPE_STRING;
            args[2] = Type.TYPE_INT;
            method = new MethodContainer("indexOf", Type.TYPE_INT, args, this, mid++);
            htMethods.put(method.spec, method);

            args = new Type[2];
            args[0] = Type.TYPE_STRING;
            args[1] = Type.TYPE_STRING;
            method = new MethodContainer("strEquals", Type.TYPE_BOOL, args, this, mid++);
            htMethods.put(method.spec, method);

            args = new Type[1];
            args[0] = Type.TYPE_STRING;
            method = new MethodContainer("trim", Type.TYPE_STRING, args, this, mid++);
            htMethods.put(method.spec, method);

            args = new Type[1];
            args[0] = Type.TYPE_STRING;
            method = new MethodContainer("toUpperCase", Type.TYPE_STRING, args, this, mid++);
            htMethods.put(method.spec, method);

            args = new Type[1];
            args[0] = Type.TYPE_STRING;
            method = new MethodContainer("toLowerCase", Type.TYPE_STRING, args, this, mid++);
            htMethods.put(method.spec, method);

            args = new Type[1];
            args[0] = Type.TYPE_CHAR;
            method = new MethodContainer("toUpperCase", Type.TYPE_CHAR, args, this, mid++);
            htMethods.put(method.spec, method);

            args = new Type[1];
            args[0] = Type.TYPE_CHAR;
            method = new MethodContainer("toLowerCase", Type.TYPE_CHAR, args, this, mid++);
            htMethods.put(method.spec, method);

            args = new Type[3];
            args[0] = Type.TYPE_STRING;
            args[1] = Type.TYPE_CHAR;
            args[2] = Type.TYPE_CHAR;
            method = new MethodContainer("replace", Type.TYPE_STRING, args, this, mid++);
            htMethods.put(method.spec, method);

            args = new Type[2];
            args[0] = Type.TYPE_STRING;
            args[1] = Type.TYPE_INT;
            method = new MethodContainer("charAt", Type.TYPE_CHAR, args, this, mid++);
            htMethods.put(method.spec, method);
        }
        else
        {
            singleton = this;
        }
    }

    
    
    

    public String getDesc ()
    {
        return "jcc2/lib/strlib/library";
    }


    public String getName ()
    {
        return "strlib";
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
        throw new Exception ("object not found");
    }

    public Object rtNewArray (int id, int len) throws Exception
    {
        switch (id)
        {
            default:
                throw new Exception ("object not found");
        }
    }
    
    
    public Object rtInvokeMethod(int id, Object[] args, RTCallbackCaller caller) throws Exception
    {
        switch (id)
        {
          case 0: //	byteToStr(byte[])
          {
		    return byteToStr((byte[])((Object[])args[0])[0]);
          }
		  case 1: //	strStartWith(String, String)
		  {
		    int[] ret = new int[1];
		    if (strStartsWith((String)args[0], (String)args[1]))
		      ret[0] = 1;
		    else
		      ret[0] = 0;
		    return ret;
		  }
		  case 2: //	strEndsWith(String, String)
		  {
		    int[] ret = new int[1];
		    if (strEndsWith((String)args[0], (String)args[1]))
		      ret[0] = 1;
		    else
		      ret[0] = 0;
		    return ret;
		  }
		  case 3: //	strToByte(String)
		  {
		    byte[] b = strToBytes((String)args[0]);
		    Object[] ret = new Object[1];
		    ret[0] = b;
		    return ret;
		  }
		  case 4: //	substr(String, int)
		  {
		    return substr((String)args[0], ((int[])args[1])[0]);
		  }
		  case 5: //	substr(String, int, int)
		  {
		    return substr((String)args[0], ((int[])args[1])[0], ((int[])args[2])[0]);
		  }
		  case 6: //	indexOf(String, int)
		  {
		    int[] ret = { indexOf((String)args[0], ((int[])args[1])[0]) };
		    return ret;
		  }
		  case 7: //	indexOf(String, int, int)
		  {
		    int[] ret = { indexOf((String)args[0], ((int[])args[1])[0], ((int[])args[2])[0]) };
		    return ret;
		  }
		  case 8: //	indexOf(String, String)
		  {
		    int[] ret = { indexOf((String)args[0], (String)args[1]) };
		    return ret;
		  }
		  case 9: //	indexOf(String, String, int)
		  {
		    int[] ret = { indexOf((String)args[0], (String)args[1], ((int[])args[2])[0]) };
		    return ret;
		  }
		  case 10: //	strEquals(String, String)
		  {
		    if (strEquals((String)args[0], (String)args[1])) {
		      return new int[] { 1 };
		    }
		    return new int[1];
		  }
		  case 11: //	trim(String)
		  {
		    return trim((String)args[0]);
		  }
		  case 12: //	toUpperCase(String)
		  {
		    return toUpperCase((String)args[0]);
		  }
		  case 13: //	toLowerCase(String)
		  {
		    return toLowerCase((String)args[0]);
		  }
		  case 14: //	toUpperCase(char)
		  {
		    int[] ret = { toUpperCase((char)((int[])args[0])[0]) };
		    return ret;
		  }
		  case 15: //	toLowerCase(char)
		  {
		    int[] ret = { toLowerCase((char)((int[])args[0])[0]) };
		    return ret;
		  }
		  case 16: // replace(String, char, char)
		  {
		    return replace((String)args[0], (char)((int[])args[1])[0], (char)((int[])args[2])[0]);
		  }
		  case 17: // charAt(String, int)
		  {
		    int[] ret = { charAt((String)args[0], ((int[])args[1])[0]) };
		    return ret;
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


    
    
    
// ------------- Methods --------------------- //
    
    public String byteToStr(byte[] arr) {
      return new String(arr);
    }

    public boolean strStartsWith(String str, String sub) {
      return str.startsWith(sub);
    }

    public boolean strEndsWith(String str, String sub) {
      return str.endsWith(sub);
    }

    public byte[] strToBytes(String str) {
      return str.getBytes();
    }

    public String substr(String str, int pos) {
      return str.substring(pos);
    }

    public String substr(String str, int pos, int end) {
      return str.substring(pos, end);
    }

    public int indexOf(String str, int ch) {
      return str.indexOf(ch);
    }

    public int indexOf(String str, int ch, int from) {
      return str.indexOf(ch, from);
    }

    public int indexOf(String str, String sub) {
      return str.indexOf(sub);
    }

    public int indexOf(String str, String sub, int from) {
      return str.indexOf(sub, from);
    }

    public boolean strEquals(String str1, String str2) {
      return str1.equals(str2);
    }

    public String trim(String str) {
      return str.trim();
    }

    public String toUpperCase(String str) {
      return str.toUpperCase();
    }

    public String toLowerCase(String str) {
      return str.toLowerCase();
    }

    public char toUpperCase(char ch) {
      return Character.toUpperCase(ch);
    }

    public char toLowerCase(char ch) {
      return Character.toLowerCase(ch);
    }

    public String replace(String str, char from, char to) {
      return str.replace(from, to);
    }

    public int charAt(String str, int ch) {
      return str.charAt(ch);
    }
    
}