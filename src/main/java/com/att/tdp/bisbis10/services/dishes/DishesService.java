package com.att.tdp.bisbis10.services.dishes;

import com.att.tdp.bisbis10.dtos.dishes.DishDTO;
import com.att.tdp.bisbis10.dtos.utils.DtoUtils;
import com.att.tdp.bisbis10.entities.Dish;
import com.att.tdp.bisbis10.entities.Restaurant;
import com.att.tdp.bisbis10.repositories.RestaurantsRepository;
import com.att.tdp.bisbis10.services.utils.ServicesUtils;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DishesService implements DishesServiceInterface{
    private final RestaurantsRepository restaurantsRepository;

    public DishesService(RestaurantsRepository restaurantsRepository) {
        this.restaurantsRepository = restaurantsRepository;
    }

    public void createDish(String restaurantId, DishDTO dishDTO) {
        Dish dish = DtoUtils.createDishFromDTO(dishDTO);
        restaurantsRepository.findById(restaurantId).ifPresentOrElse(restaurant -> {
            restaurant.getDishes().add(dish);
            restaurantsRepository.save(restaurant);
        },
                ServicesUtils.entityNotFoundException(restaurantId));
    }

    public void updateDish(String restaurantId, String dishId, DishDTO dishDTO) {
        restaurantsRepository
                .findById(restaurantId)
                .ifPresentOrElse(restaurant -> restaurant.getDishes()
                .stream()
                .filter(dish -> dish.getId().toString().equals(dishId))
                .findAny()
                .ifPresent(dish -> {
                    ServicesUtils.updateDish(dish, dishDTO);
                    restaurantsRepository.save(restaurant);
                }),
                        ServicesUtils.entityNotFoundException(restaurantId));
    }

    public void deleteDish(String restaurantId, String dishId) {
        restaurantsRepository.findById(restaurantId).ifPresentOrElse(restaurant -> {
            List<Dish> dishesList = restaurant.getDishes();
            dishesList
                    .stream()
                    .filter(dish -> dish.getId().toString().equals(dishId))
                    .findAny()
                    .ifPresent(dishToRemove -> {
                        dishesList.remove(dishToRemove);
                        restaurantsRepository.save(restaurant);
                    });
        },
                ServicesUtils.entityNotFoundException(restaurantId));
    }

    public List<Dish> getDishesByRestaurant(String id) {
        return restaurantsRepository.findById(id)
                .map(Restaurant::getDishes)
                .orElse(null);
    }
}
