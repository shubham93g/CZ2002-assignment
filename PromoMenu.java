import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class PromoMenu{
	private ArrayList <MenuSet> promoMenu;
	private Menu menu;
	BufferedWriter out;	
	BufferedReader in;
	
		//constructor
		public PromoMenu(Menu menu){
		   promoMenu = new ArrayList<MenuSet>(); 
		   this.menu = menu;
			//read from promomenu.txt  
		   try {
				File file = new File("promomenu.txt");
		        BufferedReader br = new BufferedReader(new FileReader(file));
		        List<String> lines = new ArrayList<String>();
		        String line = br.readLine();
		        String tempName;
				String tempDescription;
				int tempID;
				double tempPrice;
				int tempMenuItemID;
				int tempSetSize;
		        while(line != null) {
		            lines.add(line.replace("<", ""));
		            line = br.readLine();
		        }
		        int i=0;
		        
		while (i<lines.size()){
			 tempID = Integer.parseInt(lines.get(i));
			 tempSetSize = Integer.parseInt(lines.get(i+1));
			 MenuSet tempMenuSet = new MenuSet(menu,tempID);
			 String[] menuIDWithSeparator = lines.get(i+2).split("\\|");
			 for(int k =0;k<tempSetSize;k++){
				 tempMenuItemID=Integer.parseInt(menuIDWithSeparator[k]);
				 tempMenuSet.addMenuItem(tempMenuItemID);
			 }
			 
					tempName = lines.get(i+3);
					tempDescription = lines.get(i+4);
					tempPrice= Double.parseDouble(lines.get(i+5));
					tempMenuSet.setName(tempName);
					tempMenuSet.setDescription(tempDescription);
					tempMenuSet.setPrice(tempPrice);
					promoMenu.add(tempMenuSet);
					i=i+7;
					}
		//close the reader
			br.close();
		
			}
		   //catch exceptions
		 		  catch(IOException e){
	     System.out.println("There was a problem:" + e);
	 }
			catch (NumberFormatException e) {
	   //System.out.println("This is not a number");
	}
	
		}
		
		//automaticly generate a setID
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
		//creates a menuset
		 public void createMenuSet(){
			 int iD = generateSetID();
			 MenuSet tempMenuSet = new MenuSet(menu,iD);
			 tempMenuSet.CreateMenuSet();
			 promoMenu.add(tempMenuSet);
			 savePromoMenu();
			 
		 }
		 	 //prints the entire promomenu
		public void printPromoMenu(){   
			for (int i=0; i<promoMenu.size(); i++){
		 	 //System.out.println("Promotional menu set no."+(i+1));
				System.out.format("%n%5s %20s   %9s", "SetID","Set Name","Set Price");
				System.out.format("%n%5d %20s   %4s%5.2f", promoMenu.get(i).getID(), promoMenu.get(i).getName(), "SGD ", promoMenu.get(i).getPrice());
				promoMenu.get(i).printMenuSet();
				System.out.println("\n");
			}
		  }
		
		//prints the promomenu with id "id"
		public void printSetByID(int id){
			for(int i=0;i<promoMenu.size();i++){
				if(promoMenu.get(i).getID() == id)
					promoMenu.get(i).printMenuSet();
			}
		}
		//gets the set with id "setID"
		public MenuSet getSetByID(int setID){
			int index = getSetIndexByID(setID);
			if(index!=-1)
				return promoMenu.get(index);
			else
				return null;
		}
		//returns the index for a id "setID"
		public int getSetIndexByID(int setID){
			for(int i=0;i<promoMenu.size();i++)
				if(promoMenu.get(i).getID() == setID)
					return i;
			System.out.println("No such set exists");
			return -1; //if set doesn't exist;
		}
		//updates the set price and saves it to file
		public void updateSetPrice(int setID, double price){
			int index = getSetIndexByID(setID);
			if(index!=-1){
				promoMenu.get(index).setPrice(price);
			savePromoMenu();}
			else
				System.out.println("Update failed. Set ID invalid.");
				
		}
		//updates the set name and saves it to file
		public void updateSetName(int setID, String name){
			int index = getSetIndexByID(setID);
			if(index!=-1){
				promoMenu.get(index).setName(name);
				savePromoMenu();}
			else
				System.out.println("Update failed. Set ID invalid.");
		}
		//updates the set description and saves it to file
		public void updateSetDescription(int setID, String description){
			int index = getSetIndexByID(setID);
			if(index!=-1){
				promoMenu.get(index).setDescription(description);
			savePromoMenu();}
			else
				System.out.println("Update failed. Set ID invalid.");
		}
		//adds a menuitem with ID "menuItemID" to set with id "setID"
		public void addMenuItem(int setID, int menuItemID){
			int index = this.getSetIndexByID(setID);
			if(index!=-1){
				promoMenu.get(index).addMenuItem(menuItemID);
			}
			else
				System.out.println("Error : Invalid setID");
		}
		//updates the items in a set
		public void updateSetItems(int setID){
			int index = getSetIndexByID(setID);
			if(index!=-1){
				promoMenu.get(index).updateMenuSet();
			savePromoMenu();}
			else
				System.out.println("Update failed. Set ID invalid.");
		}
		//removes the set from the arraylist and saves to file
		public void removeSetByID(int setID){
			int index = getSetIndexByID(setID);
			if(index!=-1){
				System.out.println( promoMenu.get(index).getName() + " removed");
				promoMenu.remove(index);
			savePromoMenu();}
			else
				System.out.println("No such set exists");
		}
		
		//save (writing) to promomenu.txt
		public void savePromoMenu(){
		
			try{
		 		int id;
	            out = new BufferedWriter(new FileWriter("promomenu.txt",false)); 
	            for(int counter=0;counter<promoMenu.size();counter++){
					{
					out.write(promoMenu.get(counter).getID()+"\n"+promoMenu.get(counter).getSetSize()+"\n");
	           		for(int i=0; i<promoMenu.get(counter).getSetSize();i++){
	           		id = promoMenu.get(counter).getIDByIndex(i);
	           		//System.out.print("Test id :" + id);
	           		out.write(String.valueOf(id));
	           		out.write("|");
	           		}
	           		//add in ID
	           		out.write("\n"+promoMenu.get(counter).getName()+"\n"+promoMenu.get(counter).getDescription()+
	            			"\n"+String.valueOf(promoMenu.get(counter).getPrice()));
				out.newLine();
	 			out.newLine();
					}
	            }
	            //close writer
	             out.close();
	             }
			//catch exceptions
	 			catch(IOException e){
	 				System.out.println("There was a problem:" + e);
	 			}
			catch (NumberFormatException e) {
				}
	}

	
	
} 



