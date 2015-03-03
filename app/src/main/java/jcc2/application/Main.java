package jcc2.application;

/**
 *
 * @author note173@gmail.com
 */

import jcc2.lib.Library;
import jcc2.midlet.Midlet;

import jcc2.io.fs.*;
import jcc2.parser.*;
import jcc2.common.ClassContainer;
import jcc2.common.MethodContainer;
import jcc2.common.Type;
import jcc2.compiler.*;
import jcc2.runtime.*;

import javax.microedition.lcdui.*;
import java.io.*;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Vector;

import jcc2.editor.*;

/****
 * 
 * @fixed NeiroNext
 *
 */



public class Main extends Midlet implements CommandListener
{
    public static Main singleton;

    
    
    
//    USE jcc2.midlet.Midlet fields 
//    volatile public Display display;
//    public Form f = new Form ("out");
    
    Command CMD_RETURN = new Command ("Return", Command.SCREEN, 1);

    public JccEdit tbSource;
    public static final int MAX_SOURCE_CODE = 1024*10;
    public TextBox tbText = new TextBox  ("text", "", 4096, TextField.ANY);
    Command CMD_OK = new Command ("OK", Command.OK, 1);
    Command CMD_COMPILE = new Command ("Compile", Command.SCREEN, 1);
    Command CMD_COMPILE_JASMIN = new Command ("Compile to Jasmin", Command.SCREEN, 1);
    Command CMD_RUN = new Command ("Run", Command.SCREEN, 2);
    Command CMD_EDIT = new Command ("Edit selection", Command.SCREEN, 2);
    Command CMD_LOAD_TEST = new Command ("Load test", Command.SCREEN, 2);
    Command CMD_EXIT = new Command ("Exit", Command.EXIT, 1);
    Command CMD_SAVE_SRC = new Command ("Save", Command.SCREEN, 3);
    Command CMD_LOAD_SRC = new Command ("Load", Command.SCREEN, 4);
    Command CMD_SAVE_BYTECODE = new Command ("Save bytecode", Command.SCREEN, 5);
    Command CMD_EDITOR_SETTINGS = new Command ("Editor settings", Command.SCREEN, 6);
    Command CMD_INFO = new Command("Info", 1, 7);

    Command CMD_SAVE = new Command ("Save", Command.SCREEN, 0);
    Command CMD_LOAD = new Command ("Load", Command.SCREEN, 0);
    Command CMD_CANCEL = new Command ("Cancel", Command.CANCEL, 0);
    TextBox tbFileName;
    String curPath = "/";
    int mode;
    int bcmode;

    FileSystem fs;
    String[][] vSamples;
    
    final int LIBS_INFO = 0;
    final int CLASSES_INFO = 1;
    final int INFO_INFO = 2;
    
    String currentInfoListString;
    int currentInfo = 0;
    Library lbr = null;
    
    Object[] typesInfo = { 
      Type.TYPE_INT, "int", Type.TYPE_LONG, "long", Type.TYPE_SHORT, "short", 
      Type.TYPE_BYTE, "byte", Type.TYPE_CHAR, "char", Type.TYPE_FLOAT, "float", 
      Type.TYPE_DOUBLE, "double", Type.TYPE_BOOL, "bool", Type.TYPE_STRING, "string", 
      Type.TYPE_VOID, "void", Type.TYPE_AINT, "int[]", Type.TYPE_ALONG, "long[]", 
      Type.TYPE_ASHORT, "short[]", Type.TYPE_ABYTE, "byte[]", Type.TYPE_ACHAR, "char[]", 
      Type.TYPE_AFLOAT, "float[]", Type.TYPE_ADOUBLE, "double[]", Type.TYPE_ABOOL, "bool[]", 
      Type.TYPE_ASTRING, "string[]", Type.TYPE_NULL, "null", Type.TYPE_OBJECT, "Object", 
      Type.TYPE_AOBJECT, "Object[]", Type.TYPE_CALLBACK, "callback" };

    Hashtable htTypes = new Hashtable();
    Vector usedlibs = new Vector();
    Hashtable samlibs = new Hashtable();
    Hashtable hSamples = new Hashtable();
   
    List lSamples = new List("Samples List", List.IMPLICIT);
    List samples = new List("Samples", List.IMPLICIT);
    List infoList = new List("INFO", List.IMPLICIT);
    Form fInfo = new Form("Info:");
    List lsFs;
    
    
    
    

    public JccRuntime vm;
    public byte[] bytecode;
    boolean bCanRun;
    int smode;

    Form waitForm = new Form ("Wait...");
    public String sEntryPoint = "main";

    public Main ()
    {
        singleton = this;
        display = Display.getDisplay(this);
        f = new Form ("out");
        display.setCurrent(f);

        /*if (false)
        {
            try
            {
                FileSystem fs = FileSystem.GetInstance();
                int size = fs.Size("/" + fs.List("/")[0] + "test.jc2");
                FilePtr f = fs.Open("/" + fs.List("/")[0] + "test.jc2", FileSystem.READ);
                Jcc2Parser parser = new Jcc2Parser (f.GetDataInputStream());
                ASTCompilationUnit unit = parser.CompilationUnit();
                //unit.dump("");
                Compiler compiler;
                if (false)
                {
                    compiler = new Compiler (unit, true);
                    f = fs.Open("/" + fs.List("/")[0] + "test.j", FileSystem.WRITE);
                    f.Write(compiler.code, 0, compiler.code.length);
                    f.Close();
                }
                else
                {
                    compiler = new Compiler (unit, false);
                    JccRuntime runtime = new JccRuntime (compiler.code);
                    runtime.startApp("main()V");
                }


            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
            if (true)
                return;
        }*/

        tbText.addCommand (CMD_OK);
        tbText.addCommand (CMD_CANCEL);
        tbText.setCommandListener(this);

        tbSource = new JccEdit (display,"Jcc2 v"+getAppProperty("MIDlet-Version"));
        tbSource.addCommand(CMD_COMPILE);
        tbSource.addCommand(CMD_RUN);
        tbSource.addCommand(CMD_EDIT);
        tbSource.addCommand(CMD_LOAD_TEST);
        tbSource.addCommand(CMD_SAVE_SRC);
        tbSource.addCommand(CMD_LOAD_SRC);
        tbSource.addCommand(CMD_COMPILE_JASMIN);
        tbSource.addCommand(CMD_SAVE_BYTECODE);
        tbSource.addCommand(CMD_EDITOR_SETTINGS);
        tbSource.addCommand(CMD_INFO);
        tbSource.addCommand(CMD_EXIT);
        tbSource.setCommandListener(this);

        lSamples.addCommand(CMD_RETURN);
        lSamples.setCommandListener(this);
        samples.addCommand(CMD_RETURN);
        samples.setCommandListener(this);
        infoList.addCommand(CMD_RETURN);
        infoList.setCommandListener(this);
        fInfo.addCommand(CMD_RETURN);
        fInfo.setCommandListener(this);

        try{
          tbSource.setString(loadTxt("/res/tests/start.jc2"));
        } catch (Exception exc) {
        	System.out.print("Error when loading start example!");
        	exc.printStackTrace();
        }


        f.addCommand(CMD_RETURN);
        f.setCommandListener(this);

        lsFs = new List ("list", List.IMPLICIT);
        lsFs.addCommand(CMD_CANCEL);
        lsFs.setCommandListener(this);

        tbFileName = new TextBox ("Filename", "", 256, TextField.ANY);
        tbFileName.addCommand(CMD_SAVE);
        tbFileName.addCommand(CMD_CANCEL);
        tbFileName.setCommandListener(this);

        try{
        fs = FileSystem.GetInstance();
        } catch (Exception e)
        {
            e.printStackTrace();
            display.setCurrent(new Alert("Error", "FS error: " + e.toString(), null, null), tbSource);
        }

        bytecode = null;
        tbSource.currentMode = JccEdit.STATE_NORMAL;
        
        
        
        
        for (int i = 0; i < typesInfo.length / 2; i++) {
            htTypes.put(typesInfo[(i * 2)], typesInfo[(i * 2 + 1)]);
        }
        loadTestsList("/res/TESTS.list");

        for (int i = 0; i < vSamples.length; i++) {
           hSamples.put(vSamples[i][0], vSamples[i][1]);
        }
        loadTests();
    }

    
    
    
    
    public void commandAction (Command c, Displayable d)
    {
        if (d == tbFileName && c == CMD_CANCEL)
            display.setCurrent(lsFs);
        else if (c == CMD_CANCEL)
        {
            display.setCurrent(tbSource);
        }
        
        if (d == lsFs)
        {
            if (c == List.SELECT_COMMAND)
            {
                boolean bRefresh = true;
                int idx = lsFs.getSelectedIndex();
                if (idx >= 0)
                {
                    String sf = lsFs.getString(idx);
                    if (sf.equals("../"))
                    {
                        curPath = curPath.substring(0, curPath.lastIndexOf('/'));
                        if (curPath.length() == 0)
                            curPath = "/";
                        else
                            curPath = curPath.substring(0, curPath.lastIndexOf('/')) + "/";
                    }
                    else if (sf.endsWith("/"))
                    {
                        curPath += lsFs.getString(idx);
                    }
                    else
                    {
                        if (mode == 1) //load
                        {
                            curPath += lsFs.getString(idx);
                            try
                            {
                                new Thread ()
                                {
                                    public void run()
                                    {
                                        String trace = "tr5_";
                                        try
                                        {
                                            trace += "2";
                                            int size = fs.Size(curPath);
                                            trace += "3";
                                            FilePtr f = fs.Open(curPath,
                                                    FileSystem.READ);
                                            trace += "4";
                                            byte[] curCode = new byte[size];
                                            trace += "5";
                                            f.Read(curCode, 0, curCode.length);
                                            trace += "6";
                                            f.Close();
                                            trace += "7";
                                            if (curCode.length >= MAX_SOURCE_CODE)
                                            {
                                                throw new Exception ("file lenght >= " + MAX_SOURCE_CODE);
                                            }
                                            tbSource.setString (new String(curCode));
                                            trace += "8";
                                            display.setCurrent(tbSource);
                                        }
                                        catch (Exception e)
                                        {
                                            System.out.println ("load:"+curPath);
                                            e.printStackTrace();
                                            display.setCurrent(new Alert ("error", "can't open file [5-1]:" + e.toString(), null, null), tbSource);
                                        }
                                    }
                                }.start();
                            }
                            catch (Exception e)
                            {
                                e.printStackTrace();
                                display.setCurrent(new Alert ("error", "can't open file[8]:" + e.toString(), null, null), tbSource);
                            }
                            bRefresh = false;
                        }
                        else
                        {
                            display.setCurrent(tbFileName);
                            bRefresh = false;
                        }
                    }

                    if (bRefresh)
                    {
                        new Thread()
                        {
                            public void run()
                            {
                                String trace = "tr2_";
                                try
                                {
                                    lsFs.deleteAll();
                                    lsFs.setTitle("Wait...");
                                    trace += "1";
                                    String[] vs = fs.List(curPath);
                                    trace += "2";
                                    lsFs.setTitle("Files");
                                    if(!curPath.equals("/"))
                                    	lsFs.append("../", null);
                                    for (int i = 0; i < vs.length; i++)
                                    {
                                        lsFs.append(vs[i], null);
                                    }
                                    trace += "3";
                                }
                                catch (Exception e)
                                {
                                    System.out.println ("1: " + e.toString());
                                    e.printStackTrace();
                                    display.setCurrent(new Alert ("error", "can't open file [4] "+ trace + "::" + e.toString(), null, null), tbSource);
                                }
                            }
                        }.start ();
                    }
                }
            }
            else if (c == CMD_SAVE)
            {
                tbFileName.setString(".jc2");
                display.setCurrent(tbFileName);
            }
            else if (c == CMD_SAVE_BYTECODE)
            {
                if (bcmode == 0)
                    tbFileName.setString(".jb2");
                else if (bcmode == 1)
                    tbFileName.setString(".j");
                display.setCurrent(tbFileName);
            }
            else if (c == CMD_LOAD)
            {
                int idx = lsFs.getSelectedIndex();
                if (idx >= 0 && !lsFs.getString(idx).endsWith("/"))
                {
                    new Thread ()
                    {
                        public void run()
                        {
                            String trace = "1";
                            try
                            {
                                trace += "2";
                                int size = fs.Size(curPath + lsFs.getString(lsFs.getSelectedIndex()));
                                trace += "3";
                                FilePtr f = fs.Open(curPath + lsFs.getString(lsFs.getSelectedIndex()),
                                        FileSystem.READ);
                                trace += "4";
                                byte[] curCode = new byte[size];
                                trace += "5";
                                f.Read(curCode, 0, curCode.length);
                                trace += "6";
                                f.Close();
                                trace += "7";
                                if (curCode.length >= MAX_SOURCE_CODE)
                                {
                                    throw new Exception ("file lenght >= " + MAX_SOURCE_CODE);
                                }
                                tbSource.setString (new String(curCode));
                                trace += "8";
                                display.setCurrent(tbSource);
                            }
                            catch (Exception e)
                            {
                                System.out.println ("load:"+curPath);
                                e.printStackTrace();
                                display.setCurrent(new Alert ("error", "can't open file [5]:"  + e.toString(), null, null), tbSource);
                            }
                        }
                    }.start();
                }
            }
        }
        else if (d == tbFileName)
        {
            if (c == CMD_SAVE)
            {
                System.out.println ("save to " + curPath + tbFileName.getString());
                new Thread ()
                {
                    public void run()
                    {
                        try
                        {
                            FileSystem fs = FileSystem.GetInstance();
                            FilePtr f = fs.Open(curPath + tbFileName.getString(), FileSystem.WRITE);
                            byte[] curCode = null;
                            if (smode == 1)
                                curCode = tbSource.getString().getBytes();
                            else if (smode == 2)
                                curCode = bytecode;
                            f.Write(curCode, 0, curCode.length);
                            f.Close();
                            display.setCurrent(tbSource);
                            lsFs.append(tbFileName.getString(), null);
                        }
                        catch (Exception e)
                        {
                            System.out.println ("save:"+curPath + tbFileName.getString());
                            e.printStackTrace();
                            display.setCurrent(new Alert ("error", "can't open file:" + e.toString(), null, null), tbSource);
                        }
                    }
                }.start();
            }
            else if (c == CMD_SAVE_BYTECODE)
            {

            }
            else if (c == CMD_CANCEL)
            {
                display.setCurrent(tbSource);
            }
        }
        else if (d == tbText)
        {
            if (c == CMD_OK)
            {
                display.setCurrent(tbSource);
                tbSource.insertString(tbText.getString());
            }
        }
        else if (c == CMD_COMPILE)
        {
            bCanRun = true;
            bytecode = null;
            bcmode = 0;
            try
            {
            	long time=System.currentTimeMillis();
                f.deleteAll();
                //display.setCurrent(f);
                tbSource.setTitle("parsing...");
                f.append("parsing...\n");
                //InputStream is = new Object().getClass().getResourceAsStream("/test.jcc");
                Jcc2Parser parser = new Jcc2Parser (new ByteArrayInputStream(tbSource.getString().getBytes()));
                tbSource.setTitle("done parsing");
                f.append("done parsing\n");
                tbSource.setTitle("compiling...");
                f.append("compiling...\n");
//                parser.enable_tracing();
                ASTCompilationUnit unit = parser.CompilationUnit();
//                unit.dump("");
                Compiler compiler = new Compiler(unit, false);
                bytecode = compiler.code;
                tbSource.setTitle("done");
                f.append("done\n");
                tbSource.setTitle("time : "+(System.currentTimeMillis()-time)+"ms.");
                new Thread() {

                    public void run() {
                        try {
                            sleep(2000);
                        } catch (Exception e) {
                        } finally {
                            tbSource.setTitle("Jcc v" + getAppProperty("MIDlet-Version"));
                        }
                    }
                }.start();
                //is.close ();
            }
            catch (Exception e)
            {
                f.append(e.toString());
                e.printStackTrace();
                display.setCurrent(f);
                tbSource.setTitle("Jcc v"+getAppProperty("MIDlet-Version"));
            }
        }
        else if (c == CMD_COMPILE_JASMIN)
        {
            bCanRun = false;
            bytecode = null;
            bcmode = 1;
            try
            {
                long time=System.currentTimeMillis();
                f.deleteAll();
                //display.setCurrent(f);
                tbSource.setTitle("parsing...");
                f.append("parsing...\n");
                //InputStream is = new Object().getClass().getResourceAsStream("/test.jcc");
                Jcc2Parser parser = new Jcc2Parser (new ByteArrayInputStream(tbSource.getString().getBytes()));
                tbSource.setTitle("done parsing");
                f.append("done parsing\n");
                tbSource.setTitle("compiling...");
                f.append("compiling...\n");
//                parser.enable_tracing();
                ASTCompilationUnit unit = parser.CompilationUnit();
//                unit.dump("");
                Compiler compiler = new Compiler(unit, true);
                bytecode = compiler.code;
                tbSource.setTitle("done");
                f.append("done\n");
                tbSource.setTitle("time : "+(System.currentTimeMillis()-time)+"ms.");
                new Thread() {

                    public void run() {
                        try {
                            sleep(2000);
                        } catch (Exception e) {
                        } finally {
                            tbSource.setTitle("Jcc v" + getAppProperty("MIDlet-Version"));
                        }
                    }
                }.start();
                //is.close ();
            }
            catch (Exception e)
            {
                f.append(e.toString());
                e.printStackTrace();
                display.setCurrent(f);
                tbSource.setTitle("Jcc v"+getAppProperty("MIDlet-Version"));
            }
        }
        else if (c == CMD_RUN)
        {
            display.setCurrent(f);
            if (bytecode != null && bCanRun)
            {
                new Thread () {
                    public void run ()
                    {
                        try
                        {
                            f.deleteAll();
                            tbSource.setTitle("Jcc v"+getAppProperty("MIDlet-Version"));
//                            f.append("running...\n");
                            vm = new JccRuntime(bytecode);
                            vm.startApp("main()V");
                            display.setCurrent(f);
                        }
                        catch (Exception e)
                        {
                            e.printStackTrace();
                            f.append(e.toString());
                            display.setCurrent(f);
                        }
                    }
                }.start ();
            }
            else if (!bCanRun)
            {
                f.append("Compiled to Jasmin assemble");
            }
            else
            {
                f.append("No bytecode\n");
            }
        }
        else if (c == CMD_LOAD_TEST)
        {
            display.setCurrent(lSamples);
        }
        else if (c == List.SELECT_COMMAND && d == lSamples) {
            int ind = lSamples.getSelectedIndex();
            samples.deleteAll();
            if (ind > 0) {
              Vector vtmp = new Vector();
              String stmp = lSamples.getString(ind);
              vtmp = (Vector)samlibs.get(stmp.substring(0, stmp.indexOf(' ')));
              for (int i = 0; i < vtmp.size(); i++)
                samples.append((String)vtmp.elementAt(i), null);
            } else if (ind == 0) {
              for (int i = 0; i < vSamples.length; i++)
                samples.append(vSamples[i][0], null);
            }
            display.setCurrent(samples);
          }
          else if (c == List.SELECT_COMMAND && d == samples)
          {
            int ind = samples.getSelectedIndex();
            if (ind >= 0)
            {
              try
              {
                String s = loadTxt("/res/tests/" + (String)hSamples.get(samples.getString(ind)));
                tbSource.setString(s);
                display.setCurrent(tbSource);
              }
              catch (Exception e)
              {
                e.printStackTrace();
                display.setCurrent(new Alert("error", "can't open file:" + e.toString(), null, null), tbSource);
              }
            }
          }
          else if (c == List.SELECT_COMMAND && d == infoList) {
              if (currentInfo == 0){
                currentInfoListString = infoList.getString(infoList.getSelectedIndex());
              }
              showInfo(++currentInfo);
        } 
        else if (c == CMD_RETURN && d == samples) {
             display.setCurrent(lSamples);
        }
        else if (c == CMD_RETURN && (d == fInfo || d == infoList)) {
          showInfo(--currentInfo);
        }
        else if (c == CMD_RETURN)
        {
          //bytecode = null;
          if (vm != null)
          {
            vm.stop();
          }
          f.deleteAll();
          display.setCurrent(tbSource);
        }
        else if (c == CMD_EDITOR_SETTINGS)
        {
        	tbSource.showSettings();
        }
        else if (c == CMD_INFO) {
        	showInfo(0);
        }
        else if (c == CMD_EXIT)
        {
            destroyApp (false);
        }
        else if (c == CMD_SAVE_SRC)
        {
            saveSource ();
        }
        else if (c == CMD_LOAD_SRC)
        {
            loadSource ();
        }
        else if (c == CMD_SAVE_BYTECODE)
        {
            saveBytecode ();
        }
        else if (c == CMD_EDIT)
        {
            String s = tbSource.getSelectedString();
            tbText.setString(s);
            display.setCurrent(tbText);
        }
    }

    
    private String loadTxt (String src) throws IOException
    {
        InputStream is = new Object().getClass().getResourceAsStream(src);
        String s = "";
        if (is != null)
        {
            int ch=0;
            while (ch != -1)
            {
                ch = is.read();
                if (ch != -1)
                    s += (char)ch;
                else
                    break;
            }
            is.close ();
        }
        return s;
    }

    public void startApp ()
    {
    }

    public void pauseApp ()
    {
    }

    public void destroyApp (boolean unconditional)
    {
        notifyDestroyed ();
    }

    public void loadSource ()
    {
        lsFs.removeCommand(CMD_SAVE);
        lsFs.addCommand(CMD_LOAD);
        lsFs.setTitle("Files");
        if (!curPath.equals("/"))
            curPath = curPath.substring(0, curPath.lastIndexOf('/') + 1);
        mode = 1;
        display.setCurrent(lsFs);
        new Thread()
        {
            public void run()
            {
                try
                {
                  if(curPath.equals("/")){
                    String[] vs = fs.List(curPath);
                    lsFs.deleteAll();
                    if (!curPath.equals("/"))
                        lsFs.append("../", null);
                    for (int i = 0; i < vs.length; i++)
                    {
                        lsFs.append(vs[i], null);
                    }
                  }
                    lsFs.setTitle("Files");
                }
                catch (Exception e)
                {
                    e.printStackTrace();
                    display.setCurrent(new Alert ("error", "can't list dir:" + e.toString(), null, null), tbSource);
                }
            }
        }.start ();
    }

    public void saveSource ()
    {
        smode = 1;
        mode = 2;
        lsFs.removeCommand(CMD_LOAD);
        lsFs.removeCommand(CMD_SAVE_BYTECODE);
        lsFs.addCommand(CMD_SAVE);
        lsFs.setTitle("Files");
        if (!curPath.equals("/"))
            curPath = curPath.substring(0, curPath.lastIndexOf('/') + 1);
        display.setCurrent(lsFs);
        new Thread()
        {
            public void run()
            {
                try
                {
                  if(curPath.equals("/")){
                    String[] vs = fs.List(curPath);
                    lsFs.deleteAll();
                    if (!curPath.equals("/"))
                        lsFs.append("../", null);
                    for (int i = 0; i < vs.length; i++)
                    {
                        lsFs.append(vs[i], null);
                    }
                  }
                    lsFs.setTitle("Files");
                }
                catch (Exception e)
                {
                    e.printStackTrace();
                    display.setCurrent(new Alert ("error", "can't list dir:" + e.toString(), null, null), tbSource);
                }
            }
        }.start ();
    }

    public void saveBytecode ()
    {
        smode = 2;
        mode = 2;
        lsFs.removeCommand(CMD_LOAD);
        lsFs.removeCommand(CMD_SAVE);
        lsFs.addCommand(CMD_SAVE_BYTECODE);
        lsFs.setTitle("Files");
        if (!curPath.equals("/"))
            curPath = curPath.substring(0, curPath.lastIndexOf('/') + 1);
        display.setCurrent(lsFs);
        new Thread()
        {
            public void run()
            {
                try
                {
                  if(curPath.equals("/")){
                    String[] vs = fs.List(curPath);
                    lsFs.deleteAll();
                    if (!curPath.equals("/"))
                        lsFs.append("../", null);
                    for (int i = 0; i < vs.length; i++)
                    {
                        lsFs.append(vs[i], null);
                    }
                  }
                    lsFs.setTitle("Files");
                }
                catch (Exception e)
                {
                    e.printStackTrace();
                    display.setCurrent(new Alert ("error", "can't list dir:" + e.toString(), null, null), tbSource);
                }
            }
        }.start ();
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    // Load example's list
    public void loadTestsList(String path)
    {
      String str = null;
      int from = 0, to = 0;
      char c = ' ';
      int count = 0;
      try
      {
        str = loadTxt(path);
      } catch (Exception localException) { }
      for (int i = 0; i < str.length(); i++) {
        c = str.charAt(i);
        if (c == '"') {
          count++;
        }
      }
      count /= 4;
      vSamples = new String[count][2];

      for (int i = 0; i < count; i++)
        for (int j = 0; j < 2; j++) {
          from = str.indexOf('"', to + 1);
          to = str.indexOf('"', from + 1);
          vSamples[i][j] = str.substring(from + 1, to);
        }
    }
    
    
    // load categories of example's list
    public void loadTests()
    {
      String[] libs = null;
      String tmp = null;
      int size = 0;

      for (int i = 0; i < vSamples.length; i++) {
        libs = getTestLibs(vSamples[i][1]);
        for (int j = 0; j < libs.length; j++) {
          if (samlibs.containsKey(libs[j])) {
            ((Vector)samlibs.get(libs[j])).addElement(vSamples[i][0]);
          } else {
            samlibs.put(libs[j], new Vector());
            ((Vector)samlibs.get(libs[j])).addElement(vSamples[i][0]);
            usedlibs.addElement(libs[j]);
          }
        }
      }
      
      lSamples.append("All (" + vSamples.length + ")", null);
      for (int i = 0; i < usedlibs.size(); i++) {
        tmp = (String)usedlibs.elementAt(i);
        size = ((Vector)samlibs.get(tmp)).size();
        lSamples.append(tmp + " (" + size + ")", null);
      }
    }
      
    
    // get list of libraries from example test
    public String[] getTestLibs(String name)
    {
      InputStream is = null;
      StringBuffer sb = null;
      int b = 0;
      
      try
      {
        is = getClass().getResourceAsStream("/res/tests/" + name);
        sb = new StringBuffer();
        while ((b = is.read()) != -1) {
          if ((sb.length() > 0) && (sb.charAt(sb.length() - 1) == '\n') && (b != 10) && (b != 'u') && (b != ' '))
            break;
          sb.append((char)b);
        }
        b = 0;
      } catch (Exception e) {
        e.printStackTrace();
      }

      String[] tmp = new String[30];
      int from = 0; int to = 0;
      while (to != sb.length() - 1) {
        to = sb.toString().indexOf('\n', from);
        if (to == -1)
          to = sb.length() - 1;
        if (to != from) {
          tmp[b] = sb.toString().substring(from, to);
          b++;
        }
        from = to + 1;
      }

      String[] ret = new String[b];
      for (int i = 0; i < b; i++) {
        ret[i] = tmp[i].substring(tmp[i].indexOf("use") + 4, tmp[i].length() - 1);
      }
      return ret;
    }
    
    
    
    // show information about lib's part (lib, class, methods)
    public void showInfo(int num)
    {
      //System.out.println(num);
      if (num < 0) {
        display.setCurrent(tbSource);
        return;
      }
      switch (num)
      {
	      case LIBS_INFO:		// display libs list
	      {
	        infoList.deleteAll();
	        String stmp = null;
	        int from = 0, to = 0;
	        try {
	          stmp = loadTxt("/res/LIBS.list");
	        } catch (Exception exc) {
	        	exc.printStackTrace();
	        }
	        while (to != stmp.length()-1) {
	          to = stmp.indexOf('\n', from);
	          infoList.append(stmp.substring(from, to), null);
	          from = to + 1;
	        }
	        display.setCurrent(infoList);
	        currentInfo = LIBS_INFO;
	        break;
	      }
	      case CLASSES_INFO:	// display classes list
	      {
	        infoList.deleteAll();
	        Enumeration enu = null;
	        ClassContainer cctmp = null;
	        try {
	          getClass();
	          lbr = ((Library)Class.forName("jcc2.lib." + currentInfoListString + ".library").newInstance());
	          lbr.init(true);
	        } catch (Exception e) {
	          e.printStackTrace();
	          return;
	        }
	        infoList.append("Lib methods", null);
	        enu = lbr.ctGetAllClasses();
	        while (enu.hasMoreElements()) {
	          cctmp = (ClassContainer)enu.nextElement();
	          infoList.append(cctmp.name, null);
	        }
	        display.setCurrent(infoList);
	        currentInfo = CLASSES_INFO;
	        break;
	      }
	      case INFO_INFO:		// display list of the class's content 
	      {
	        int indx = infoList.getSelectedIndex();
	        ClassContainer cctmp = null;
	        MethodContainer mctmp = null;
	        Enumeration methods = null;
	        String stmp = null;
	        if (indx != 0) {
	          cctmp = lbr.ctGetClass(infoList.getString(indx));
	          methods = cctmp.htMethods.elements();
	        } else {
	          methods = lbr.ctGetAllMethods();
	        }
	
	        fInfo.deleteAll();
	        while (methods.hasMoreElements()) {
	          mctmp = (MethodContainer)methods.nextElement();
	          stmp = getStringType(mctmp.ret) + " ";
	          if (mctmp.name == "<init>")
	            stmp = cctmp.name;
	          else
	            stmp = stmp + mctmp.name;
	          stmp = stmp + "(";
	          for (int i = 0; i < mctmp.args.length; i++) {
	            stmp = stmp + getStringType(mctmp.args[i]);
	            if (i < mctmp.args.length - 1)
	              stmp = stmp + ", ";
	          }
	          stmp = stmp + "); \n";
	
	          if (mctmp.name == "<init>")
	            fInfo.insert(0, new StringItem(stmp, null));
	          else
	            fInfo.append(stmp);
	        }
	        display.setCurrent(fInfo);
	        break;
	      }
      }
    }

    
    // get String type
    public String getStringType(Type tp)
    {
      String ret = null;
      ret = (String)htTypes.get(tp);
      if (ret == null) {
        ret = tp.object.name;
        if (tp.arrayDepth != 0)
          for (int i = 0; i < tp.arrayDepth; i++)
            ret = ret + "[]";
      }
      if (ret == null)
        ret = "null";
      return ret;
    }

    
    
    
}
