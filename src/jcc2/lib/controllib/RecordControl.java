package jcc2.lib.controllib;

import jcc2.common.ClassContainer;
import jcc2.common.MethodContainer;
import jcc2.common.Type;
import jcc2.lib.RTObject;
import jcc2.lib.iolib.OutputStream;
import jcc2.midlet.Midlet;

/***
 * 
 * @author NeiroNext
 *
 */




public class RecordControl extends RTObject
{
  static ClassContainer ctClass = null;
  static boolean bInit = false;
  public javax.microedition.media.control.RecordControl rc;

  public static ClassContainer getClassContainer()
  {
    if (ctClass != null)
      return ctClass;
    ClassContainer container = new ClassContainer("RecordControl");
    container.className = "jcc2/lib/controllib/RecordControl";
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
    args[0] = new Type(OutputStream.getClassContainer(), 0);
    method = new MethodContainer("setRecordStream", Type.TYPE_VOID, args, null, mid++);
    container.addMethod(method);

    args = new Type[0];
    method = new MethodContainer("startRecord", Type.TYPE_VOID, args, null, mid++);
    container.addMethod(method);

    args = new Type[0];
    method = new MethodContainer("commit", Type.TYPE_VOID, args, null, mid++);
    container.addMethod(method);

    args = new Type[0];
    method = new MethodContainer("reset", Type.TYPE_VOID, args, null, mid++);
    container.addMethod(method);

    args = new Type[1];
    args[0] = Type.TYPE_STRING;
    method = new MethodContainer("setRecordLocation", Type.TYPE_VOID, args, null, mid++);
    container.addMethod(method);

    args = new Type[1];
    args[0] = Type.TYPE_INT;
    method = new MethodContainer("setRecordSizeLimit", Type.TYPE_VOID, args, null, mid++);
    container.addMethod(method);

    args = new Type[0];
    method = new MethodContainer("stopRecord", Type.TYPE_VOID, args, null, mid++);
    container.addMethod(method);
  }

  
  
  
  
  public Object rtInvoke(int iMethod, Object[] args) throws Exception
  {
    switch (iMethod)
    {
	    case 0: //<init>
	    {
	      return Type.TYPE_VOID;
	    }
	    case 1: //setRecordStream(OutputStream)
	    {
	      setRecordStream((OutputStream)args[0]);
	      return Type.TYPE_VOID;
	    }
	    case 2: //startRecord()
	    {
	      startRecord();
	      return Type.TYPE_VOID;
	    }
	    case 3: //commit()
	    {
	      commit();
	      return Type.TYPE_VOID;
	    }
	    case 4: //reset()
	    {
	      reset();
	      return Type.TYPE_VOID;
	    }
	    case 5: //setRecordLocation(string)
	    {
	      setRecordLocation((String)args[0]);
	      return Type.TYPE_VOID;
	    }
	    case 6: //setRecordSizeLimit()
	    {
	      setRecordSizeLimit(((int[])args[0])[0]);
	      return Type.TYPE_VOID;
	    }
	    case 7: //stopRecord()
	    {
	      stopRecord();
	      return Type.TYPE_VOID;
	    }
    }

    throw new Exception("RecordControl[" + iMethod + "]");
  }

  
  
  
  
  
  
// --------------------------- Methods --------------------------- //
  
  public void setRecordStream(OutputStream os){
    rc.setRecordStream(os.os);
  }

  public void startRecord() {
    rc.startRecord();
  }

  public void commit() {
    try {
      rc.commit();
    } catch (Exception e) {
      e.printStackTrace();
      Midlet.midlet.f.append("\nRecordControl method commit: " + e.getMessage());
    }
  }

  public void reset() {
    try {
      rc.reset();
    } catch (Exception e) {
      e.printStackTrace();
      Midlet.midlet.f.append("\nRecordControl method reset: " + e.getMessage());
    }
  }

  public void setRecordLocation(String path) {
    try {
      rc.setRecordLocation(path);
    } catch (Exception e) {
      e.printStackTrace();
      Midlet.midlet.f.append("\nRecordControl method setRecordLocation: " + e.getMessage());
    }
  }

  public void setRecordSizeLimit(int limit) {
    try {
      rc.setRecordSizeLimit(limit);
    } catch (Exception e) {
      e.printStackTrace();
      Midlet.midlet.f.append("\nRecordControl method setRecordSizeLimit: " + e.getMessage());
    }
  }

  public void stopRecord() {
    rc.stopRecord();
  }
  
}