package com.kancth03.techeerpartnersbackend.domain.restaurant.dto;

import com.kancth03.techeerpartnersbackend.domain.restaurant.entity.Restaurant;
import com.kancth03.techeerpartnersbackend.domain.restaurant.entity.RestaurantCategory;

/**
 * DTO for {@link com.kancth03.techeerpartnersbackend.domain.restaurant.entity.Restaurant}
 */
public record AddRestaurantRequest(
        String name,
        RestaurantCategory category
) {
    public Restaurant toEntity() {
        return new Restaurant(name, category);
    }
}