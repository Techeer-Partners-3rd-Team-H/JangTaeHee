package com.kancth03.techeerpartnersbackend.domain.review.dto;

import com.kancth03.techeerpartnersbackend.domain.review.entity.Review;

public record AddReviewRequest(
        Long restaurantId,
        String title,
        String content
) {
}
