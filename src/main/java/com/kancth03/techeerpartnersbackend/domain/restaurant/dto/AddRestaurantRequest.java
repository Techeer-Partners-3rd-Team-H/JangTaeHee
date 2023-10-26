package com.kancth03.techeerpartnersbackend.domain.restaurant.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.kancth03.techeerpartnersbackend.domain.restaurant.entity.Restaurant;
import com.kancth03.techeerpartnersbackend.domain.restaurant.entity.RestaurantCategory;

import java.io.Serializable;

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