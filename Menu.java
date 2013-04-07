import java.util.ArrayList;

public class Menu{

	ArrayList <MenuItem> menu;

 	public Menu(){
 		menu = new ArrayList <MenuItem>();
 	}
  
  
  
  public void printMenu(){
	  //first sort it according to category
	  MenuItem[] Menu = new MenuItem[menu.size()];
	  System.arraycopy(menu.toArray(), 0, Menu, 0, menu.size());
	  int n = Menu.length;
	  MenuItem temp;
  
                for(int i=0; i < n; i++){
                 for(int j=1; j < (n-i); j++){
                 
                                if(Menu[j-1].getCategory() > Menu[j].getCategory()){
                                        temp = Menu[j-1];
                                        Menu[j-1] = Menu[j];
                                        Menu[j] = temp;
                        }
                	}
                }
  
      //then print it
  
	  for (int i=0; i<n; i++){
	  if (Menu[i].getCategory() != 0)
	  System.out.println(Menu[i].getName()+"\n"+Menu[i].getDescription()+"\n"+Menu[i].getPrice());
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
	  for(int i=0;i<menu.size();i++) //check if there are any items with missing IDs (as compared to index)
		  if(!checkMenuItem(i))	//if yes, return this missing ID
			  return i;
	  
	  int lastID = menu.get(menu.size()-1).getID(); //otherwise, get the last used ID
	  while(checkMenuItem(lastID)) //increment it till you get a new, unused ID
		  lastID++;
	  return lastID; //return this newID
			  
  }
  
 
//check first available menu item
//insert values given for name, category, price and description
public void createMenuItem(String cname, String cdescription, double cprice, int ccategory){
	MenuItem newMenuItem = new MenuItem(generateID(), cname, ccategory, cdescription, cprice);
	menu.add(newMenuItem);
}

//return index of menuItem with given ID if it exists
public int getMenuItemIndex(int id){
	for(int i=0;i<menu.size();i++)
		if(menu.get(i).getID() == id)
			return i;
	return -1; //if no such item with given ID exists, return -1
}

//Update menuitem
	public void updateMenuItemPrice(int itemID, double price){
		int index = getMenuItemIndex(itemID);
		if(index!=-1)
			menu.get(index).setPrice(price);
		else
			System.out.println("Update failed");
			
	}
	public void updateMenuItemName(int itemID, String name){
		int index = getMenuItemIndex(itemID);
		if(index!=-1)
			menu.get(index).setName(name);
		else
			System.out.println("Update failed");
	}
	public void updateMenuItemDescription(int itemID, String description){
		int index = getMenuItemIndex(itemID);
		if(index!=-1)
			menu.get(index).setDescription(description);
		else
			System.out.println("Update failed");
	}
	public void updateMenuItemCategory(int itemID, int category){
		int index = getMenuItemIndex(itemID);
		if(index!=-1)
			menu.get(index).setCategory(category);
		else
			System.out.println("Update failed");
	}



//remove menuitem, will not delete the item but make it not appear in the menu print

public void removeMenuItem(int itemID){
	int index = getMenuItemIndex(itemID);
	if(index!=-1)
		menu.remove(index);
	else
		System.out.println("Remove failed");
	
	}
}
