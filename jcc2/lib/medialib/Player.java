package jcc2.lib.medialib;

import javax.microedition.media.Manager;
import jcc2.common.ClassContainer;
import jcc2.common.MethodContainer;
import jcc2.common.Type;
import jcc2.lib.RTObject;
import jcc2.lib.iolib.InputStream;
import jcc2.midlet.Midlet;

/**
 * 
 * @author NeiroNext
 *
 */



public class Player extends RTObject
{
  static ClassContainer ctClass = null;
  static boolean bInit = false;
  public javax.microedition.media.Player player;

  public static ClassContainer getClassContainer()
  {
    if (ctClass != null)
      return ctClass;
    ClassContainer container = new ClassContainer("Player");
    container.className = "jcc2/lib/medialib/Player";
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
    args[0] = Type.TYPE_STRING;
    method = new MethodContainer("open", Type.TYPE_VOID, args, null, mid++);
    container.addMethod(method);

    args = new Type[2];
    args[0] = new Type(InputStream.getClassContainer(), 0);
    args[1] = Type.TYPE_STRING;
    method = new MethodContainer("open", Type.TYPE_VOID, args, null, mid++);
    container.addMethod(method);

    args = new Type[0];
    method = new MethodContainer("start", Type.TYPE_VOID, args, null, mid++);
    container.addMethod(method);

    args = new Type[0];
    method = new MethodContainer("stop", Type.TYPE_VOID, args, null, mid++);
    container.addMethod(method);

    args = new Type[0];
    method = new MethodContainer("close", Type.TYPE_VOID, args, null, mid++);
    container.addMethod(method);

    args = new Type[0];
    method = new MethodContainer("realize", Type.TYPE_VOID, args, null, mid++);
    container.addMethod(method);

    args = new Type[0];
    method = new MethodContainer("prefetch", Type.TYPE_VOID, args, null, mid++);
    container.addMethod(method);

    args = new Type[0];
    method = new MethodContainer("getDuration", Type.TYPE_INT, args, null, mid++);
    container.addMethod(method);

    args = new Type[0];
    method = new MethodContainer("getMediaTime", Type.TYPE_INT, args, null, mid++);
    container.addMethod(method);

    args = new Type[1];
    args[0] = Type.TYPE_INT;
    method = new MethodContainer("setMediaTime", Type.TYPE_VOID, args, null, mid++);
    container.addMethod(method);

    args = new Type[1];
    args[0] = Type.TYPE_INT;
    method = new MethodContainer("setLoopCount", Type.TYPE_VOID, args, null, mid++);
    container.addMethod(method);

    args = new Type[3];
    args[0] = Type.TYPE_INT;
    args[1] = Type.TYPE_INT;
    args[2] = Type.TYPE_INT;
    method = new MethodContainer("playTone", Type.TYPE_VOID, args, null, mid++);
    container.addMethod(method);

    args = new Type[1];
    args[0] = new Type(jcc2.lib.controllib.VideoControl.getClassContainer(), 0);
    method = new MethodContainer("getControl", Type.TYPE_BOOL, args, null, mid++);
    container.addMethod(method);

    args = new Type[1];
    args[0] = new Type(jcc2.lib.controllib.VolumeControl.getClassContainer(), 0);
    method = new MethodContainer("getControl", Type.TYPE_BOOL, args, null, mid++);
    container.addMethod(method);

    args = new Type[1];
    args[0] = new Type(jcc2.lib.controllib.RecordControl.getClassContainer(), 0);
    method = new MethodContainer("getControl", Type.TYPE_BOOL, args, null, mid++);
    container.addMethod(method);
  }

  
  
  
  public Object rtInvoke(int iMethod, Object[] args)
    throws Exception
  {
    switch (iMethod)
    {
	    case 0: //<init>
	    {
	      return Type.TYPE_VOID;
	    }
	    case 1: //open(string)
	    {
	      open((String)args[0]);
	      return Type.TYPE_VOID;
	    }
	    case 2: //open(InputStream)
	    {
	      open((InputStream)args[0], (String)args[1]);
	      return Type.TYPE_VOID;
	    }
	    case 3: //start()
	    {
	      start();
	      return Type.TYPE_VOID;
	    }
	    case 4: //stop()
	    {
	      stop();
	      return Type.TYPE_VOID;
	    }
	    case 5: //close()
	    {
	      close();
	      return Type.TYPE_VOID;
	    }
	    case 6: //realize()
	    {
	      realize();
	      return Type.TYPE_VOID;
	    }
	    case 7: //prefetch()
	    {
	      prefetch();
	      return Type.TYPE_VOID;
	    }
	    case 8: //getDuration()
	    {
	      int[] ret = { getDuration() };
	      return ret;
	    }
	    case 9: //getMediaTime()
	    {
	      int[] ret = { getMediaTime() };
	      return ret;
	    }
	    case 10: //setMediaTime(int)
	    {
	      setMediaTime(((int[])args[0])[0]);
	      return Type.TYPE_VOID;
	    }
	    case 11: //setLoopCount(int)
	    {
	      setLoopCount(((int[])args[0])[0]);
	      return Type.TYPE_VOID;
	    }
	    case 12: //playTone(int, int, int)
	    {
	      playTone(((int[])args[0])[0], ((int[])args[1])[0], ((int[])args[2])[0]);
	      return Type.TYPE_VOID;
	    }
	    case 13: //getControl(VideoControl)
	    {
	      int[] ret = new int[1];
	      if (getControl((jcc2.lib.controllib.VideoControl)args[0]))
	        ret[0] = 1;
	      else
	        ret[0] = 0;
	      return ret;
	    }
	    case 14: //getControl(VolumeControl)
	    {
	      int[] ret = new int[1];
	      if (getControl((jcc2.lib.controllib.VolumeControl)args[0]))
	        ret[0] = 1;
	      else
	        ret[0] = 0;
	      return ret;
	    }
	    case 15: //getControl(RecordControl)
	    {
	      int[] ret = new int[1];
	      if (getControl((jcc2.lib.controllib.RecordControl)args[0]))
	        ret[0] = 1;
	      else
	        ret[0] = 0;
	      return ret;
	    }
    }

    throw new Exception("Player[" + iMethod + "]");
  }

  
  
  
  
  
  
  
// ------------------------------ Methods ------------------------ //
  
  public void open(String path){
    try
    {
      player = Manager.createPlayer(path);
    } catch (Exception e) {
      e.printStackTrace();
      Midlet.midlet.f.append("\nPlayer method open: " + e.getMessage());
    }
  }

  public void open(InputStream is, String encode) {
    try {
      player = Manager.createPlayer(is.is, encode);
    } catch (Exception e) {
      e.printStackTrace();
      Midlet.midlet.f.append("\nPlayer method open: " + e.getMessage());
    }
  }

  public void start() {
    try {
      player.start();
    } catch (Exception e) {
      e.printStackTrace();
      Midlet.midlet.f.append("\nPlayer method start: " + e.getMessage());
    }
  }

  public void stop() {
    try {
      player.stop();
    } catch (Exception e) {
      Midlet.midlet.f.append("\nPlayer method stop: " + e.getMessage());
    }
  }

  public void close() {
    try {
      player.close();
    } catch (Exception e) {
      Midlet.midlet.f.append("\nPlayer method close: " + e.getMessage());
    }
  }

  public void realize() {
    try {
      player.realize();
    } catch (Exception e) {
      Midlet.midlet.f.append("\nPlayer method relize: " + e.getMessage());
    }
  }

  public void prefetch() {
    try {
      player.prefetch();
    } catch (Exception e) {
      Midlet.midlet.f.append("\nPlayer method prefetch: " + e.getMessage());
    }
  }

  public int getDuration() {
    try {
      return (int)player.getDuration();
    } catch (Exception e) {
      Midlet.midlet.f.append("\nPlayer method getDuration: " + e.getMessage());
    }return -1;
  }

  public int getMediaTime(){
    try {
      return (int)player.getMediaTime();
    } catch (Exception e) {
      Midlet.midlet.f.append("\nPlayer method getMediaTime: " + e.getMessage());
    }return -1;
  }

  public void setMediaTime(int time){
    try {
      player.setMediaTime(time);
    } catch (Exception e) {
      Midlet.midlet.f.append("\nPlayer method setMediaTime: " + e.getMessage());
    }
  }

  public void setLoopCount(int count) {
    try {
      player.setLoopCount(count);
    } catch (Exception e) {
      Midlet.midlet.f.append("\nPlayer method setLoopCount: " + e.getMessage());
    }
  }

  public void playTone(int note, int duration, int volume) {
    try {
      Manager.playTone(note, duration, volume);
    } catch (Exception e) {
      e.printStackTrace();
      Midlet.midlet.f.append("\nPlayer method playTone: " + e.getMessage());
    }
  }

  public boolean getControl(jcc2.lib.controllib.VideoControl con){
    try
    {
      con.vc = ((javax.microedition.media.control.VideoControl)player.getControl("VideoControl"));
      if (con != null) {
        return true;
      }
    } catch (Exception e) {
      e.printStackTrace();
      Midlet.midlet.f.append("\nPlayer method getControl(VideoControl): " + e.getMessage());
    }	return false;
  }

  public boolean getControl(jcc2.lib.controllib.VolumeControl con){
    try {
      con.vc = ((javax.microedition.media.control.VolumeControl)player.getControl("VolumeControl"));
      if (con != null) {
        return true;
      }
    } catch (Exception e) {
      e.printStackTrace();
      Midlet.midlet.f.append("\nPlayer method getControl(VolumeControl): " + e.getMessage());
    }	return false;
  }

  public boolean getControl(jcc2.lib.controllib.RecordControl con){
    try {
      con.rc = ((javax.microedition.media.control.RecordControl)player.getControl("RecordControl"));
      if (con != null) {
        return true;
      }
    } catch (Exception e) {
      e.printStackTrace();
      Midlet.midlet.f.append("\nPlayer method getControl(RecordControl): " + e.getMessage());
    }	return false;
  }
 
}