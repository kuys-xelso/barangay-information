/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package classes;

import java.awt.Component;
import javax.swing.DefaultCellEditor;
import javax.swing.JCheckBox;
import javax.swing.JTable;

/**
 *
 * @author Hector
 */
public class tableActionCellEditor11 extends DefaultCellEditor{

    private tableActionEvent11 event11;
    
    
    public tableActionCellEditor11( tableActionEvent11 event11) {
        super(new JCheckBox());
        this.event11 = event11;
    }

    
    
    
    @Override
    public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
       
    PanelAction11 action = new PanelAction11();
    action.initEvent11(event11, row);
    action.setBackground(table.getSelectionBackground());
    return action;
    
    }

   
    
}
