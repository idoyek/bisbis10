package com.att.tdp.bisbis10.services;

import com.att.tdp.bisbis10.controllers.dtos.DtoUtils;
import com.att.tdp.bisbis10.controllers.dtos.RestaurantDTO;
import com.att.tdp.bisbis10.entities.Restaurant;
import com.att.tdp.bisbis10.repositories.RestaurantsRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class RestaurantsService implements RestaurantsServiceInterface {
    private final RestaurantsRepository restaurantsRepository;

    public RestaurantsService(RestaurantsRepository restaurantsRepository) {
        this.restaurantsRepository = restaurantsRepository;
    }

    public List<Restaurant> getAllRestaurants() {
        return restaurantsRepository.findAll();
    }

    public List<Restaurant> getRestaurantsByCuisine(String cuisine) {
        return restaurantsRepository.findRestaurantsByCuisine(cuisine);
    }

    public Restaurant getRestaurantById(String id) {
        return restaurantsRepository.findById(id).get();
    }

    public void createRestaurant(RestaurantDTO restaurantDTO) {
        Restaurant restaurant =  DtoUtils.createRestaurantFromDTO(restaurantDTO);
        restaurantsRepository.save(restaurant);
    }

    public void updateRestaurant(String id, Map<String, Object> updatedInfo) {
        Optional<Restaurant> optionalRestaurant = restaurantsRepository.findById(id);
        if (optionalRestaurant.isPresent()) {
            Restaurant restaurant = optionalRestaurant.get();
            UpdateRestaurant.setEntity(restaurant, updatedInfo);
            restaurantsRepository.save(restaurant);
        }
    }

    public void deleteRestaurant(String id) {
        Restaurant restaurant = restaurantsRepository.findById(id).get();
        restaurantsRepository.delete(restaurant);
    }
}
