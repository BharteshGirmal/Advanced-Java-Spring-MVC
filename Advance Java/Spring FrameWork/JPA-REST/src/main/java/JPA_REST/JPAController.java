package JPA_REST;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import antlr.collections.impl.LList;
@CrossOrigin
@RestController
@RequestMapping(path = "/product")
public class JPAController
{
	@Autowired
	MyRepository repo;
	
	@GetMapping("/getproduct")
	public List<ProductEntity> GetAllProducts()
	{
		System.out.println("Get Ajax Product Information ...");
		List<ProductEntity> list=repo.findAll();
		System.out.println(list);
		return list;
		
	}
	
	@PostMapping("/add/{id}/{name}/{cost}")
	public String Insert(@PathVariable int id , @PathVariable String name, @PathVariable int cost)
	{
		ProductEntity entity=new ProductEntity(id,name,cost);
		repo.save(entity);
		return "............. Record Inserted .............";
	}
	
	@DeleteMapping("/deleteproduct")
	public void deletePrduct(@RequestParam int id)
	{
		repo.deleteById(id);
	}
	
	@PutMapping("updateproduct/{pid}/{pname}")
	public void UpdateProduct(@PathVariable int pid , @PathVariable String pname)
	{
		ProductEntity list=repo.findById(pid).get();
		list.setName(pname);
		repo.save(list);
	}
	
	@PostMapping("/findname/{name}")
	public List<ProductEntity> getAllNames(@PathVariable String name)
	{
		List<ProductEntity> list=repo.findByName(name);
		return list;
	}
	
	@PostMapping("/findcost/{cost}")
	public List<ProductEntity> getCost(@PathVariable int cost)
	{
		List<ProductEntity> list=repo.findByCost(cost);
		return list;
	}
	

	@PostMapping("/find/{cost}")
	public List<ProductEntity> getcCostless(@PathVariable int cost)
	{
		List<ProductEntity> list=repo.findLessThanCost(cost);
		return list;
	}
}
