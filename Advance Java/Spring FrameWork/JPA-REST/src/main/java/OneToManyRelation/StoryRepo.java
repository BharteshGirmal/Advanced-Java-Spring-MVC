package OneToManyRelation;

import org.springframework.data.jpa.repository.JpaRepository;

import OneToOneRelation.User;

public interface StoryRepo extends JpaRepository<Story, Integer> 
{

}
