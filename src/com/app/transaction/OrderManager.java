package com.app.transaction;

import com.app.details.FoodItem;
import java.util.List;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class OrderManager {

    private List<FoodItem> orderItems;

    public OrderManager(List<FoodItem> orderItems) {
        this.orderItems = orderItems;
    }

    public void displayOrderItems(JPanel orderListPanel) {
        orderListPanel.removeAll(); // Clear existing components

        for (FoodItem item : orderItems) {
            if (item.getUserQuantity() >= 1) {
                JLabel itemLabel = new JLabel(item.getName() + " x" + item.getUserQuantity());
                orderListPanel.add(itemLabel);
            }
        }

        // Add any additional components or formatting as needed

        // Update the UI
        orderListPanel.revalidate();
        orderListPanel.repaint();
    }

    // Other methods for managing the order, e.g., adding, removing items, calculating total, etc.
}
