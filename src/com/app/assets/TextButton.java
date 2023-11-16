/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.app.assets;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;


public class TextButton extends JButton {

    public boolean isOver() {
        return over;
    }

    public void setOver(boolean over) {
        this.over = over;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
        setForeground(color);
    }

    public Color getColorOver() {
        return colorOver;
    }

    public void setColorOver(Color colorOver) {
        this.colorOver = colorOver;
    }

    public Color getColorClick() {
        return colorClick;
    }

    public void setColorClick(Color colorClick) {
        this.colorClick = colorClick;
    }


    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

    public TextButton() {
        //  Init Color

        setColor(Color.BLACK);
        colorOver = new Color(194, 21, 10);
        colorClick = new Color(74, 11, 7);
        setContentAreaFilled(false);
        //  Add event mouse
        addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent me) {
                setForeground(colorOver);
                setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                over = true;
            }

            @Override
            public void mouseExited(MouseEvent me) {
                setForeground(color);
                setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
                over = false;
            }

            @Override
            public void mousePressed(MouseEvent me) {
                setForeground(colorClick);
            }

            @Override
            public void mouseReleased(MouseEvent me) {
                if (over) {
                    setForeground(colorOver);
                } else {
                    setForeground(color);
                }
            }
        });
    }

    private boolean over;
    private Color color;
    private Color colorOver;
    private Color colorClick;
    private int radius = 0;

    @Override
    protected void paintComponent(Graphics grphcs) {
        Graphics2D g2 = (Graphics2D) grphcs;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        // Set alpha value for the background
        float alpha = 0.0f; // Default alpha when idle

        if (over) {
            // Set alpha value for the background when hovered
            alpha = 0.7f;
        }

        if (getModel().isPressed()) {
            // Set alpha value for the background when clicked
            alpha = 0.5f;
        }

        g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, alpha));

        // Reset the composite for the text
        g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 1.0f));

        // Comment out or remove the line below to remove the button text
        super.paintComponent(grphcs);
    }
}