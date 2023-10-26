package com.kancth03.techeerpartnersbackend.domain.restaurant.dto;

import com.kancth03.techeerpartnersbackend.domain.restaurant.entity.Restaurant;
import com.kancth03.techeerpartnersbackend.domain.restaurant.entity.RestaurantCategory;

import java.time.LocalDateTime;

public record FindRestaurantResponse(
        String name,
        RestaurantCategory category,
        LocalDateTime createdAt
) {
    public static FindRestaurantResponse entityToDto(Restaurant restaurant) {
        return new FindRestaurantResponse(restaurant.getName(), restaurant.getCategory(), restaurant.getCreatedAt());
    }
}
