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

public class Vector extends RTObject
{
  static ClassContainer ctClass = null;
  static boolean bInit = false;
  public java.util.Vector v;

  public Vector(){
    init();
  }

  public Vector(int size) {
    init(size);
  }

  public void init() {
    v = new java.util.Vector();
  }

  public void init(int size) {
    v = new java.util.Vector(size);
  }

  
  
  
  
  public static ClassContainer getClassContainer()
  {
    if (ctClass != null)
      return ctClass;
    ClassContainer container = new ClassContainer("Vector");
    container.className = "jcc2/lib/utillib/Vector";
    
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

      args = new Type[0];
      method = new MethodContainer("<init>", Type.TYPE_VOID, args, null, mid++);
      container.addMethod(method);

      args = new Type[1];
      args[0] = Type.TYPE_INT;
      method = new MethodContainer("<init>", Type.TYPE_VOID, args, null, mid++);
      container.addMethod(method);

      args = new Type[1];
      args[0] = Type.TYPE_OBJECT;
      method = new MethodContainer("add", Type.TYPE_VOID, args, null, mid++);
      container.addMethod(method);

      args = new Type[2];
      args[0] = Type.TYPE_OBJECT;
      args[1] = Type.TYPE_INT;
      method = new MethodContainer("insert", Type.TYPE_VOID, args, null, mid++);
      container.addMethod(method);

      args = new Type[2];
      args[0] = Type.TYPE_OBJECT;
      args[1] = Type.TYPE_INT;
      method = new MethodContainer("set", Type.TYPE_VOID, args, null, mid++);
      container.addMethod(method);

      args = new Type[1];
      args[0] = Type.TYPE_INT;
      method = new MethodContainer("get", Type.TYPE_OBJECT, args, null, mid++);
      container.addMethod(method);

      args = new Type[0];
      method = new MethodContainer("size", Type.TYPE_INT, args, null, mid++);
      container.addMethod(method);

      args = new Type[1];
      args[0] = Type.TYPE_OBJECT;
      method = new MethodContainer("indexOf", Type.TYPE_INT, args, null, mid++);
      container.addMethod(method);

      args = new Type[2];
      args[0] = Type.TYPE_OBJECT;
      args[1] = Type.TYPE_INT;
      method = new MethodContainer("indexOf", Type.TYPE_INT, args, null, mid++);
      container.addMethod(method);

      args = new Type[1];
      args[0] = Type.TYPE_OBJECT;
      method = new MethodContainer("lastIndexOf", Type.TYPE_INT, args, null, mid++);
      container.addMethod(method);

      args = new Type[2];
      args[0] = Type.TYPE_OBJECT;
      args[1] = Type.TYPE_INT;
      method = new MethodContainer("lastIndexOf", Type.TYPE_INT, args, null, mid++);
      container.addMethod(method);

      args = new Type[1];
      args[0] = Type.TYPE_INT;
      method = new MethodContainer("delete", Type.TYPE_VOID, args, null, mid++);
      container.addMethod(method);

      args = new Type[1];
      args[0] = Type.TYPE_OBJECT;
      method = new MethodContainer("delete", Type.TYPE_VOID, args, null, mid++);
      container.addMethod(method);

      args = new Type[0];
      method = new MethodContainer("deleteAll", Type.TYPE_VOID, args, null, mid++);
      container.addMethod(method);

      args = new Type[0];
      method = new MethodContainer("isEmpty", Type.TYPE_BOOL, args, null, mid++);
      container.addMethod(method);

      args = new Type[1];
      args[0] = Type.TYPE_OBJECT;
      method = new MethodContainer("contains", Type.TYPE_BOOL, args, null, mid++);
      container.addMethod(method);

      args = new Type[0];
      method = new MethodContainer("getObjectArray", Type.TYPE_AOBJECT, args, null, mid++);
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
	
	    case 2: //	add(Object)
	    {
	        add(args[0]);
	        return Type.TYPE_VOID;
	    }
	
	    case 3: //	insert(Oject, int)
	    {
	        insert(args[0], ((int[])args[1])[0]);
	        return Type.TYPE_VOID;
	    }
	
	    case 4: //	set(Object, int)
	    {
	        set(args[0], ((int[])args[1])[0]);
	        return Type.TYPE_VOID;
	    }
	
	    case 5: //	get(int)
	    {
	        return get(((int[])args[0])[0]);
	    }
	
	    case 6: //	size()
	    {
	        int ret[] = { size() };
	        return ret;
	    }
	
	    case 7: //	indexOf(Object)
	    {
	        int ret[] = { indexOf(args[0]) };
	        return ret;
	    }
	
	    case 8: //	indexOf(Object, int)
	    {
	        int ret[] = { indexOf(args[0], ((int[])args[1])[0]) };
	        return ret;
	    }
	
	    case 9: //	lastIndexOf(Object)
	    {
	        int ret[] = { lastIndexOf(args[0]) };
	        return ret;
	    }
	
	    case 10: //	lastIndexOf(Object, int)
	    {
	        int ret[] = { lastIndexOf(args[0], ((int[])args[1])[0]) };
	        return ret;
	    }
	
	    case 11: //	delete(int)
	    {
	        delete(((int[])args[0])[0]);
	        return Type.TYPE_VOID;
	    }
	
	    case 12: //	delete(Object)
	    {
	        delete(args[0]);
	        return Type.TYPE_VOID;
	    }
	
	    case 13: //	deleteAll()
	    {
	        deleteAll();
	        return Type.TYPE_VOID;
	    }
	
	    case 14: //	isEmpty()
	    {
	        int ret[] = new int[1];
	        if(isEmpty())
	            ret[0] = 1;
	        else
	            ret[0] = 0;
	        return ret;
	    }
	
	    case 15: //	contains(Object)
	    {
	        int ret[] = new int[1];
	        if(contains(args[0]))
	            ret[0] = 1;
	        else
	            ret[0] = 0;
	        return ret;
	    }
	
	    case 16: //	getObjectArray()
	    {
	        return getObjectArray();
	    }
    }

    throw new Exception("Vector[" + iMethod + "]");
  }

  
  
  
  
  
// ----------------------------- Methods -------------------------------- //
  
  
  public void add(Object obj){
    v.addElement(obj);
  }

  public void insert(Object obj, int pos) {
    v.insertElementAt(obj, pos);
  }

  public void set(Object obj, int pos) {
    v.setElementAt(obj, pos);
  }

  public Object get(int pos) {
    return v.elementAt(pos);
  }

  public int size() {
    return v.size();
  }

  public int indexOf(Object obj) {
    return v.indexOf(obj);
  }

  public int indexOf(Object obj, int pos) {
    return v.indexOf(obj, pos);
  }

  public int lastIndexOf(Object obj) {
    return v.lastIndexOf(obj);
  }

  public int lastIndexOf(Object obj, int pos) {
    return v.lastIndexOf(obj, pos);
  }

  public void delete(int indx) {
    v.removeElementAt(indx);
  }

  public void delete(Object obj) {
    v.removeElement(obj);
  }

  public void deleteAll() {
    v.removeAllElements();
  }

  public boolean isEmpty() {
    return v.isEmpty();
  }

  public boolean contains(Object obj) {
    return v.contains(obj);
  }

  public Object[] getObjectArray() {
    Object[] ret = new Object[v.size()];
    v.copyInto(ret);
    return ret;
  }
  
}