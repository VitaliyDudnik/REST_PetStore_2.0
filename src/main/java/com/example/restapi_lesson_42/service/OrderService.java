package com.example.restapi_lesson_42.service;

import com.example.restapi_lesson_42.repository.OrderRepository;
import com.example.restapi_lesson_42.entity.Order;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class OrderService {
    private final OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public Order save(Order order) {
        return orderRepository.save(order);
    }

    public Optional<Order> findById(long id) {
        return orderRepository.findById(id);
    }

    public void delete(long id){
        orderRepository.deleteById(id);
    }

}
