package com.kancth03.techeerpartnersbackend.domain.restaurant.controller;

import com.kancth03.techeerpartnersbackend.domain.restaurant.dto.*;
import com.kancth03.techeerpartnersbackend.domain.restaurant.entity.RestaurantCategory;
import com.kancth03.techeerpartnersbackend.domain.restaurant.service.RestaurantService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/restaurant")
public class RestaurantController {

    private final RestaurantService restaurantService;

    @PostMapping
    public AddRestaurantResponse addRestaurant(@RequestBody AddRestaurantRequest request) {
        // 레스토랑에는 레스토랑명, 레스토랑 카테고리 (한식, 중식, 일식 등)의 내용이 있습니다.
        // 등록한 날짜를 기록해야 합니다.
        return restaurantService.addRestaurant(request);
    }

    @PutMapping
    public ModifyCategoryResponse modifyCategory(@RequestBody ModifyCategoryRequest request) {
        // 리뷰를 수정할 수 있습니다.
        return restaurantService.modifyCategory(request);
    }

    @GetMapping
    public List<FindRestaurantResponse> findRestaurantList(@RequestParam(required = false) RestaurantCategory category) {
        // 레스토랑의 전체 목록을 조회할 수 있습니다.
        // 레스토랑 카테고리에 따른 레스토랑 목록 조회를 할 수 있습니다.
        if (category == null) {
            return restaurantService.findRestaurantList();
        }
        return restaurantService.findRestaurantList(category);
    }

    @GetMapping("/{restaurantId}")
    public FindRestaurantResponse findRestaurant(@PathVariable Long restaurantId) {
        // 레스토랑 명, 카테고리, 음식점의 생성 일자가 반환 되어야 합니다.
        return restaurantService.findRestaurant(restaurantId);
    }

    @DeleteMapping("/{restaurantId}")
    public void deleteRestaurant(@PathVariable Long restaurantId) {
        // 레스토랑의 삭제로 인하여 작성된 리뷰들이 삭제 되면 안됩니다. (Soft Delete)
        restaurantService.deleteRestaurant(restaurantId);
    }
}
