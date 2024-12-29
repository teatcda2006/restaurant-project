package com.example.restaurantservice.service;

import com.example.restaurantservice.dto.RestaurantDTO;
import com.example.restaurantservice.entity.Menu;
import com.example.restaurantservice.entity.Restaurant;
import com.example.restaurantservice.repository.RestaurantRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RestaurantService {
    private final RestaurantRepository restaurantRepository;

    public Restaurant createRestaurant(RestaurantDTO restaurantDTO) {
        Restaurant restaurant = new Restaurant();
        restaurant.setName(restaurantDTO.getName());
        restaurant.setAddress(restaurantDTO.getAddress());
        restaurant.setPhoneNumber(restaurantDTO.getPhoneNumber());
        restaurant.setMenu(restaurantDTO.getMenu());

        return restaurantRepository.save(restaurant);
    }

    public Restaurant updateRestaurant(RestaurantDTO restaurantDTO, Long id) {
        Restaurant restaurant = restaurantRepository.findById(id).orElse(null);

        if (restaurant != null) {
            restaurant.setName(restaurantDTO.getName());
            restaurant.setAddress(restaurantDTO.getAddress());
            restaurant.setPhoneNumber(restaurantDTO.getPhoneNumber());
            for (Menu menu : restaurantDTO.getMenu()) {
                restaurant.getMenu().add(menu);
            }
            return restaurantRepository.save(restaurant);
        }

        return null;
    }

    public List<Restaurant> getAllRestaurants() {
        return restaurantRepository.findAll();
    }

    public Restaurant getRestaurantById(Long id) {
        return restaurantRepository.findById(id).orElse(null);
    }

    public void deleteRestaurant(Long id) {
        restaurantRepository.deleteById(id);
    }
}
