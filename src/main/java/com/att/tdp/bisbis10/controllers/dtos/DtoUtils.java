package com.att.tdp.bisbis10.controllers.dtos;

import com.att.tdp.bisbis10.entities.Order;
import com.att.tdp.bisbis10.entities.OrderItem;
import com.att.tdp.bisbis10.entities.Rating;
import com.att.tdp.bisbis10.entities.Restaurant;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class DtoUtils {
    public static Restaurant createRestaurantFromDTO(RestaurantDTO restaurantDTO){
        Restaurant restaurant = new Restaurant();

        restaurant.setName(restaurantDTO.name());
        restaurant.setIs_kosher(restaurantDTO.isKosher());
        restaurant.setAverage_rating(restaurantDTO.averageRating());
        restaurant.setCuisines(restaurantDTO.cuisines());
        restaurant.setDishes(restaurantDTO.dishes());

        return restaurant;
    }

    public static Rating createRatingFromDTO(RatingDTO ratingDTO){
        Rating rating = new Rating();

        rating.setRating(ratingDTO.rating());

        return rating;
    }

    public static Order createOrderFromDTO(OrderDTO orderDTO) {
        Order order = new Order();

        order.setId(UUID.randomUUID().toString());
        List<OrderItem> orderItems = createOrderItemsFromDTO(orderDTO.orderItems());

        order.setOrderItems(orderItems);

        return order;
    }

    private static List<OrderItem> createOrderItemsFromDTO(List<OrderItemDTO> orderItemsDTO) {
        List<OrderItem> orderItemsList = new ArrayList<>();

        for (OrderItemDTO orderItemFromDTO: orderItemsDTO){
            OrderItem orderItem = new OrderItem();
            orderItem.setDish_id(orderItemFromDTO.dishId().longValue());
            orderItem.setAmount(orderItemFromDTO.amount());
            orderItemsList.add(orderItem);
        }

        return orderItemsList;
    }
}
