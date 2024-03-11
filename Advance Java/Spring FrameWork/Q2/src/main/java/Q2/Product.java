package Q2;

public class Product 
{
	private String productName;
	private int productRating;
	
	public Product() {
		// TODO Auto-generated constructor stub
	}

	public Product(String productName, int productRating) {
		super();
		this.productName = productName;
		this.productRating = productRating;
	}

	@Override
	public String toString() {
		return "Product Name : "+productName+"\nProduct Rating : "+productRating;
	}
	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public int getProductRating() {
		return productRating;
	}

	public void setProductRating(int productRating) {
		this.productRating = productRating;
	}
	
	
}
