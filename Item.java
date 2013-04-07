
public class Item {
	
	int id;
	String name;
	String description;
	double price;
	
	public Item(int id, String name, String description, double price){
		this.id = id;
		this.name = name;
		this.description = description;
		this.price = price;
	}
	
	public int getID(){
		return id;
	}
	
	public String getName(){
		return name;
	}
	
	public String getDescription(){
		return description;
	}
	
	public double getPrice(){
		return price;
	}
	
	public void setID(int id){
		this.id = id;
	}
	
	public void setName(String name){
		this.name = name;
	}
	
	public void setDescription(String description){
		this.description = description;
	}
	
	public void setPrice(double price){
		this.price = price;
	}

}
