package jcc2.lib.stdlib;

import jcc2.common.ClassContainer;
import jcc2.common.MethodContainer;
import jcc2.common.Type;
import jcc2.io.fs.FileSystem;
import jcc2.lib.RTObject;
import jcc2.lib.iolib.InputStream;
import jcc2.lib.iolib.OutputStream;

/***
 * 
 * @author NeiroNext
 *
 */

public class Time extends RTObject
{
	
  static ClassContainer ctClass = null;
  static boolean bInit = false;

  public static ClassContainer getClassContainer()
  {
    if (ctClass != null)
      return ctClass;

    ClassContainer container = new ClassContainer("Time");
    container.className = "jcc2/lib/stdlib/Time"; 
    ctClass = container;
    
    return ctClass;
  }
  
  
  public static void initClassContainer ()
  {
	if (bInit)
          return;
      bInit = true;
      
      ClassContainer container = getClassContainer ();
 
      container.addStatic("AM", new Integer(0), Type.TYPE_INT);
      container.addStatic("AM_PM", new Integer(9), Type.TYPE_INT);
      container.addStatic("APRIL", new Integer(3), Type.TYPE_INT);
      container.addStatic("AUGUST", new Integer(7), Type.TYPE_INT);
      container.addStatic("DATE", new Integer(5), Type.TYPE_INT);
      container.addStatic("DAY_OF_MONTH", new Integer(5), Type.TYPE_INT);
      container.addStatic("DAY_OF_WEEK", new Integer(7), Type.TYPE_INT);
      container.addStatic("DECEMBER", new Integer(11), Type.TYPE_INT);
      container.addStatic("FEBRUARY", new Integer(1), Type.TYPE_INT);
      container.addStatic("FRIDAY", new Integer(6), Type.TYPE_INT);
      container.addStatic("HOUR", new Integer(10), Type.TYPE_INT);
      container.addStatic("HOUR_OF_DAY", new Integer(11), Type.TYPE_INT);
      container.addStatic("JANUARY", new Integer(0), Type.TYPE_INT);
      container.addStatic("JULY", new Integer(6), Type.TYPE_INT);
      container.addStatic("JUNE", new Integer(5), Type.TYPE_INT);
      container.addStatic("MARCH", new Integer(2), Type.TYPE_INT);
      container.addStatic("MAY", new Integer(4), Type.TYPE_INT);
      container.addStatic("MILLISECOND", new Integer(14), Type.TYPE_INT);
      container.addStatic("MINUTE", new Integer(12), Type.TYPE_INT);
      container.addStatic("MONDAY", new Integer(2), Type.TYPE_INT);
      container.addStatic("MONTH", new Integer(2), Type.TYPE_INT);
      container.addStatic("NOVEMBER", new Integer(10), Type.TYPE_INT);
      container.addStatic("OCTOBER", new Integer(9), Type.TYPE_INT);
      container.addStatic("PM", new Integer(1), Type.TYPE_INT);
      container.addStatic("SATURDAY", new Integer(7), Type.TYPE_INT);
      container.addStatic("SECOND", new Integer(13), Type.TYPE_INT);
      container.addStatic("SEPTEMBER", new Integer(8), Type.TYPE_INT);
      container.addStatic("SUNDAY", new Integer(1), Type.TYPE_INT);
      container.addStatic("THURSDAY", new Integer(5), Type.TYPE_INT);
      container.addStatic("TUESDAY", new Integer(3), Type.TYPE_INT);
      container.addStatic("WEDNESDAY", new Integer(4), Type.TYPE_INT);
      container.addStatic("YEAR", new Integer(1), Type.TYPE_INT);

  }
  
  
  public Object rtInvoke(int iMethod, Object[] args)
    throws Exception
  {
    throw new Exception("Method not found");
  }
}