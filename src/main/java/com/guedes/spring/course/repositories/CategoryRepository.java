package com.guedes.spring.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.guedes.spring.course.entities.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {

}
