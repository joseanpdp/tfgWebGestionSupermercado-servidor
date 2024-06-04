package japdp.supermercado.application.dto.request;

import japdp.supermercado.application.persistence.model.Category;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CategoryRequest {

	private String name;
	private String description;
	
}