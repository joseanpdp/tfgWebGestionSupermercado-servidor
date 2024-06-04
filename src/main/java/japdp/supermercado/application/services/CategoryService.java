package japdp.supermercado.application.services;

import java.util.List;

import japdp.supermercado.application.dto.request.CategoryRequest;
import japdp.supermercado.application.dto.response.CategoryResponse;

public interface CategoryService {
	
	public List<CategoryResponse> getAll();
	
	public CategoryResponse getById(long id);
	
	public CategoryResponse create(CategoryRequest categoryRequest);
	
	public CategoryResponse update(long id, CategoryRequest categoryRequest);
	
	public void delete(long id);
	
}
