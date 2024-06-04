package japdp.supermercado;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import japdp.supermercado.application.persistence.model.Category;
import japdp.supermercado.application.persistence.model.Customer;
import japdp.supermercado.application.persistence.model.Order;
import japdp.supermercado.application.persistence.model.OrderDetail;
import japdp.supermercado.application.persistence.model.Product;
import japdp.supermercado.application.persistence.repository.CategoryRepositoryI;
import japdp.supermercado.application.persistence.repository.CustomerRepositoryI;
import japdp.supermercado.application.persistence.repository.OrderDetailRepositoryI;
import japdp.supermercado.application.persistence.repository.OrderRepositoryI;
import japdp.supermercado.application.persistence.repository.ProductRepositoryI;
import japdp.supermercado.security.persistence.model.User;
import japdp.supermercado.security.persistence.repository.UserRepository;

@Component
public class DatabaseLoader implements CommandLineRunner {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(DatabaseLoader.class);
	
	// Security
	
	@Autowired
	UserRepository userRepository;
	
	// Application
	
	@Autowired
	CustomerRepositoryI customerRepository;
	@Autowired
	ProductRepositoryI productRepository;
	@Autowired
	OrderRepositoryI orderRepository;
	@Autowired
	OrderDetailRepositoryI orderDetailRepository;
	@Autowired
	CategoryRepositoryI categoryRepository;
	
	@Override
	public void run(String... args) throws Exception {
		
		// Security
		
		User user = new User("jose", "jose1@example.es", "321", "Jose descrito", "2024-02-02");
		userRepository.save(user);
				
		// Application
		
		
		LOGGER.debug("Loading the data");
		Customer cus1 = new Customer("Paco", "Pepe", "Sevilla");
		customerRepository.save(cus1);
		Customer cus2 = new Customer("Felipe", "Juan", "Málaga");
		customerRepository.save(cus2);
		Customer cus3 = new Customer("Pepe", "Pepe", "España");
		customerRepository.save(cus3);
		
		Category cat1 = new Category("Agua y refrescos", "Bebidas para hidratarse o para ofrecer un sabor refrescante.");
		categoryRepository.save(cat1);
		Category cat2 = new Category("Aperitivos", "Aperitivos para comer en cualquier momento");
		categoryRepository.save(cat2);
		Category cat3 = new Category("Cacao, café e infusiones", "Bebidas para tomar en el desayuno o merienda");
		categoryRepository.save(cat3);
		Category cat4 = new Category("Carne", "Para almuerzos y cenas");
		categoryRepository.save(cat4);
		Category cat5 = new Category("Galletas", "Aperitivos para comer en cualquier momento");
		categoryRepository.save(cat5);
		Category cat6 = new Category("Charcutería y quesos", "Bebidas para tomar en el desayuno o merienda");
		categoryRepository.save(cat6);
		
		Product prod1 = new Product("Lote agua mineral mediana", 2.40f, "6 botellas x 1 L", cat1, 50);
		productRepository.save(prod1);
		Product prod2 = new Product("Lote agua mineral grande", 1.50f, "6 botellas x 1,5 L", cat1, 50);
		productRepository.save(prod2);
		Product prod3 = new Product("Botella agua mineral mediana", 0.40f, "Botella 1 L", cat1, 200);
		productRepository.save(prod3);
		Product prod4 = new Product("Botella agua mineral grande", 0.25f, "Bottela 1,5 L", cat1, 200);
		productRepository.save(prod4);
		Product prod5 = new Product("Refresco Coca-Cola grande", 1.99f, "Bottela 2 L", cat1, 200);
		productRepository.save(prod5);
		Product prod6 = new Product("Refresco Coca-Cola mediano", 1.49f, "Bottela 1,25 L", cat1, 200);
		productRepository.save(prod6);
		Product prod7 = new Product("Refresco Coca-Cola pequeño", 1.45f, "Bottela 1.5 L", cat1, 200);
		productRepository.save(prod7);
		Product prod8 = new Product("Refresco Coca-Cola lata", 0.89f, "Lata 330 mL", cat1, 400);
		productRepository.save(prod8);
		Product prod9 = new Product("Lote Coca-Cola lata", 0.89f, "12 latas x 330 mL", cat1, 200);
		productRepository.save(prod9);
		Product prod10 = new Product("Patatas fritas Lay's grande", 1.99f, "Bolsa 160 g", cat2, 150);
		productRepository.save(prod10);
		Product prod11 = new Product("Patatas fritas Lays sabor jamón grande", 1.99f, "Bolsa 160 g", cat2, 200);
		productRepository.save(prod11);
		Product prod12 = new Product("Pistachos", 2.35f, "Paquete 130 g", cat2, 300);
		productRepository.save(prod12);
		Product prod13 = new Product("Almendras sin piel al punto de sal", 3.10f, "Paquete 200 g", cat2, 200);
		productRepository.save(prod13);
		Product prod14 = new Product("Almendras con piel al punto de sal", 2.70f, "Paquete 200 g", cat2, 200);
		productRepository.save(prod14);
		Product prod15 = new Product("Avellanas", 3.10f, "Paquete 200 g", cat2, 200);
		productRepository.save(prod15);
		Product prod16 = new Product("Bote ColaCao mediano", 3.70f, "Bote 383 g", cat3, 150);
		productRepository.save(prod16);
		Product prod17 = new Product("Bote ColaCao grande", 5.10f, "Bote 760 g", cat3, 130);
		productRepository.save(prod17);
		Product prod18 = new Product("Lote café en cápsula Dolce Gusto", 4.89f, "Caja 16 cápsulas", cat3, 160);
		productRepository.save(prod18);
		Product prod19 = new Product("Té verde", 1f, "Caja 20 bolsitas", cat3, 100);
		productRepository.save(prod19);
		Product prod20 = new Product("Té negro", 1.10f, "Caja 20 bolsitas", cat3, 120);
		productRepository.save(prod20);
		Product prod21 = new Product("Té Chai", 1.30f, "Caja 20 bolsitas", cat3, 80);
		productRepository.save(prod21);
		Product prod22 = new Product("Filete de Res", 15.00f, "Paquete 500 g", cat4, 40);
		productRepository.save(prod22);
		Product prod23 = new Product("Pechuga de Pollo", 7.50f, "Paquete 1 kilo", cat4, 40);
		productRepository.save(prod23);
		Product prod24 = new Product("Costillas de Cerdo", 12.00f, "Paquete 1 kilo", cat4, 40);
		productRepository.save(prod24);
		Product prod25 = new Product("Galletas de Chocolate", 3.50f, "Paquete 200 g", cat5, 100);
		productRepository.save(prod25);
		Product prod26 = new Product("Galletas de Avena", 2.80f, "Paquete 150 g", cat5, 100);
		productRepository.save(prod26);
		Product prod27 = new Product("Jamón Serrano", 8.50f, "Paquete 250 g", cat6, 80);
		productRepository.save(prod27);
		Product prod28 = new Product("Salami", 5.75f, "Paquete 300 g", cat6, 60);
		productRepository.save(prod28);
		Product prod29 = new Product("Queso Cheddar", 6.20f, "Paquete 200 g", cat6, 90);
		productRepository.save(prod29);
		Product prod30 = new Product("Queso Brie", 7.30f, "Paquete 150 g", cat6, 70);
		productRepository.save(prod30);
		
		Order order1 = new Order(cus1, "2024-12-23", "Sevilla");
		orderRepository.save(order1);
		Order order2 = new Order(cus1, "2024-01-11", "Sevilla");
		orderRepository.save(order2);
		Order order3 = new Order(cus2, "2024-01-07", "Cádiz");
		orderRepository.save(order3);
		Order order4 = new Order(cus2, "2024-02-11", "Cádiz");
		orderRepository.save(order4);
		Order order5 = new Order(cus3, "2024-05-15", "Madrid");
		orderRepository.save(order5);
		
		OrderDetail ordDet1 = new OrderDetail(order1, prod1, 4);
		orderDetailRepository.save(ordDet1);
		OrderDetail ordDet2 = new OrderDetail(order1, prod3, 6);
		orderDetailRepository.save(ordDet2);
		OrderDetail ordDet3 = new OrderDetail(order1, prod10, 4);
		orderDetailRepository.save(ordDet3);
		OrderDetail ordDet4 = new OrderDetail(order2, prod11, 6);
		orderDetailRepository.save(ordDet4);
		OrderDetail ordDet5 = new OrderDetail(order2, prod20, 6);
		orderDetailRepository.save(ordDet5);
		OrderDetail ordDet6 = new OrderDetail(order2, prod23, 6);
		orderDetailRepository.save(ordDet6);
		OrderDetail ordDet7 = new OrderDetail(order3, prod30, 6);
		orderDetailRepository.save(ordDet7);
				
	}
	
}
