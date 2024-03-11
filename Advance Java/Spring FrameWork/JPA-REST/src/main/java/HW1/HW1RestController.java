package HW1;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController // used instead of @Controller
@RequestMapping(path = "/course") // this is a super mapping at start
public class HW1RestController
{
	@Autowired
	Hw1Repository repo;
	
	//1.  GET  /allCourses    - use Spring-JPA to return all Courses 
	@GetMapping("/allcourses")
	public List<CourseEntity> getAllCourses()
	{
		List<CourseEntity> al=repo.findAll();
		return al;
	}
	
	//2.  POST  /addCourse  --- send a RequestBody with all course details and insert the record in the DB 
	@PostMapping("/add")
	public String Insert(@RequestBody CourseEntity C)
	{
		CourseEntity obj=new CC.getId(),C.getCourseourseEntity(Name(),C.getCourseDesc(),C.getDuration(),C.getFacultyName());
		repo.save(obj);
		return ".................Record Inserted .................";
	}
	
	//3. PUT    /change/{courseName}/{facultyName} 
	//change facultyName for all records matching the courseName
	@PutMapping("/change/{courseName}/{facultyName}")
	public String Change(@PathVariable String courseName,@PathVariable String facultyName)
	{
		List<CourseEntity> al=repo.findAll();
		al.forEach((row)->{if(row.getCourseName().equals(courseName))row.setFacultyName(facultyName);});
		repo.saveAll(al);
		return ".................Record Updated.................";
	}
	
	//4. DELETE  /removecourse/{courseId}   remove the Course 
	@DeleteMapping("/delete/{id}")
	public String delete(@PathVariable int id)
	{
		repo.deleteById(id);
		return ".................Record Deleted .................";
	}

}
