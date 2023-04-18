/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TorresDeHanoi.Visual;

import java.awt.Component;

import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author tutaa
 */

public class CenterTableCellRenderer extends DefaultTableCellRenderer {

    public CenterTableCellRenderer() {
        super();
    }

    public Component getTableCellRendererComponent(JTable table, Object value,
            boolean isSelected, boolean hasFocus, int row, int column) {
        Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
        if (c instanceof JLabel) {
            JLabel label = (JLabel) c;
            label.setHorizontalAlignment(SwingConstants.CENTER);
        }
        return c;
    }
}