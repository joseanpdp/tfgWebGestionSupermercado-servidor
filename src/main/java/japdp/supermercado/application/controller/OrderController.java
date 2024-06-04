package japdp.supermercado.application.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
import japdp.supermercado.application.dto.request.OrderRequest;
import japdp.supermercado.application.dto.response.OrderResponse;
import japdp.supermercado.application.dto.response.OrderResponseBrief;
import japdp.supermercado.application.exceptions.OrderNotFoundException;
import japdp.supermercado.application.persistence.model.OrderStatus;
import japdp.supermercado.application.services.OrderService;

/*

PARA Swagger

  En clase

		@Tag(name = "The amazing product API", description = "Godspeed!", externalDocs = @ExternalDocumentation(description = "docs desc class"))

  En métodos:
  
  	@Operation(summary = "Get product by id", description = "Just said it")
		@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Awesome product!"),
				@ApiResponse(responseCode = "404", description = "Product not found!") })

*/

@Tag(name = "The amazing order API", description = "Godspeed!", externalDocs = @ExternalDocumentation(description = "docs desc class"))

@CrossOrigin
@RestController
@RequestMapping("/order")
public class OrderController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(OrderController.class);
	
	@Autowired
	OrderService orderService;

	@ExceptionHandler(OrderNotFoundException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public String handleOrderNotFoundException(Exception e) {
		String message = "Order no encontrado: " + e;
		return message;
	}
	
	@GetMapping
	@ResponseStatus(HttpStatus.OK)
	public List<OrderResponseBrief> getAll() {
		return orderService.getAll();
	}

	@GetMapping("/bycustomer/{id}")
	@ResponseStatus(HttpStatus.OK)
	public List<OrderResponseBrief> getByCustomerId(@PathVariable long id) {
		return orderService.getByCustomerId(id);
	}	
	
	@GetMapping("/bystatus/{status}")
	@ResponseStatus(HttpStatus.OK)
	public List<OrderResponseBrief> getByStatus(@PathVariable OrderStatus status) {
		return orderService.getByStatus(status);
	}	
	
	@GetMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	public OrderResponse getById(@PathVariable long id) {
		return orderService.getById(id);
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public OrderResponse create(@RequestBody OrderRequest orderRequest) {
		return orderService.create(orderRequest);
	}

	@PutMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	public OrderResponse update(@PathVariable long id, @RequestBody OrderRequest orderRequest) {
		return orderService.update(id, orderRequest);
	}	
	
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	public void delete(@PathVariable long id) {
		orderService.delete(id);
	}	



}
