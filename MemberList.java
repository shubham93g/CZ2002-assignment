import java.util.ArrayList;

public class MemberList
{
   private ArrayList<Member> member_list;
   
   public MemberList(){
	   member_list = new ArrayList<Member>(); //How to determine the length of this array? - ArrayList
       /*for (int i=0; i< member_list.size(); i++){ 
		     member_list.get(i)= new Member(i+1,"a","b",0,"c",false);
		 }*/
 //---------------need to replace above code with reading of members from a file----------------------
	  
   }
   
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
	 
	 public void createMember(String member_name, String member_emailID, int member_phoneNumber, String member_address){
		 int memberID = generateID();
		 Member member = new Member(memberID,member_name, member_emailID, member_phoneNumber, member_address);
	    	 member_list.add(member);
	         System.out.println("The MemberID "+member.getID()+ " is assigned to "+member.getName());

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
}
//print all members by member ID and staffID;
