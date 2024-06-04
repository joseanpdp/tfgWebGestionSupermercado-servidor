package japdp.supermercado.application.persistence.model;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "T_ORDERDETAIL")
@Entity

public class OrderDetail implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	// Bidireccional
	
	@NotNull(message = "OrderDetail order cannot be null")
	@ManyToOne
	private Order order;

	// Unidireccional
	@NotNull(message = "OrderDetail product cannot be null")
	@ManyToOne
	private Product product;
	
	@Min(1)
	private int quantity;

	public OrderDetail(Order order, Product product, int quantity) {
		this();
		this.order = order;
		this.product = product;
		this.quantity = quantity;
	}
}
