/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package classes;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import javax.swing.border.EmptyBorder;

/**
 *
 * @author Hector
 */
public class AddButton extends JButton{
    
    
  private boolean mousePress;
  
    
    
    public AddButton(){
    
        setContentAreaFilled(false);
         setForeground(new Color(229, 231, 233));
        setBorder(new EmptyBorder(3,3,3,3));
         addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent me) {
                mousePress = true;
            }

            @Override
            public void mouseReleased(MouseEvent me) {
                mousePress = false;
            }
        });
        
    }

    @Override
    protected void paintComponent(Graphics g) {
        
        Graphics2D g2 = (Graphics2D)g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
         int width = getWidth();
        int height = getHeight();
        
        int x = 0;
        int y = 0;
        int arcWidth = height / 4; // Adjust the arc width to control the roundness of the rectangle
    int arcHeight = height / 4; 
        if (mousePress) {
            g2.setColor(new Color(174, 214, 241));
        } else {
            g2.setColor(new Color(52, 152, 219));
        }
        g2.fillRoundRect(x, y, width, height, arcWidth, arcHeight);
        g2.dispose();
      
        super.paintComponent(g); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }
    
    
}
