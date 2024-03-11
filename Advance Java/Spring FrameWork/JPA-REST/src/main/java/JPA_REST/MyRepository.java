package JPA_REST;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface MyRepository extends JpaRepository<ProductEntity, Integer>
{
	public List<ProductEntity> findByName(String name);
	public List<ProductEntity> findByCost(int cost);
	
	@Query(value = "from JPA_REST.ProductEntity P where P.cost > :cost")
	public List<ProductEntity> findLessThanCost(@Param("cost")int cost);
	
}
