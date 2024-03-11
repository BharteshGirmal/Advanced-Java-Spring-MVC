package study.jparest.repositary;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import study.jparest.entity.CourseEntity1;

@Repository
public interface MyRepositary extends JpaRepository<CourseEntity1,Integer>
{

}
