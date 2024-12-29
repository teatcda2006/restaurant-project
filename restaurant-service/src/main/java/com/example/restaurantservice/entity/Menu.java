package com.example.restaurantservice.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;


@Entity
@Data
public class Menu {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String name;
    String description;

    @ManyToMany(fetch = FetchType.EAGER)
    List<Food> foods;
    @ManyToMany(fetch = FetchType.EAGER)
    List<Drink> drinks;
}
