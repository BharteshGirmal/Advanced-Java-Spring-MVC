package OneToOneRelation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OneToOneController 
{
	@Autowired
	UserProfileRepo repo;
	
	@Autowired
	UserRepo repo2;
	
	// Case 1: table level Without Cascading style
	@PostMapping("/add/{uname}/{pass}/{fname}/{lname}/{email}")
	public String AddUser(@PathVariable String uname ,@PathVariable String pass ,@PathVariable String fname ,@PathVariable String lname,@PathVariable String email)
	{
		UserProfile profile= new UserProfile();
		profile.setFirstName(fname);
		profile.setLastName(lname);
		profile.setEmail(email);
		
		User U=new User();
		U.setUser_name(uname);
		U.setPassword(pass);
		
		System.out.println("Before Saving The Id : "+U.getUserid());
		User saveduser=repo2.save(U);
		System.out.println("After Saving The ID : "+saveduser.getUserid());
		
		profile.setUser(saveduser);
		repo.save(profile);
		
		return ".................. User added ..................";
	}

	//case 2: using cascading Styling ...
	
	@PostMapping("/add2/{}/{uname}/{pass}/{fname}/{lname}/{email}")
	public String CascadeInsert(@PathVariable String uname ,@PathVariable String pass
	, @PathVariable String fname ,@PathVariable String lname , @PathVariable String email )
	{
		UserProfile profile = new UserProfile();
		profile.setFirstName(fname);
		profile.setLastName(lname);
		profile.setEmail(email);
		
		User U= new User();
		U.setUser_name(uname);
		U.setPassword(pass);
		profile.setUser(U);
		U.setProfile(profile);
		
		repo2.save(U);
		
		return ".................. User added ..................";
	}
	
	@DeleteMapping("/delete/{id}")
	public String DeleteUser(@PathVariable int id)
	{
		User U = repo2.findById(id).get();
		System.out.println("After fetching User ====> "+U.getUser_name()+" Profile ===> "+U.getProfile().getFirstName());
		repo2.delete(U);
		return ".................. User Deleted ..................";
	}
}
