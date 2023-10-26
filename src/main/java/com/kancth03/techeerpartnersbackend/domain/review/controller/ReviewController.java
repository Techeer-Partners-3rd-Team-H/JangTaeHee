package com.kancth03.techeerpartnersbackend.domain.review.controller;

import com.kancth03.techeerpartnersbackend.domain.review.dto.AddReviewRequest;
import com.kancth03.techeerpartnersbackend.domain.review.dto.ModifyReviewRequest;
import com.kancth03.techeerpartnersbackend.domain.review.dto.ReviewResponse;
import com.kancth03.techeerpartnersbackend.domain.review.service.ReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/review")
public class ReviewController {

    private final ReviewService reviewService;

    @PostMapping
    public ReviewResponse addReview(@RequestBody AddReviewRequest request) {
        return reviewService.addReview(request);
    }

    @GetMapping("/{restaurantId}")
    public Page<ReviewResponse> findReviewList(@PathVariable Long restaurantId, Pageable pageable) {
        return reviewService.findReviewList(restaurantId, pageable);
    }

    @GetMapping
    public ReviewResponse findReview(@RequestParam Long reviewId) {
        return reviewService.findReview(reviewId);
    }

    @PutMapping
    public ReviewResponse modifyReview(@RequestBody ModifyReviewRequest request) {
        return reviewService.modifyReview(request);
    }

    @DeleteMapping("/{reviewId}")
    public void deleteReview(@PathVariable Long reviewId) {
        reviewService.deleteReview(reviewId);
    }
}
