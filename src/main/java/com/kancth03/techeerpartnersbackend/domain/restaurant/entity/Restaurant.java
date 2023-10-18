package com.kancth03.techeerpartnersbackend.domain.restaurant.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

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

    @Setter
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private RestaurantCategory category;

    @CreatedDate
    private LocalDateTime createdAt;

    private Restaurant(String name, RestaurantCategory category) {
        this.name = name;
        this.category = category;
    }

    public static Restaurant of(String name, RestaurantCategory category) {
        return new Restaurant(name, category);
    }
}
