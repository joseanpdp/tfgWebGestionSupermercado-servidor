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
import japdp.supermercado.application.dto.request.CategoryRequest;
import japdp.supermercado.application.dto.response.CategoryResponse;
import japdp.supermercado.application.exceptions.CategoryNotFoundException;
import japdp.supermercado.application.services.CategoryService;

/*

PARA Swagger

  En clase

		@Tag(name = "The amazing product API", description = "Godspeed!", externalDocs = @ExternalDocumentation(description = "docs desc class"))

  En métodos:
  
  	@Operation(summary = "Get product by id", description = "Just said it")
		@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Awesome product!"),
				@ApiResponse(responseCode = "404", description = "Product not found!") })

*/

@Tag(name = "PENDIENTE 01", description = "PENDIENTE 02", externalDocs = @ExternalDocumentation(description = "docs desc class"))

@CrossOrigin
@RestController
@RequestMapping("/category")
public class CategoryController {

	@Autowired
	CategoryService categoryService;

	@ExceptionHandler(CategoryNotFoundException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public String handleCategoryNotFoundException(Exception e) {
		String message = "Category no encontrado: " + e;
		return message;
	}
	
	@GetMapping
	@ResponseStatus(HttpStatus.OK)
	public List<CategoryResponse> getAll() {
		return categoryService.getAll();
	}

	@GetMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	public CategoryResponse getById(@PathVariable long id) {
		return categoryService.getById(id);
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public CategoryResponse createCategory(@RequestBody CategoryRequest categoryRequest) {
		return categoryService.create(categoryRequest);
	}

	@PutMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	public CategoryResponse updateCategory(@PathVariable long id, @RequestBody CategoryRequest categoryRequest) {
		return categoryService.update(id, categoryRequest);
	}

	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	public void deleteCategory(@PathVariable long id) {
		categoryService.delete(id);
	}

}
