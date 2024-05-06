package com.att.tdp.bisbis10.controllers.dtos;

import com.att.tdp.bisbis10.entities.OrderItem;

import java.util.List;

public record OrderDTO(Long restaurantId, List<OrderItemDTO> orderItems) {
}
