package jcc2.lib.utillib;

import jcc2.common.ClassContainer;
import jcc2.common.MethodContainer;
import jcc2.common.Type;
import jcc2.lib.RTObject;

/***
 * 
 * @author NeiroNext
 *
 */

public class Hashtable extends RTObject
{
  static ClassContainer ctClass = null;
  static boolean bInit = false;
  public java.util.Hashtable ht;

  public Hashtable(){
    init();
  }

  public Hashtable(int num) {
    init(num);
  }

  public void init() {
    ht = new java.util.Hashtable();
  }

  public void init(int num) {
    ht = new java.util.Hashtable(num);
  }

  
  
  public static ClassContainer getClassContainer()
  {
    if (ctClass != null)
      return ctClass;
    ClassContainer container = new ClassContainer("Hashtable");
    container.className = "jcc2/lib/utillib/Hashtable";
    
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
    method = new MethodContainer("<init>", Type.TYPE_VOID, args, null, mid++);
    container.addMethod(method);

    args = new Type[2];
    args[0] = Type.TYPE_OBJECT;
    args[1] = Type.TYPE_OBJECT;
    method = new MethodContainer("put", Type.TYPE_VOID, args, null, mid++);
    container.addMethod(method);

    args = new Type[1];
    args[0] = Type.TYPE_OBJECT;
    method = new MethodContainer("get", Type.TYPE_OBJECT, args, null, mid++);
    container.addMethod(method);

    args = new Type[0];
    method = new MethodContainer("size", Type.TYPE_INT, args, null, mid++);
    container.addMethod(method);

    args = new Type[1];
    args[0] = Type.TYPE_OBJECT;
    method = new MethodContainer("contains", Type.TYPE_BOOL, args, null, mid++);
    container.addMethod(method);

    args = new Type[1];
    args[0] = Type.TYPE_OBJECT;
    method = new MethodContainer("containsKey", Type.TYPE_BOOL, args, null, mid++);
    container.addMethod(method);

    args = new Type[0];
    method = new MethodContainer("isEmpty", Type.TYPE_BOOL, args, null, mid++);
    container.addMethod(method);

    args = new Type[1];
    args[0] = Type.TYPE_OBJECT;
    method = new MethodContainer("delete", Type.TYPE_VOID, args, null, mid++);
    container.addMethod(method);

    args = new Type[0];
    method = new MethodContainer("deleteAll", Type.TYPE_VOID, args, null, mid++);
    container.addMethod(method);
  }

  
  
  
  public Object rtInvoke(int iMethod, Object[] args) throws Exception
  {
    switch (iMethod)
    {
	    case 0: //	init
	    {
	      init();
	      return Type.TYPE_VOID;
	    }
	    case 1: //	init(int)
	    {
	      init(((int[])args[0])[0]);
	      return Type.TYPE_VOID;
	    }
	    case 2: //	put(Object, Object)
	    {
	      put(args[0], args[1]);
	      return Type.TYPE_VOID;
	    }
	    case 3: //	get(Object)
	    {
	      return get(args[0]);
	    }
	    case 4: //	size()
	    {
	      int[] ret = { size() };
	      return ret;
	    }
	    case 5: //	contains(Object)
	    {
	      int[] ret = new int[1];
	      if (contains(args[0]))
	        ret[0] = 1;
	      else
	        ret[0] = 0;
	      return ret;
	    }
	    case 6: //	containsKey(Object)
	    {
	      int[] ret = new int[1];
	      if (containsKey(args[0]))
	        ret[0] = 1;
	      else
	        ret[0] = 0;
	      return ret;
	    }
	    case 7: //	isEmpty()
	    {
	      int[] ret = new int[1];
	      if (isEmpty())
	        ret[0] = 1;
	      else
	        ret[0] = 0;
	      return ret;
	    }
	    case 8: //	delete(Object)
	    {
	      delete(args[0]);
	      return Type.TYPE_VOID;
	    }
	    case 9: // deleteAll()
	    {
	      deleteAll();
	      return Type.TYPE_VOID;
	    }
    }
    throw new Exception("Hashtable[" + iMethod + "]");
  }

  
  
  
  
  
// ------------------------- Methods --------------------------- //
  
  
  public void put(Object key, Object value)
  {
    ht.put(key, value);
  }

  public Object get(Object key) {
    return ht.get(key);
  }

  public int size() {
    return ht.size();
  }

  public boolean contains(Object obj) {
    return ht.contains(obj);
  }

  public boolean containsKey(Object key) {
    return ht.containsKey(key);
  }

  public boolean isEmpty() {
    return ht.isEmpty();
  }

  public void delete(Object key) {
    ht.remove(key);
  }

  public void deleteAll() {
    ht.clear();
  }
  
}