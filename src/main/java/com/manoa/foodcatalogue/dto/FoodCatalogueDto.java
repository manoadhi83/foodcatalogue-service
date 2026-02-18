package com.manoa.foodcatalogue.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FoodCatalogueDto {

    private List<FoodItemDto> foodItemDto;
    private RestaurantDto restaurantDto;
}
