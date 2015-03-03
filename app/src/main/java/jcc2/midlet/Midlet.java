package jcc2.midlet;

import javax.microedition.lcdui.Display;
import javax.microedition.lcdui.Form;
import javax.microedition.midlet.MIDlet;

/***
 * 
 * @author NeiroNext
 *
 */




public class Midlet extends MIDlet
{
	
  public static Display display;
  public static Midlet midlet;
  public Form f = new Form(null);

  public Midlet(){
    display = Display.getDisplay(this);
    midlet = this;
  }

  public void destroyApp(boolean arg){
	  notifyDestroyed();
  }

  public void pauseApp()	{ }

  public void startApp()	{ }
  
}