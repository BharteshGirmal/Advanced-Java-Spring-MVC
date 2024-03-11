package HW2;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/user")
public class Hw2RestController 
{
	@Autowired
	Hw2Repository repo;

	/*
	 * 1. POST /login in the request body pass uname and password check if the
	 * database has matching row if yes return statuscode 200 else return statuscode
	 * 404 ( return type is ResponseEntity )
	 */

	@PostMapping("/add/{uname}/{pass}")
	public String AddUser(@PathVariable String uname , @PathVariable String pass)
	{
		UserEntity user=new UserEntity(uname,pass);
		List<UserEntity> list=repo.findAll();
		list.forEach((row)->{
			if(row.getUsername()!=uname)
			{
				repo.save(user);
				return;

			}
		});
		return "<<<<<<<<<< User Added sucessfully >>>>>>>>>>";
	}

	//2.   GET  /allUsers  = show list of all usernames only
	@GetMapping("/getusers")
	public ArrayList<String> GetAllUsers()
	{
		List<UserEntity> list=repo.findAll();
		ArrayList<String> al=new ArrayList<>();
		list.forEach((row)->{al.add(row.getUsername());});
		return al;
	}


	// 3. PUT /changepwd/{uname}/{oldpwd}/{newpwd} change password only if oldpwd is correct

	@PutMapping("/changepwd/{uname}/{oldpwd}/{newpwd}")
	public String UpdatePWD(@PathVariable String uname,@PathVariable String oldpwd,@PathVariable String newpwd)
	{
		List<UserEntity> list=repo.findAll();
		list.forEach((row)->{
			if(row.getUsername().equals(uname)&& row.getPassword().equals(oldpwd))
			{
				row.setPassword(newpwd);
				repo.saveAll(list);
			}
			else
			{
				System.out.println("<<<<<<<<<< Username Password doesnt Matches >>>>>>>>>>");
			}
		});

		return "<<<<<<<<<< Password Updated sucessfully >>>>>>>>>>";
	}

	
	// 4.   DELETE   /removeuser/{uname}/{pwdForadmin}
	//	remove given uname if the pwdForadmin user is correct

	@DeleteMapping("/removeuser/{uname}/{pass}")
	public String RemoveUser(@PathVariable String uname,@PathVariable String pass)
	{
		List<UserEntity> list=repo.findAll();
		list.forEach((row)->{if(row.getUsername().equals(uname)&&row.getPassword().equals(pass))
		{
			repo.delete(row);
		}});
		return "<<<<<<<<<< User Removed sucessfully >>>>>>>>>>";
	}
}
