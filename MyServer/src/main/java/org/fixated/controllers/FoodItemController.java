package org.fixated.controllers;

import org.fixated.models.food.FoodItem;
import org.fixated.services.FoodItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/foods")
public class FoodItemController {

    @Autowired
    private FoodItemService foodItemService;

    FoodItemController(FoodItemService foodItemService) {
        this.foodItemService = foodItemService;
    }

    @GetMapping("/category/{category}")
    public List<FoodItem> getFoodsByCategory(@PathVariable String category) {
        return foodItemService.getByCategory(category);
    }
}
