package japdp.supermercado.application.dto.response;

import japdp.supermercado.application.persistence.model.Category;
import japdp.supermercado.application.persistence.model.Product;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor

public class ProductResponseBrief {
	
	private long id;
	private String name;
	private double price;
	private String description;
	private int quantity;
	
	public ProductResponseBrief(Product product) {
		
		id          = product.getId();
		name        = product.getName();
		price       = product.getPrice();
		description = product.getDescription();
		quantity = product.getQuantity();

	}
}
