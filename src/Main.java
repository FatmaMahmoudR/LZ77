//Fatma Mahmoud Ramadan 20201134
//Basmalla Magdy Mohammed 20201045


import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {


	public static void main(String[] args) {
		//////////////
		
		System.out.println("Enter 1 to encode string ");
	    System.out.println("Enter 2 to decode tags");
	    Scanner O1 = new Scanner(System.in); 
	    int op = O1.nextInt();
	    
	    
	    if(op==1) 
	    {
	    	String s; 
			
			 Scanner O2 = new Scanner(System.in); 
				s = O2.nextLine();
		
				
			 Map<String, Integer> dict = new HashMap<String, Integer>(); 
		    
		    char c1='A', c2='a';
		    for (int i=65;i<=90;i++){
		        String tmp="";
		        tmp+= c1;
		        c1++;
		        dict.put(tmp,i);
		    }
		    for (int i=97;i<=122;i++){
		        String tmp="";
		        tmp+= c2;
		        c2++;
		        dict.put(tmp,i);
		    }
		    int TagCount = 0;
		    
		    int index=128;
		    for(int i=0,j=1;i<=s.length() && i+j < s.length();){
		    	
		        String curr ="";
		        curr+=s.charAt(i);
		        String next=curr;
		      
	            next+=s.charAt(i+j);
	           
		        while(true){   
		            j++;
		            
		            if (dict.containsKey(next) && i+j < s.length()){
		            	//found
		                curr=next;
		                next+=s.charAt(i+j);
		                }
		            else if(i+j == s.length()) { /////
		            	curr=next;
		            }
		            else{ //not found
		            	
		                System.out.print(dict.get(curr));
		                System.out.print(" ");
		                TagCount++;

		             
		                dict.put(next,index++);
		                j=1;
		                i+=curr.length();
		                break;
		           
		            	
		            }
		        }
		        


		    }
		    
		    System.out.print("\n");
		    System.out.print("Original Size : "+ s.length()*8+" Bits\n");
		    System.out.print("Compressed Size : "+ TagCount*8+" Bits\n");

			//////////
	    	
	    }
	    else 
	    {
	    	System.out.println("Enter your number of Tags : ");
			 Scanner INPUT = new Scanner(System.in);
			 int n=INPUT.nextInt();

			 System.out.println("Enter your tags : ");
			int [] tags=new int[n];
			for(int i=0;i<n;i++) {
				tags[i]=INPUT.nextInt();
				
			}
			String original_data="";
			int c=128;
			Map <Integer,String>m=new HashMap<Integer,String>();
			for(int i=65;i<=127;i++){
				   
			    m.put(i,"" +(char)i);
			}
			int tags_num=tags.length;
			 for(int i=0;i<tags_num;i++){
		         if(i!=0){
		       int x=tags[i];
		       if(m.get(x)!=null){
			        String v="";
			        v=m.get(tags[i-1]);
			        String vv=m.get(x);
			      
			        v+=vv.substring(0,1);
			        m.put(c,v);
			        original_data+=m.get(x);
			        c++;
		       }
		       
		       else{
		            String cur=m.get(tags[i-1]);
		            String v="";
		            v+=cur+cur.substring(0,1);
		            m.put(c, v);
		            original_data+=v;
		            c++;
		       }
		       }
	         else{
	        	 original_data+=m.get(tags[i]);
	            }    
		
			 }
			 
				System.out.println("The original data is");
				System.out.println(original_data);
				System.out.println("..........................");
				System.out.print("Original Size : ");
				System.out.println(original_data.length()*8);
				System.out.println("..........................");
			 }
	    
	    }
	    	
	    	
	
}


//ABAABABBAABAABAAAABABBBBBBBB
//14
//65 66 65 128 128 129 131 134 130 129 66 138 139 138

