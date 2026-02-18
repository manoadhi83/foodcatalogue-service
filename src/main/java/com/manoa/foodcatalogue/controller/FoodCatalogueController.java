package com.manoa.foodcatalogue.controller;

import com.manoa.foodcatalogue.dto.FoodCatalogueDto;
import com.manoa.foodcatalogue.dto.FoodItemDto;
import com.manoa.foodcatalogue.service.FoodItemService;
import org.apache.http.protocol.HTTP;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/food-items")
@CrossOrigin
public class FoodCatalogueController {

    private FoodItemService foodItemService;

    public FoodCatalogueController(FoodItemService foodItemService) {
        this.foodItemService = foodItemService;
    }

    @PostMapping
    public ResponseEntity<FoodItemDto> addFoodItem(@RequestBody FoodItemDto foodItemDto) {
        return new ResponseEntity<>(foodItemService.addFoodItem(foodItemDto), HttpStatus.CREATED);
    }

    @PostMapping("{foodItemId}")
    public ResponseEntity<FoodItemDto> getFoodItemById(Long foodItemId) {
        return new ResponseEntity<>(foodItemService.getFoodItemById(foodItemId), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<FoodItemDto>> getAllFoodItems() {
        return new ResponseEntity<>(foodItemService.getAllFoodItems(), HttpStatus.OK);
    }

    @GetMapping("/restaurant/{restaurantId}")
    public ResponseEntity<FoodCatalogueDto> getFoodCatalogue(@PathVariable Long restaurantId) {
        return new ResponseEntity<>(foodItemService.getAllFoodItemByRestaurantId(restaurantId), HttpStatus.CREATED);
    }

    @DeleteMapping("/{foodItemId}")
    public  ResponseEntity<Void> deleteFoodItem(@PathVariable Long foodItemId) {
        foodItemService.deleteFoodItemById(foodItemId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
