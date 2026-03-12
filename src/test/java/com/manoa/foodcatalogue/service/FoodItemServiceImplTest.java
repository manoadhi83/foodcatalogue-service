package com.manoa.foodcatalogue.service;

import com.manoa.foodcatalogue.dao.FoodItemRepository;
import com.manoa.foodcatalogue.dto.FoodCatalogueDto;
import com.manoa.foodcatalogue.dto.FoodItemDto;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;

public class FoodItemServiceImpl {

    @Mock
    FoodItemRepository dao;

    @InjectMocks
    FoodItemServiceImpl service;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    public void testAddFoodItem() {

        FoodItemDto dto = new FoodItemDto(0L, );
    }

    public void testGetFoodItemById() {

    }

    public void  testGetAllFoodItemByRestaurantId() {

    }

    public void testDeleteFoodItemById() {

    }

    public  void testGetAllFoodItems() {

    }


}
