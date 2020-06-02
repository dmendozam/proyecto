/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Estructuras;

import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Universidad
 */
public class CustomTableModel extends DefaultTableModel{

    @Override
    public boolean isCellEditable(int row, int column) {
        if(column == 0 || column == 8 || column == 9)
            return false;
        else
            return true;
    }
}
