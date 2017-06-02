package org.mannayakasha.dao;


import org.hibernate.Session;
import org.mannayakasha.model.Food;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class FoodDaoImpl implements FoodDao {
    private static final Logger logger = LoggerFactory.getLogger(FoodDaoImpl.class);

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public void addFood(Food food) {
        Session session = entityManager.unwrap(Session.class);
        session.persist(food);
        logger.info("Food successfully saved. Food details: " + food);
    }

    @Override
    public void updateFood(Food food) {
        Session session = entityManager.unwrap(Session.class);
        session.update(food);
        logger.info("Food successfully updated. Food details: " + food);
    }

    @Override
    public void removeFood(int id) {
        Session session = entityManager.unwrap(Session.class);
        Food food = (Food) session.load(Food.class, new Integer(id));

        if(food != null){
            session.delete(food);
        }
        logger.info("Food successfully removed. Food details: " + food);
    }

    @Override
    public Food getFoodById(int id) {
        Session session = entityManager.unwrap(Session.class);
        Food food = (Food) session.load(Food.class, new Integer(id));
        logger.info("Food successfully loaded. Food details: " + food);

        return food;
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Food> listFoods() {
        Session session = entityManager.unwrap(Session.class);
        List<Food> foodList = session.createQuery("from Food").list();

        for(Food food: foodList){
            logger.info("Food list: " + food);
        }

        return foodList;
    }
}
