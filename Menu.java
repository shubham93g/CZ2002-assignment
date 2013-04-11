import java.util.ArrayList;
import java.io.*;
import java.util.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.List;

public class Menu{

ArrayList <MenuItem> menu;
BufferedWriter out;
BufferedReader in;

public Menu(){
 		menu = new ArrayList <MenuItem>();
 		//read values from menu.txt



//to read menu into arraylist of text
//add read write itemID
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
        while(line != null) {
            lines.add(line.replace(">", ""));
            line = br.readLine();
        }
        int i=0;
        
while (i<lines.size()){
tempID = Integer.parseInt(lines.get(i));
tempName = lines.get(i+1);
tempCategory = Integer.parseInt(lines.get(i+2));
tempDescription = lines.get(i+3);
tempPrice= Double.parseDouble(lines.get(i+4));
MenuItem newMenuItem = new MenuItem(tempID, tempName, tempCategory, tempDescription, tempPrice);
menu.add(newMenuItem);
/*
createMenuItem(tempName,tempDescription, tempPrice,tempCategory);*/
i=i+5;
}
//menuOverwrite();
        
      /*  
        for(String l : lines) {
            System.out.println(l);
        }*/
        br.close();
        }
        
         		  catch(IOException e){
             System.out.println("There was a problem:" + e);
         }
 			catch (NumberFormatException e) {
           //System.out.println("This is not a number");
       }

	}
 		
  
  public void printMenu(){
//first sort it according to category*/
System.out.println("teststart");
System.out.println(menu);
System.out.println("testend");
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
	for (int i=0; i<n; i++){
	if (menucopy[i].getCategory()==1)
	{pcategory="Starter";
	}
	else if (menucopy[i].getCategory()==2){
	pcategory="Main";
	}
	else if (menucopy[i].getCategory()==3){
	pcategory="Dessert";
	}

	if (menucopy[i].getCategory() != 0)
	System.out.println(pcategory+" with itemID: "+menucopy[i].getID()+" \n"+menucopy[i].getName()+"\n"+menucopy[i].getDescription()+"\n"+menucopy[i].getPrice()+" SGD");
   	System.out.println("---------------------------\n");
 }
			
	}		
			
			
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
	public void updateMenuItemPrice(int itemID, double price){
	int index = getMenuItemIndexByID(itemID);
		if(index!=-1){
			menu.get(index).setPrice(price);
			menuOverwrite();}
		else
			System.out.println("Update failed");
			
	}
	public void updateMenuItemName(int itemID, String name){
		int index = getMenuItemIndexByID(itemID);
		if(index!=-1){
			menu.get(index).setName(name);
			menuOverwrite();}
		else
			System.out.println("Update failed");
	}
	public void updateMenuItemDescription(int itemID, String description){
		int index = getMenuItemIndexByID(itemID);
		if(index!=-1){
			menu.get(index).setDescription(description);
			menuOverwrite();}
		else
			System.out.println("Update failed");
	}
	public void updateMenuItemCategory(int itemID, int category){
		int index = getMenuItemIndexByID(itemID);
		if(index!=-1){
			menu.get(index).setCategory(category);
			menuOverwrite();}
		else
			System.out.println("Update failed");

	}

//remove menuitem, will not delete the item but make it not appear in the menu print

public void removeMenuItem(int itemID){
int index = getMenuItemIndexByID(itemID);
	if(index!=-1){
		menu.remove(index);
		menuOverwrite();}
	else
		System.out.println("Remove failed");
	}

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


public MenuItem getMenuItem(int itemID){
	for(int i=0;i<menu.size();i++)
		if(menu.get(i).getID()==itemID)
			return menu.get(i);
	return null;
}
public ArrayList<MenuItem> getMenu(){
return menu;
}






}