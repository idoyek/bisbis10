package com.att.tdp.bisbis10.controllers;

import com.att.tdp.bisbis10.dtos.restaurants.RestaurantDTO;
import com.att.tdp.bisbis10.dtos.restaurants.RestaurantResponseDTO;
import com.att.tdp.bisbis10.services.restaurants.RestaurantsService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/restaurants")
public class RestaurantsController {

    private final RestaurantsService restaurantsService;

    public RestaurantsController(RestaurantsService restaurantsService) {
        this.restaurantsService = restaurantsService;
    }

    @GetMapping()
    public ResponseEntity<List<RestaurantResponseDTO>> getAllRestaurants() {
        List<RestaurantResponseDTO> restaurants = restaurantsService.getAllRestaurants();
        return ResponseEntity.ok(restaurants);
    }

    @GetMapping(params = "cuisine")
    public ResponseEntity<List<RestaurantResponseDTO>> getRestaurantsByCuisine(@RequestParam String cuisine) {
        List<RestaurantResponseDTO> restaurants = restaurantsService.getRestaurantsByCuisine(cuisine);
        return ResponseEntity.ok(restaurants);
    }

    @GetMapping("/{id}")
    public ResponseEntity<RestaurantResponseDTO> getRestaurantsById(@PathVariable String id) {
        RestaurantResponseDTO restaurant = restaurantsService.getRestaurantById(id);
        return ResponseEntity.ok(restaurant);
    }

    @PostMapping()
    public ResponseEntity<Void> createRestaurant(@RequestBody RestaurantDTO restaurantDTO) {
        restaurantsService.createRestaurant(restaurantDTO);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping()
    public ResponseEntity<Void> updateRestaurant(@RequestParam String id, @RequestBody RestaurantDTO restaurantDTO){
        restaurantsService.updateRestaurant(id, restaurantDTO);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRestaurant(@PathVariable String id){
        restaurantsService.deleteRestaurant(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
