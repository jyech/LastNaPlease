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
public class SeafoodSection extends javax.swing.JPanel {
    
    CartSection cartSection = new CartSection();
    
    public SeafoodSection() {
        initComponents();
        FoodStorage.getInstance().clear();
        FoodStorage.getInstance().addFoodItem(new FoodItem("17", "Lobster", new ImageIcon(getClass().getResource("/com/app/images/lobster.png")), 110.0, "Seafood", 1));
        FoodStorage.getInstance().addFoodItem(new FoodItem("18", "Octopus", new ImageIcon(getClass().getResource("/com/app/images/octopus.png")), 220.0, "Seafood", 1));
        FoodStorage.getInstance().addFoodItem(new FoodItem("19", "Salmon", new ImageIcon(getClass().getResource("/com/app/images/salmon.png")), 250.0, "Seafood", 1));
        FoodStorage.getInstance().addFoodItem(new FoodItem("20", "Shrimp", new ImageIcon(getClass().getResource("/com/app/images/shrimp.png")), 180.0, "Seafood", 1));
        FoodStorage.getInstance().addFoodItem(new FoodItem("21", "Squid", new ImageIcon(getClass().getResource("/com/app/images/squid.png")), 120.0, "Seafood", 1));
        
        initializeUI();
    }
    
    public void ReinitializeUI() {
        List<OrderPanel> foodNamePanels = Arrays.asList(TilapiaPanel, BangusPanel, LapuLapuPanel, GalunggongPanel, SalmonPanel);
        HomePage homepage = (HomePage)SwingUtilities.getWindowAncestor(SeafoodSection.this);

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
        SnackSectionBG.add(orderPanel);
    }

    private void initializeUI() {
        List<OrderPanel> foodNamePanels = Arrays.asList(TilapiaPanel, BangusPanel, LapuLapuPanel, GalunggongPanel, SalmonPanel);
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
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        SnackSectionBG = new javax.swing.JPanel();
        SeafoodLabel = new javax.swing.JLabel();
        TilapiaPanel = new com.app.assets.OrderPanel();
        BangusPanel = new com.app.assets.OrderPanel();
        LapuLapuPanel = new com.app.assets.OrderPanel();
        GalunggongPanel = new com.app.assets.OrderPanel();
        SalmonPanel = new com.app.assets.OrderPanel();

        setBackground(new java.awt.Color(145, 196, 131));
        setPreferredSize(new java.awt.Dimension(1600, 900));

        SnackSectionBG.setBackground(new java.awt.Color(145, 196, 131));

        SeafoodLabel.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        SeafoodLabel.setText("Seafood");

        javax.swing.GroupLayout SnackSectionBGLayout = new javax.swing.GroupLayout(SnackSectionBG);
        SnackSectionBG.setLayout(SnackSectionBGLayout);
        SnackSectionBGLayout.setHorizontalGroup(
            SnackSectionBGLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(SnackSectionBGLayout.createSequentialGroup()
                .addGap(90, 90, 90)
                .addGroup(SnackSectionBGLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(SnackSectionBGLayout.createSequentialGroup()
                        .addComponent(SeafoodLabel)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(SnackSectionBGLayout.createSequentialGroup()
                        .addGroup(SnackSectionBGLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(SnackSectionBGLayout.createSequentialGroup()
                                .addComponent(TilapiaPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 89, Short.MAX_VALUE)
                                .addComponent(BangusPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 89, Short.MAX_VALUE)
                                .addComponent(LapuLapuPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(SnackSectionBGLayout.createSequentialGroup()
                                .addGap(202, 202, 202)
                                .addComponent(GalunggongPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(151, 151, 151)
                                .addComponent(SalmonPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addGap(90, 90, 90))))
        );
        SnackSectionBGLayout.setVerticalGroup(
            SnackSectionBGLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(SnackSectionBGLayout.createSequentialGroup()
                .addGap(68, 68, 68)
                .addGroup(SnackSectionBGLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(SnackSectionBGLayout.createSequentialGroup()
                        .addComponent(SeafoodLabel)
                        .addGap(40, 40, 40)
                        .addComponent(TilapiaPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(LapuLapuPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BangusPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(58, 58, 58)
                .addGroup(SnackSectionBGLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(GalunggongPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(SalmonPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(114, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(SnackSectionBG, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(SnackSectionBG, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.app.assets.OrderPanel BangusPanel;
    private com.app.assets.OrderPanel GalunggongPanel;
    private com.app.assets.OrderPanel LapuLapuPanel;
    private com.app.assets.OrderPanel SalmonPanel;
    private javax.swing.JLabel SeafoodLabel;
    private javax.swing.JPanel SnackSectionBG;
    private com.app.assets.OrderPanel TilapiaPanel;
    // End of variables declaration//GEN-END:variables
}
