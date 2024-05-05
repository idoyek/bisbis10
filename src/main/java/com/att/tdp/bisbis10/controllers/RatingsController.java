package com.att.tdp.bisbis10.controllers;

import com.att.tdp.bisbis10.controllers.dtos.RatingDTO;
import com.att.tdp.bisbis10.services.RatingsService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ratings")
public class RatingsController {
    private final RatingsService ratingsService;

    public RatingsController(RatingsService ratingsService) {
        this.ratingsService = ratingsService;
    }

    @PostMapping()
    public void addRestaurantRating(@RequestBody RatingDTO ratingDTO){
        ratingsService.addRestaurantRating(ratingDTO);
    }

}
