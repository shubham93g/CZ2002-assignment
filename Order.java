import java.text.SimpleDateFormat;
import java.util.Date;

public class Order {
	
	MenuItems [] menuItems;
	PromotionalPackage [] promotionalPackage;
	int staffID;
	int tableID;
	long time;
	Date date;
	//SimpleDateFormat date; could implement this also ?
	int orderID;
	
	public Order(){
		menuItems = new MenuItems();
		promotionalPackage = new PromotionalPackage();
	}
	
	public void create(){
		//create order
	}
	
	public void update(){
		//update order
	}
	
	public void remove(){
		//remove order
	}
	
	public void calculateSum(){
		//calculate total sum of order
	}
	
	public void viewOrder(){
		//display order details
	}
	
	public void createInvoice(){
		//create Invoice
	}
}
