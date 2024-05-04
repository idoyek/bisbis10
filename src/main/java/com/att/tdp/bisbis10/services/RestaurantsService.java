package com.att.tdp.bisbis10.services;

import com.att.tdp.bisbis10.entities.Restaurant;
import com.att.tdp.bisbis10.repositories.RestaurantsRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RestaurantsService implements RestaurantsServiceInterface {
    private final RestaurantsRepository restaurantsRepository;

    public RestaurantsService(RestaurantsRepository restaurantsRepository) {
        this.restaurantsRepository = restaurantsRepository;
    }

    public List<Restaurant> getAllRestaurants() {
        return restaurantsRepository.findAll();
    }
}
