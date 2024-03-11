package ManyToManyRelation;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ManyToManyController 
{
	@Autowired
	CourseRepo repo;

	@PostMapping("/addcourse")
	public String add() {
		Course3 c = new Course3();
		c.setCourseName("Data Structures");
		c.setCourseDesc("Algorithum using Java");
		c.setDuration(22);

		Set<Student> set = new HashSet<Student>();

		Student s1= new Student();
		s1.setStudentName("Bhartesh");
		s1.setEmail("bharteshgirmal@gmail.com"); 
		set.add(s1);
		/*
		 * Student s2= new Student(); s2.setStudentName("Hardik");
		 * s2.setEmail("hardikparab@gmail.com"); set.add(s2);
		 * 
		 * Student s3= new Student(); s3.setStudentName("Shubham");
		 * s3.setEmail("shubhamsharma@gmail.com"); set.add(s3);
		 * 
		 * Student s4= new Student(); s4.setStudentName("Rushikesh");
		 * s4.setEmail("rushikeshpekar@gmail.com"); set.add(s4);
		 */

		Student s5= new Student(); 
		s5.setStudentName("Nilima");
		s5.setEmail("nilimapansare@gmail.com"); 
		set.add(s5) ;


		Course3 savedcourse = repo.save(c); // saving the course here
		savedcourse.setStudents(set); // setting the students associated with this courses
		repo.save(savedcourse);

		return "************** The course is added sucessfull **************";
	}

	@GetMapping("/showcourses")
	public String get() {
		Course3 c = repo.findById(1).get();
		String Names = "";
		for (Student s : c.getStudents())
		{
			Names += s.getStudentName() + "  ,";
		}

		return c.getCourseName() + " Students : " + Names;
	}
}
