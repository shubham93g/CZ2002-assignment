import java.util.Date;


public class Reservation {
	Date dateOfReservation;
	int noOfPeople;
	int tableID;
	String name;
	int phoneNumber;
	TableList table;
	
	public Reservation(String name, int phoneNumber, int noOfPeople, Date date){
		dateOfReservation = date;
		this.noOfPeople = noOfPeople;
		this.name = name;
		this.phoneNumber = phoneNumber;
	}
	
	public void selectTable(int noOfPeople){
		int tempTableID = -1;
		int tempDifference = 10;
		for(int i=0;i<table.getNoOfTables();i++){
			if(table.getTable(i).capacity >= noOfPeople && !table.getTable(i).isOccupied())
				if(Math.abs(table.getTable(i).capacity-noOfPeople)<=tempDifference){
					tempDifference = Math.abs(table.getTable(i).capacity-noOfPeople);
					tempTableID = i;
			}
		}
		tableID = tempTableID;
		table.getTable(tableID).occupy();
	}

}
