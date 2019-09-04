package yt190409;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
public class byyl1 {
	static int i=0;
static char getch(String buffer){
	char c;
	c=buffer.charAt(i);
	i++;
	return c;
}
static boolean isletter(char c) {
	if ((('A'<=c) && (c <= 'Z'))|| ((c<='z')&&(c>='a')))
		return true;
	else return false;
}
static boolean isnumber(char c) {
	if ('0' <= c&&c <= '9')
		return true;
	else return false;
}
static boolean isoperator(char c) {
	if (c=='+'|| c == '-' || c == '*' || c == '/'||c== '='||c=='<'||c=='>')
		return true;
	else return false;
}
static boolean isresword(String c) {
	if (c.equals("int")||c.equals("main")|| c.equals("double")|| c.equals("float"))
		return true;
	else return false;
}
static boolean isborder(char c){
	if(c==','||c==';'||c=='('||c==')'||c=='{'||c=='}')
	   return true;
	else return false;
}
static void getoperator(String ope) {
	if (ope.equals("+"))
		System.out.println("plus  "+ope);
	if (ope.equals("-"))
		System.out.println("minus  "+ope);
	if (ope.equals("*"))
		System.out.println("times  "+ope);
	if (ope.equals("/"))
		System.out.println("slash  "+ope);
	if (ope.equals("="))
		System.out.println("eql  "+ope);
	if (ope.equals("<="))
		System.out.println("leq  "+ope);
	if (ope.equals(">="))
		System.out.println("geq  "+ope);
}
static void getresword(String resword) {
	if (resword.equals("int"))
		System.out.println("intsys  "+resword);
	if (resword.equals("double"))
		System.out.println("doublesys  "+resword);
	if (resword.equals("main"))
		System.out.println("mainsys  "+resword);
}
static void getborder(char border) {
	if (border==',')
		System.out.println("comma  "+border);
	if (border ==';')
		System.out.println("semicion  "+border);
	if (border=='{')
		System.out.println("lbparen  "+border);
	if (border=='}')
		System.out.println("rbparen  "+border);
	if (border=='(')
		System.out.println("lparen  "+border);
	if (border==')')
		System.out.println("rparen  "+border);
}
	public static BufferedReader buffer;
	public static void main(String[] args) throws IOException {
FileReader fr=new FileReader("D:\\360MoveData\\Users\\叶谈\\Desktop\\byyl\\demo.txt");
		     buffer = new BufferedReader(fr);
		     String line=new String();
		     String yt=new String();
		     while((line=buffer.readLine())!=null){
		     System.out.println(line);
		      yt=yt+line;
		     }
		     System.out.println(yt);
		     int count=yt.length();
		     System.out.println("文件中共有"+count+"个字符。");	
	 while (i < count) {
		char ch = getch(yt);
			while(ch ==' '|| ch=='\n') 
		{ ch = getch(yt); }
		if (isletter(ch)) 
		{
			int k = 0;
		    String a="";
			do{ 
				if (k < 10) {  a=a+String.valueOf(ch);k=k+1; ch = getch(yt); }
				else ch = getch(yt);
			} while (isletter(ch) || isnumber(ch));
				if (isresword(a))
				{ 
					getresword(a);
				i--;continue; }
				else {
					System.out.println("ident  "+String.valueOf(a)); 
					i--;
					continue;
					}
		}		
		else if (isnumber(ch)) 
		{
			String num=new String("");
			do{
				num = num + String.valueOf(ch);
				ch = getch(yt);
			} while (isnumber(ch));
			System.out.println("number  "+num);
			i--;
			continue;			
		}
		else if(isborder(ch))
		{
			getborder(ch);
			continue;
		}
		else if(isoperator(ch))
		{
			String ope=new String("");
			do {
				ope = ope +String.valueOf(ch);
				ch = getch(yt);
			} while (isoperator(ch));
			getoperator(ope);
			i--;
			continue;
		}	
	}
}
}




		


