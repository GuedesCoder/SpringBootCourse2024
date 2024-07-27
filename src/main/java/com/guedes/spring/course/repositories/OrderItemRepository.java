package com.guedes.spring.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.guedes.spring.course.entities.OrderItem;
import com.guedes.spring.course.entities.pk.OrderItemPK;

public interface OrderItemRepository extends JpaRepository<OrderItem, OrderItemPK> {

}
