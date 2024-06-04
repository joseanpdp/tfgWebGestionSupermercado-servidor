package japdp.supermercado.application.services;

import java.util.List;

import japdp.supermercado.application.dto.request.OrderDetailRequest;
import japdp.supermercado.application.dto.response.OrderDetailResponse;
import japdp.supermercado.application.dto.response.OrderDetailResponseBrief;
import japdp.supermercado.application.dto.response.OrderResponseBrief;

public interface OrderDetailService {
	
	public List<OrderDetailResponseBrief> getAll();
	
	public List<OrderDetailResponseBrief> getByOrderId(long id);
	
	public List<OrderDetailResponseBrief> getByProductId(long id);

	public OrderDetailResponse getById(long id);

	public OrderDetailResponse create(OrderDetailRequest orderDetailRequest);
	
	public OrderDetailResponse update(long id, OrderDetailRequest orderDetail);
	
	public void delete(long id);
	
	/*****************************************************/
	
	public void deleteByOrderId(long id);
	
	public void deleteByProductId(long id);

}
