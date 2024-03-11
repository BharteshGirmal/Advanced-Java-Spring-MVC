package study.controller;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import study.jparest.entity.UserEntity;
import study.jparest.repositary.MyRepositary1;

@RestController
@RequestMapping("/user")
public class MyController1
{
	@Autowired
	MyRepositary1 repo1;
	
	@PostMapping("/add/{uname}/{pwd}")
	public String addUser(@PathVariable String uname,@PathVariable String pwd)
	{
		UserEntity u = new UserEntity(uname,pwd);
		repo1.save(u);
		return "User Add...";
	}
	
	@PutMapping("/update/{uname}/{oldPass}/{newPass}")
	public String update(@PathVariable String uname,@PathVariable String oldPass,@PathVariable String newPass)
	{
		List<UserEntity> list = repo1.findAll();
		list.forEach((row)->{if(row.getUname().equals(uname) && row.getPassword().equals(oldPass))
		{
			row.setPassword(newPass);
		}
		});
		repo1.saveAll(list);
		return "PassWord Updated...";
	}
	
	@DeleteMapping("/del/{uname}/{pwd}")
	public String delete(@PathVariable String uname,@PathVariable String pwd)
	{
		List<UserEntity> list = repo1.findAll();
		list.forEach((row)->{if(row.getUname().equals(uname) && row.getPassword().equals(pwd))
		{
			repo1.deleteById(uname);
		}
		});
		return "Record Deleted...";
	}
	
	@GetMapping("/allusers")
	public ArrayList<String> showAllUname()
	{
		List<UserEntity> list = repo1.findAll();
		ArrayList<String> al = new ArrayList<String>();
		list.forEach((row)->{al.add(row.getUname());});
		return al;
	}
	
	@PostMapping("/login")
	public ResponseEntity<Integer> isPresent(@RequestBody UserEntity u)
	{
		ResponseEntity<Integer> re = null;
		List<UserEntity> list = repo1.findAll();
		list.forEach((row)->{if(row.getUname().equals(u.getUname()) && row.getPassword().equals(u.getPassword()))
		{
			
		}
		});
	}
}













