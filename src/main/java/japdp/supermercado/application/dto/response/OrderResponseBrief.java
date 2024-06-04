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

public class OrderResponseBrief {

	private long id;
	private String date;
	private String shipAddress;
    private long customerId;
    private String customerName;
    private String customerSurname;
	private OrderStatus status;

	/*
	public OrderResponseBrief(Order order) {
		id = order.getId();
		date = order.getDate();
		shipAddress = order.getShipAddress();
		status      = order.getStatus();

        customerId = order.getCustomer().getId();
	}*/
	
	public OrderResponseBrief(Order order) {
		id = order.getId();
		date = order.getDate();
		shipAddress = order.getShipAddress();
		status      = order.getStatus();

        customerId = order.getCustomer().getId();
        customerName = order.getCustomer().getName();
        customerSurname = order.getCustomer().getSurname();
	}
}
