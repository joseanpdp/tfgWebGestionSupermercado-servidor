package japdp.supermercado.application.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import japdp.supermercado.application.dto.request.CategoryRequest;
import japdp.supermercado.application.dto.response.CategoryResponse;
import japdp.supermercado.application.exceptions.CategoryNotFoundException;
import japdp.supermercado.application.persistence.model.Category;
import japdp.supermercado.application.persistence.repository.CategoryRepositoryI;
import japdp.supermercado.application.persistence.repository.ProductRepositoryI;

@Service
public class CategoryServiceImpl implements CategoryService {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(CategoryServiceImpl.class);
	
	@Autowired
	CategoryRepositoryI categoryRepository;

	@Autowired
	ProductRepositoryI productRepository;
	
	@Autowired
	ProductService productService;
	
	@Override
	public List<CategoryResponse> getAll() {
		LOGGER.info("Obteniendo todas las categorías");
		List<Category> categories = categoryRepository.findAll();
		List<CategoryResponse> categoriesDTO = new ArrayList<>();
		for (Category category : categories) {
			CategoryResponse categoryDTO = new CategoryResponse(category.getId(), category.getName(), 
												   category.getDescription());
			categoriesDTO.add(categoryDTO);
		}
		return categoriesDTO;
	}


	@Override
	public CategoryResponse getById(long id) {
		LOGGER.info("Obtención de la categoría {}", id);
		Optional<Category> optionalCategory = categoryRepository.findById(id);
		if (optionalCategory.isPresent()) {
			LOGGER.info("Obtención de la categoría {} exitosa", id);
			Category category = optionalCategory.get();
			return new CategoryResponse(category.getId(), category.getName(), category.getDescription());
		}
		else {
			throw new CategoryNotFoundException(id);
		}
	}

	@Override
	public CategoryResponse create(CategoryRequest categoryRequest) {
		Category category = new Category(categoryRequest.getName(),categoryRequest.getDescription());
		categoryRepository.save(category);
		return new CategoryResponse(category);
	}
	
	@Override
	public CategoryResponse update(long id, CategoryRequest categoryRequest) {
		Optional<Category> optionalCategory = categoryRepository.findById(id);
		if(optionalCategory.isPresent()) {
			Category category = optionalCategory.get();
			category.setName(categoryRequest.getName());
			category.setDescription(categoryRequest.getDescription());		
			categoryRepository.save(category);
			return new CategoryResponse(category);
		}
		else {
			throw new CategoryNotFoundException(id);
		}
	}

	@Override
	public void delete(long id) {
		Optional<Category> optionalCategory = categoryRepository.findById(id);
		if(optionalCategory.isPresent()) {
			productService.deleteByCategoryId(id);
			categoryRepository.deleteById(optionalCategory.get().getId());
		}				
	}
	
}

