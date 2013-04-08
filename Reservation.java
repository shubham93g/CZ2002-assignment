import java.util.Date;


public class Reservation {
	
	private Date dateOfReservation;
	private int noOfPeople;
	private int tableID;
	private String name; //key
	private int phoneNumber; //key
	
	public Reservation(String name, int phoneNumber, int noOfPeople, int tableID, Date date){
		dateOfReservation = date;
		this.noOfPeople = noOfPeople;
		this.name = name;
		this.phoneNumber = phoneNumber;
	}
	
	public Date getDate(){
		return dateOfReservation;
	}
	
	public int getNoOfPeople(){
		return noOfPeople;
	}
	
	public int getTableId(){
		return tableID;
	}
	
	public String getName(){
		return name;
	}
	
	public int getPhoneNumber(){
		return phoneNumber;
	}
	
	public void print(){
		System.out.println("Reservation Details\nName : "+ name);
		System.out.println("Date : "+ dateOfReservation);
		System.out.println("No of people : "+ noOfPeople);
		System.out.println("Table assigned : "+ tableID);
		System.out.println("Phone Number : "+ phoneNumber);
		
	}

}
