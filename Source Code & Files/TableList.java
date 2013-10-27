
public class TableList {
	
	private Table[] table;
	private int noOfTables; 
	
	public TableList(){
		noOfTables = 10;
		table = new Table[10];
		table[0] = new Table(2,0);
		table[1] = new Table(2,1);
		table[2] = new Table(2,2);
		table[3] = new Table(4,3);
		table[4] = new Table(4,4);
		table[5] = new Table(4,5);
		table[6] = new Table(6,6);
		table[7] = new Table(6,7);
		table[8] = new Table(6,8);
		table[9] = new Table(10,9);
	}
	
	public int showEmpty(){
		int empty = 0;
		for(int i=0;i<10;i++)
			if(!table[i].isOccupied()){
				//table[i].print();
				empty++;
			}
		return empty;
	}
	
	public void show(){
		System.out.format("%n%7s %8s %8s", "TableID","Capacity","Occupied");
		for(int i=0;i<10;i++)
			System.out.format("%n%7d %8d %8s",table[i].getTableID(), table[i].getCapacity(), String.valueOf(table[i].isOccupied()));
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
	
	//returns index of table with best fit empty table for the the noOfPeople booking
	public int getBestFitEmptyIndex(int noOfPeople){
		if(noOfPeople<=0 || noOfPeople>10){
			System.out.print("Error. Check input");
			return -1;
		}
		else{
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
	
	public int getBestFit(int noOfPeople){
		if(noOfPeople<=0 || noOfPeople>10){
			System.out.print("Error. Check input");
			return -1;
		}
		else{
			int tempTableID = -1;
			if(showEmpty()==0) //if no tables are empty, return -1
				return tempTableID;
			int tempDifference = 10;
			for(int i=0;i<10;i++){
				if(table[i].getCapacity() >= noOfPeople)
					if((table[i].getCapacity()-noOfPeople)<=tempDifference){
						tempDifference = table[i].getCapacity()-noOfPeople;
						tempTableID = i;
				}
			}
			return tempTableID;
		}
	}
}
