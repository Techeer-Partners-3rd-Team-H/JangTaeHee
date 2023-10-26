package com.kancth03.techeerpartnersbackend.domain.restaurant.validate;

import com.kancth03.techeerpartnersbackend.domain.restaurant.entity.Restaurant;
import com.kancth03.techeerpartnersbackend.domain.restaurant.repository.RestaurantRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@RequiredArgsConstructor
@Component
public class RestaurantValidate {

    private final RestaurantRepository restaurantRepository;

    public void duplicateValidate(String restaurantName) {
        Optional<Restaurant> findRestaurant = restaurantRepository.findByName(restaurantName);

        if (findRestaurant.isPresent()) {
            throw new IllegalArgumentException("레스토랑명 중복");
        }
    }

    public void restaurantValidate(Long restaurantId) {
        Optional<Restaurant> findRestaurant = restaurantRepository.findById(restaurantId);

        if (findRestaurant.isEmpty()) {
            throw new IllegalArgumentException("존재하지 않는 레스토랑");
        }
    }
}
