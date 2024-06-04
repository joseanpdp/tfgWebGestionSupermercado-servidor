package japdp.supermercado.application.dto.response;

import japdp.supermercado.application.persistence.model.Category;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CategoryResponse {
	private long id;
	private String name;
	private String description;
	
	public CategoryResponse(Category category) {
		id          = category.getId();
		name        = category.getName();
		description = category.getDescription();
	}
}