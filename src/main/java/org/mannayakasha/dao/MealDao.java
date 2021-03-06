package org.mannayakasha.dao;

import org.mannayakasha.model.Meal;

import java.util.List;

public interface MealDao {

    void addMeal(Meal meal);

    void updateMeal(Meal meal);

    void removeMeal(int id);

    Meal getMealById(int id);

    List<Meal> listMeals();
}
