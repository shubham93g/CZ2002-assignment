
public class Table {
	private int tableID;
	private int capacity;
	private boolean isOccupied;
	
	public Table(int tableID, int capacity){
		isOccupied = false;
		this.tableID = tableID;
		this.capacity = capacity;
	}
	
	public void occupy(){
		isOccupied = true;
	}
	
	public void vacate(){
		isOccupied = false;
	}
	
	public boolean isOccupied(){
		return isOccupied;
	}
	
	public int getTableID(){
		return tableID;
	}
	
	public int getCapacity(){
		return capacity;
	}

}
