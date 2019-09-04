package yt190409;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.Stack;
public class byyl21 {
	public static BufferedReader buffer;
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
	       //  System.out.println(ch1);
	         Stack<String> mystack=new Stack<String>();
	         for(int i=ch1.length()-1;i>=0;i--){
	        	 char m=ch1.charAt(i);
	        	 String x=String.valueOf(m);
	           mystack.add(x);
	         }
	         System.out.println("mystack:"+mystack);
	         Stack<String> dict=new Stack<String>();
	         dict.push("#");
	         dict.push("E");
	       //  System.out.println(dict.peek());
	         System.out.println("dictstack:"+dict);
	         int yt2=10000;
	      letter:   while(yt2>0){
	        	 yt2--;
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