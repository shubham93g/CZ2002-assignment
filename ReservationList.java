import java.util.Date;
import java.util.Scanner;


public class ReservationList {
	Reservation []reservation;
	int noOfReservations;
	
	public ReservationList(){
		reservation = new Reservation[20];
		noOfReservations = 0;
	}
	
	public void create(){
		Scanner sc = new Scanner(System.in);
		String name;
		int phoneNumber;
		int noOfPeople;
		Date date;
		date = new Date();
		System.out.print("Input the following details\nName : ");
		name = sc.next();
		System.out.print("Phone Number : ");
		phoneNumber = sc.nextInt();
		System.out.print("Reservation for how many people : ");
		noOfPeople = sc.nextInt();
		System.out.print("Date and time of reservation");
		//get date and time
		reservation[noOfReservations] = new Reservation(name, phoneNumber, noOfPeople);
	}
}
