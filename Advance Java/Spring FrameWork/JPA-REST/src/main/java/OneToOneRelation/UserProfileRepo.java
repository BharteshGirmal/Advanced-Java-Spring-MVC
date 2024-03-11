package OneToOneRelation;

import org.springframework.boot.autoconfigure.security.SecurityProperties.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserProfileRepo extends JpaRepository<UserProfile, Integer> 
{


}
