package japdp.supermercado.application.dto.response;
import japdp.supermercado.application.persistence.model.Customer;
import japdp.supermercado.application.persistence.model.Order;
import japdp.supermercado.application.persistence.model.OrderDetail;
import japdp.supermercado.application.persistence.model.Product;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor

public class OrderDetailResponse {

	private long   id;
	private int    quantity;
	
	private long   productId;
	private String productName;
	private double productPrice;
	
	private long   orderId;
	private String orderDate;
	private String orderShipAddress;
	
	private long   customerId;
	private String customerName;
	private String customerSurname;

	public OrderDetailResponse(OrderDetail orderDetail) {
		
		id       = orderDetail.getId();
		quantity = orderDetail.getQuantity();
		
		Product  product  = orderDetail.getProduct();
		Order    order    = orderDetail.getOrder();
		Customer customer = order.getCustomer();
		
		productId   = product.getId();
		productName = product.getName();
		productPrice = product.getPrice();
		
		orderId           = order.getId();
		orderDate         = order.getDate();
		orderShipAddress  = order.getShipAddress();
		
		customerId        = customer.getId();
		customerName      = customer.getName();
		customerSurname   = customer.getSurname();
		
	}
}
