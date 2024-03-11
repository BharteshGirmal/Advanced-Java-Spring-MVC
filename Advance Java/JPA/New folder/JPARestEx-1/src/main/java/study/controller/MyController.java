package study.controller;

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

import study.jparest.entity.CourseEntity1;
import study.jparest.repositary.MyRepositary;

@RestController
@RequestMapping("/jpaex1")
public class MyController 
{
	@Autowired
	MyRepositary repo;
	
	@GetMapping("/allcourse")
	public List<CourseEntity1> allCourse()
	{
		List<CourseEntity1> al = repo.findAll();
		
		return al;
	}
	
	@PostMapping("/addcourse")
	public String insert(@RequestBody CourseEntity1 c)
	{
		CourseEntity1 obj = new CourseEntity1(c.getId(),c.getCourseName(),c.getCourseDesc(),c.getDuration(),c.getFacultyName());
		repo.save(obj);
		return "Insered...";
	}
//	{
//		  "id":1,
//		  "courseName":"AAA",
//		  "courseDesc":"BBB",
//		  "duration":4,
//		  "facultyName":"CCC"
//		}
	
	@PutMapping("/change/{cName}/{facName}")
	public String change(@PathVariable String cName,@PathVariable String facName)
	{
		List<CourseEntity1> list = repo.findAll();
		list.forEach((row)->{if(row.getCourseName().equals(cName))row.setFacultyName(facName);});
		repo.saveAll(list);
		return "Record Change";
	}
	
	@DeleteMapping("/del/{id}")
	public String delete(@PathVariable int id)
	{
		repo.deleteById(id);
		return "Record Deleted";
	}
}