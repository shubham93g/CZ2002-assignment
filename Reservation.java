import java.util.Calendar;
import java.util.Date;


public class Reservation {
	
	private Date startOfReservation;
	private int noOfPeople;
	private int tableID;
	private String name; //key
	private int phoneNumber; //key
	
	public Reservation(String name, int phoneNumber, int noOfPeople, int tableID, Date startDate){
		startOfReservation = startDate;
		this.noOfPeople = noOfPeople;
		this.name = name;
		this.phoneNumber = phoneNumber;
		this.tableID = tableID;
	}
	

	public Date getEndDate(){				//stores startDate + 30 minutes
		Calendar endDate = Calendar.getInstance();
		endDate.setTime(startOfReservation);
		int minute = endDate.get(Calendar.MINUTE);
		endDate.set(Calendar.MINUTE, minute+30);
		return endDate.getTime();
	}
	
	public Date getDate(){
		return startOfReservation;
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
		System.out.println("Date : "+ startOfReservation);
		System.out.println("No of people : "+ noOfPeople);
		System.out.println("Table assigned : "+ tableID);
		System.out.println("Phone Number : "+ phoneNumber);
		
	}

}
