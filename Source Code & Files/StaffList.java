import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class StaffList
{
   private ArrayList<Staff> staff_list;							//ArrayList for dynamic memory allocation
   BufferedWriter out;
   BufferedReader in;
   
   public StaffList()
   {
	   staff_list=new ArrayList <Staff>(); 						//reading staff from text files
	   try {
			File file = new File("stafflist.txt");
	        BufferedReader br = new BufferedReader(new FileReader(file));
	        List<String> lines = new ArrayList<String>();
	        String line = br.readLine();
	        String tempName;
			int tempID;
			String tempGender;
			String tempJobTitle;
			String tempAddress;
			String tempEmailID;
			int tempPhoneNumber;
	        while(line != null) {
	            lines.add(line.replace(">", ""));
	            line = br.readLine();
	        }
	        int i=0;
	        
	while (i<lines.size()){

	tempID = Integer.parseInt(lines.get(i));
	tempName = lines.get(i+1);
	tempGender = lines.get(i+2);
	tempJobTitle = lines.get(i+3);
	tempPhoneNumber = Integer.parseInt(lines.get(i+4));
	tempEmailID = lines.get(i+5);
	tempAddress = lines.get(i+6);
	Staff staff = new Staff(tempID, tempName, tempGender.charAt(0), tempJobTitle, tempEmailID, tempAddress, tempPhoneNumber);
	staff_list.add(staff);
	i=i+8;
	}

	        br.close();
	        }
	        
	         		  catch(IOException e){
	             System.out.println("There was a problem:" + e);
	         }
	 			catch (NumberFormatException e) {
	 				e.printStackTrace();
	 			}

		}
	
   public boolean checkStaff(int staff_employeeID){ //to check staff by staffID			
		for (int i=0; i<staff_list.size(); i++)
			if (staff_employeeID==staff_list.get(i).getID()){
				return true;
			}
		return false;
	    }
   
   public int generateID(){//randomly generate staffID
		  for(int i=0;i<staff_list.size();i++) //check if there are any staff with missing IDs (as compared to index)
			  if(!checkStaff(i))	//if yes, return this missing ID
				  return i;
		  int lastID = 0;
		  if(staff_list.size()!=0)
			  lastID = staff_list.get(staff_list.size()-1).getID(); //otherwise, get the last used ID 
		  while(checkStaff(lastID)) //increment it till you get a new, unused ID
			  lastID++;
		  return lastID; //return this newID
				  
	  }
   
   public int getStaffIndex(int id){
		for(int i=0;i<staff_list.size();i++)
			if(staff_list.get(i).getID() == id)
				return i;
		return -1; //if no such staff with given ID exists, return -1
	}
   
   public Staff getStaffByID(int ID){
	   int index = getStaffIndex(ID);
	   if(index<staff_list.size())
		   return staff_list.get(index);
	   else
		   return null;
   }
	
	
	 public void createStaff(String staffName, char staffGender, String staffJobTitle, String staffEmailID, String staffAddress, int staffPhoneNumber){
		 int staffID = generateID();
		 Staff staff = new Staff(staffID, staffName, staffGender, staffJobTitle, staffEmailID, staffAddress, staffPhoneNumber);
		    	 staff_list.add(staff);
		         System.out.println("The StaffID "+staff.getID()+ " is assigned to "+staff.getName());
		         staffListOverwrite();
	     }
	       
	 public void printStaff(int staff_employeeID){ //to print details of a member given membership ID
	 for (int i=0; i<staff_list.size(); i++)
	    if (staff_employeeID==staff_list.get(i).getID()){
	    	staff_list.get(i).print();
	    }
	 }
	  
	 public void sortStaff(){//sort and print staff by staffID
		Staff temporaryStaff; //used for array operations
		Staff [] staffCopy = new Staff[100];
		System.arraycopy(staff_list.toArray(), 0, staffCopy, 0, staff_list.size());
		for(int j=0;j<staff_list.size();j++)	
			for(int i=staffCopy.length-1;i>j;i--)
				if(staffCopy[i-1].getID() >= staffCopy[i].getID()){
					temporaryStaff = staffCopy[i];
					staffCopy[i] = staffCopy[i-1];
					staffCopy[i-1] = temporaryStaff;
				}
		System.out.println("The sorted list is as follows  : ");
		for(int k=0;k<staffCopy.length;k++){
			System.out.println("Staff ID "+staffCopy[k].getID()+" is staff "+staffCopy[k].getName());
			}
		}
			 
	 public void printAllStaff(){
		 System.out.println ("The following is the list of staff and their employee IDs: ");
		 for (int i=0; i<staff_list.size(); i++)
	        System.out.println("Name: "+staff_list.get(i).getName()+" Staff ID: "+staff_list.get(i).getID());
	    }
	 
	 public void removeStaffByID(int ID){
		 int index = this.getStaffIndex(ID);
		 if(index!=-1){
			 staff_list.remove(index);
			 System.out.print("\nStaff removed");
			 staffListOverwrite();
		 }
		 else
			 System.out.println("Staff with ID does not exist");
	 }
	 
	 public void staffListOverwrite(){//update the changes back in the text file
	        try{
	         out = new BufferedWriter(new FileWriter("stafflist.txt",false)); 
	         for(int counter=0;counter<staff_list.size();counter++){
	        	 	out.write(staff_list.get(counter).getID()+"\n"+
	        	 			staff_list.get(counter).getName()+"\n"+
	        	 			staff_list.get(counter).getGender()+"\n"+
	        	 			staff_list.get(counter).getJobTitle()+"\n"+
	        	 			String.valueOf(staff_list.get(counter).getPhoneNumber())+
	        	 			"\n"+staff_list.get(counter).getEmailID()+"\n"+
	        	 			staff_list.get(counter).getAddress());
	        	 			out.newLine();
	        	 			out.newLine();
	         }
	         out.close();
	         }
	         catch(IOException e){
	         System.out.println("There was a problem:" + e);
	         }

	}

	 
}

