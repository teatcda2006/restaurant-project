package com.example.restaurantservice.service;

import com.example.restaurantservice.dto.FoodDTO;
import com.example.restaurantservice.entity.Food;
import com.example.restaurantservice.repository.FoodRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FoodService {

    private final FoodRepository foodRepository;

    public Food createFood(FoodDTO foodDTO) {
        Food food = new Food();
        food.setName(foodDTO.getName());
        food.setDescription(foodDTO.getDescription());
        food.setPrice(foodDTO.getPrice());

        return foodRepository.save(food);
    }

    public Food getFood(Long foodId) {
        return foodRepository.findById(foodId).orElse(null);
    }

    public List<Food> getFoods() {
        return foodRepository.findAll();
    }

    public Food updateFood(Long foodId, FoodDTO foodDTO) {
        Food food = foodRepository.findById(foodId).orElse(null);

        if (food != null) {
            food.setName(foodDTO.getName());
            food.setDescription(foodDTO.getDescription());
            food.setPrice(foodDTO.getPrice());
            return foodRepository.save(food);
        }

        return null;
    }

    public void deleteFood(Long foodId) {
        foodRepository.deleteById(foodId);
    }
}
