package com.example.restaurantservice.dto;

import com.example.restaurantservice.entity.Drink;
import com.example.restaurantservice.entity.Food;
import lombok.Data;

import java.util.List;

@Data
public class MenuDTO {
    private String name;
    private String description;
    List<Food> foods;
    List<Drink> drinks;
}
