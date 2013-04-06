import java.util.Date;


public class Reservation {
	Date dateOfReservation;
	int noOfPeople;
	int tableID;
	String name;
	int phoneNumber;
	TableList table;
	
	public Reservation(String name, int phoneNumber, int noOfPeople){
		dateOfReservation = new Date();
		this.noOfPeople = noOfPeople;
		this.name = name;
		this.phoneNumber = phoneNumber;
	}
	
	public void selectTable(int noOfPeople){
		
	}

}
