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
import org.netbeans.lib.awtextra.AbsoluteLayout;

/**
 *
 * @author Kirin
 */
public class MeatSection extends javax.swing.JPanel {
    CartSection cartSection = new CartSection();

    public MeatSection() {
        initComponents();
        FoodStorage.getInstance().clear();
        FoodStorage.getInstance().addFoodItem(new FoodItem("22", "Chicken Wings", new ImageIcon(getClass().getResource("/com/app/images/foodimage.png")), 20.0, "Lays Description"));
        FoodStorage.getInstance().addFoodItem(new FoodItem("23", "Chicken Legs", new ImageIcon(getClass().getResource("/com/app/images/foodimage.png")), 20.0, "Doritos Description"));
        FoodStorage.getInstance().addFoodItem(new FoodItem("24", "Chicken Breast", new ImageIcon(getClass().getResource("/com/app/images/foodimage.png")), 20.0, "Nova Description"));
        FoodStorage.getInstance().addFoodItem(new FoodItem("25", "Pork Tenga", new ImageIcon(getClass().getResource("/com/app/images/foodimage.png")), 20.0, "Lays Description"));
        FoodStorage.getInstance().addFoodItem(new FoodItem("26", "Pork Liempo", new ImageIcon(getClass().getResource("/com/app/images/foodimage.png")), 20.0, "Doritos Description"));
        FoodStorage.getInstance().addFoodItem(new FoodItem("27", "Pork Ribs", new ImageIcon(getClass().getResource("/com/app/images/foodimage.png")), 20.0, "Nova Description"));
        FoodStorage.getInstance().addFoodItem(new FoodItem("28", "Pork Brisket", new ImageIcon(getClass().getResource("/com/app/images/foodimage.png")), 20.0, "Lays Description"));
        FoodStorage.getInstance().addFoodItem(new FoodItem("29", "Beef Shank", new ImageIcon(getClass().getResource("/com/app/images/foodimage.png")), 20.0, "Doritos Description"));
        FoodStorage.getInstance().addFoodItem(new FoodItem("30", "Beef Sirloin", new ImageIcon(getClass().getResource("/com/app/images/foodimage.png")), 20.0, "Nova Description"));
        
        initializeUI();
    }
    
    private void addOrderPanelToContainer(OrderPanel orderPanel) {
        MeatSectionBG.add(orderPanel);
    }

    private void initializeUI() {
        List<OrderPanel> foodNamePanels = Arrays.asList(ChickenWingsPanel, ChickenLegsPanel, ChickenBreastPanel, PorkTengaPanel, PorkLiempoPanel, PorkRibsPanel, BeefBrisketPanel, BeefShankPanel, BeefSirloinPanel);
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
        HomePage homePage = (HomePage) SwingUtilities.getWindowAncestor(MeatSection.this);
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

        MeatSectionBG = new javax.swing.JPanel();
        BeefLabel = new javax.swing.JLabel();
        ChickenWingsPanel = new com.app.assets.OrderPanel();
        ChickenLegsPanel = new com.app.assets.OrderPanel();
        ChickenBreastPanel = new com.app.assets.OrderPanel();
        PorkTengaPanel = new com.app.assets.OrderPanel();
        PorkLiempoPanel = new com.app.assets.OrderPanel();
        PorkRibsPanel = new com.app.assets.OrderPanel();
        BeefBrisketPanel = new com.app.assets.OrderPanel();
        BeefShankPanel = new com.app.assets.OrderPanel();
        BeefSirloinPanel = new com.app.assets.OrderPanel();
        ChickenLabel = new javax.swing.JLabel();
        PorkLabel = new javax.swing.JLabel();

        setPreferredSize(new java.awt.Dimension(1600, 1150));

        MeatSectionBG.setBackground(new java.awt.Color(241, 242, 237));
        MeatSectionBG.setPreferredSize(new java.awt.Dimension(1600, 12));

        BeefLabel.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        BeefLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        BeefLabel.setText("Beef");
        BeefLabel.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        ChickenLabel.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        ChickenLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ChickenLabel.setText("Chicken");
        ChickenLabel.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        PorkLabel.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        PorkLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        PorkLabel.setText("Pork");
        PorkLabel.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout MeatSectionBGLayout = new javax.swing.GroupLayout(MeatSectionBG);
        MeatSectionBG.setLayout(MeatSectionBGLayout);
        MeatSectionBGLayout.setHorizontalGroup(
            MeatSectionBGLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(ChickenLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 1600, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(PorkLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 1600, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(BeefLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 1600, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(MeatSectionBGLayout.createSequentialGroup()
                .addGap(90, 90, 90)
                .addGroup(MeatSectionBGLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(MeatSectionBGLayout.createSequentialGroup()
                        .addComponent(ChickenWingsPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(95, 95, 95)
                        .addComponent(ChickenLegsPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(95, 95, 95)
                        .addComponent(ChickenBreastPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(MeatSectionBGLayout.createSequentialGroup()
                        .addComponent(PorkTengaPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(95, 95, 95)
                        .addComponent(PorkLiempoPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(95, 95, 95)
                        .addComponent(PorkRibsPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(MeatSectionBGLayout.createSequentialGroup()
                        .addComponent(BeefBrisketPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(95, 95, 95)
                        .addComponent(BeefShankPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(105, 105, 105)
                        .addComponent(BeefSirloinPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );
        MeatSectionBGLayout.setVerticalGroup(
            MeatSectionBGLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MeatSectionBGLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(ChickenLabel)
                .addGap(12, 12, 12)
                .addGroup(MeatSectionBGLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ChickenWingsPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ChickenLegsPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ChickenBreastPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addComponent(PorkLabel)
                .addGap(22, 22, 22)
                .addGroup(MeatSectionBGLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(PorkTengaPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(PorkLiempoPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(PorkRibsPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addComponent(BeefLabel)
                .addGap(22, 22, 22)
                .addGroup(MeatSectionBGLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(BeefSirloinPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(MeatSectionBGLayout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addGroup(MeatSectionBGLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(BeefBrisketPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(BeefShankPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(MeatSectionBG, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(MeatSectionBG, javax.swing.GroupLayout.PREFERRED_SIZE, 1180, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.app.assets.OrderPanel BeefBrisketPanel;
    private javax.swing.JLabel BeefLabel;
    private com.app.assets.OrderPanel BeefShankPanel;
    private com.app.assets.OrderPanel BeefSirloinPanel;
    private com.app.assets.OrderPanel ChickenBreastPanel;
    private javax.swing.JLabel ChickenLabel;
    private com.app.assets.OrderPanel ChickenLegsPanel;
    private com.app.assets.OrderPanel ChickenWingsPanel;
    private javax.swing.JPanel MeatSectionBG;
    private javax.swing.JLabel PorkLabel;
    private com.app.assets.OrderPanel PorkLiempoPanel;
    private com.app.assets.OrderPanel PorkRibsPanel;
    private com.app.assets.OrderPanel PorkTengaPanel;
    // End of variables declaration//GEN-END:variables
}
