package com.att.tdp.bisbis10.services;

import com.att.tdp.bisbis10.controllers.dtos.RatingDTO;

public interface RatingsServiceInterface {
    void addRestaurantRating(RatingDTO rating);
}
