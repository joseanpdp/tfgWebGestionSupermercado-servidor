package japdp.supermercado.application.persistence.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import japdp.supermercado.application.persistence.model.Order;
import japdp.supermercado.application.persistence.model.OrderDetail;
import japdp.supermercado.application.persistence.model.OrderStatus;

public interface OrderRepositoryI extends JpaRepository<Order, Long> {

	/*

	Si tuvieramos:
	
	
	   class Order 
	   	 @OneToMany(mappedBy="order")
     	 private List<OrderDetail> orderDetails;

	   podríamos utilizar
	   @Query("SELECT od FROM Order o JOIN o.orderDetails od WHERE o.id=:id")
	   public List<OrderDetail> findOrderDetailsByOrderId(long id);
	   
	 Como solo tenemos el @ManyToOne en OrderDetail la opción es la siguiente:
	 
    */

	@Query("SELECT o FROM Order o JOIN o.customer c WHERE c.id=:id")
	public List<Order> findByCustomerId(long id);
	
	@Query("SELECT o FROM Order o WHERE o.status=:status")
	public List<Order> findByStatus(OrderStatus status);
	
	/******************************************/
	
	@Query("SELECT od FROM OrderDetail od JOIN od.order o WHERE o.id=:id")
	public List<OrderDetail> findOrderDetailsByOrderId(long id);

	
}

