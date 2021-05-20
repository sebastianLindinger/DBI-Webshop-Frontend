package at.ameisenbert.webshop.Repositories;

import at.ameisenbert.webshop.Entities.DB.CartDB;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartRepository extends JpaRepository<CartDB, Integer> {
}
