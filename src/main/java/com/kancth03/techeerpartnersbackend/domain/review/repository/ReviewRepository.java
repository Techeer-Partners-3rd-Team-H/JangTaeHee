package com.kancth03.techeerpartnersbackend.domain.review.repository;

import com.kancth03.techeerpartnersbackend.domain.restaurant.entity.Restaurant;
import com.kancth03.techeerpartnersbackend.domain.review.entity.Review;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewRepository extends JpaRepository<Review, Long> {
    Page<Review> findByRestaurant(Restaurant restaurant, Pageable pageable);
}