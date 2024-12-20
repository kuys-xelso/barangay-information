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
public class tableActionCellEditor extends DefaultCellEditor{

    private tableActionEvent event;
    
    
    public tableActionCellEditor( tableActionEvent event) {
        super(new JCheckBox());
        this.event = event;
    }

    
    
    
    @Override
    public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
       
    PanelAction action = new PanelAction();
    action.initEvent(event, row);
    action.setBackground(table.getSelectionBackground());
    return action;
    
    }

   
    
}
