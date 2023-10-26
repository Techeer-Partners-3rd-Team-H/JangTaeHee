package com.kancth03.techeerpartnersbackend.domain.review.service;

import com.kancth03.techeerpartnersbackend.domain.restaurant.entity.Restaurant;
import com.kancth03.techeerpartnersbackend.domain.restaurant.repository.RestaurantRepository;
import com.kancth03.techeerpartnersbackend.domain.restaurant.validate.RestaurantValidate;
import com.kancth03.techeerpartnersbackend.domain.review.dto.AddReviewRequest;
import com.kancth03.techeerpartnersbackend.domain.review.dto.ReviewResponse;
import com.kancth03.techeerpartnersbackend.domain.review.entity.Review;
import com.kancth03.techeerpartnersbackend.domain.review.repository.ReviewRepository;
import com.kancth03.techeerpartnersbackend.domain.review.validate.ReviewValidate;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class ReviewService {

    private final ReviewRepository reviewRepository;
    private final RestaurantRepository restaurantRepository;
    private final RestaurantValidate restaurantValidate;
    private final ReviewValidate reviewValidate;

    public ReviewResponse addReview(AddReviewRequest request) {
        restaurantValidate.restaurantValidate(request.restaurantId());

        Restaurant restaurant = restaurantRepository.findById(request.restaurantId()).orElseThrow();
        Review review = reviewRepository.save(new Review(request.title(), request.content(), restaurant));

        return ReviewResponse.entityToDto(review);
    }

    public void deleteReview(Long reviewId) {
        reviewValidate.reviewValidate(reviewId);

        reviewRepository.deleteById(reviewId);
    }
}
