/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.app.transaction;

import com.app.details.FoodItem;
import java.util.ArrayList;
import java.util.List;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

/**
 *
 * @author Kirin
 */
public class CheckoutSection extends javax.swing.JPanel {
    
    public enum DeliveryMethod {
        SAME_DAY,
        REGULAR,
        PICK_UP
    }
    public enum PaymentMethod {
        CASH,
        GCASH,
    }
    
    private List<FoodItem> cartItems;
    private DeliveryMethod currentDeliveryMethod;
    private PaymentMethod currentPaymentMethod;


    public CheckoutSection() {
        initComponents();
        List<FoodItem> initialCartItems = new ArrayList<>();
        displayCartItems(initialCartItems);
        // Add DocumentListener to FirstNameTextfield
        addDocumentListener(FirstNameTextfield);
        addDocumentListener(LastNameTextfield);
        addDocumentListener(MobileNumberTextfield);
        addDocumentListener(AddressTextfield);
        addDocumentListener(PaymentTextfield);
        
         SameDayButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            currentDeliveryMethod = DeliveryMethod.SAME_DAY;
            // Toggle the enabled state of Regular and Pick Up buttons
            RegularButton.setEnabled(!RegularButton.isEnabled());
            PickUpButton.setEnabled(!PickUpButton.isEnabled());
        }
    });

    RegularButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            currentDeliveryMethod = DeliveryMethod.REGULAR;
            // Toggle the enabled state of Same Day and Pick Up buttons
            SameDayButton.setEnabled(!SameDayButton.isEnabled());
            PickUpButton.setEnabled(!PickUpButton.isEnabled());
        }
    });

    PickUpButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            currentDeliveryMethod = DeliveryMethod.PICK_UP;
            // Toggle the enabled state of Same Day and Regular buttons
            SameDayButton.setEnabled(!SameDayButton.isEnabled());
            RegularButton.setEnabled(!RegularButton.isEnabled());
        }
});
    
    
    GCashButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            currentPaymentMethod = PaymentMethod.CASH;
            // Toggle the enabled state of Same Day and Regular buttons
            CashButton.setEnabled(!CashButton.isEnabled());
        }
    });
    
    CashButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            currentPaymentMethod = PaymentMethod.CASH;
            // Toggle the enabled state of Same Day and Regular buttons
            GCashButton.setEnabled(!GCashButton.isEnabled());
        }
    });
    
    }
    
    private void addDocumentListener(javax.swing.JTextField textField) {
        textField.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                updatePayButtonEnabled();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                updatePayButtonEnabled();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                updatePayButtonEnabled();
            }
            
            
            
        });
    }

    private void updatePayButtonEnabled() {
        // Enable PayButton if all specified text fields have text, otherwise disable it
        boolean allFieldsHaveText =
                !FirstNameTextfield.getText().trim().isEmpty() &&
                !LastNameTextfield.getText().trim().isEmpty() &&
                !MobileNumberTextfield.getText().trim().isEmpty() &&
                !AddressTextfield.getText().trim().isEmpty() &&
                !PaymentTextfield.getText().trim().isEmpty() &&
                currentDeliveryMethod != null &&
                currentPaymentMethod != null;

        PayButton.setEnabled(allFieldsHaveText);
    }
    
    
    
// Modify the displayCartItems method
public void displayCartItems(List<FoodItem> cartItems) {
    this.cartItems = cartItems;
    OrderListPanel.removeAll(); // Clear previous content
    OrderListPanel.setLayout(new BoxLayout(OrderListPanel, BoxLayout.Y_AXIS));

    for (FoodItem item : cartItems) {
        if (item.getUserQuantity() >= 1) {
            // Create JLabels for item information
            JLabel nameLabel = new JLabel(item.getName());
            nameLabel.setFont(new Font("Segoe UI", Font.BOLD, 24)); // Set the font with a larger size

            // Multiply the price by the quantity to get the total price for the item
            double totalPrice = item.getPrice() * item.getUserQuantity();
            JLabel priceLabel = new JLabel(String.format("Price: " + "%.2f", totalPrice));
            priceLabel.setFont(new Font("Segoe UI", Font.PLAIN, 20)); // Set the font with a larger size

            JLabel quantityLabel = new JLabel("Quantity: " + Integer.toString(item.getUserQuantity()));
            quantityLabel.setFont(new Font("Segoe UI", Font.PLAIN, 20)); // Set the font with a larger size

            // Add the JLabels to the OrderListPanel
            OrderListPanel.add(nameLabel);
            OrderListPanel.add(priceLabel);
            OrderListPanel.add(quantityLabel);
        }
    }

    // Revalidate and repaint the OrderListPanel
    OrderListPanel.revalidate();
    OrderListPanel.repaint();

    // Update the total field after displaying the cart items
    updateTotalField();
}



    
    public void updateTotalField() {
        // Implement the logic to update the total field here
        // For example, if you have a JLabel named TotalNumberLabel, you can update it like this:
        double totalAmount = calculateTotalAmount(cartItems);
        TotalNumberLabel.setText(String.format("%.2f", totalAmount));
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
    
    public void transferToCheckout(List<FoodItem> cartItems) {
        displayCartItems(cartItems);
        // You may also perform additional actions or calculations here
    }

 
     
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        CheckoutLabel = new javax.swing.JLabel();
        ContactInfoLabel = new javax.swing.JLabel();
        FirstNameTextfield = new javax.swing.JTextField();
        LastNameTextfield = new javax.swing.JTextField();
        MobileNumberTextfield = new javax.swing.JTextField();
        AddressTextfield = new javax.swing.JTextField();
        DeliveryMethodLabel = new javax.swing.JLabel();
        FirstNameLabel = new javax.swing.JLabel();
        LastNameLabel = new javax.swing.JLabel();
        MobileNumberLabel = new javax.swing.JLabel();
        AddressLabel = new javax.swing.JLabel();
        SameDayButton = new com.app.assets.ColoredButton();
        RegularButton = new com.app.assets.ColoredButton();
        PickUpButton = new com.app.assets.ColoredButton();
        PaymentMethodLabel = new javax.swing.JLabel();
        GCashButton = new com.app.assets.ColoredButton();
        CashButton = new com.app.assets.ColoredButton();
        ListOfItemsPanel = new javax.swing.JPanel();
        OrderListScroll = new javax.swing.JScrollPane();
        OrderListPanel = new javax.swing.JPanel();
        TotalLabel = new javax.swing.JLabel();
        PaymentLabel = new javax.swing.JLabel();
        ChangeLabel = new javax.swing.JLabel();
        TotalNumberLabel = new javax.swing.JLabel();
        ChangeNumberLabel = new javax.swing.JLabel();
        PaymentTextfield = new javax.swing.JTextField();
        ListOfItemsLabel = new javax.swing.JLabel();
        PayButton = new com.app.assets.ColoredButton();

        setBackground(new java.awt.Color(241, 242, 237));
        setPreferredSize(new java.awt.Dimension(1600, 900));

        CheckoutLabel.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        CheckoutLabel.setText("Checkout");

        ContactInfoLabel.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        ContactInfoLabel.setText("1. Contact Information");

        FirstNameTextfield.setBackground(new java.awt.Color(214, 211, 199));
        FirstNameTextfield.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        FirstNameTextfield.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        FirstNameTextfield.setSelectionColor(new java.awt.Color(160, 157, 149));

        LastNameTextfield.setBackground(new java.awt.Color(214, 211, 199));
        LastNameTextfield.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        LastNameTextfield.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        LastNameTextfield.setSelectionColor(new java.awt.Color(160, 157, 149));

        MobileNumberTextfield.setBackground(new java.awt.Color(214, 211, 199));
        MobileNumberTextfield.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        MobileNumberTextfield.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        MobileNumberTextfield.setSelectionColor(new java.awt.Color(160, 157, 149));

        AddressTextfield.setBackground(new java.awt.Color(214, 211, 199));
        AddressTextfield.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        AddressTextfield.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        AddressTextfield.setSelectionColor(new java.awt.Color(160, 157, 149));

        DeliveryMethodLabel.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        DeliveryMethodLabel.setText("2. Delivery Method");

        FirstNameLabel.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        FirstNameLabel.setText("First Name");

        LastNameLabel.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        LastNameLabel.setText("Last Name");

        MobileNumberLabel.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        MobileNumberLabel.setText("Mobile Number");

        AddressLabel.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        AddressLabel.setText("Address");

        SameDayButton.setText("SAME DAY");

        RegularButton.setText("REGULAR");

        PickUpButton.setText("PICK - UP");

        PaymentMethodLabel.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        PaymentMethodLabel.setText("3. Payment Method");

        GCashButton.setText("GCASH");

        CashButton.setText("CASH");

        ListOfItemsPanel.setBackground(new java.awt.Color(241, 242, 237));
        ListOfItemsPanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));

        OrderListScroll.setHorizontalScrollBar(null);

        OrderListPanel.setBackground(new java.awt.Color(241, 242, 237));
        OrderListPanel.setLayout(new javax.swing.BoxLayout(OrderListPanel, javax.swing.BoxLayout.LINE_AXIS));
        OrderListScroll.setViewportView(OrderListPanel);

        TotalLabel.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        TotalLabel.setText("Total");

        PaymentLabel.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        PaymentLabel.setText("Payment");

        ChangeLabel.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        ChangeLabel.setText("Change");

        TotalNumberLabel.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        TotalNumberLabel.setText("0.00");

        ChangeNumberLabel.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        ChangeNumberLabel.setText("0.00");

        PaymentTextfield.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        PaymentTextfield.setText("0.00");
        PaymentTextfield.setPreferredSize(new java.awt.Dimension(99, 32));

        ListOfItemsLabel.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        ListOfItemsLabel.setText("List of Items");

        javax.swing.GroupLayout ListOfItemsPanelLayout = new javax.swing.GroupLayout(ListOfItemsPanel);
        ListOfItemsPanel.setLayout(ListOfItemsPanelLayout);
        ListOfItemsPanelLayout.setHorizontalGroup(
            ListOfItemsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ListOfItemsPanelLayout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(ListOfItemsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ListOfItemsPanelLayout.createSequentialGroup()
                        .addGroup(ListOfItemsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(TotalLabel)
                            .addComponent(PaymentLabel))
                        .addGap(6, 6, Short.MAX_VALUE)
                        .addGroup(ListOfItemsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(ListOfItemsPanelLayout.createSequentialGroup()
                                .addComponent(PaymentTextfield, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(150, Short.MAX_VALUE))
                            .addGroup(ListOfItemsPanelLayout.createSequentialGroup()
                                .addComponent(TotalNumberLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addGroup(ListOfItemsPanelLayout.createSequentialGroup()
                        .addComponent(ChangeLabel)
                        .addGap(18, 18, 18)
                        .addComponent(ChangeNumberLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(ListOfItemsPanelLayout.createSequentialGroup()
                        .addGroup(ListOfItemsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(ListOfItemsPanelLayout.createSequentialGroup()
                                .addComponent(ListOfItemsLabel)
                                .addGap(0, 142, Short.MAX_VALUE))
                            .addComponent(OrderListScroll))
                        .addContainerGap())))
        );
        ListOfItemsPanelLayout.setVerticalGroup(
            ListOfItemsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ListOfItemsPanelLayout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(ListOfItemsLabel)
                .addGap(32, 32, 32)
                .addComponent(OrderListScroll, javax.swing.GroupLayout.DEFAULT_SIZE, 350, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(ListOfItemsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TotalLabel)
                    .addComponent(TotalNumberLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(ListOfItemsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(PaymentLabel)
                    .addComponent(PaymentTextfield, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(ListOfItemsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ChangeLabel)
                    .addComponent(ChangeNumberLabel))
                .addContainerGap(98, Short.MAX_VALUE))
        );

        PayButton.setText("PAY");
        PayButton.setEnabled(false);
        PayButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PayButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(126, 126, 126)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(SameDayButton, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(RegularButton, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(PickUpButton, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(DeliveryMethodLabel)
                    .addComponent(ContactInfoLabel)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(FirstNameTextfield, javax.swing.GroupLayout.PREFERRED_SIZE, 306, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(FirstNameLabel))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(LastNameLabel)
                            .addComponent(LastNameTextfield, javax.swing.GroupLayout.PREFERRED_SIZE, 306, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(MobileNumberTextfield, javax.swing.GroupLayout.PREFERRED_SIZE, 306, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(MobileNumberLabel))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(AddressLabel)
                            .addComponent(AddressTextfield, javax.swing.GroupLayout.PREFERRED_SIZE, 493, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(CheckoutLabel)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(GCashButton, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(CashButton, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(PaymentMethodLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 168, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(ListOfItemsPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(PayButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(116, 116, 116))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(CheckoutLabel)
                        .addGap(66, 66, 66)
                        .addComponent(ContactInfoLabel)
                        .addGap(13, 13, 13)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(FirstNameLabel)
                            .addComponent(LastNameLabel))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(FirstNameTextfield, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(LastNameTextfield, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(MobileNumberLabel)
                            .addComponent(AddressLabel))
                        .addGap(4, 4, 4)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(MobileNumberTextfield, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(AddressTextfield, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(57, 57, 57)
                        .addComponent(DeliveryMethodLabel)
                        .addGap(35, 35, 35)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(SameDayButton, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(RegularButton, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(PickUpButton, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(71, 71, 71)
                        .addComponent(PaymentMethodLabel)
                        .addGap(35, 35, 35)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(GCashButton, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(CashButton, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(ListOfItemsPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(PayButton, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(88, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void PayButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PayButtonActionPerformed
     // Get the total amount and payment from the labels
    double totalAmount = Double.parseDouble(TotalNumberLabel.getText());
    double paymentAmount;

    try {
        // Attempt to parse the payment amount from the PaymentTextfield
        paymentAmount = Double.parseDouble(PaymentTextfield.getText());
    } catch (NumberFormatException ex) {
        // Handle the case where the payment amount is not a valid number
        JOptionPane.showMessageDialog(this, "Invalid payment amount. Please enter a valid number.", "Error", JOptionPane.ERROR_MESSAGE);
        return;
    }

    // Check if the payment is sufficient
    if (paymentAmount < totalAmount) {
        // Display an error message if the payment is insufficient
        JOptionPane.showMessageDialog(this, "Insufficient payment. Please enter a sufficient amount.", "Error", JOptionPane.ERROR_MESSAGE);
    } else {
        // Perform the necessary actions when payment is sufficient
        // Check if the mobile number is valid (11 digits)
        String mobileNumber = MobileNumberTextfield.getText().trim();
        if (mobileNumber.length() == 11 && mobileNumber.matches("\\d+")) {
            // Continue with the payment process
            double changeAmount = paymentAmount - totalAmount;
            ChangeNumberLabel.setText(String.format("PHP %.2f", changeAmount));

            // Display a JOptionPane with the order status, change amount, and delivery method
            String orderStatus = "Paid";
            String deliveryMethod = SameDayButton.isEnabled() ? "Same Day Delivery" : (RegularButton.isEnabled() ? "Regular Delivery" : "Pick-Up");
            String paymentMethod = GCashButton.isEnabled() ? "GCash" : (CashButton.isEnabled() ? "Cash" : "Unknown");

            String message = "Order Status: " + orderStatus + "\n" +
                    "Change: " + String.format("%.2f", changeAmount) + "\n" +
                    "Delivery Method: " + deliveryMethod + "\n" +
                    "Payment Method: " + paymentMethod;

            JOptionPane.showMessageDialog(this, message, "Order Status", JOptionPane.INFORMATION_MESSAGE);

            // Additional actions or method calls can be added here
        } else {
            // Display an error message for an invalid mobile number
            JOptionPane.showMessageDialog(this, "Invalid phone number. Please enter a valid 11-digit number.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    }//GEN-LAST:event_PayButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel AddressLabel;
    private javax.swing.JTextField AddressTextfield;
    private com.app.assets.ColoredButton CashButton;
    private javax.swing.JLabel ChangeLabel;
    private javax.swing.JLabel ChangeNumberLabel;
    private javax.swing.JLabel CheckoutLabel;
    private javax.swing.JLabel ContactInfoLabel;
    private javax.swing.JLabel DeliveryMethodLabel;
    private javax.swing.JLabel FirstNameLabel;
    private javax.swing.JTextField FirstNameTextfield;
    private com.app.assets.ColoredButton GCashButton;
    private javax.swing.JLabel LastNameLabel;
    private javax.swing.JTextField LastNameTextfield;
    private javax.swing.JLabel ListOfItemsLabel;
    private javax.swing.JPanel ListOfItemsPanel;
    private javax.swing.JLabel MobileNumberLabel;
    private javax.swing.JTextField MobileNumberTextfield;
    private javax.swing.JPanel OrderListPanel;
    private javax.swing.JScrollPane OrderListScroll;
    private com.app.assets.ColoredButton PayButton;
    private javax.swing.JLabel PaymentLabel;
    private javax.swing.JLabel PaymentMethodLabel;
    private javax.swing.JTextField PaymentTextfield;
    private com.app.assets.ColoredButton PickUpButton;
    private com.app.assets.ColoredButton RegularButton;
    private com.app.assets.ColoredButton SameDayButton;
    private javax.swing.JLabel TotalLabel;
    private javax.swing.JLabel TotalNumberLabel;
    // End of variables declaration//GEN-END:variables
}
