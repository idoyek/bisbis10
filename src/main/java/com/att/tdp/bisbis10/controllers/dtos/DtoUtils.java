package com.att.tdp.bisbis10.controllers.dtos;

import com.att.tdp.bisbis10.entities.Restaurant;

public class DtoUtils {
    public static Restaurant createRestaurantFromDTO(RestaurantDTO restaurantDTO){
        Restaurant restaurant = new Restaurant();
        restaurant.setName(restaurantDTO.name());
        restaurant.setIs_kosher(restaurantDTO.isKosher());
        restaurant.setAverage_rating(restaurantDTO.averageRating());
        restaurant.setCuisines(restaurantDTO.cuisines());
        restaurant.setDishes(restaurantDTO.dishes());

        return restaurant;
    }
}
