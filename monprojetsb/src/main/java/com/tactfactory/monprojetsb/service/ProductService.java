package com.tactfactory.monprojetsb.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tactfactory.monprojetsb.entity.Product;
import com.tactfactory.monprojetsb.repository.ProductRepository;

@Service
public class ProductService {

	@Autowired
    private ProductRepository productRepository;

    public Product save(Product item) {
        return this.productRepository.save(item);
    }

    public void delete(Product item) {
        this.productRepository.delete(item);
    }

    public void update(Product item) {
        this.productRepository.save(item);
    }

    public List<Product> findAll() {
        return this.productRepository.findAll();
    }

}
