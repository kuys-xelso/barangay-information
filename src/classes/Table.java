/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package classes;


import java.awt.Color;
import java.awt.Component;

import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;

/**
 *
 * @author gardh
 */
public class Table extends JTable{
    
    public Table(){
        
        setShowHorizontalLines(true);
        setGridColor(new Color(230,230,230));
        setRowHeight(40);
        getTableHeader().setReorderingAllowed(false);
        
         setDefaultRenderer(Object.class, new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable jtable, Object o, boolean selected, boolean bln1, int i, int i1) {
                
                    Component com = super.getTableCellRendererComponent(jtable, o, selected, bln1, i, i1);
                    
                    setBorder(noFocusBorder);
                   
                    return com;
                
              
            }
        });      
   
    }
    
     public void addRow(Object[] row) {
        DefaultTableModel model = (DefaultTableModel) getModel();
        model.addRow(row);
     }
     
   public void refreshTable(Object[][] updatedData, String[] columnNames) {
    DefaultTableModel model = new DefaultTableModel(updatedData, columnNames);
    setModel(model);
}
   
   

}

