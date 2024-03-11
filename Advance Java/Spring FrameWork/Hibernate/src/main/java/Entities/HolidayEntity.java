package Entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Holiday")
public class HolidayEntity 
{
	@Id
	@Column(name = "id")
	private int id;
	@Column
	private String nameofHoliday;
	@Column
	private String dateInYear;
	
	public HolidayEntity() {
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public String toString() {
		return "Id : "+id+"\nName of Holiday : "+nameofHoliday+"\nDate : "+dateInYear;
	}

	public HolidayEntity(int id, String nameofHoliday, String dateInYear) {
		super();
		this.id = id;
		this.nameofHoliday = nameofHoliday;
		this.dateInYear = dateInYear;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNameofHoliday() {
		return nameofHoliday;
	}

	public void setNameofHoliday(String nameofHoliday) {
		this.nameofHoliday = nameofHoliday;
	}

	public String getDateInYear() {
		return dateInYear;
	}

	public void setDateInYear(String dateInYear) {
		this.dateInYear = dateInYear;
	}
	
	
}
