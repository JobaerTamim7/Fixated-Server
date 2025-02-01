package org.fixated.controllers;

import org.fixated.models.food.FoodItem;
import org.fixated.services.FoodItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class FoodItemController {

    @Autowired
    private FoodItemService foodItemService;

    FoodItemController(FoodItemService foodItemService) {
        this.foodItemService = foodItemService;
    }

    @GetMapping("/foods")
    public List<FoodItem> getFoods(
            @RequestParam(name = "page", defaultValue = "1") int page,
            @RequestParam(name = "size", defaultValue = "9") int size
    ) {
        Pageable pageable = PageRequest.of(page-1, size);
        System.out.println("page : " + page);
        System.out.println("size : " + size);
        System.out.println("pageable : " + pageable);
        System.out.println(foodItemService.getFoodItems(pageable));
        return foodItemService.getFoodItems(pageable);
    }
}
