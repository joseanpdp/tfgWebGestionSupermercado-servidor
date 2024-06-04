package japdp.supermercado.application.dto.response;

import japdp.supermercado.application.persistence.model.Customer;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CustomerResponse {
	
	private long id;
	private String name;
	private String surname;
	private String address;
	
	public CustomerResponse(Customer customer) {
		id      = customer.getId();
		name    = customer.getName();
		surname = customer.getSurname();
		address = customer.getAddress();
	}
	
}