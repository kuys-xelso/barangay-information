/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package OfficialsPanel;

import classes.DataModel;
import superAdminPanel.*;
import classes.Model_card;
import classes.ScrollBar;
import connection.Connect;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Hector
 */
public class dashboardPanel extends javax.swing.JPanel {

  Connection con;
    PreparedStatement pst;
    ResultSet rs;
     
    private int kgID;
    
    public dashboardPanel() {
        initComponents();
       con = Connect.con();
        
        kgID = DataModel.getDatakgID() ;
         
      
         
         
         dashboardTable_Scroll.setVerticalScrollBar(new ScrollBar());
         
         //display total population
           try {
        pst = con.prepareCall("Select purok_assigned FRom brgy_officials where Id = ? ");
        pst.setInt(1, kgID);
        rs = pst.executeQuery();
        
        if (rs.next()) {
          int p_ID = rs.getInt("purok_assigned");
          
            try {
                pst = con.prepareCall("SELECT id FROM household WHERE purok_add = ?; ");
                pst.setInt(1, p_ID);
                rs = pst.executeQuery();
                
                if (rs.next()) {
                    int h_ID = rs.getInt("id");
                    
                    try {
                        pst = con.prepareCall("SELECT COUNT(*) FROM person WHERE household_id = ? ");
                        pst.setInt(1, h_ID);
                        rs = pst.executeQuery();
                        
                        if (rs.next()) {
                            int count = rs.getInt(1);
                            String value = String.valueOf(count);
                      card1.setData(new Model_card("Population",value));
                            
                        }
                        
                    } catch (Exception e) {
                    }
                }
                
                
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

     
    } catch (SQLException ex) {
        Logger.getLogger(accountManagement.class.getName()).log(Level.SEVERE, null, ex);
    }
          
          
          
            //display total Female
          
          try {
        pst = con.prepareCall("Select purok_assigned FRom brgy_officials where Id = ? ");
        pst.setInt(1, kgID);
        rs = pst.executeQuery();
        
        if (rs.next()) {
          int p_ID = rs.getInt("purok_assigned");
          
            try {
                pst = con.prepareCall("SELECT id FROM household WHERE purok_add = ?; ");
                pst.setInt(1, p_ID);
                rs = pst.executeQuery();
                
                if (rs.next()) {
                    int h_ID = rs.getInt("id");
                    
                    try {
                        pst = con.prepareCall("SELECT COUNT(*) FROM person WHERE household_id = ? AND gender = \"Female\"");
                        pst.setInt(1, h_ID);
                        rs = pst.executeQuery();
                        
                        if (rs.next()) {
                            int count = rs.getInt(1);
                            String value = String.valueOf(count);
                      card2.setData(new Model_card("Female",value));
                            
                        }
                        
                    } catch (Exception e) {
                    }
                }
                
                
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

     
    } catch (SQLException ex) {
        Logger.getLogger(accountManagement.class.getName()).log(Level.SEVERE, null, ex);
    }
            //display total Male
          
           try {
        pst = con.prepareCall("Select purok_assigned FRom brgy_officials where Id = ? ");
        pst.setInt(1, kgID);
        rs = pst.executeQuery();
        
        if (rs.next()) {
          int p_ID = rs.getInt("purok_assigned");
          
            try {
                pst = con.prepareCall("SELECT id FROM household WHERE purok_add = ?; ");
                pst.setInt(1, p_ID);
                rs = pst.executeQuery();
                
                if (rs.next()) {
                    int h_ID = rs.getInt("id");
                    
                    try {
                        pst = con.prepareCall("SELECT COUNT(*) FROM person WHERE household_id = ? AND gender = \"Male\"");
                        pst.setInt(1, h_ID);
                        rs = pst.executeQuery();
                        
                        if (rs.next()) {
                            int count = rs.getInt(1);
                            String value = String.valueOf(count);
                      card3.setData(new Model_card("Male",value));
                            
                        }
                        
                    } catch (Exception e) {
                    }
                }
                
                
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

     
    } catch (SQLException ex) {
        Logger.getLogger(accountManagement.class.getName()).log(Level.SEVERE, null, ex);
    }
          
          //display number of household
          
        try {
        pst = con.prepareCall("Select purok_assigned FRom brgy_officials where Id = ? ");
        pst.setInt(1, kgID);
        rs = pst.executeQuery();
        
        if (rs.next()) {
          int p_ID = rs.getInt("purok_assigned");
          
            try {
                pst = con.prepareCall("SELECT COUNT(*) FROM household WHERE purok_add=?; ");
                pst.setInt(1, p_ID);
                rs = pst.executeQuery();
                
                if (rs.next()) {
                    int count = rs.getInt(1);
                    String value = String.valueOf(count);
                      card4.setData(new Model_card("Households",value));
                }
                
                
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

     
    } catch (SQLException ex) {
        Logger.getLogger(accountManagement.class.getName()).log(Level.SEVERE, null, ex);
    }
        
        

   //display purok label
    
     try {
              pst = con.prepareCall("Select purok_assigned FRom brgy_officials where Id = ?");
                pst.setInt(1, kgID);
        rs = pst.executeQuery();
        
             if (rs.next()) {
          int p_ID = rs.getInt("purok_assigned");
          
            try {
                pst = con.prepareCall("SELECT purok_name FROM purok WHERE id=?; ");
                pst.setInt(1, p_ID);
                rs = pst.executeQuery();
                
                if (rs.next()) {
                    String pname = rs.getString("purok_name");
                    purokname_lbl.setText("List of Household of Purok " +pname);
                    
                }
                
                
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
              
              
          } catch (SQLException ex) {
              Logger.getLogger(kagawad_Dashboard.class.getName()).log(Level.SEVERE, null, ex);
          }
            
    



         

//display table in dashboard






           try {
        pst = con.prepareCall("Select purok_assigned FRom brgy_officials where Id = ? ");
        pst.setInt(1, kgID);
        rs = pst.executeQuery();
        
        if (rs.next()) {
          int p_ID = rs.getInt("purok_assigned");
          
            try {
            pst = con.prepareCall("SELECT household.id,person.name,household.purok_add ,household.contact "
                    + "FROM household INNER JOIN person ON household.id = person. household_id  Where household.purok_add = ? AND person.relationship = \"Family Head\" ; ");
            pst.setInt(1, p_ID);
            rs = pst.executeQuery();
            
            while(rs.next()){
            Object[] rowdata = new Object[4];
            
            for(int i = 0; i < 4; i++){
            
                rowdata[i] =rs.getObject(i+1);
            
            }
            tableDashnoard.addRow(rowdata);
            
            }
            
        } catch (SQLException ex) {  
            Logger.getLogger(superAdminPanel.dashboardPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
        }
        
         } catch (SQLException ex) {
        Logger.getLogger(accountManagement.class.getName()).log(Level.SEVERE, null, ex);
    }
    }

 
    
    
    

//    
//private int getAssignedpurok(int b_id) {
//    
//    int H_count;
//
//    try {
//        pst = con.prepareCall("Select purok-assigned FRom brgy_officials where Id = ? ");
//        pst.setInt(1, b_id);
//        rs = pst.executeQuery();
//        
//        if (rs.next()) {
//          int p_ID = rs.getInt("purok_assigned");
//          
//            try {
//                pst = con.prepareCall("SELECT COUNT(*) FROM household WHERE purok_add=?; ");
//                pst.setInt(1, p_ID);
//                
//                
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//        }
//
//     
//    } catch (SQLException ex) {
//        Logger.getLogger(accountManagement.class.getName()).log(Level.SEVERE, null, ex);
//    }
//return 
//}    
//    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        card1 = new panel.Card();
        card2 = new panel.Card();
        card3 = new panel.Card();
        card4 = new panel.Card();
        jLabel1 = new javax.swing.JLabel();
        panelBorder1 = new panel.panelBorder();
        dashboardTable_Scroll = new javax.swing.JScrollPane();
        tableDashnoard = new classes.Table();
        purokname_lbl = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setPreferredSize(new java.awt.Dimension(1053, 647));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new java.awt.GridLayout(1, 4, 10, 10));

        card1.setColor1(new java.awt.Color(245, 176, 65));
        card1.setColor2(new java.awt.Color(255, 127, 80));
        jPanel1.add(card1);

        card2.setColor1(new java.awt.Color(187, 143, 206));
        card2.setColor2(new java.awt.Color(17, 122, 101));
        jPanel1.add(card2);

        card3.setColor1(new java.awt.Color(236, 112, 99));
        card3.setColor2(new java.awt.Color(202, 111, 30));
        jPanel1.add(card3);

        card4.setColor1(new java.awt.Color(247, 220, 111));
        card4.setColor2(new java.awt.Color(22, 160, 133));
        jPanel1.add(card4);

        jLabel1.setFont(new java.awt.Font("SansSerif", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("DASHBOARD");

        panelBorder1.setBackground(new java.awt.Color(214, 214, 214));

        tableDashnoard.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID no.", "Head of Family", "Purok Address", "Contact"
            }
        ));
        tableDashnoard.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        dashboardTable_Scroll.setViewportView(tableDashnoard);

        purokname_lbl.setFont(new java.awt.Font("SansSerif", 1, 16)); // NOI18N
        purokname_lbl.setForeground(new java.awt.Color(76, 76, 76));
        purokname_lbl.setText("List of Household of Purok");

        javax.swing.GroupLayout panelBorder1Layout = new javax.swing.GroupLayout(panelBorder1);
        panelBorder1.setLayout(panelBorder1Layout);
        panelBorder1Layout.setHorizontalGroup(
            panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBorder1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(dashboardTable_Scroll, javax.swing.GroupLayout.DEFAULT_SIZE, 1029, Short.MAX_VALUE)
                    .addGroup(panelBorder1Layout.createSequentialGroup()
                        .addComponent(purokname_lbl)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        panelBorder1Layout.setVerticalGroup(
            panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelBorder1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(purokname_lbl, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(dashboardTable_Scroll, javax.swing.GroupLayout.DEFAULT_SIZE, 303, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(panelBorder1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(79, 79, 79)
                .addComponent(panelBorder1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private panel.Card card1;
    private panel.Card card2;
    private panel.Card card3;
    private panel.Card card4;
    private javax.swing.JScrollPane dashboardTable_Scroll;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private panel.panelBorder panelBorder1;
    private javax.swing.JLabel purokname_lbl;
    private classes.Table tableDashnoard;
    // End of variables declaration//GEN-END:variables
}
