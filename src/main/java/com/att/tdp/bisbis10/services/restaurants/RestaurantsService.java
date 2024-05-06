package com.att.tdp.bisbis10.services.restaurants;

import com.att.tdp.bisbis10.dtos.utils.DtoUtils;
import com.att.tdp.bisbis10.dtos.restaurants.RestaurantDTO;
import com.att.tdp.bisbis10.dtos.restaurants.RestaurantResponseDTO;
import com.att.tdp.bisbis10.entities.Restaurant;
import com.att.tdp.bisbis10.repositories.RestaurantsRepository;
import com.att.tdp.bisbis10.services.utils.ServicesUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RestaurantsService implements RestaurantsServiceInterface {
    private final RestaurantsRepository restaurantsRepository;

    public RestaurantsService(RestaurantsRepository restaurantsRepository) {
        this.restaurantsRepository = restaurantsRepository;
    }

    public List<RestaurantResponseDTO> getAllRestaurants() {
        return restaurantsRepository.findAll().stream()
                .map(DtoUtils::createRestaurantResponseDTOFromRestaurant)
                .collect(Collectors.toList());
    }

    public List<RestaurantResponseDTO> getRestaurantsByCuisine(String cuisine) {
        return restaurantsRepository.findRestaurantsByCuisine(cuisine)
                .stream()
                .map(DtoUtils::createRestaurantResponseDTOFromRestaurant)
                .collect(Collectors.toList());
    }

    public RestaurantResponseDTO getRestaurantById(String id) {
        return restaurantsRepository.findById(id)
                .map(DtoUtils::createRestaurantResponseDTOFromRestaurant)
                .orElse(null);
    }

    public void createRestaurant(RestaurantDTO restaurantDTO) {
        Restaurant restaurant =  DtoUtils.createRestaurantFromDTO(restaurantDTO);
        restaurantsRepository.save(restaurant);
    }

    public void updateRestaurant(String id, RestaurantDTO restaurantDTO) {
        restaurantsRepository.findById(id)
                .ifPresentOrElse(restaurant -> {
                    ServicesUtils.updateRestaurant(restaurant, restaurantDTO);
                    restaurantsRepository.save(restaurant);
                    },
                        ServicesUtils.entityNotFoundException(id)
        );
    }

    public void deleteRestaurant(String id) {
        restaurantsRepository.findById(id)
                .ifPresentOrElse(
                        restaurantsRepository::delete,
                        ServicesUtils.entityNotFoundException(id)
                );
    }
}
