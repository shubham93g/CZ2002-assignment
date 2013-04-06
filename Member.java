

public class Member
{
   private int memberID;
   private String name;
   private String emailID;
   private int phoneNumber;
   private String address;
   private boolean exists;
   
   	public Member(){
	   	memberID=0;
	   	name="a";
	   	emailID="b";
	   	phoneNumber=0;
	   	address="c";
	   	exists=false;
   	}

	public Member(int member_memberID, String member_name, String member_emailID, int member_phoneNumber, String member_address, boolean a){
		memberID = member_memberID;
		name = member_name;
		emailID = member_emailID;
		phoneNumber = member_phoneNumber;
		address = member_address;
		exists = a;
	}
	
	public int getMemberID(){
		return memberID;
	}
	
	public void setMemberID(int a){
		memberID=a;
	}
	
	public String getName(){
		return name;
	}
	
	public void setName(String b){
		name=b;
	}
	
	public String getEmailID(){
		return emailID;
	}
	
	public void setEmailID(String c){
		emailID=c;
	}
	
	public int getPhoneNumber(){
		return phoneNumber;
	}
	
	public void setPhoneNumber(int d){
		phoneNumber=d;
	}
	
	public String getAddress(){
		return address;
	}
	
	public void setAddress (String e){
		address=e;
	}
	
	public void create(String member_name,String member_emailID,int member_phoneNumber,String member_address ){
		name = member_name;
		emailID = member_emailID;
		phoneNumber = member_phoneNumber;
		address = member_address;
		exists = true;
	}
	
	public boolean isMember(){
		return exists;
	}

}
