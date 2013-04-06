//import java.util.scanner;


public class MemberList
{
   private Member[] member_list;
   
   public MemberList()
   {member_list=new Member[100]; //How to determine the length of this array?
       for (int i=0; i< member_list.length; i++)
		 { 
		     member_list[i]= new Member(i+1,"a","b",0,"c",false);
		 }
}
	public boolean checkMember(int member_memberID) //to check membership by memberID; //to have a boolean variable that return true if membership exists;
	{
	    int i=member_memberID;
	    if (member_list[i].isMember()==true) {return true;}
	    else {return false;}
	    
	            
	       }
	       
	 public void printMember(int member_memberID) //to print details of a member given membership ID
	 {{for (int i=0; i<member_list.length; i++)
	    {if (member_memberID==member_list[i].getMemberID())
	        {System.out.println ("Member name"+member_list[i].getName()); 
	            System.out.println("Member email ID"+member_list[i].getEmailID());
	            
	           System.out.println("Member phone number"+member_list[i].getPhoneNumber());}
	           System.out.println("Member address"+member_list[i].getAddress());
	       }}}
	       
	 public void createMember(int memberID, String member_name,String member_emailID,int member_phoneNumber,String member_address)
	 {int i=memberID-1;
	     if (member_list[i].isMember()==false)
	     {member_list[i].create(member_name, member_emailID, member_phoneNumber, member_address);
	         System.out.println("The MemberID "+member_list[i].getMemberID()+ " is assigned to "+member_list[i].getName());}
	         else {System.out.println("This memberID is already taken!");}}
	  
	 public void sortMembers(){
		Member temporaryMember; //used for array operations
		Member [] memberCopy = new Member[100];
		System.arraycopy(member_list, 0, memberCopy, 0, member_list.length);
		for(int j=0;j<member_list.length;j++)	
			for(int i=memberCopy.length-1;i>j;i--)
				if(memberCopy[i-1].getMemberID() >= memberCopy[i].getMemberID()){
					temporaryMember = memberCopy[i];
					memberCopy[i] = memberCopy[i-1];
					memberCopy[i-1] = temporaryMember;
				}System.out.println("The sorted list is as follows  : ");
		for(int k=0;k<memberCopy.length;k++)
			{System.out.println("Member ID "+memberCopy[k].getMemberID()+" is customer "+memberCopy[k].getName());
	 
			 }}
			 
	public void printAllMembers()
	{System.out.println ("The following is the list of members and their member IDs: ");
	    for (int i=0; i<100; i++)
	    {if (member_list[i].isMember()==true)
	        {System.out.println("Name: "+member_list[i].getName()+" Member ID: "+member_list[i].getMemberID());}}}
}
//print all members by member ID and staffID;
