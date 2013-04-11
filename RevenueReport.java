import java.util.ArrayList;
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
public void setPeriod() {
			int year_start,year_end,month_start,month_end,day_start,day_end, hour_start, hour_end;
	    	Calendar start = Calendar.getInstance();
	    	Calendar end =Calendar.getInstance();
	    	Scanner sc = new Scanner(System.in);
	    	System.out.println("Input the following details");
	    	System.out.print("Start year");
	    	year_start = sc.nextInt();
	    	System.out.print("Start month");
	    	month_start = sc.nextInt();
	    	month_start--;
	    	System.out.print("Start day");
	    	day_start = sc.nextInt();
	    	System.out.print("Start hour");
	    	hour_start = sc.nextInt();
	    	System.out.print("End year");
	    	year_end = sc.nextInt();
	    	System.out.print("End month");
	    	month_end = sc.nextInt();
	    	month_end--;
	    	System.out.print("End day");
	    	day_end = sc.nextInt();
	    	System.out.print("End hour");
	    	hour_end = sc.nextInt();
            start.set(Calendar.YEAR, year_start);
            start.set(Calendar.MONTH, month_start);
            start.set(Calendar.DAY_OF_MONTH, day_start);
            start.set(Calendar.HOUR_OF_DAY, hour_start);
            start.set(Calendar.MINUTE, 0);
            startDate = start.getTime();

            end.set(Calendar.YEAR, year_end);
            end.set(Calendar.MONTH, month_end);
            end.set(Calendar.DAY_OF_MONTH, day_end);
            end.set(Calendar.HOUR_OF_DAY, hour_end);
            end.set(Calendar.MINUTE, 0);
            endDate = end.getTime();
		//set the period to generate revenue report
	}
	
	
	
	public void generateReport(){
		//generate the report
		
		//---------------need to add code to read orders from a file----------------------
		// order must be inactive 
		// order date must be between the period
		// (order.isActive()==false)&&startDate.before(order.getDate())&&endDate.after(order.getDate())
		// read order by order and insert in arrayList is above condition is true
		
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
		//midDate.set(Calendar.MONTH, midDate.get(Calendar.MONTH)+1);
		while(testDate.before(endDate)){
			orderSize = 0;
			memberSize = 0;
			price = 0.0;
			memberPrice = 0.0;
			totalPrice = 0.0;
			for(int i=0;i<orders.getSize();i++){
				tempDate.setTime(orders.getOrderByIndex(i).getDate());
				if(tempDate.get(Calendar.MONTH)==testDate.get(Calendar.MONTH)&&tempDate.get(Calendar.YEAR)==testDate.get(Calendar.YEAR) && !orders.getOrderByIndex(i).isActive()){
					orderSize++;
					if(orders.getOrderByIndex(i).isMember()){
						memberSize++;
						memberPrice+= orders.getOrderByIndex(i).getTotalPrice()*0.9;
					}
					else{ //if not member
						price += orders.getOrderByIndex(i).getTotalPrice();
					}
				}//end of if
			}
			totalPrice = memberPrice + price;
			System.out.println("Month : " + monthDigitToString(testDate.get(Calendar.MONTH)));
			System.out.println("Total revenue : SGD "+ totalPrice);
			System.out.println("Total no.of order : "+ orderSize);
			System.out.println("No.of orders by members : "+ memberSize);
			System.out.println("Revenue from non-members : SGD "+ price);
			System.out.println("Revenue from members : SGD "+ memberPrice + "\n");
			month = testDate.get(Calendar.MONTH); 
			testDate.set(Calendar.MONTH,month+1); //increment date by 1
		}
	}
	
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
