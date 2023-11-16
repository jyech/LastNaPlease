package com.app.details;

import com.app.transaction.OrderManager;
import javax.swing.ImageIcon;

public class FoodItem {
    private String id;
    private String orderId;  // New field to store the order ID
    private String name;
    private ImageIcon image;
    private double price;
    private int userQuantity;
    private String userDescription;

    public FoodItem(String id, String name, ImageIcon image, double price, String userDescription) {
        this.id = id;
        this.name = name;
        this.image = image;
        this.price = price;
        this.userDescription = userDescription;
        this.userQuantity = 0;
        this.orderId = OrderManager.getInstance().getOrderId();  // Get the order ID from OrderManager
    }


    // Getters and setters

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getName() {
        return name;
    }

    public ImageIcon getImageIcon() {
        return image;
    }

    public double getPrice() {
        return price;
    }

    public int getUserQuantity() {
        return userQuantity;
    }

    public void setUserQuantity(int userQuantity) {
        this.userQuantity = userQuantity;
    }

    public String getDescription() {
        return userDescription;
    }
}
