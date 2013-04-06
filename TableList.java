
public class TableList {
	
	Table[] table;
	int noOfTables; 
	
	public TableList(){
		noOfTables = 10;
		table = new Table[10];
		table[0] = new Table(0,2);
		table[1] = new Table(1,2);
		table[2] = new Table(2,2);
		table[3] = new Table(3,2);
		table[4] = new Table(4,4);
		table[5] = new Table(5,4);
		table[6] = new Table(6,4);
		table[7] = new Table(7,4);
		table[8] = new Table(8,6);
		table[9] = new Table(9,6);
	}
	
	public int showEmpty(){
		int empty = 0;
		for(int i=0;i<10;i++)
			if(!table[i].isOccupied())
				empty++;
		return empty;
	}
	
	public int showOcupied(){
		int occupied = 0;
		for(int i=0;i<10;i++)
			if(table[i].isOccupied())
				occupied++;
		return occupied;
	}
	
	public Table getTable(int tableID){
		return table[tableID];
	}

	public int getNoOfTables(){
		return noOfTables;
	}
}
