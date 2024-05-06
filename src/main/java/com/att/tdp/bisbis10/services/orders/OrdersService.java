package com.att.tdp.bisbis10.services.orders;

import com.att.tdp.bisbis10.dtos.utils.DtoUtils;
import com.att.tdp.bisbis10.dtos.orders.OrderDTO;
import com.att.tdp.bisbis10.dtos.orders.OrderIdResponseDTO;
import com.att.tdp.bisbis10.entities.Order;
import com.att.tdp.bisbis10.entities.Restaurant;
import com.att.tdp.bisbis10.repositories.RestaurantsRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class OrdersService implements OrdersServiceInterface {

    private final RestaurantsRepository restaurantsRepository;

    public OrdersService(RestaurantsRepository restaurantsRepository) {
        this.restaurantsRepository = restaurantsRepository;
    }

    public OrderIdResponseDTO addOrder(OrderDTO orderDTO) {
        OrderIdResponseDTO orderId = null;
        String restaurantId = orderDTO.restaurantId().toString();
        Order order = DtoUtils.createOrderFromDTO(orderDTO);
        Optional<Restaurant> optionalRestaurant = restaurantsRepository.findById(restaurantId);
        if (optionalRestaurant.isPresent()){
            Restaurant restaurant = optionalRestaurant.get();
            restaurant.getOrders().add(order);
            orderId = new OrderIdResponseDTO(order.getId());
            restaurantsRepository.save(restaurant);
        }

        return orderId;
    }
}
