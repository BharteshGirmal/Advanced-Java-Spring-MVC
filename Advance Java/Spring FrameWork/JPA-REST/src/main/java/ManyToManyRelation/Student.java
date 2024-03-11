package ManyToManyRelation;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Student_table")
public class Student 
{
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private int studentId;
	@Column
	private String studentName;
	@Column
	private String email;
	
	public Student() {}

	public Student(int studentId, String studentName, String email) {
		super();
		this.studentId = studentId;
		this.studentName = studentName;
		this.email = email;
	}

	public int getStudentId() {
		return studentId;
	}

	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	
}
