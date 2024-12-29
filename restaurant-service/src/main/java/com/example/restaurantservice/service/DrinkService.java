package com.example.restaurantservice.service;

import com.example.restaurantservice.dto.DrinkDTO;
import com.example.restaurantservice.entity.Drink;
import com.example.restaurantservice.repository.DrinkRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DrinkService {

    private final DrinkRepository drinkRepository;

    public List<Drink> getAllDrinks() {
        return drinkRepository.findAll();
    }

    public Drink getDrinkById(Long id) {
        return drinkRepository.findById(id).orElse(null);
    }

    public Drink saveDrink(DrinkDTO drinkDTO) {
        Drink drink = new Drink();
        drink.setName(drinkDTO.getName());
        drink.setDescription(drinkDTO.getDescription());
        drink.setPrice(drinkDTO.getPrice());

        return drinkRepository.save(drink);
    }

    public Drink updateDrink(Long drinkId, DrinkDTO drinkDTO) {
        Drink drink = drinkRepository.findById(drinkId).orElse(null);

        if (drink != null) {
            drink.setName(drinkDTO.getName());
            drink.setPrice(drinkDTO.getPrice());
            drink.setDescription(drinkDTO.getDescription());
            return drinkRepository.save(drink);
        }

        return null;
    }

    public void deleteDrink(Long drinkId) {
        drinkRepository.deleteById(drinkId);
    }
}
