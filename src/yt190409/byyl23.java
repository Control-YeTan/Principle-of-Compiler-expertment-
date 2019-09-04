package yt190409;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.Stack;
public class byyl23 {
	private static BufferedReader buffer,buffer1;
	private static Scanner sc;
	static int ii=0;
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
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		 FileReader fr=new FileReader("D:\\360MoveData\\Users\\叶谈\\Desktop\\byyl\\demo4.txt");
		 FileReader fr1=new FileReader("D:\\360MoveData\\Users\\叶谈\\Desktop\\byyl\\demo5.txt");
	     buffer = new BufferedReader(fr);
	     buffer1=new BufferedReader(fr1);
	     String[] yt=new String[704];
	     String[] yt1=new String[19];
 	     for(int i=0;i<704;i++)
	     { 
				yt[i]=buffer.readLine();			
		//	 System.out.println(yt[i]); 
	     }
 	    for(int i=0;i<19;i++)
	     { 
				yt1[i]=buffer1.readLine();			
		//	 System.out.println(yt1[i]); 
	     }
	     sc = new Scanner(System.in);
	     System.out.print("请输入一个字符串：");	     
         String ch1=sc.next();
       //  System.out.println(ch1);
         String ch2="";        
         int count=ch1.length();
        // System.out.println(count);
         while(ii<count){
        	 char ch=getch(ch1);
        		if (isletter(ch)) 
        		{  
        			do{ ch = getch(ch1);
        			 } while (isletter(ch) || isnumber(ch));
        			ch2=ch2+"i";
        		      ii--;
        		     continue;
        		 }
        		else if (isnumber(ch)) 
        		{
        			do{ch = getch(ch1);
        			} while (isnumber(ch));
        		     ch2=ch2+"i";	
        			ii--;
        			continue;			
        		}	
        		else
        		{ch2=ch2+String.valueOf(ch);
    			continue;}
        		}
       
         System.out.println("待分析串："+ch2);
         Stack<String> statestack=new Stack<String>();
         statestack.push("0");
         System.out.println("状态栈:"+statestack);
         Stack<String> signstack=new Stack<String>();
         signstack.push("#");
         System.out.println("符号栈:"+signstack);
         Stack<String> inputstack=new Stack<String>();
         for(int i=ch2.length()-1;i>=0;i--){
        	 char m=ch2.charAt(i);
        	 String x=String.valueOf(m);
        	 inputstack.push(x);
         }
         System.out.println("待输入串:"+inputstack);
  letter:   while(true){
    	 for(int i=0;i<yt.length;i=i+4){
    		 if(yt[i].equals(statestack.peek())&&yt[i+1].equals(inputstack.peek())&&yt[i+2].equals("S")){
    			 System.out.println("----------移进中------------");
    			 statestack.push(yt[i+3]);
    			 signstack.push(inputstack.peek());
    			 inputstack.pop();
    			 System.out.println("状态栈:"+statestack);
    			 System.out.println("符号栈:"+signstack);
    			 System.out.println("待输入串:"+inputstack);
    			 System.out.println("----------移进完成！----------");
    			 break;
    		 }
    		 else if(yt[i].equals(statestack.peek())&&yt[i+1].equals(inputstack.peek())&&yt[i+2].equals("R")){
    			 System.out.println("----------归约中---------");
    			 char x=yt[i+3].toString().charAt(0);
                 int wf=x-'0';//wf是拓广文法的索引号
    			 int len=yt1[2*(wf+1)].length();
    			 for(int j=0;j<len;j++)
    			    {
    				 statestack.pop();
    				 signstack.pop();
    				 }
    			 
    		   signstack.push(yt1[2*wf+1]);
    			 for(int j=0;j<yt.length;j=j+4)
    			 {
    				 if(yt[j].equals(statestack.peek())&&yt[j+1].equals(signstack.peek()))
    				 {
    					 statestack.push(yt[j+2]);
    					 break;
    				 }
    			 }
    			 System.out.println("状态栈:"+statestack);
    			 System.out.println("符号栈:"+signstack);
    			 System.out.println("待输入串:"+inputstack);
    			 System.out.println("----------归约完成！----------");
    			 break;
    		 }
    		 else if(yt[i].equals(statestack.peek())&&yt[i+1].equals(inputstack.peek())&&yt[i+2].equals("acc")){
    			 System.out.println("分析完成！");
    			 System.out.println("最终的状态栈:"+statestack);
    			 System.out.println("最终的符号栈:"+signstack);
    			 System.out.println("最终的待输入串:"+inputstack);
    			 break letter;
    		 }
    		
    		 else if(yt[i].equals(statestack.peek())&&yt[i+1].equals(inputstack.peek())&&yt[i+2].equals("NULL")){
    			 System.out.println("待输入串有误！");
    			 System.out.println("此时的状态栈:"+statestack);
    			 System.out.println("此时的符号栈:"+signstack);
    			 System.out.println("此时的待输入串:"+inputstack);
    			 break letter;
    		 }
    		 else{
    			 continue;
    		 } 
    	 }
     }
	}
}
