public class MenuItem {

private int category;
private String name;
private double price;
private String description;
private int itemID;

//constructor
public MenuItem(int itemID_construct){
itemID=itemID_construct;
category = 0;
name = "";
price = 0.0;
description = "";

}

public int getCategory(){
return category;
}

public String getName(){
return name;
}

public double getPrice(){
return price;
}

public  String getDescription(){
return description;
}

public int getItemID(){
return itemID;
}

public void setCategory(int category_set){
category=category_set;
}

public void setName(String name_set){
name=name_set;
}

public void setPrice(double price_set){
price=price_set;
}

public void setDescription(String description_set){
description=description_set;
}

public void setItemID(int itemID_set){
itemID=itemID_set;
}


	public void clearName(){
	name = "";
	}
	
	public void clearPrice(){
	price = 0.0;
	}
	public void clearCategory(){
	category=0;
	}
	public void clearDescription(){
	description="";
	}


}
