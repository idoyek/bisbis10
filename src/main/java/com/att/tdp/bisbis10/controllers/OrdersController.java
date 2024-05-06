package com.att.tdp.bisbis10.controllers;

import com.att.tdp.bisbis10.controllers.dtos.OrderDTO;
import com.att.tdp.bisbis10.services.OrdersService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/order")
public class OrdersController {
    private final OrdersService ordersService;

    public OrdersController(OrdersService ordersService) {
        this.ordersService = ordersService;
    }

    @PostMapping()
    public ResponseEntity<String> addOrder(@RequestBody OrderDTO orderDTO){
        String orderId = ordersService.addOrder(orderDTO);
        return ResponseEntity.ok(orderId);
    }

}
