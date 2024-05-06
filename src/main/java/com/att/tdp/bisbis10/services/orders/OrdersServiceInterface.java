package com.att.tdp.bisbis10.services.orders;

import com.att.tdp.bisbis10.dtos.orders.OrderDTO;
import com.att.tdp.bisbis10.dtos.orders.OrderIdResponseDTO;

public interface OrdersServiceInterface {
    OrderIdResponseDTO addOrder(OrderDTO orderDTO);
}
