/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package superAdminPanel;

import classes.DataModel;
import classes.ScrollBar;
import classes.tablActionCellRenderer;
import classes.tableActionCellEditor;
import classes.tableActionEvent;
import connection.Connect;
import java.awt.Color;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Hector
 */
public class addFamilyMember extends javax.swing.JFrame {

    
    private int householdID;
   
     Connection con;
    PreparedStatement pst;
    ResultSet rs;
     
    
    
     
    // Setter method
    
    
    public addFamilyMember() {
        initComponents();
        init();
        con = Connect.con();
        
        
        householdID = DataModel.getDataID();
        
       
        jScrollPane1.setVerticalScrollBar(new ScrollBar());
        
          tableActionEvent event = new tableActionEvent() {
            @Override
            public void onEdit(int row) {
                System.out.println("EDIT ROW: " + row);
                
                     int selectedrow  = table_persons.getSelectedRow();
              
             if (selectedrow != -1) {
               
                 Object[] rowData = new Object[5];

             for (int i = 0; i < 5; i++) {
                rowData[i] =  table_persons.getValueAt(selectedrow, i);
                 }

             
             
             
             
               id_txt.setText(rowData[0].toString());
                     name_txt.setText(rowData[1].toString());
                      birthdate_txt.setText(rowData[2].toString());
                   if(rowData[3].toString().equals("Male")){
                            genderCbox.setSelectedIndex(1);
                     }
                     else if(rowData[3].toString().equals("Female")){
                              genderCbox.setSelectedIndex(2);
                     }
                  
                     
                   if(rowData[4].toString().equals("Son")){
                            genderCbox_relation.setSelectedIndex(1);
                     }
                     else if(rowData[4].toString().equals("Daughter")){
                              genderCbox_relation.setSelectedIndex(2);
                     }
                     else if(rowData[4].toString().equals("Wife")){
                              genderCbox_relation.setSelectedIndex(3);
                     }
                     else if(rowData[4].toString().equals("Husband")){
                              genderCbox_relation.setSelectedIndex(4);
                     }
                     else if(rowData[4].toString().equals("Parent")){
                              genderCbox_relation.setSelectedIndex(5);
                     }
                   
                   
                  




        }
                 }

            @Override
            public void onDelete(int row) {
              
                if (table_persons.isEditing()) {
                    table_persons.getCellEditor().stopCellEditing();
                }
              deletePerson();
            }
        };
                
                
        table_persons.getColumnModel().getColumn(5).setCellRenderer(new tablActionCellRenderer() );
        table_persons.getColumnModel().getColumn(5).setCellEditor(new tableActionCellEditor(event) );
        
        
        
        
            try {
            pst = con.prepareCall("SELECT person.id,person.name,person.datebirth,person.gender, person.relationship FROM household "
                    + "INNER JOIN person ON household.id = person.household_id WHERE person.household_id = ?; ");
            pst.setInt(1,householdID);
            rs = pst.executeQuery();
            
            while(rs.next()){
            Object[] rowdata = new Object[5];
            
            for(int i = 0; i < 5; i++){
            
                rowdata[i] =rs.getObject(i+1);
            
            }
            table_persons.addRow(rowdata);
            
            }
        } catch (SQLException ex) {  
            Logger.getLogger(addFamilyMember.class.getName()).log(Level.SEVERE, null, ex);
        }
        
            int id = NextIdFromDatabase();
            
        id_txt.setText(String.valueOf(id));
           
    }

    
     private int NextIdFromDatabase() {
    int nextId = 0;

    try {
        // Get the auto-increment value for the table
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery("SHOW TABLE STATUS LIKE 'person'");
        
        if (rs.next()) {
            nextId = rs.getInt("Auto_increment");
        }

        stmt.close();
    } catch (SQLException ex) {
        Logger.getLogger(accountManagement.class.getName()).log(Level.SEVERE, null, ex);
    }

    return nextId;
}    
    
     
        
 private void deletePerson(){

 int selectedRow = table_persons.getSelectedRow();

              
                    // Extract information from the selected row
                    int userId = (int) table_persons.getValueAt(selectedRow, 0);

                    // Construct the SQL DELETE statement
                    String sql = "DELETE FROM household WHERE id = ?";

                    try (PreparedStatement statement = con.prepareStatement(sql)) {
                        // Set the parameter in the DELETE statement
                        statement.setInt(1, userId);

                        // Execute the DELETE statement
                        statement.executeUpdate();

                        // Remove the selected row from the JTable model
                        DefaultTableModel model = (DefaultTableModel) table_persons.getModel();
                        model.removeRow(selectedRow);

                      
                       
                    
                    } catch (SQLException ex) {
                        Logger.getLogger(OfficialsPanel.accountManagement.class.getName()).log(Level.SEVERE, null, ex);
                    }

 }
 
     
     
     
      private void insertUser(String name, String date, String gender,  int id,String rel) {
    String sql = "INSERT INTO `person` ( `household_id`,`name`,`datebirth`,`gender`,`relationship`) VALUES (?,?,?,?,?)" ;
    try (PreparedStatement statement = con.prepareStatement(sql)) {
        statement.setInt(1, id);
        statement.setString(2, name);
        statement.setString(3, date);
        statement.setString(4, gender);
        statement.setString(5,rel);
        statement.executeUpdate();
       
          
        
    } catch (SQLException ex) {
        Logger.getLogger(manageHousehold.class.getName()).log(Level.SEVERE, null, ex);
    }
}
    
           public  void init(){
    
        setBackground(new Color(0,0,0,0));
        
    }
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        dateChooser1 = new com.raven.datechooser.DateChooser();
        panelShadow1 = new swing.PanelShadow();
        jScrollPane1 = new javax.swing.JScrollPane();
        table_persons = new classes.Table();
        jLabel6 = new javax.swing.JLabel();
        id_txt = new classes.Textfield();
        jLabel12 = new javax.swing.JLabel();
        name_txt = new classes.Textfield();
        jLabel11 = new javax.swing.JLabel();
        birthdate_txt = new classes.Textfield();
        jLabel8 = new javax.swing.JLabel();
        calendarBtn2 = new classes.calendarBtn();
        add_btn = new classes.Button();
        close_lbl = new javax.swing.JLabel();
        genderCbox = new classes.ComboBox();
        jLabel13 = new javax.swing.JLabel();
        genderCbox_relation = new classes.ComboBox();

        dateChooser1.setTextRefernce(birthdate_txt);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        panelShadow1.setBackground(new java.awt.Color(153, 153, 153));

        table_persons.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Name", "Birthdate", "Gender", "Relationship", "Action"
            }
        ));
        jScrollPane1.setViewportView(table_persons);

        jLabel6.setFont(new java.awt.Font("SansSerif", 1, 15)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(39, 55, 70));
        jLabel6.setText("ID");

        id_txt.setEditable(false);

        jLabel12.setFont(new java.awt.Font("SansSerif", 1, 15)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(39, 55, 70));
        jLabel12.setText("Name");

        jLabel11.setFont(new java.awt.Font("SansSerif", 1, 15)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(39, 55, 70));
        jLabel11.setText("Relationship");

        jLabel8.setFont(new java.awt.Font("SansSerif", 1, 15)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(39, 55, 70));
        jLabel8.setText("Birthdate");

        calendarBtn2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/raven/datechooser/calendar (2).png"))); // NOI18N
        calendarBtn2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                calendarBtn2ActionPerformed(evt);
            }
        });

        add_btn.setText("Save");
        add_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                add_btnActionPerformed(evt);
            }
        });

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

        genderCbox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Select", "Male", "Female" }));

        jLabel13.setFont(new java.awt.Font("SansSerif", 1, 15)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(39, 55, 70));
        jLabel13.setText("Gender");

        genderCbox_relation.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Select", "Son", "Daughter", "Wife", "Husband", "Parent" }));

        javax.swing.GroupLayout panelShadow1Layout = new javax.swing.GroupLayout(panelShadow1);
        panelShadow1.setLayout(panelShadow1Layout);
        panelShadow1Layout.setHorizontalGroup(
            panelShadow1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelShadow1Layout.createSequentialGroup()
                .addGap(102, 102, 102)
                .addGroup(panelShadow1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(name_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 325, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(id_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 325, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(panelShadow1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(genderCbox, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 325, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 114, Short.MAX_VALUE)
                .addGroup(panelShadow1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelShadow1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelShadow1Layout.createSequentialGroup()
                            .addGroup(panelShadow1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(panelShadow1Layout.createSequentialGroup()
                                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(202, 202, 202))
                                .addComponent(birthdate_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 325, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(calendarBtn2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(panelShadow1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(add_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(genderCbox_relation, javax.swing.GroupLayout.PREFERRED_SIZE, 325, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(99, 99, 99))
            .addGroup(panelShadow1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelShadow1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelShadow1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(close_lbl, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        panelShadow1Layout.setVerticalGroup(
            panelShadow1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelShadow1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(close_lbl, javax.swing.GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE)
                .addGap(51, 51, 51)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 41, Short.MAX_VALUE)
                .addGroup(panelShadow1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(panelShadow1Layout.createSequentialGroup()
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(9, 9, 9)
                        .addComponent(id_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(name_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelShadow1Layout.createSequentialGroup()
                        .addGroup(panelShadow1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(panelShadow1Layout.createSequentialGroup()
                                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(birthdate_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(calendarBtn2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(genderCbox_relation, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(genderCbox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(47, 47, 47)
                .addComponent(add_btn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(76, 76, 76))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelShadow1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelShadow1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void calendarBtn2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_calendarBtn2ActionPerformed

        dateChooser1.showPopup();
    }//GEN-LAST:event_calendarBtn2ActionPerformed

    private void close_lblMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_close_lblMouseEntered

        close_lbl.setForeground(new Color(231, 76, 60));
    }//GEN-LAST:event_close_lblMouseEntered

    private void close_lblMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_close_lblMouseExited

        close_lbl.setForeground(new Color(255,255,255));
    }//GEN-LAST:event_close_lblMouseExited

    private void close_lblMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_close_lblMousePressed

       this.dispose();
    }//GEN-LAST:event_close_lblMousePressed

    private void add_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_add_btnActionPerformed
       
        
         if (!name_txt.getText().isEmpty()) {
                         if (!birthdate_txt.getText().isEmpty()) {
                             if (!genderCbox.getSelectedItem().equals("Select")  ) {
                                  if (!genderCbox_relation.getSelectedItem().equals("Select")) {
                                 
                                    
                                             
                                             
                                 int id = Integer.parseInt(id_txt.getText());
                                 String name =  name_txt.getText()  ;
                                 String birthdate =  birthdate_txt.getText()  ;
                                 String gender  =  genderCbox.getSelectedItem().toString()  ;
                                 String relationship  =  genderCbox_relation.getSelectedItem().toString()  ;
                                 
                                
                                




                                          //insert data in table       
                                      insertUser(name, birthdate, gender, householdID, relationship);
                                        
                                //clear textfeilds
                                       
                                
                                name_txt.setText("");
                                genderCbox.setSelectedIndex(0);
                                genderCbox_relation.setSelectedIndex(0);
                              
                                birthdate_txt.setText("");
                                
                                
                                //display new data in  table
                                         loadDatabase();
                                       
                                             int nextID = NextIdFromDatabase();
                                             id_txt.setText(String.valueOf(nextID));
                                       
                                      
                               
                             } else {
                            JOptionPane.showMessageDialog(null, "Relationship is empty");
                             }
                             } else {
                            JOptionPane.showMessageDialog(null, "Gender is empty");
                             }
                           
                         } else {
                              JOptionPane.showMessageDialog(null, "birthdate is empty.");
                         }
                   } else {
                         JOptionPane.showMessageDialog(null, "Name is Empty.");
                   }
         
        
        
    }//GEN-LAST:event_add_btnActionPerformed

     private void loadDatabase(){
    
          DefaultTableModel model = (DefaultTableModel) table_persons.getModel();
         model.setRowCount(0);
         
         
         try {
            pst = con.prepareCall("SELECT person.id,person.name,person.datebirth,person.gender, person.relationship FROM person "
                    + "INNER JOIN household ON household.id = person.household_id WHERE person.household_id = ?; ");
            pst.setInt(1,householdID);
            rs = pst.executeQuery();
            
            while(rs.next()){
            Object[] rowdata = new Object[5];
            
            for(int i = 0; i < 5; i++){
            
                rowdata[i] =rs.getObject(i+1);
            
            }
            table_persons.addRow(rowdata);
            
            }
        } catch (SQLException ex) {  
            Logger.getLogger(addFamilyMember.class.getName()).log(Level.SEVERE, null, ex);
        }
        
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
            java.util.logging.Logger.getLogger(addFamilyMember.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(addFamilyMember.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(addFamilyMember.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(addFamilyMember.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new addFamilyMember().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private classes.Button add_btn;
    private classes.Textfield birthdate_txt;
    private classes.calendarBtn calendarBtn2;
    private javax.swing.JLabel close_lbl;
    private com.raven.datechooser.DateChooser dateChooser1;
    private classes.ComboBox genderCbox;
    private classes.ComboBox genderCbox_relation;
    private classes.Textfield id_txt;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private classes.Textfield name_txt;
    private swing.PanelShadow panelShadow1;
    private classes.Table table_persons;
    // End of variables declaration//GEN-END:variables
}
