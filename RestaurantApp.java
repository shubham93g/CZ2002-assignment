import java.util.Scanner;
import java.util.ArrayList;
import java.io.*;
import java.util.*;

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

while (choice<11){
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
break;

case 2:
System.out.print("Enter orderID : ");
orderID = sc.nextInt();
Order order = ol.getOrderByID(orderID);
if(ol.checkOrderById(orderID))
	ol.viewOrder(order);
//view order
//print order of choice
break;

case 3: System.out.println("\n\n1. Update order\n2.Cancel order\n");
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
//update order
//modify order of choice
break;

case 4:{
	int reservChoice=0;
	while (reservChoice<2){
	System.out.println("1. Show reservations\n2. Back");
	reservChoice = sc.nextInt();
	
	switch(reservChoice){
	case 1:{
		rl.printReservation();
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
int setcategory=sc.nextInt();
System.out.println("Please enter the description of the item: ");
String setdescription=sc.nextLine();
setdescription=sc.nextLine();
System.out.println("Please enter the price of the item: ");
double setprice=sc.nextDouble();
m.createMenuItem(setname,setdescription,setprice,setcategory);
break;
}

case 2:{
int choice2;
System.out.println("Which item do you wish to update?");
System.out.println("Please enter the item ID");
choice2=sc.nextInt();
System.out.print("For itemID: "+choice2);
//while loop to check itemID exists etc.

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
System.out.println("Enter the new name");
String updatename1=sc.nextLine();
updatename1=sc.nextLine();
m.updateMenuItemName(choice2, updatename1);
System.out.println("Menu item"+choice2+" had its name updated to "+updatename1);
break;}
case 2:{
System.out.println("Enter the new category");
int updatecategory1=sc.nextInt();
m.updateMenuItemCategory(choice2, updatecategory1);
System.out.println("Menu item"+choice2+" had its category updated to "+updatecategory1);
break;}
case 3:{
System.out.println("Enter the new description");
String updatedescription1=sc.nextLine();
updatedescription1=sc.nextLine();
m.updateMenuItemDescription(choice2, updatedescription1);
System.out.println("Menu item"+choice2+" had its description updated to "+updatedescription1);
break;}
case 4:{
System.out.println("Enter the new price");
double updateprice1=sc.nextDouble();
m.updateMenuItemPrice(choice2, updateprice1);
System.out.println("Menu item"+choice2+" had its name updated to "+updateprice1);
break;}
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
System.out.println("Please enter the itemID of the item you wish to remove: ");
choice3 = sc.nextInt();
m.removeMenuItem(choice3);
System.out.println("Menu item removed succesfully");
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
String catchEmpty;
int choicePromoUpdate=-1;
pm.printPromoMenu();
while(choicePromoUpdate<0){
System.out.println("Which promotional menu do you wish to update? ");
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
int choicePromoRemove=0;
while (choicePromoRemove>0){
System.out.println("Please enter the promo menu you wish to have removed");
choicePromoRemove=sc.nextInt();
}
pm.removeSetByID(choicePromoRemove);
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
}

break;


case 7:{
int noEmptyTables;
System.out.print("\n");
noEmptyTables = t.showEmpty();
System.out.print("\n");
System.out.println("Number of empty tables: "+noEmptyTables);
System.out.print("\n");

break;
}

case 8:{
	System.out.print("Enter orderID : ");
	orderID = sc.nextInt();
	ol.createInvoice(orderID);

//print order invoice
//get data from the order of choice
//print the data
break;
}

case 9: rr.setPeriod();
		rr.generateReport();
//invoice
//enter start date and end date
//read from .txt file and save the relevant data into arraylist 
//print the data read
break;


//staff
case 10:
	System.out.println("----PRINTING STAFF-----");
	sl.printAllStaff();
	break;
	
	//members
case 11:
	System.out.println("----PRINTING ALL MEMBERS----");
	ml.printAllMembers();
	break;


default:
break;

}
}
}
}



