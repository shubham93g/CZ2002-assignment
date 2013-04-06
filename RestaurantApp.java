import java.util.Scanner;


public main RestaurantApp{

while (choice!=10) do{
System.out.println("Make your choice (1-10):");
System.out.println("1. Create order");
System.out.println("2. View order");
System.out.println("3. Update order");
System.out.println("4. Manage reservations ");
System.out.println("5. Create/update/remove menu");
System.out.println("6. Create/update/remove promotion");
System.out.println("7. Check table availability");
System.out.println("8. Print order invoice");
System.out.println("9. Print sales revenue report");
System.out.println("10. Quit");
Scanner sc = new Scanner(System.in);
int choice = sc.nextInt();

switch(choice)

case 1:
//create order
break;

case 2:
//view order
break;

case 3:
//update order
break;

case 4:
//manage reservation
break;

case 5:{
int choice1=0;
while (choice1 != 4) do{
System.out.println("What do you want to do:");
System.out.println("1. Create menu item");
System.out.println("2. Update menu item");
System.out.println("3. Remove menu item");
System.out.println("4. Back");

choice1 = sc.nextInt();

switch(choice1){

case1:{
System.out.println("--Create menu item--");
System.out.println("Please enter the name of the item: ");
//scanner get string for name
System.out.println("Please enter the category of the item: ");
//scanner get int category
System.out.println("Please enter the description of the item: ");
//scanner get string descr
System.out.println("Please enter the price of the item: ");
//scanner get double price

Menu.createMenuItem(//invariables)


}

case2:{
System.out.println("Which item do you wish to update?");
System.out.println("Please enter the item ID");
//scanner get itemID
//while loop to check itemID exists etc.
System.out.println("What do you wish to update for this item?");
System.out.println("1. Update item name");
System.out.println("2. Update item category");
System.out.println("3. Update item description");
System.out.println("4. Update item price");
System.out.println("5. Back");

choice2=getint etc

case 1:
System.out.println("Enter the new name");
//updatemenuitemname(itemid, name)
//if change ok
System.out.println("Menu item"+itemID+" had its name updated to "+itemName);
break;
case 2:
System.out.println("Enter the new category");
//updatemenuitemname(itemid, categorye)
//if change ok
System.out.println("Menu item"+itemID+" had its category updated to "+itemcategory);
break;
case 3:
System.out.println("Enter the new description");
//updatemenuitemname(itemid, descr)
//if change ok
System.out.println("Menu item"+itemID+" had its description updated to "+itemdescr);
break;
case 4:
System.out.println("Enter the new price");
//updatemenuitemname(itemid, price)
//if change ok
System.out.println("Menu item"+itemID+" had its name updated to "+itemprice);
break;
default: 
break;



}
//remove menuitem
case3:{
System.out.println("--Remove menu item--");
System.out.println("Please enter the itemID of the item you wish to remove: ");
choice3 =get int
//if ok and existing menuitem, run following
removeMenuitem(choice3);
System.out.println("Menu item removed succesfully");

}
default:
break;
}


}
break;


//Menu promotion
case 6:{
while (choice1 != 4) do{
System.put.println("--PROMOTION MENU--");
System.out.println("What do you want to do:");
System.out.println("1. Create promotion menu");
System.out.println("2. Update promotion menu");
System.out.println("3. Remove promotion menu");
System.out.println("4. Back");

choice1 = sc.getnextInt();

switch(choice1)

case 1:{
//check if want full promomeal or just 1 or two dishes, save integer i
//run creation loop for i
System.out.println("Do you wish to create from already existing menu items or create new menu items");
System.out.println("1. From existing");
System.out.println("2. Create brand new");

choice23=getnextInt();

case 1:
//loop
System.out.println("Please enter the itemID: ");

//after all entered, print this promomenu




break;

case 2:
System.out.println("Please enter the name of the item: ");
//scanner get string for name
System.out.println("Please enter the category of the item: ");
//scanner get int category
System.out.println("Please enter the description of the item: ");
//scanner get string descr
System.out.println("Please enter the price of the item: ");
//scanner get double price


break;

default:
break;
}
break;

//update promomenu
case 2:

//
System.out.println("Which promotional menu do you wish to update? ");

choice 2313 = get next int

menu update

//wish to update the whole menu or just one item?
System.out.println("Wish to upgrade one item or the whole thing?");
System.out.println("1. Update one item");
System.out.println("2. The whole thing");


switch

case 1:
System.out.println("Enter the new name");
//updatemenuitemname(itemid, name)
//if change ok
System.out.println("Menu item"+itemID+" had its name updated to "+itemName);
break;
case 2:
System.out.println("Enter the new category");
//updatemenuitemname(itemid, categorye)
//if change ok
System.out.println("Menu item"+itemID+" had its category updated to "+itemcategory);
break;
case 3:
System.out.println("Enter the new description");
//updatemenuitemname(itemid, descr)
//if change ok
System.out.println("Menu item"+itemID+" had its description updated to "+itemdescr);
break;
case 4:
System.out.println("Enter the new price");
//updatemenuitemname(itemid, price)
//if change ok
System.out.println("Menu item"+itemID+" had its name updated to "+itemprice);
break;
default: 
break;


break;


//remove menu promo
case 3:
System.out.prinln("Please enter the promo menu you wish to have removed");
choice32=getint

for i=0; i<3 i++
MenuSet.RemoveMenuitem(i)


 


break;


}
break;

case 7:
break;


case 8:
break;

default:
break;



}


}