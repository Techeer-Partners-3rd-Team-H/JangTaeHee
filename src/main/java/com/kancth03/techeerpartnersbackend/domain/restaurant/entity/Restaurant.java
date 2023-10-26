package com.kancth03.techeerpartnersbackend.domain.restaurant.entity;

import com.kancth03.techeerpartnersbackend.domain.review.entity.Review;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@EntityListeners(AuditingEntityListener.class)
@Entity
@Table
@Getter
public class Restaurant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "restaurant_id")
    private Long id;

    @Column(nullable = false, updatable = false, unique = true, length = 100)
    private String name;

    @OneToMany(mappedBy = "restaurant_id")
    private List<Review> reviews = new ArrayList<>();

    @Setter
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private RestaurantCategory category;

    @CreatedDate
    private LocalDateTime createdAt;

    public Restaurant(String name, RestaurantCategory category) {
        this.name = name;
        this.category = category;
    }
}
