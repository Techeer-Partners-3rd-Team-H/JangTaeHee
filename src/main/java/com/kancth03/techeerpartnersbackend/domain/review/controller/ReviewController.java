package com.kancth03.techeerpartnersbackend.domain.review.controller;

import com.kancth03.techeerpartnersbackend.domain.review.dto.AddReviewRequest;
import com.kancth03.techeerpartnersbackend.domain.review.dto.ModifyReviewRequest;
import com.kancth03.techeerpartnersbackend.domain.review.dto.ReviewResponse;
import com.kancth03.techeerpartnersbackend.domain.review.service.ReviewService;
import lombok.RequiredArgsConstructor;
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

    @GetMapping("/{reviewId}")
    public ReviewResponse findReview(@PathVariable Long reviewId) {
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
