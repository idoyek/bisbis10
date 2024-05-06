package com.att.tdp.bisbis10.dtos;

import com.att.tdp.bisbis10.entities.Dish;

import java.util.List;

public record RestaurantDTO(String name, Double averageRating,
                            Boolean isKosher, List<String> cuisines,
                            List<Dish> dishes) {
}
