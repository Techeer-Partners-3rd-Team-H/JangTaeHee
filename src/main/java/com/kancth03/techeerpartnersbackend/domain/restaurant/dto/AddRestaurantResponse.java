package com.kancth03.techeerpartnersbackend.domain.restaurant.dto;

import com.kancth03.techeerpartnersbackend.domain.restaurant.entity.Restaurant;
import com.kancth03.techeerpartnersbackend.domain.restaurant.entity.RestaurantCategory;

import java.time.LocalDateTime;

/**
 * DTO for {@link com.kancth03.techeerpartnersbackend.domain.restaurant.entity.Restaurant}
 */
public record AddRestaurantResponse(
        Long id,
        String name,
        RestaurantCategory category,
        LocalDateTime createdAt
) {
    public static AddRestaurantResponse entityToDto(Restaurant entity) {
        return new AddRestaurantResponse(entity.getId(), entity.getName(), entity.getCategory(), entity.getCreatedAt());
    }
}