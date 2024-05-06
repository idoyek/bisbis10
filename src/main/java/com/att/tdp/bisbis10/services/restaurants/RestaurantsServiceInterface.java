package com.att.tdp.bisbis10.services.restaurants;

import com.att.tdp.bisbis10.dtos.restaurants.RestaurantDTO;
import com.att.tdp.bisbis10.dtos.restaurants.RestaurantResponseDTO;

import java.util.List;

public interface RestaurantsServiceInterface {
    List<RestaurantResponseDTO> getAllRestaurants();
    List<RestaurantResponseDTO> getRestaurantsByCuisine(String cuisine);
    RestaurantResponseDTO getRestaurantById(String id);
    void createRestaurant(RestaurantDTO restaurantDTO);
    void updateRestaurant(String id, RestaurantDTO restaurantDTO);
    void deleteRestaurant(String id);
}
