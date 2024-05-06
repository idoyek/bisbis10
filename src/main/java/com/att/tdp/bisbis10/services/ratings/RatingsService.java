package com.att.tdp.bisbis10.services.ratings;

import com.att.tdp.bisbis10.dtos.DtoUtils;
import com.att.tdp.bisbis10.dtos.RatingDTO;
import com.att.tdp.bisbis10.entities.Rating;
import com.att.tdp.bisbis10.repositories.RestaurantsRepository;
import com.att.tdp.bisbis10.services.utils.ServicesUtils;
import org.springframework.stereotype.Service;

@Service
public class RatingsService implements RatingsServiceInterface{

    private final RestaurantsRepository restaurantsRepository;

    public RatingsService(RestaurantsRepository restaurantsRepository) {
        this.restaurantsRepository = restaurantsRepository;
    }

    public void addRestaurantRating(RatingDTO ratingDTO) {
        Rating rating = DtoUtils.createRatingFromDTO(ratingDTO);
        String restaurantId = ratingDTO.restaurantId().toString();
        restaurantsRepository.findById(restaurantId)
                .ifPresentOrElse(restaurant -> {
                    Double newRatingAverage = ServicesUtils.calculateAverageRating(
                            restaurant.getAverageRating(),
                            restaurant.getRatings().size(),
                            ratingDTO.rating()
                    );
                    restaurant.getRatings().add(rating);
                    restaurant.setAverageRating(newRatingAverage);
                    restaurantsRepository.save(restaurant);
                },
                    ServicesUtils.entityNotFoundException(restaurantId));
    }
}
