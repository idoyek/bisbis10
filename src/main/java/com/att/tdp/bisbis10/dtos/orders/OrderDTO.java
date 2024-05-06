package com.att.tdp.bisbis10.dtos.orders;

import java.util.List;

public record OrderDTO(Long restaurantId, List<OrderItemDTO> orderItems) {
}
