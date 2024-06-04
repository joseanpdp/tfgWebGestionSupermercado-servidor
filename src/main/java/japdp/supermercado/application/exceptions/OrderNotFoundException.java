package japdp.supermercado.application.exceptions;

public class OrderNotFoundException extends RuntimeException {
	public OrderNotFoundException() {
		super();
	}
	
	public OrderNotFoundException(long id) {
		super("Order not found: " + id);
	}
}
