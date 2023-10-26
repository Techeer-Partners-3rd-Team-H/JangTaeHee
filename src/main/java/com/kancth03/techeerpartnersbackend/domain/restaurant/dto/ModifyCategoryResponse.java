package com.kancth03.techeerpartnersbackend.domain.restaurant.dto;

import com.kancth03.techeerpartnersbackend.domain.restaurant.entity.RestaurantCategory;

public record ModifyCategoryResponse(
        String name,
        RestaurantCategory oldCategory,
        RestaurantCategory newCategory

) {
}
