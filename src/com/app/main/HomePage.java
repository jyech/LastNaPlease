/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.app.main;

import com.app.assets.OrderPanel;
import com.app.details.FoodItem;
import com.app.details.FoodStorage;
import com.app.sections.ProduceSection;
import com.app.transaction.CartSection;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

/**
 *
 * @author Kirin
 */
public class HomePage extends javax.swing.JFrame {
    
    
    private List<FoodItem> cartItems; 
    private CartSection cartSection;
    private String currentPage; 
    private String previousPage;
   
    public HomePage() {
        initComponents();
        cartSection = CartMainPage;
        cartItems = new ArrayList<>();
        currentPage = "card2";
        
        //BackButtons
        ActionListener backButtonListener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            JButton sourceButton = (JButton) e.getSource();
            ((HomePage) SwingUtilities.getWindowAncestor(sourceButton)).switchToCategorySection();
        }
     };
        
        ProduceGoToCartButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            switchToCartSection();
        }
    });
        
        CheckOutButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                switchToCheckoutSection();
            }
        });
        
        BackToShopButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                switchToPreviousSection();
            }
        });
        
        BackToCartButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                switchToPreviousSection();
            }
        });
        
     ProduceBackButton.addActionListener(backButtonListener);
     BeverageBackButton.addActionListener(backButtonListener);
     SnackBackButton.addActionListener(backButtonListener);   
     MeatBackButton.addActionListener(backButtonListener);
     SeafoodBackButton.addActionListener(backButtonListener);
    }
    
    
    public void switchToProduceSection() {
        previousPage = currentPage;
        CardLayout cardLayout = (CardLayout) getContentPane().getLayout();
        cardLayout.show(getContentPane(), "card3");
        currentPage = "card3";
    }

    public void switchToBeverageSection() {
        previousPage = currentPage;
        CardLayout cardLayout = (CardLayout) getContentPane().getLayout();
        cardLayout.show(getContentPane(), "card4");
        currentPage = "card4";
    }

    public void switchToSnackSection() {
        previousPage = currentPage;
        CardLayout cardLayout = (CardLayout) getContentPane().getLayout();
        cardLayout.show(getContentPane(), "card5");
        currentPage = "card5";
    }

    public void switchToMeatSection() {
        previousPage = currentPage;
        CardLayout cardLayout = (CardLayout) getContentPane().getLayout();
        cardLayout.show(getContentPane(), "card6");
        currentPage = "card6";
    }

    public void switchToSeafoodSection() {
        previousPage = currentPage;
        CardLayout cardLayout = (CardLayout) getContentPane().getLayout();
        cardLayout.show(getContentPane(), "card7");
        currentPage = "card7";
    }

    public void switchToCategorySection() {
        previousPage = currentPage;
        CardLayout cardLayout = (CardLayout) getContentPane().getLayout();
        cardLayout.show(getContentPane(), "card2");
        currentPage = "card2";
    }

    public void switchToCartSection() {
        previousPage = currentPage;
        CardLayout cardLayout = (CardLayout) getContentPane().getLayout();
        cardLayout.show(getContentPane(), "card8");
        cartSection.displayCartItems(cartItems);
        currentPage = "card8";
    }

    public void switchToCheckoutSection() {
        CardLayout cardLayout = (CardLayout) getContentPane().getLayout();
        cardLayout.show(getContentPane(), "card9");
        currentPage = "card9";
    }

    private void switchToPreviousSection() {
        System.out.println("Current Page: " + currentPage);
        // Determine the current page and switch back accordingly
        switch (previousPage) {
            case "card3":
                switchToProduceSection();
                break;
            case "card4":
                switchToBeverageSection();
                break;
            case "card5":
                switchToSnackSection();
                break;
            case "card6":
                switchToMeatSection();
                break;
            case "card7":
                switchToSeafoodSection();
                break;
            case "card8":
                switchToCartSection();
                break;
            case "card9":
                switchToCheckoutSection();
                break;
            default:
                // Default to the category section if the current page is unknown
                switchToCategorySection();
                break;
        }
    }



    
    public void addItemToCart(FoodItem foodItem) {
        cartItems.add(foodItem);
    }
  

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        CategoryPage = new javax.swing.JPanel();
        CategorySection = new com.app.sections.CategorySection();
        ProducePage = new javax.swing.JPanel();
        ProduceGoToCartButton = new com.app.assets.ColoredButton();
        ProduceBackButton = new com.app.assets.ColoredButton();
        ProduceSection = new com.app.sections.ProduceSection();
        BeveragePage = new javax.swing.JPanel();
        BeverageBackButton = new com.app.assets.ColoredButton();
        BeverageSection = new com.app.sections.BeverageSection();
        SnackPage = new javax.swing.JPanel();
        SnackBackButton = new com.app.assets.ColoredButton();
        SnackSection = new com.app.sections.SnackSection();
        MeatPage = new javax.swing.JPanel();
        MeatBackButton = new com.app.assets.ColoredButton();
        MeatSection = new com.app.sections.MeatSection();
        SeafoodPage = new javax.swing.JPanel();
        SeafoodBackButton = new com.app.assets.ColoredButton();
        SeafoodSection = new com.app.sections.SeafoodSection();
        CartPage = new javax.swing.JPanel();
        CheckOutButton = new com.app.assets.ColoredButton();
        BackToShopButton = new com.app.assets.ColoredButton();
        CartMainPage = new com.app.transaction.CartSection();
        CheckoutPage = new javax.swing.JPanel();
        BackToCartButton = new com.app.assets.ColoredButton();
        CheckOutSection = new com.app.transaction.CheckoutSection();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(new java.awt.CardLayout());

        CategoryPage.setPreferredSize(new java.awt.Dimension(1280, 720));

        CategorySection.setMaximumSize(new java.awt.Dimension(1600, 900));
        CategorySection.setMinimumSize(new java.awt.Dimension(1600, 900));

        javax.swing.GroupLayout CategoryPageLayout = new javax.swing.GroupLayout(CategoryPage);
        CategoryPage.setLayout(CategoryPageLayout);
        CategoryPageLayout.setHorizontalGroup(
            CategoryPageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(CategorySection, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        CategoryPageLayout.setVerticalGroup(
            CategoryPageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(CategorySection, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        getContentPane().add(CategoryPage, "card2");

        ProducePage.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        ProduceGoToCartButton.setText("C");
        ProduceGoToCartButton.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        ProduceGoToCartButton.setRadius(100);
        ProducePage.add(ProduceGoToCartButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(1420, 40, 50, 50));

        ProduceBackButton.setText("<-");
        ProduceBackButton.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        ProduceBackButton.setRadius(100);
        ProducePage.add(ProduceBackButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, 50, 50));
        ProducePage.add(ProduceSection, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        getContentPane().add(ProducePage, "card3");

        BeveragePage.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        BeverageBackButton.setText("<-");
        BeverageBackButton.setRadius(100);
        BeveragePage.add(BeverageBackButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 30, 50, 50));
        BeveragePage.add(BeverageSection, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        getContentPane().add(BeveragePage, "card4");

        SnackPage.setPreferredSize(new java.awt.Dimension(1280, 720));
        SnackPage.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        SnackBackButton.setText("<-");
        SnackBackButton.setRadius(100);
        SnackPage.add(SnackBackButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 30, 50, 50));
        SnackPage.add(SnackSection, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        getContentPane().add(SnackPage, "card5");

        MeatPage.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        MeatBackButton.setText("<-");
        MeatBackButton.setRadius(100);
        MeatPage.add(MeatBackButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 30, 50, 50));
        MeatPage.add(MeatSection, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        getContentPane().add(MeatPage, "card6");

        SeafoodPage.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        SeafoodBackButton.setText("<-");
        SeafoodBackButton.setRadius(100);
        SeafoodPage.add(SeafoodBackButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 30, 50, 50));
        SeafoodPage.add(SeafoodSection, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        getContentPane().add(SeafoodPage, "card7");

        CartPage.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        CheckOutButton.setText("CHECKOUT");
        CartPage.add(CheckOutButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(1140, 800, 420, 60));

        BackToShopButton.setText("<-");
        BackToShopButton.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        BackToShopButton.setRadius(100);
        CartPage.add(BackToShopButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, 50, 50));
        CartPage.add(CartMainPage, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        getContentPane().add(CartPage, "card8");

        CheckoutPage.setPreferredSize(new java.awt.Dimension(1280, 720));
        CheckoutPage.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        BackToCartButton.setText("<-");
        BackToCartButton.setRadius(100);
        CheckoutPage.add(BackToCartButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 30, 50, 50));
        CheckoutPage.add(CheckOutSection, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        getContentPane().add(CheckoutPage, "card9");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(HomePage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(HomePage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(HomePage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(HomePage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new HomePage().setVisible(true);
            }
        });
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
        HomePage.this.addItemToCart(foodItem);  

        // Print a message to confirm that the item has been added
        System.out.println("Item added to cart: " + foodItem.getName());
    }
}
  

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.app.assets.ColoredButton BackToCartButton;
    private com.app.assets.ColoredButton BackToShopButton;
    private com.app.assets.ColoredButton BeverageBackButton;
    private javax.swing.JPanel BeveragePage;
    private com.app.sections.BeverageSection BeverageSection;
    private com.app.transaction.CartSection CartMainPage;
    private javax.swing.JPanel CartPage;
    private javax.swing.JPanel CategoryPage;
    private com.app.sections.CategorySection CategorySection;
    private com.app.assets.ColoredButton CheckOutButton;
    private com.app.transaction.CheckoutSection CheckOutSection;
    private javax.swing.JPanel CheckoutPage;
    private com.app.assets.ColoredButton MeatBackButton;
    private javax.swing.JPanel MeatPage;
    private com.app.sections.MeatSection MeatSection;
    private com.app.assets.ColoredButton ProduceBackButton;
    private com.app.assets.ColoredButton ProduceGoToCartButton;
    private javax.swing.JPanel ProducePage;
    private com.app.sections.ProduceSection ProduceSection;
    private com.app.assets.ColoredButton SeafoodBackButton;
    private javax.swing.JPanel SeafoodPage;
    private com.app.sections.SeafoodSection SeafoodSection;
    private com.app.assets.ColoredButton SnackBackButton;
    private javax.swing.JPanel SnackPage;
    private com.app.sections.SnackSection SnackSection;
    // End of variables declaration//GEN-END:variables
}
