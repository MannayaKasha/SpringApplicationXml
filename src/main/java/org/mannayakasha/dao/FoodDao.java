package org.mannayakasha.dao;

import org.mannayakasha.model.Food;

import java.util.List;

public interface FoodDao {
    void addFood(Food food);

    void updateFood(Food food);

    void removeFood(int id);

    Food getFoodById(int id);

    List<Food> listFoods();
}
