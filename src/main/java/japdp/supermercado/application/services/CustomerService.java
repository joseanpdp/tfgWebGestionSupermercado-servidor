package japdp.supermercado.application.services;

import java.util.List;

import japdp.supermercado.application.dto.request.CustomerRequest;
import japdp.supermercado.application.dto.response.CustomerResponse;


public interface CustomerService {
	
	public List<CustomerResponse> getAll();
	
	public CustomerResponse getById(long id);
	
	public CustomerResponse getByNameAndSurname(String name, String surname);
	
	public CustomerResponse create(CustomerRequest customerRequest);
	
	public CustomerResponse update(long id, CustomerRequest customerRequest);
	
	public void delete(long id);
	
}
