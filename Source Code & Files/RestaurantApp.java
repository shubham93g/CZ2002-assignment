import java.util.Scanner;

public class RestaurantApp{
public static void main(String args[]){


//create classes

Menu m = new Menu();
PromoMenu pm = new PromoMenu(m);
TableList t = new TableList();
ReservationList rl = new ReservationList(t);
StaffList sl = new StaffList();
MemberList ml = new MemberList();
OrderList ol = new OrderList(m,pm,t,sl,ml);
RevenueReport rr = new RevenueReport(ol);

//initial menu
Scanner sc = new Scanner(System.in);
int choice=0,orderID;
System.out.println("Restaurant Reservation & Point Sale System");
System.out.println("Developed by Douglas, Sanchita & Shubham");
while (choice<12){
System.out.println("\nPress enter to continue");
sc.nextLine();
System.out.println("Make your choice (1-10):");
System.out.println("1. Create order");
System.out.println("2. View order");
System.out.println("3. Change order");
System.out.println("4. Manage reservations ");
System.out.println("5. Create/update/remove menu");
System.out.println("6. Create/update/remove promotion");
System.out.println("7. Check table availability");
System.out.println("8. Print order invoice");
System.out.println("9. Print sales revenue report");
System.out.println("10. Manage staff");
System.out.println("11. Manage members");
System.out.println("12. Quit");
choice = sc.nextInt();


//initial menu choices
switch(choice) {

case 1: ol.create();
//create order
//initialize order for table
sc.nextLine();
break;

case 2:
System.out.print("Enter orderID : ");
orderID = sc.nextInt();
Order order = ol.getOrderByID(orderID);
if(ol.checkOrderById(orderID)){
	System.out.println("Order Found\n");
	ol.viewOrder(order);
	if(order.isActive())
		System.out.println("\nOrder is currently ACTIVE");
	else
		System.out.println("\n" +
				"Order has been COMPLETED");
}
else
	System.out.println("No such order found");
//view order
//print order of choice
sc.nextLine();
break;

case 3: System.out.println("\n1. Update order\n2. Cancel order\n");
choice = sc.nextInt();
switch(choice){
		case 1:System.out.print("Enter orderID : ");
				orderID = sc.nextInt();
				ol.update(orderID);
				break;
		case 2:System.out.print("Enter orderID : ");
				orderID = sc.nextInt();
				ol.cancel(orderID);
				break;
		default : System.out.println("Error : Check input");
}
sc.nextLine();
//update order
//modify order of choice
break;

case 4:{
	int reservChoice=0;
	while (reservChoice<3){
	System.out.println("1. Create reservations\n2. Remove reservation\n3. View reservations\n4. Back");
	reservChoice = sc.nextInt();
	
	switch(reservChoice){
	
	case 1:{
		rl.createReservation();
		
		break;}
	case 2:{
		String rName;
		System.out.println("---Remove reservation---");
		System.out.println("Enter the name the resrvation is booked in: ");
		sc.nextLine();
		rName=sc.nextLine();
		rl.removeReservation(rName);
		
	break;}
	case 3:{
		String name;
		System.out.print("Input the name reservation was made by : ");
		sc.nextLine();
		name = sc.nextLine();
		rl.checkPrintReservation(name);
		
	}
	default:
			break;
	}
	
//manage reservation
//create
//reservationlist
//view reservations
//remove based on name
	}
	sc.nextLine();
break;
}
//create, update & remove menu
case 5:{
	int choice1=0;
	while (choice1 != 5 && choice1>-1){
		System.out.println("What do you want to do:");
		System.out.println("1. Create menu item");
		System.out.println("2. Update menu item");
		System.out.println("3. Remove menu item");
		System.out.println("4. View Menu");
		System.out.println("5. Back");

		choice1 = sc.nextInt();

		switch(choice1){

		case 1:{
			System.out.println("--Create menu item--");
			System.out.println("Please enter the name of the item: ");
			String setname=sc.nextLine();
			setname=sc.nextLine();
			System.out.println("Please enter the category of the item: ");
			System.out.println("1. Starter");
			System.out.println("2. Main");
			System.out.println("3. Dessert");
			System.out.println("4. Drinks");
			int setcategory=sc.nextInt();
			System.out.println("Please enter the description of the item: ");
			String setdescription=sc.nextLine();
			setdescription=sc.nextLine();
			System.out.println("Please enter the price of the item: ");
			double setprice=sc.nextDouble();
			m.createMenuItem(setname,setdescription,setprice,setcategory);
			System.out.println(setname+" added to menu");
			break;
			}

		case 2:{
			int choice2;
			System.out.println("Which item do you wish to update?");
			do{
				System.out.println("Please enter the item ID : ");
				choice2=sc.nextInt();
				if(!m.checkMenuItem(choice2))
					System.out.println("Error : Enter valid menu itemID");
			}while(!m.checkMenuItem(choice2));
			m.getMenuItemById(choice2).printMenuItem();
			int updatechoice1;
			System.out.println("What do you wish to update for this item?");
			System.out.println("1. Update item name");
			System.out.println("2. Update item category");
			System.out.println("3. Update item description");
			System.out.println("4. Update item price");
			System.out.println("5. Back");
			updatechoice1=sc.nextInt();

			switch(updatechoice1){
			case 1:{
				System.out.println("Enter the new name: ");
				String updatename1=sc.nextLine();
				updatename1=sc.nextLine();
				m.updateMenuItemName(choice2, updatename1);
				System.out.println("Menu itemID "+choice2+" had its name updated to "+updatename1);
				break;
				}
			case 2:{
				System.out.println("Enter the new category(1/2/3/4): ");
				int updatecategory1=sc.nextInt();
				m.updateMenuItemCategory(choice2, updatecategory1);
				System.out.println("Menu itemID "+choice2+" had its category updated to "+updatecategory1);
				break;
				}
			case 3:{
				System.out.println("Enter the new description : ");
				String updatedescription1=sc.nextLine();
				updatedescription1=sc.nextLine();
				m.updateMenuItemDescription(choice2, updatedescription1);
				System.out.println("Menu itemID "+choice2+" had its description updated to "+updatedescription1);
				break;
				}
			case 4:{
				System.out.println("Enter the new price: SGD ");
				double updateprice1=sc.nextDouble();
				m.updateMenuItemPrice(choice2, updateprice1);
				System.out.println("Menu itemID "+choice2+" had its name updated to "+updateprice1);
				break;
				}
			default: {
				break;
				}
			}
			break;
		}

//remove menuitem
		case 3:{
			int choice3;
			System.out.println("--Remove menu item--");
			do{
				System.out.println("Please enter the itemID of the item you wish to remove: ");
				choice3 = sc.nextInt();
				if(!m.checkMenuItem(choice3))
					System.out.println("Error : Enter valid menu itemID");
				}while(!m.checkMenuItem(choice3));
			
			System.out.println(m.getMenuItemById(choice3).getName() +" removed succesfully");
			m.removeMenuItem(choice3);
			break;
			}
		case 4:{
			m.printMenu();
			break;
		}

		default:
			break;
		}


	}
	sc.nextLine();
	break;
}
//Menu promotion
	case 6:{
		int choicePromo=0;
//choice pm
		while (choicePromo < 4){
			System.out.println("--PROMOTION MENU--");
			System.out.println("What do you want to do:");
			System.out.println("1. Create promotion menu");
			System.out.println("2. Update promotion menu");
			System.out.println("3. Remove promotion menu");
			System.out.println("4. View promotion menu");
			System.out.println("5. Back");
			choicePromo = sc.nextInt();

			switch(choicePromo){
//case 1 - create pm
			case 1:{
				pm.createMenuSet();
				break;
				}

				//update pm
			case 2:{
				int choicePromoUpdate=-1;
				pm.printPromoMenu();
				while(choicePromoUpdate<0){
					System.out.println("Which promotional menu do you wish to update?\nEnter setID : ");
					choicePromoUpdate=sc.nextInt();
					choicePromoUpdate--;
					}
				int choiceUpdateChoice=0;
				
				while(choiceUpdateChoice<5){
					System.out.println("What do you wish to update? \n 1. Items in the menu set \n 2. The set price \n 3. The set name \n 4. The set description \n 5. Finished");
					choiceUpdateChoice = sc.nextInt();

					switch(choiceUpdateChoice){

						case 1:
							pm.updateSetItems(choicePromoUpdate);
							break;

						case 2: 
							double newSetPrice;
							System.out.println("Please enter the new set price: ");
							newSetPrice=sc.nextDouble();
							pm.updateSetPrice(choicePromoUpdate, newSetPrice);
							break;

						case 3:
							String newSetName;
							System.out.println("Please enter the new set name: ");
							newSetName=sc.next();
							pm.updateSetName(choicePromoUpdate, newSetName);
							break;

						case 4:
							String newSetDescription;
							System.out.println("Please enter the new set price: ");
							newSetDescription=sc.nextLine();
							pm.updateSetDescription(choicePromoUpdate,newSetDescription);
							break;
						case 5:
							break;
					}
				}
				break;
			}

//remove menu promo
			case 3:{
				pm.printPromoMenu();
				System.out.println("Please enter the promo menu you wish to have removed\nEnter setID : ");
				int ID = sc.nextInt();
				pm.removeSetByID(ID);
				break;
			}

			case 4:{
				System.out.println("PRINTING PROMOTIONAL MENU");
				pm.printPromoMenu();
				System.out.println("------------------------------");
				break;
			}
	
			}
		}
		sc.nextLine();
	}

	break;

//table availability
	case 7:{
		int noEmptyTables;
		System.out.print("\n");
		noEmptyTables = t.showEmpty();
		System.out.println("Number of empty tables: "+noEmptyTables);
		t.show();
		sc.nextLine();
		break;
	}

//order invoice	
	case 8:{
		System.out.print("Enter orderID : ");
		orderID = sc.nextInt();
		ol.createInvoice(orderID);
		sc.nextLine();
		break;
	}

	case 9: rr.setPeriod();
			rr.generateReport();
			sc.nextLine();
//revenue report
break;


//staff
case 10: int userChoice;
	do{
	System.out.println("\nInput your choice\n1. Add new staff\n2. Remove staff\n3. View staff\n4. Back\n");
	userChoice = sc.nextInt();
	switch(userChoice){
	case 1: System.out.print("\nInput the following details\nStaff name: ");
			sc.nextLine();
			String name = sc.nextLine();
			System.out.print("Gender(m/f) : ");
			char gender = sc.next().charAt(0);
			System.out.print("Job title : ");
			sc.nextLine();
			String jobTitle = sc.nextLine();
			System.out.print("Email : ");
			String email = sc.next();
			System.out.print("Address : ");
			sc.nextLine();
			String address = sc.nextLine();
			System.out.print("Phone Number : ");
			int phoneNumber = sc.nextInt();
			sl.createStaff(name, gender, jobTitle, email, address, phoneNumber);
			System.out.println("Staff creating successful");
			break;
	case 2: System.out.print("\nInput staff ID to remove");
			int ID = sc.nextInt();
			sl.removeStaffByID(ID);
			break;
	case 3:	System.out.println("----PRINTING STAFF-----");
			sl.printAllStaff();
			break;
	case 4: break;
	default:break;
	}
	}while(userChoice!=4);
	break;
	
	//members
case 11:
	int userChoice2;
	do{
	System.out.println("\nInput your choice\n1. Add new member\n2. Remove member\n3. View member\n4. Back\n");
	userChoice2 = sc.nextInt();
	switch(userChoice2){
	case 1: System.out.print("\nInput the following details\nMember name: ");
			sc.nextLine();
			String name = sc.nextLine();
			System.out.print("Email : ");
			String email = sc.next();
			System.out.print("Address : ");
			sc.nextLine();
			String address = sc.nextLine();
			System.out.print("Phone Number : ");
			int phoneNumber = sc.nextInt();
			ml.createMember(name, email, phoneNumber, address);
			System.out.println("Member created successful");
			break;
	case 2: System.out.print("\nInput member ID to remove");
			int ID = sc.nextInt();
			ml.removeMemberByID(ID);
			break;
	case 3:	System.out.println("----PRINTING MEMBER-----");
			ml.printAllMembers();
			break;
	case 4: break;
	default:break;
	}
	}while(userChoice2!=4);
	//
	sc.nextLine();
	break;


default:break;

}
}
}
}



