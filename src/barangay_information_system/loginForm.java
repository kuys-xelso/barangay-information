/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package barangay_information_system;



import OfficialsPanel.kagawad_Dashboard;
import classes.DataModel;
import connection.Connect;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.awt.Color;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import superAdminPanel.SuperAdmin_Dashboard;

/**
 *
 * @author Hector
 */
public class loginForm extends javax.swing.JFrame {

   
    Connection con;
   PreparedStatement pst;
    ResultSet rs;
    
    
    
    public loginForm() {
        con = Connect.con();
        initComponents();
        log_btn.requestFocus();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        usrname_txt = new classes.Textfield();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        log_btn = new classes.Button();
        showPass = new javax.swing.JCheckBox();
        txt_pass = new classes.Passwordfeild();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(17, 120, 100));

        usrname_txt.setText("USERNAME");
        usrname_txt.setForeground(Color.gray);
        usrname_txt.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                usrname_txtFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                usrname_txtFocusLost(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Roboto Black", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("BARANGAY INFORMATION SYSTEM");

        jLabel2.setFont(new java.awt.Font("SansSerif", 2, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Sal-ing, Balilihan, Bohol");

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/waterfalls-v (2).png"))); // NOI18N

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/person.png"))); // NOI18N

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/shield-lock.png"))); // NOI18N

        log_btn.setText("LOG IN");
        log_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                log_btnActionPerformed(evt);
            }
        });

        showPass.setForeground(new java.awt.Color(255, 255, 255));
        showPass.setText("Show Password");
        showPass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                showPassActionPerformed(evt);
            }
        });

        txt_pass.setText("PASSWORD");
        txt_pass.setForeground(Color.GRAY);
        txt_pass.setEchoChar('\0');
        txt_pass.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txt_passFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_passFocusLost(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(233, 233, 233)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(146, 146, 146)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(usrname_txt, javax.swing.GroupLayout.DEFAULT_SIZE, 253, Short.MAX_VALUE)
                            .addComponent(showPass, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(log_btn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txt_pass, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(157, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(146, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(266, 266, 266))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 329, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(128, 128, 128))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addGap(37, 37, 37)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(usrname_txt, javax.swing.GroupLayout.DEFAULT_SIZE, 44, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, 44, Short.MAX_VALUE)
                    .addComponent(txt_pass, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(4, 4, 4)
                .addComponent(showPass)
                .addGap(28, 28, 28)
                .addComponent(log_btn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(58, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void usrname_txtFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_usrname_txtFocusGained
        
         showPass.setSelected(false);
         if(usrname_txt.getText().equals("USERNAME")){
            usrname_txt.setText("");
            usrname_txt.setForeground(Color.BLACK );
        }
    }//GEN-LAST:event_usrname_txtFocusGained

    private void showPassActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_showPassActionPerformed

        if(showPass.isSelected()){
            txt_pass.setEchoChar('\0');
        }else{
            txt_pass.setEchoChar('\u2022');
        }
    }//GEN-LAST:event_showPassActionPerformed

    private void usrname_txtFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_usrname_txtFocusLost
         if(usrname_txt.getText().isEmpty()){
            usrname_txt.setText("USERNAME");
            usrname_txt.setForeground(Color.GRAY);
         }
    }//GEN-LAST:event_usrname_txtFocusLost

    private void txt_passFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_passFocusGained
   
        if(txt_pass.getText().equals("PASSWORD")){
            txt_pass.setText("");
            txt_pass.setEchoChar('\u2022');
            txt_pass.setForeground(Color.black);
        }
    }//GEN-LAST:event_txt_passFocusGained

    private void txt_passFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_passFocusLost
      
         
         if(txt_pass.getText().isEmpty()){
            txt_pass.setText("PASSWORD");
            txt_pass.setEchoChar('\0');
            txt_pass.setForeground(Color.GRAY);
        }
    }//GEN-LAST:event_txt_passFocusLost

    private void log_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_log_btnActionPerformed
      
        String username = usrname_txt.getText();
        String pass = new String(txt_pass.getPassword());
        
           if(username.equals("USERNAME")){ 
        JOptionPane.showMessageDialog(null, "Username is Empty.");
        return;
        }
        if(pass.equals("PASSWORD")){
        JOptionPane.showMessageDialog(null, "Password is Empty.");
        return;
        }
        
      try {
    String sql = "SELECT * FROM officials_data WHERE username=? AND password=?";
    pst = con.prepareCall(sql);
    pst.setString(1, username);
    pst.setString(2, pass);
    rs = pst.executeQuery();

    if (rs.next()) {
        int brgy_id = rs.getInt("brgy_off_id");
        try {
            
              pst = con.prepareCall("SELECT  Brgy_Officials.Id,Brgy_Officials.Position, Brgy_Officials.Name FROM Brgy_Officials INNER JOIN officials_data "
                + "ON Brgy_Officials.Id = officials_data.brgy_off_id WHERE officials_data.brgy_off_id = ?;");
        pst.setInt(1, brgy_id);
        ResultSet rs2 = pst.executeQuery();

        if(rs2.next()) {
            int id = rs2.getInt("Id");
            String position = rs2.getString("Position");
            String nameD = rs2.getString("Name");
            
            DataModel.setDatakgID(id);
            DataModel.setDataName(nameD);
            DataModel.setDataPos(position);
            
            
            if (position.equals("Captain")) {
                SuperAdmin_Dashboard admin = new SuperAdmin_Dashboard();
                admin.show();
                this.dispose();
               
            } else if (position.equals("Kagawad")) {
                kagawad_Dashboard kag_dash = new kagawad_Dashboard();
                kag_dash.show();
                this.dispose();
               
            }
        }
        rs2.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
            
          
    }
    
    else{
    JOptionPane.showMessageDialog(rootPane, "Incorrect credentials.");
    }
} catch (SQLException e) {
    e.printStackTrace();
}
            
            
            
            
           
            
        
        
    }//GEN-LAST:event_log_btnActionPerformed

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
            java.util.logging.Logger.getLogger(loginForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(loginForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(loginForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(loginForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new loginForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private classes.Button log_btn;
    private javax.swing.JCheckBox showPass;
    private classes.Passwordfeild txt_pass;
    private classes.Textfield usrname_txt;
    // End of variables declaration//GEN-END:variables
}