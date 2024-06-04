package japdp.supermercado.application.exceptions;

public class CategoryNotFoundException extends RuntimeException {
	public CategoryNotFoundException() {
		super();
	}
	
	public CategoryNotFoundException(long id) {
		super("Category not found: " + id);
	}
}
