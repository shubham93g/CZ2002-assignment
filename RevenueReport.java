import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;


public class RevenueReport {
	
	private ArrayList <Order> orders;
	private Date startDate;
	private Date endDate;
	
	public RevenueReport(){
		//constructor
		startDate = new Date();
		endDate = new Date();
		setPeriod();
		
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
		
		
		Calendar midDate = Calendar.getInstance();
		midDate.setTime(startDate);
		midDate.set(Calendar.MONTH, midDate.get(Calendar.MONTH)+1);
		while(midDate.getTime().before(endDate)){
			//need tp fpnish code
		}
	}

}
