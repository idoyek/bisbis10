package com.att.tdp.bisbis10.services.orders;

import com.att.tdp.bisbis10.dtos.OrderDTO;

public interface OrdersServiceInterface {
    String addOrder(OrderDTO orderDTO);
}
