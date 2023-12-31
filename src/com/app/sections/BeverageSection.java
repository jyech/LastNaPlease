/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.app.sections;

import com.app.assets.OrderPanel;
import com.app.assets.ProductDetailsPanel;
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
public class BeverageSection extends javax.swing.JPanel {

    CartSection cartSection = new CartSection();
    
    public BeverageSection() {
        initComponents();
        FoodStorage.getInstance().clear();
        FoodStorage.getInstance().addFoodItem(new FoodItem("7", "Coke", new ImageIcon(getClass().getResource("/com/app/images/coke.png")), 33.0, "Carbonated Drink", 1));
        FoodStorage.getInstance().addFoodItem(new FoodItem("8", "Milk", new ImageIcon(getClass().getResource("/com/app/images/milk.png")), 99.0, "Dairy Cow's Milk", 1));
        FoodStorage.getInstance().addFoodItem(new FoodItem("9", "Soju", new ImageIcon(getClass().getResource("/com/app/images/sojus.png")), 102.0, "Distilled Alcoholic Drink", 1));
        FoodStorage.getInstance().addFoodItem(new FoodItem("10", "Yakult", new ImageIcon(getClass().getResource("/com/app/images/yakult.png")), 53.0, "Probiotic Drink", 1));
        FoodStorage.getInstance().addFoodItem(new FoodItem("11", "Sprite", new ImageIcon(getClass().getResource("/com/app/images/sprite.png")), 30.0, "Carbonated Drink", 1));
        
        initializeUI();
    }
    
    public void ReinitializeUI() {
        List<OrderPanel> foodNamePanels = Arrays.asList(CokePanel, CowheadPanel, SojuPanel, YakultPanel, ChuckiePanel);
        HomePage homepage = (HomePage)SwingUtilities.getWindowAncestor(BeverageSection.this);

        for (int i = 0; i < foodNamePanels.size(); i++) {
            OrderPanel foodNamePan = foodNamePanels.get(i);

            boolean isInCart = false; // default to false on startup
            
            if (homepage != null) {
                isInCart = homepage.isInCart(foodNamePan.getFoodName()); // Check if its in cart
            }
            
            foodNamePan.toggleAddToCartButton(!isInCart);
            
            // Add the existing OrderPanel to the container
            addOrderPanelToContainer(foodNamePan);
        }
    }
    
    private void addOrderPanelToContainer(OrderPanel orderPanel) {
        BeverageSectionBG.add(orderPanel);
    }

    private void initializeUI() {
        List<OrderPanel> foodNamePanels = Arrays.asList(CokePanel, CowheadPanel, SojuPanel, YakultPanel, ChuckiePanel);
        List<FoodItem> foodItems = FoodStorage.getInstance().getFoodItems();
        HomePage homepage = (HomePage)SwingUtilities.getWindowAncestor(BeverageSection.this);

        for (int i = 0; i < Math.min(foodNamePanels.size(), foodItems.size()); i++) {
            OrderPanel foodNamePan = foodNamePanels.get(i);
            FoodItem foodItem = foodItems.get(i);

            foodNamePan.setFoodName(foodItem.getName());
            foodNamePan.setFoodDescription(foodItem.getDescription());
            foodNamePan.setFoodPrice(foodItem.getPrice());  // Assuming getPrice() returns a double
            foodNamePan.setOrderId(foodItem.getOrderId());
            foodNamePan.setOrderImage(foodItem.getImageIcon());  // Assuming getImageIcon() returns the ImageIcon
            
            System.out.println("is it still null");
            System.out.println(homepage);
            boolean isInCart = false; // default to false on startup
            if (homepage != null)
                isInCart = homepage.isInCart(foodItem.getName()); // Check if its in cart
            
            foodNamePan.toggleAddToCartButton(!isInCart);
            
            // Add the existing OrderPanel to the container
            addOrderPanelToContainer(foodNamePan);
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

        BeverageSectionBG = new javax.swing.JPanel();
        BeveragesLabel = new javax.swing.JLabel();
        CokePanel = new com.app.assets.OrderPanel();
        CowheadPanel = new com.app.assets.OrderPanel();
        SojuPanel = new com.app.assets.OrderPanel();
        YakultPanel = new com.app.assets.OrderPanel();
        ChuckiePanel = new com.app.assets.OrderPanel();

        setPreferredSize(new java.awt.Dimension(1600, 900));

        BeverageSectionBG.setBackground(new java.awt.Color(145, 196, 131));

        BeveragesLabel.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        BeveragesLabel.setText("Beverages");

        javax.swing.GroupLayout BeverageSectionBGLayout = new javax.swing.GroupLayout(BeverageSectionBG);
        BeverageSectionBG.setLayout(BeverageSectionBGLayout);
        BeverageSectionBGLayout.setHorizontalGroup(
            BeverageSectionBGLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(BeverageSectionBGLayout.createSequentialGroup()
                .addGap(90, 90, 90)
                .addGroup(BeverageSectionBGLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(BeverageSectionBGLayout.createSequentialGroup()
                        .addComponent(BeveragesLabel)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(BeverageSectionBGLayout.createSequentialGroup()
                        .addGroup(BeverageSectionBGLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(BeverageSectionBGLayout.createSequentialGroup()
                                .addComponent(CokePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 95, Short.MAX_VALUE)
                                .addComponent(CowheadPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 95, Short.MAX_VALUE)
                                .addComponent(SojuPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(BeverageSectionBGLayout.createSequentialGroup()
                                .addGap(202, 202, 202)
                                .addComponent(YakultPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(151, 151, 151)
                                .addComponent(ChuckiePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addGap(90, 90, 90))))
        );
        BeverageSectionBGLayout.setVerticalGroup(
            BeverageSectionBGLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(BeverageSectionBGLayout.createSequentialGroup()
                .addGap(68, 68, 68)
                .addGroup(BeverageSectionBGLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(BeverageSectionBGLayout.createSequentialGroup()
                        .addComponent(BeveragesLabel)
                        .addGap(40, 40, 40)
                        .addComponent(CokePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(SojuPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CowheadPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(58, 58, 58)
                .addGroup(BeverageSectionBGLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(YakultPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ChuckiePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(126, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(BeverageSectionBG, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(BeverageSectionBG, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel BeverageSectionBG;
    private javax.swing.JLabel BeveragesLabel;
    private com.app.assets.OrderPanel ChuckiePanel;
    private com.app.assets.OrderPanel CokePanel;
    private com.app.assets.OrderPanel CowheadPanel;
    private com.app.assets.OrderPanel SojuPanel;
    private com.app.assets.OrderPanel YakultPanel;
    // End of variables declaration//GEN-END:variables
}
