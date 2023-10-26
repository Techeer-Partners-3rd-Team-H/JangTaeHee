package com.kancth03.techeerpartnersbackend.domain.review.dto;

public record AddReviewRequest(
        Long restaurantId,
        String title,
        String content
) {
}
