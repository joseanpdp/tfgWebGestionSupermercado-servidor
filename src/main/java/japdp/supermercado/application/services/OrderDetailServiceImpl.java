package japdp.supermercado.application.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import japdp.supermercado.application.dto.request.OrderDetailRequest;
import japdp.supermercado.application.dto.response.OrderDetailResponse;
import japdp.supermercado.application.dto.response.OrderDetailResponseBrief;
import japdp.supermercado.application.dto.response.OrderResponseBrief;
import japdp.supermercado.application.exceptions.CustomerNotFoundException;
import japdp.supermercado.application.exceptions.OrderDetailNotFoundException;
import japdp.supermercado.application.exceptions.OrderNotFoundException;
import japdp.supermercado.application.exceptions.ProductNotFoundException;
import japdp.supermercado.application.persistence.model.Order;
import japdp.supermercado.application.persistence.model.OrderDetail;
import japdp.supermercado.application.persistence.model.Product;
import japdp.supermercado.application.persistence.repository.OrderDetailRepositoryI;
import japdp.supermercado.application.persistence.repository.OrderRepositoryI;
import japdp.supermercado.application.persistence.repository.ProductRepositoryI;

@Service
public class OrderDetailServiceImpl implements OrderDetailService {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(OrderDetailServiceImpl.class);
	
	@Autowired
	OrderDetailRepositoryI orderDetailRepository;
	
	@Autowired
	OrderRepositoryI orderRepository;

	@Autowired
	ProductRepositoryI productRepository;	
	
	@Override
	public List<OrderDetailResponseBrief> getAll() {
		List<OrderDetail> orderDetails = orderDetailRepository.findAll();
		List<OrderDetailResponseBrief> orderDetailsDTO2 = new ArrayList<>();
		for (OrderDetail orderDetail : orderDetails) {
			OrderDetailResponseBrief orderDetailDTO2 = new OrderDetailResponseBrief(orderDetail);
			orderDetailsDTO2.add(orderDetailDTO2);
		}
		return orderDetailsDTO2;
	}
	

	@Override
	public OrderDetailResponse getById(long id) {
		Optional<OrderDetail> optionalOrderDetail = orderDetailRepository.findById(id);
		if (optionalOrderDetail.isPresent()) {
			OrderDetail orderDetail = optionalOrderDetail.get();
			return new OrderDetailResponse(orderDetail);
		} else {
			throw new CustomerNotFoundException(id);
		}
	}	
	
	@Override
	public List<OrderDetailResponseBrief> getByOrderId(long id) {
		List<OrderDetail> orderDetails = orderDetailRepository.findByOrderId(id);
		// Lo que sigue es factorizable (ver abajo)
		List<OrderDetailResponseBrief> orderDetailsResponseBrief = new ArrayList<>();
		for (OrderDetail orderDetail : orderDetails) {
			OrderDetailResponseBrief orderDetailResponseBrief = new OrderDetailResponseBrief(orderDetail);
			orderDetailsResponseBrief.add(orderDetailResponseBrief);
		}
		return orderDetailsResponseBrief;
	}
	
	@Override
	public List<OrderDetailResponseBrief> getByProductId(long id) {
		List<OrderDetail> orderDetails = orderDetailRepository.findByProductId(id);
		// Lo que sigue es factorizable (ver arriba)
		List<OrderDetailResponseBrief> orderDetailsResponseBrief = new ArrayList<>();
		for (OrderDetail orderDetail : orderDetails) {
			OrderDetailResponseBrief orderDetailResponseBrief = new OrderDetailResponseBrief(orderDetail);
			orderDetailsResponseBrief.add(orderDetailResponseBrief);
		}
		return orderDetailsResponseBrief;
	}
	
	@Override
	public OrderDetailResponse create(OrderDetailRequest orderDetailRequest) {
		long orderId   = orderDetailRequest.getOrderId();
		long productId = orderDetailRequest.getProductId();
		Optional<Order> optionalOrder = orderRepository.findById(orderId);
		if(optionalOrder.isPresent()) {
			Order order = optionalOrder.get();
			Optional<Product> optionalProduct = productRepository.findById(productId);
			if(optionalProduct.isPresent()) {
				Product product = optionalProduct.get();
				OrderDetail orderDetail = 
						new OrderDetail(order,product,orderDetailRequest.getQuantity());
				orderDetailRepository.save(orderDetail);
				return new OrderDetailResponse(orderDetail);
			}
			else {
				throw new ProductNotFoundException(productId);				
			}
		}
		else {
			throw new OrderNotFoundException(orderId);
		}
	}


	@Override
	public OrderDetailResponse update(long id, OrderDetailRequest orderDetailRequest) {
		Optional<OrderDetail> optionalOrderDetail = orderDetailRepository.findById(id);
		if(optionalOrderDetail.isPresent()) {
			OrderDetail orderDetail = optionalOrderDetail.get();
			long orderId   = orderDetailRequest.getOrderId();
			Optional<Order> optionalOrder = orderRepository.findById(orderId);
			if(optionalOrder.isPresent()) {
				Order order = optionalOrder.get();
				long productId = orderDetailRequest.getProductId();
				Optional<Product> optionalProduct = productRepository.findById(productId);		
				if(optionalProduct.isPresent()) {
					Product product = optionalProduct.get();
					orderDetail.setOrder(order);
					orderDetail.setProduct(product);
					orderDetail.setQuantity(orderDetailRequest.getQuantity());
					orderDetailRepository.save(orderDetail);
					return new OrderDetailResponse(orderDetail);
				}
				else {
					throw new ProductNotFoundException(productId);				
				}
			}
			else {
				throw new OrderNotFoundException(orderId);
			}
		}
		else {
			throw new OrderDetailNotFoundException(id);
		}
	}



	@Override
	public void delete(long id) {
		Optional<OrderDetail> optionalOrderDetail = orderDetailRepository.findById(id);
		if(optionalOrderDetail.isPresent()) {
			orderDetailRepository.deleteById(optionalOrderDetail.get().getId());
		}				
	}

	/*****************************************************/
	
	public void deleteByOrderId(long id) {
		List<OrderDetail> orderDetails = orderDetailRepository.findByOrderId(id);
		for (OrderDetail orderDetail : orderDetails) {
			this.delete(orderDetail.getId());
		}		
	}

	public void deleteByProductId(long id) {
		List<OrderDetail> orderDetails = orderDetailRepository.findByProductId(id);
		for (OrderDetail orderDetail : orderDetails) {
			this.delete(orderDetail.getId());
		}		
	}

	
	
}
