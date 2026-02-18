package com.manoa.foodcatalogue.dto;

public record FoodItemDto(Long id,
                          String itemName,
                          String itemDescription,
                          Boolean isVeg,
                          Double price,
                          Long restaurantId,
                          Integer quantity) {
}
