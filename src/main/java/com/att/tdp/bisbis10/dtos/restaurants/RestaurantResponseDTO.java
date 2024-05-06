package com.att.tdp.bisbis10.dtos.restaurants;

import com.att.tdp.bisbis10.entities.Dish;
import com.att.tdp.bisbis10.entities.Order;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
public record RestaurantResponseDTO(Long id, String name, Double averageRating,
                                    Boolean isKosher, List<String> cuisines,
                                    List<Dish> dishes, List<Order> orders) {
}
