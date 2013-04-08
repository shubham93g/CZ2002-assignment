import java.util.Date;
import java.util.Scanner;

public class Order {
	
	private int [] menuItems;
	private int [] menuSet;
	private int staffID;
	private int tableID;
	private Date date;
	private int orderID;
	private Menu menu; //for list of menu items
	private PromoMenu promoMenu; //for list of promo
	private TableList tableList;
	private int itemNo;
	private int setNo;
	private boolean active; 
	
	public Order(Menu menu, PromoMenu promoMenu, TableList tableList){
		menuItems = new int[20];
		menuSet = new int[20];
		itemNo = 0;
		setNo = 0;
		active = true;
		this.menu = menu;
		this.promoMenu = promoMenu;
		this.tableList = tableList;
	}
	
	public void create(int staffID, int tableID){
		//create order
		this.staffID = staffID;
		this.tableID = tableID;
		if(!tableList.getTable(tableID).isOccupied())
			tableList.occupyTable(tableID);
		else
			System.out.println("Error : Table is already occupied");
		date = new Date();
		int choice; //for user choice
		int menuSelection; //for selection on user menu input
		Scanner sc = new Scanner(System.in); //user input
		
		do{	
		System.out.println("1. Add Menu Item\n2. Add Menu Set\n3. Finish");
		choice = sc.nextInt();
		switch(choice){
			case 1: menu.printMenu();
					System.out.print("Input Menu Item to add : ");
					menuSelection = sc.nextInt();
					menuItems[itemNo] = menuSelection;
					itemNo++;
					System.out.println("Item add successful");
					break;
			case 2: menu.printMenu();
					System.out.print("Input Menu Set to add : ");
					menuSelection = sc.nextInt();
					menuSet[setNo] = menuSelection;
					setNo++;
					System.out.println("Set add successful");
					break;
			case 3: System.out.println("Order creation successful");
					this.viewOrder();
					break;
			default:System.out.println("Check input value");
					break;
			}
		}while(choice!=3);
	}
	
	public void update(){
		//update order
		int menuSelection;
		int choice;
		Scanner sc = new Scanner(System.in);
		do{
			System.out.println("1. Add Menu Item\n2.Add Menu Set\n3.Remove Menu Item\n4. Remove Menu Set\n5. Finish");
			choice = sc.nextInt();
			switch(choice){
				case 1: this.viewOrder();
						System.out.print("Select Menu Item to modify : ");
						menuSelection  = sc.nextInt();
						//update quantity - code to be added
						break;
				case 2: this.viewOrder();
						System.out.print("Select Menu Set to modify : ");
						menuSelection  = sc.nextInt();
						//update quantity - code to be added
						break;
				case 3: System.out.println("Order update successful");
						this.viewOrder();
						break;
				default:System.out.println("Check input value");
						break;
			}
		}while(choice!=3);
	}
	
	public void remove(){
		//remove order
		int menuSelection;
		int choice;
		Scanner sc = new Scanner(System.in);
		do{
			System.out.println("1. Remove Menu Item\n2.Remove Menu Set\n3. Finish");
			choice = sc.nextInt();
			switch(choice){
				case 1: this.viewOrder();
						System.out.print("Select Menu Item to remove : ");
						menuSelection  = sc.nextInt();
						for(int i = menuSelection;i<itemNo;i++)
							menuItems[i-1]=menuItems[i];
						itemNo--;
						//remove last element - code to be added
							
						break;
				case 2: this.viewOrder();
						System.out.print("Select Menu Set to remove : ");
						menuSelection  = sc.nextInt();
						for(int i = menuSelection;i<setNo;i++)
							menuSet[i-1]=menuSet[i];
						setNo--;
						//remove last element - code to be added
						break;
				case 3: System.out.println("Order update successful");
						this.viewOrder();
						break;
				default:System.out.println("Check input value");
						break;
			}
		}while(choice!=3);
	}

	
	public double calculateSum(){
		//calculate total sum of order
		double price = 0;
		for(int i=0;i<itemNo;i++)
			price += menu.getMenuItemById(menuItems[i]).getPrice();
		for(int j=0;j<setNo;j++)
			price += promoMenu.getSetByID(menuSet[j]).getPrice();
		return price;
	}
	
	public void viewOrder(){
		//display order details
		System.out.println(date.toString());
		System.out.println("Menu Items");
		for(int i=0;i<itemNo;i++){
			System.out.println(i+1 +". ");
			menu.getMenuItemById(menuItems[i]).printMenuItem();
		}
		System.out.println("Menu Sets");
		for(int j=0;j<setNo;j++){
			System.out.println(j+1 +". ");
			promoMenu.getSetByID(menuSet[j]).printMenuSet();
		}
	}
	
	public void createInvoice(){
		//create Invoice
		active = false;
		tableList.vacateTable(tableID);
		viewOrder();
		System.out.println("Total Price : " + calculateSum());
		System.out.println("GST : 7%");
		System.out.println("Price after GST : " + calculateSum()*1.07);
	}
	
	public int getStaffID(){
		return staffID;
	}
	
	public int getTableID(){
		return tableID;
	}
	
	public Date getDate(){
		return date;
	}
	
	public int getOrderID(){
		return orderID;
	}
	
	public boolean getStatus(){
		return active;
	}
}
