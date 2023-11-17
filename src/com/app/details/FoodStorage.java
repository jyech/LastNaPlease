package com.app.details;

import java.util.ArrayList;
import java.util.List;

public class FoodStorage {
    private static FoodStorage instance;
    private List<FoodItem> foodItems;

    private FoodStorage() {
        foodItems = new ArrayList<>();
    }

    public static synchronized FoodStorage getInstance() {
        if (instance == null) {
            instance = new FoodStorage();
        }
        return instance;
    }

    public void addFoodItem(FoodItem foodItem) {
        foodItems.add(foodItem);
    }

    public List<FoodItem> getFoodItems() {
        return new ArrayList<>(foodItems);
    }

    // Add this method to find FoodItem by orderId
    public FoodItem getFoodItemByOrderId(String orderId) {
        for (FoodItem foodItem : foodItems) {
            if (foodItem.getOrderId().equals(orderId)) {
                return foodItem;
            }
        }
        return null; // Return null if no matching FoodItem is found
    }
    
    public void clear() {
        foodItems.clear();
    }
    
}
