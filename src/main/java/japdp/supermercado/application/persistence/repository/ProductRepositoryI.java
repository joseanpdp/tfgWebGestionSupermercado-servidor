package japdp.supermercado.application.persistence.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import japdp.supermercado.application.persistence.model.Category;
import japdp.supermercado.application.persistence.model.OrderDetail;
import japdp.supermercado.application.persistence.model.Product;

public interface ProductRepositoryI extends JpaRepository<Product, Long> {
	
	@Query("SELECT p FROM Product p WHERE p.name=:name")
	public Optional<Product> findByName(String name);
	
	@Query("SELECT p FROM Product p JOIN p.category c WHERE c.id=:id")
	public List<Product> findByCategoryId(long id);
	
	
	/****************************************/
	
	@Query("SELECT od FROM OrderDetail od JOIN od.product p WHERE p.id=:id")
	public List<OrderDetail> findOrderDetailsByProductId(long id);
	
}
