package com.att.tdp.bisbis10.services;

import com.att.tdp.bisbis10.entities.Dish;
import com.att.tdp.bisbis10.entities.Restaurant;
import com.att.tdp.bisbis10.repositories.RestaurantsRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DishesService implements DishesServiceInterface{
    private final RestaurantsRepository restaurantsRepository;

    public DishesService(RestaurantsRepository restaurantsRepository) {
        this.restaurantsRepository = restaurantsRepository;
    }

    public void createDish(String id, Dish dish) {
        Optional<Restaurant> optionalRestaurant = restaurantsRepository.findById(id);
        if (optionalRestaurant.isPresent()) {
            Restaurant restaurant = optionalRestaurant.get();
            restaurant.getDishes().add(dish);
            restaurantsRepository.save(restaurant);
        }
    }

    public void deleteDish(String id, String dishId) {
        Optional<Restaurant> optionalRestaurant = restaurantsRepository.findById(id);
        if (optionalRestaurant.isPresent()) {
            Restaurant restaurant = optionalRestaurant.get();
            List<Dish> dishesList = restaurant.getDishes();
            Dish dishToRemove = dishesList.stream().filter(dish -> dish.getId().toString().equals(dishId)).findAny().get();
            dishesList.remove(dishToRemove);
            restaurantsRepository.save(restaurant);
        }
    }

    public List<Dish> getDishesByRestaurant(String id) {
        List<Dish> dishesList = null;
        Optional<Restaurant> optionalRestaurant = restaurantsRepository.findById(id);
        if (optionalRestaurant.isPresent()) {
            Restaurant restaurant = optionalRestaurant.get();
            dishesList = restaurant.getDishes();
        }
        return dishesList;
    }
}
