package com.example.restaurantservice.dto;

import lombok.Data;

@Data
public class FoodDTO {
    private String name;
    private String description;
    private Double price;
}
