import java.util.ArrayList;
import java.io.*;
import java.util.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

public class PromoMenu{
	private ArrayList <MenuSet> promoMenu;
	private Menu menu;
	BufferedWriter out;	
	BufferedReader in;
	public PromoMenu(Menu menu){
	   promoMenu = new ArrayList<MenuSet>(); 
	   this.menu = menu;
	try {
		File file = new File("promomenu.txt");
        BufferedReader br = new BufferedReader(new FileReader(file));
        List<String> lines = new ArrayList<String>();
        String line = br.readLine();
        String tempName;
		String tempDescription;
		int tempID;
		int tempCategory;
		double tempPrice;
		int tempMenuItemID;
        while(line != null) {
            lines.add(line.replace("|", ""));
            line = br.readLine();
        }
        int i=0;
        
while (i<lines.size()){
	 tempID = Integer.parseInt(lines.get(i+1));
	 MenuSet tempMenuSet = new MenuSet(menu,tempID);
	 tempMenuSet.CreateMenuSet();
	 promoMenu.add(tempMenuSet);
	String[] strArray = lines.get(i).split(" | ");
	for(int j = 0; j < strArray.length; j++) {
	     tempMenuItemID= Integer.parseInt(strArray[j]);
	     promoMenu.addMenuItemToMenuSet(tempID, tempMenuItemID);
	}
	



tempName = lines.get(i+2);
tempDescription = lines.get(i+3);
tempPrice= Double.parseDouble(lines.get(i+4));
i=i+5;
}
	br.close();

	}
 		  catch(IOException e){
     System.out.println("There was a problem:" + e);
 }
		catch (NumberFormatException e) {
   //System.out.println("This is not a number");
}

	}
	
	//SetID
	// 1 | 2 | 3 | 4
	// Name
	// Description
	// Price
	//
	
	 public int generateSetID(){
		 for(int i=0;i<promoMenu.size();i++) //check if there are any items with missing IDs (as compared to index)
			  if(getSetIndexByID(i)==-1)	//if yes, return this missing ID
				  return i;
			if (promoMenu.size()==0){
	  	return 0;
	  	}
	  	else{
		  int lastID = promoMenu.get(promoMenu.size()-1).getID(); //otherwise, get the last used ID
		  while(getSetIndexByID(lastID)!=-1) {//increment it till you get a new, unused ID
			  lastID++;}
		  return lastID;}
		  
	 }
	
	 public void createMenuSet(){
		 int iD = generateSetID();
		 MenuSet tempMenuSet = new MenuSet(menu,iD);
		 tempMenuSet.CreateMenuSet();
		 promoMenu.add(tempMenuSet);
		 
	 }
	 	 
	public void printPromoMenu(){   
		for (int i=0; i<promoMenu.size(); i++){
	 	 System.out.println("Promotional menu set no."+(i+1));
	 	 promoMenu.get(i).printMenuSet();
	 	 System.out.println("\n");
		}
	  }
	
	public void printSetByID(int id){
		for(int i=0;i<promoMenu.size();i++){
			if(promoMenu.get(i).getID() == id)
				promoMenu.get(i).printMenuSet();
		}
	}
	public MenuSet getSetByID(int setID){
		int index = getSetIndexByID(setID);
		if(index!=-1)
			return promoMenu.get(index);
		else
			return null;
	}
	
	public int getSetIndexByID(int setID){
		for(int i=0;i<promoMenu.size();i++)
			if(promoMenu.get(i).getID() == setID)
				return i;
		System.out.println("No such set exists");
		return -1; //if set doesn't exist;
	}
	
	public void updateSetPrice(int setID, double price){
		int index = getSetIndexByID(setID);
		if(index!=-1)
			promoMenu.get(index).setPrice(price);
		else
			System.out.println("Update failed. Set ID invalid.");
			
	}
	public void updateSetName(int setID, String name){
		int index = getSetIndexByID(setID);
		if(index!=-1)
			promoMenu.get(index).setName(name);
		else
			System.out.println("Update failed. Set ID invalid.");
	}
	public void updateSetDescription(int setID, String description){
		int index = getSetIndexByID(setID);
		if(index!=-1)
			promoMenu.get(index).setDescription(description);
		else
			System.out.println("Update failed. Set ID invalid.");
	}
	
	public void addMenuItem(int setID, int menuItemID){
		int index = this.getSetIndexByID(setID);
		if(index!=-1){
			promoMenu.get(index).addMenuItem(menuItemID);
		}
		else
			System.out.println("Error : Invalid setID");
	}
	
	public void updateSetItems(int setID){
		int index = getSetIndexByID(setID);
		if(index!=-1)
			promoMenu.get(index).updateMenuSet();
		else
			System.out.println("Update failed. Set ID invalid.");
	}
	
	public void removeSetByID(int setID){
		int index = getSetIndexByID(setID);
		if(index!=-1)
			promoMenu.remove(index);
		else
			System.out.println("No such set exists");
	}
	
	
	public void savePromoMenu(){
	
 try{
 
            out = new BufferedWriter(new FileWriter("promomenu.txt",false)); 
            for(int counter=0;counter<promoMenu.size();counter++){
				{
				out.write(promoMenu.get(counter).getID()+"\n");
           		for(int i=0; i<promoMenu.get(counter).getSetSize();i++){
           		out.write(promoMenu.get(counter).getIDByIndex(i));
           		out.write(" | ");
           		}
           		//add in ID
           		out.write("\n"+promoMenu.get(counter).getName()+"\n"+promoMenu.get(counter).getDescription()+
            			"\n"+String.valueOf(promoMenu.get(counter).getPrice()));
			out.newLine();
 			out.newLine();
				}
            }
             out.close();
             }
 			catch(IOException e){
 				System.out.println("There was a problem:" + e);
 			}
		catch (NumberFormatException e) {
   //System.out.println("This is not a number");
			}
	}

	
	
} 



