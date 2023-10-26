package com.kancth03.techeerpartnersbackend.domain.restaurant.dto;

import com.kancth03.techeerpartnersbackend.domain.restaurant.entity.RestaurantCategory;

public record ModifyCategoryRequest(
        Long id,
        RestaurantCategory category
) {
}
