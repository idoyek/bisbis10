package com.att.tdp.bisbis10.controllers;

import com.att.tdp.bisbis10.dtos.orders.OrderDTO;
import com.att.tdp.bisbis10.dtos.orders.OrderIdResponseDTO;
import com.att.tdp.bisbis10.services.orders.OrdersService;
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
    public ResponseEntity<OrderIdResponseDTO> addOrder(@RequestBody OrderDTO orderDTO){
        OrderIdResponseDTO orderIdResponseDTO = ordersService.addOrder(orderDTO);
        return ResponseEntity.ok(orderIdResponseDTO);
    }

}
