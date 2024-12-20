/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package classes;

import java.awt.Component;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Insets;
import java.awt.Shape;
import java.awt.geom.RoundRectangle2D;
import javax.swing.BorderFactory;
import javax.swing.JPasswordField;
import javax.swing.border.AbstractBorder;
import javax.swing.border.EmptyBorder;

/**
 *
 * @author gardh
 */
public class Passwordfeild extends JPasswordField {
    
    public Passwordfeild() {
        setOpaque(false);
        setFont(new Font("sanserif",0,14));
        setEchoChar('\u2022');
        setBorder(BorderFactory.createCompoundBorder(
                new CustomeBorder(),
                new EmptyBorder(new Insets(4, 4, 4, 4))));
    }

    @Override
    protected void paintComponent(Graphics g) {
        int width = getWidth();
        int height = getHeight();
        // Paint a rounded rectangle in the background
        g.setColor(getBackground());
        g.fillRoundRect(0, 0, width, height, 10, 10);
        // Call the superclass behavior to paint the foreground
        super.paintComponent(g);
    }

    private static class CustomeBorder extends AbstractBorder {
        @Override
        public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
            Graphics2D g2d = (Graphics2D) g;
        
            Shape shape = new RoundRectangle2D.Float(0, 0, c.getWidth() - 1, c.getHeight() - 1, 10, 10);
            g2d.draw(shape);
        }
    }
}
