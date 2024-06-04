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

public class OrderDetailResponseBrief {

	private long   id;
	private int    quantity;
	
	private long   productId;
	private String productName;
	private double productPrice;
	

	public OrderDetailResponseBrief(OrderDetail orderDetail) {
		
		id       = orderDetail.getId();
		quantity = orderDetail.getQuantity();
		
		Product  product  = orderDetail.getProduct();
		
		productId   = product.getId();
		productName = product.getName();
		productPrice = product.getPrice();
		
	}
}
