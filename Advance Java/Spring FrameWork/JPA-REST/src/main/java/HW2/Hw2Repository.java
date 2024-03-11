package HW2;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Hw2Repository extends JpaRepository<UserEntity, Integer> 
{

}
