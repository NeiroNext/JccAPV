package jcc2.lib.iolib;

import java.util.Vector;
import jcc2.common.ClassContainer;
import jcc2.common.MethodContainer;
import jcc2.common.Type;
import jcc2.lib.RTObject;

/**
 * 
 * @author NeiroNext
 *
 */


public class ByteEdit extends RTObject
{
  static ClassContainer ctClass = null;
  static boolean bInit = false;
  public Vector v;

  public ByteEdit()
  {
    init();
  }

  public ByteEdit(InputStream is)
  {
    init(is);
  }

  public ByteEdit(byte[] b)
  {
    init(b);
  }

  public static ClassContainer getClassContainer()
  {
    if (ctClass != null) {
      return ctClass;
    }
    ClassContainer container = new ClassContainer("ByteEdit");
    container.className = "jcc2/lib/iolib/ByteEdit";
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

    args = new Type[1];
    args[0] = new Type(InputStream.getClassContainer(), 0);
    method = new MethodContainer("<init>", Type.TYPE_VOID, args, null, mid++);
    container.addMethod(method);

    args = new Type[1];
    args[0] = Type.TYPE_ABYTE;
    method = new MethodContainer("<init>", Type.TYPE_VOID, args, null, mid++);
    container.addMethod(method);

    args = new Type[0];
    method = new MethodContainer("<init>", Type.TYPE_VOID, args, null, mid++);
    container.addMethod(method);

    args = new Type[0];
    method = new MethodContainer("size", Type.TYPE_INT, args, null, mid++);
    container.addMethod(method);

    args = new Type[1];
    args[0] = Type.TYPE_INT;
    method = new MethodContainer("get", Type.TYPE_INT, args, null, mid++);
    container.addMethod(method);

    args = new Type[1];
    args[0] = Type.TYPE_INT;
    method = new MethodContainer("add", Type.TYPE_VOID, args, null, mid++);
    container.addMethod(method);

    args = new Type[2];
    args[0] = Type.TYPE_INT;
    args[1] = Type.TYPE_INT;
    method = new MethodContainer("set", Type.TYPE_VOID, args, null, mid++);
    container.addMethod(method);

    args = new Type[2];
    args[0] = Type.TYPE_INT;
    args[1] = Type.TYPE_INT;
    method = new MethodContainer("insert", Type.TYPE_VOID, args, null, mid++);
    container.addMethod(method);

    args = new Type[1];
    args[0] = Type.TYPE_INT;
    method = new MethodContainer("delete", Type.TYPE_VOID, args, null, mid++);
    container.addMethod(method);

    args = new Type[0];
    method = new MethodContainer("deleteAll", Type.TYPE_VOID, args, null, mid++);
    container.addMethod(method);

    args = new Type[2];
    args[0] = Type.TYPE_INT;
    args[1] = Type.TYPE_INT;
    method = new MethodContainer("get", Type.TYPE_AINT, args, null, mid++);
    container.addMethod(method);

    args = new Type[2];
    args[0] = Type.TYPE_INT;
    args[1] = Type.TYPE_INT;
    method = new MethodContainer("replace", Type.TYPE_VOID, args, null, mid++);
    container.addMethod(method);

    args = new Type[2];
    args[0] = Type.TYPE_INT;
    args[1] = Type.TYPE_ABYTE;
    method = new MethodContainer("replace", Type.TYPE_VOID, args, null, mid++);
    container.addMethod(method);

    args = new Type[2];
    args[0] = Type.TYPE_INT;
    args[1] = Type.TYPE_AINT;
    method = new MethodContainer("replace", Type.TYPE_VOID, args, null, mid++);
    container.addMethod(method);

    args = new Type[2];
    args[0] = Type.TYPE_INT;
    args[1] = Type.TYPE_STRING;
    method = new MethodContainer("replace", Type.TYPE_VOID, args, null, mid++);
    container.addMethod(method);

    args = new Type[0];
    method = new MethodContainer("getAll", Type.TYPE_ABYTE, args, null, mid++);
    container.addMethod(method);

    args = new Type[0];
    method = new MethodContainer("getAllInts", Type.TYPE_AINT, args, null, mid++);
    container.addMethod(method);

    args = new Type[1];
    args[0] = Type.TYPE_ABYTE;
    method = new MethodContainer("add", Type.TYPE_VOID, args, null, mid++);
    container.addMethod(method);

    args = new Type[1];
    args[0] = Type.TYPE_AINT;
    method = new MethodContainer("add", Type.TYPE_VOID, args, null, mid++);
    container.addMethod(method);

    args = new Type[1];
    args[0] = Type.TYPE_STRING;
    method = new MethodContainer("add", Type.TYPE_VOID, args, null, mid++);
    container.addMethod(method);

    args = new Type[2];
    args[0] = Type.TYPE_ABYTE;
    args[1] = Type.TYPE_INT;
    method = new MethodContainer("insert", Type.TYPE_VOID, args, null, mid++);
    container.addMethod(method);

    args = new Type[2];
    args[0] = Type.TYPE_AINT;
    args[1] = Type.TYPE_INT;
    method = new MethodContainer("insert", Type.TYPE_VOID, args, null, mid++);
    container.addMethod(method);

    args = new Type[2];
    args[0] = Type.TYPE_STRING;
    args[1] = Type.TYPE_INT;
    method = new MethodContainer("insert", Type.TYPE_VOID, args, null, mid++);
    container.addMethod(method);

    args = new Type[2];
    args[0] = Type.TYPE_INT;
    args[1] = Type.TYPE_INT;
    method = new MethodContainer("delete", Type.TYPE_VOID, args, null, mid++);
    container.addMethod(method);

    args = new Type[2];
    args[0] = Type.TYPE_ABYTE;
    args[1] = Type.TYPE_INT;
    method = new MethodContainer("set", Type.TYPE_VOID, args, null, mid++);
    container.addMethod(method);

    args = new Type[2];
    args[0] = Type.TYPE_AINT;
    args[1] = Type.TYPE_INT;
    method = new MethodContainer("set", Type.TYPE_VOID, args, null, mid++);
    container.addMethod(method);

    args = new Type[2];
    args[0] = Type.TYPE_STRING;
    args[1] = Type.TYPE_INT;
    method = new MethodContainer("set", Type.TYPE_VOID, args, null, mid++);
    container.addMethod(method);
  }

  
  
  public Object rtInvoke(int iMethod, Object[] args)
    throws Exception
  {
    switch (iMethod)
    {
	    case 0: //	init(InputStream)
	    {
	      init((InputStream)args[0]);
	      return Type.TYPE_VOID;
	    }
	    case 1: //	init(byte[])
	    {
	      init((byte[])((Object[])args[0])[0]);
	      return Type.TYPE_VOID;
	    }
	    case 2: //	init
	    {
	      init();
	      return Type.TYPE_VOID;
	    }
	    case 3: //	size()
	    {
	      int[] ret = { size() };
	      return ret;
	    }
	    case 4: //	get(int)
	    {
	      int[] ret = { get(((int[])args[0])[0]) };
	      return ret;
	    }
	    case 5: //	add(int)
	    {
	      add(((int[])args[0])[0]);
	      return Type.TYPE_VOID;
	    }
	    case 6: // set(int, int)
	    {
	      set(((int[])args[0])[0], ((int[])args[1])[0]);
	      return Type.TYPE_VOID;
	    }
	    case 7: // insert(int, int)
	    {
	      insert(((int[])args[0])[0], ((int[])args[1])[0]);
	      return Type.TYPE_VOID;
	    }
	    case 8: //	delete(int)
	    {
	      delete(((int[])args[0])[0]);
	      return Type.TYPE_VOID;
	    }
	    case 9: //	deleteAll()
	    {
	      deleteAll();
	      return Type.TYPE_VOID;
	    }
	    case 10: //	get(int, int)
	    {
	      Object[] ret = { get(((int[])args[0])[0], ((int[])args[1])[0]) };
	      return ret;
	    }
	    case 11: //	replace(int, int)
	    {
	      replace(((int[])args[0])[0], ((int[])args[1])[0]);
	      return Type.TYPE_VOID;
	    }
	    case 12: //	replace(int, byte[])
	    {
	      replace(((int[])args[0])[0], (byte[])((Object[])args[1])[0]);
	      return Type.TYPE_VOID;
	    }
	    case 13: //	replace(int, int[])
	    {
	      replace(((int[])args[0])[0], (int[])((Object[])args[1])[0]);
	      return Type.TYPE_VOID;
	    }
	    case 14: //	replace(int, String)
	    {
	      replace(((int[])args[0])[0], (String)args[1]);
	      return Type.TYPE_VOID;
	    }
	    case 15: //	getAll()
	    {
	      Object[] ret = { getAll() };
	      return ret;
	    }
	    case 16: //	getAllInts()
	    {
	      Object[] ret = { getAllInts() };
	      return ret;
	    }
	    case 17: //	add(byte[])
	    {
	      add((byte[])((Object[])args[0])[0]);
	      return Type.TYPE_VOID;
	    }
	    case 18: //	add(int[])
	    {
	      add((int[])((Object[])args[0])[0]);
	      return Type.TYPE_VOID;
	    }
	    case 19: //	add(String)
	    {
	      add((String)args[0]);
	      return Type.TYPE_VOID;
	    }
	    case 20: //	insert(byte[], int)
	    {
	      insert((byte[])((Object[])args[0])[0], ((int[])args[1])[0]);
	      return Type.TYPE_VOID;
	    }
	    case 21: // insert(int[], int)
	    {
	      insert((int[])((Object[])args[0])[0], ((int[])args[1])[0]);
	      return Type.TYPE_VOID;
	    }
	    case 22: //	insert(String, int)
	    {
	      insert((String)args[0], ((int[])args[1])[0]);
	      return Type.TYPE_VOID;
	    }
	    case 23: //	delete(int, int)
	    {
	      delete(((int[])args[0])[0], ((int[])args[1])[0]);
	      return Type.TYPE_VOID;
	    }
	    case 24: // set(byte[], int)
	    {
	      set((byte[])((Object[])args[0])[0], ((int[])args[1])[0]);
	      return Type.TYPE_VOID;
	    }
	    case 25: //	set(int[], int)
	    {
	      set((int[])((Object[])args[0])[0], ((int[])args[1])[0]);
	      return Type.TYPE_VOID;
	    }
	    case 26: // set(String, int)
	    {
	      set((String)args[0], ((int[])args[1])[0]);
	      return Type.TYPE_VOID;
	    }
    }

    throw new Exception("ByteEdit[" + iMethod + "]");
 } 

  
  
  
  
  
  
  

  
// ---------------------- Mrthods ----------------------- //
  
  
  public void init(InputStream is) {
	v = new Vector();
    int b = 0;
    try {
      while ((b = is.is.read()) != -1)
        v.addElement(new byte[] { (byte)b });
    }
    catch (Exception e) {
      e.printStackTrace();
    } }

  public void init(byte[] b) {
    v = new Vector();
    int len = b.length;
    try {
      for (int i = 0; i < len; i++)
        v.addElement(new byte[] { b[i] });
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public void init() {
    v = new Vector();
  }

  public int size() {
    return v.size();
  }

  public int byteToInt(byte b){
	  int ret = b;
	  if(ret < 0)
		  ret += 256;
	  return ret;
  }
  
  public int get(int indx) {
    return byteToInt(((byte[])v.elementAt(indx))[0]);
  }

  public void add(int b) {
    v.addElement(new byte[] { (byte)b });
  }

  public void set(int b, int indx) {
    v.setElementAt(new byte[] { (byte)b }, indx);
  }

  public void insert(int b, int indx) {
    v.insertElementAt(new byte[] { (byte)b }, indx);
  }

  public void delete(int indx) {
    v.removeElementAt(indx);
  }

  public void deleteAll() {
    v.removeAllElements();
  }

  public int[] get(int from, int to) {
    int[] ret = new int[to - from];
    for (int i = 0; i < ret.length; i++) {
      ret[i] = byteToInt(((byte[])v.elementAt(i))[0]);
    }
    return ret;
  }

  public void replace(int from, int to)
  {
    int res = 0;
    for (int i = 0; i < v.size(); i++)
    {
      res = ((byte[])v.elementAt(i))[0];
      if (res == from)
        v.setElementAt(new byte[] { (byte)to }, i);
    }
  }

  public void replace(int from, byte[] b) {
    int res = 0;
    for (int i = 0; i < v.size(); i++)
    {
      res = ((byte[])v.elementAt(i))[0];
      if (res == from) {
        v.removeElementAt(i);
        for (int j = 0; j < b.length; j++) {
          v.insertElementAt(new byte[] { b[j] }, i);
          i++;
        }
      }
    }
  }

  public void replace(int from, int[] b) {
    int res = 0;
    for (int i = 0; i < v.size(); i++)
    {
      res = ((byte[])v.elementAt(i))[0];
      if (res == from) {
        v.removeElementAt(i);
        for (int j = 0; j < b.length; j++) {
          v.insertElementAt(new byte[] { (byte)b[j] }, i);
          i++;
        }
      }
    }
  }

  public void replace(int from, String str) {
    int res = 0;
    byte[] b = str.getBytes();
    for (int i = 0; i < v.size(); i++)
    {
      res = ((byte[])v.elementAt(i))[0];
      if (res == from) {
        v.removeElementAt(i);
        for (int j = 0; j < b.length; j++) {
          v.insertElementAt(new byte[] { b[j] }, i);
          i++;
        }
      }
    }
  }

  public byte[] getAll() {
    byte[] ret = new byte[v.size()];
    for (int i = 0; i < v.size(); i++) {
      ret[i] = ((byte[])v.elementAt(i))[0];
    }
    return ret;
  }

  public int[] getAllInts() {
    int[] ret = new int[v.size()];
    for (int i = 0; i < v.size(); i++) {
      ret[i] = byteToInt(((byte[])v.elementAt(i))[0]);
    }
    return ret;
  }

  public void add(byte[] b)
  {
    for (int i = 0; i < b.length; i++)
      v.addElement(new byte[] { b[i] });
  }

  public void add(int[] b) {
    for (int i = 0; i < b.length; i++)
      v.addElement(new byte[] { (byte)b[i] });
  }

  public void add(String str) {
    byte[] b = str.getBytes();
    for (int i = 0; i < b.length; i++)
      v.addElement(new byte[] { b[i] });
  }

  public void insert(byte[] b, int indx) {
    for (int i = 0; i < b.length; i++)
      v.insertElementAt(new byte[] { b[i] }, indx + i);
  }

  public void insert(int[] b, int indx) {
    for (int i = 0; i < b.length; i++)
      v.insertElementAt(new byte[] { (byte)b[i] }, indx + i);
  }

  public void insert(String str, int indx) {
    byte[] b = str.getBytes();
    for (int i = 0; i < b.length; i++)
      v.insertElementAt(new byte[] { b[i] }, indx + i);
  }

  public void delete(int from, int to) {
    for (int i = 0; i < to - from; i++)
      if (v.size() >= from + 1)
        v.removeElementAt(from);
  }

  public void set(byte[] b, int indx) {
    delete(indx, indx + b.length);
    insert(b, indx);
  }

  public void set(int[] b, int indx) {
    delete(indx, indx + b.length);
    insert(b, indx);
  }

  public void set(String str, int indx) {
    delete(indx, indx + str.length());
    insert(str, indx);
  }
  
  
}