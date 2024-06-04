package japdp.supermercado.application.dto.request;

import japdp.supermercado.application.persistence.model.Customer;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CustomerRequest {
	
	private String name;
	private String surname;
	private String address;
		
}