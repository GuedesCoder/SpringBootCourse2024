package com.guedes.spring.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.guedes.spring.course.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
