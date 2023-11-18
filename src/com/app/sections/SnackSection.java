/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.app.sections;

import com.app.assets.OrderPanel;
import com.app.details.FoodItem;
import com.app.details.FoodStorage;
import com.app.main.HomePage;
import com.app.transaction.CartSection;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.SwingUtilities;

/**
 *
 * @author Kirin
 */
public class SnackSection extends javax.swing.JPanel {

    CartSection cartSection = new CartSection();
    
    public SnackSection() {
        initComponents();
        FoodStorage.getInstance().clear();
        FoodStorage.getInstance().addFoodItem(new FoodItem("12", "Lays", new ImageIcon(getClass().getResource("/com/app/images/lays.png")), 120.0, "Potato Chips"));
        FoodStorage.getInstance().addFoodItem(new FoodItem("13", "Popcorn", new ImageIcon(getClass().getResource("/com/app/images/popcorn.png")), 110.0, "Kernel Corn"));
        FoodStorage.getInstance().addFoodItem(new FoodItem("14", "Nova", new ImageIcon(getClass().getResource("/com/app/images/nova.png")), 80.0, "Local Snack"));
        FoodStorage.getInstance().addFoodItem(new FoodItem("15", "Lollipop", new ImageIcon(getClass().getResource("/com/app/images/lollipop.png")), 35.0, "Sweet Treat"));
        FoodStorage.getInstance().addFoodItem(new FoodItem("16", "Honey Butter Chips", new ImageIcon(getClass().getResource("/com/app/images/honeybutterchips.png")), 97.0, "Potato Chips"));
        
        initializeUI();
    }
    
    private void addOrderPanelToContainer(OrderPanel orderPanel) {
        SnackSectionBG.add(orderPanel);
    }

    private void initializeUI() {
        List<OrderPanel> foodNamePanels = Arrays.asList(LaysPanel, DoritosPanel, NovaPanel, PiattosPanel, PringlesPanel);
        List<FoodItem> foodItems = FoodStorage.getInstance().getFoodItems();

        for (int i = 0; i < Math.min(foodNamePanels.size(), foodItems.size()); i++) {
            OrderPanel foodNamePan = foodNamePanels.get(i);
            FoodItem foodItem = foodItems.get(i);

            foodNamePan.setFoodName(foodItem.getName());
            foodNamePan.setFoodDescription(foodItem.getDescription());
            foodNamePan.setFoodPrice(foodItem.getPrice());  // Assuming getPrice() returns a double
            foodNamePan.setOrderId(foodItem.getOrderId());
            foodNamePan.setOrderImage(foodItem.getImageIcon());  // Assuming getImageIcon() returns the ImageIcon

            // Add the existing OrderPanel to the container
            addOrderPanelToContainer(foodNamePan);

            // Create the AddToCartListener here and add it to the CartButton
            AddToCartListener addToCartListener = new AddToCartListener(foodItem, foodNamePan);

            // Assuming you added the getCartButton method to your OrderPanel class
            JButton cartButton = foodNamePan.getCartButton();
            if (cartButton != null) {
                cartButton.addActionListener(addToCartListener);
            } else {
                System.err.println("CartButton not found in OrderPanel.");
            }
        }
    }

    private class AddToCartListener implements ActionListener {
    private FoodItem foodItem;
    private OrderPanel orderPanel;

    public AddToCartListener(FoodItem foodItem, OrderPanel orderPanel) {
        this.foodItem = foodItem;
        this.orderPanel = orderPanel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // Get the quantity from the OrderPanel
        int quantity = orderPanel.getQuantity();

        // Update the FoodItem with the obtained quantity
        foodItem.setUserQuantity(quantity);

        // Add the FoodItem to the cart
        HomePage homePage = (HomePage) SwingUtilities.getWindowAncestor(SnackSection.this);
        homePage.addItemToCart(foodItem);

        // Print a message to confirm that the item has been added
        //System.out.println("Item added to cart: " + foodItem.getName());
        //cartSection.displayCartItems();
    }
    
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        SnackSectionBG = new javax.swing.JPanel();
        SnacksLabel = new javax.swing.JLabel();
        LaysPanel = new com.app.assets.OrderPanel();
        DoritosPanel = new com.app.assets.OrderPanel();
        NovaPanel = new com.app.assets.OrderPanel();
        PiattosPanel = new com.app.assets.OrderPanel();
        PringlesPanel = new com.app.assets.OrderPanel();

        setBackground(new java.awt.Color(145, 196, 131));
        setPreferredSize(new java.awt.Dimension(1600, 900));

        SnackSectionBG.setBackground(new java.awt.Color(145, 196, 131));

        SnacksLabel.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        SnacksLabel.setText("Snacks");

        javax.swing.GroupLayout SnackSectionBGLayout = new javax.swing.GroupLayout(SnackSectionBG);
        SnackSectionBG.setLayout(SnackSectionBGLayout);
        SnackSectionBGLayout.setHorizontalGroup(
            SnackSectionBGLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(SnackSectionBGLayout.createSequentialGroup()
                .addGap(90, 90, 90)
                .addGroup(SnackSectionBGLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(SnackSectionBGLayout.createSequentialGroup()
                        .addComponent(SnacksLabel)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(SnackSectionBGLayout.createSequentialGroup()
                        .addGroup(SnackSectionBGLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(SnackSectionBGLayout.createSequentialGroup()
                                .addComponent(LaysPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 95, Short.MAX_VALUE)
                                .addComponent(DoritosPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 95, Short.MAX_VALUE)
                                .addComponent(NovaPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(SnackSectionBGLayout.createSequentialGroup()
                                .addGap(202, 202, 202)
                                .addComponent(PiattosPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(151, 151, 151)
                                .addComponent(PringlesPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addGap(90, 90, 90))))
        );
        SnackSectionBGLayout.setVerticalGroup(
            SnackSectionBGLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(SnackSectionBGLayout.createSequentialGroup()
                .addGap(68, 68, 68)
                .addGroup(SnackSectionBGLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(SnackSectionBGLayout.createSequentialGroup()
                        .addComponent(SnacksLabel)
                        .addGap(40, 40, 40)
                        .addComponent(LaysPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(NovaPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(DoritosPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(58, 58, 58)
                .addGroup(SnackSectionBGLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(PiattosPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(PringlesPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(126, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(SnackSectionBG, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(SnackSectionBG, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.app.assets.OrderPanel DoritosPanel;
    private com.app.assets.OrderPanel LaysPanel;
    private com.app.assets.OrderPanel NovaPanel;
    private com.app.assets.OrderPanel PiattosPanel;
    private com.app.assets.OrderPanel PringlesPanel;
    private javax.swing.JPanel SnackSectionBG;
    private javax.swing.JLabel SnacksLabel;
    // End of variables declaration//GEN-END:variables
}
