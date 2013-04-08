import java.util.ArrayList;
import java.util.Calendar;
import java.util.Scanner;


public class ReservationList {
	ArrayList <Reservation> reservation;
	int noOfReservations;
	TableList tableList;
	
	public ReservationList(TableList taableList){
		reservation = new ArrayList<Reservation>();
		noOfReservations = 0;
		this.tableList = tableList;
	}
	
	public int getIndexByName(String name){
		for(int i=0;i<reservation.size();i++)
			if(reservation.get(i).getName() == name)
				return i;
		return -1;
	}
	
	public void createReservation(){
		Scanner sc = new Scanner(System.in);
		String name;
		int phoneNumber;
		int noOfPeople;
		int year, month, date, hour, minute;
		Calendar bookingTime = Calendar.getInstance();
		System.out.print("Input the following details\nName : ");
		name = sc.next();
		System.out.print("Phone Number : ");
		phoneNumber = sc.nextInt();
		System.out.print("Reservation for how many people : ");
		noOfPeople = sc.nextInt();
		
		//reading date and time
		System.out.print("Year of reservation : ");
		year = sc.nextInt();
		System.out.print("Month of reservation: ");
		month = sc.nextInt();
		System.out.print("Date of reservation: ");
		date = sc.nextInt();
		System.out.print("Hour of reservation: ");
		hour = sc.nextInt();
		System.out.print("Minute of reservation: ");
		minute = sc.nextInt();
		
		//saving date and time
		bookingTime.set(Calendar.YEAR, year);
		bookingTime.set(Calendar.MONTH, month-1);
		bookingTime.set(Calendar.DAY_OF_MONTH, date);
		bookingTime.set(Calendar.HOUR_OF_DAY, hour);
		bookingTime.set(Calendar.MINUTE, minute);
		
		int tableID = tableList.getBestFitIndex(noOfPeople);
		Reservation tempReservation = new Reservation(name, phoneNumber, noOfPeople, tableID, bookingTime.getTime());
		reservation.add(tempReservation);
		tableList.occupyTable(tableID);
	}
	
	public void checkPrintReservation(String name){
		int index = getIndexByName(name);
		if(index==-1)
			System.out.println("No reservation by the name "+name+" was found");
		else
			reservation.get(index).print();
	}
	
	public void removeReservation(String name){
		int index = getIndexByName(name);
		if(index==-1)
			System.out.println("No reservation by the name "+name+" was found");
		else{
			tableList.vacateTable(reservation.get(index).getTableId());
			reservation.remove(index);
			System.out.println("Reservation removed");
		}
	}
}
