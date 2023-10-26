package com.kancth03.techeerpartnersbackend.domain.review.service;

import com.kancth03.techeerpartnersbackend.domain.restaurant.entity.Restaurant;
import com.kancth03.techeerpartnersbackend.domain.restaurant.repository.RestaurantRepository;
import com.kancth03.techeerpartnersbackend.domain.restaurant.validate.RestaurantValidate;
import com.kancth03.techeerpartnersbackend.domain.review.dto.AddReviewRequest;
import com.kancth03.techeerpartnersbackend.domain.review.dto.ModifyReviewRequest;
import com.kancth03.techeerpartnersbackend.domain.review.dto.ReviewResponse;
import com.kancth03.techeerpartnersbackend.domain.review.entity.Review;
import com.kancth03.techeerpartnersbackend.domain.review.repository.ReviewRepository;
import com.kancth03.techeerpartnersbackend.domain.review.validate.ReviewValidate;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

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

    public ReviewResponse modifyReview(ModifyReviewRequest request) {
        reviewValidate.reviewValidate(request.reviewId());

        Review review = reviewRepository.findById(request.reviewId()).orElseThrow();
        review.setTitle(request.title());
        review.setContent(request.content());
        // 실시간 쿼리 확인용
        Review modifiedReview = reviewRepository.save(review);
        return ReviewResponse.entityToDto(modifiedReview);
    }

    public ReviewResponse findReview(Long reviewId) {
        reviewValidate.reviewValidate(reviewId);

        Review review = reviewRepository.findById(reviewId).orElseThrow();
        return ReviewResponse.entityToDto(review);
    }

    public Page<ReviewResponse> findReviewList(Long restaurantId, Pageable pageable) {
        restaurantValidate.restaurantValidate(restaurantId);

        Restaurant restaurant = restaurantRepository.findById(restaurantId).orElseThrow();
        Page<Review> reviewPage = reviewRepository.findByRestaurant(restaurant, pageable);
        List<ReviewResponse> dtoList = reviewPage.stream()
                .map(ReviewResponse::entityToDto)
                .toList();
        return new PageImpl<>(dtoList);
    }
}
