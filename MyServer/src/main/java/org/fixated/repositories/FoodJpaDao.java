package org.fixated.repositories;

import org.fixated.models.food.FoodItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FoodJpaDao extends JpaRepository<FoodItem,Integer> {
    List<FoodItem> findByCategory(String foodName);
}

