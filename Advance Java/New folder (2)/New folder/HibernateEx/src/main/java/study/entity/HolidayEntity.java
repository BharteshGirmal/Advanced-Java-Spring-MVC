package study.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="holiday")
public class HolidayEntity
{
	@Id
	@Column
	private int id;
	
	@Column
    private String nameOfHoliday;
	
	@Column
	private String dateInCurrentYear;
	
	public HolidayEntity()
	{
		
	}

	public HolidayEntity(int id, String nameOfHoliday, String dateInCurrentYear) {
		super();
		this.id = id;
		this.nameOfHoliday = nameOfHoliday;
		this.dateInCurrentYear = dateInCurrentYear;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNameOfHoliday() {
		return nameOfHoliday;
	}

	public void setNameOfHoliday(String nameOfHoliday) {
		this.nameOfHoliday = nameOfHoliday;
	}

	public String getDateInCurrentYear() {
		return dateInCurrentYear;
	}

	public void setDateInCurrentYear(String dateInCurrentYear) {
		this.dateInCurrentYear = dateInCurrentYear;
	}

	@Override
	public String toString() {
		return "HolidayEntity [id=" + id + ", nameOfHoliday=" + nameOfHoliday + ", dateInCurrentYear="
				+ dateInCurrentYear + "]";
	}
}