
package classes;

import javax.swing.JTextField;
import javax.swing.*;
import java.awt.*;
import java.awt.geom.RoundRectangle2D;
import javax.swing.border.AbstractBorder;
import javax.swing.border.EmptyBorder;


public class Textfield extends JTextField {
    
     public Textfield() {
         
        setOpaque(false);
          setFont(new Font("sanserif",0,14 ));
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
    

