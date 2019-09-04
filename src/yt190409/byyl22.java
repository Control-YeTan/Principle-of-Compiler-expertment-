package yt190409;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.Stack;
public class byyl22 {
	public static BufferedReader buffer;
	public static BufferedReader buffer1;
public static boolean is1fouroperators(Stack<String> a){
	if(a.peek().equals("+")||a.peek().equals("-")||a.peek().equals("*")||a.peek().equals("/"))
	{return true;}
	else return false;
}
public static boolean is2fouroperators(Stack<String> a){
	if(firstoperatorisnot1(a).equals("+")||firstoperatorisnot1(a).equals("-")||
			firstoperatorisnot1(a).equals("*")||firstoperatorisnot1(a).equals("/"))
	{return true;}
	else return false;
}
public static String firstoperator(Stack<String> a){
    for(int i=a.size()-1;i>=0;i--){
    	if(a.get(i).equals("i")||a.get(i).equals("+")||a.get(i).equals("-")
    			||a.get(i).equals("*")||a.get(i).equals("/")||a.get(i).equals("(")
    			||a.get(i).equals(")")||a.get(i).equals("#"))
    	{        
    		return a.get(i).toString(); 
    	}
    }
    	return "false";
}
public static String firstoperatoris1(Stack<String> a){
    for(int i=a.size()-1;i>=0;i--){
    	if((a.get(i).equals("i")||a.get(i).equals("+")||a.get(i).equals("-")
    			||a.get(i).equals("*")||a.get(i).equals("/")||a.get(i).equals("(")
    			||a.get(i).equals(")")||a.get(i).equals("#"))&&i==a.size()-1)
    	{        
    		return a.get(i).toString(); 
    	}
    }
    	return "false";
}
public static String firstoperatorisnot1(Stack<String> a){
    for(int i=a.size()-1;i>=0;i--){
    	if((a.get(i).equals("i")||a.get(i).equals("+")||a.get(i).equals("-")
    			||a.get(i).equals("*")||a.get(i).equals("/")||a.get(i).equals("(")
    			||a.get(i).equals(")")||a.get(i).equals("#"))&&i!=a.size()-1)
    	{        
    		return a.get(i).toString(); 
    	}
    }
    	return "false";
}
	public static void main(String[] args)throws IOException {
		  FileReader fr=new FileReader("D:\\360MoveData\\Users\\叶谈\\Desktop\\byyl\\demo2.txt");
		  FileReader fr1=new FileReader("D:\\360MoveData\\Users\\叶谈\\Desktop\\byyl\\demo3.txt");
		     buffer = new BufferedReader(fr);
		     buffer1=new BufferedReader(fr1);
		     String[] yt=new String[193];
		     String[] yt1=new String[19];
		     for(int i=0;i<193;i++)
		     {
		    	 yt[i]=buffer.readLine();
				// System.out.print(yt[i]); 
		     }
		     System.out.println(); 
		     for(int i=0;i<19;i++)
		     {
		    	 yt1[i]=buffer1.readLine();
				 //System.out.print(yt1[i]); 
		     }       
             Scanner sc=new Scanner(System.in);
		     System.out.print("请输入一个字符串：");
	          String ch1=sc.next();
	          sc.close();  
	         Stack<String> mystack=new Stack<String>();
	         for(int i=ch1.length()-1;i>=0;i--){
	        	 char m=ch1.charAt(i);
	        	 String x=String.valueOf(m);
	           mystack.add(x);                                   //mystack是存放待输入串的栈
	         }
	         System.out.println("mystack:"+mystack);
	         Stack<String> dict=new Stack<String>();
	         dict.push("#");   //dict是分析栈
	        // System.out.println(dict.get(0));
	         //System.out.println("dictstack:"+dict);	
	         System.out.println(firstoperator(dict));	
	         int max=100;	      	        
letter:   while(max>0){
	        	 max--;
	         for(int j=1;j<193;j=j+3)
	         {       	 
	        	if(yt[j].equals(firstoperator(dict))&&yt[j+1].equals(mystack.peek())&&(yt[j+2].equals("<")||yt[j+2].equals("="))){
	        		System.out.println("---------------------1");
	        		 dict.add(mystack.peek());
		        	 mystack.pop();
		        	 System.out.println(dict);
		        	 System.out.println(mystack);
		        	 break;
	        	} 
	        	 else if(yt[j].equals(firstoperatoris1(dict))&&yt[j+1].equals(mystack.peek())&&yt[j+2].equals(">")&&dict.peek().equals(")"))
		         {
	        		 System.out.println("---------------------2");
	                     dict.pop();
	                     dict.pop();
	                     dict.pop();
	                     for(int ii=2;ii<19;ii+=2)
	    	        	 {
	    	        		 String ysf1=yt1[ii];
	    	        		if(ysf1.charAt(0)=='('){
	    	        			dict.add(yt1[ii-1]);
	    	        		}
	    	             } 
	                     System.out.println(dict);
	    	        	 System.out.println(mystack);
	                     break;
		         }
	        	else if(yt[j].equals(firstoperatoris1(dict))&&yt[j+1].equals(mystack.peek())&&yt[j+2].equals(">")){
	        		System.out.println("---------------------3");
	        		 String ysf=dict.peek();
		        	 dict.pop();
	    letter1:for(int ii=2;ii<19;ii+=2)
	 	        	 {
	 	        		 String ysf1=yt1[ii];
	 	        		 for(int jj=0;jj<ysf1.length();jj++)
	 	        		{
	 	        			 char ysf11=ysf1.charAt(jj);
	 	        			 String ysf111=String.valueOf(ysf11);
	 	        			 if(ysf111.equals(ysf))
	 	        			 {
	 	        				 dict.add(yt1[ii-1]);
	 	        				 System.out.println(dict);
	 	   		        	     System.out.println(mystack);
	 	        				 break letter1;
	 	        			 }
	 	        	     }
	 	             } 
	                }	        	
	        	else  if(yt[j].equals(firstoperatorisnot1(dict))&&yt[j+1].equals(mystack.peek())&&yt[j+2].equals(">")
	        			&&is2fouroperators(dict)&&(dict.get(dict.size()-3).equals("F")||dict.get(dict.size()-3).equals("E")||
	        					dict.get(dict.size()-3).equals("T")))
	              {
	        		System.out.println("---------------------4");
		        	 dict.pop();
		        	 String ysf=dict.peek();
		        	 dict.pop();dict.pop();
		  letter2:      	 for(int ii=2;ii<19;ii+=2)
		        	 {
		        		 String ysf1=yt1[ii];
		        		 for(int jj=0;jj<ysf1.length();jj++)
		        		{
		        			 char ysf11=ysf1.charAt(jj);
		        			 String ysf111=String.valueOf(ysf11);
		        			 if(ysf111.equals(ysf))
		        			 {
		        				 dict.add(yt1[ii-1]);
		        				 break letter2;
		        			 }
		        	     }
		             } 
		        	 System.out.println(dict);
		        	 System.out.println(mystack);
		        	 break; 
	                }
	         else if(dict.size()==2&&(dict.peek().equals("F")||dict.peek().equals("E")||dict.peek().equals("T"))&&mystack.size()==1&&mystack.peek().equals("#"))
	         {
	        	 System.out.println("此时的mystack："+mystack);
	        	 System.out.println("此时的dictstack："+dict);
	        	 System.out.println("分析完成！");
	        	 break letter;
	         }
	         else if(yt[j].equals(firstoperator(dict))&&yt[j+1].equals(mystack.peek())&&yt[j+2].equals("NULL"))
	         {
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
	}       
        	 System.out.println("最终的dictstack："+dict);
        	   System.out.println("最终的mystack："+mystack);
	         }
}