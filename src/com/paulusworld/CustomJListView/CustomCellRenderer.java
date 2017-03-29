/**
 * 
 */
package com.paulusworld.CustomJListView;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.FlowLayout;

import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.ListCellRenderer;

/**
 * Renders List cells. This allows more data to be displayed in
 * more complex layouts. 
 * 
 * @author Paul Lyon <pmlyon@gmail.com>
 *
 */
public class CustomCellRenderer implements ListCellRenderer<Item> {

	/**
	 * Returns a single rendered cell as a Component. 
	 * 
	 * @param list The list component that will be displaying the data.
	 * @param value A single item or value that will be used to create a new cell.
	 * @param index Cell number.
	 * @param isSelected Whether or not a the item is selected.
	 * @param cellHasFocus Whether or not the cell has focus.
	 */
	@Override
	public Component getListCellRendererComponent(JList<? extends Item> list, Item value, int index, boolean isSelected,
			boolean cellHasFocus) {
		
		// Create a panel to hold a new layout and two labels.
		JPanel panel = new JPanel();
		// Set the layout to be a FlowLayout
		panel.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));
		
		// Create a label to hold an icon image.
		JLabel lblIcon = new JLabel();
		// Set the icon to be that specified from value.
		lblIcon.setIcon(value.getImageIcon());
		// Add the label containing the icon to the layout of the panel.
		panel.add(lblIcon, BorderLayout.WEST);		
		
		JLabel lblText = new JLabel();
		lblText.setText(value.getText());
		panel.add(lblText, BorderLayout.EAST);
		
		if(isSelected) {
			
			panel.setBackground(list.getSelectionBackground());
			panel.setForeground(list.getSelectionForeground());
			
		} else {
			
			panel.setBackground(list.getBackground());
			panel.setForeground(list.getForeground());
			
		}
		
		return panel;
	}

}
