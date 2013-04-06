
public class Date
{ private int day; private int month; private int year; private int hour;
   public Date()
   {day=0;
       month=0;
       year=0;
       hour=0;
    }
    public Date(int date_day, int day_month, int date_year, int date_hour)
    {day=date_day;
        month=day_month;
        year=date_year;
        hour=date_hour;}
    
    
    public int getDay() {return day;}
    public void setDay(int date_day) {day=date_day;}
    
    public int getMonth() {return month;}
    public void setMonth(int date_month) {month=date_month;}
    
    public int getYear() {return year;}
    public void setYear(int date_year) {year=date_year;}
    
    public int getHour() {return hour;}
    public void setHour(int date_hour) {hour=date_hour;}
    
    public void displayDate() {System.out.println("Date: "+day+"/"+month+"/"+year+" Time: "+hour);}
    
}
