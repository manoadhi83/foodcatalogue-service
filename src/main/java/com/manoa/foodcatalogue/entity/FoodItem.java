package com.manoa.foodcatalogue.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "food_items")
public class FoodItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String itemName;

    private String itemDescription;

    private Boolean isVeg;

    private Double price;

    private Long restaurantId;

    @Column(columnDefinition = "INT DEFAULT 0")
    private Integer quantity;
}
