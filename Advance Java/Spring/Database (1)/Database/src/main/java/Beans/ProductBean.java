package Beans;

public class ProductBean 
{
	String name,description;
	int cost;

	public ProductBean() 
	{
		System.out.println("ProductBean Constructor Called");

	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getCost() {
		return cost;
	}
	public void setCost(int cost) {
		this.cost = cost;
	}

}
