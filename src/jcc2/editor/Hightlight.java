package jcc2.editor;

import javax.microedition.lcdui.*;

/***
 * 
 * @author NeiroNext
 *
 */




public class Hightlight {

	final static int NUMBER = 0;
	final static int COMMENT = 1;
	final static int MULTI_COMMENT = 2;
	final static int TYPE = 3;
	final static int STRING = 4;
	final static int METHOD = 5;
	final static int MACROS = 6;
	final static int NON = 7;
	
	final  static String[] methods  = {"new", "if", "else", "for", "while", "true", "false", "null", "break"};
	final  static String[] types    = {"byte", "int", "long", "float", "double", "string", "bool"};
	final  static String   comment  = "//";
	final  static String[] multiCom = {"/*", "*/"};
	final  static int[]    colors   = {0xff00ff, 0x806080, 0x806080, 0xaa00ff, 0xaaaa00, 0x0000ff, 0x00aa00, 0x0};
	
	static int nowType = NON;
	
	public Hightlight() { }
	
	
	
	
	
	public static Image draw(String str, Font fnt){
		int width = fnt.stringWidth(str);
		width = (width > 0) ? width : 1;
		Image img = Image.createImage(width, fnt.getHeight());
		Graphics g = img.getGraphics();
		g.setFont(fnt);
		int indx = 0, len = 0, lastcolor = colors[nowType], nowX = 0;
		boolean change = false;
		int nowLen = 0;
		
		if(str.length() == 0)
			return img;
		
		for(int i=0; i <= str.length(); ++i){
			change = false;
			nowLen = 0;
			
			if(i == str.length()){
				change = true;
				len = i - indx;
				if(nowType == COMMENT)
					nowType = NON;
			} else
			if((nowLen=is(str, i, methods, true)) > 0){
				nowType = METHOD;
				change = true;
				len = i-indx;
			} else
			if((nowLen=is(str, i, types, true)) > 0){
				nowType = TYPE;
				change = true;
				len = i-indx;
			} else
			if(is(str, i, comment)){
				nowType = COMMENT;
				change = true;
				len = i-indx;
				i = str.length()-1;
			} else
			
			if(is(str, i, multiCom[0])){
				nowType = MULTI_COMMENT;
				change = true;
				len = i-indx;
			} else
			if(is(str, i, multiCom[1])){
				nowType = NON;
				change = true;
				len = i-indx + multiCom[1].length();
			} else
			if(str.charAt(i) == '\''){
				nowType = STRING;
				change = true;
				len = i - indx;
			}
			
				
			
			if(change){
				g.setColor(lastcolor);
				g.drawSubstring(str, indx, len, nowX, 0, 20);
				
				nowX += fnt.substringWidth(str, indx, len);
				indx += len;
				lastcolor = colors[nowType];
				
				if(nowLen > 0){
					g.setColor(lastcolor);
					g.drawSubstring(str, indx, nowLen, nowX, 0, 20);
					
					nowX += fnt.substringWidth(str, indx, nowLen);
					indx += nowLen;
					lastcolor = colors[NON];
					nowType = NON;
				}
			} // end change if
			
		}
		
		return null;
		
	}
	
	
	
	
	public static boolean is(String str, int from, String who){
		boolean ret = true;
		int indx = 0;
		
		if(str.length()-from < who.length())
			return false;
		
		for(int i = 0; i<who.length(); i++){
			if(str.charAt(indx+from) != who.charAt(indx)){
				ret = false;
				break;
			}
			indx ++;
		}	
		return ret;
	}
	
	public static int is(String str, int from, String[] who, boolean sep){
		int ret = 0;
		
		for(int i=0; i < who.length; i++){
			if(is(str, from, who[i])){
				if(sep){
					if(from-1 >= 0)
						if(nonSep(str.charAt(from-1))){
							continue;
					}
					if(from+who[i].length() < str.length())
						if(nonSep(str.charAt(from+who[i].length()))){
							continue;
					}
				}
				ret = who[i].length();
			}
		}
				
		return ret;
	}
	
	
	public static boolean nonSep(char ch){
		return ((ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z') || (ch >= '0' && ch <= '9') || ch == '_');
	}

}
