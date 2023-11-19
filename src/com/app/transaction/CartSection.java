/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.app.transaction;

import com.app.details.FoodItem;
import com.app.assets.ProductDetailsPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;



/**
 * CartSection to display items in the shopping cart.
 * 
 * @author Kirin
 */
public class CartSection extends javax.swing.JPanel implements ProductDetailsPanel.QuantityChangeListener, ActionListener {
    
    private List<FoodItem> cartItems;
    
    
    public CartSection() {
        initComponents();
        cartItems = new ArrayList<>();// Ensure that this method is called to initialize the components // Initialize cartPanel
    }

    @Override
    public void onQuantityChanged(String itemName, int newQuantity) {
        // Update the total field in the CartSection when the quantity changes
        updateTotalField();

        // Update the corresponding FoodItem in the cartItems list
        updateFoodItemQuantity(itemName, newQuantity);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() instanceof JButton) {
            JButton removeButton = (JButton) e.getSource();
            ProductDetailsPanel panelToRemove = findPanelFromRemoveButton(removeButton);
            if (panelToRemove != null) {
                removePanelAndItem(panelToRemove);
            }
        }
    }
    
    private void removePanelAndItem(ProductDetailsPanel panelToRemove) {
    // Remove the panel from the container
    JPanel container = (JPanel) OrderScrollPane.getViewport().getView();
    container.remove(panelToRemove);

    // Remove the corresponding item from cartItems
    String itemName = panelToRemove.getFoodName();
    cartItems.removeIf(item -> item.getName().equals(itemName));

    // Decrease the unique items count

    // Update the UI
    revalidate();
    repaint();

    // Update the total field after removal
    updateTotalField();
}



    private ProductDetailsPanel findPanelFromRemoveButton(JButton removeButton) {
    Component[] components = ((JPanel) OrderScrollPane.getViewport().getView()).getComponents();

    for (Component component : components) {
        if (component instanceof ProductDetailsPanel) {
            ProductDetailsPanel panel = (ProductDetailsPanel) component;
            if (panel.getRemoveButton() == removeButton) {
                return panel;
            }
        }
    }

    return null;
}


    private void updateRemoveButton(ProductDetailsPanel panel) {
        JButton removeButton = panel.getRemoveButton();
        removeButton.addActionListener(this);
    }

    
    
    private void updateTotalField() {
    SwingUtilities.invokeLater(() -> {
        
        double totalAmount = calculateTotalAmount(cartItems);
        
        TotalLabel.setText(String.format("%.2f", totalAmount));
                
        revalidate();
        repaint();
    });
}


    

private void updateFoodItemQuantity(String itemName, int newQuantity) {
        for (FoodItem item : cartItems) {
            if (item.getName().equals(itemName)) {
                item.setUserQuantity(newQuantity);
                break;
            }
        }
    }

    public void displayCartItems(List<FoodItem> cartItems) {
    this.cartItems = cartItems;
    JPanel cartOrderPanelContainer = new JPanel();
    cartOrderPanelContainer.setLayout(new BoxLayout(cartOrderPanelContainer, BoxLayout.Y_AXIS));

    for (FoodItem item : cartItems) {
    if (item.getUserQuantity() >= 1) {
        // Check if the item is already displayed in the cart
        ProductDetailsPanel existingPanel = findExistingPanel(cartOrderPanelContainer, item.getName());

        if (existingPanel != null) {
            // Item already exists, update its quantity
            existingPanel.updateQuantity(existingPanel.getQuantity() + item.getUserQuantity());
        } else {
            // Create a new CartOrderPanel and add it to the container
            ProductDetailsPanel cartOrderPanel = new ProductDetailsPanel(
                    item.getName(),
                    item.getPrice(),
                    item.getUserQuantity()
            );

            cartOrderPanelContainer.setBackground(new java.awt.Color(241, 242, 237));
            cartOrderPanel.setOrderImage(item.getImageIcon());

            // Set the listener here
            cartOrderPanel.setQuantityChangeListener(this);

            cartOrderPanelContainer.add(cartOrderPanel);
            cartOrderPanel.setRemoveButtonAction(this);

        }
    }
}
    

    // Add vertical glue to push CartOrderPanel instances to the top
    cartOrderPanelContainer.add(Box.createVerticalGlue());

    // Add the container to the existing JScrollPane
    OrderScrollPane.setViewportView(cartOrderPanelContainer);
    OrderScrollPane.setAlignmentX(LEFT_ALIGNMENT);  // Ensure the alignment is set to the left
    revalidate();
    repaint();

    // Update the total field after displaying the cart items
    updateTotalField();
}



    
    private double calculateTotalAmount(List<FoodItem> cartItems) {
    double totalAmount = 0;

    for (FoodItem item : cartItems) {
        int userQuantity = item.getUserQuantity();
        if (userQuantity >= 1) {
            totalAmount += item.getPrice() * userQuantity;
        }
    }
    return totalAmount;
}



private ProductDetailsPanel findExistingPanel(JPanel container, String itemName) {
    Component[] components = container.getComponents();

    for (Component component : components) {
        if (component instanceof ProductDetailsPanel) {
            ProductDetailsPanel existingPanel = (ProductDetailsPanel) component;
            if (existingPanel.getName().equals(itemName)) {
                return existingPanel;
            }
        }
    }

    return null;
}

    private int calculateTotalQuantity(List<FoodItem> cartItems) {
        int totalQuantity = 0;

        for (FoodItem item : cartItems) {
            if (item.getUserQuantity() >= 1) {
                totalQuantity += item.getUserQuantity();
            }
        }

        return totalQuantity;
    }


    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        OrderScrollPane = new javax.swing.JScrollPane();
        ShoppingCartLabel = new javax.swing.JLabel();
        TotalLabel = new javax.swing.JLabel();
        TotalLabel2 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(241, 242, 237));
        setPreferredSize(new java.awt.Dimension(1600, 900));

        OrderScrollPane.setBackground(new java.awt.Color(241, 242, 237));
        OrderScrollPane.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        OrderScrollPane.setHorizontalScrollBar(null);
        OrderScrollPane.setPreferredSize(new java.awt.Dimension(1600, 900));

        ShoppingCartLabel.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        ShoppingCartLabel.setText("Shopping Cart");

        TotalLabel.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        TotalLabel.setText("0.00");

        TotalLabel2.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        TotalLabel2.setText("TOTAL");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(ShoppingCartLabel)
                        .addGap(1123, 1123, 1123))
                    .addComponent(OrderScrollPane, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
            .addGroup(layout.createSequentialGroup()
                .addGap(264, 264, 264)
                .addComponent(TotalLabel2)
                .addGap(18, 18, 18)
                .addComponent(TotalLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(ShoppingCartLabel)
                .addGap(18, 18, 18)
                .addComponent(OrderScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 706, Short.MAX_VALUE)
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TotalLabel2)
                    .addComponent(TotalLabel))
                .addGap(39, 39, 39))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane OrderScrollPane;
    private javax.swing.JLabel ShoppingCartLabel;
    private javax.swing.JLabel TotalLabel;
    private javax.swing.JLabel TotalLabel2;
    // End of variables declaration//GEN-END:variables
}
