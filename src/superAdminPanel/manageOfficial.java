/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package superAdminPanel;

import classes.ScrollBar;
import classes.tablActionCellRenderer;
import classes.tablActionCellRenderer11;
import classes.tableActionCellEditor;
import classes.tableActionCellEditor11;
import classes.tableActionEvent;
import classes.tableActionEvent11;
import connection.Connect;
import java.awt.Color;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import swing.PictureBox;

/**
 *
 * @author Hector
 */
public class manageOfficial extends javax.swing.JFrame {

     File f = null;
    String path = null;
    private ImageIcon format = null;
    String fname= null;
    int s = 0;
    byte[] pimage=null;
    
    
    Connection con;
    PreparedStatement pst;
    ResultSet rs;
    
    
    public manageOfficial() {
        initComponents();
        con = Connect.con();
        jScrollPane1.setVerticalScrollBar(new ScrollBar());
        
         tableActionEvent11 event11 = new tableActionEvent11() {
            @Override
            public void onEdit(int row) {
                System.out.println("EDIT ROW: " + row);
                int selectedrow  =tableOfficials_data.getSelectedRow();
              
                   if (selectedrow != -1) {
               
                   Object value = tableOfficials_data.getValueAt(selectedrow, 0);
                        if (value != null) {
                           int idNo = Integer.parseInt(value.toString());
                           
                           id_txt.setText(String.valueOf(idNo));
                           
                           
                            if (selectedrow != -1) {
               
                 Object[] rowData = new Object[8];

             for (int i = 0; i < 8; i++) {
                rowData[i] =  tableOfficials_data.getValueAt(selectedrow, i);
                 }

             
             
             
             
               
                     name_txt.setText(rowData[1].toString());
                     position_txt.setText(rowData[2].toString());
                     gender_txt.setText(rowData[3].toString());
                     age_txt.setText(rowData[4].toString());
                     contact_txt.setText(rowData[5].toString());
                     username_txt.setText(rowData[6].toString());
                     password_txt.setText(rowData[7].toString());
                   
                    imageAndPath(id_txt.getText());
                     
        }
                        }
                   }
                
                
            
               
             
            
             labelImage1.repaint();
             savebtn.setText("Save");
                
                 }

            @Override
            public void onDelete(int row) {
              
                if (tableOfficials_data.isEditing()) {
                    tableOfficials_data.getCellEditor().stopCellEditing();
                }
                 deleteOfficial();
            }
        };
                
            
         int id =  NextIdFromDatabase();
         id_txt.setText(String.valueOf(id));
         
         
        tableOfficials_data.getColumnModel().getColumn(8).setCellRenderer(new tablActionCellRenderer11());
        tableOfficials_data.getColumnModel().getColumn(8).setCellEditor(new tableActionCellEditor11(event11) );
    
    
    
    
      try {
           pst = con.prepareCall("SELECT brgy_officials.id,brgy_officials.Name,brgy_officials.Position,officials_data.gender,officials_data.age,officials_data.contact,"
                    + " officials_data.username,officials_data.password FROM brgy_officials "
                    + "INNER JOIN officials_data ON Brgy_Officials.Id = officials_data.brgy_off_id; ");
            rs = pst.executeQuery();
            
            while(rs.next()){
            Object[] rowdata = new Object[8];
            
            for(int i = 0; i < 8; i++){
            
                rowdata[i] =rs.getObject(i+1);
            
            }
            tableOfficials_data.addRow(rowdata);
            
            }
           
        } catch (SQLException ex) {
            Logger.getLogger(accountManagement.class.getName()).log(Level.SEVERE, null, ex);
        }

    
    
    
    
    
    
    
    
    
    }

    
    private void imageAndPath(String id) {
    try {
        pst = con.prepareStatement("SELECT * FROM officials_data WHERE brgy_off_id = ?;");
        pst.setString(1, id);
        rs = pst.executeQuery();
        
        if (rs.next()) {
            loadImage();
            String path = rs.getString("imagePath");
            File f = new File(path);

    
            imagePath_txt.setText(path);
            
        } else {
            JOptionPane.showMessageDialog(null, "No image found");
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
}

public void loadImage() {
    try {
        byte[] imageData = rs.getBytes("image");
        
            ImageIcon mm = new ImageIcon(imageData);
            
            
            labelImage1.setImage(mm);
            labelImage1.repaint();
        
    } catch (SQLException e) {
        e.printStackTrace();
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
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        close_lbl = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableOfficials_data = new classes.Table();
        panelShadow1 = new swing.PanelShadow();
        imagePath_txt = new classes.Textfield();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        age_txt = new classes.Textfield();
        username_txt = new classes.Textfield();
        jLabel11 = new javax.swing.JLabel();
        gender_txt = new classes.Textfield();
        jLabel12 = new javax.swing.JLabel();
        position_txt = new classes.Textfield();
        jLabel9 = new javax.swing.JLabel();
        name_txt = new classes.Textfield();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        contact_txt = new classes.Textfield();
        jLabel15 = new javax.swing.JLabel();
        browse_btn = new classes.Button();
        password_txt = new classes.Passwordfeild();
        showPass = new javax.swing.JCheckBox();
        panelShadow3 = new swing.PanelShadow();
        labelImage1 = new swing.PictureBox();
        jLabel8 = new javax.swing.JLabel();
        savebtn = new classes.Button();
        id_txt = new classes.Textfield();
        jLabel16 = new javax.swing.JLabel();

        dateChooser1.setForeground(new java.awt.Color(82, 190, 128));
        dateChooser1.setDateFormat("MMMM-dd-yyyy");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(229, 229, 229));
        jPanel1.setForeground(new java.awt.Color(32, 35, 34));
        jPanel1.setToolTipText("");
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(22, 160, 133));

        close_lbl.setBackground(new java.awt.Color(231, 76, 60));
        close_lbl.setFont(new java.awt.Font("Roboto Medium", 0, 18)); // NOI18N
        close_lbl.setForeground(new java.awt.Color(39, 55, 70));
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

        jLabel10.setFont(new java.awt.Font("SansSerif", 1, 24)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("Barangay Sal - ing City");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(1156, Short.MAX_VALUE)
                .addComponent(close_lbl, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup()
                    .addGap(99, 99, 99)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 999, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(99, Short.MAX_VALUE)))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(close_lbl, javax.swing.GroupLayout.DEFAULT_SIZE, 33, Short.MAX_VALUE)
                .addGap(17, 17, 17))
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup()
                    .addGap(12, 12, 12)
                    .addComponent(jLabel10)
                    .addContainerGap(12, Short.MAX_VALUE)))
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("SansSerif", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("MANAGE OFFICIALS");

        tableOfficials_data.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Fullname", "Position", "Gender", "Age", "Contact", "Username", "Password", "Action"
            }
        ));
        tableOfficials_data.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane1.setViewportView(tableOfficials_data);

        panelShadow1.setBackground(new java.awt.Color(204, 204, 204));
        panelShadow1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        panelShadow1.add(imagePath_txt, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 270, 220, 30));

        jLabel6.setFont(new java.awt.Font("SansSerif", 1, 15)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(39, 55, 70));
        jLabel6.setText("Image");
        panelShadow1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 250, 123, 16));

        jLabel7.setFont(new java.awt.Font("SansSerif", 1, 15)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(39, 55, 70));
        jLabel7.setText("Age");
        panelShadow1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(766, 45, 91, 16));
        panelShadow1.add(age_txt, new org.netbeans.lib.awtextra.AbsoluteConstraints(766, 67, 234, 37));
        panelShadow1.add(username_txt, new org.netbeans.lib.awtextra.AbsoluteConstraints(766, 200, 234, 37));

        jLabel11.setFont(new java.awt.Font("SansSerif", 1, 15)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(39, 55, 70));
        jLabel11.setText("Username");
        panelShadow1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(766, 178, 123, 16));
        panelShadow1.add(gender_txt, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 265, 234, 37));

        jLabel12.setFont(new java.awt.Font("SansSerif", 1, 15)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(39, 55, 70));
        jLabel12.setText("Gender");
        panelShadow1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 243, 123, 16));
        panelShadow1.add(position_txt, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 200, 234, 37));

        jLabel9.setFont(new java.awt.Font("SansSerif", 1, 15)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(39, 55, 70));
        jLabel9.setText("Position");
        panelShadow1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 175, 123, 16));
        panelShadow1.add(name_txt, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 132, 234, 37));

        jLabel13.setFont(new java.awt.Font("SansSerif", 1, 15)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(39, 55, 70));
        jLabel13.setText("Name");
        panelShadow1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 110, 123, 16));

        jLabel14.setFont(new java.awt.Font("SansSerif", 1, 15)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(39, 55, 70));
        jLabel14.setText("Password");
        panelShadow1.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(766, 243, 123, 16));
        panelShadow1.add(contact_txt, new org.netbeans.lib.awtextra.AbsoluteConstraints(766, 132, 234, 37));

        jLabel15.setFont(new java.awt.Font("SansSerif", 1, 15)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(39, 55, 70));
        jLabel15.setText("Contact No.");
        panelShadow1.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(766, 110, 123, 16));

        browse_btn.setBackground(new java.awt.Color(0, 204, 204));
        browse_btn.setText("Browse");
        browse_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                browse_btnActionPerformed(evt);
            }
        });
        panelShadow1.add(browse_btn, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 310, 89, 30));
        panelShadow1.add(password_txt, new org.netbeans.lib.awtextra.AbsoluteConstraints(766, 265, 234, 37));

        showPass.setForeground(new java.awt.Color(255, 255, 255));
        showPass.setText("Show Password");
        showPass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                showPassActionPerformed(evt);
            }
        });
        panelShadow1.add(showPass, new org.netbeans.lib.awtextra.AbsoluteConstraints(766, 314, 204, 12));

        javax.swing.GroupLayout panelShadow3Layout = new javax.swing.GroupLayout(panelShadow3);
        panelShadow3.setLayout(panelShadow3Layout);
        panelShadow3Layout.setHorizontalGroup(
            panelShadow3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelShadow3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(labelImage1, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        panelShadow3Layout.setVerticalGroup(
            panelShadow3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelShadow3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelImage1, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        panelShadow1.add(panelShadow3, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 70, 180, 170));

        jLabel8.setFont(new java.awt.Font("SansSerif", 1, 15)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(39, 55, 70));
        jLabel8.setText("ID");
        panelShadow1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 42, 123, 16));

        savebtn.setText("Add");
        savebtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                savebtnActionPerformed(evt);
            }
        });
        panelShadow1.add(savebtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(911, 338, 89, -1));

        id_txt.setFocusable(false);
        id_txt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                id_txtActionPerformed(evt);
            }
        });
        panelShadow1.add(id_txt, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 67, 234, 37));

        jLabel16.setFont(new java.awt.Font("SansSerif", 1, 15)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(39, 55, 70));
        jLabel16.setText("Image");
        panelShadow1.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 50, 123, 16));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(panelShadow1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(41, 41, 41)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(panelShadow1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 50, 1200, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 763, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void close_lblMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_close_lblMousePressed

        this.dispose();
    }//GEN-LAST:event_close_lblMousePressed

    private void close_lblMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_close_lblMouseExited
        close_lbl.setOpaque(false);
        close_lbl.setForeground(new Color(39,55,70));

    }//GEN-LAST:event_close_lblMouseExited

    private void close_lblMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_close_lblMouseEntered

        close_lbl.setForeground(new Color(253, 254, 254));
        close_lbl.setOpaque(true);
    }//GEN-LAST:event_close_lblMouseEntered

    private void browse_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_browse_btnActionPerformed

        // browse photo from files
        JFileChooser fileChooser = new JFileChooser();
        FileNameExtensionFilter fnwf = new FileNameExtensionFilter("PNG JPG AND JPEG","png","jpeg","jpg");
        fileChooser.addChoosableFileFilter(fnwf);
        int load = fileChooser.showOpenDialog(null);

        if(load == fileChooser.APPROVE_OPTION){
            f =fileChooser.getSelectedFile();

            path = f.getAbsolutePath();
            imagePath_txt.setText(path);
            ImageIcon ii = new ImageIcon(path);
            labelImage1.setImage(ii);
            labelImage1.repaint();
        }

    }//GEN-LAST:event_browse_btnActionPerformed

    private void showPassActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_showPassActionPerformed

        if(showPass.isSelected()){
            password_txt.setEchoChar('\0');
        }else{
            password_txt.setEchoChar('\u2022');
        }
    }//GEN-LAST:event_showPassActionPerformed

    private void savebtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_savebtnActionPerformed

        int id = Integer.parseInt(id_txt.getText());
        String name =  name_txt.getText()  ;
        String position =  position_txt.getText()  ;
        String gender  =  gender_txt.getText()  ;
        int age = Integer.parseInt(age_txt.getText());
        String contact =  contact_txt.getText()  ;
        String username =  username_txt.getText()  ;
        String pass =  String.valueOf(password_txt.getText()) ;
       

        if(savebtn.getText().equals("Add")){
            if (!name_txt.getText().isEmpty()) {
                if (!position_txt.getText().isEmpty()) {
                    if (!gender_txt.getText().isEmpty() ) {
                        if(!age_txt.getText().isEmpty()){
                            if(!contact_txt.getText().isEmpty()){
                                if(!username_txt.getText().isEmpty()){
                                    if(!String.valueOf(password_txt).isEmpty()){
                                        if (!f.getName().isEmpty()) {
                                            if (!imagePath_txt.getText().isEmpty()) {

                                                //insert data in table
                                                insertOfficial(name, position,age, contact,  username,  pass , gender,  f, path,  id) ;

                                                //clear textfeilds
                                                labelImage1.setImage(null);
                                                labelImage1.repaint();
                                                imagePath_txt.setText("");
                                                name_txt.setText("");
                                                position_txt.setText("");
                                                gender_txt.setText("");
                                                age_txt.setText("");
                                                contact_txt.setText("");
                                                username_txt.setText("");
                                                password_txt.setText("");

                                                //display new data in  table
                                                loadDatafromDataBase();
                                                int B_id =  NextIdFromDatabase();
                                                 id_txt.setText(String.valueOf(B_id));
                                                accountManagement acM = new accountManagement();
                                                acM.repaint();
                                                PictureBox pc =new PictureBox();
                                                pc.repaint();

                                            } else {
                                                JOptionPane.showMessageDialog(null, "Image Path is empty.");
                                            }
                                        } else {
                                            JOptionPane.showMessageDialog(null, "Image is empty.");
                                        }
                                    }else{
                                        JOptionPane.showMessageDialog(null, "Password Feild is empty.");
                                    }
                                }else{
                                    JOptionPane.showMessageDialog(null, "Username is empty..");
                                }
                            }else{
                                JOptionPane.showMessageDialog(null, "Contact is Empty.");
                            }
                        }else{
                            JOptionPane.showMessageDialog(null, "Age is empty");
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Gender is empty");
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Position is empty.");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Fullname is Empty.");
            }
        }
        else{

            if (!name_txt.getText().isEmpty()) {
                if (!position_txt.getText().isEmpty()) {
                    if (!gender_txt.getText().isEmpty() ) {
                        if(!age_txt.getText().isEmpty()){
                            if(!contact_txt.getText().isEmpty()){
                                if(!username_txt.getText().isEmpty()){
                                    if(!String.valueOf(password_txt).isEmpty()){
                                        if (!f.getName().isEmpty()) {
                                            if (!imagePath_txt.getText().isEmpty()) {

                                                //insert data in table
                                                updateOfficial(id, name, position, age, contact, username, pass, gender, f, path);

                                                labelImage1.setImage(null);
                                                labelImage1.repaint();
                                                imagePath_txt.setText("");
                                                name_txt.setText("");
                                                position_txt.setText("");
                                                gender_txt.setText("");
                                                age_txt.setText("");
                                                contact_txt.setText("");
                                                username_txt.setText("");
                                                password_txt.setText("");

                                                //display new data in  table
                                                loadDatafromDataBase();
                                                  loadDatafromDataBase();
                                                int B_id =  NextIdFromDatabase();

                                            } else {
                                                JOptionPane.showMessageDialog(null, "Image Path is empty.");
                                            }
                                        } else {
                                            JOptionPane.showMessageDialog(null, "Image is empty.");
                                        }
                                    }else{
                                        JOptionPane.showMessageDialog(null, "Password Feild is empty.");
                                    }
                                }else{
                                    JOptionPane.showMessageDialog(null, "Username is empty..");
                                }
                            }else{
                                JOptionPane.showMessageDialog(null, "Contact is Empty.");
                            }
                        }else{
                            JOptionPane.showMessageDialog(null, "Age is empty");
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Gender is empty");
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Position is empty.");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Fullname is Empty.");
            }

        }

    }//GEN-LAST:event_savebtnActionPerformed

    private void id_txtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_id_txtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_id_txtActionPerformed

    
      //load database
    private void loadDatafromDataBase(){
     
         con = Connect.con();
         
         DefaultTableModel model = (DefaultTableModel) tableOfficials_data.getModel();
         model.setRowCount(0);
         
           try {
           pst = con.prepareCall("SELECT brgy_officials.id,brgy_officials.Name,brgy_officials.Position,officials_data.gender,officials_data.age,officials_data.contact,"
                    + " officials_data.username,officials_data.password FROM brgy_officials "
                    + "INNER JOIN officials_data ON Brgy_Officials.Id = officials_data.brgy_off_id; ");
            rs = pst.executeQuery();
            
            while(rs.next()){
            Object[] rowdata = new Object[8];
            
            for(int i = 0; i < 8; i++){
            
                rowdata[i] =rs.getObject(i+1);
            
            }
            tableOfficials_data.addRow(rowdata);
            
            }
           
        } catch (SQLException ex) {
            Logger.getLogger(accountManagement.class.getName()).log(Level.SEVERE, null, ex);
        }
         
     }
    
    
    
 private int NextIdFromDatabase() {
    int nextId = 0;

    try {
        // Get the auto-increment value for the table
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery("SHOW TABLE STATUS LIKE 'brgy_officials'");
        
        if (rs.next()) {
            nextId = rs.getInt("Auto_increment");
        }

        stmt.close();
    } catch (SQLException ex) {
        Logger.getLogger(accountManagement.class.getName()).log(Level.SEVERE, null, ex);
    }

    return nextId;
}    
 
 
 
 private void insertOfficial(String fullname, String position, int age, String contact, String usrname, String pass, String gender, File f,String path, int id) {
     InputStream is = null;
    try {
        String sql = "INSERT INTO `brgy_officials` (`Name`, `Position`) VALUES (?, ?)";
        String sql1 = "INSERT INTO `officials_data`(`gender`, `contact`, `age`, `username`, `password`,`brgy_off_id`,`image`,`imagePath`) VALUES (?, ?, ?, ?, ?, ?,?,?)";
              is = new FileInputStream(f);
              try (PreparedStatement statement = con.prepareStatement(sql); PreparedStatement statement1 = con.prepareStatement(sql1)) {
                  statement.setString(1, fullname);
                  statement.setString(2, position);
                  statement.executeUpdate();
                  
                  statement1.setString(1, gender);
                  statement1.setString(2, contact);
                  statement1.setInt(3, age);
                  statement1.setString(4, usrname);
                  statement1.setString(5, pass);
                  statement1.setInt(6, id);
                  statement1.setBlob(7,is );
                  statement1.setString(8, path);
                  
                  statement1.executeUpdate();
              } catch (SQLException ex) {
                  Logger.getLogger(accountManagement.class.getName()).log(Level.SEVERE, null, ex);
              }
    } catch (FileNotFoundException ex) {
        Logger.getLogger(accountManagement.class.getName()).log(Level.SEVERE, null, ex);
    } finally {
              try {
                  is.close();
              } catch (IOException ex) {
                  Logger.getLogger(accountManagement.class.getName()).log(Level.SEVERE, null, ex);
              }
          }
}
 
 
 
 //update table
 
 private void updateOfficial(int officialId, String fullname, String position, int age, String contact, String usrname, String pass, String gender, File f, String path) {
    try {
        String sql = "UPDATE `brgy_officials` SET `Name` = ?, `Position` = ? WHERE `Id` = ?";
        String sql1 = "UPDATE `officials_data` SET `gender` = ?, `contact` = ?, `age` = ?, `username` = ?, `password` = ?, `image` = ?, `imagePath` = ? WHERE `brgy_off_id` = ?";
        
        try (PreparedStatement statement = con.prepareStatement(sql); PreparedStatement statement1 = con.prepareStatement(sql1)) {
            statement.setString(1, fullname);
            statement.setString(2, position);
            statement.setInt(3, officialId);
            statement.executeUpdate();
            
            statement1.setString(1, gender);
            statement1.setString(2, contact);
            statement1.setInt(3, age);
            statement1.setString(4, usrname);
            statement1.setString(5, pass);
            
            // Convert the image file to a byte array
            try (InputStream is = new FileInputStream(f)) {
                byte[] imageBytes = is.readAllBytes();
                statement1.setBytes(6, imageBytes);
            }
            
            statement1.setString(7, path);
            statement1.setInt(8, officialId);
            statement1.executeUpdate();
        }
    } catch (SQLException | IOException ex) {
        Logger.getLogger(accountManagement.class.getName()).log(Level.SEVERE, null, ex);
    }
}
 
  private void deleteOfficial(){

 int selectedRow = tableOfficials_data.getSelectedRow();

              
                    // Extract information from the selected row
                    int userId = (int) tableOfficials_data.getValueAt(selectedRow, 0);

                    // Construct the SQL DELETE statement
                    String sql = "DELETE FROM brgy_officials WHERE id = ?";

                    try (PreparedStatement statement = con.prepareStatement(sql)) {
                        // Set the parameter in the DELETE statement
                        statement.setInt(1, userId);

                        // Execute the DELETE statement
                        statement.executeUpdate();

                        // Remove the selected row from the JTable model
                        DefaultTableModel model = (DefaultTableModel) tableOfficials_data.getModel();
                        model.removeRow(selectedRow);

                      
                       
                    
                    } catch (SQLException ex) {
                        Logger.getLogger(accountManagement.class.getName()).log(Level.SEVERE, null, ex);
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
            java.util.logging.Logger.getLogger(manageOfficial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(manageOfficial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(manageOfficial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(manageOfficial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new manageOfficial().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private classes.Textfield age_txt;
    private classes.Button browse_btn;
    private javax.swing.JLabel close_lbl;
    private classes.Textfield contact_txt;
    private com.raven.datechooser.DateChooser dateChooser1;
    private classes.Textfield gender_txt;
    private classes.Textfield id_txt;
    private classes.Textfield imagePath_txt;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private swing.PictureBox labelImage1;
    private classes.Textfield name_txt;
    private swing.PanelShadow panelShadow1;
    private swing.PanelShadow panelShadow3;
    private classes.Passwordfeild password_txt;
    private classes.Textfield position_txt;
    private classes.Button savebtn;
    private javax.swing.JCheckBox showPass;
    private classes.Table tableOfficials_data;
    private classes.Textfield username_txt;
    // End of variables declaration//GEN-END:variables
}
