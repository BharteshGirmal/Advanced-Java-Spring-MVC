package RestControllers;

public class User 
{
	
	private String uname , city;
	
	public User() {
		System.out.println("User Object get Called ....");
	}
	
	public void setUname(String uname) {
		this.uname = uname;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getUname() {
		return uname;
	}
	
	public String getCity() {
		return city;
	}

}
