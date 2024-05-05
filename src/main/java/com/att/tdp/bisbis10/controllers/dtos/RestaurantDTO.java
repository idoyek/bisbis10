package com.att.tdp.bisbis10.controllers.dtos;

import com.att.tdp.bisbis10.entities.Dish;

import java.util.List;

public record RestaurantDTO(Long id, String name, Double averageRating,
                            Boolean isKosher, List<String> cuisines,
                            List<Dish> dishes) {
}
