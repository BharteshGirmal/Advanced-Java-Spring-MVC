package Beans;

public class AddressBean
{
	String city;
	int pin;

	public AddressBean()
	{
		System.out.println("Address Constructor Called");
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public int getPin() {
		return pin;
	}

	public void setPin(int pin) {
		this.pin = pin;
	}
}
