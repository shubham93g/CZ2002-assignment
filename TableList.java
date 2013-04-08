
public class TableList {
	
	private Table[] table;
	private int noOfTables; 
	
	public TableList(){
		noOfTables = 10;
		table = new Table[10];
		table[0] = new Table(0,2);
		table[1] = new Table(1,2);
		table[2] = new Table(2,2);
		table[3] = new Table(3,4);
		table[4] = new Table(4,4);
		table[5] = new Table(5,4);
		table[6] = new Table(6,6);
		table[7] = new Table(7,6);
		table[8] = new Table(8,6);
		table[9] = new Table(9,10);
	}
	
	public int showEmpty(){
		int empty = 0;
		for(int i=0;i<10;i++)
			if(!table[i].isOccupied()){
				table[i].print();
				empty++;
			}
		return empty;
	}
	
	public int showOcupied(){
		int occupied = 0;
		for(int i=0;i<10;i++)
			if(table[i].isOccupied()){
				table[i].print();
				occupied++;
			}
		return occupied;
	}
	
	public Table getTable(int tableID){
		return table[tableID];
	}

	public int getNoOfTables(){
		return noOfTables;
	}
	
	public void occupyTable(int tableID){
		table[tableID].occupy();
	}
	
	public void vacateTable(int tableID){
		table[tableID].vacate();
	}
	
	//returns index of table with best fit for the the noOfPeople booking
	public int getBestFitIndex(int noOfPeople){
		int tempTableID = -1;
		if(showEmpty()==0) //if no tables are empty, return -1
			return tempTableID;
		int tempDifference = 10;
		for(int i=0;i<10;i++){
			if(table[i].getCapacity() >= noOfPeople && !table[i].isOccupied())
				if((table[i].getCapacity()-noOfPeople)<=tempDifference){
					tempDifference = table[i].getCapacity()-noOfPeople;
					tempTableID = i;
			}
		}
		return tempTableID;
	}
}
