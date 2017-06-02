package org.mannayakasha.service;

import org.mannayakasha.dao.MealDao;
import org.mannayakasha.model.Meal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class MealServiceImpl implements MealService {

    @Autowired
    private MealDao mealDao;

    public void setMealDao(MealDao mealDao) {
        this.mealDao = mealDao;
    }

    @Override
    public void addMeal(Meal meal) {
        this.mealDao.addMeal(meal);
    }

    @Override
    public void updateMeal(Meal meal) {
        this.mealDao.updateMeal(meal);
    }

    @Override
    public void removeMeal(int id) {
        this.mealDao.removeMeal(id);
    }

    @Override
    public Meal getMealById(int id) {
        return this.mealDao.getMealById(id);
    }

    @Override
    public List<Meal> listMeals() {
        return this.mealDao.listMeals();
    }
}
