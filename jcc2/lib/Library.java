package jcc2.lib;

import java.util.Enumeration;
import jcc2.common.ClassContainer;
import jcc2.common.MethodContainer;

/**
 *
 * @author note173@gmail.com
 */

public abstract class Library
{
    public int id;

    abstract public void init(boolean compileTime);
    abstract public String getDesc();
    abstract public String getName();

    // compile-time
    abstract public Enumeration ctGetAllClasses ();
    abstract public Enumeration ctGetAllMethods ();
    abstract public ClassContainer ctGetClass (String name);
    abstract public MethodContainer ctGetMethod (String name);

    //runtime
    abstract public Object rtInvokeMethod (int id, Object[] args, RTCallbackCaller caller) throws Exception;
    abstract public Object rtNewObject (int id) throws Exception;
    abstract public Object rtNewArray (int id, int len) throws Exception;
}
