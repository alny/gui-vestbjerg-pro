package TestGUI;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;

import ControllerLayer.OrderController;

	public class CustomerDialog {
	private JTextField textField;
	private JTextField textField_1;
	private boolean status = false;
	private OrderController orderCtr;
	private JFrame f;
	private JTabbedPane tab;
	
	public CustomerDialog(JTabbedPane t, OrderController oCtr) {
		tab = t;
		orderCtr = oCtr;
		f = new JFrame("Kunde Info");
		
		f.setBounds(100, 100, 580, 400);
		f.setVisible(true);
		
		JPanel panel_1 = new JPanel();
		f.getContentPane().add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(null);
		
		JLabel lblTelefon = new JLabel("Telefon");
		lblTelefon.setBounds(129, 59, 56, 16);
		panel_1.add(lblTelefon);
		
		JLabel lblAddresse = new JLabel("Addresse");
		lblAddresse.setBounds(129, 108, 56, 16);
		panel_1.add(lblAddresse);
		
		textField = new JTextField();
		textField.setBounds(213, 56, 210, 22);
		panel_1.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(213, 105, 210, 22);
		panel_1.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel label = new JLabel("");
		label.setBounds(213, 193, 210, 16);
		panel_1.add(label);
		
		JButton btnNewButton = new JButton("Levering");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(status == true) {
					status = false;
					label.setText("Ordre skal ikke leveres");
				} else {
					status = true;
					label.setText("Ordre skal leveres");
				}
			}
		});
		btnNewButton.setBounds(213, 155, 210, 25);
		panel_1.add(btnNewButton);
		
		JButton btnOpretOrdre = new JButton("Opret Ordre");
		btnOpretOrdre.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				createOrder();
			}
		});
		btnOpretOrdre.setBounds(12, 315, 157, 25);
		panel_1.add(btnOpretOrdre);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
	}
	
	public void createOrder() {
		
		String address = textField_1.getText();
		String phone = textField.getText();
		
		orderCtr.createOrder(status, address, phone);
		f.setVisible(false);
		f.dispose();
		tab.setSelectedIndex(1);
		

	}

}
