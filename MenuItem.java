public class MenuItem extends Item{
//the MenuClass will have the attributes of item and adding the category attribute
	private int category;
	
	//constructor
	public MenuItem(int itemID, String name, int category, String description, double price){
		super(itemID, name,description,price);
		this.category = category;
	}
	
	//a simple get category which returns the category
	public int getCategory(){
		return category;
	}
	
	//update the category to the input category
	public void setCategory(int category_set){
		category=category_set;
	}
	
	//prints the menuitem
	public void printMenuItem(){
		String pcategory;
		if (category==1){
			pcategory="Starter";
		}
		else if (category==2){
			pcategory="Main";
		}
		else if (category==3){
			pcategory="Dessert";
		}
		else if (category ==4)
			pcategory="Drink";
		else{
			pcategory="Not specified";
		}
		System.out.println("Name: "+getName());
		System.out.println("ItemID: "+ getID());
		System.out.println("Category: "+pcategory);
		System.out.println("Description: "+getDescription());
		System.out.println("Price: "+ getPrice());
		}
	


}
