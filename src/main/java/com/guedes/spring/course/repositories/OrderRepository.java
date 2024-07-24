package com.guedes.spring.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.guedes.spring.course.entities.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {

}
