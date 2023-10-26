package com.kancth03.techeerpartnersbackend.domain.review.validate;

import com.kancth03.techeerpartnersbackend.domain.review.entity.Review;
import com.kancth03.techeerpartnersbackend.domain.review.repository.ReviewRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@RequiredArgsConstructor
@Component
public class ReviewValidate {

    private final ReviewRepository reviewRepository;

    public void reviewValidate(Long reviewId) {
        Optional<Review> findReview = reviewRepository.findById(reviewId);

        if (findReview.isEmpty()) {
            throw new IllegalArgumentException("존재하지 않는 리뷰");
        }
    }
}
