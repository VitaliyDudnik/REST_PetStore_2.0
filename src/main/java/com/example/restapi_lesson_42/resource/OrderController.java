package com.example.restapi_lesson_42.resource;

import com.example.restapi_lesson_42.entity.Order;
import com.example.restapi_lesson_42.service.OrderService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@RestController
@RequestMapping("/store/order")
public class OrderController {
    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping("/save")
    public ResponseEntity<Order> save(@Valid @RequestBody Order order) {
        Order save = orderService.save(order);
        return new ResponseEntity<>(save, HttpStatus.OK);
    }

    @GetMapping("/findById")
    public ResponseEntity<Order> findById(long id) {
        if (id >= 1 && id <= 10) {
            Optional<Order> order = orderService.findById(id);
            if (order.isPresent()) {
                return new ResponseEntity<>(order.get(), HttpStatus.OK);
            }
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<Order> delete(long id) {
        if (id >= 0) {
            orderService.delete(id);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
