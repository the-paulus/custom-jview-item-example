package com.paulusworld.CustomJListView;

import javax.swing.ImageIcon;

/**
 * Basic class that holds multiple pieces of data that will be displayed in a ListView.
 * 
 * @author Paul Lyon <pmlyon@gmail.com>
 *
 */
public class Item {

	/**
	 * Associated image for the list item.
	 */
	private ImageIcon imageIcon;
	
	/**
	 * Text of the item.
	 */
	private String text;
	
	/**
	 * Default constructor.
	 */
	public Item() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * Constructs a new Item object with the text of <em>text</em>.
	 * 
	 * @param text Text to use for the Item.
	 */
	public Item(String text) {
		
		setText(text);
		
	}
	
	/**
	 * Constructs a new Item object with the text of <em>text</em> and an ImageIcon.
	 * @param text Text to use for the Item.
	 * @param imageIcon Image to use for the Item.
	 */
	public Item(String text, ImageIcon imageIcon) {
		
		setText(text);
		setImageIcon(imageIcon);
		
	}

	/**
	 * Returns an {@see ImageIcon} object.
	 * 
	 * @return the imageIcon
	 */
	public ImageIcon getImageIcon() {
		
		return imageIcon;
		
	}

	/**
	 * Sets the {@see ImageIcon} for the Item.
	 * 
	 * @param imageIcon the iconFile to set
	 */
	public void setImageIcon(ImageIcon imageIcon) {
		
		this.imageIcon = imageIcon;
		
	}

	/**
	 * Returns the text of the Item.
	 * 
	 * @return the text
	 */
	public String getText() {
		
		return text;
		
	}

	/**
	 * Sets the text of the Item. 
	 * @param text the text to set
	 */
	public void setText(String text) {
		
		this.text = text;
		
	}

	@Override
	public String toString() {
		
		return getText();
		
	}
}
