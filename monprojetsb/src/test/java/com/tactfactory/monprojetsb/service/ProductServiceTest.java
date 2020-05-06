package com.tactfactory.monprojetsb.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.junit4.SpringRunner;

import com.tactfactory.monprojetsb.entity.Product;
import com.tactfactory.monprojetsb.repository.ProductRepository;
import com.tactfactory.monprojetsb.repository.UserRepository;

@RunWith(SpringRunner.class)
@AutoConfigureTestDatabase(replace = Replace.NONE)
@DataJpaTest
@EntityScan(basePackages="com.tactfactory.monprojetsb")
@ComponentScan(basePackages="com.tactfactory.monprojetsb")
public class ProductServiceTest {

    @Autowired
    private ProductService productService;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ProductRepository productRepository;

    // Initialise la base avant chaque test
    @Before
    public void clear() {
        this.productRepository.deleteAll();
        this.userRepository.deleteAll();
    }

    // Test l'incrémentation lors de l'ajout d'un produit
    @Test
    public void TestInsertOne() {
        Long before = productRepository.count();
        productService.save(new Product());
        Long after = productRepository.count();

        assertEquals(before + 1, after);
    }

    // Test la décrémentation lors de la suppression d'un produit
    @Test
    public void TestDeleteOne() {
        Product product = new Product();
        productService.save(product);
        Long before = productRepository.count();
        productService.delete(product);
        Long after = productRepository.count();

        assertEquals(before - 1, after);
    }

}
