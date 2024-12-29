package com.example.restaurantservice.service;

import com.example.restaurantservice.dto.MenuDTO;
import com.example.restaurantservice.entity.Drink;
import com.example.restaurantservice.entity.Food;
import com.example.restaurantservice.entity.Menu;
import com.example.restaurantservice.repository.MenuRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MenuService {

    private final MenuRepository menuRepository;

    public List<Menu> getAllMenus() {
        return menuRepository.findAll();
    }

    public Menu getMenuById(Long id) {
        return menuRepository.findById(id).orElse(null);
    }

    public Menu saveMenu(Menu menu) {
        return menuRepository.save(menu);
    }

    public Menu updateById(MenuDTO menuDto, Long id) {
        Menu menu = menuRepository.findById(id).orElse(null);

        if (menu != null) {
            menu.setName(menuDto.getName());
            menu.setDescription(menuDto.getDescription());

            if (menuDto.getFoods() != null) {
                for (Food food : menuDto.getFoods()) {
                    menu.getFoods().add(food);
                }
            }

            if (menuDto.getDrinks() != null) {
                for (Drink drink : menuDto.getDrinks()) {
                    menu.getDrinks().add(drink);
                }
            }
            return menuRepository.save(menu);
        }

        return null;
    }

    public void deleteMenuById(Long id) {
        menuRepository.deleteById(id);
    }
}
