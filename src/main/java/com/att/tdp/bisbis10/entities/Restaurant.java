package com.att.tdp.bisbis10.entities;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "restaurants")
public class Restaurant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private Double average_rating;
    private Boolean is_kosher;

    @ElementCollection
    private List<String> cuisines;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Dish> dishes;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Rating> ratings;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Order> orders;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getAverageRating() {
        return average_rating;
    }

    public void setAverageRating(Double average_rating) {
        this.average_rating = average_rating;
    }

    public Boolean getIsKosher() {
        return is_kosher;
    }

    public void setIsKosher(Boolean is_kosher) {
        this.is_kosher = is_kosher;
    }

    public List<String> getCuisines() {
        return cuisines;
    }

    public void setCuisines(List<String> cuisines) {
        this.cuisines = cuisines;
    }

    public List<Dish> getDishes() {
        return dishes;
    }

    public void setDishes(List<Dish> dishes) {
        this.dishes = dishes;
    }

    public List<Rating> getRatings() {
        return ratings;
    }

    public void setRatings(List<Rating> ratings) {
        this.ratings = ratings;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }
}
