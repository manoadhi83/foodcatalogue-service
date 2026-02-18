package com.manoa.foodcatalogue.dao;

import com.manoa.foodcatalogue.entity.FoodItem;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface FoodItemRepository extends JpaRepository<FoodItem, Long> {

    Optional<List<FoodItem>> findFoodItemsByRestaurantId(Long id);
}
