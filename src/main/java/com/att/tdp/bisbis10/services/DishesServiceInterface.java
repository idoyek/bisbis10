package com.att.tdp.bisbis10.services;

import com.att.tdp.bisbis10.entities.Dish;

import java.util.List;

public interface DishesServiceInterface {
    void createDish(String id, Dish dish);
    void deleteDish(String id, String dishId);
    List<Dish> getDishesByRestaurant(String id);
}
