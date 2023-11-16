/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.app.assets;

import javax.swing.JLabel;

/**
 *
 * @author Kirin
 */
public class CartOrderPanel extends javax.swing.JPanel {

    private String foodName;
    private String foodDescription;
    private double foodPrice;
    private int foodQuantity;

   public CartOrderPanel(String name, String description, double price, int quantity) {
        initComponents();
        setOpaque(false);

        this.foodName = name;
        this.foodDescription = description;
        this.foodPrice = price;
        this.foodQuantity = quantity;

        // Set the values in your labels or components here
        NameLabel.setText(foodName);
        DescriptionLabel.setText(foodDescription);
        PriceLabel.setText(String.valueOf(foodPrice));
        QuantityLabel.setText(String.valueOf(foodQuantity));

        // Debugging print statements
        System.out.println("Creating CartOrderPanel for: " + foodName);
    }


    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        NameLabel = new javax.swing.JLabel();
        DescriptionLabel = new javax.swing.JLabel();
        PriceLabel = new javax.swing.JLabel();
        QuantityLabel = new javax.swing.JLabel();

        setBackground(new java.awt.Color(241, 242, 237));
        setPreferredSize(new java.awt.Dimension(1100, 200));
        setRequestFocusEnabled(false);

        NameLabel.setText("Food Name");

        DescriptionLabel.setText("FoodDescription");

        PriceLabel.setText("Food Price");

        QuantityLabel.setText("FoodQuantity");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(123, 123, 123)
                .addComponent(NameLabel)
                .addGap(207, 207, 207)
                .addComponent(DescriptionLabel)
                .addGap(219, 219, 219)
                .addComponent(PriceLabel)
                .addGap(115, 115, 115)
                .addComponent(QuantityLabel)
                .addContainerGap(158, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(93, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(NameLabel)
                    .addComponent(DescriptionLabel)
                    .addComponent(PriceLabel)
                    .addComponent(QuantityLabel))
                .addGap(91, 91, 91))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel DescriptionLabel;
    private javax.swing.JLabel NameLabel;
    private javax.swing.JLabel PriceLabel;
    private javax.swing.JLabel QuantityLabel;
    // End of variables declaration//GEN-END:variables
}
