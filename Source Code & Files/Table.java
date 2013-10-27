
public class Table {
	private int tableID;
	private int capacity;
	private boolean isOccupied;
	
	public Table(int capacity, int tableID){
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
	
	public void print(){
		System.out.println("Table ID : "+tableID);
		System.out.println("Capacity : "+ capacity);
		if(isOccupied)
			System.out.println("Status : Occupied");
		else
			System.out.println("Status : Vacant");
	}

}
