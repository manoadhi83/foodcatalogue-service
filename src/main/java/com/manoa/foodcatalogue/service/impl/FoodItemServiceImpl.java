package com.manoa.foodcatalogue.service.impl;

import com.manoa.foodcatalogue.dao.FoodItemRepository;
import com.manoa.foodcatalogue.dto.FoodCatalogueDto;
import com.manoa.foodcatalogue.dto.FoodItemDto;
import com.manoa.foodcatalogue.dto.RestaurantDto;
import com.manoa.foodcatalogue.entity.FoodItem;
import com.manoa.foodcatalogue.mapper.FoodItemMapper;
import com.manoa.foodcatalogue.service.FoodItemService;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;

@Service
public class FoodItemServiceImpl implements FoodItemService {

    private FoodItemRepository foodItemRepository;

    private RestTemplate restTemplate;

    public FoodItemServiceImpl(FoodItemRepository foodItemRepository, RestTemplate restTemplate) {
        this.foodItemRepository = foodItemRepository;
        this.restTemplate = restTemplate;
    }

    @Override
    public FoodItemDto addFoodItem(FoodItemDto foodItemDto) {
        FoodItem foodItem = foodItemRepository.save(FoodItemMapper.INSTANCE.toFoodItem(foodItemDto));
        return FoodItemMapper.INSTANCE.toFoodItemDto(foodItem);
    }

    @Override
    public FoodItemDto getFoodItemById(Long id) {
        if( foodItemRepository.findById(id).isPresent()) {
            return FoodItemMapper.INSTANCE.toFoodItemDto(foodItemRepository.findById(id).get());
        }
        return null;
    }

    @Override
    public FoodCatalogueDto getAllFoodItemByRestaurantId(Long restuarantId) {

        // 1. Get food Item by restaurant Id
        List<FoodItemDto> foodItemsDto = getFoodItemsByRestaurantId(restuarantId);

        // 2. Get Restaurant details
        RestaurantDto restaurantDto = getRestaurantById(restuarantId);

        // 3. Create FoodCatalogue Dto

        return createFoodCatalogueDto(foodItemsDto, restaurantDto);
    }

    @Override
    public void deleteFoodItemById(Long id) {
        Optional<FoodItem> foodItem = foodItemRepository.findById(id);
        foodItem.ifPresent(item -> foodItemRepository.delete(item));
    }

    @Override
    public List<FoodItemDto> getAllFoodItems() {
        return foodItemRepository.findAll().stream()
                .map(FoodItemMapper.INSTANCE::toFoodItemDto)
                .toList();
    }

    private List<FoodItemDto> getFoodItemsByRestaurantId(Long restuarantId) {
        Optional<List<FoodItem>> foodItems = foodItemRepository.findFoodItemsByRestaurantId(restuarantId);
        return foodItems.map(items -> items.stream()
                .map(FoodItemMapper.INSTANCE::toFoodItemDto)
                .toList()).orElse(null);
    }

    private RestaurantDto getRestaurantById(Long restaurantId) {
        return restTemplate.getForObject("http://restaurant-service/api/restaurants/"+restaurantId, RestaurantDto.class);
    }

    private FoodCatalogueDto createFoodCatalogueDto(List<FoodItemDto> foodItemsDto, RestaurantDto restaurantDto) {
        return new FoodCatalogueDto(foodItemsDto, restaurantDto);
    }
}
