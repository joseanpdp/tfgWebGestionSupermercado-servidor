package japdp.supermercado.application.persistence.model;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "T_ORDER")
@Entity
public class Order implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@NotNull(message = "Order date cannot be null")
	@NotEmpty(message = "Order date cannot be an empty string")
	@NotBlank(message = "Order date cannot be blank")
	private String date;
	
	@NotNull(message = "Order ship address cannot be null")
	@NotEmpty(message = "Order ship address cannot be an empty string")
	@NotBlank(message = "Order ship address cannot be blank")
	private String shipAddress;

	@Enumerated(EnumType.STRING)
	@Column(nullable = false)
	private OrderStatus status;
	
	// Unidireccional
	@NotNull(message = "Order customer cannot be null")
	@ManyToOne
	private Customer customer;
	
	// Bidireccional
	//@OneToMany(mappedBy="order")
	//@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
	//private List<OrderDetail> orderDetails;
	
	public Order(Customer customer, String date, String shipAddress) {
		this();
		this.customer = customer;
		this.date = date;
		this.shipAddress = shipAddress;
		this.status = OrderStatus.PENDING;
		//this.orderDetails = new ArrayList<>();
	}	
}
