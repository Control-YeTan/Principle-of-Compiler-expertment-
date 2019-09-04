package yt190409;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.Stack;
public class byyl211 {
	static int ii=0;
	public static BufferedReader buffer;
    static char getch(String buffer){
	char c;
	c=buffer.charAt(ii);
	ii++;
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
	public static boolean predict(Stack<String> a){
		if (a.peek().equals("(")||a.peek().equals(")")||a.peek().equals("+")
				||a.peek().equals("-")||a.peek().equals("*")||a.peek().equals("/"))
		{
		    return true;
		}
		else 
		{	return false;}
	}
	public static void main(String[] args)throws IOException {
		  FileReader fr=new FileReader("D:\\360MoveData\\Users\\叶谈\\Desktop\\byyl\\demo1.txt");
		     buffer = new BufferedReader(fr);
		     String[] yt=new String[121];
		     for(int i=0;i<121;i++)
		     {
		    	 yt[i]=buffer.readLine();
				// System.out.println(yt[i]); 
		     }
		     Scanner sc=new Scanner(System.in);
		     System.out.print("请输入一个字符串：");
	         String ch1=sc.next();
	         System.out.println(ch1);
	         String ch2="";        
	         int count=ch1.length();
	         System.out.println(count);
	         while(ii<count){
	        	 char ch=getch(ch1);
	        		if (isletter(ch)) 
	        		{        		    
	        			do{ 
	        				 ch = getch(ch1);
	        			} while (isletter(ch) || isnumber(ch));
	        					ch2=ch2+"i";
	        					ii--;
	        					continue;
	        					}
	        		else if (isnumber(ch)) 
	        		{
	        			do{
	        				ch = getch(ch1);
	        			} while (isnumber(ch));
	        		     ch2=ch2+"i";	
	        			ii--;
	        			continue;			
	        		}	
	        		else
	        		{ch2=ch2+String.valueOf(ch);
        			continue;}
	        		}
	         System.out.println(ch2);
	         Stack<String> mystack=new Stack<String>();
	         for(int i=ch2.length()-1;i>=0;i--){
	        	 char m=ch2.charAt(i);
	        	 String x=String.valueOf(m);
	           mystack.add(x);
	         }
	         System.out.println("mystack:"+mystack);
	         Stack<String> dict=new Stack<String>();
	         dict.push("#");
	         dict.push("E");
	       //  System.out.println(dict.peek());
	         System.out.println("dictstack:"+dict);
	      letter:   while(true){
	         for(int j=1;j<121;j=j+3)
	         {       	 
	         if(yt[j].equals(dict.peek())&&yt[j+1].equals(mystack.peek())&&yt[j+2].equals("NULL")==false&&
	        		 dict.peek().equals(mystack.peek())==false&&yt[j+2].equals("O")==false){
	        	 String yy=new StringBuffer(yt[j+2]).reverse().toString();
	        	// System.out.println(yy);
	        	 dict.pop();
	        	 for(int i=0;i<yy.length();i++){
	        	     char m=yy.charAt(i);
	        	     String x=String.valueOf(m);
	        		 dict.add(x);
	        		 //System.out.println("dictstack:"+dict);
	        	    }
	        	 System.out.println("---------------1---------------");
	        	 System.out.println("dictstack:"+dict);
	        	 System.out.println("mystack:"+mystack);
	        	 System.out.println("---------------1---end---------");
	        	          break; 
	                }
	         else if(dict.peek().equals(mystack.peek()))
	                {
	        	 dict.pop();
	        	 mystack.pop();
	        	 System.out.println("---------------2---------------");
	        	 System.out.println("dictstack:"+dict);
	        	 System.out.println("mystack:"+mystack);
	        	 System.out.println("---------------2---end---------");
	        	 if(dict.isEmpty()&&mystack.isEmpty())
	        	 {System.out.println("dictstack:"+dict);
	        		 System.out.println("分析完成！");
	        		 break letter;}
	         	 break;
	                }
	         else if(yt[j].equals(dict.peek())&&yt[j+1].equals(mystack.peek())&&
	        		 dict.peek().equals(mystack.peek())==false&&yt[j+2].equals("O")){
	        	 dict.pop();
	        	 System.out.println("---------------3---------------");
	        	 System.out.println("dictstack:"+dict);
	        	 System.out.println("mystack:"+mystack);
	        	 System.out.println("---------------3---end---------");
	        	 break;
	         }
	         else if(yt[j].equals(dict.peek())&&yt[j+1].equals(mystack.peek())&&yt[j+2].equals("NULL")){
	        	 System.out.println("字符串输入有误！");
	        	 System.out.println("此时的dictstack:"+dict);
	        	 System.out.println("此时的mystack:"+mystack);
	        	 break letter;
	         }
	         else if(predict(dict)==true&&predict(mystack)==false){
	        	 System.out.println("字符串输入有误！");
	        	 System.out.println("此时的dictstack:"+dict);
	        	 System.out.println("此时的mystack:"+mystack);
	        	 break letter;
	         }
	         else 
	            {
	        	 continue;
	            } 
	         }      
	          sc.close();      
	}
	         }
}