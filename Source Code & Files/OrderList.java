import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Scanner;


public class OrderList {
	
	private Menu menu; //for list of menu items
	private PromoMenu promoMenu; //for list of promo
	private TableList tableList;
	private StaffList staffList;
	private MemberList memberList;
	private ArrayList <Order> orders;
	private int activeOrders;
	
	BufferedWriter out;
	BufferedReader in;
	
	//constructor
	//also reads previous orders from the orderlist.txt
	public OrderList(Menu menu, PromoMenu promoMenu, TableList tableList, StaffList staffList, MemberList memberList){
		
		this.menu = menu;
		this.promoMenu = promoMenu;
		this.tableList = tableList;
		this.staffList  = staffList;
		this.memberList = memberList;
		orders = new ArrayList <Order>();
		activeOrders = 0;
		
		//initializing the file at the beginning of the program
		try {
			File file = new File("order.txt");
	        BufferedReader br = new BufferedReader(new FileReader(file));
	        List<String> lines = new ArrayList<String>();
	        String line = br.readLine();
	        while(line != null) {
	            lines.add(line.replace(">", ""));
	            line = br.readLine();
	        }
	        //data storing sequence
	        //orderID
	        //staffID
	        //tableID
	        //pax
	        //itemSize
	        //[]itemID
	        //setSize
	        //[]setID
	        //isMember
	        //active
	        //Price
	        //date
	        int orderID, staffID, tableID, pax, itemSize, setSize, tempItemID, tempSetID;
	        boolean isMember, active;
	        double price;
	        Order order;
	        Calendar date = Calendar.getInstance();
	        while(line != null) {
	            lines.add(line.replace("<", ""));
	            line = br.readLine();
	        }
	        int i=0;
	        
	        while (i<lines.size()){
				 orderID = Integer.parseInt(lines.get(i));
				 staffID = Integer.parseInt(lines.get(i+1));
				 tableID = Integer.parseInt(lines.get(i+2));
				 pax = 	   Integer.parseInt(lines.get(i+3));
				 itemSize= Integer.parseInt(lines.get(i+4));
				 String[] itemID = lines.get(i+5).split("\\|");
				 setSize = Integer.parseInt(lines.get(i+6));				
				 String[] setID = lines.get(i+7).split("\\|");
				 isMember= Boolean.parseBoolean(lines.get(i+8)); 
				 active =  Boolean.parseBoolean(lines.get(i+9)); 
				 price =   Double.parseDouble(lines.get(i+10));
				 String[] stringDate = lines.get(i+11).split("\\|");
				 //format for date : year month day hour minute
				 date.set(Integer.parseInt(stringDate[0]), 
				 Integer.parseInt(stringDate[1]),Integer.parseInt(stringDate[2]), Integer.parseInt(stringDate[3]), Integer.parseInt(stringDate[4]));
				 order =   new Order(orderID,0,0,staffID,tableID,pax,date.getTime(),isMember,active,price);
				 for(int k =0;k<itemSize;k++){
					 tempItemID=Integer.parseInt(itemID[k]);
					 order.addMenuItem(tempItemID);
				 	}
				 for(int l =0;l<setSize;l++){
					 tempSetID=Integer.parseInt(setID[l]);
					 order.addMenuSet(tempSetID);
				 	}
				 orders.add(order);
				 if(order.isActive())
				 	tableList.occupyTable(tableID);
				 i+=13;
			}
				br.close();
		
		}
	 		  catch(IOException e){
	 			  System.out.println("There was a problem:" + e);
	 		  }
			catch (NumberFormatException e) {
				//System.out.println("This is not a number");
			}
		
		for(int i=0;i<orders.size();i++)
			if(orders.get(i).isActive())
				activeOrders++;
	}
	
	//function to write orders to orderlist.txt
	public void orderOverWrite(){
        try{
         out = new BufferedWriter(new FileWriter("order.txt",false)); 
         int tempItemID, tempSetID;
         Calendar date = Calendar.getInstance();
       //data storing sequence
	        //orderID
	        //staffID
	        //tableID
	        //pax
	        //itemSize
	        //[]itemID
	        //setSize
	        //[]setID
	        //isMember
	        //active
	        //Price
	        //date
         for(int counter=0;counter<orders.size();counter++){
        	 date.setTime(orders.get(counter).getDate());
	 out.write(orders.get(counter).getOrderID()+"\n"+
    		   orders.get(counter).getStaffID()+"\n"+
    		   orders.get(counter).getTableID()+"\n"+
    		   orders.get(counter).getPax()+"\n"+
    		   orders.get(counter).getItemSize()+"\n");
	 		for(int i=0;i<orders.get(counter).getItemSize();i++){
	 			tempItemID = orders.get(counter).getItemIdByIndex(i);
	 			out.write(String.valueOf(tempItemID)+"|");
	 		}
	 			out.write("\n"+orders.get(counter).getSetSize()+"\n");
	 		for(int j=0;j<orders.get(counter).getItemSize();j++){
		 			tempSetID = orders.get(counter).getSetIdByIndex(j);
		 			out.write(String.valueOf(tempSetID)+"|");
		 		}	
    		   out.write("\n"+orders.get(counter).isMember()+"\n"+
		 		orders.get(counter).isActive()+"\n"+
    		   String.valueOf(orders.get(counter).getTotalPrice())+"\n"+
		 		date.get(Calendar.YEAR)+"|"+date.get(Calendar.MONTH)+"|"+date.get(Calendar.DAY_OF_MONTH)+"|"+date.get(Calendar.HOUR_OF_DAY)+"|"+date.get(Calendar.MINUTE)+"|");
				out.newLine();
				out.newLine();
        }
         out.close();
         }
         catch(IOException e){
         System.out.println("There was a problem:" + e);
         }

}
	
	//function to check if an order with given orderID exists  
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
	  
	//function to return ArrayList index of given orderID
	public int getIndexByID(int id){
		  for(int i=0;i<orders.size();i++)
			  if(orders.get(i).getOrderID() == id)
				  return i;
		  return -1; //if not found
	  }
	
	//function to return the entire order with given orderID  
	public Order getOrderByID(int id){
		  for(int i=0;i<orders.size();i++)
			  if(orders.get(i).getOrderID() == id)
				  return orders.get(i);
		  return null; //if not found
	  }
	
	//function to return order with given index of the ArrayList
	public Order getOrderByIndex(int index){
		  return orders.get(index);
	  }
	  
	//function to create a new order
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
			else if(pax<=0)
				System.out.println("Please input a valid number");
		}while(pax>10 || pax<=0);
		
		tableID  = tableList.getBestFitEmptyIndex(pax);
		if(tableID==-1)
			System.out.println("Sorry. We are completely occupied at the moment. Please wait for 15 minutes");
		else{
		System.out.print("Table " + tableID + " with capacity "+tableList.getTable(tableID).getCapacity() + " assigned");
		
		int choice; //for user choice
		int menuSelection; //for selection on user menu input
		int orderID = generateID();
		int itemSize = 0;
		int setSize = 0;
		Order order = new Order(orderID,itemSize,setSize,staffID,tableID,pax);
		
		do{	
		System.out.println("\n1. Add Menu Item\n2. Add Menu Set\n3. Finish");
		choice = sc.nextInt();
		switch(choice){
			case 1: menu.printMenu();
					System.out.print("Input Menu Item ID to add : ");
					menuSelection = sc.nextInt();
					if(menu.checkMenuItem(menuSelection)){ //if item exists
						order.addMenuItem(menuSelection);
						itemSize++;
					System.out.println(menu.getMenuItemById(menuSelection).getName() +" added");
					}
					else //if item doesnt exist
						System.out.println("Error : Input valid item ID");
					break;
			case 2: promoMenu.printPromoMenu();
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
					else{ //if items were added
						order.setTotalPrice(calculateSum(order));
						orders.add(order);
						//occupy table only when order has successfully been placed
						tableList.occupyTable(tableID);
						System.out.println("Order creation successful");
						this.viewOrder(order);
						orderOverWrite();
						activeOrders++;
					}
					break;
			default:System.out.println("Check input value");
					break;
			}
		}while(choice!=3);
		}
	}
	
	//function to update order with given orderID
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
		else{ //if order is active and valid
			viewOrder(order);
			do{
			System.out.println("\n1. Add Menu Item\n2. Add Menu Set\n3. Remove Menu Item\n4. Remove Menu Set\n5. Finish");
			choice = sc.nextInt();
			switch(choice){
				case 1: 
						System.out.print("Input item ID to add : ");
						menuSelection  = sc.nextInt();
						if(menu.checkMenuItem(menuSelection)){ //if item exists
							order.addMenuItem(menuSelection);
							System.out.println(menu.getMenuItemById(menuSelection).getName() +" added");
						}
						else //if item doesnt exist
							System.out.println("Error : Input valid item ID");
						sc.nextLine();
						System.out.println("\nPress enter to continue");
						sc.nextLine();
						break;
						
				case 2: 
						System.out.print("Input set ID to add : ");
						menuSelection  = sc.nextInt();
						if(promoMenu.getSetIndexByID(menuSelection)!=-1){ //if set exists
							order.addMenuSet(menuSelection);
							System.out.println(promoMenu.getSetByID(menuSelection).getName() +" added");
						}
						else //if set doesnt exist
							System.out.println("Error : Input valid set ID");
						sc.nextLine();
						System.out.println("\nPress enter to continue");
						sc.nextLine();
						break;
						
				case 3: 
						System.out.print("Input item ID to remove : ");
						menuSelection  = sc.nextInt();
						if(order.checkItemByID(menuSelection)){ //if item exists
							order.removeMenuItem(menuSelection);
							System.out.println(menu.getMenuItemById(menuSelection).getName() +" removed");
						}
						else //if item doesnt exist
							System.out.println("Error : Input valid item ID");
						sc.nextLine();
						System.out.println("\nPress enter to continue");
						sc.nextLine();
						break;
						
				case 4: 
						System.out.print("Input set ID to remove : ");
						menuSelection  = sc.nextInt();
						if(order.checkSetByID(menuSelection)){ //if set exists
							order.removeMenuSet(menuSelection);
							System.out.println(promoMenu.getSetByID(menuSelection).getName() +" removed");
						}
						else //if set doesnt exist
							System.out.println("Error : Input valid set ID");
						sc.nextLine();
						System.out.println("\nPress enter to continue");
						sc.nextLine();
						break;
		
				case 5: if(order.getSetSize() ==0 && order.getItemSize()==0){ //no items in order
							System.out.println("\nError : Order is now empty. You have to add atleast 1 set or 1 item");
							choice = 1;
							sc.nextLine();
							System.out.println("\nPress enter to continue");
							sc.nextLine();
				}
				else{
						System.out.println("Order update successful");
						this.viewOrder(order);
						order.setTotalPrice(calculateSum(order));
						orders.remove(index); //remove old order
						orders.add(order); //re-add updated order
						orderOverWrite();
				}
						break;
				default:System.out.println("Check input value");
					System.out.println("\nPress enter to continue");
					sc.nextLine();
						break;
			}
		}while(choice!=5);
		}
	}
	
	//function to cancel order with given orderID
	public void cancel(int orderID){
		//remove order
		int index;
		Order order;
		if(!this.checkOrderById(orderID))
			System.out.println("Error : Invalid order ID");
		else{ //if order exists
			index = this.getIndexByID(orderID);
			order = orders.get(index);
			if(!order.isActive()){
				System.out.println("\nOrder has already been completed. Cannot cancel this order");
				return;
			}
			this.viewOrder(order);
			tableList.vacateTable(order.getTableID());
			orders.remove(index);
			orderOverWrite();
			activeOrders--;
			System.out.println("\nOrder cancelled. Table " +order.getTableID() + " is now vacant");
		}
		
	}

	//function to calculate order's total price (excluding GST)
	public double calculateSum(Order order){
		//calculate total sum of order
		double price = 0;
		for(int i=0;i<order.getItemSize();i++)
			price += menu.getMenuItemById(order.getItemIdByIndex(i)).getPrice();
		for(int j=0;j<order.getSetSize();j++)
			price += promoMenu.getSetByID(order.getSetIdByIndex(j)).getPrice();
		return price;
	}
	
	//function to view order details
	public void viewOrder(Order order){
		//display order details
		System.out.println(order.getDate().toString());
		System.out.println("Order ID : " + order.getOrderID());
		System.out.println("Table ID : " + order.getTableID());
		System.out.println("Staff ID : " + order.getStaffID());
		System.out.println("\nMenu Items");
		System.out.format("%2s %-6s %30s    %9s","#", "ItemID", "Item Name", "Price");
		for(int i=0;i<order.getItemSize();i++){
			System.out.format("%n%2d %6d %30s    %4s%5.2f",i+1,
					menu.getMenuItemById(order.getItemIdByIndex(i)).getID(),
					menu.getMenuItemById(order.getItemIdByIndex(i)).getName(),
					"SGD ",
					menu.getMenuItemById(order.getItemIdByIndex(i)).getPrice());
		}
		System.out.println("\n\nMenu Sets");
		System.out.format("%2s %6s %30s    %9s","#", "SetID", "Set Name", "Price");
		for(int j=0;j<order.getSetSize();j++){
			System.out.format("%n%2d %6d %30s    %4s%5.2f",j+1,
					promoMenu.getSetByID(order.getSetIdByIndex(j)).getID(),
					promoMenu.getSetByID(order.getSetIdByIndex(j)).getName(),
					"SGD ",
					promoMenu.getSetByID(order.getSetIdByIndex(j)).getPrice());
		}
	}
	
	//function to create invoice of given orderID
	public void createInvoice(int orderID){
		//create Invoice
		int index = this.getIndexByID(orderID);
		if(index==-1){
			System.out.println("\nNo such order exists\n");
			return;
		}
		Order order = orders.get(index);
		if(!order.isActive()){
			System.out.println("\nOrder is already complete\n");
			return;
		}
		viewOrder(order);
		double price = calculateSum(order);
		Scanner sc = new Scanner(System.in);
		System.out.print("\nAre you a member ? (y/n) : ");
		String answer = sc.next();
		int memberID;
		if(answer.equals("y")|| answer.equals("Y") || answer.equals("YES")||answer.equals("yes")){
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
		
		tableList.vacateTable(order.getTableID());
		order.closeOrder();
		order.setTotalPrice(price);
		orders.remove(index);
		orders.add(order);
		orderOverWrite();
		activeOrders--;
	}
	
	public int getActiveOrders(){
		return activeOrders;
	}
	
	public int getSize(){
		return orders.size();
	}

}
