package org.mannayakasha.service;

import org.mannayakasha.dao.FoodDao;
import org.mannayakasha.model.Food;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class FoodServiceImpl implements FoodService {

    @Autowired
    private FoodDao foodDao;

    public void setFoodDao(FoodDao foodDao) {
        this.foodDao = foodDao;
    }

    @Override
    @Transactional
    public void addFood(Food food) {
        this.foodDao.addFood(food);
    }

    @Override
    @Transactional
    public void updateFood(Food food) {
        this.foodDao.updateFood(food);
    }

    @Override
    @Transactional
    public void removeFood(int id) {
        this.foodDao.removeFood(id);
    }

    @Override
    @Transactional
    public Food getFoodById(int id) {
        return this.foodDao.getFoodById(id);
    }

    @Override
    @Transactional
    public List<Food> listFoods() {
        return this.foodDao.listFoods();
    }
}
