package org.mannayakasha.service;

import org.mannayakasha.model.Meal;

import java.util.List;

public interface MealService {

    void addMeal(Meal meal);

    void updateMeal(Meal meal);

    void removeMeal(int id);

    Meal getMealById(int id);

    List<Meal> listMeals();
}
