package com.realdolmen.services;

import com.realdolmen.domain.Food;
import com.realdolmen.repositories.FoodRepository;

import java.util.List;

public class FoodService {

    /*TODO: To link FoodRepository to this service and to be able to call the methods on our repository,
        we have to add a field of type FoodRepository + initiate it */
    private FoodRepository foodRepository = new FoodRepository();

    public List<Food> getAllFood() {
        return foodRepository.getAllFoodFromDb();
    }

    //TODO add deleteFoodById(int id)
    /**this method deletes a food by id*/
    public void deleteFoodById(int id) {
        foodRepository.deleteFoodById(id);
    }

    //TODO:and updateFoodName(int id, String foodName)
    public void updateFoodName(int id, String foodName) {
        foodRepository.updateFoodName(id, foodName);
    }
}
