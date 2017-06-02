package org.mannayakasha.dao;

import org.hibernate.Session;
import org.mannayakasha.model.Meal;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class MealDaoImpl implements MealDao {
    private static final Logger logger = LoggerFactory.getLogger(MealDaoImpl.class);

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public void addMeal(Meal meal) {
        Session session = entityManager.unwrap(Session.class);
        session.persist(meal);
        logger.info("Meal successfully saved. Meal details: " + meal);
    }

    @Override
    public void updateMeal(Meal meal) {
        Session session = entityManager.unwrap(Session.class);
        session.update(meal);
        logger.info("Meal successfully updated. Meal details: " + meal);
    }

    @Override
    public void removeMeal(int id) {
        Session session = entityManager.unwrap(Session.class);
        Meal meal = (Meal) session.load(Meal.class, new Integer(id));

        if(meal != null){
            session.delete(meal);
        }
        logger.info("Meal successfully removed. Meal details: " + meal);
    }

    @Override
    public Meal getMealById(int id) {
        Session session = entityManager.unwrap(Session.class);
        Meal meal = (Meal) session.load(Meal.class, new Integer(id));
        logger.info("Meal successfully loaded. Meal details: " + meal);

        return meal;
    }

    @Override
    public List<Meal> listMeals() {
        Session session = entityManager.unwrap(Session.class);
        List<Meal> mealList = session.createQuery("from Meal").list();

        for(Meal meal: mealList){
            logger.info("Meal list: " + meal);
        }

        return mealList;
    }
}
