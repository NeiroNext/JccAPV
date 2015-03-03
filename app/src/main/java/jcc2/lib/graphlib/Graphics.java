/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package jcc2.lib.graphlib;

import jcc2.common.ClassContainer;
import jcc2.common.MethodContainer;
import jcc2.common.Type;
import jcc2.lib.RTObject;
import javax.microedition.lcdui.Font;;

/**
 *
 * @author note173@gmail.com
 */

public class Graphics extends RTObject
{
    static ClassContainer ctClass = null;
    static boolean bInit = false;
    javax.microedition.lcdui.Graphics graphics;

    public Graphics ()
    {
    }

    public static ClassContainer getClassContainer ()
    {
        if (ctClass != null)
            return ctClass;

        ClassContainer container = new ClassContainer ("Graphics");
        container.className = "jcc2/lib/graphlib/Graphics";
        ctClass = container;
        return ctClass;
    }

    public static void initClassContainer ()
    {
        if (bInit)
            return;
        bInit = true;
        ClassContainer container = getClassContainer ();
        container.addStatic("BASELINE", new Integer(javax.microedition.lcdui.Graphics.BASELINE), Type.TYPE_INT);
        container.addStatic("BOTTOM", new Integer(javax.microedition.lcdui.Graphics.BOTTOM), Type.TYPE_INT);
        container.addStatic("DOTTED", new Integer(javax.microedition.lcdui.Graphics.DOTTED), Type.TYPE_INT);
        container.addStatic("HCENTER", new Integer(javax.microedition.lcdui.Graphics.HCENTER), Type.TYPE_INT);
        container.addStatic("LEFT", new Integer(javax.microedition.lcdui.Graphics.LEFT), Type.TYPE_INT);
        container.addStatic("RIGHT", new Integer(javax.microedition.lcdui.Graphics.RIGHT), Type.TYPE_INT);
        container.addStatic("SOLID", new Integer(javax.microedition.lcdui.Graphics.SOLID), Type.TYPE_INT);
        container.addStatic("TOP", new Integer(javax.microedition.lcdui.Graphics.TOP), Type.TYPE_INT);
        container.addStatic("VCENTER", new Integer(javax.microedition.lcdui.Graphics.VCENTER), Type.TYPE_INT);
        
        //	Font constants
        container.addStatic("FACE_SYSTEM", new Integer(Font.FACE_SYSTEM), Type.TYPE_INT);
        container.addStatic("FACE_MONOSPACE ", new Integer(Font.FACE_MONOSPACE), Type.TYPE_INT);
        container.addStatic("FACE_PROPORTIONAL", new Integer(Font.FACE_PROPORTIONAL), Type.TYPE_INT);
        container.addStatic("STYLE_PLAIN", new Integer(Font.STYLE_PLAIN), Type.TYPE_INT);
        container.addStatic("STYLE_BOLD", new Integer(Font.STYLE_BOLD), Type.TYPE_INT);
        container.addStatic("STYLE_ITALIC", new Integer(Font.STYLE_ITALIC), Type.TYPE_INT);
        container.addStatic("STYLE_UNDERLINED", new Integer(Font.STYLE_UNDERLINED), Type.TYPE_INT);
        container.addStatic("SIZE_SMALL", new Integer(Font.SIZE_SMALL), Type.TYPE_INT);
        container.addStatic("SIZE_MEDIUM", new Integer(Font.SIZE_MEDIUM), Type.TYPE_INT);
        container.addStatic("SIZE_LARGE", new Integer(Font.SIZE_LARGE), Type.TYPE_INT);
        

        Type[] args;
        MethodContainer method;
        int mid = 0;

        args = new Type[7];
        args[0] = Type.TYPE_INT;
        args[1] = Type.TYPE_INT;
        args[2] = Type.TYPE_INT;
        args[3] = Type.TYPE_INT;
        args[4] = Type.TYPE_INT;
        args[5] = Type.TYPE_INT;
        args[6] = Type.TYPE_INT;
        method = new MethodContainer ("copyArea", Type.TYPE_VOID, args, null, mid++);
        container.addMethod(method);

        args = new Type[6];
        args[0] = Type.TYPE_INT;
        args[1] = Type.TYPE_INT;
        args[2] = Type.TYPE_INT;
        args[3] = Type.TYPE_INT;
        args[4] = Type.TYPE_INT;
        args[5] = Type.TYPE_INT;
        method = new MethodContainer ("drawArc", Type.TYPE_VOID, args, null, mid++);
        container.addMethod(method);

        args = new Type[4];
        args[0] = Type.TYPE_CHAR;
        args[1] = Type.TYPE_INT;
        args[2] = Type.TYPE_INT;
        args[3] = Type.TYPE_INT;
        method = new MethodContainer ("drawChar", Type.TYPE_VOID, args, null, mid++);
        container.addMethod(method);

        args = new Type[6];
        args[0] = Type.TYPE_ACHAR;
        args[1] = Type.TYPE_INT;
        args[2] = Type.TYPE_INT;
        args[3] = Type.TYPE_INT;
        args[4] = Type.TYPE_INT;
        args[5] = Type.TYPE_INT;
        method = new MethodContainer ("drawChars", Type.TYPE_VOID, args, null, mid++);
        container.addMethod(method);

        args = new Type[4];
        args[0] = new Type (Image.getClassContainer(), 0);
        args[1] = Type.TYPE_INT;
        args[2] = Type.TYPE_INT;
        args[3] = Type.TYPE_INT;
        method = new MethodContainer ("drawImage", Type.TYPE_VOID, args, null, mid++);
        container.addMethod(method);

        args = new Type[4];
        args[0] = Type.TYPE_INT;
        args[1] = Type.TYPE_INT;
        args[2] = Type.TYPE_INT;
        args[3] = Type.TYPE_INT;
        method = new MethodContainer ("drawLine", Type.TYPE_VOID, args, null, mid++);
        container.addMethod(method);

        args = new Type[4];
        args[0] = Type.TYPE_INT;
        args[1] = Type.TYPE_INT;
        args[2] = Type.TYPE_INT;
        args[3] = Type.TYPE_INT;
        method = new MethodContainer ("drawRect", Type.TYPE_VOID, args, null, mid++);
        container.addMethod(method);

        args = new Type[8];
        args[0] = Type.TYPE_AINT;
        args[1] = Type.TYPE_INT;
        args[2] = Type.TYPE_INT;
        args[3] = Type.TYPE_INT;
        args[4] = Type.TYPE_INT;
        args[5] = Type.TYPE_INT;
        args[6] = Type.TYPE_INT;
        args[7] = Type.TYPE_BOOL;
        method = new MethodContainer ("drawRGB", Type.TYPE_VOID, args, null, mid++);
        container.addMethod(method);

        args = new Type[6];
        args[0] = Type.TYPE_INT;
        args[1] = Type.TYPE_INT;
        args[2] = Type.TYPE_INT;
        args[3] = Type.TYPE_INT;
        args[4] = Type.TYPE_INT;
        args[5] = Type.TYPE_INT;
        method = new MethodContainer ("drawRoundRect", Type.TYPE_VOID, args, null, mid++);
        container.addMethod(method);

        args = new Type[4];
        args[0] = Type.TYPE_STRING;
        args[1] = Type.TYPE_INT;
        args[2] = Type.TYPE_INT;
        args[3] = Type.TYPE_INT;
        method = new MethodContainer ("drawString", Type.TYPE_VOID, args, null, mid++);
        container.addMethod(method);

        args = new Type[6];
        args[0] = Type.TYPE_STRING;
        args[1] = Type.TYPE_INT;
        args[2] = Type.TYPE_INT;
        args[3] = Type.TYPE_INT;
        args[4] = Type.TYPE_INT;
        args[5] = Type.TYPE_INT;
        method = new MethodContainer ("drawSubstring", Type.TYPE_VOID, args, null, mid++);
        container.addMethod(method);

        args = new Type[6];
        args[0] = Type.TYPE_INT;
        args[1] = Type.TYPE_INT;
        args[2] = Type.TYPE_INT;
        args[3] = Type.TYPE_INT;
        args[4] = Type.TYPE_INT;
        args[5] = Type.TYPE_INT;
        method = new MethodContainer ("fillArc", Type.TYPE_VOID, args, null, mid++);
        container.addMethod(method);

        args = new Type[4];
        args[0] = Type.TYPE_INT;
        args[1] = Type.TYPE_INT;
        args[2] = Type.TYPE_INT;
        args[3] = Type.TYPE_INT;
        method = new MethodContainer ("fillRect", Type.TYPE_VOID, args, null, mid++);
        container.addMethod(method);

        args = new Type[6];
        args[0] = Type.TYPE_INT;
        args[1] = Type.TYPE_INT;
        args[2] = Type.TYPE_INT;
        args[3] = Type.TYPE_INT;
        args[4] = Type.TYPE_INT;
        args[5] = Type.TYPE_INT;
        method = new MethodContainer ("fillRoundRect", Type.TYPE_VOID, args, null, mid++);
        container.addMethod(method);

        args = new Type[6];
        args[0] = Type.TYPE_INT;
        args[1] = Type.TYPE_INT;
        args[2] = Type.TYPE_INT;
        args[3] = Type.TYPE_INT;
        args[4] = Type.TYPE_INT;
        args[5] = Type.TYPE_INT;
        method = new MethodContainer ("fillTriangle", Type.TYPE_VOID, args, null, mid++);
        container.addMethod(method);

        args = new Type[0];
        method = new MethodContainer ("getBlueComponent", Type.TYPE_INT, args, null, mid++);
        container.addMethod(method);

        args = new Type[0];
        method = new MethodContainer ("getClipHeight", Type.TYPE_INT, args, null, mid++);
        container.addMethod(method);

        args = new Type[0];
        method = new MethodContainer ("getClipWidth", Type.TYPE_INT, args, null, mid++);
        container.addMethod(method);

        args = new Type[0];
        method = new MethodContainer ("getClipX", Type.TYPE_INT, args, null, mid++);
        container.addMethod(method);

        args = new Type[0];
        method = new MethodContainer ("getClipY", Type.TYPE_INT, args, null, mid++);
        container.addMethod(method);

        args = new Type[0];
        method = new MethodContainer ("getColor", Type.TYPE_INT, args, null, mid++);
        container.addMethod(method);

        args = new Type[0];
        method = new MethodContainer ("getGreenComponent", Type.TYPE_INT, args, null, mid++);
        container.addMethod(method);

        args = new Type[0];
        method = new MethodContainer ("getRedComponent", Type.TYPE_INT, args, null, mid++);
        container.addMethod(method);

        args = new Type[0];
        method = new MethodContainer ("getStrokeStyle", Type.TYPE_INT, args, null, mid++);
        container.addMethod(method);

        args = new Type[0];
        method = new MethodContainer ("getTranslateX", Type.TYPE_INT, args, null, mid++);
        container.addMethod(method);

        args = new Type[0];
        method = new MethodContainer ("getTranslateY", Type.TYPE_INT, args, null, mid++);
        container.addMethod(method);

        args = new Type[4];
        args[0] = Type.TYPE_INT;
        args[1] = Type.TYPE_INT;
        args[2] = Type.TYPE_INT;
        args[3] = Type.TYPE_INT;
        method = new MethodContainer ("setClip", Type.TYPE_VOID, args, null, mid++);
        container.addMethod(method);

        args = new Type[1];
        args[0] = Type.TYPE_INT;
        method = new MethodContainer ("setColor", Type.TYPE_VOID, args, null, mid++);
        container.addMethod(method);

        args = new Type[3];
        args[0] = Type.TYPE_INT;
        args[1] = Type.TYPE_INT;
        args[2] = Type.TYPE_INT;
        method = new MethodContainer ("setColor", Type.TYPE_VOID, args, null, mid++);
        container.addMethod(method);

        args = new Type[1];
        args[0] = Type.TYPE_INT;
        method = new MethodContainer ("setStrokeStyle", Type.TYPE_VOID, args, null, mid++);
        container.addMethod(method);

        args = new Type[2];
        args[0] = Type.TYPE_INT;
        args[1] = Type.TYPE_INT;
        method = new MethodContainer ("translate", Type.TYPE_VOID, args, null, mid++);
        container.addMethod(method);
        
        args = new Type[3];
        args[0] = Type.TYPE_INT;
        args[1] = Type.TYPE_INT;
        args[2] = Type.TYPE_INT;
        method = new MethodContainer("setFont", Type.TYPE_VOID, args, null, mid++);
        container.addMethod(method);

        args = new Type[1];
        args[0] = Type.TYPE_STRING;
        method = new MethodContainer("stringWidth", Type.TYPE_INT, args, null, mid++);
        container.addMethod(method);

        args = new Type[0];
        method = new MethodContainer("stringHeight", Type.TYPE_INT, args, null, mid++);
        container.addMethod(method);

        args = new Type[0];
        method = new MethodContainer("cls", Type.TYPE_VOID, args, null, mid++);
        container.addMethod(method);
        
        args = new Type[1];
        args[0] = Type.TYPE_INT;
        method = new MethodContainer("cls", Type.TYPE_VOID, args, null, mid++);
        container.addMethod(method);
        
    }

    public Object rtInvoke (int iMethod, Object[] args) throws Exception
    {
        switch (iMethod)
        {
            case 0: //copyArea
            {
                copyArea(((int[])args[0])[0], ((int[])args[1])[0], ((int[])args[2])[0], ((int[])args[3])[0],
                        ((int[])args[4])[0], ((int[])args[5])[0], ((int[])args[6])[0]);
                return Type.TYPE_VOID;
            }
            case 1: //drawArc
            {
                drawArc(((int[])args[0])[0], ((int[])args[1])[0], ((int[])args[2])[0], ((int[])args[3])[0],
                        ((int[])args[4])[0], ((int[])args[5])[0]);
                return Type.TYPE_VOID;
            }
            case 2: //drawChar
            {
                drawChar((char)((int[])args[0])[0], ((int[])args[1])[0], ((int[])args[2])[0], ((int[])args[3])[0]);
                return Type.TYPE_VOID;
            }
            case 3: //drawChars
            {
                drawChars((char[])((Object[])args[0])[0], ((int[])args[1])[0], ((int[])args[2])[0], ((int[])args[3])[0],
                        ((int[])args[4])[0], ((int[])args[5])[0]);
                return Type.TYPE_VOID;
            }
            case 4: //drawImage
            {
                drawImage ((Image)(args[0]), ((int[])args[1])[0], ((int[])args[2])[0], ((int[])args[3])[0]);
                return Type.TYPE_VOID;
            }
            case 5: //drawLine
            {
                drawLine(((int[])args[0])[0], ((int[])args[1])[0], ((int[])args[2])[0], ((int[])args[3])[0]);
                return Type.TYPE_VOID;
            }
            case 6: //drawRect
            {
                drawRect(((int[])args[0])[0], ((int[])args[1])[0], ((int[])args[2])[0], ((int[])args[3])[0]);
                return Type.TYPE_VOID;
            }
            case 7: //drawRGB
            {
                drawRGB((int[])((Object[])args[0])[0], ((int[])args[1])[0], ((int[])args[2])[0], ((int[])args[3])[0],
                        ((int[])args[4])[0], ((int[])args[5])[0], ((int[])args[6])[0], (((int[])args[7])[0]==0)?false:true);
                return Type.TYPE_VOID;
            }
            case 8: //drawRoundRect
            {
                drawRoundRect(((int[])args[0])[0], ((int[])args[1])[0], ((int[])args[2])[0], ((int[])args[3])[0],
                        ((int[])args[4])[0], ((int[])args[5])[0]);
                return Type.TYPE_VOID;
            }
            case 9: //drawString
            {
                drawString((String)(args[0]), ((int[])args[1])[0], ((int[])args[2])[0], ((int[])args[3])[0]);
                return Type.TYPE_VOID;
            }
            case 10: //drawSubstring
            {
                drawSubstring((String)(args[0]), ((int[])args[1])[0], ((int[])args[2])[0], ((int[])args[3])[0],
                        ((int[])args[4])[0], ((int[])args[5])[0]);
                return Type.TYPE_VOID;
            }
            case 11: //fillArc
            {
                fillArc(((int[])args[0])[0], ((int[])args[1])[0], ((int[])args[2])[0], ((int[])args[3])[0],
                        ((int[])args[4])[0], ((int[])args[5])[0]);
                return Type.TYPE_VOID;
            }
            case 12: //fillRect
            {
                fillRect(((int[])args[0])[0], ((int[])args[1])[0], ((int[])args[2])[0], ((int[])args[3])[0]);
                return Type.TYPE_VOID;
            }
            case 13: //fillRoundRect
            {
                fillRoundRect(((int[])args[0])[0], ((int[])args[1])[0], ((int[])args[2])[0], ((int[])args[3])[0],
                        ((int[])args[4])[0], ((int[])args[5])[0]);
                return Type.TYPE_VOID;
            }
            case 14: //fillTriangle
            {
                fillTriangle(((int[])args[0])[0], ((int[])args[1])[0], ((int[])args[2])[0], ((int[])args[3])[0],
                        ((int[])args[4])[0], ((int[])args[5])[0]);
                return Type.TYPE_VOID;
            }
            case 15: //getBlueComponent
            {
                int[] val = {getBlueComponent()};
                return val;
            }
            case 16: //getClipHeight
            {
                int[] val = {getClipHeight()};
                return val;
            }
            case 17: //getClipWidth
            {
                int[] val = {getClipWidth()};
                return val;
            }
            case 18: //getClipX
            {
                int[] val = {getClipX()};
                return val;
            }
            case 19: //getClipY
            {
                int[] val = {getClipY()};
                return val;
            }
            case 20: //getColor
            {
                int[] val = {getColor()};
                return val;
            }
            case 21: //getgGreenComponent
            {
                int[] val = {getGreenComponent()};
                return val;
            }
            case 22: //getRedComponent
            {
                int[] val = {getRedComponent()};
                return val;
            }
            case 23: //getStrokeStyle
            {
                int[] val = {getStrokeStyle()};
                return val;
            }
            case 24: //getTranslateX
            {
                int[] val = {getTranslateX()};
                return val;
            }
            case 25: //getTranslateY
            {
                int[] val = {getTranslateY()};
                return val;
            }
            case 26: //setClip
            {
                setClip(((int[])args[0])[0], ((int[])args[1])[0], ((int[])args[2])[0], ((int[])args[3])[0]);
                return Type.TYPE_VOID;
            }
            case 27: //setColor
            {
                setColor(((int[])args[0])[0]);
                return Type.TYPE_VOID;
            }
            case 28: //setColor
            {
                setColor(((int[])args[0])[0], ((int[])args[1])[0], ((int[])args[2])[0]);
                return Type.TYPE_VOID;
            }
            case 29: //setStrokeStyle
            {
                setStrokeStyle(((int[])args[0])[0]);
                return Type.TYPE_VOID;
            }
            case 30: //translate
            {
                translate(((int[])args[0])[0], ((int[])args[1])[0]);
                return Type.TYPE_VOID;
            }
            case 31: //	setFont(int, int, int)
            {
                setFont(((int[])args[0])[0], ((int[])args[1])[0], ((int[])args[2])[0]);
                return Type.TYPE_VOID;
            }
            case 32: //	stringWidth(String)
            {
                int[] ret = { stringWidth((String)args[0]) };
                return ret;
            }
            case 33: //	stringHeight(String)
            {
                int[] ret = { stringHeight() };
                return ret;
            }
            case 34: //	cls()
            {
                cls();
                return Type.TYPE_VOID;
            }
            case 35: //	cls(int)
            {
                cls(((int[])args[0])[0]);
                return Type.TYPE_VOID;
            }

            default:
                throw new Exception ("InputStream[" + iMethod + "]");
        }
    }

    
    
    
    
    
    
    
// ---------------------------- Methods ----------------------------------- //
    
    public void copyArea (int x_src, int y_src, int width, int height, int x_dest, int y_dest, int anchor)
    {
        graphics.copyArea(x_src, y_src, width, height, x_dest, y_dest, anchor);
    }

    public void drawArc (int x, int y, int width, int height, int startAngle, int endAngle)
    {
        graphics.drawArc(x, y, width, height, startAngle, endAngle);
    }

    public void drawChar (char c, int x, int y, int anchor)
    {
        graphics.drawChar(c, x, y, anchor);
    }

    public void drawChars (char[] chars, int offset, int length, int x, int y, int anchor)
    {
        graphics.drawChars(chars, offset, length, x, y, anchor);
    }

    public void drawImage (Image img, int x, int y, int anchor)
    {
        graphics.drawImage(img.img, x, y, anchor);
    }

    public void drawLine (int x1, int y1, int x2, int y2)
    {
        graphics.drawLine(x1, y1, x2, y2);
    }

    public void drawRect (int x, int y, int width, int heigth)
    {
        graphics.drawRect(x, y, width, heigth);
    }

    public void drawRGB (int[] rgb, int offset, int scanlen, int x, int y, int width, int height, boolean bAlpha)
    {
        graphics.drawRGB(rgb, offset, scanlen, x, y, width, height, bAlpha);
    }

    public void drawRoundRect (int x, int y, int width, int height, int arcWidth, int arcHeight)
    {
        graphics.drawRoundRect(x, y, width, height, arcWidth, arcHeight);
    }

    public void drawString (String s, int x, int y, int anchor)
    {
        graphics.drawString(s, x, y, anchor);
    }

    public void drawSubstring (String s, int offset, int len, int x, int y, int anchor)
    {
        graphics.drawSubstring(s, offset, len, x, y, anchor);
    }

    public void fillArc (int x, int y, int width, int height, int arcWidth, int arcHeight)
    {
        graphics.fillArc(x, y, width, height, arcHeight, arcHeight);
    }

    public void fillRect (int x, int y, int width, int height)
    {
        graphics.fillRect(x, y, width, height);
    }

    public void fillRoundRect (int x, int y, int width, int height, int arcWidth, int arcHeight)
    {
        graphics.fillRoundRect(x, y, width, height, arcWidth, arcHeight);
    }

    public void fillTriangle (int x1, int y1, int x2, int y2, int x3, int y3)
    {
        graphics.fillTriangle(x1, y1, x2, y2, x3, y3);
    }

    public int getBlueComponent ()
    {
        return graphics.getBlueComponent();
    }

    public int getClipHeight ()
    {
        return graphics.getClipHeight();
    }

    public int getClipWidth ()
    {
        return graphics.getClipWidth();
    }

    public int getClipX ()
    {
        return graphics.getClipX();
    }

    public int getClipY ()
    {
        return graphics.getClipY();
    }

    public int getColor ()
    {
        return graphics.getColor();
    }

    public int getGreenComponent ()
    {
        return graphics.getGreenComponent();
    }

    public int getRedComponent ()
    {
        return graphics.getRedComponent();
    }

    public int getStrokeStyle ()
    {
        return graphics.getStrokeStyle();
    }

    public int getTranslateX ()
    {
        return graphics.getTranslateX();
    }

    public int getTranslateY ()
    {
        return graphics.getTranslateY();
    }

    public void setClip (int x, int y, int width, int height)
    {
        graphics.setClip(x, y, width, height);
    }

    public void setColor (int rgb)
    {
        graphics.setColor(rgb);
    }

    public void setColor (int r, int g, int b)
    {
        graphics.setColor(r, g, b);
    }

    public void setStrokeStyle (int style)
    {
        graphics.setStrokeStyle(style);
    }

    public void translate (int x, int y)
    {
        graphics.translate(x, y);
    }
    
    public void setFont(int arg1, int arg2, int arg3) {
        Font f = Font.getFont(arg1, arg2, arg3);
        graphics.setFont(f);
    }

    public int stringWidth(String str) {
    	Font f = graphics.getFont();
    	return f.stringWidth(str);
    }

    public int stringHeight() {
    	return graphics.getFont().getHeight();
    }

    public void cls() {
    	graphics.fillRect(0, 0, graphics.getClipWidth(), graphics.getClipHeight());
    }
    
    public void cls(int color) {
    	graphics.setColor(color);
    	graphics.fillRect(0, 0, graphics.getClipWidth(), graphics.getClipHeight());
    }
      
}
