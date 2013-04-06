public class MenuSet{
private MenuItem MenuSet[] = new MenuItem[3];
private double setPrice;
private int setID;
 

//constructor
 public MenuSet(){
  for (int i=0; i<3; i++){
   MenuSet[i]=new MenuItem(0); 
  }
   setPrice=0.0;
   
  
  
  }
  //Create, update, delete
  
  
  public double getPrice(){
	  return setPrice;
  }  
  
  public void setPrice(double price){
	  setPrice=price;
  }
  
  public void setSetID(int setID){
	  this.setID = setID;
  }
  
  public int getSetID(){
	  return setID;
  }
  
  //Create new MenuSet, starting by setting 3 new dishes, starter main and dessert
  public void setDishByInfo(int category, String name, String description, double price,int getj){
  MenuSet[getj].setCategory(category);
  MenuSet[getj].setName(name);
  MenuSet[getj].setDescription(description);
  MenuSet[getj].setPrice(price); 
  }
  
  //assigns values form itemId to the category of choice
  public void setDishByItemID(int setitemID,int geti){
  MenuSet[geti].setName(MenuSet[setitemID].getName());
  MenuSet[geti].setPrice(MenuSet[setitemID].getPrice());
  MenuSet[geti].setCategory(MenuSet[setitemID].getCategory());
  MenuSet[geti].setDescription(MenuSet[setitemID].getDescription());
  }
  
  //resets the values for the menuSet
  public void clearMenuSet(){
  for (int i=0; i<3; i++){
   MenuSet[i].clearName();
  MenuSet[i].clearPrice();
  MenuSet[i].clearCategory();
  MenuSet[i].clearDescription();
  }
  }
  
  
  //sorts and prints the menuSet
public void printMenuSet(){
  //first sort it according to category
  int n = MenuSet.length;
  MenuItem temp;
  
                for(int i=0; i < n; i++){
                 for(int j=1; j < (n-i); j++){
                 
                                if(MenuSet[j-1].getCategory() > MenuSet[j].getCategory()){
                                        temp = MenuSet[j-1];
                                        MenuSet[j-1] = MenuSet[j];
                                        MenuSet[j] = temp;
                        }
                 }
                }
  
  //then print it
  
  System.out.println("PRICE: "+setPrice);
  for (int i=0; i<n; i++){
  if (MenuSet[i].getCategory() != 0)
  System.out.println(MenuSet[i].getName()+"\n"+MenuSet[i].getDescription()+"\n");
  System.out.println("---------------------------------------");
  
   }
  
 }
}