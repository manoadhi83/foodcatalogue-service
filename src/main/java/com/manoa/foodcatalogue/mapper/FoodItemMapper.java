package com.manoa.foodcatalogue.mapper;

import com.manoa.foodcatalogue.dto.FoodItemDto;
import com.manoa.foodcatalogue.entity.FoodItem;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface FoodItemMapper {

    FoodItemMapper INSTANCE = Mappers.getMapper(FoodItemMapper.class);

    FoodItemDto toFoodItemDto(FoodItem foodItem);

    FoodItem toFoodItem(FoodItemDto foodItemDto);

}
