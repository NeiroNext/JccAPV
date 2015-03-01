package jcc2.lib.medialib;

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

      int cid = 0;
      Player.initClassContainer();

      ClassContainer ctPlayer = Player.getClassContainer();
      ctPlayer.id = (cid++);
      ctPlayer.libHost = this;

      htClasses.put("Player", ctPlayer);
    }
    else
    {
      singleton = this;
    }
  }

  public String getDesc()
  {
    return "jcc2/lib/medialib/library";
  }

  public String getName()
  {
    return "medialib";
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
      return new Player();
    }

    throw new Exception("object not found");
  }

  public Object rtNewArray(int id, int len)
    throws Exception
  {
    switch (id)
    {
    case 0:
      return new Player[len];
    }

    throw new Exception("object not found");
  }

  public Object rtInvokeMethod(int id, Object[] args, RTCallbackCaller caller)
    throws Exception
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