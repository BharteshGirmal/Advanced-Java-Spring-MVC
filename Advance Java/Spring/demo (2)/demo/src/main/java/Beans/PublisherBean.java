package Beans;

import org.springframework.stereotype.Component;

@Component
public class PublisherBean
{
	private String City, Name;
	public PublisherBean()
	{
		Name="TechMax Publications";
		City="Mumbai";
	}
	public String getCity() {
		return City;
	}
	public void setCity(String city) {
		City = city;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	
	
}
