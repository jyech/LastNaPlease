/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.app.transaction;

import com.app.details.FoodItem;

/**
 *
 * @author Kirin
 */
public class CartItem {

    private FoodItem foodItem;
    private int quantity;

    public CartItem(FoodItem foodItem) {
        this.foodItem = foodItem;
        this.quantity = 1;  // Start with quantity 1
    }

    public FoodItem getFoodItem() {
        return foodItem;
    }

    public int getQuantity() {
        return quantity;
    }

    public void incrementQuantity() {
        quantity++;
    }
}




