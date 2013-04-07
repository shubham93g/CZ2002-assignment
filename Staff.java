

public class Staff extends Person{
	
	String jobTitle;
	char gender;


	public Staff(int staffID, String staffName, char staffGender, String staffJobTitle, String staffEmailID, String staffAddress, int staffPhoneNumber){
		super(staffName, staffAddress, staffEmailID, staffID, staffPhoneNumber);
		jobTitle = staffJobTitle;
		gender = staffGender;
		}
	
	public char getGender(){
		return gender;
	}
	
	public void setGender(char gender){
		this.gender = gender;
		}
	
	public String getJobTitle(){
		return jobTitle;
	}
	
	public void setJobTitle(String jobTitle){
		this.jobTitle = jobTitle;
	}
	
	public void print(){
		System.out.println("Name : " + super.getName());
		System.out.println("ID : " + super.getID());
		System.out.println("Gender : "+ gender);
		System.out.println("Job Title : "+ jobTitle);
		System.out.println("Address : " + super.getAddress());
		System.out.println("Email : " + super.getEmailID());
		System.out.println("Contact : " + super.getPhoneNumber());
	}

}