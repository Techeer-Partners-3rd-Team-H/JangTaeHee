package com.kancth03.techeerpartnersbackend.domain.restaurant.service;

import com.kancth03.techeerpartnersbackend.domain.restaurant.dto.AddRestaurantRequest;
import com.kancth03.techeerpartnersbackend.domain.restaurant.dto.AddRestaurantResponse;
import com.kancth03.techeerpartnersbackend.domain.restaurant.dto.ModifyCategoryRequest;
import com.kancth03.techeerpartnersbackend.domain.restaurant.dto.ModifyCategoryResponse;
import com.kancth03.techeerpartnersbackend.domain.restaurant.entity.Restaurant;
import com.kancth03.techeerpartnersbackend.domain.restaurant.entity.RestaurantCategory;
import com.kancth03.techeerpartnersbackend.domain.restaurant.repository.RestaurantRepository;
import com.kancth03.techeerpartnersbackend.domain.restaurant.validate.RestaurantValidate;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class RestaurantService {

    private final RestaurantRepository restaurantRepository;
    private final RestaurantValidate restaurantValidate;

    public AddRestaurantResponse addRestaurant(AddRestaurantRequest request) {
        restaurantValidate.duplicateValidate(request.name());

        Restaurant savedRestaurant = restaurantRepository.save(request.toEntity());
        return AddRestaurantResponse.entityToDto(savedRestaurant);
    }

    public ModifyCategoryResponse modifyCategory(ModifyCategoryRequest request) {
        // 레스토랑 id 존재 확인
        restaurantValidate.restaurantValidate(request.id());

        Restaurant restaurant = restaurantRepository.findById(request.id()).orElseThrow();
        RestaurantCategory oldCategory = restaurant.getCategory();

        restaurant.setCategory(request.category());
        // 쿼리 확인을 위해 바로 save
        restaurantRepository.save(restaurant);

        return new ModifyCategoryResponse(restaurant.getName(), oldCategory, restaurant.getCategory());
    }

}