package at.ameisenbert.webshop.Repositories;

import at.ameisenbert.webshop.Entities.DB.UserDB;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends JpaRepository<UserDB, Integer> {

}
