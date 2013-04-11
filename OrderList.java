import java.util.ArrayList;
import java.util.Scanner;


public class OrderList {
	
	private Menu menu; //for list of menu items
	private PromoMenu promoMenu; //for list of promo
	private TableList tableList;
	private StaffList staffList;
	private MemberList memberList;
	private ArrayList <Order> orders;
	private int activeOrders;
	
	public OrderList(Menu menu, PromoMenu promoMenu, TableList tableList, StaffList staffList, MemberList memberList){
		
		this.menu = menu;
		this.promoMenu = promoMenu;
		this.tableList = tableList;
		this.staffList  = staffList;
		this.memberList = memberList;
		orders = new ArrayList <Order>();
		activeOrders = 0;
		
//---------------need to add code to read orders from a file----------------------
		
		for(int i=0;i<orders.size();i++)
			if(orders.get(i).isActive())
				activeOrders++;
	}
	
	  //function to check if an order with given ID exists  
	  public boolean checkOrderById(int id){
		  for(int i=0;i<orders.size();i++)
			  if(orders.get(i).getOrderID() == id)
				  return true;
		  return false;
	  }
	  
	  //function to auto generate orderID
	  public int generateID(){
		  int lastID;
		  for(int i=0;i<orders.size();i++) //check if there are any orders with missing IDs (as compared to index)
			  if(!checkOrderById(i))	//if yes, return this missing ID
				  return i;
		  if (orders.size()==0)
			  lastID=0;
		  else{
			  lastID = orders.get(orders.size()-1).getOrderID(); //otherwise, get the last used ID}
		  while(checkOrderById(lastID)) //increment it till you get a new, unused ID
			  lastID++;
			  }
		  return lastID; //return this newID
				  
	  }
	  
	  private int getIndexByID(int id){
		  for(int i=0;i<orders.size();i++)
			  if(orders.get(i).getOrderID() == id)
				  return i;
		  return -1; //if not found
	  }
	  
	  public Order getOrderByID(int id){
		  for(int i=0;i<orders.size();i++)
			  if(orders.get(i).getOrderID() == id)
				  return orders.get(i);
		  return null; //if not found
	  }
	
	public void create(){
		//create order
		Scanner sc = new Scanner(System.in);
		int tableID, staffID, pax;
		boolean testBool;
		
		do{
		System.out.print("Input your staffID : ");
		staffID = sc.nextInt();
		testBool = staffList.checkStaff(staffID);
			if(!testBool)
				System.out.println("Error : Input valid staffID");
		}while(!testBool);
		do{
			System.out.print("Input no of people : ");
			pax = sc.nextInt();
			if(pax>10)
				System.out.println("Sorry. We can seat a maximum of 10 people");
		}while(pax>10);
		
		tableID  = tableList.getBestFitIndex(pax);
		if(tableID==-1)
			System.out.println("Sorry. We are completely occupied at the moment. Please wait for 15 minutes");
		else{
		System.out.print("Table " + tableID + " has been assigned to this order");
		
		int choice; //for user choice
		int menuSelection; //for selection on user menu input
		int orderID = generateID();
		int itemSize = 0;
		int setSize = 0;
		Order order = new Order(orderID,itemSize,setSize,staffID,tableID,pax);
		
		do{	
		System.out.println("1. Add Menu Item\n2. Add Menu Set\n3. Finish");
		choice = sc.nextInt();
		switch(choice){
			case 1: //menu.printMenu();
					System.out.print("Input Menu Item ID to add : ");
					menuSelection = sc.nextInt();
					if(menu.checkMenuItem(menuSelection)){ //if item exists
						order.addMenuItem(menuSelection);
						itemSize++;
					System.out.println(menu.getMenuItem(menuSelection).getName() +" added");
					}
					else //if item doesnt exist
						System.out.println("Error : Input valid item ID");
					break;
			case 2: //menu.printMenu();
					System.out.print("Input Menu Set to add : ");
					menuSelection = sc.nextInt();
					if(promoMenu.getSetIndexByID(menuSelection)!=-1){ //if set exists
						order.addMenuSet(menuSelection);
						setSize++;
					System.out.println(promoMenu.getSetByID(menuSelection).getName() +" added");
					}
					else //if set doesnt exist
						System.out.println("Error : Input valid set ID");
					break;
			case 3: if(setSize==0 && itemSize==0){ //no items were added
						System.out.println("Error : Order is empty. Please add items before finishing");
						choice = 1; //to prevent the loop from ending
					}
					else{
						orders.add(order);
						tableList.occupyTable(tableID);
						System.out.println("Order creation successful");
						this.viewOrder(order);
						activeOrders++;
					}
					break;
			default:System.out.println("Check input value");
					break;
			}
		}while(choice!=3);
		}
	}
	
	public void update(int orderID){
		//update order
		int index = this.getIndexByID(orderID);
		Order order = orders.get(index);
		int menuSelection;
		int choice;
		Scanner sc = new Scanner(System.in);
		if(!order.isActive())
			System.out.println("Error : Order has already completed");
		else if(index==-1)
			System.out.println("Error : Invalid order ID");
		else{ //if order is active
			do{
			System.out.println("1. Add Menu Item\n2.Add Menu Set\n3.Remove Menu Item\n4. Remove Menu Set\n5. Finish");
			choice = sc.nextInt();
			switch(choice){
				case 1: viewOrder(order);
						System.out.print("Input item ID to add : ");
						menuSelection  = sc.nextInt();
						if(menu.checkMenuItem(menuSelection)){ //if item exists
							order.addMenuItem(menuSelection);
							System.out.println(menu.getMenuItem(menuSelection).getName() +" added");
						}
						else //if item doesnt exist
							System.out.println("Error : Input valid item ID");
						break;
						
				case 2: this.viewOrder(order);
						System.out.print("Input set ID to add : ");
						menuSelection  = sc.nextInt();
						if(promoMenu.getSetIndexByID(menuSelection)!=-1){ //if set exists
							order.addMenuSet(menuSelection);
							System.out.println(promoMenu.getSetByID(menuSelection).getName() +" added");
						}
						else //if set doesnt exist
							System.out.println("Error : Input valid set ID");
						break;
						
				case 3: viewOrder(order);
						System.out.print("Input item ID to remove : ");
						menuSelection  = sc.nextInt();
						if(order.checkItemByID(menuSelection)){ //if item exists
							order.removeMenuItem(menuSelection);
							System.out.println(menu.getMenuItem(menuSelection).getName() +" removed");
						}
						else //if item doesnt exist
							System.out.println("Error : Input valid item ID");
						break;
						
				case 4: this.viewOrder(order);
						System.out.print("Input set ID to remove : ");
						menuSelection  = sc.nextInt();
						if(order.checkSetByID(menuSelection)){ //if set exists
							order.removeMenuSet(menuSelection);
							System.out.println(promoMenu.getSetByID(menuSelection).getName() +" removed");
						}
						else //if set doesnt exist
							System.out.println("Error : Input valid set ID");
						break;
		
				case 5: System.out.println("Order update successful");
						this.viewOrder(order);
						orders.remove(index); //remove old order
						orders.add(order); //re-add updated order
						break;
				default:System.out.println("Check input value");
						break;
			}
		}while(choice!=5);
		}
	}
	
	public void cancel(int orderID){
		//remove order
		int index;
		Order order;
		if(!this.checkOrderById(orderID))
			System.out.println("Error : Invalid order ID");
		else{
			index = this.getIndexByID(orderID);
			order = orders.get(index);
			this.viewOrder(order);
			tableList.vacateTable(order.getTableID());
			orders.remove(index);
			activeOrders--;
			System.out.println("Order cancelled. Table " +order.getTableID() + " is now vacant");
		}
		
	}

	
	public double calculateSum(Order order){
		//calculate total sum of order
		double price = 0;
		for(int i=0;i<order.getItemSize();i++)
			price += menu.getMenuItemById(order.getItemIdByIndex(i)).getPrice();
		for(int j=0;j<order.getSetSize();j++)
			price += promoMenu.getSetByID(order.getSetIdByIndex(j)).getPrice();
		return price;
	}
	
	public void viewOrder(Order order){
		//display order details
		System.out.println(order.getDate().toString());
		System.out.println("Menu Items");
		for(int i=0;i<order.getItemSize();i++){
			System.out.println(i+1 +". ");
			menu.getMenuItemById(order.getItemIdByIndex(i)).printMenuItem();
		}
		System.out.println("Menu Sets");
		for(int j=0;j<order.getSetSize();j++){
			System.out.println(j+1 +". ");
			promoMenu.getSetByID(order.getSetIdByIndex(j)).printMenuSet();
		}
	}
	
	public void createInvoice(int orderID){
		//create Invoice
		int index = this.getIndexByID(orderID);
		Order order = orders.get(index);
		viewOrder(order);
		double price = calculateSum(order);
		Scanner sc = new Scanner(System.in);
		System.out.print("Are you a member ? (y/n");
		String answer = sc.next();
		int memberID;
		if(answer=="y" || answer=="Y" || answer=="YES"||answer=="yes"){
			System.out.print("Input memberID : ");
			memberID = sc.nextInt();
			if(memberList.checkMember(memberID)){
				order.orderIsByMember();
				System.out.println("Members enjoy 10% discount");
				System.out.println("Total Price : " + price);
				System.out.println("GST : 7%");
				System.out.println("Discount : 10%");
				System.out.println("Price after discount & GST : " + price*0.9*1.07);
			}
			else
				System.out.println("Invalid memberID");
		}
		System.out.println("Total Price : " + price);
		System.out.println("GST : 7%");
		System.out.println("Price after GST : " + price*1.07);
		
		order.closeOrder();
		tableList.vacateTable(order.getTableID());
		orders.remove(index);
		orders.add(order);
		activeOrders--;
	}
	
	public int getActiveOrders(){
		return activeOrders;
	}

}
