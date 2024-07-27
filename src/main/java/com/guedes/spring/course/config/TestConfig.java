package com.guedes.spring.course.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.guedes.spring.course.entities.Category;
import com.guedes.spring.course.entities.Order;
import com.guedes.spring.course.entities.OrderItem;
import com.guedes.spring.course.entities.Product;
import com.guedes.spring.course.entities.User;
import com.guedes.spring.course.entities.enums.OrderStatus;
import com.guedes.spring.course.repositories.CategoryRepository;
import com.guedes.spring.course.repositories.OrderItemRepository;
import com.guedes.spring.course.repositories.OrderRepository;
import com.guedes.spring.course.repositories.ProductRepository;
import com.guedes.spring.course.repositories.UserRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private OrderRepository orderRepository;

	@Autowired
	private CategoryRepository categoryRepository;

	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private OrderItemRepository orderItemRepository;

	@Override
	public void run(String... args) throws Exception {
		User u1 = new User(null, "Leandro Guedes Costa", "leandro.costa30@fatec.sp.gov.br", "991033011", "StarLord");
		User u2 = new User(null, "Debora Ribeiro Santana", "dede_2santana@hotmail.com", "988464445", "DixieKong");
		User u3 = new User(null, "Juliana Cristina Vieira", "itsjuliana@hotmail.com", "997532551", "LolaBunny");

		Order o1 = new Order(null, Instant.parse("2019-06-20T19:53:07Z"), OrderStatus.PAID, u1);
		Order o2 = new Order(null, Instant.parse("2019-07-21T03:42:10Z"), OrderStatus.WAITING_PAYMENT, u2);
		Order o3 = new Order(null, Instant.parse("2019-07-22T15:21:22Z"), OrderStatus.WAITING_PAYMENT, u1);

		Category cat1 = new Category(null, "Eletronics");
		Category cat2 = new Category(null, "Tools");
		Category cat3 = new Category(null, "Health & Care");

		Product prod1 = new Product(null, "Playstation 5", "Console Playstation 5 com disco", 3829.99,
				"https://www.playstation.com/pt-br/ps5/");
		Product prod2 = new Product(null, "Tupia Milwaukee", "Tupia 18v Fuel 2838-20 Milwaukee", 6885.99,
				"https://www.milwaukeestore.com.br/ferramentas-eletricas/tupia-18v-fuel-2838-20-milwaukee?gad_source=1&utm_source=google&utm_campaign=20239894544&utm_medium=660791881128-149275046105&utm_content=milwaukee%7C%7Cnemu_zB0qG_KTaI");
		Product prod3 = new Product(null, "Whey Protein 80%", "Whey Protein Concentrado (1KG) - Growth Supplements",
				108.19, "https://www.gsuplementos.com.br/whey-protein-concentrado-1kg-growth-supplements-p985936");
		Product prod4 = new Product(null, "The Last of Us II", "Jogo PS5 - The Last of Us partII", 269.39,
				"https://www.amazon.com.br/Last-Us-Part-Remastered-PlayStation/dp/B0CP689L59");
		Product prod5 = new Product(null, "Nível Laser", "Nível Laser 8 Linhas 3d Verde Recarregável Auto Nivelamento",
				168.72,
				"https://produto.mercadolivre.com.br/MLB-3505275223-nivel-laser-8-linhas-3d-verde-recarregavel-auto-nivelamento");

		userRepository.saveAll(Arrays.asList(u1, u2, u3));
		orderRepository.saveAll(Arrays.asList(o1, o2, o3));
		categoryRepository.saveAll(Arrays.asList(cat1, cat2, cat3));
		productRepository.saveAll(Arrays.asList(prod1, prod2, prod3, prod4, prod5));

		prod1.getCategories().add(cat1);
		prod2.getCategories().add(cat2);
		prod3.getCategories().add(cat3);
		prod4.getCategories().add(cat1);
		prod5.getCategories().add(cat2);

		productRepository.saveAll(Arrays.asList(prod1, prod2, prod3, prod4, prod5));

		OrderItem orderItem1 = new OrderItem(o3, prod5, 2, prod5.getPrice());
		OrderItem orderItem2 = new OrderItem(o3, prod3, 3, prod3.getPrice());
		OrderItem orderItem3 = new OrderItem(o2, prod3, 5, prod3.getPrice());
		OrderItem orderItem4 = new OrderItem(o1, prod1, 1, prod1.getPrice());
		
		orderItemRepository.saveAll(Arrays.asList(orderItem1, orderItem2, orderItem3, orderItem4));
	}

}
