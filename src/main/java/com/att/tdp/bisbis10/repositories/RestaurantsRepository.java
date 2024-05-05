package com.att.tdp.bisbis10.repositories;

import com.att.tdp.bisbis10.entities.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RestaurantsRepository extends JpaRepository<Restaurant, String> {
    @Query("SELECT r FROM Restaurant r WHERE :cuisine IN elements(r.cuisines)")
    List<Restaurant> findRestaurantsByCuisine(String cuisine);
}
