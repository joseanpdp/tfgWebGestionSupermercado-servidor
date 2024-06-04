package japdp.supermercado.application.exceptions;

public class OrderDetailNotFoundException extends RuntimeException {
	public OrderDetailNotFoundException() {
		super();
	}
	
	public OrderDetailNotFoundException(long id) {
		super("Order not found: " + id);
	}
}
