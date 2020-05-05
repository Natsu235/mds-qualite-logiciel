package com.tactfactory.monprojetsb.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tactfactory.monprojetsb.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
