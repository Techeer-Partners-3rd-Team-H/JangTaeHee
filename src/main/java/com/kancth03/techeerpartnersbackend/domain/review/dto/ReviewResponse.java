package com.kancth03.techeerpartnersbackend.domain.review.dto;

import com.kancth03.techeerpartnersbackend.domain.review.entity.Review;

public record ReviewResponse(
        String restaurantName,
        String title,
        String content
) {
    public static ReviewResponse entityToDto(Review review) {
        return new ReviewResponse(review.getRestaurant().getName(), review.getTitle(), review.getContent());
    }
}
