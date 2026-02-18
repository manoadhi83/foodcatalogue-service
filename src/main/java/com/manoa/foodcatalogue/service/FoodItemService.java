package com.manoa.foodcatalogue.service;

import com.manoa.foodcatalogue.dto.FoodCatalogueDto;
import com.manoa.foodcatalogue.dto.FoodItemDto;

import java.util.List;

public interface FoodItemService {

    FoodItemDto addFoodItem(FoodItemDto foodItemDto);

    FoodItemDto getFoodItemById(Long id);

    FoodCatalogueDto getAllFoodItemByRestaurantId(Long restuarantId);

    void deleteFoodItemById(Long id);

    List<FoodItemDto> getAllFoodItems();
}
