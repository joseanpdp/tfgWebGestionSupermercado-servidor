package japdp.supermercado.application.persistence.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import japdp.supermercado.application.dto.response.OrderResponse;
import japdp.supermercado.application.persistence.model.Customer;
import japdp.supermercado.application.persistence.model.Order;
import japdp.supermercado.application.persistence.model.OrderDetail;

@Repository
public interface CustomerRepositoryI extends JpaRepository<Customer, Long> {
	
	@Query("SELECT c FROM Customer c WHERE c.name=:name AND c.surname=:surname")
	public Optional<Customer> findByNameAndSurname(String name, String surname);
	
	/*****************************************/
	
	@Query("SELECT o FROM Order o JOIN o.customer c WHERE c.id=:id")
	public List<Order> findOrdersByCustomerId(long id);
}
