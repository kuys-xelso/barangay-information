/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package superAdminPanel;

import classes.modelOfficialcard;
import connection.Connect;
import java.awt.Color;
import java.awt.Image;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import swing.PictureBox;

/**
 *
 * @author Hector
 */
public class officialListPanel extends javax.swing.JPanel {

   
    Connection con;
    PreparedStatement pst;
    ResultSet rs;
    
     ArrayList<Integer> idList = new ArrayList<>();
    
    
    public officialListPanel() {
        initComponents();
        con = Connect.con();
       
       officialIDList();
                 
//    try {
//    // Assuming you have a method to get the list of IDs
//
//    for (int currentNumber : idList) {
//        pst = con.prepareCall("SELECT brgy_officials.name, brgy_officials.Position, officials_data.image FROM brgy_officials "
//                + "INNER JOIN officials_data ON brgy_officials.id = officials_data.brgy_off_id WHERE brgy_officials.id = ?;");
//        pst.setInt(1, currentNumber);
//        rs = pst.executeQuery();
//
//        if (rs.next()) {
//            String name = rs.getString("name");
//            String position = rs.getString("Position");
//            // Assuming you have a method to retrieve the image from the ResultSet
//            byte[] imageData = rs.getBytes("image");
//            ImageIcon imageIcon = new ImageIcon(imageData);
//
//             // Create a new modelOfficialcard object with the retrieved data
//          
//          
//          
//        }
//    }
//} catch (SQLException ex) {
//    Logger.getLogger(officialListPanel.class.getName()).log(Level.SEVERE, null, ex);
//}
//        
//try {
//   
//        // Assuming you have a method to get the list of IDs
//
//    for (int currentNumber : idList) {
//        pst = con.prepareCall("SELECT brgy_officials.name, brgy_officials.Position, officials_data.image FROM brgy_officials "
//                + "INNER JOIN officials_data ON brgy_officials.id = officials_data.brgy_off_id WHERE brgy_officials.id = ?;");
//        pst.setInt(1, currentNumber);
//        rs = pst.executeQuery();
//
//        while (rs.next()) {
//            String name = rs.getString("name");
//            String position = rs.getString("Position");
//            // Assuming you have a method to retrieve the image from the ResultSet
//            byte[] imageData = rs.getBytes("image");
//            ImageIcon imageIcon = new ImageIcon(imageData);
//
//            // Create a new modelOfficialcard object with the retrieved data
//            modelOfficialcard officialCard = new modelOfficialcard(name, position, imageIcon);
//
//            // Set the data in each card_off object based on the currentNumber
//            switch (currentNumber) {
//                case 1:
//                    card_off1.setData(officialCard);
//                    break;
//                case 2:
//                    card_off2.setData(officialCard);
//                    break;
//                case 3:
//                    card_off3.setData(officialCard);
//                    break;
//                case 4:
//                    card_off4.setData(officialCard);
//                    break;
//                case 5:
//                    card_off5.setData(officialCard);
//                    break;
//                case 6:
//                    card_off6.setData(officialCard);
//                    break;
//                default:
//                    break;
//            }
//        }
//    }
//} catch (SQLException ex) {
//    Logger.getLogger(officialListPanel.class.getName()).log(Level.SEVERE, null, ex);
//}
        
    }

    
  
    
    
    
    // Display image method
    
//    private void displayImage(PictureBox imagelbl, JLabel namelbl,JLabel positionlbl, int off_id){
//    
//    try {
//    // Establish a connection to the database
//   
//    
//    pst = con.prepareCall(" SELECT brgy_officials.name, brgy_officials.Position,officials_data.image FROM brgy_officials INNER " +
//"            JOIN officials_data on brgy_officials.id = officials_data.brgy_off_id WHERE brgy_officials.id = ?;");
//    pst.setInt(1,off_id);
//   rs = pst.executeQuery();
//   
//            while (rs.next()) {            
//            
//                String Name = rs.getString("name");
//                String Position = rs.getString("Position");
//                 byte[] imageData = rs.getBytes("image");
//                 
//               
//                 
//                  namelbl.setText(Name);
//                positionlbl.setText(Position);
//                  ImageIcon imageIcon = new ImageIcon(imageData);
//                  imagelbl.setImage(imageIcon);
//                  imagelbl.repaint();
//      
//       
//                
//                
//                
//        }
//   
//   
//   
//   
////   if(rs.next()){
////   
////       
////        String name = rs.getString("Name");
////        String pos = rs.getString("Position");
////        
////        namelbl.setText(name);
////        positionlbl.setText(pos);
////        
////        
////        pst = con.prepareCall("Select image From officials_data Where Id = ?");
////        pst.setInt(1, id);
////        rs = pst.executeQuery();
////   
////   
////        
////        while (rs.next()) {
////        // Retrieve the image data from the result set
////        byte[] imageData = rs.getBytes("image"); // Replace with the actual column name
////
////        // Convert the image data into a format that can be displayed
////        ImageIcon imageIcon = new ImageIcon(imageData);
////        
////        // Display the image in the label
////        imagelbl.setImage(imageIcon);
////        
////    }
////   }
//  
//} catch (Exception e) {
//    e.printStackTrace();
//}
//    
//    }
    
    
    
//    
//    SELECT brgy_officials.name, brgy_officials.Position,officials_data.image FROM brgy_officials INNER 
//            JOIN officials_data on brgy_officials.id = officials_data.brgy_off_id;
    
    
    private void officialIDList(){
    
           try {
               pst = con.prepareCall("SELECT Id FROM brgy_officials");
               rs = pst.executeQuery();
               
               while(rs.next()){
                     int officialId = rs.getInt("Id");
                        idList.add(officialId);
               
               }
               
               
           } catch (SQLException ex) {
               Logger.getLogger(officialListPanel.class.getName()).log(Level.SEVERE, null, ex);
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

        setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1060, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1821, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    
    void setColor(JLabel label){
    
        label.setForeground(new Color(52, 152, 219));
    }
    
   void resetColor (JLabel label){
   
        label.setForeground(new Color(89,89,89));
   }
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
