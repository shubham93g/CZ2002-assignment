import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;


public class RevenueReport {
	
	Order [] order;
	Date startDate;
	Date endDate;
	
	public RevenueReport(){
		//constructor
		startDate = new Date();
		endDate = new Date();
	}
public void setPeriod(int year_start, int year_end, int month_start, int month_end, int day_start, int day_end) {
	    	Calendar myCal = Calendar.getInstance();
	    	Calendar myCal2=Calendar.getInstance();
	    	int month1=month_start-1;
	    	int month2=month_end-1;

            	myCal.set(Calendar.YEAR, year_start);
            	myCal.set(Calendar.MONTH, month1);
            	myCal.set(Calendar.DAY_OF_MONTH, day_start);
            	Date theDate = myCal.getTime();
		startDate= theDate;

		myCal2.set(Calendar.YEAR, year_end);
		myCal2.set(Calendar.MONTH, month2);
		myCal2.set(Calendar.DAY_OF_MONTH, day_end);
		Date theDate2 = myCal2.getTime();
		endDate=theDate2;
		//set the period to generate revenue report
	}
	
	/*public void setPeriod(){
		//set the period to generate revenue report
		Scanner sc = new Scanner(System.in);
		int 
	}*/
	
	public void generateReport(){
		//generate the report
		for (i=0;i<order.length;i++)
			{if (order[i].getDate.after(startDate)&&order[i].getDate.before(endDate))
			{order[i].viewOrder;}}
	}

}
