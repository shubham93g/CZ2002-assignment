
public class Person {
	String name;
	String address;
	String emailID;
	int id;
	int phoneNumber;
	
	public Person(String name, String address, String emailID, int id, int phoneNumber){
		this.name = name;
		this.address = address;
		this.emailID = emailID;
		this.id = id;
		this.phoneNumber = phoneNumber;
	}
	
	public String getName(){
		return name;
	}
	
	public String getAddress(){
		return address;
	}
	
	public String getEmailID(){
		return emailID;
	}
	
	public int getID(){
		return id;
	}
	
	public int getPhoneNumber(){
		return phoneNumber;
	}
	
	public void setName(String name){
		this.name = name;
	}
	
	public void setAddress(String address){
		this.address = address;
	}
	
	public void setEmailID(String emailID){
		this.emailID = emailID;
	}
	
	public void setID(int id){
		this.id = id;
	}
	
	public void setPhoneNumber(int phoneNumber){
		this.phoneNumber = phoneNumber;
	}
	
	public void print(){
		System.out.println("Name : " + name);
		System.out.println("ID : " + id);
		System.out.println("Address : " + address);
		System.out.println("Email : " + emailID);
		System.out.println("Contact : " + phoneNumber);
	}

}
