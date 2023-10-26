package com.kancth03.techeerpartnersbackend.domain.restaurant.service;

import com.kancth03.techeerpartnersbackend.domain.restaurant.dto.AddRestaurantRequest;
import com.kancth03.techeerpartnersbackend.domain.restaurant.dto.AddRestaurantResponse;
import com.kancth03.techeerpartnersbackend.domain.restaurant.dto.ModifyCategoryRequest;
import com.kancth03.techeerpartnersbackend.domain.restaurant.dto.ModifyCategoryResponse;
import com.kancth03.techeerpartnersbackend.domain.restaurant.entity.Restaurant;
import com.kancth03.techeerpartnersbackend.domain.restaurant.entity.RestaurantCategory;
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

    public ModifyCategoryResponse modifyCategory(ModifyCategoryRequest request) {
        // 레스토랑 id 존재 확인
        restaurantValidate(request.id());

        Restaurant restaurant = restaurantRepository.findById(request.id()).orElseThrow();
        RestaurantCategory oldCategory = restaurant.getCategory();

        restaurant.setCategory(request.category());
        // 쿼리 확인을 위해 바로 save
        restaurantRepository.save(restaurant);

        return new ModifyCategoryResponse(restaurant.getName(), oldCategory, restaurant.getCategory());
    }

    private void duplicateValidate(String restaurantName) {
        Optional<Restaurant> findRestaurant = restaurantRepository.findByName(restaurantName);

        if (findRestaurant.isPresent()) {
            throw new IllegalArgumentException("레스토랑명 중복");
        }
    }

    private void restaurantValidate(Long restaurantId) {
        Optional<Restaurant> findRestaurant = restaurantRepository.findById(restaurantId);

        if (findRestaurant.isEmpty()) {
            throw new IllegalArgumentException("존재하지 않는 레스토랑");
        }
    }
}