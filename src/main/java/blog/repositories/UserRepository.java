package blog.repositories;

import blog.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by lucky on 16-12-6.
 * not provide any implementation, Spring Data JPA will implement it
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long>{
}
