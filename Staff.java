

public class Staff
{
String name,gender,jobTitle;
int employeeID,age;
boolean exists;

public Staff()
{name="a";
gender="m";
jobTitle="b";
 employeeID=0;
 age=0;
 exists=false;
}

public Staff(String staff_name, String staff_gender, String staff_jobTitle, int staff_employeeID, int staff_age, boolean a)
{name=staff_name;
gender=staff_gender;
jobTitle=staff_jobTitle;
employeeID=staff_employeeID;
age=staff_age;
exists=a;
}

public void create(String staff_name, String staff_gender, String staff_jobTitle, int staff_age )
{name=staff_name;
gender=staff_gender;
jobTitle=staff_jobTitle;
//employeeID=staff_employeeID;
age=staff_age;
exists=true;}


public String getName()
{return name;}
public void setName(String a)
{name=a;
}

public String getGender()
{return gender;}
public void setGender(String b)
{gender=b;}

public String getJobTitle()
{return jobTitle;}
public void setJobTitle(String c)
{jobTitle=c;}

public int getEmployeeID()
{return employeeID;}
public void setEmployeeID(int k)
{employeeID=k;}

public int getAge()
{return age;}
public void setAge(int l)
{age=l;}

public boolean isStaff()
{return exists;}

}