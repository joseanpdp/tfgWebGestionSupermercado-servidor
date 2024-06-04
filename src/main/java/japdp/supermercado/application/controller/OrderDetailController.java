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
import japdp.supermercado.application.dto.request.OrderDetailRequest;
import japdp.supermercado.application.dto.response.OrderDetailResponse;
import japdp.supermercado.application.dto.response.OrderDetailResponseBrief;
import japdp.supermercado.application.dto.response.OrderResponseBrief;
import japdp.supermercado.application.exceptions.ProductNotFoundException;
import japdp.supermercado.application.persistence.model.OrderDetail;
import japdp.supermercado.application.services.OrderDetailService;

/*

PARA Swagger

  En clase

		@Tag(name = "The amazing product API", description = "Godspeed!", externalDocs = @ExternalDocumentation(description = "docs desc class"))

  En métodos:
  
  	@Operation(summary = "Get product by id", description = "Just said it")
		@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Awesome product!"),
				@ApiResponse(responseCode = "404", description = "Product not found!") })

*/

@Tag(name = "The amazing order detail API", description = "Godspeed!", externalDocs = @ExternalDocumentation(description = "docs desc class"))

@CrossOrigin
@RestController
@RequestMapping("/orderdetail")
public class OrderDetailController {

	@Autowired
	OrderDetailService orderDetailService;

	@ExceptionHandler(ProductNotFoundException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public String handleOrderDetailNotFoundException(Exception e) {
		String message = "Order detail no encontrado: " + e;
		return message;
	}
	
	@GetMapping
	@ResponseStatus(HttpStatus.OK)
	public List<OrderDetailResponseBrief> getAll() {
		return orderDetailService.getAll();
	}

	@GetMapping("/byorder/{id}")
	@ResponseStatus(HttpStatus.OK)
	public List<OrderDetailResponseBrief> getByOrderId(@PathVariable long id) {
		return orderDetailService.getByOrderId(id);
	}	
	
	@GetMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	public OrderDetailResponse getById(@PathVariable long id) {
		return orderDetailService.getById(id);
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public OrderDetailResponse create(@RequestBody OrderDetailRequest orderDetailRequest) {
		return orderDetailService.create(orderDetailRequest);
	}

	@PutMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	public OrderDetailResponse updateOrderDetail(@PathVariable long id, 
			@RequestBody OrderDetailRequest orderDetailRequest) {
		return orderDetailService.update(id, orderDetailRequest);
	}

	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	public void deleteOrderDetail(@PathVariable long id) {
		orderDetailService.delete(id);
	}

	
}
