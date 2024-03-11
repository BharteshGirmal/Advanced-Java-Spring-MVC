package ManyToManyRelation;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
@Entity
@Table(name = "Course_table")
public class Course3
{
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private int courseId;
	@Column
	private String courseName;
	@Column
	private String courseDesc;
	@Column
	private int duration;
	
	public Course3() {
		// TODO Auto-generated constructor stub
	}

	public Course3(int courseId, String courseName, String courseDesc, int duration) {
		super();
		this.courseId = courseId;
		this.courseName = courseName;
		this.courseDesc = courseDesc;
		this.duration = duration;
	}
	
	@ManyToMany(cascade = CascadeType.ALL)
	private Set<Student> students;

	public void setStudents(Set<Student> students) {
		this.students = students;
	}
	public Set<Student> getStudents() {
		return students;
	}
	public int getCourseId() {
		return courseId;
	}

	public void setCourseId(int courseId) {
		this.courseId = courseId;
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
	
	
}
