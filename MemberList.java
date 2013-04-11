import java.util.ArrayList;
import java.io.*;
import java.util.*;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class MemberList
{
	
   private ArrayList<Member> member_list;
   BufferedWriter out;
   BufferedReader in;
   
   
   public MemberList(){
	   
	   
	   member_list = new ArrayList<Member>();
	   
	   //read from memberlist.txt
	   try {
			File file = new File("memberlist.txt");
	        BufferedReader br = new BufferedReader(new FileReader(file));
	        List<String> lines = new ArrayList<String>();
	        String line = br.readLine();
	        String tempName;
			int tempID;
			String tempAddress;
			String tempEmailID;
			int tempPhoneNumber;
	        while(line != null) {
	            lines.add(line.replace(">", ""));
	            line = br.readLine();
	        }
	        int i=0;
	        
	while (i<lines.size()){
	tempID = Integer.parseInt(lines.get(i));
	tempName = lines.get(i+1);
	tempPhoneNumber = Integer.parseInt(lines.get(i+2));
	tempEmailID = lines.get(i+3);
	tempAddress = lines.get(i+4);
	Member member = new Member(tempID, tempName, tempEmailID, tempPhoneNumber,tempAddress);
	 member_list.add(member);
	i=i+6;
	}

	        br.close();
	        }
	        
	         		  catch(IOException e){
	             System.out.println("There was a problem:" + e);
	         }
	 			catch (NumberFormatException e) {
	           //System.out.println("This is not a number");
	       }

		}
	   
	   
 //---------------need to replace above code with reading of members from a file----------------------
	  
   
	public boolean checkMember(int member_memberID){ 
		//to check membership by memberID; 
		//to have a boolean variable that return true if membership exists;
		for(int i=0;i<member_list.size();i++)   
			if (member_list.get(i).getID()==member_memberID)
		    	return true;
		return false;
	       }
	
	//auto generate member ID
	   public int generateID(){
			  for(int i=0;i<member_list.size();i++) //check if there are any member with missing IDs (as compared to index)
				  if(!checkMember(i))	//if yes, return this missing ID
					  return i;
			  
			  int lastID = member_list.get(member_list.size()-1).getID(); //otherwise, get the last used ID
			  while(checkMember(lastID)) //increment it till you get a new, unused ID
				  lastID++;
			  return lastID; //return this newID
					  
		  }
	       
	 public void printMember(int member_memberID){ //to print details of a member given membership ID
		 {
			 for (int i=0; i<member_list.size(); i++)
				 if (member_memberID==member_list.get(i).getID()){
					 member_list.get(i).print();
				 	 break; //to break out of the loop and save time
				 }
			 }
		 }
	       
	 public int getMemberIndex(int id){
			for(int i=0;i<member_list.size();i++)
				if(member_list.get(i).getID() == id)
					return i;
			return -1; //if no such item with given ID exists, return -1
		}
	 
	 public Member getMemberByID(int ID){
		 int index = getMemberIndex(ID);
		 if(index<member_list.size())
			 return member_list.get(index);
		 else
			 return null;
	 }
	 
	 public void createMember(String member_name, String member_emailID, int member_phoneNumber, String member_address){
		 int memberID = generateID();
		 Member member = new Member(memberID,member_name, member_emailID, member_phoneNumber, member_address);
	    	 member_list.add(member);
	         System.out.println("The MemberID "+member.getID()+ " is assigned to "+member.getName());
	         memberListOverwrite();
	     }
	  
	 public void sortMembers(){
		Member temporaryMember; //used for array operations
		Member [] memberCopy = new Member[member_list.size()];
		System.arraycopy(member_list.toArray(), 0, memberCopy, 0, member_list.size());
		for(int j=0;j<member_list.size();j++)	
			for(int i=memberCopy.length-1;i>j;i--)
				if(memberCopy[i-1].getID() >= memberCopy[i].getID()){
					temporaryMember = memberCopy[i];
					memberCopy[i] = memberCopy[i-1];
					memberCopy[i-1] = temporaryMember;
				}
		System.out.println("The sorted list is as follows  : ");
		for(int k=0;k<memberCopy.length;k++){
			System.out.println("Member ID "+memberCopy[k].getID()+" is customer "+memberCopy[k].getName());
			}
		}
			 
	public void printAllMembers(){
		System.out.println ("The following is the list of members and their member IDs: ");
	    for (int i=0; i<member_list.size(); i++)
	    		System.out.println("Name: "+member_list.get(i).getName()+" Member ID: "+member_list.get(i).getID());
	    }
	
	public void memberListOverwrite(){
        try{
         out = new BufferedWriter(new FileWriter("memberlist.txt",false)); 
         for(int counter=0;counter<member_list.size();counter++){
        	 	out.write(member_list.get(counter).getID()+"\n"+member_list.get(counter).getName()+"\n"+String.valueOf(member_list.get(counter).getPhoneNumber())+"\n"+
    		   	member_list.get(counter).getEmailID()+
        "\n"+member_list.get(counter).getAddress());
        	 out.newLine();
			out.newLine();
         }
         out.close();
         }
         catch(IOException e){
         System.out.println("There was a problem:" + e);
         }

}
	
	
	
}
//print all members by member ID and staffID;
