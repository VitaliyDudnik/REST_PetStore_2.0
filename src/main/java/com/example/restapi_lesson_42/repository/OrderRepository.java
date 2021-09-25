package com.example.restapi_lesson_42.repository;

import com.example.restapi_lesson_42.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {

}
