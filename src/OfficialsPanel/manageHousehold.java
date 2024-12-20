/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package OfficialsPanel;

import superAdminPanel.*;
import classes.DataModel;
import classes.ScrollBar;
import classes.tablActionCellRenderer1;
import classes.tableActionCellEditor1;
import classes.tableActionEvent1;
import connection.Connect;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
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
public class manageHousehold extends javax.swing.JPanel {

   
    Connection con;
    PreparedStatement pst;
    ResultSet rs;
     
    private int kgID;
    
    public manageHousehold() {
        initComponents();
        con= Connect.con();
        jScrollPane1.setVerticalScrollBar(new ScrollBar());
        
        
         kgID = DataModel.getDatakgID() ;
         
         tableActionEvent1 event1 = new tableActionEvent1() {
            @Override
            public void onEdit(int row) {
                
                   int selectedrow  =table_household.getSelectedRow();
              
             if (selectedrow != -1) {
               
                   Object value = table_household.getValueAt(selectedrow, 0);
                        if (value != null) {
                           int idNo = Integer.parseInt(value.toString());
                           
                               try {
                                     
                    
                    pst = con.prepareCall("SELECT household.id,person.name,person.datebirth,household.contact,person.gender,household.purok_add "
                            + "FROM household INNER join person on household.id = person.household_id Where household.id = ? AND person.relationship = \"Family Head\";");
                    pst.setInt(1, idNo);
                    
                    rs = pst.executeQuery();
                    
                    while (rs.next()) {
                        
                        int h_id = rs.getInt("id");
                        String h_name = rs.getString("name");
                        String h_birth = rs.getString("datebirth");
                        String h_contact = rs.getString("contact");
                        String h_gender = rs.getString("gender");
                        int h_purok = rs.getInt("purok_add");
                        
                        id_txt.setText(String.valueOf(h_id));
                    name_txt.setText(h_name);
                    birthdate_txt.setText(h_birth);
                    contact_txt.setText(h_contact);
                    
                    if(h_gender.equals("Male")){
                        genderCbox.setSelectedIndex(1);
                    }
                    else if(h_gender.equals("Female")){
                        genderCbox.setSelectedIndex(2);
                    }
                    
                    purokAdd_txt.setText(String.valueOf(h_purok));
                    
                    
                    }
                    
                    
                    
                } catch (SQLException ex) {
                    Logger.getLogger(manageHousehold.class.getName()).log(Level.SEVERE, null, ex);
                }
                    
}
}
                    
                             }
       
                 
             
             
                     
        
                
                
               
            
             

            @Override
            public void onDelete(int row) {
                        if (table_household.isEditing()) {
                    table_household.getCellEditor().stopCellEditing();
                }
               deleteTableHousehold();
            }
        

            @Override
            public void onView(int row) {
                
                
            Object value = table_household.getModel().getValueAt(row, 0);
            int householdID = Integer.parseInt(value.toString());
        
            DataModel.setDataID(householdID);
                
            
               addFamilyMember addFM = new addFamilyMember();
               addFM.show();
            
            }
            
         }; 
        
                
      table_household.getColumnModel().getColumn(4).setCellRenderer(new tablActionCellRenderer1() );
        table_household.getColumnModel().getColumn(4).setCellEditor(new tableActionCellEditor1( event1) );
        
        
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
            table_household.addRow(rowdata);
            
            }
            
        } catch (SQLException ex) {  
            Logger.getLogger(superAdminPanel.dashboardPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
        }
        
         } catch (SQLException ex) {
        Logger.getLogger(accountManagement.class.getName()).log(Level.SEVERE, null, ex);
    }
    
           
           int iDD= NextIdFromDatabase();
           id_txt.setText(String.valueOf(iDD));
           
    }
    
    
     
    private void loadDatabase(){
    
         DefaultTableModel model = (DefaultTableModel) table_household.getModel();
         model.setRowCount(0);
        
         try {
            pst = con.prepareCall("SELECT household.id,person.name,household.purok_add,household.contact"
                    + "FROM household INNER JOIN person ON household.id = person.household_id; ");
            rs = pst.executeQuery();
            
            while(rs.next()){
            Object[] rowdata = new Object[4];
            
            for(int i = 0; i < 4; i++){
            
                rowdata[i] =rs.getObject(i+1);
            
            }
            table_household.addRow(rowdata);
            
            }
        } catch (SQLException ex) {  
            Logger.getLogger(dashboardPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
 private void deleteTableHousehold(){

 int selectedRow = table_household.getSelectedRow();

              
                    // Extract information from the selected row
                    int userId = (int) table_household.getValueAt(selectedRow, 0);

                    // Construct the SQL DELETE statement
                    String sql = "DELETE FROM household WHERE id = ?";

                    try (PreparedStatement statement = con.prepareStatement(sql)) {
                        // Set the parameter in the DELETE statement
                        statement.setInt(1, userId);

                        // Execute the DELETE statement
                        statement.executeUpdate();

                        // Remove the selected row from the JTable model
                        DefaultTableModel model = (DefaultTableModel) table_household.getModel();
                        model.removeRow(selectedRow);

                      
                       
                    
                    } catch (SQLException ex) {
                        Logger.getLogger(accountManagement.class.getName()).log(Level.SEVERE, null, ex);
                    }



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
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        table_household = new classes.Table();
        jLabel2 = new javax.swing.JLabel();
        panelShadow1 = new swing.PanelShadow();
        name_txt = new classes.Textfield();
        jLabel6 = new javax.swing.JLabel();
        calendarBtn2 = new classes.calendarBtn();
        birthdate_txt = new classes.Textfield();
        jLabel8 = new javax.swing.JLabel();
        contact_txt = new classes.Textfield();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        purokAdd_txt = new classes.Textfield();
        jLabel11 = new javax.swing.JLabel();
        add_btn = new classes.Button();
        id_txt = new classes.Textfield();
        jLabel12 = new javax.swing.JLabel();
        genderCbox = new classes.ComboBox();

        dateChooser1.setForeground(new java.awt.Color(82, 190, 128));
        dateChooser1.setDateFormat("MMMM-dd-yyyy");
        dateChooser1.setTextRefernce(birthdate_txt);

        setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("SansSerif", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("MANAGE HOUSEHOLD");

        table_household.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Head of Family", "Purok Address", "Contact", "Action"
            }
        ));
        table_household.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane1.setViewportView(table_household);

        jLabel2.setFont(new java.awt.Font("SansSerif", 1, 15)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(51, 51, 51));
        jLabel2.setText("List of Household");

        panelShadow1.setBackground(new java.awt.Color(204, 204, 204));

        jLabel6.setFont(new java.awt.Font("SansSerif", 1, 15)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(39, 55, 70));
        jLabel6.setText("Name");

        calendarBtn2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/raven/datechooser/calendar (2).png"))); // NOI18N
        calendarBtn2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                calendarBtn2ActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("SansSerif", 1, 15)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(39, 55, 70));
        jLabel8.setText("Birthdate");

        jLabel9.setFont(new java.awt.Font("SansSerif", 1, 15)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(39, 55, 70));
        jLabel9.setText("Contact No.");

        jLabel10.setFont(new java.awt.Font("SansSerif", 1, 15)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(39, 55, 70));
        jLabel10.setText("Gender");

        jLabel11.setFont(new java.awt.Font("SansSerif", 1, 15)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(39, 55, 70));
        jLabel11.setText("Purok Address");

        add_btn.setText("Add Household Head");
        add_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                add_btnActionPerformed(evt);
            }
        });

        id_txt.setEditable(false);

        jLabel12.setFont(new java.awt.Font("SansSerif", 1, 15)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(39, 55, 70));
        jLabel12.setText("ID");

        genderCbox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Select", "Male", "Female" }));

        javax.swing.GroupLayout panelShadow1Layout = new javax.swing.GroupLayout(panelShadow1);
        panelShadow1.setLayout(panelShadow1Layout);
        panelShadow1Layout.setHorizontalGroup(
            panelShadow1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelShadow1Layout.createSequentialGroup()
                .addGap(140, 140, 140)
                .addGroup(panelShadow1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelShadow1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(panelShadow1Layout.createSequentialGroup()
                            .addGroup(panelShadow1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(name_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 325, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(175, 175, 175))
                        .addGroup(panelShadow1Layout.createSequentialGroup()
                            .addComponent(birthdate_txt, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(calendarBtn2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(129, 129, 129)))
                    .addGroup(panelShadow1Layout.createSequentialGroup()
                        .addGroup(panelShadow1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(id_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 325, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(32, 32, 32)))
                .addGroup(panelShadow1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelShadow1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelShadow1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(contact_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 325, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelShadow1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(purokAdd_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 325, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(add_btn, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(genderCbox, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 325, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(115, 115, 115))
        );
        panelShadow1Layout.setVerticalGroup(
            panelShadow1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelShadow1Layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(panelShadow1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(panelShadow1Layout.createSequentialGroup()
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(contact_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelShadow1Layout.createSequentialGroup()
                        .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(id_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelShadow1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelShadow1Layout.createSequentialGroup()
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(name_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelShadow1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(birthdate_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(calendarBtn2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(panelShadow1Layout.createSequentialGroup()
                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(genderCbox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(purokAdd_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27)
                        .addComponent(add_btn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(35, Short.MAX_VALUE))
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
                            .addComponent(jScrollPane1)
                            .addComponent(panelShadow1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(17, 17, 17)
                                .addComponent(jLabel1))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(53, 53, 53)
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(41, 41, 41)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(panelShadow1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void add_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_add_btnActionPerformed
       
      
         if(add_btn.getText().equals("Add Household Head")){
          if (!name_txt.getText().isEmpty()) {
                         if (!birthdate_txt.getText().isEmpty()) {
                             if (!genderCbox.getSelectedItem().equals("Select")  ) {
                                 
                                     if(!contact_txt.getText().isEmpty()){
                                         
                                         if(!purokAdd_txt.getText().isEmpty()){
                                    
                                             
                                             
                                 int id = Integer.parseInt(id_txt.getText());
                                 String name =  name_txt.getText()  ;
                                 String birthdate =  birthdate_txt.getText()  ;
                                 String gender  =  genderCbox.getSelectedItem().toString()  ;
                                 
                                 String contact =  contact_txt.getText()  ;
                                 int purok_add  =  Integer.parseInt(purokAdd_txt.getText())  ;




                                          //insert data in table       
                               insertUser(name, birthdate , contact,  gender,  id , purok_add) ;
                                        
                                //clear textfeilds
                                       
                                id_txt.setText("");
                                name_txt.setText("");
                                genderCbox.setSelectedIndex(0);
                                contact_txt.setText("");
                                purokAdd_txt.setText("");
                                birthdate_txt.setText("");
                                
                                
                                //display new data in  table
                                         loadDatabase();
                                         int iDD= NextIdFromDatabase();
                                             id_txt.setText(String.valueOf(iDD));
                                                
                                       
                                        }else{
                                       JOptionPane.showMessageDialog(null, "Purok is empty..");
                                             }  
                                       }else{
                                     JOptionPane.showMessageDialog(null, "Contact is Empty.");
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
         
         }else{
         
          if (!name_txt.getText().isEmpty()) {
                         if (!birthdate_txt.getText().isEmpty()) {
                             if (!genderCbox.getSelectedItem().equals("Select")  ) {
                                 
                                     if(!contact_txt.getText().isEmpty()){
                                         
                                         if(!purokAdd_txt.getText().isEmpty()){
                                    
                                             
                                             
                                 int id = Integer.parseInt(id_txt.getText());
                                 String name =  name_txt.getText()  ;
                                 String birthdate =  birthdate_txt.getText()  ;
                                 String gender  =  genderCbox.getSelectedItem().toString()  ;
                                 
                                 String contact =  contact_txt.getText()  ;
                                 int purok_add  =  Integer.parseInt(purokAdd_txt.getText())  ;




                                          //update data in table       
                                             updateOfficial(purok_add, contact, id, name, birthdate, gender);
                                        
                                //clear textfeilds
                                       
                                id_txt.setText("");
                                name_txt.setText("");
                                genderCbox.setSelectedIndex(0);
                                contact_txt.setText("");
                                purokAdd_txt.setText("");
                                birthdate_txt.setText("");
                                
                                
                                //display new data in  table
                                         loadDatabase();
                                         int iDD= NextIdFromDatabase();
                                         id_txt.setText(String.valueOf(iDD));
                                                
                                       
                                        }else{
                                       JOptionPane.showMessageDialog(null, "Purok is empty..");
                                             }  
                                       }else{
                                     JOptionPane.showMessageDialog(null, "Contact is Empty.");
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
         
         }
         
        
    }//GEN-LAST:event_add_btnActionPerformed

    private void calendarBtn2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_calendarBtn2ActionPerformed

        dateChooser1.showPopup();
    }//GEN-LAST:event_calendarBtn2ActionPerformed

    
    
     private int NextIdFromDatabase() {
    int nextId = 0;

    try {
        // Get the auto-increment value for the table
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery("SHOW TABLE STATUS LIKE 'household'");
        
        if (rs.next()) {
            nextId = rs.getInt("Auto_increment");
        }

        stmt.close();
    } catch (SQLException ex) {
        Logger.getLogger(superAdminPanel.accountManagement.class.getName()).log(Level.SEVERE, null, ex);
    }

    return nextId;
}    
 
    
    
     private void updateOfficial(int pAdd, String contact, int  ID , String Pname, String date, String gender) {
    try {
        String sql = "UPDATE `household` SET `purok_add` = ?, `contact` = ? WHERE `Id` = ?";
        String sql1 = "UPDATE `person` SET `name` = ?, `datebirth` = ?, `gender` = ? WHERE `household_id` = ?";
        
        try (PreparedStatement statement = con.prepareStatement(sql); PreparedStatement statement1 = con.prepareStatement(sql1)) {
            statement.setInt(1, pAdd);
            statement.setString(2, contact);
            statement.setInt(3, ID);
            statement.executeUpdate();
            
            statement1.setString(1, Pname);
            statement1.setString(2, date);
            statement1.setString(3, gender); 
            statement1.setInt(4, ID);
          
           
            
          
            statement1.executeUpdate();
        }
    } catch (SQLException ex) {
        Logger.getLogger(superAdminPanel.accountManagement.class.getName()).log(Level.SEVERE, null, ex);
    }
}
    
    
 private void insertUser(String name, String date, String contact, String gender,  int id, int purok) {
    String sql = "INSERT INTO `household` ( `purok_add`,`contact`) VALUES (?,?)" ;
    try (PreparedStatement statement = con.prepareStatement(sql)) {
        statement.setInt(1, purok);
        statement.setString(2, contact);
        statement.executeUpdate();
       
             try {
             String sql1 =   "INSERT INTO `person`(`household_id`, `name`, `datebirth`, `gender`,`relationship`) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement statement1 = con.prepareStatement(sql1);
                  statement1.setInt(1, id);
                   statement1.setString(2, name);
                   statement1.setString(3, date);
                   statement1.setString(4, gender);
                   statement1.setString(5, "Family Head");
                  
                   
                 statement1.executeUpdate();
                 
                 
              
                 
                   } catch (SQLException ex) {
              Logger.getLogger(manageHousehold.class.getName()).log(Level.SEVERE, null, ex);
     
        }
        
    } catch (SQLException ex) {
        Logger.getLogger(manageHousehold.class.getName()).log(Level.SEVERE, null, ex);
    }
}

    
    
    

    
    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private classes.Button add_btn;
    private classes.Textfield birthdate_txt;
    private classes.calendarBtn calendarBtn2;
    private classes.Textfield contact_txt;
    private com.raven.datechooser.DateChooser dateChooser1;
    private classes.ComboBox genderCbox;
    private classes.Textfield id_txt;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private classes.Textfield name_txt;
    private swing.PanelShadow panelShadow1;
    private classes.Textfield purokAdd_txt;
    private classes.Table table_household;
    // End of variables declaration//GEN-END:variables
}
