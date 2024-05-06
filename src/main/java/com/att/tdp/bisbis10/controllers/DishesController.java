package com.att.tdp.bisbis10.controllers;

import com.att.tdp.bisbis10.dtos.DishDTO;
import com.att.tdp.bisbis10.entities.Dish;
import com.att.tdp.bisbis10.services.dishes.DishesService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/restaurants/{id}/dishes")
public class DishesController {
    private final DishesService dishesService;

    public DishesController(DishesService dishesService) {
        this.dishesService = dishesService;
    }

    @PostMapping()
    public ResponseEntity<Void> createDish(@PathVariable String id, @RequestBody DishDTO dishDTO){
        dishesService.createDish(id, dishDTO);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping(path = "/{dishId}")
    public ResponseEntity<Void> updateDish(@PathVariable String id, @PathVariable String dishId, @RequestBody DishDTO dishDTO){
        dishesService.updateDish(id, dishId, dishDTO);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @DeleteMapping(path = "/{dishId}")
    public ResponseEntity<Void> deleteDish(@PathVariable String id, @PathVariable String dishId){
        dishesService.deleteDish(id, dishId);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @GetMapping()
    public ResponseEntity<List<Dish>> getDishesByRestaurant(@PathVariable String id){
        List<Dish> dishesList = dishesService.getDishesByRestaurant(id);
        return ResponseEntity.ok(dishesList);
    }
}
