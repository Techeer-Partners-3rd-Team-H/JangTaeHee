package com.kancth03.techeerpartnersbackend.domain.review.dto;

public record ModifyReviewRequest(
        Long reviewId,
        String title,
        String content
) {
}
