package at.ameisenbert.webshop.Repositories;

import at.ameisenbert.webshop.Entities.DB.ProductDB;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<ProductDB, Integer> {
}
