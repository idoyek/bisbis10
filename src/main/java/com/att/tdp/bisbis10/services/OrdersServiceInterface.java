package com.att.tdp.bisbis10.services;

import com.att.tdp.bisbis10.controllers.dtos.OrderDTO;

public interface OrdersServiceInterface {
    String addOrder(OrderDTO orderDTO);
}
