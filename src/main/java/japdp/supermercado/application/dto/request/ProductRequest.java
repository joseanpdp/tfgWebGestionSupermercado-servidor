package japdp.supermercado.application.dto.request;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class ProductRequest {

	private String name;
	private double price;
	private String description;
	private long categoryId;
	private int quantity;
	

}
