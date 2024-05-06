package com.att.tdp.bisbis10.services.utils;

import com.att.tdp.bisbis10.dtos.dishes.DishDTO;
import com.att.tdp.bisbis10.dtos.restaurants.RestaurantDTO;
import com.att.tdp.bisbis10.entities.Dish;
import com.att.tdp.bisbis10.entities.Restaurant;
import jakarta.persistence.EntityNotFoundException;

import java.util.ArrayList;
import java.util.Optional;

public class ServicesUtils {

    public static Double calculateAverageRating(Double averageRating, Integer ratingsListSize, Double newRating) {
        if (ratingsListSize == 0) {
            return newRating;
        } else {
            return (averageRating * ratingsListSize + newRating) / (ratingsListSize + 1);
        }
    }

    public static void updateRestaurant(Restaurant restaurant, RestaurantDTO restaurantDTO){
        Optional.ofNullable(restaurantDTO.name())
                .ifPresent(restaurant::setName);
        Optional.ofNullable(restaurantDTO.isKosher())
                .ifPresent(restaurant::setIsKosher);
        Optional.ofNullable(restaurantDTO.averageRating())
                .ifPresent(restaurant::setAverageRating);
        Optional.ofNullable(restaurantDTO.cuisines())
                .ifPresent(cuisines -> restaurant.setCuisines(new ArrayList<>(cuisines)));
        Optional.ofNullable(restaurantDTO.dishes())
                .ifPresent(dishes -> restaurant.setDishes(new ArrayList<>(dishes)));
    }

    public static void updateDish(Dish dish, DishDTO dishDTO){
        Optional.ofNullable(dishDTO.name())
                .ifPresent(dish::setName);
        Optional.ofNullable(dishDTO.description())
                .ifPresent(dish::setDescription);
        Optional.ofNullable(dishDTO.price())
                .ifPresent(dish::setPrice);
    }

    public static Runnable entityNotFoundException(String id) {
        return () -> { throw new EntityNotFoundException("Restaurant with id " + id + " not found"); };
    }
}
