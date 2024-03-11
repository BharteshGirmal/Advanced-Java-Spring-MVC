package Beans;

import org.springframework.stereotype.Component;

@Component
public class MyDate
{
	private int day, month ,year;
	
	public MyDate()
	{
		//day=30,month=-6,year=2022;
		System.out.println("MyDate Constructor is Called . . . ");
	}

	public int getDay() {
		return day;
	}

	public void setDay(int day) {
		this.day = day;
	}

	public int getMonth() {
		return month;
	}

	public void setMonth(int month) {
		this.month = month;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}
	
	
	
}
