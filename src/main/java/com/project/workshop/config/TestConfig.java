package com.project.workshop.config;

import com.project.workshop.entities.Category;
import com.project.workshop.entities.Order;
import com.project.workshop.entities.User;
import com.project.workshop.entities.enums.OrderStatus;
import com.project.workshop.repositories.CategoryRepository;
import com.project.workshop.repositories.OrderRepository;
import com.project.workshop.repositories.UserRepository;
import org.hibernate.annotations.Array;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Arrays;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public void run(String... args) throws Exception {
        User u1 = new User(null, "Maria Brown", "maria@gmail.com", "988888", "123");
        User u2 = new User(null, "Alex Green", "alex@gmail.com", "977777", "456");

        userRepository.saveAll(Arrays.asList(u1, u2));

        Order o1 = new Order(null, Instant.now(), OrderStatus.WAITING_PAYMENT, u1);
        Order o2 = new Order(null, Instant.now(), OrderStatus.PAID, u2);

        orderRepository.saveAll(Arrays.asList(o1, o2));

        Category c1 = new Category(null, "Eletronics");
        Category c2 = new Category(null, "Books");
        Category c3 = new Category(null, "Computers");

        categoryRepository.saveAll(Arrays.asList(c1, c2, c3));

    }
}
