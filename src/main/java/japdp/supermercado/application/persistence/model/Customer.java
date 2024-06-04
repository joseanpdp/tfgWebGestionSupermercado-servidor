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
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "T_CUSTOMER")
@Entity
public class Customer implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@NotNull(message = "Customer name cannot be null")
	@NotEmpty(message = "Customer name cannot be an empty string")
	@NotBlank(message = "Customer name cannot be blank")
	private String name;
	
	@NotNull(message = "Customer address cannot be null")
	@NotEmpty(message = "Customer address cannot be an empty string")
	@NotBlank(message = "Customer address cannot be blank")
	private String surname;
	
	@NotNull(message = "Customer address cannot be null")
	@NotEmpty(message = "Customer address cannot be an empty string")
	@NotBlank(message = "Customer address cannot be blank")
	private String address;
	
	public Customer(String name, String surname, String address) {
		this();
		this.name = name;
		this.surname = surname;
		this.address = address;
	}	
}
