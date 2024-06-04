package japdp.supermercado.application.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.tags.Tag;
import japdp.supermercado.application.dto.request.CustomerRequest;
import japdp.supermercado.application.dto.response.CustomerResponse;
import japdp.supermercado.application.exceptions.CustomerNotFoundException;
import japdp.supermercado.application.services.CustomerService;

/*

PARA Swagger

  En clase

		@Tag(name = "The amazing product API", description = "Godspeed!", externalDocs = @ExternalDocumentation(description = "docs desc class"))

  En métodos:
  
  	@Operation(summary = "Get product by id", description = "Just said it")
		@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Awesome product!"),
				@ApiResponse(responseCode = "404", description = "Product not found!") })

*/

@Tag(name = "The amazing customer API", description = "Godspeed!", externalDocs = @ExternalDocumentation(description = "docs desc class"))

@CrossOrigin
@RestController
@RequestMapping("/customer")
public class CustomerController {

	@Autowired
	CustomerService customerService;

	@ExceptionHandler(CustomerNotFoundException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public String handleCustomerNotFoundException(Exception e) {
		String message = "Customer no encontrado: " + e;
		return message;
	}

	@GetMapping
	@ResponseStatus(HttpStatus.OK)
	public List<CustomerResponse> getAll() {
		return customerService.getAll();
	}

	@GetMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	public CustomerResponse getById(@PathVariable long id) {
		return customerService.getById(id);
	}

	@GetMapping("/{name}/{surname}")
	@ResponseStatus(HttpStatus.OK)
	public CustomerResponse getCustomerByNameAndSurname(@PathVariable String name, @PathVariable String surname) {
		return customerService.getByNameAndSurname(name, surname);
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public CustomerResponse createCustomer(@RequestBody CustomerRequest customerRequest) {
		return customerService.create(customerRequest);
	}

	@PutMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	public CustomerResponse updateCustomer(@PathVariable long id, @RequestBody CustomerRequest customerRequest) {
		return customerService.update(id, customerRequest);
	}

	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	public void deleteCustomer(@PathVariable long id) {
		customerService.delete(id);
	}

}

