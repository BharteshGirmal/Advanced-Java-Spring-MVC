package study.jparest.repositary;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import study.jparest.entity.UserEntity;

@Repository
public interface MyRepositary1 extends JpaRepository<UserEntity, String>
{

}
