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
import japdp.supermercado.application.dto.request.ProductRequest;
import japdp.supermercado.application.dto.response.ProductResponse;
import japdp.supermercado.application.dto.response.ProductResponseBrief;
import japdp.supermercado.application.exceptions.ProductNotFoundException;
import japdp.supermercado.application.persistence.model.Product;
import japdp.supermercado.application.services.ProductService;

/*

  PARA Swagger
  
    En clase
  
  		@Tag(name = "The amazing product API", description = "Godspeed!", externalDocs = @ExternalDocumentation(description = "docs desc class"))

    En métodos:
    
    	@Operation(summary = "Get product by id", description = "Just said it")
		@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Awesome product!"),
				@ApiResponse(responseCode = "404", description = "Product not found!") })
 
*/

@Tag(name = "The amazing product API", description = "Godspeed!", externalDocs = @ExternalDocumentation(description = "docs desc class"))

@CrossOrigin
@RestController
@RequestMapping("/product")
public class ProductController {

	private static final Logger LOGGER = LoggerFactory.getLogger(ProductController.class);

	@Autowired
	ProductService productService;

	@ExceptionHandler(ProductNotFoundException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public String handleProductNotFoundException(Exception e) {
		String message = "Product no encontrado: " + e;
		return message;
	}

	@GetMapping
	@ResponseStatus(HttpStatus.OK)
	public List<ProductResponse> getAll() {
		return productService.getAll();
	}

	@GetMapping("/bycategory/{id}")
	@ResponseStatus(HttpStatus.OK)
	public List<ProductResponseBrief> getByCategoryId(@PathVariable long id) {
		return productService.getByCategoryId(id);
	}	
	
	@GetMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	public ProductResponse getById(@PathVariable long id) {
		return productService.getById(id);
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public ProductResponse createProduct(@RequestBody ProductRequest productRequest) {
		return productService.create(productRequest);
	}

	@PutMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	public ProductResponse updateProduct(@PathVariable long id, @RequestBody ProductRequest productRequest) {
        LOGGER.debug("updateProduct: {}",productRequest.getQuantity());
		return productService.update(id, productRequest);
	}

	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	public void deleteProduct(@PathVariable long id) {
		productService.delete(id);
	}

}
