/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.app.transaction;

public class OrderManager {

    private static OrderManager instance;
    private int nextOrderId;

    private OrderManager() {
        // private constructor to enforce singleton pattern
        // Initialize the order ID to 1
        this.nextOrderId = 1;
    }

    public static OrderManager getInstance() {
        if (instance == null) {
            instance = new OrderManager();
        }
        return instance;
    }

    public String getOrderId() {
        // Return the current order ID and then increment for the next one
        return String.valueOf(nextOrderId++);
    }
}


