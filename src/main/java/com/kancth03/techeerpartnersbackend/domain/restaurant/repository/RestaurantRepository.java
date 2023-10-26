package com.kancth03.techeerpartnersbackend.domain.restaurant.repository;

import com.kancth03.techeerpartnersbackend.domain.restaurant.entity.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RestaurantRepository extends JpaRepository<Restaurant, Long> {

    Optional<Restaurant> findByName(String restaurantName);
}