/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package superAdminPanel;

import barangay_information_system.loginForm;
import classes.DataModel;
import java.awt.Color;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import superAdminPanel.dashboardPanel;

/**
 *
 * @author Hector
 */

public class SuperAdmin_Dashboard extends javax.swing.JFrame {

    private String name;
    private String position;
    private dashboardPanel dbPanel;
    private officailsPanel offPanel;
    private purokManagement purokMng;
    private manageHousehold mngHousehold;
    private accountManagement  accManagement;
    
    
    public SuperAdmin_Dashboard() {
        initComponents();
            dbPanel = new dashboardPanel();
            offPanel = new officailsPanel();
            purokMng = new purokManagement();
            mngHousehold = new manageHousehold();
            accManagement = new accountManagement();
            
            mainPanel.add(dbPanel);
            mainPanel.add(offPanel);
            mainPanel.add(purokMng);
            mainPanel.add(mngHousehold);
            mainPanel.add(accManagement);
            
            dbPanel.setVisible(true);
            offPanel.setVisible(false);
            purokMng.setVisible(false);
            mngHousehold.setVisible(false);
            accManagement.setVisible(false);
            
            
            name = DataModel.getDataName();
            position = DataModel.getDataPos();
            
            
            name_lbl.setText(name);
            position_lbl.setText(position);
          
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        dashboard = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        officials = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        account = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        household = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        purok = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        name_lbl = new javax.swing.JLabel();
        position_lbl = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        pictureBox1 = new swing.PictureBox();
        jLabel10 = new javax.swing.JLabel();
        logout = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        mainPanel = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        close_lbl = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jPanel3.setBackground(new java.awt.Color(17, 120, 100));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        dashboard.setBackground(new java.awt.Color(23, 165, 137));
        dashboard.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                dashboardMousePressed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("DASHBOARD");

        javax.swing.GroupLayout dashboardLayout = new javax.swing.GroupLayout(dashboard);
        dashboard.setLayout(dashboardLayout);
        dashboardLayout.setHorizontalGroup(
            dashboardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dashboardLayout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 243, Short.MAX_VALUE)
                .addContainerGap())
        );
        dashboardLayout.setVerticalGroup(
            dashboardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dashboardLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 31, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel3.add(dashboard, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 140, 300, -1));

        officials.setBackground(new java.awt.Color(20, 143, 119));
        officials.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                officialsMousePressed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("BRGY. OFFICIALS");

        javax.swing.GroupLayout officialsLayout = new javax.swing.GroupLayout(officials);
        officials.setLayout(officialsLayout);
        officialsLayout.setHorizontalGroup(
            officialsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(officialsLayout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 243, Short.MAX_VALUE)
                .addContainerGap())
        );
        officialsLayout.setVerticalGroup(
            officialsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(officialsLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 31, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel3.add(officials, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 180, 300, -1));

        account.setBackground(new java.awt.Color(20, 143, 119));
        account.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                accountMousePressed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("ACCOUNT");

        javax.swing.GroupLayout accountLayout = new javax.swing.GroupLayout(account);
        account.setLayout(accountLayout);
        accountLayout.setHorizontalGroup(
            accountLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(accountLayout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 243, Short.MAX_VALUE)
                .addContainerGap())
        );
        accountLayout.setVerticalGroup(
            accountLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(accountLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 31, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel3.add(account, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 300, 300, -1));

        household.setBackground(new java.awt.Color(20, 143, 119));
        household.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                householdMousePressed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("HOUSEHOLD");

        javax.swing.GroupLayout householdLayout = new javax.swing.GroupLayout(household);
        household.setLayout(householdLayout);
        householdLayout.setHorizontalGroup(
            householdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(householdLayout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 243, Short.MAX_VALUE)
                .addContainerGap())
        );
        householdLayout.setVerticalGroup(
            householdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(householdLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 31, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel3.add(household, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 260, 300, -1));

        purok.setBackground(new java.awt.Color(20, 143, 119));
        purok.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                purokMousePressed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("PUROK");

        javax.swing.GroupLayout purokLayout = new javax.swing.GroupLayout(purok);
        purok.setLayout(purokLayout);
        purokLayout.setHorizontalGroup(
            purokLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(purokLayout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, 243, Short.MAX_VALUE)
                .addContainerGap())
        );
        purokLayout.setVerticalGroup(
            purokLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(purokLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, 31, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel3.add(purok, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 220, 300, -1));

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/user-circle (1).png"))); // NOI18N
        jPanel3.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 70, -1, 60));

        name_lbl.setFont(new java.awt.Font("Segoe UI", 2, 12)); // NOI18N
        name_lbl.setForeground(new java.awt.Color(255, 255, 255));
        name_lbl.setText("ADMIN A. ADMIN");
        jPanel3.add(name_lbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 100, 120, 20));

        position_lbl.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        position_lbl.setForeground(new java.awt.Color(255, 255, 255));
        position_lbl.setText("ADMIN");
        jPanel3.add(position_lbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 80, 120, -1));

        jPanel4.setBackground(new java.awt.Color(14, 102, 85));

        pictureBox1.setImage(new javax.swing.ImageIcon(getClass().getResource("/image/waterfalls-v (2).png"))); // NOI18N

        jLabel10.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(235, 235, 235));
        jLabel10.setText("BARANGAY INFORMATION SYSTEM");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pictureBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addComponent(jLabel10)
                .addContainerGap(38, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(16, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(pictureBox1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE))
                .addGap(14, 14, 14))
        );

        jPanel3.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 290, 60));

        logout.setBackground(new java.awt.Color(20, 143, 119));
        logout.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                logoutMousePressed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("LOG OUT");

        javax.swing.GroupLayout logoutLayout = new javax.swing.GroupLayout(logout);
        logout.setLayout(logoutLayout);
        logoutLayout.setHorizontalGroup(
            logoutLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(logoutLayout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, 243, Short.MAX_VALUE)
                .addContainerGap())
        );
        logoutLayout.setVerticalGroup(
            logoutLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(logoutLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, 31, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel3.add(logout, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 340, 300, -1));

        mainPanel.setLayout(new java.awt.CardLayout());

        jPanel1.setBackground(new java.awt.Color(22, 160, 133));

        close_lbl.setBackground(new java.awt.Color(231, 76, 60));
        close_lbl.setFont(new java.awt.Font("Roboto Medium", 0, 18)); // NOI18N
        close_lbl.setForeground(new java.awt.Color(255, 255, 255));
        close_lbl.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        close_lbl.setText("X");
        close_lbl.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        close_lbl.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                close_lblMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                close_lblMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                close_lblMousePressed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("SansSerif", 1, 24)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("Barangay Sal - ing City");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(81, Short.MAX_VALUE)
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 999, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(close_lbl, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(close_lbl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel8)))
                .addGap(18, 18, 18))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(mainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(mainPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 726, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void dashboardMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_dashboardMousePressed
        
        setColor(dashboard);
        resetColor(officials);
        resetColor(purok);
        resetColor(household);
        resetColor(account);
         resetColor(logout);
        
         dbPanel.setVisible(true);
         offPanel.setVisible(false);
           purokMng.setVisible(false);
           mngHousehold.setVisible(false);
           accManagement.setVisible(false);
    }//GEN-LAST:event_dashboardMousePressed

    private void officialsMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_officialsMousePressed
        
        resetColor(dashboard);
        setColor(officials);
        resetColor(purok);
        resetColor(household);
        resetColor(account);
         resetColor(logout);
        
         dbPanel.setVisible(false);
         offPanel.setVisible(true);
           purokMng.setVisible(false);
           mngHousehold.setVisible(false);
           accManagement.setVisible(false);
    }//GEN-LAST:event_officialsMousePressed

    private void purokMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_purokMousePressed
      
        resetColor(dashboard);
        resetColor(officials);
        setColor(purok);
        resetColor(household);
        resetColor(account);
         resetColor(logout);
        
         dbPanel.setVisible(false);
         offPanel.setVisible(false);
           purokMng.setVisible(true);
           mngHousehold.setVisible(false);
           accManagement.setVisible(false);
        
    }//GEN-LAST:event_purokMousePressed

    private void householdMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_householdMousePressed

        resetColor(dashboard);
        resetColor(officials);
        resetColor(purok);
        setColor(household);
        resetColor(account);
         resetColor(logout);
        
         dbPanel.setVisible(false);
         offPanel.setVisible(false);
           purokMng.setVisible(false);
           mngHousehold.setVisible(true);
           accManagement.setVisible(false);
    }//GEN-LAST:event_householdMousePressed

    private void accountMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_accountMousePressed
      
        resetColor(dashboard);
        resetColor(officials);
        resetColor(purok);
        resetColor(household);
        setColor(account);
        resetColor(logout);
        
           dbPanel.setVisible(false);
         offPanel.setVisible(false);
           purokMng.setVisible(false);
           mngHousehold.setVisible(false);
           accManagement.setVisible(true);
    }//GEN-LAST:event_accountMousePressed

    private void close_lblMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_close_lblMousePressed
        
        System.exit(0);
    }//GEN-LAST:event_close_lblMousePressed

    private void close_lblMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_close_lblMouseEntered
       
        close_lbl.setForeground(new Color(231, 76, 60));
    }//GEN-LAST:event_close_lblMouseEntered

    private void close_lblMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_close_lblMouseExited
       
        close_lbl.setForeground(new Color(255,255,255));
    }//GEN-LAST:event_close_lblMouseExited

    private void logoutMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logoutMousePressed
       
        
         resetColor(dashboard);
        resetColor(officials);
        resetColor(purok);
        resetColor(household);
        resetColor(account);
       setColor(logout);
       
             
         int confirmation = JOptionPane.showConfirmDialog(
        null, "Are you sure you want to logout?", "Confirm", JOptionPane.YES_NO_OPTION
    );

    if (confirmation == JOptionPane.YES_OPTION) {
        loginForm log = new loginForm();
          log.setVisible(true);
        dispose();
        
        
    } 
       
       
    }//GEN-LAST:event_logoutMousePressed

    
    
   void setColor (JPanel jpanel){
   
       jpanel.setBackground(new Color(23,165,137));
   }
    
   void resetColor (JPanel jpanel){
   
        jpanel.setBackground(new Color(20,143,119));
   }
       
    
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
            java.util.logging.Logger.getLogger(SuperAdmin_Dashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SuperAdmin_Dashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SuperAdmin_Dashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SuperAdmin_Dashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SuperAdmin_Dashboard().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel account;
    private javax.swing.JLabel close_lbl;
    private javax.swing.JPanel dashboard;
    private javax.swing.JPanel household;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel logout;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JLabel name_lbl;
    private javax.swing.JPanel officials;
    private swing.PictureBox pictureBox1;
    private javax.swing.JLabel position_lbl;
    private javax.swing.JPanel purok;
    // End of variables declaration//GEN-END:variables
}
