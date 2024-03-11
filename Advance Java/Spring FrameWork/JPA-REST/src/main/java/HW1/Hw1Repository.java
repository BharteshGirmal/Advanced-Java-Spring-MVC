package HW1;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Repository
// or @Component both are same
public interface Hw1Repository extends JpaRepository<CourseEntity, Integer>
{

}
