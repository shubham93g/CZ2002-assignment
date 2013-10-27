import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;


public class RevenueReport {
	
	private OrderList orders;
	private Date startDate;
	private Date endDate;
	
	public RevenueReport(OrderList orders){
		//constructor
		this.orders = orders;
		startDate = new Date();
		endDate = new Date();
		
	}
	
	//function to set the period to generate revenue report
	public void setPeriod() {
			int year_start,year_end,month_start,month_end,day_start,day_end, hour_start, hour_end;
	    	Calendar start = Calendar.getInstance();
	    	Calendar end = Calendar.getInstance();
	    	Scanner sc = new Scanner(System.in);
	    	System.out.println("Input the following details");
	    	System.out.print("Start year: ");
	    	year_start = sc.nextInt();
	    	System.out.print("Start month: ");
	    	month_start = sc.nextInt();
	    	month_start--;
	    	System.out.print("Start day: ");
	    	day_start = sc.nextInt();
	    	System.out.print("Start hour: ");
	    	hour_start = sc.nextInt();
	    	System.out.print("End year: ");
	    	year_end = sc.nextInt();
	    	System.out.print("End month: ");
	    	month_end = sc.nextInt();
	    	month_end--;
	    	System.out.print("End day: ");
	    	day_end = sc.nextInt();
	    	System.out.print("End hour: ");
	    	hour_end = sc.nextInt();
            start.set(Calendar.YEAR, year_start);
            start.set(Calendar.MONTH, month_start);
            start.set(Calendar.DAY_OF_MONTH, day_start);
            start.set(Calendar.HOUR_OF_DAY, hour_start);
            start.set(Calendar.MINUTE, 0);
            startDate = start.getTime(); //return a date object

            end.set(Calendar.YEAR, year_end);
            end.set(Calendar.MONTH, month_end);
            end.set(Calendar.DAY_OF_MONTH, day_end);
            end.set(Calendar.HOUR_OF_DAY, hour_end);
            end.set(Calendar.MINUTE, 0);
            endDate = end.getTime(); //return a date object
		
	}
	
	
	//function to generate the report for the given period
	public void generateReport(){
		System.out.println("Start Date : "+startDate);
		System.out.println("End Date : "+endDate);
		Calendar testDate = Calendar.getInstance();
		Calendar endDate = Calendar.getInstance();
		testDate.setTime(this.startDate);
		endDate.setTime(this.endDate);
		Calendar tempDate = Calendar.getInstance();
		int orderSize, memberSize, month;
		double price;
		double memberPrice;
		double totalPrice;
		while(testDate.before(endDate)){
			orderSize = 0;
			memberSize = 0;
			price = 0.0;
			memberPrice = 0.0;
			totalPrice = 0.0;
			System.out.println("Month : " + monthDigitToString(testDate.get(Calendar.MONTH)));
			System.out.format("%n%-28s %7s %8s %9s", "Date","OrderID", "isMember", "Price SGD");
			for(int i=0;i<orders.getSize();i++){
				tempDate.setTime(orders.getOrderByIndex(i).getDate());
				if(tempDate.get(Calendar.MONTH)==testDate.get(Calendar.MONTH)&&tempDate.get(Calendar.YEAR)==testDate.get(Calendar.YEAR) && !orders.getOrderByIndex(i).isActive()){
					orderSize++;
					if(orders.getOrderByIndex(i).isMember()){ //if member
						memberSize++;
						memberPrice+= orders.getOrderByIndex(i).getTotalPrice()*0.9;
						System.out.format("%n%28s %7d %8s %9.2f",
								orders.getOrderByIndex(i).getDate().toString(),
								orders.getOrderByIndex(i).getOrderID(), 
								String.valueOf(orders.getOrderByIndex(i).isMember()),
								orders.getOrderByIndex(i).getTotalPrice()*0.9);
					}
					else{ //if not member
						price += orders.getOrderByIndex(i).getTotalPrice();
						System.out.format("%n%28s %7d %8s %9.2f",
								orders.getOrderByIndex(i).getDate().toString(),
								orders.getOrderByIndex(i).getOrderID(), 
								String.valueOf(orders.getOrderByIndex(i).isMember()),
								orders.getOrderByIndex(i).getTotalPrice());
					}
				}//end of if
			}
			totalPrice = memberPrice + price;
			System.out.println("\nTotal revenue : SGD "+ totalPrice);
			System.out.println("Total no.of order : "+ orderSize);
			System.out.println("No.of orders by members : "+ memberSize);
			System.out.println("Revenue from non-members : SGD "+ price);
			System.out.println("Revenue from members : SGD "+ memberPrice + "\n");
			month = testDate.get(Calendar.MONTH); 
			testDate.set(Calendar.MONTH,month+1); //increment date by 1
		}
	}
	
	//function to return the appropriate month string with given month number (by Date class)
	public String monthDigitToString(int month){
		switch(month){
		case 0:return "Janurary";
		case 1: return "February";
		case 2: return "March";
		case 3: return "April";
		case 4: return "May";
		case 5: return "June";
		case 6: return "July";
		case 7: return "August";
		case 8: return "September";
		case 9: return"October";
		case 10: return "Novermber";
		case 11: return "December";
		}
		return null;
	}

}
