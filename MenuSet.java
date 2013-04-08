import java.util.Scanner;

public class MenuSet extends Item{
	
	private int [] menuItemID; //array of menuItem's IDs
	private Menu menu;
	private int setSize;

	//constructor
	 public MenuSet(Menu menu, int id){
	  this.menu = menu;
	  menuItemID = new int[10];
	  setSize = 0;
	  super.setID(id);
	  }
	 
	 public void CreateMenuSet(){
		 menu.printMenu();
		 Scanner sc = new Scanner(System.in);
		 int choice;
		 int userInput;
		 int index;
		 do{
		 System.out.println("Select choice\n1. Add Menu Item\n2. Remove\n3. Finish");
		 choice = sc.nextInt();
		 switch(choice){
		 case 1:if(setSize==10){
			 		System.out.println("Max items per set reached. Cannot add more items.");
		 			break;
		 		}
			 	System.out.print("Input MenuItem id to add : ");
		 		userInput = sc.nextInt();
		 		if(menu.checkMenuItem(userInput)){
		 			menuItemID[setSize] = userInput;
		 			setSize++;
		 			System.out.println("Item added to set");
		 		}
		 		else
		 			System.out.println("No such item exists in menu");
		 		break;
		 case 2:System.out.print("Input MenuItem id to remove : ");
	 			userInput = sc.nextInt();
	 			index = getIndexById(userInput);
	 			if(index!=-1){
	 				for(int j = index+1; j<setSize;j++)
	 					menuItemID[j-1] = menuItemID[j];
	 				setSize--;
	 			}
	 			else
	 				System.out.println("No such item exists in set");
	 			break;
		 case 3:break;
		 default:break;
		 	}
		 }while(choice!=3);
		 
		 String input;
		 double price;
		 System.out.print("Input set name : ");
		 input = sc.next();
		 super.setName(input);
		 System.out.print("Input set description : ");
		 input = sc.next();
		 super.setDescription(input);
		 System.out.print("Input set price : ");
		 price = sc.nextDouble();
		 super.setPrice(price);
		 System.out.println("Set creation successful");
	 }
	 
	 public void updateMenuSet(){
		 printMenuSet();
		 Scanner sc = new Scanner(System.in);
		 int choice;
		 int userInput;
		 int index;
		 do{
		 System.out.println("Select choice\n1. Add Menu Item\n2. Remove\n3. Finish");
		 choice = sc.nextInt();
		 switch(choice){
		 case 1:if(setSize==10){
			 		System.out.println("Max items per set reached. Cannot add more items.");
		 			break;
		 		}
			 	System.out.print("Input MenuItem id to add : ");
		 		userInput = sc.nextInt();
		 		if(menu.checkMenuItem(userInput)){
		 			menuItemID[setSize] = userInput;
		 			setSize++;
		 			System.out.println("Item added to set");
		 		}
		 		else
		 			System.out.println("No such item exists in menu");
		 		break;
		 case 2:System.out.print("Input MenuItem id to remove : ");
	 			userInput = sc.nextInt();
	 			index = getIndexById(userInput);
	 			if(index!=-1){ //if item exists in set
	 				for(int j = index+1; j<setSize;j++)
	 					menuItemID[j-1] = menuItemID[j];
	 				setSize--;
	 			}
	 			else
	 				System.out.println("No such item exists in set");
	 			break;
		 case 3:System.out.println("Set update complete");
			 break;
		 default:break;
		 	}
		 }while(choice!=3);
		 
	 }
	 
	 public boolean checkItemExistsInSet(int id){
		 for(int i=0;i<setSize;i++)
			 if(id==menuItemID[i])
				 return true;
		 return false;
	 }
	 
	 public int getIndexById(int id){
		 for(int i=0;i<setSize;i++)
			 if(id==menuItemID[i])
				 return i;
		 return -1;
	 }

	 public void printMenuSet(){
		  //first sort it according to category
		  int n = setSize;
		  int temp;
		  for(int i=0; i < n; i++){
			  for(int j=1; j < (n-i); j++){
				  if(menu.getMenuItemById(menuItemID[j-1]).getCategory() > menu.getMenuItemById(menuItemID[j]).getCategory()){
					  temp = menuItemID[j-1];
					  menuItemID[j-1] = menuItemID[j];
					  menuItemID[j] = temp;
					  }
				  }
			  }
		  //then print it
		  System.out.println("Name: "+getName());
		  System.out.println("Price: "+getPrice());
		  System.out.println("Description: "+getDescription());
		  for (int i=0; i<n; i++){
			  if (menu.getMenuItemById(menuItemID[i]).getCategory()!= 0)
				  System.out.println(menu.getMenuItemById(menuItemID[i]).getName()+"\n"+menu.getMenuItemById(menuItemID[i]).getDescription()+"\n");
		  System.out.println("---------------------------------------");
		  }
	 }
}
		  
 
 /*
 //Create, update, delete

  //Create new menuItemID, starting by setting 3 new dishes, starter main and dessert
  public void setDishByInfo(int category, String name, String description, double price,int getj){
  menuItemID[getj].setCategory(category);
  menuItemID[getj].setName(name);
  menuItemID[getj].setDescription(description);
  menuItemID[getj].setPrice(price); 
  }
  
  //assigns values form itemId to the category of choice
  public void setDishByItemID(int setitemID,int geti){
  menuItemID[geti].setName(menuItemID[setitemID].getName());
  menuItemID[geti].setPrice(menuItemID[setitemID].getPrice());
  menuItemID[geti].setCategory(menuItemID[setitemID].getCategory());
  menuItemID[geti].setDescription(menuItemID[setitemID].getDescription());
  }
  
  //resets the values for the menuItemID
  public void clearmenuItemID(){
  for (int i=0; i<3; i++){
   menuItemID[i].clearName();
  menuItemID[i].clearPrice();
  menuItemID[i].clearCategory();
  menuItemID[i].clearDescription();
  }
  }
  
  
  //sorts and prints the menuItemID

 }
 */