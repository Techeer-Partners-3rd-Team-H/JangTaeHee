package com.kancth03.techeerpartnersbackend.domain.restaurant.repository;

import com.kancth03.techeerpartnersbackend.domain.restaurant.entity.Restaurant;
import com.kancth03.techeerpartnersbackend.domain.restaurant.entity.RestaurantCategory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface RestaurantRepository extends JpaRepository<Restaurant, Long> {

    Optional<Restaurant> findByName(String restaurantName);
    List<Restaurant> findAllByCategory(RestaurantCategory category);
}