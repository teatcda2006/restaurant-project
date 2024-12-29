package com.example.restaurantservice.controller;

import com.example.restaurantservice.dto.DrinkDTO;
import com.example.restaurantservice.entity.Drink;
import com.example.restaurantservice.entity.Food;
import com.example.restaurantservice.service.DrinkService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/drinks")
public class DrinkController {
    private final DrinkService drinkService;

    @GetMapping
    public ResponseEntity<List<Drink>> getAllDrinks() {
        return ResponseEntity.ok(drinkService.getAllDrinks());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Drink> getDrinkById(@PathVariable Long id) {
        return ResponseEntity.ok(drinkService.getDrinkById(id));
    }

    @PostMapping
    public ResponseEntity<Drink> createDrink(@RequestBody DrinkDTO drink) {
        return ResponseEntity.ok(drinkService.saveDrink(drink));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Drink> updateDrink(@RequestBody DrinkDTO drink, @PathVariable Long id) {
        return ResponseEntity.ok(drinkService.updateDrink(id, drink));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Drink> deleteDrink(@PathVariable Long id) {
        drinkService.deleteDrink(id);

        return new ResponseEntity<>(HttpStatus.OK);
    }
}
