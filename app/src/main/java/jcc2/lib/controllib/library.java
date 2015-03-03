package jcc2.lib.controllib;

import java.util.Enumeration;
import java.util.Hashtable;
import jcc2.common.ClassContainer;
import jcc2.common.MethodContainer;
import jcc2.lib.Library;
import jcc2.lib.RTCallbackCaller;

/**
 * 
 * @author NeiroNext
 *
 */




public class library extends Library
{
  public static library singleton;
  static boolean bInit = false;
  Hashtable htClasses;
  Hashtable htMethods;
  RTCallbackCaller callbackCaller;

  public static library getSingleton(RTCallbackCaller caller)
  {
    if (singleton == null)
      singleton = new library();
    singleton.callbackCaller = caller;
    return singleton;
  }

  public library()
  {
    init(false);
  }

  
  
  
  public void init(boolean compileTime)
  {
    if (compileTime)
    {
      htClasses = new Hashtable();
      htMethods = new Hashtable();

      ClassContainer ct;
      int cid = 0;
      VideoControl.initClassContainer();
      VolumeControl.initClassContainer();
      RecordControl.initClassContainer();

      ct = VideoControl.getClassContainer();
      ct.id = (cid++);
      ct.libHost = this;
      htClasses.put(ct.name, ct);

      ct = VolumeControl.getClassContainer();
      ct.id = (cid++);
      ct.libHost = this;
      htClasses.put(ct.name, ct);

      ct = RecordControl.getClassContainer();
      ct.id = (cid++);
      ct.libHost = this;
      htClasses.put(ct.name, ct);

    }
    else
    {
      singleton = this;
    }
  }

  public String getDesc()
  {
    return "jcc2/lib/controllib/library";
  }

  public String getName()
  {
    return "controllib";
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
    switch (id) {
    case 0:
      return new VideoControl();
    case 1:
      return new VolumeControl();
    case 2:
      return new RecordControl();
    }

    throw new Exception("object not found");
  }

  
  public Object rtNewArray(int id, int len) throws Exception
  {
    switch (id)
    {
    case 0:
      return new VideoControl[len];
    case 1:
      return new VolumeControl[len];
    case 2:
      return new RecordControl[len];
    }

    throw new Exception("object not found");
  }

  public Object rtInvokeMethod(int id, Object[] args, RTCallbackCaller caller) throws Exception
  {
    throw new Exception("method not found");
  }

  public Enumeration ctGetAllClasses()
  {
    return htClasses.elements();
  }

  public Enumeration ctGetAllMethods()
  {
    return htMethods.elements();
  }
}