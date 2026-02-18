package com.manoa.foodcatalogue.dto;

public record RestaurantDto(Long id,
                            String name,
                            String address,
                            String city,
                            String description) {
}
