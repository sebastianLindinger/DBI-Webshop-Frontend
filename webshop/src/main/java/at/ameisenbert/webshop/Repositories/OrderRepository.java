package at.ameisenbert.webshop.Repositories;

import at.ameisenbert.webshop.Entities.DB.OrderDB;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<OrderDB, Integer> {
}
