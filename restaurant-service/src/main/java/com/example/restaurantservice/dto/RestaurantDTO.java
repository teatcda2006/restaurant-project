package com.example.restaurantservice.dto;

import com.example.restaurantservice.entity.Menu;
import lombok.Data;

import java.util.List;

@Data
public class RestaurantDTO {
    private String name;
    private String address;
    private String phoneNumber;
    List<Menu> menu;
}
