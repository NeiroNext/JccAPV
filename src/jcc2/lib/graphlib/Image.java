package jcc2.lib.graphlib;

import jcc2.common.ClassContainer;

/**
 *
 * @author note173@gmail.com
 */

import jcc2.common.MethodContainer;
import jcc2.common.Type;
import jcc2.lib.RTObject;

public class Image extends RTObject
{
    static ClassContainer ctClass = null;
    static boolean bInit = false;

    public javax.microedition.lcdui.Image img;

    public Image ()
    {
    }

    public Image (String s)
    {
        init (s);
    }
    
    public Image (jcc2.lib.iolib.InputStream is)
    {
        init (is);
    }
    
    public Image (int w, int h)
    {
        init (w, h);
    }
    
    public Image(byte[] b) {
        init(b);
    }

    public void init (String s)
    {
        try
        {
            img = javax.microedition.lcdui.Image.createImage(s);
        }
        catch (Exception e)
        {
            jcc2.lib.stdlib.library.singleton.setLastError(e.getMessage());
        }
    }

    public void init (jcc2.lib.iolib.InputStream is)
    {
        try {
            img = javax.microedition.lcdui.Image.createImage(is.is);
        }
        catch (Exception e){
            jcc2.lib.stdlib.library.singleton.setLastError(e.getMessage());
        }
    }

    public void init (int w, int h)
    {
        img = javax.microedition.lcdui.Image.createImage(w, h);
    }
    
    public void init(byte[] b) {
        img = javax.microedition.lcdui.Image.createImage(b, 0, b.length);
    }

    public static ClassContainer getClassContainer ()
    {
        if (ctClass != null)
            return ctClass;

        ClassContainer container = new ClassContainer ("Image");
        container.className = "jcc2/lib/graphlib/Image";
        ctClass = container;
        return ctClass;
    }

    public static void initClassContainer ()
    {
        if (bInit)
            return;
        bInit = true;
        ClassContainer container = getClassContainer ();
        Type[] args;
        MethodContainer method;
        int mid = 0;

        args = new Type[1];
        args[0] = Type.TYPE_STRING;
        method = new MethodContainer ("<init>", Type.TYPE_VOID, args, null, mid++);
        container.addMethod(method);

        args = new Type[1];
        args[0] = new Type (jcc2.lib.iolib.InputStream.getClassContainer(), 0);
        method = new MethodContainer ("<init>", Type.TYPE_VOID, args, null, mid++);
        container.addMethod(method);

        args = new Type[2];
        args[0] = Type.TYPE_INT;
        args[1] = Type.TYPE_INT;
        method = new MethodContainer ("<init>", Type.TYPE_VOID, args, null, mid++);
        container.addMethod(method);
        
        args = new Type[1];
        args[0] = Type.TYPE_ABYTE;
        method = new MethodContainer("<init>", Type.TYPE_VOID, args, null, mid++);
        container.addMethod(method);

        args = new Type[0];
        method = new MethodContainer ("getGraphics", new Type(Graphics.getClassContainer(), 0), args, null, mid++);
        container.addMethod(method);

        args = new Type[0];
        method = new MethodContainer ("getHeight", Type.TYPE_INT, args, null, mid++);
        container.addMethod(method);

        args = new Type[0];
        method = new MethodContainer ("getWidth", Type.TYPE_INT, args, null, mid++);
        container.addMethod(method);

        args = new Type[7];
        args[0] = Type.TYPE_AINT;
        args[1] = Type.TYPE_INT;
        args[2] = Type.TYPE_INT;
        args[3] = Type.TYPE_INT;
        args[4] = Type.TYPE_INT;
        args[5] = Type.TYPE_INT;
        args[6] = Type.TYPE_INT;
        method = new MethodContainer ("getRGB", Type.TYPE_VOID, args, null, mid++);
        container.addMethod(method);

        args = new Type[0];
        method = new MethodContainer ("isMutable", Type.TYPE_BOOL, args, null, mid++);
        container.addMethod(method);
    }

    public Object rtInvoke(int iMethod, Object[] args) throws Exception
    {
        switch (iMethod)
        {
            case 0: //<init>(String)
            {
                init ((String)(args[0]));
                return Type.TYPE_VOID;
            }
            case 1: //<init>(InputStream)
            {
                init ((jcc2.lib.iolib.InputStream)(args[0]));
                return Type.TYPE_VOID;
            }
            case 2: //<init>(int, int)
            {
                init (((int[])(args[0]))[0], ((int[])(args[1]))[0]);
                return Type.TYPE_VOID;
            }
            case 3: // <init>(byte[])
            {
                init((byte[])((Object[])args[0])[0]);
                return Type.TYPE_VOID;
            }
            case 4: //getGraphics
            {
                return getGraphics ();
            }
            case 5: //getHeight
            {
                int[] val = {getHeight()};
                return val;
            }
            case 6: //getWidth
            {
                int[] val = {getWidth()};
                return val;
            }
            case 7: //getRGB
            {
                getRGB((int[])((Object[])args[0])[0], ((int[])args[1])[0], ((int[])args[2])[0], ((int[])args[3])[0],
                        ((int[])args[4])[0], ((int[])args[5])[0], ((int[])args[6])[0]);
                return Type.TYPE_VOID;
            }
            case 8: //isMutable
            {
                int[] val = {(isMutable())?1:0};
                return val;
            }
            default:
                throw new Exception ("Image[" + iMethod + "]");
        }
    }

    
    
    
// ----------------------------- Methods --------------------------- //
    
    public Graphics getGraphics ()
    {
        Graphics graphics = new Graphics ();
        graphics.graphics = img.getGraphics();
        return graphics;
    }

    public int getHeight ()
    {
        return img.getHeight();
    }

    public int getWidth ()
    {
        return img.getWidth();
    }

    public void getRGB (int[] rgb, int offset, int scanlen, int x, int y, int width, int height)
    {
        img.getRGB(rgb, offset, scanlen, x, y, width, height);
    }

    public boolean isMutable ()
    {
        return img.isMutable();
    }
}
