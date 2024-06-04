package japdp.supermercado.application.dto.request;

import japdp.supermercado.application.persistence.model.OrderStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class OrderRequest {
	private String date;
	private String shipAddress;
	private long customerId;
	private OrderStatus status;
}