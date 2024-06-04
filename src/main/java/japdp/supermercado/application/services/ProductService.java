package japdp.supermercado.application.services;

import java.util.List;

import japdp.supermercado.application.dto.request.ProductRequest;
import japdp.supermercado.application.dto.response.ProductResponse;
import japdp.supermercado.application.dto.response.ProductResponseBrief;
import japdp.supermercado.application.persistence.model.Product;

public interface ProductService {
	
	public List<ProductResponse> getAll();

	public List<ProductResponseBrief> getByCategoryId(long id);	
	
	public ProductResponse getById(long id);
	
	public ProductResponse getByName(String name);

	public ProductResponse create(ProductRequest productRequest);
	
	public ProductResponse update(long id, ProductRequest productRequest);
	
	public void delete(long id);
	
	/*****************************************************/

    public void deleteByCategoryId(long id);


}
