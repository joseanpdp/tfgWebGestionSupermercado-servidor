package japdp.supermercado.application.exceptions;

public class CustomerNotFoundException extends RuntimeException {
	public CustomerNotFoundException() {
		super();
	}
	
	public CustomerNotFoundException(long id) {
		super("Customer not found: " + id);
	}
	
	public CustomerNotFoundException(String name, String surname) {
		super("Customer not found: " + name + ", " + surname);
	}
}
