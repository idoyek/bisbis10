package com.att.tdp.bisbis10.services.ratings;

import com.att.tdp.bisbis10.dtos.ratings.RatingDTO;

public interface RatingsServiceInterface {
    void addRestaurantRating(RatingDTO rating);
}
