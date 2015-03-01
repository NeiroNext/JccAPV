package jcc2.lib.mathlib;

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
        return "jcc2/lib/mathlib/library";
    }

    public String getName ()
    {
        return "mathlib";
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
            args[0] = Type.TYPE_INT;
            method = new MethodContainer("abs", Type.TYPE_INT, args, this, mid++);
            htMethods.put(method.spec, method);

            args = new Type[1];
            args[0] = Type.TYPE_LONG;
            method = new MethodContainer("abs", Type.TYPE_LONG, args, this, mid++);
            htMethods.put(method.spec, method);

            args = new Type[1];
            args[0] = Type.TYPE_FLOAT;
            method = new MethodContainer("abs", Type.TYPE_FLOAT, args, this, mid++);
            htMethods.put(method.spec, method);

            args = new Type[1];
            args[0] = Type.TYPE_DOUBLE;
            method = new MethodContainer("abs", Type.TYPE_DOUBLE, args, this, mid++);
            htMethods.put(method.spec, method);

            args = new Type[2];
            args[0] = Type.TYPE_INT;
            args[1] = Type.TYPE_INT;
            method = new MethodContainer("max", Type.TYPE_INT, args, this, mid++);
            htMethods.put(method.spec, method);

            args = new Type[2];
            args[0] = Type.TYPE_LONG;
            args[1] = Type.TYPE_LONG;
            method = new MethodContainer("max", Type.TYPE_LONG, args, this, mid++);
            htMethods.put(method.spec, method);

            args = new Type[2];
            args[0] = Type.TYPE_FLOAT;
            args[1] = Type.TYPE_FLOAT;
            method = new MethodContainer("max", Type.TYPE_FLOAT, args, this, mid++);
            htMethods.put(method.spec, method);

            args = new Type[2];
            args[0] = Type.TYPE_DOUBLE;
            args[1] = Type.TYPE_DOUBLE;
            method = new MethodContainer("max", Type.TYPE_DOUBLE, args, this, mid++);
            htMethods.put(method.spec, method);

            args = new Type[2];
            args[0] = Type.TYPE_INT;
            args[1] = Type.TYPE_INT;
            method = new MethodContainer("min", Type.TYPE_INT, args, this, mid++);
            htMethods.put(method.spec, method);

            args = new Type[2];
            args[0] = Type.TYPE_LONG;
            args[1] = Type.TYPE_LONG;
            method = new MethodContainer("min", Type.TYPE_LONG, args, this, mid++);
            htMethods.put(method.spec, method);

            args = new Type[2];
            args[0] = Type.TYPE_FLOAT;
            args[1] = Type.TYPE_FLOAT;
            method = new MethodContainer("min", Type.TYPE_FLOAT, args, this, mid++);
            htMethods.put(method.spec, method);

            args = new Type[2];
            args[0] = Type.TYPE_DOUBLE;
            args[1] = Type.TYPE_DOUBLE;
            method = new MethodContainer("min", Type.TYPE_DOUBLE, args, this, mid++);
            htMethods.put(method.spec, method);

            args = new Type[1];
            args[0] = Type.TYPE_DOUBLE;
            method = new MethodContainer("cos", Type.TYPE_DOUBLE, args, this, mid++);
            htMethods.put(method.spec, method);

            args = new Type[1];
            args[0] = Type.TYPE_DOUBLE;
            method = new MethodContainer("sin", Type.TYPE_DOUBLE, args, this, mid++);
            htMethods.put(method.spec, method);

            args = new Type[1];
            args[0] = Type.TYPE_DOUBLE;
            method = new MethodContainer("tan", Type.TYPE_DOUBLE, args, this, mid++);
            htMethods.put(method.spec, method);

            args = new Type[1];
            args[0] = Type.TYPE_FLOAT;
            method = new MethodContainer("cos", Type.TYPE_FLOAT, args, this, mid++);
            htMethods.put(method.spec, method);

            args = new Type[1];
            args[0] = Type.TYPE_FLOAT;
            method = new MethodContainer("sin", Type.TYPE_FLOAT, args, this, mid++);
            htMethods.put(method.spec, method);

            args = new Type[1];
            args[0] = Type.TYPE_FLOAT;
            method = new MethodContainer("tan", Type.TYPE_FLOAT, args, this, mid++);
            htMethods.put(method.spec, method);

            args = new Type[1];
            args[0] = Type.TYPE_DOUBLE;
            method = new MethodContainer("sqrt", Type.TYPE_DOUBLE, args, this, mid++);
            htMethods.put(method.spec, method);

            args = new Type[1];
            args[0] = Type.TYPE_DOUBLE;
            method = new MethodContainer("toRadians", Type.TYPE_DOUBLE, args, this, mid++);
            htMethods.put(method.spec, method);

            args = new Type[1];
            args[0] = Type.TYPE_DOUBLE;
            method = new MethodContainer("toDegrees", Type.TYPE_DOUBLE, args, this, mid++);
            htMethods.put(method.spec, method);

            args = new Type[1];
            args[0] = Type.TYPE_DOUBLE;
            method = new MethodContainer("ceil", Type.TYPE_INT, args, this, mid++);
            htMethods.put(method.spec, method);
            
            
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
          case 0:
          {
            int[] ret = new int[1];
            ret[0] = abs(((int[])args[0])[0]);
            return ret;
          }
          case 1:
          {
            long[] ret = new long[1];
            ret[0] = abs(((long[])args[0])[0]);
            return ret;
          }
          case 2:
          {
            float[] ret = new float[1];
            ret[0] = abs(((float[])args[0])[0]);
            return ret;
          }
          case 3:
          {
            double[] ret = new double[1];
            ret[0] = abs(((double[])args[0])[0]);
            return ret;
          }
          case 4:
          {
            int[] ret = new int[1];
            ret[0] = max(((int[])args[0])[0], ((int[])args[1])[0]);
            return ret;
          }
          case 5:
          {
            long[] ret = new long[1];
            ret[0] = max(((long[])args[0])[0], ((long[])args[1])[0]);
            return ret;
          }
          case 6:
          {
            float[] ret = new float[1];
            ret[0] = max(((float[])args[0])[0], ((float[])args[1])[0]);
            return ret;
          }
          case 7:
          {
            double[] ret = new double[1];
            ret[0] = max(((double[])args[0])[0], ((double[])args[1])[0]);
            return ret;
          }
          case 8:
          {
            int[] ret = new int[1];
            ret[0] = min(((int[])args[0])[0], ((int[])args[1])[0]);
            return ret;
          }
          case 9:
          {
            long[] ret = new long[1];
            ret[0] = min(((long[])args[0])[0], ((long[])args[1])[0]);
            return ret;
          }
          case 10:
          {
            float[] ret = new float[1];
            ret[0] = min(((float[])args[0])[0], ((float[])args[1])[0]);
            return ret;
          }
          case 11:
          {
            double[] ret = new double[1];
            ret[0] = min(((double[])args[0])[0], ((double[])args[1])[0]);
            return ret;
          }
          case 12:
          {
            double[] ret = new double[1];
            ret[0] = cos(((double[])args[0])[0]);
            return ret;
          }
          case 13:
          {
            double[] ret = new double[1];
            ret[0] = sin(((double[])args[0])[0]);
            return ret;
          }
          case 14:
          {
            double[] ret = new double[1];
            ret[0] = tan(((double[])args[0])[0]);
            return ret;
          }
          case 15:
          {
            float[] ret = new float[1];
            ret[0] = cos(((float[])args[0])[0]);
            return ret;
          }
          case 16:
          {
            float[] ret = new float[1];
            ret[0] = sin(((float[])args[0])[0]);
            return ret;
          }
          case 17:
          {
            float[] ret = new float[1];
            ret[0] = tan(((float[])args[0])[0]);
            return ret;
          }
          case 18:
          {
            double[] ret = new double[1];
            ret[0] = sqrt(((double[])args[0])[0]);
            return ret;
          }
          case 19:
          {
            double[] ret = new double[1];
            ret[0] = toRadians(((double[])args[0])[0]);
            return ret;
          }
          case 20:
          {
            double[] ret = new double[1];
            ret[0] = toDegrees(((double[])args[0])[0]);
            return ret;
          }
          case 21:
          {
            int[] ret = new int[1];
            ret[0] = ceil(((double[])args[0])[0]);
            return ret;
          }
            
          default:
            throw new Exception ("method not found");
        }
    }
    
    
    
// ----------------------- Methods ------------------------- //

    
    public int abs(int i) {
      return Math.abs(i);
    }

    public long abs(long i) {
      return Math.abs(i);
    }

    public float abs(float i) {
      return Math.abs(i);
    }

    public double abs(double i) {
      return Math.abs(i);
    }

    public int max(int a, int b) {
      return Math.max(a, b);
    }

    public long max(long a, long b) {
      return Math.max(a, b);
    }

    public float max(float a, float b) {
      return Math.max(a, b);
    }

    public double max(double a, double b) {
      return Math.max(a, b);
    }

    public int min(int a, int b) {
      return Math.min(a, b);
    }

    public long min(long a, long b) {
      return Math.min(a, b);
    }

    public float min(float a, float b) {
      return Math.min(a, b);
    }

    public double min(double a, double b) {
      return Math.min(a, b);
    }

    public float cos(float arg)
    {
      return (float)Math.cos(arg);
    }

    public float sin(float arg) {
      return (float)Math.sin(arg);
    }

    public float tan(float arg) {
      return (float)Math.tan(arg);
    }

    public double cos(double arg) {
      return Math.cos(arg);
    }

    public double sin(double arg) {
      return Math.sin(arg);
    }

    public double tan(double arg) {
      return Math.tan(arg);
    }

    public double sqrt(double arg) {
      return Math.sqrt(arg);
    }

    public double toDegrees(double arg) {
      return Math.toDegrees(arg);
    }

    public double toRadians(double arg) {
      return Math.toRadians(arg);
    }

    public int ceil(double arg) {
      return (int)Math.ceil(arg);
    }
  
    
}