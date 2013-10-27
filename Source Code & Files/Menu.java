import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Menu{

	ArrayList <MenuItem> menu;
	BufferedWriter out;
	BufferedReader in;


	//constructor of Menu
	public Menu(){
	 		menu = new ArrayList <MenuItem>();
	
	
	
	 		//reading menu from file (menu.txt)
	 		try {
				File file = new File("menu.txt");
		        BufferedReader br = new BufferedReader(new FileReader(file));
		        List<String> lines = new ArrayList<String>();
		        String line = br.readLine();
		        String tempName;
				String tempDescription;
				int tempID;
				int tempCategory;
				double tempPrice;
		       //storing all lines in an arraylist
				while(line != null) {
		            lines.add(line.replace(">", ""));
		            line = br.readLine();
		        }
		        int i=0;
		        //get individual values from the stored arraylist
		        while (i<lines.size()){
		        	tempID = Integer.parseInt(lines.get(i));
				tempName = lines.get(i+1);
				tempCategory = Integer.parseInt(lines.get(i+2));
				tempDescription = lines.get(i+3);
				tempPrice= Double.parseDouble(lines.get(i+4));
				//creating a new menuitem with the data parsed from the arraylist
				MenuItem newMenuItem = new MenuItem(tempID, tempName, tempCategory, tempDescription, tempPrice);
				menu.add(newMenuItem);
				i=i+6;
		}
		//close the bufferedReader
	        br.close();
	        }
	        //catch exceptions
	         		  catch(IOException e){
	             System.out.println("There was a problem:" + e);
	         }
	 			catch (NumberFormatException e) {
	       }
	
		}
	 		
	  //function to print the menu
	  public void printMenu(){
		  //first sort it according to category
		  MenuItem[] menucopy = new MenuItem[menu.size()];
		  System.arraycopy(menu.toArray(), 0, menucopy, 0, menu.size());
		  int n = menucopy.length;
		  MenuItem temp;
	                for(int i=0; i < n; i++){
	                 for(int j=1; j < (n-i); j++){
	                 
	                                if(menucopy[j-1].getCategory() > menucopy[j].getCategory()){
	                                        temp = menucopy[j-1];
	                                        menucopy[j-1] = menucopy[j];
	                                        menucopy[j] = temp;
	                        }
	                	}
	                }
	  
	      //then print it
	    String pcategory=null;
	    System.out.println("--------MENU---------");
		System.out.format("%n%8s %6s %30s %9s %s%n", "Category", "ItemID", "Name", "Price", "Description");
		for (int i=0; i<n; i++){
		switch(menucopy[i].getCategory()){
			case 1: pcategory = "Starter";
					break;
			case 2: pcategory = "Main";
					break;
			case 3: pcategory = "Dessert";
					break;
			case 4: pcategory = "Drink";
					break;
		}
		System.out.format("%8s %6d %30s %4s%5.2f %s%n", pcategory,menucopy[i].getID(), menucopy[i].getName(), "SGD ", menucopy[i].getPrice(), menucopy[i].getDescription());
	 }
				
		}		
				
				//prints the menuitem for the input ID
				  public void printMenuItemByID(int id){
					 for(int i=0;i<menu.size();i++)
						 	if(menu.get(i).getID() == id){
						 	menu.get(i).printMenuItem();
						 	break;
						 	}
				  
	  }
				
	  
	  //function to check if an item with given ID exists  
	  public boolean checkMenuItem(int id){
		  for(int i=0;i<menu.size();i++)
			  if(menu.get(i).getID() == id)
				  return true;
		  return false;
	  }
	  
	  //function to auto generate menuID
	  public int generateID(){
	  int lastID;
		  for(int i=0;i<menu.size();i++) //check if there are any items with missing IDs (as compared to index)
			  if(!checkMenuItem(i))	//if yes, return this missing ID
				  return i;
		  if (menu.size()==0){
		  lastID=0;
		  }
		  else{
		  lastID = menu.get(menu.size()-1).getID(); //otherwise, get the last used ID}
		  while(checkMenuItem(lastID)) //increment it till you get a new, unused ID
			  lastID++;
			  }
		  return lastID; //return this newID
				  
	  }
	  
	 
	  //check first available menu item
	  //insert values given for name, category, price and description
	  public void createMenuItem(String cname, String cdescription, double cprice, int ccategory){
		  MenuItem newMenuItem = new MenuItem(generateID(), cname, ccategory, cdescription, cprice);
		  menu.add(newMenuItem);
		  menuOverwrite();
	  }
	
	  //gets the index in the arraylist for a menuitem with user input id
	  public int getMenuItemIndexByID(int id){
		for(int i=0;i<menu.size();i++)
			if(menu.get(i).getID() == id)
				return i;
		return -1; //if no such item with given ID exists, return -1
	  }
	
	
		public MenuItem getMenuItemById(int id){
			int index = getMenuItemIndexByID(id);
			if(index!=-1)
				return menu.get(index);
			else
				return null;
		}
	
	
		//Update menuitem
	
		//update menuitem price
		public void updateMenuItemPrice(int itemID, double price){
		int index = getMenuItemIndexByID(itemID);
			if(index!=-1){
				menu.get(index).setPrice(price);
				menuOverwrite();}
			else
				System.out.println("Update failed");
				
		}
		
		//update menuitem name
		public void updateMenuItemName(int itemID, String name){
			int index = getMenuItemIndexByID(itemID);
			if(index!=-1){
				menu.get(index).setName(name);
				menuOverwrite();}
			else
				System.out.println("Update failed");
		}
		//utdape menuitem description
		public void updateMenuItemDescription(int itemID, String description){
			int index = getMenuItemIndexByID(itemID);
			if(index!=-1){
				menu.get(index).setDescription(description);
				menuOverwrite();}
			else
				System.out.println("Update failed");
		}
		//update menuitem category
		public void updateMenuItemCategory(int itemID, int category){
			int index = getMenuItemIndexByID(itemID);
			if(index!=-1){
				menu.get(index).setCategory(category);
				menuOverwrite();}
			else
				System.out.println("Update failed");
	
		}
	
	//remove menuitem, removes item from arraylist
		public void removeMenuItem(int itemID){
			int index = getMenuItemIndexByID(itemID);
				if(index!=-1){
					menu.remove(index);
					menuOverwrite();}
				else
					System.out.println("Remove failed");
			}
	
	//overwrites the current menu.txt with the values in the arraylist menu
		public void menuOverwrite(){
	            try{
	             out = new BufferedWriter(new FileWriter("menu.txt",false)); 
	             	for(int counter=0;counter<menu.size();counter++){
	             		if (menu.get(counter).getCategory()!=0 && menu.get(counter).getPrice()!=0.0){
	             			out.write(menu.get(counter).getID()+"\n"+menu.get(counter).getName()+"\n"+String.valueOf(menu.get(counter).getCategory())+
	             					"\n"+menu.get(counter).getDescription()+
	             					"\n"+String.valueOf(menu.get(counter).getPrice()));
	             			out.newLine();
	             			out.newLine();
	             			}
	             		else{
	             			System.out.println();
	             		}
	             	}
	             out.close();
	             }
	           catch(IOException e){
	             System.out.println("There was a problem:" + e);
	             }
	
		}
	
		//function to return the id of a menuitem at index "index" in the menu arraylist
			public MenuItem getMenuItemByIndex(int index){
				return menu.get(index);
			}
	
			//simple method to get the menu
			public ArrayList<MenuItem> getMenu(){
				return menu;
			}

	
} //end of class

