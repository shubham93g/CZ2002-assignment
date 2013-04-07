public class MenuItem extends Item{

	int category;
	
	//constructor
	public MenuItem(int itemID, String name, int category, String description, double price){
	
	super(itemID, name,description,price);
	this.category = category;
	
	}
	
	public int getCategory(){
	return category;
	}
	
	public void setCategory(int category_set){
	category=category_set;
	}
	
	public void printMenuItem(){
		String pcategory;
		if (category=='1'){
			pcategory="Starter";
		}
		else if (category=='2'){
			pcategory="Main";
		}
		else if (category=='3'){
			pcategory="Dessert";
		}
		else{
			pcategory="Not specified";
		}
		System.out.println("ItemID: "+ getID());
		System.out.println("Name: "+getName());
		System.out.println("Category: "+pcategory);
		System.out.println("Description: "+getDescription());
		System.out.println("Price: "+ getPrice());
		}
	


}
