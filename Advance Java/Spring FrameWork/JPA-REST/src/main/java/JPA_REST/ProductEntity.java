package JPA_REST;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Product")
public class ProductEntity
{
	@Id
	@Column(name = "Product_ID")
	private int id;
	@Column(name = "Product_Name")
	private String name;
	@Column(name = "Product_Cost")
	private int cost;
	
	public ProductEntity() {
		// TODO Auto-generated constructor stub
	}

	public ProductEntity(int id, String name, int cost) {
		super();
		this.id = id;
		this.name = name;
		this.cost = cost;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getCost() {
		return cost;
	}

	public void setCost(int cost) {
		this.cost = cost;
	}
	
	
	
	
	
}
