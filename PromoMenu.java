public class PromoMenu{
private MenuSet PromoMenu[] = new MenuSet[5];

 public PromoMenu(){
  for (int i=0; i<5; i++){
   PromoMenu[i]=new MenuSet(); 
  }

}

//currently will print all menus. Have to add a condition to only print the ones with values
public void printPromoMenu(){   
	for (int i=0; i<PromoMenu.length; i++){
 	 System.out.println("Promotional menu set no."+(i+1));
 	 PromoMenu[i].printMenuSet();
 	 System.out.println("\n");
  }
  }
public MenuSet getMenuSet(int setID){
	for(int i=0;i<PromoMenu.length;i++)
		if(PromoMenu[i].getSetID()==setID)
			return PromoMenu[i];
	return null;
}
  }



