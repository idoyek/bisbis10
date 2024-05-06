package com.att.tdp.bisbis10.services.restaurants;

import com.att.tdp.bisbis10.dtos.RestaurantDTO;
import com.att.tdp.bisbis10.entities.Restaurant;

import java.util.List;

public interface RestaurantsServiceInterface {
    List<Restaurant> getAllRestaurants();
    List<Restaurant> getRestaurantsByCuisine(String cuisine);
    Restaurant getRestaurantById(String id);
    void createRestaurant(RestaurantDTO restaurantDTO);
    void updateRestaurant(String id, RestaurantDTO restaurantDTO);
    void deleteRestaurant(String id);
}
