package com.kancth03.techeerpartnersbackend.domain.restaurant.service;

import com.kancth03.techeerpartnersbackend.domain.restaurant.dto.AddRestaurantRequest;
import com.kancth03.techeerpartnersbackend.domain.restaurant.entity.Restaurant;
import com.kancth03.techeerpartnersbackend.domain.restaurant.dto.AddRestaurantResponse;
import com.kancth03.techeerpartnersbackend.domain.restaurant.repository.RestaurantRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class RestaurantService {

    private final RestaurantRepository restaurantRepository;

    public AddRestaurantResponse addRestaurant(AddRestaurantRequest request) {
        duplicateValidate(request.name());

        Restaurant savedRestaurant = restaurantRepository.save(request.toEntity());
        return AddRestaurantResponse.entityToDto(savedRestaurant);
    }

    private void duplicateValidate(String restaurantName) {
        Optional<Restaurant> findRestaurant = restaurantRepository.findByName(restaurantName);

        if (findRestaurant.isPresent()) {
            throw new IllegalArgumentException("이미 존재하는 레스토랑명입니다.");
        }
    }
}
