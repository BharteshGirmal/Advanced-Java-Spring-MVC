package HW1;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "course")
public class CourseEntity 
{
	@Id
	@Column
	private int id;
	@Column
	private String courseName;
	@Column
	private String courseDesc;
	@Column
	private int duration;
	@Column
	private String facultyName;
	
	public CourseEntity() 
	{
		// TODO Auto-generated constructor stub
	}

	public CourseEntity(int id, String courseName, String courseDesc, int duration, String facultyName) {
		super();
		this.id = id;
		this.courseName = courseName;
		this.courseDesc = courseDesc;
		this.duration = duration;
		this.facultyName = facultyName;
	}

	@Override
	public String toString() 
	{
		return "Book ID : "+id+"\nCourse Name : "+courseName+"\nCourse Description : "
				+courseDesc+"\nDuration : "+duration+"\nFaculty Name : "+facultyName;
	}
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public String getCourseDesc() {
		return courseDesc;
	}

	public void setCourseDesc(String courseDesc) {
		this.courseDesc = courseDesc;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public String getFacultyName() {
		return facultyName;
	}

	public void setFacultyName(String facultyName) {
		this.facultyName = facultyName;
	}
}
