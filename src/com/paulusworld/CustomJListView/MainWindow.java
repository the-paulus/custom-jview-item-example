package com.paulusworld.CustomJListView;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;

import java.awt.BorderLayout;
import java.awt.Component;

import javax.swing.JSplitPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import java.awt.FlowLayout;
import java.awt.Image;

import javax.swing.JTextField;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.JLabel;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MainWindow {

	private JFrame frame;
	private JTextField textField;
	private DefaultListModel<Item> listModel = new DefaultListModel<>();

	private final String DEFAULT_LABEL_TEXT = "Click to set icon";
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainWindow window = new MainWindow();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MainWindow() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new BorderLayout(0, 0));
		
		JSplitPane splitPane = new JSplitPane();
		splitPane.setOrientation(JSplitPane.VERTICAL_SPLIT);
		frame.getContentPane().add(splitPane, BorderLayout.CENTER);
		
		listModel.addElement(new Item("One"));
		listModel.addElement(new Item("Two"));
		
		JList<Item> list = new JList<Item>(listModel);
		list.setCellRenderer(new CustomCellRenderer());
		JScrollPane scrollPane = new JScrollPane(list);
		splitPane.setLeftComponent(scrollPane);
		
		JPanel panel = new JPanel();
		splitPane.setRightComponent(panel);
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel lblIcon = new JLabel(DEFAULT_LABEL_TEXT);
		lblIcon.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				File iconFile;
				JFileChooser fileChooser = new JFileChooser();
				fileChooser.setDialogTitle("Select icon");
				fileChooser.setFileFilter(new FileNameExtensionFilter("Image Files", "png", "jpg", "gif"));
				
				if(fileChooser.showOpenDialog((Component) e.getSource()) == JFileChooser.APPROVE_OPTION) {
					
					iconFile = fileChooser.getSelectedFile();
					ImageIcon imageIcon = new ImageIcon(iconFile.getAbsolutePath());				
					lblIcon.setIcon(new ImageIcon(imageIcon.getImage().getScaledInstance(32, 32, Image.SCALE_DEFAULT)));
					
				}
				
			}
			
		});
		
		panel.add(lblIcon);
		
		textField = new JTextField();
		panel.add(textField);
		textField.setColumns(10);  
		
		JButton btnAdd = new JButton("Add");
		
		btnAdd.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
			
				listModel.addElement(new Item(textField.getText(), (ImageIcon) lblIcon.getIcon()));
				list.updateUI();
				lblIcon.setIcon(null);
				textField.setText("");
		
			}
		
		});
		
		panel.add(btnAdd);
		
		JButton btnDelete = new JButton("Delete");
		
		btnDelete.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				try {
				listModel.remove(list.getSelectedIndex());
				list.updateUI();
				} catch(ArrayIndexOutOfBoundsException ex) {
					JOptionPane.showMessageDialog(frame, "Invalid Selection.", "Error", JOptionPane.ERROR_MESSAGE);
				}
				
			}
		});
		
		panel.add(btnDelete);
	}
}
