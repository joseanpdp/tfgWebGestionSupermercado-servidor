package japdp.supermercado.application.services;

import java.util.List;

import japdp.supermercado.application.dto.request.OrderRequest;
import japdp.supermercado.application.dto.response.OrderResponse;
import japdp.supermercado.application.dto.response.OrderResponseBrief;
import japdp.supermercado.application.persistence.model.OrderStatus;

public interface OrderService {
	
	public List<OrderResponseBrief> getAll();

	public List<OrderResponseBrief> getByCustomerId(long id);
	
	public List<OrderResponseBrief> getByStatus(OrderStatus status);
	
	public OrderResponse getById(long id);
	
	public OrderResponse create(OrderRequest orderRequest);
	
	public OrderResponse update(long id, OrderRequest orderRequest);
	
	public void delete(long id);

	/*****************************************************/
	
	public void deleteByCustomerId(long id);
	
}
