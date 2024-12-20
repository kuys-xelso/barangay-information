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
public class tableActionCellEditorView extends DefaultCellEditor{

    private tableActionEventView event1;
    
    
    public tableActionCellEditorView( tableActionEventView event1) {
        super(new JCheckBox());
        this.event1 = event1;
    }

    
    
    
    @Override
    public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
       
    PanelActionView action = new PanelActionView();
    action.initEvent1(event1, row);
    action.setBackground(table.getSelectionBackground());
    return action;
    
    }

   
    
}
