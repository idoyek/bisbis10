package com.att.tdp.bisbis10.services;

import com.att.tdp.bisbis10.controllers.dtos.DtoUtils;
import com.att.tdp.bisbis10.controllers.dtos.RatingDTO;
import com.att.tdp.bisbis10.entities.Rating;
import com.att.tdp.bisbis10.entities.Restaurant;
import com.att.tdp.bisbis10.repositories.RestaurantsRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RatingsService implements RatingsServiceInterface{

    private final RestaurantsRepository restaurantsRepository;

    public RatingsService(RestaurantsRepository restaurantsRepository) {
        this.restaurantsRepository = restaurantsRepository;
    }

    public void addRestaurantRating(RatingDTO ratingDTO) {
        Rating rating = DtoUtils.createRatingFromDTO(ratingDTO);
        Optional<Restaurant> optionalRestaurant = restaurantsRepository.findById(ratingDTO.restaurantId().toString());
        if (optionalRestaurant.isPresent()){
            Restaurant restaurant = optionalRestaurant.get();
            Double newRatingAverage = ServicesUtils.calculateAverageRating(restaurant.getAverage_rating(), restaurant.getRatings().size(), ratingDTO.rating());
            restaurant.getRatings().add(rating);
            restaurant.setAverage_rating(newRatingAverage);
            restaurantsRepository.save(restaurant);
        }
    }
}
