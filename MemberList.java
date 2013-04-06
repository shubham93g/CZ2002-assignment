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
   
	public boolean checkMember(int member_memberID){ //to check membership by memberID; //to have a boolean variable that return true if membership exists;
		for(int i=0;i<member_list.size();i++)   
			if (member_list.get(i).isMember() && member_list.get(i).getMemberID()==member_memberID)
		    	return true;
		return false;
	       }
	       
	 public void printMember(int member_memberID){ //to print details of a member given membership ID
		 {
			 for (int i=0; i<member_list.size(); i++)
				 if (member_memberID==member_list.get(i).getMemberID()){
					 System.out.println("Member name"+member_list.get(i).getName()); 
					 System.out.println("Member email ID"+member_list.get(i).getEmailID()); 
					 System.out.println("Member phone number"+member_list.get(i).getPhoneNumber());
				 	 System.out.println("Member address"+member_list.get(i).getAddress());
				 	 break; //to break out of the loop and save time
				 }
			 }
		 }
	       
	 public void createMember(int memberID, String member_name, String member_emailID, int member_phoneNumber, String member_address){
		 int i=memberID-1;
		 Member member = new Member();
		 member.create(member_name, member_emailID, member_phoneNumber, member_address);
		 if(!checkMember(memberID)){
	    	 member_list.add(member);
	         System.out.println("The MemberID "+member_list.get(i).getMemberID()+ " is assigned to "+member_list.get(i).getName());
	         }
	     else 
	    	 System.out.println("This memberID is already taken!");
	     }
	  
	 public void sortMembers(){
		Member temporaryMember; //used for array operations
		Member [] memberCopy = new Member[member_list.size()];
		System.arraycopy(member_list.toArray(), 0, memberCopy, 0, member_list.size());
		for(int j=0;j<member_list.size();j++)	
			for(int i=memberCopy.length-1;i>j;i--)
				if(memberCopy[i-1].getMemberID() >= memberCopy[i].getMemberID()){
					temporaryMember = memberCopy[i];
					memberCopy[i] = memberCopy[i-1];
					memberCopy[i-1] = temporaryMember;
				}
		System.out.println("The sorted list is as follows  : ");
		for(int k=0;k<memberCopy.length;k++){
			System.out.println("Member ID "+memberCopy[k].getMemberID()+" is customer "+memberCopy[k].getName());
			}
		}
			 
	public void printAllMembers(){
		System.out.println ("The following is the list of members and their member IDs: ");
	    for (int i=0; i<100; i++){
	    	if (member_list.get(i).isMember()){
	    		System.out.println("Name: "+member_list.get(i).getName()+" Member ID: "+member_list.get(i).getMemberID());
	    		}
	    	}
	    }
}
//print all members by member ID and staffID;
