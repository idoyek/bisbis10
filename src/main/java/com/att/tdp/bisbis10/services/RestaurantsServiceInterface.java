package com.att.tdp.bisbis10.services;

import com.att.tdp.bisbis10.controllers.dtos.RestaurantDTO;
import com.att.tdp.bisbis10.entities.Restaurant;

import java.util.List;
import java.util.Map;

public interface RestaurantsServiceInterface {
    List<Restaurant> getAllRestaurants();
    List<Restaurant> getRestaurantsByCuisine(String cuisine);
    Restaurant getRestaurantById(String id);
    void createRestaurant(RestaurantDTO restaurantDTO);
    void updateRestaurant(String id, Map<String, Object> updatedInfo);
    void deleteRestaurant(String id);
}
