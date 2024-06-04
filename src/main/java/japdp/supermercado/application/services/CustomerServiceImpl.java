package japdp.supermercado.application.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import japdp.supermercado.application.dto.request.CustomerRequest;
import japdp.supermercado.application.dto.response.CustomerResponse;
import japdp.supermercado.application.exceptions.CustomerNotFoundException;
import japdp.supermercado.application.persistence.model.Customer;
import japdp.supermercado.application.persistence.repository.CustomerRepositoryI;

@Service
public class CustomerServiceImpl implements CustomerService {

	private static final Logger LOGGER = LoggerFactory.getLogger(CustomerServiceImpl.class);
	
	@Autowired
	CustomerRepositoryI customerRepository;

	@Autowired
	OrderService orderService;

	@Override
	public List<CustomerResponse> getAll() {
		List<Customer> customers = customerRepository.findAll();
		List<CustomerResponse> customersDTO = new ArrayList<>();
		for (Customer customer : customers) {
			CustomerResponse customerDTO = new CustomerResponse(customer.getId(), customer.getName(),
					customer.getSurname(), customer.getAddress());
			customersDTO.add(customerDTO);
		}
		return customersDTO;
	}

	@Override
	public CustomerResponse getById(long id) {
		Optional<Customer> optionalCustomer = customerRepository.findById(id);
		if (optionalCustomer.isPresent()) {
			Customer customer = optionalCustomer.get();
			return new CustomerResponse(customer.getId(), customer.getName(), customer.getSurname(),
					customer.getAddress());
		} else {
			throw new CustomerNotFoundException(id);
		}
	}

	@Override
	public CustomerResponse getByNameAndSurname(String name, String surname) {
		Optional<Customer> optionalCustomer = customerRepository.findByNameAndSurname(name, surname);
		if (optionalCustomer.isPresent()) {
			Customer customer = optionalCustomer.get();
			return new CustomerResponse(customer.getId(), customer.getName(), customer.getSurname(),
					customer.getAddress());
		} else {
			throw new CustomerNotFoundException(name, surname);
		}
	}

	@Override
	public CustomerResponse create(CustomerRequest customerRequest) {
		Customer customer = new Customer(customerRequest.getName(),
										 customerRequest.getSurname(),
										 customerRequest.getAddress());
		customerRepository.save(customer);
		return new CustomerResponse(customer);
	}

	
	
	@Override
	public CustomerResponse update(long id, CustomerRequest customerRequest) {
		Optional<Customer> optionalCustomer = customerRepository.findById(id);
		if (optionalCustomer.isPresent()) {
			Customer customer = optionalCustomer.get();
			customer.setName(customerRequest.getName());
			customer.setSurname(customerRequest.getSurname());
			customer.setAddress(customerRequest.getAddress());
			customerRepository.save(customer);
			return new CustomerResponse(customer);
		} else {
			throw new CustomerNotFoundException(id);
		}
	}

	@Override
	public void delete(long id) {
		Optional<Customer> optionalCustomer = customerRepository.findById(id);
		if (optionalCustomer.isPresent()) {
			orderService.deleteByCustomerId(id);
			customerRepository.deleteById(optionalCustomer.get().getId());
		}
	}

}
