package com.att.tdp.bisbis10.services.orders;

import com.att.tdp.bisbis10.dtos.DtoUtils;
import com.att.tdp.bisbis10.dtos.OrderDTO;
import com.att.tdp.bisbis10.entities.Order;
import com.att.tdp.bisbis10.entities.Restaurant;
import com.att.tdp.bisbis10.repositories.RestaurantsRepository;
import com.att.tdp.bisbis10.services.utils.ServicesUtils;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class OrdersService implements OrdersServiceInterface {

    private final RestaurantsRepository restaurantsRepository;

    public OrdersService(RestaurantsRepository restaurantsRepository) {
        this.restaurantsRepository = restaurantsRepository;
    }

    public String addOrder(OrderDTO orderDTO) {
        String orderId = null;
        String restaurantId = orderDTO.restaurantId().toString();
        Order order = DtoUtils.createOrderFromDTO(orderDTO);
        Optional<Restaurant> optionalRestaurant = restaurantsRepository.findById(restaurantId);
        if (optionalRestaurant.isPresent()){
            Restaurant restaurant = optionalRestaurant.get();
            restaurant.getOrders().add(order);
            orderId = order.getId();
            restaurantsRepository.save(restaurant);
        }

        return orderId;
    }
}
