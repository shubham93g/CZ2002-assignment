public class Menu{
private MenuItem Menu[] = new MenuItem[40];


 public Menu(){
  for (int i=0; i<Menu.length; i++){
   Menu[i]=new MenuItem(i); 
  }
  }
  
  
  
  public void printMenu(){
  //first sort it according to category
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
  
 
//check first available menu item
//insert values given for name, categorty, price and description
public void createMenuItem(String cname, String cdescription, double cprice, int ccategory){

int k = 0;
	while (Menu[k].getPrice() != 0.0 && Menu[k].getCategory() != 0){
		k++;
	}

	Menu[k].setPrice(cprice);
	Menu[k].setName(cname);
	Menu[k].setDescription(cdescription);
	Menu[k].setCategory(ccategory);


}



//Update menuitem
	public void updateMenuItemPrice(int itemID, double price){
		Menu[itemID].setPrice(price);
	}
	public void updateMenuItemName(int itemID, String name){
		Menu[itemID].setName(name);
	}
	public void updateMenuItemDescription(int itemID, String description){
		Menu[itemID].setDescription(description);
	}
	public void updateMenuItemCategory(int itemID, int category){
		Menu[itemID].setCategory(category);
	}



//remove menuitem, will not delete the item but make it not appear in the menu print

public void removeMenuItem(int itemID){
	Menu[itemID].clearName();
	Menu[itemID].clearPrice();
	Menu[itemID].clearCategory();
	Menu[itemID].clearDescription();
	
	
}

public MenuItem getMenuItem(int itemID){
	for(int i=0;i<Menu.length;i++)
		if(Menu[i].getItemID()==itemID)
			return Menu[i];
	return null;
}


}
