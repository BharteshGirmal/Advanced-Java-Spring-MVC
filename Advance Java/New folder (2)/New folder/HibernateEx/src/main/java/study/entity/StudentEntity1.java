package study.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="student1")
public class StudentEntity1 
{
	@Id
	@Column
	private int id;
	
	@Column(name="roll_number")
	private int rollNumber;
	
	@Column(name="first_name")
	private String firstName;
	
	@Column(name="last_name")
	private String lastName;
	
    public StudentEntity1()
    {
    	
    }

	public StudentEntity1(int id, int rollNumber, String firstName, String lastName)
	{
		super();
		this.id = id;
		this.rollNumber = rollNumber;
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getRollNumber() {
		return rollNumber;
	}

	public void setRollNumber(int rollNumber) {
		this.rollNumber = rollNumber;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	@Override
	public String toString() {
		return "StudentEntity [id=" + id + ", rollNumber=" + rollNumber + ", firstName=" + firstName + ", lastName="
				+ lastName + "]";
	}
	
}