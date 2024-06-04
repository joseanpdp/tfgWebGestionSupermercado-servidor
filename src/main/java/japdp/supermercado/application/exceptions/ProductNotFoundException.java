package japdp.supermercado.application.exceptions;

public class ProductNotFoundException extends RuntimeException {
	public ProductNotFoundException() {
		super();
	}
	
	public ProductNotFoundException(long id) {
		super("Product not found: " + id);
	}
	
	public ProductNotFoundException(String name) {
		super("Product not found: " + name);
	}
}
