/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package panel;

import classes.Model_card;
import classes.modelOfficialcard;
import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import javax.swing.Icon;
import javax.swing.JLabel;
import superAdminPanel.officialData;

/**
 *
 * @author gardh
 */
public class Card_off extends javax.swing.JPanel {

   
    public Color getColor1() {
        return color1;
    }

    
    public void setColor1(Color color1) {
        this.color1 = color1;
    }

    
    
    public Color getColor2() {
        return color2;
    }

    
    public void setColor2(Color color2) {
        this.color2 = color2;
    }

    
    
    private Color color1;
    private Color color2;
    
    
    public Card_off() {
        initComponents();
        setOpaque(false);
        color1 = Color.BLACK;
        color2 = Color.WHITE;
        
    }

    public void setData(modelOfficialcard data){
    
        Name_lbl.setText(data.getTitle());
        pos_lbl.setText(data.getValues());
        imageLabel.setImage(data.getImage());
        
    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelShadow5 = new swing.PanelShadow();
        imageLabel = new swing.PictureBox();
        Name_lbl = new javax.swing.JLabel();
        pos_lbl = new javax.swing.JLabel();
        tres_view = new javax.swing.JLabel();

        panelShadow5.setBackground(new java.awt.Color(255, 255, 255));

        imageLabel.setImage(new javax.swing.ImageIcon(getClass().getResource("/image/person_1.png"))); // NOI18N

        Name_lbl.setFont(new java.awt.Font("SansSerif", 1, 15)); // NOI18N
        Name_lbl.setForeground(new java.awt.Color(89, 89, 89));
        Name_lbl.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Name_lbl.setText("NAME");

        pos_lbl.setFont(new java.awt.Font("SansSerif", 1, 20)); // NOI18N
        pos_lbl.setForeground(new java.awt.Color(89, 89, 89));
        pos_lbl.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        pos_lbl.setText("Position");

        tres_view.setFont(new java.awt.Font("SansSerif", 1, 24)); // NOI18N
        tres_view.setForeground(new java.awt.Color(89, 89, 89));
        tres_view.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        tres_view.setText("View");
        tres_view.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        tres_view.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                tres_viewMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                tres_viewMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tres_viewMousePressed(evt);
            }
        });

        javax.swing.GroupLayout panelShadow5Layout = new javax.swing.GroupLayout(panelShadow5);
        panelShadow5.setLayout(panelShadow5Layout);
        panelShadow5Layout.setHorizontalGroup(
            panelShadow5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelShadow5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelShadow5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Name_lbl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pos_lbl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(tres_view, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(panelShadow5Layout.createSequentialGroup()
                .addGap(90, 90, 90)
                .addComponent(imageLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(90, 90, 90))
        );
        panelShadow5Layout.setVerticalGroup(
            panelShadow5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelShadow5Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(imageLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Name_lbl)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pos_lbl)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(tres_view)
                .addContainerGap(41, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelShadow5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelShadow5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void tres_viewMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tres_viewMouseEntered

        setColor(tres_view);
    }//GEN-LAST:event_tres_viewMouseEntered

    private void tres_viewMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tres_viewMouseExited
        resetColor(tres_view);
    }//GEN-LAST:event_tres_viewMouseExited

    private void tres_viewMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tres_viewMousePressed
        officialData  offData = new officialData();
        offData.setVisible(true);
    }//GEN-LAST:event_tres_viewMousePressed


   void setColor(JLabel label){
    
        label.setForeground(new Color(52, 152, 219));
    }
    
   void resetColor (JLabel label){
   
        label.setForeground(new Color(89,89,89));
   }

    
    
      @Override
    protected void paintComponent(Graphics grphcs) {
        Graphics2D g2 = (Graphics2D) grphcs;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        GradientPaint g = new GradientPaint(0, 0, getColor1(), 0, getHeight(), getColor2());
        g2.setPaint(g);
        g2.fillRoundRect(0, 0, getWidth(), getHeight(), 15, 15);
       
        super.paintComponent(grphcs);
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Name_lbl;
    private swing.PictureBox imageLabel;
    private swing.PanelShadow panelShadow5;
    private javax.swing.JLabel pos_lbl;
    private javax.swing.JLabel tres_view;
    // End of variables declaration//GEN-END:variables
}
