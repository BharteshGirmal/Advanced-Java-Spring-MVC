package Beans;

public class DummyBean 
{
	private String data ,name;
	
	public DummyBean()
	{
		System.out.println("DummyBean Constructor is called");
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	
}
