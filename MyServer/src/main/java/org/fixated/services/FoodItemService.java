package org.fixated.services;

import org.fixated.models.food.FoodItem;
import org.fixated.repositories.FoodJpaDao;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FoodItemService {
    private FoodJpaDao foodDao;

    public List<FoodItem> getFoodItems() {
        return foodDao.findAll();
    }

    public void addFoodItem(FoodItem foodItem) {
        foodDao.save(foodItem);
    }

    public List<FoodItem> getByCategory(String category) {
        return foodDao.findByCategory(category);
    }
}
