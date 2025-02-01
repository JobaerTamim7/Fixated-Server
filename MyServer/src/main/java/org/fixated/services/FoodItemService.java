package org.fixated.services;

import org.fixated.models.food.FoodItem;
import org.fixated.repositories.FoodJpaDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class FoodItemService {
    private FoodJpaDao foodDao;

    @Autowired
    public FoodItemService(FoodJpaDao foodDao) {
        this.foodDao = foodDao;
    }

    public List<FoodItem> getFoodItems(Pageable pageable) {
        return foodDao.findAll(pageable).getContent();
    }

    public void addFoodItem(FoodItem foodItem) {
        foodDao.save(foodItem);
    }

    public List<FoodItem> getByCategory(String category) {
        return foodDao.findByCategory(category);
    }
}
