package japdp.supermercado.application.persistence.model;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import japdp.supermercado.application.dto.request.CategoryRequest;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "T_CATEGORY")
@Entity
public class Category implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@NotNull(message = "Category name cannot be null")
	@NotEmpty(message = "Category name cannot be an empty string")
	@NotBlank(message = "Category name cannot be blank")
	private String name;

	@NotNull(message = "Category description cannot be null")
	@NotEmpty(message = "Category description cannot be an empty string")
	@NotBlank(message = "Category description cannot be blank")
	private String description;

/*
	@JsonIgnoreProperties("category")
	@OneToMany(mappedBy = "category")
	private List<Product> products;
*/
	
	public Category(String name, String description) {
		this();
		this.name = name;
		this.description = description;
		// this.products = new ArrayList<>();
	}

}

