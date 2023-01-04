//Fatma Mahmoud Ramadan 20201134
//Basmalla Magdy Mohammed 20201045

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Vector;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		
		String s;
	    Scanner myObj = new Scanner(System.in);  // Create a Scanner object
	    System.out.println("Hello dear user");
	    System.out.println("Enter 1 to encode string ");
	    System.out.println("Enter 2 to decode tags");
	    int op = myObj.nextInt();
	 
	  while(op!=1&&op!=2)
	  {
		    System.out.println("Invalid operation,Try again");
		    System.out.println("Enter 1 to encode string ");
		    System.out.println("Enter 2 to decode tags");
		    System.out.println("Enter 3 to end the prgram");
		    op = myObj.nextInt();
		    if(op==3)break;
	  }
	  
	   if(op==1)
	   {
		   int mxpos=-1000000000;
		   int mxlen=-1000000000;
	    Scanner Obj = new Scanner(System.in);  // Create a Scanner object

		    s = Obj.nextLine();
		    ArrayList<Integer> position = new ArrayList<Integer>();
		    ArrayList<Integer> length = new ArrayList<Integer>();
		    ArrayList<Character> nextSympol = new ArrayList<Character>();
		    String sub="";
		    int start=0;
	    	boolean found=false;
	   
	    	int pos=0;
	    	int matching=0;
		    for(int i=0;i<s.length();i++)
		    {
		    	
		    	if(found) {
		    	sub=sub+s.charAt(i);
		    	found=false;
		    	matching=0;
		    	}
		    	else
		    	{
		    		sub="";
		    		sub=sub+s.charAt(i);
		    		start=i;
		    		pos=0;
		    		matching=0;
		    	}
		    	
		    	for(int j=0;j<start;j++)
		    	{
		    		int jj=j,ii=0;
		    		while(jj<start&&ii<sub.length()&&s.charAt(jj)==sub.charAt(ii))
		    		{
		    			ii++;
		    			jj++;
		    			matching++;
		    		}
		    		if(ii==sub.length())
		    		{
		    			found=true;
		    			pos=j;
		    		}
		    		
		    	}
		    	if(!found)
		    	{
		    		  if(matching==0)
		                {
		                    pos=0;
		                    start=0;
		                }
		    		position.add(start-pos);
		    		length.add(sub.length()-1);	
		    		nextSympol.add(s.charAt(i));
		    	}
		    	
		    }
		    for(int i=0;i<position.size();i++)
		    {
		    	System.out.print("< ");
		    	System.out.print(position.get(i));
		    	mxpos=Math.max(mxpos,position.get(i));
		    	System.out.print(" , ");
		    	System.out.print(length.get(i));
		    	mxlen=Math.max(mxlen,length.get(i));
		    	System.out.print(" , ");
		    	System.out.print(nextSympol.get(i));
		    	System.out.println(" >");
		    	
		    }
		    int cntpos=0,cntlen=0;
		    while(mxpos>0)
		    {
		    	mxpos/=2;
		    	cntpos++;
		    }
		    while(mxlen>0)
		    {
		    	mxlen/=2;
		    	cntlen++;
		    }
		    

	    	System.out.println("Size of original string = "+(8*s.length()));
	    	System.out.println("Size of compressed string = "+(position.size()*(8+cntpos+cntlen)));
	    	


		   
	    	
	   }
	   else if(op==2)
       {
		   

		   String ss = "<0,0,A><0,0,B><2,1,A><3,2,B><5,3,B><2,2,B><5,5,B><1,1,A> ";
			
		   Scanner O = new Scanner(System.in);  // Create a Scanner object
			 ss = O.nextLine();
			String Compressed = "";

			 for (int i = 0; i < ss.length(); i++)
			 {
			        if ( ss.charAt(i) == '<' || ss.charAt(i) == '>' || ss.charAt(i) == ',')
			            continue;
			        else
			        	Compressed += ss.charAt(i);
			        }
			 
			//00A00B21A32B53B22B55B11A
			 
			 Vector v = new Vector<Character>();

			    for (int i = 0; i < Compressed.length() - 1; i += 3)
			    {
			        int x = Compressed.charAt(i) - 48;
			        int y = Compressed.charAt(i+1) - 48;

			        int start = v.size() - x;
			        
			        for (int j = start; j < start + y; j++) 
			        {
			            v.add(v.get(j));

			           
			        }
			        v.add(Compressed.charAt(i+2));

			    }

			    for (int i = 0; i < v.size(); i++) 
			    {
			    	System.out.print(v.get(i));
			    }

       }
	    //ABAABABAABBBBBBBBBBBBA
	   //<0,0,A><0,0,B><2,1,A><3,2,B><5,3,B><2,2,B><5,5,B><1,1,A>

	
	}

}