package OneToManyRelation;

import org.springframework.data.jpa.repository.JpaRepository;

public interface StoryBookRepo extends JpaRepository<StoryBook, Integer>
{

}
