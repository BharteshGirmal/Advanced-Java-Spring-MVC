package Entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="student")
public class StudentEntity {

	@Id
	@Column
	private int id;
	
	@Column(name = "roll_number")
	private int rollNumber;
	
	@Column(name="first_name")
	private String firstName;
	
	@Column(name="last_name")
	private String lastName;
	
	public StudentEntity(int id, int rollNumber, String firstName, String lastName) {
		super();
		this.id = id;
		this.rollNumber = rollNumber;
		this.firstName = firstName;
		this.lastName = lastName;
	}

	@Override
	public String toString() 
	{
		return "ID : "+id+"\nRoll No : "+rollNumber+"\nFirst Name : "+firstName+
				"\nLast Name : "+lastName;
	}
	public StudentEntity() { }

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
	
	
	
	
	
}
