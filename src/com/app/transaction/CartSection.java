/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.app.transaction;

import com.app.details.FoodItem;
import java.awt.FlowLayout;
import java.util.List;
import javax.swing.JPanel;
import com.app.assets.CartOrderPanel;
import com.app.assets.ProductDetailsPanel;
import java.awt.Component;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import javax.swing.Box;
import javax.swing.SwingUtilities;
import javax.swing.JLabel;
import javax.swing.BoxLayout;



/**
 * CartSection to display items in the shopping cart.
 * 
 * @author Kirin
 */
public class CartSection extends javax.swing.JPanel {
    
    private List<FoodItem> cartItems;
    
    public CartSection() {
        initComponents();
        cartItems = new ArrayList<>();// Ensure that this method is called to initialize the components // Initialize cartPanel
        PayButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                payButtonActionPerformed(evt);
            }
        });
    }


    public void displayCartItems(List<FoodItem> cartItems) {
    // Clear the existing items in the JScrollPane
    int uniqueItemsCount = calculateUniqueItemsCount(cartItems);
    JPanel cartOrderPanelContainer = new JPanel();
    cartOrderPanelContainer.setLayout(new BoxLayout(cartOrderPanelContainer, BoxLayout.Y_AXIS));
    double totalAmount = calculateTotalAmount(cartItems);

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
                cartOrderPanelContainer.add(cartOrderPanel);
            }
        }
    }

    // Add vertical glue to push CartOrderPanel instances to the top
    cartOrderPanelContainer.add(Box.createVerticalGlue());

    // Set the TotalQuantityLabel to display the number of unique items
    if(uniqueItemsCount < 2)
    {
        TotalQuantityLabel.setText(uniqueItemsCount + " Item");
    } else {
        TotalQuantityLabel.setText(uniqueItemsCount + " Items");
    }
    

    // Add the container to the existing JScrollPane
    OrderScrollPane.setViewportView(cartOrderPanelContainer);
    OrderScrollPane.setAlignmentX(LEFT_ALIGNMENT);  // Ensure the alignment is set to the left
    TotalTextfield.setText(String.format("%.2f", totalAmount));
    
    revalidate();
    repaint();

    // Debugging print statement
    System.out.println("Displaying CartItems completed.");
}
    
    private double calculateTotalAmount(List<FoodItem> cartItems) {
        double totalAmount = 0;

        for (FoodItem item : cartItems) {
            if (item.getUserQuantity() >= 1) {
                totalAmount += item.getPrice() * item.getUserQuantity();
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


private int calculateUniqueItemsCount(List<FoodItem> cartItems) {
    // Use a set to store unique food item names
    Set<String> uniqueItemNames = new HashSet<>();

    for (FoodItem item : cartItems) {
        if (item.getUserQuantity() >= 1) {
            uniqueItemNames.add(item.getName());
        }
    }

    // Return the count of unique food items
    return uniqueItemNames.size();
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

    
    private void payButtonActionPerformed(java.awt.event.ActionEvent evt) {
        // Get the payment amount entered by the user
        double paymentAmount = Double.parseDouble(PaymentTextfield.getText());

        // Calculate the change
        double totalAmount = Double.parseDouble(TotalTextfield.getText());
        double change = paymentAmount - totalAmount;

        // Set the ChangeTextfield to display the change
        ChangeTextfield.setText(String.format("%.2f", change));
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
        QuantityLabel = new javax.swing.JLabel();
        ProductDetailsLabel = new javax.swing.JLabel();
        PriceTotalLabel = new javax.swing.JLabel();
        TotalQuantityLabel = new javax.swing.JLabel();
        OrderSummaryPanel = new javax.swing.JPanel();
        ChangeLabel = new javax.swing.JLabel();
        OrderSummaryLabel = new javax.swing.JLabel();
        TotalLabel = new javax.swing.JLabel();
        PaymentLabel = new javax.swing.JLabel();
        PayButton = new com.app.assets.ColoredButton();
        TotalTextfield = new javax.swing.JTextField();
        PaymentTextfield = new javax.swing.JTextField();
        ChangeTextfield = new javax.swing.JTextField();

        setBackground(new java.awt.Color(241, 242, 237));
        setPreferredSize(new java.awt.Dimension(1600, 900));

        OrderScrollPane.setBackground(new java.awt.Color(241, 242, 237));
        OrderScrollPane.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        OrderScrollPane.setHorizontalScrollBar(null);
        OrderScrollPane.setPreferredSize(new java.awt.Dimension(1100, 900));

        ShoppingCartLabel.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        ShoppingCartLabel.setText("Shopping Cart");

        QuantityLabel.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        QuantityLabel.setText("Quantity");

        ProductDetailsLabel.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        ProductDetailsLabel.setText("Product Details");

        PriceTotalLabel.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        PriceTotalLabel.setText("Price Total");

        TotalQuantityLabel.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        TotalQuantityLabel.setText("0 Items");

        OrderSummaryPanel.setBackground(new java.awt.Color(191, 191, 191));

        ChangeLabel.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        ChangeLabel.setText("Change");

        OrderSummaryLabel.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        OrderSummaryLabel.setText("Order Summary");

        TotalLabel.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        TotalLabel.setText("Total");

        PaymentLabel.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        PaymentLabel.setText("Payment");

        PayButton.setText("PAY");

        TotalTextfield.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        TotalTextfield.setText("0.00");
        TotalTextfield.setEnabled(false);
        TotalTextfield.setPreferredSize(new java.awt.Dimension(71, 32));

        PaymentTextfield.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        PaymentTextfield.setText("0.00");
        PaymentTextfield.setPreferredSize(new java.awt.Dimension(71, 32));

        ChangeTextfield.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        ChangeTextfield.setText("0.00");
        ChangeTextfield.setEnabled(false);
        ChangeTextfield.setPreferredSize(new java.awt.Dimension(71, 32));

        javax.swing.GroupLayout OrderSummaryPanelLayout = new javax.swing.GroupLayout(OrderSummaryPanel);
        OrderSummaryPanel.setLayout(OrderSummaryPanelLayout);
        OrderSummaryPanelLayout.setHorizontalGroup(
            OrderSummaryPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, OrderSummaryPanelLayout.createSequentialGroup()
                .addGroup(OrderSummaryPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(OrderSummaryPanelLayout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addGroup(OrderSummaryPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(OrderSummaryPanelLayout.createSequentialGroup()
                                .addComponent(ChangeLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(ChangeTextfield, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(OrderSummaryPanelLayout.createSequentialGroup()
                                .addComponent(TotalLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(TotalTextfield, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(OrderSummaryPanelLayout.createSequentialGroup()
                                .addComponent(PaymentLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(PaymentTextfield, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(OrderSummaryPanelLayout.createSequentialGroup()
                        .addContainerGap(29, Short.MAX_VALUE)
                        .addComponent(PayButton, javax.swing.GroupLayout.PREFERRED_SIZE, 692, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(31, 31, 31))
            .addGroup(OrderSummaryPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(OrderSummaryPanelLayout.createSequentialGroup()
                    .addGap(25, 25, 25)
                    .addComponent(OrderSummaryLabel)
                    .addContainerGap(461, Short.MAX_VALUE)))
        );
        OrderSummaryPanelLayout.setVerticalGroup(
            OrderSummaryPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, OrderSummaryPanelLayout.createSequentialGroup()
                .addContainerGap(119, Short.MAX_VALUE)
                .addGroup(OrderSummaryPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TotalLabel)
                    .addComponent(TotalTextfield, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(OrderSummaryPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(PaymentLabel)
                    .addComponent(PaymentTextfield, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(OrderSummaryPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ChangeLabel)
                    .addComponent(ChangeTextfield, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(35, 35, 35)
                .addComponent(PayButton, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28))
            .addGroup(OrderSummaryPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(OrderSummaryPanelLayout.createSequentialGroup()
                    .addGap(42, 42, 42)
                    .addComponent(OrderSummaryLabel)
                    .addContainerGap(304, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(236, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(ShoppingCartLabel)
                                .addGap(744, 744, 744)
                                .addComponent(TotalQuantityLabel))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addGap(112, 112, 112)
                                    .addComponent(ProductDetailsLabel)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(QuantityLabel)
                                    .addGap(237, 237, 237)
                                    .addComponent(PriceTotalLabel)
                                    .addGap(114, 114, 114))
                                .addComponent(OrderScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGap(255, 255, 255))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(OrderSummaryPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(442, 442, 442))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TotalQuantityLabel)
                    .addComponent(ShoppingCartLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ProductDetailsLabel)
                    .addComponent(QuantityLabel)
                    .addComponent(PriceTotalLabel))
                .addGap(18, 18, 18)
                .addComponent(OrderScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 365, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(OrderSummaryPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel ChangeLabel;
    private javax.swing.JTextField ChangeTextfield;
    private javax.swing.JScrollPane OrderScrollPane;
    private javax.swing.JLabel OrderSummaryLabel;
    private javax.swing.JPanel OrderSummaryPanel;
    private com.app.assets.ColoredButton PayButton;
    private javax.swing.JLabel PaymentLabel;
    private javax.swing.JTextField PaymentTextfield;
    private javax.swing.JLabel PriceTotalLabel;
    private javax.swing.JLabel ProductDetailsLabel;
    private javax.swing.JLabel QuantityLabel;
    private javax.swing.JLabel ShoppingCartLabel;
    private javax.swing.JLabel TotalLabel;
    private javax.swing.JLabel TotalQuantityLabel;
    private javax.swing.JTextField TotalTextfield;
    // End of variables declaration//GEN-END:variables
}
