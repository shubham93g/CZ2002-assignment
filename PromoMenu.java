import java.util.ArrayList;

public class PromoMenu{
	private ArrayList <MenuSet> promoMenu;
	private Menu menu;
	
	 public PromoMenu(Menu menu){
	   promoMenu = new ArrayList<MenuSet>(); 
	   this.menu = menu;
	  }
	
	 public int generateSetID(){
		 for(int i=0;i<promoMenu.size();i++) //check if there are any items with missing IDs (as compared to index)
			  if(getSetIndexByID(i)==-1)	//if yes, return this missing ID
				  return i;
		  int lastID = promoMenu.get(promoMenu.size()-1).getID(); //otherwise, get the last used ID
		  while(getSetIndexByID(lastID)!=-1) //increment it till you get a new, unused ID
			  lastID++;
		  return lastID;
	 }
	
	 public void createMenuSet(){
		 int iD = generateSetID();
		 MenuSet tempMenuSet = new MenuSet(menu,iD);
		 tempMenuSet.CreateMenuSet();
		 promoMenu.add(tempMenuSet);
		 
	 }
	 	 
	public void printPromoMenu(){   
		for (int i=0; i<promoMenu.size(); i++){
	 	 System.out.println("Promotional menu set no."+(i+1));
	 	 promoMenu.get(i).printMenuSet();
	 	 System.out.println("\n");
		}
	  }
	
	public void printSetByID(int id){
		for(int i=0;i<promoMenu.size();i++){
			if(promoMenu.get(i).getID() == id)
				promoMenu.get(i).printMenuSet();
		}
	}
	public MenuSet getSetByID(int setID){
		int index = getSetIndexByID(setID);
		if(index!=-1)
			return promoMenu.get(index);
		else
			return null;
	}
	
	public int getSetIndexByID(int setID){
		for(int i=0;i<promoMenu.size();i++)
			if(promoMenu.get(i).getID() == setID)
				return i;
		System.out.println("No such set exists");
		return -1; //if set doesn't exist;
	}
	
	public void updateSetPrice(int setID, double price){
		int index = getSetIndexByID(setID);
		if(index!=-1)
			promoMenu.get(index).setPrice(price);
		else
			System.out.println("Update failed. Set ID invalid.");
			
	}
	public void updateSetName(int setID, String name){
		int index = getSetIndexByID(setID);
		if(index!=-1)
			promoMenu.get(index).setName(name);
		else
			System.out.println("Update failed. Set ID invalid.");
	}
	public void updateSetDescription(int setID, String description){
		int index = getSetIndexByID(setID);
		if(index!=-1)
			promoMenu.get(index).setDescription(description);
		else
			System.out.println("Update failed. Set ID invalid.");
	}
	
	public void updateSetItems(int setID){
		int index = getSetIndexByID(setID);
		if(index!=-1)
			promoMenu.get(index).updateMenuSet();
		else
			System.out.println("Update failed. Set ID invalid.");
	}
	
	public void removeSetByID(int setID){
		int index = getSetIndexByID(setID);
		if(index!=-1)
			promoMenu.remove(index);
		else
			System.out.println("No such set exists");
	}
 }



