package com.att.tdp.bisbis10.services.dishes;

import com.att.tdp.bisbis10.dtos.dishes.DishDTO;
import com.att.tdp.bisbis10.entities.Dish;

import java.util.List;

public interface DishesServiceInterface {
    void createDish(String id, DishDTO dishDTO);
    void updateDish(String restaurantId, String dishId, DishDTO dishDTO);
    void deleteDish(String id, String dishId);
    List<Dish> getDishesByRestaurant(String id);
}
