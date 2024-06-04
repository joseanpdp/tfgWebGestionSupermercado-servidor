package japdp.supermercado.application.persistence.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import japdp.supermercado.application.persistence.model.Order;
import japdp.supermercado.application.persistence.model.OrderDetail;
import japdp.supermercado.application.persistence.model.Product;

public interface OrderDetailRepositoryI extends JpaRepository<OrderDetail, Long> {
	
	@Query("SELECT od FROM OrderDetail od JOIN od.order o WHERE o.id=:id")
	public List<OrderDetail> findByOrderId(long id);	

	@Query("SELECT od FROM OrderDetail od JOIN od.product p WHERE p.id=:id")
	public List<OrderDetail> findByProductId(long id);
}
