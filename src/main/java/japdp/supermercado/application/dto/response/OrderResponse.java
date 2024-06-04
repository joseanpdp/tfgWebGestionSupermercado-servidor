package japdp.supermercado.application.dto.response;

import japdp.supermercado.application.persistence.model.Customer;
import japdp.supermercado.application.persistence.model.Order;
import japdp.supermercado.application.persistence.model.OrderStatus;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor

public class OrderResponse {
	
	private long id;
	private String date;
	private String shipAddress;

	private long customerId;
	private String customerName;
	private String customerSurname;
	
	private OrderStatus status;
	
	public OrderResponse(Order order) {
		
		id                = order.getId();
		date              = order.getDate();
		shipAddress       = order.getShipAddress();
		status            = order.getStatus();
		
		Customer customer = order.getCustomer();
		customerId        = customer.getId();
		customerName      = customer.getName();
		customerSurname   = customer.getSurname();
		
	}
}