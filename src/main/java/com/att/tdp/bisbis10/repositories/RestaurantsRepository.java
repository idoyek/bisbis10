package com.att.tdp.bisbis10.repositories;

import com.att.tdp.bisbis10.entities.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RestaurantsRepository extends JpaRepository<Restaurant, String> {
}
