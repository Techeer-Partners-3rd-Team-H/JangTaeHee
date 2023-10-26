package com.kancth03.techeerpartnersbackend.domain.review.controller;

import com.kancth03.techeerpartnersbackend.domain.review.dto.AddReviewRequest;
import com.kancth03.techeerpartnersbackend.domain.review.dto.ReviewResponse;
import com.kancth03.techeerpartnersbackend.domain.review.service.ReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/review")
public class ReviewController {

    private final ReviewService reviewService;

    @PostMapping
    public ReviewResponse addReview(@RequestBody AddReviewRequest request) {
        return reviewService.addReview(request);
    }
}
