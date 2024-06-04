package japdp.supermercado.application.persistence.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import japdp.supermercado.application.dto.response.ProductResponse;
import japdp.supermercado.application.persistence.model.Category;
import japdp.supermercado.application.persistence.model.Product;

public interface CategoryRepositoryI extends JpaRepository<Category, Long> {
	
	@Query("SELECT c FROM Category c WHERE c.name=:name")
	public Optional<Category> findByName(String name);
	
	/*************************************************/
	
	@Query("SELECT p FROM Product p JOIN p.category c WHERE c.id=:id")
	public List<Product> findProductsByCategoryId(long id);
}
