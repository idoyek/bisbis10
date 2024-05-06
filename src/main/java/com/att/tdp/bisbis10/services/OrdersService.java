package com.att.tdp.bisbis10.services;

import com.att.tdp.bisbis10.controllers.dtos.DtoUtils;
import com.att.tdp.bisbis10.controllers.dtos.OrderDTO;
import com.att.tdp.bisbis10.entities.Order;
import com.att.tdp.bisbis10.entities.Restaurant;
import com.att.tdp.bisbis10.repositories.RestaurantsRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class OrdersService implements OrdersServiceInterface {

    private final RestaurantsRepository restaurantsRepository;

    public OrdersService(RestaurantsRepository restaurantsRepository) {
        this.restaurantsRepository = restaurantsRepository;
    }

    public String addOrder(OrderDTO orderDTO) {
        String orderId = null;
        Order order = DtoUtils.createOrderFromDTO(orderDTO);
        Optional<Restaurant> optionalRestaurant = restaurantsRepository.findById(orderDTO.restaurantId().toString());
        if (optionalRestaurant.isPresent()){
            Restaurant restaurant = optionalRestaurant.get();
            restaurant.getOrders().add(order);
            orderId = order.getId();
            restaurantsRepository.save(restaurant);
        }

        return orderId;
    }
}
