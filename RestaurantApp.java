import java.util.Scanner;


public main RestaurantApp{
int choice=0;
Scanner sc = new Scanner(System.in);
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

choice = sc.nextInt();

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
String create-name;
String create-description;
double create-price;
int create-category;

System.out.println("--Create menu item--");
System.out.println("Please enter the name of the item: ");
create-name=sc.next();
System.out.println("Please enter the category of the item: ");
create-category=sc.nextInt();
System.out.println("Please enter the description of the item: ");
create-description=sc.next();
System.out.println("Please enter the price of the item: ");
create-price=sc.nextDouble();


Menu.createMenuItem(create-name, create-description,create-price, create-category);


}

case2:{
int choice2;
System.out.println("Which item do you wish to update?");
System.out.println("Please enter the item ID");
choice2=sc.nextInt();
//while loop to check itemID exists etc.
System.out.println("What do you wish to update for this item?");
System.out.println("1. Update item name");
System.out.println("2. Update item category");
System.out.println("3. Update item description");
System.out.println("4. Update item price");
System.out.println("5. Back");


case 1:
System.out.println("Enter the new name");
String update-name=sc.next();
Menu.updateMenuItemName(choice2, update-name);
System.out.println("Menu item"+itemID+" had its name updated to "+update-name);
break;
case 2:
System.out.println("Enter the new category");
int update-category=sc.nextInt();
Menu.updateMenuItemCategory(choice2, update-category);
System.out.println("Menu item"+itemID+" had its category updated to "+update-category);
break;
case 3:
System.out.println("Enter the new description");
String update-description=sc.next();
Menu.updateMenuItemDescription(choice2, update-description);
System.out.println("Menu item"+itemID+" had its description updated to "+update-description);
break;
case 4:
System.out.println("Enter the new price");
double update-price=sc.nextDouble();
Menu.updateMenuItemPrice(choice2, update-price);
System.out.println("Menu item"+itemID+" had its name updated to "+updateprice);
break;
default: 
break;



}
//remove menuitem
case3:{
int choice3;
System.out.println("--Remove menu item--");
System.out.println("Please enter the itemID of the item you wish to remove: ");
choice3 = sc.nextInt();
Menu.removeMenuItem(choice3);
System.out.println("Menu item removed succesfully");

}
default:
break;
}


}
break;


//Menu promotion
case 6:{
choice4;
while (choice1 != 4) do{
System.put.println("--PROMOTION MENU--");
System.out.println("What do you want to do:");
System.out.println("1. Create promotion menu");
System.out.println("2. Update promotion menu");
System.out.println("3. Remove promotion menu");
System.out.println("4. Back");
choice4 = sc.nextInt();

switch(choice4)

case 1:{
int choice5=0;
while (choice5<4)do{
choice5=4;
System.out.println("Do you wish to create a full promo menu (3items) or less? Please enter number of dishes: ");
choice5=sc.nextInt();
}
//run creation loop for i
int choice4=0;
for (int i=0; i<choice;i++){
System.out.println("For item: "+i+", do you wish to create from already existing menu items or create new menu items");
System.out.println("1. From existing");
System.out.println("2. Create brand new");
choice4=nextInt();
switch(choice4)

case 1:
System.out.println("Please enter the itemID of the item you wish to add: ");
int set-itemID = sc.nextInt();
setDishByItemID(set-itemID,i)
break;

case 2:
System.out.println("--Create menu item--");
System.out.println("Please enter the name of the item: ");
String create-name1=sc.next();
System.out.println("Please enter the category of the item: ");
Int create-category1=sc.nextInt();
System.out.println("Please enter the description of the item: ");
String create-description1=sc.next();
System.out.println("Please enter the price of the item: ");
Double create-price1=sc.nextDouble();

MenuSet.setDishByInfo(create-category1,create-name1, create-description1,create-price1,i);
break;

default:
break;
}}
break;

//update promomenu
case 2:
int choice6;
PromoMenu.printPromoMenu();
System.out.println("Which promotional menu do you wish to update? ");
choice6=sc.nextInt();

int choice7;
//wish to update the whole menu or just one item?
System.out.println("Wish to upgrade one item or the whole thing?");
System.out.println("1. Update one item");
System.out.println("2. The whole thing");
System.out.println("3. Update SetPrice");
choice7=sc.nextInt();

if (choice7=='1'){
PromoMenu[choice6].printSetMenu();
System.out.println("Which item do you wish to update?")
int choice8=sc.nextInt();
System.out.println("What do you want to update it to?")
System.out.println("1. New item from data")
System.out.println("2. Existing menu item?")
case 1:
System.out.println("Please enter the itemID of the item you wish to replace it with: ");
int set-itemID = sc.nextInt();
setDishByItemID(set-itemID,choice8)
break;

case 2:
System.out.println("--Create menu item--");
System.out.println("Please enter the name of the item: ");
String create-name1=sc.next();
System.out.println("Please enter the category of the item: ");
Int create-category1=sc.nextInt();
System.out.println("Please enter the description of the item: ");
String create-description1=sc.next();
System.out.println("Please enter the price of the item: ");
Double create-price1=sc.nextDouble();
MenuSet.setDishByInfo(create-category1,create-name1, create-description1,create-price1, choice8)


}
if (choice7=='2'){
for (int j=0;j<3;j++){
PromoMenu[choice6].printSetMenu();
System.out.println("Item "+(j+1)+")
int choice8=sc.nextInt();
System.out.println("What do you want to update it to?")
System.out.println("1. New item from data")
System.out.println("2. Existing menu item?")
case 1:
System.out.println("Please enter the itemID of the item you wish to replace it with: ");
int set-itemID = sc.nextInt();
setDishByItemID(set-itemID,choice8)
break;

case 2:
System.out.println("--Create menu item--");
System.out.println("Please enter the name of the item: ");
String create-name1=sc.next();
System.out.println("Please enter the category of the item: ");
Int create-category1=sc.nextInt();
System.out.println("Please enter the description of the item: ");
String create-description1=sc.next();
System.out.println("Please enter the price of the item: ");
Double create-price1=sc.nextDouble();
MenuSet.setDishByInfo(create-category1,create-name1, create-description1,create-price1, choice8)

}
}

break;




//remove menu promo
case 3:
System.out.prinln("Please enter the promo menu you wish to have removed");
int choice9=sc.nextInt();

PromoMenu[choice9].clearMenuSet()
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