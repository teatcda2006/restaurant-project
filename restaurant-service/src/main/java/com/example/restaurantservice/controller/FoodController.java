package com.example.restaurantservice.controller;

import com.example.restaurantservice.dto.FoodDTO;
import com.example.restaurantservice.entity.Food;
import com.example.restaurantservice.service.FoodService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/restaurant/foods")
@RequiredArgsConstructor
public class FoodController {

    private final FoodService foodService;

    @GetMapping
    public ResponseEntity<List<Food>> getFoods() {
        return ResponseEntity.ok(foodService.getFoods());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Food> getFoodById(@PathVariable Long id) {
        return ResponseEntity.ok(foodService.getFood(id));
    }

    @PostMapping
    public ResponseEntity<Food> createFood(@RequestBody FoodDTO food) {
        return ResponseEntity.ok(foodService.createFood(food));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Food> updateFood(@PathVariable Long id, @RequestBody FoodDTO food) {
        return ResponseEntity.ok(foodService.updateFood(id, food));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Food> deleteFood(@PathVariable Long id) {
        foodService.deleteFood(id);

        return new ResponseEntity<>(HttpStatus.OK);
    }
}
