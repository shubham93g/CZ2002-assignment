import java.util.Date;

public class Order {
	
	private int orderID;
	private int [] menuItems;
	private int [] menuSet;
	private int staffID;
	private int tableID;
	private Date date;
	private int pax;
	private int itemSize; //no of menuItems
	private int setSize;  //no of menuSet
	private boolean isMember;
	private boolean active; 
	private double totalPrice;
	
	public Order(int orderID, int itemSize, int setSize, int staffID, int tableID, int pax){
		this.orderID = orderID;
		this.menuItems = new int[50];
		this.menuSet = new int[15];
		this.staffID = staffID;
		this.tableID = tableID;
		this.itemSize = itemSize;
		this.setSize = setSize;
		date = new Date();
		this.pax = pax;
		isMember = false;
		active = true;
	}
	
	
	//Douglas - this constructor is specifically for your convenience. Will make it easier for you to get data from files into arrayList.
	protected Order(int orderID, int [] menuItems, int itemSize, int [] menuSet, int setSize, int staffID, int tableID, int pax, Date date,boolean isMember, boolean active){
		this.orderID = orderID;
		this.menuItems = new int[50];
		System.arraycopy(menuItems, 0, this.menuItems, 0, menuItems.length);
		this.menuSet = new int[15];
		System.arraycopy(menuSet, 0, this.menuSet, 0, menuSet.length);
		this.staffID = staffID;
		this.tableID = tableID;
		this.itemSize = itemSize;
		this.setSize = setSize;
		this.date = date;
		this.pax = pax;
		this.isMember = isMember;
		this.active = active;
	}
	
	private int getItemIndexByID(int itemID){
		for(int i=0;i<itemSize;i++)
			if(menuItems[i]==itemID)
				return i;
		return -1; //if item not found in order
	}
	
	private int getSetIndexByID(int setID){
		for(int i=0;i<setSize;i++)
			if(menuSet[i]==setID)
				return i;
		return -1; //if set does not exist in order
	} 
	
	public boolean checkItemByID(int itemID){
		for(int i=0;i<itemSize;i++)
			if(menuItems[i]==itemID)
				return true;
		return false;
	}
	
	public boolean checkSetByID(int setID){
		for(int i=0;i<setSize;i++)
			if(menuSet[i]==setID)
				return true;
		return false;
	}
	
	public int getItemIdByIndex(int index){
		return menuItems[index];
	}
	
	public int getSetIdByIndex(int index){
		return menuSet[index];
	}
	
	public int getStaffID(){
		return staffID;
	}
	
	public void setStaffID(int staffID){
		this.staffID = staffID;
	}
	
	public int getTableID(){
		return tableID;
	}
	
	public void setTableID(int tableID){
		this.tableID = tableID;
	}
	
	public Date getDate(){
		return date;
	}
	
	public int getOrderID(){
		return orderID;
	}
	
	public int getItemSize(){
		return itemSize;
	}
	
	public int getSetSize(){
		return setSize;
	}
	
	public boolean isActive(){
		return active;
	}
	
	public void closeOrder(){
		active = false;
	}
	
	public void addMenuItem(int menuItemID){
		if(itemSize>=50)
			System.out.println("Error: Cannot add more menu items to order. Order limit reached for menu items");
		else{
			menuItems[itemSize] = menuItemID;
			itemSize++;
			//System.out.println("Item added");
		}
	}
	
	public void addMenuSet(int menuSetID){
		if(setSize>=15)
			System.out.println("Error : Cannot add more sets to order. Order limit reached for sets");
		else{
			menuSet[setSize] = menuSetID;
			setSize++;
			//System.out.println("Set added");
		}
	}
	
	public void removeMenuItem(int ItemID){
		int index = getItemIndexByID(ItemID);
		if(index==-1)
			System.out.println("No such item exists in order");
		else{
			for(int i = index;i<itemSize-1;i++)
				menuItems[i] = menuItems[i+1];
			itemSize--;
			//System.out.println("Item removed");
		}
	}
	
	public void removeMenuSet(int setID){
		int index = getSetIndexByID(setID);
		if(index==-1)
			System.out.println("No such set exists in order");
		else{
			for(int i = index;i<setSize-1;i++)
				menuSet[i] = menuSet[i+1];
			setSize--;
			//System.out.println("Set removed");
		}
	}
	
	public int getPax(){
		return pax;
	}
	
	public boolean isMember(){
		return isMember;
	}
	
	public void orderIsByMember(){
		isMember = true;
	}
	
	public double getTotalPrice(){
		return totalPrice;
	}
	
	public void setTotalPrice(double price){
		this.totalPrice = price;
	}
	
}
