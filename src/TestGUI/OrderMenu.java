package TestGUI;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.FlowLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import ControllerLayer.AccountController;
import ControllerLayer.OrderController;
import ControllerLayer.ProductController;
import ModelLayer.Account;
import ModelLayer.Product;

public class OrderMenu extends JPanel {

	private CardLayout parent;
	private JPanel parentPanel;
	private OrderController orderCtr;
	private AccountController accountCtr;
	private ProductController productCtr;
	private JTabbedPane tabbedPane;
	private JTable jt;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private boolean status = false;
	private JDialog dialog;
	private int id;
	private String phone;
	private JLabel label;
	private JLabel label_2;
	private JLabel label_3;
	private JLabel label_4;
	private JLabel label_5;
	private JLabel label_6;
	private int barcode;
	private double total;

	public OrderMenu(JPanel mainPanel, CardLayout cardLayout, OrderController oCtr, AccountController aCtr, ProductController pCtr) {
		parentPanel = mainPanel;
		parent = cardLayout;
		orderCtr = oCtr;
		accountCtr = aCtr;
		productCtr = pCtr;
		init();
	}

	private void init() {
		setBounds(100, 100, 750, 500);
		setLayout(new BorderLayout(0, 0));

		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		add(tabbedPane, BorderLayout.CENTER);
		
		tabbedPane.addTab("Ordre Menu", null, orderMainMenu(), null);
		tabbedPane.addTab("Opret Salg", null, createSale(), null);
		tabbedPane.setEnabledAt(1, false);
	}

	private JPanel orderMainMenu() {

		JPanel mainPanel = new JPanel();
		mainPanel.setLayout(null);

		JButton btnSalgMKunde = new JButton("Salg m. Kunde");
		btnSalgMKunde.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				customerDialog();
			}
		});
		btnSalgMKunde.setBounds(274, 125, 196, 79);
		mainPanel.add(btnSalgMKunde);

		JButton btnSalgUKunde = new JButton("Salg u. Kunde");
		btnSalgUKunde.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tabbedPane.setEnabledAt(1, true);
				tabbedPane.setSelectedIndex(1);
				id = orderCtr.createOrder();
				
			}
		});
		btnSalgUKunde.setBounds(274, 270, 196, 72);
		mainPanel.add(btnSalgUKunde);

		JButton btnTilbage = new JButton("Tilbage");
		btnTilbage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				parent.show(parentPanel, "1");
			}
		});
		btnTilbage.setBounds(24, 367, 97, 25);
		mainPanel.add(btnTilbage);

		return mainPanel;
	}
	
	private JPanel createSale() {
		JPanel salePanel = new JPanel();
		salePanel.setLayout(new BorderLayout(0, 0));

		JPanel panel_1 = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel_1.getLayout();
		flowLayout.setAlignment(FlowLayout.LEFT);
		salePanel.add(panel_1, BorderLayout.SOUTH);

		JButton btnAfslutSalg = new JButton("Afslut Salg");
		btnAfslutSalg.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tabbedPane.setEnabledAt(1, false);
				clearOrdreData();
			}
		});
		panel_1.add(btnAfslutSalg);

		JButton btnAnnuller = new JButton("Annuller");
		btnAnnuller.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				tabbedPane.setEnabledAt(1, false);
				tabbedPane.setSelectedIndex(0);
			}
		});
		panel_1.add(btnAnnuller);
		
		JLabel lblNewLabel_4 = new JLabel("Total Pris:");
		panel_1.add(lblNewLabel_4);
		
		label_6 = new JLabel("");
		panel_1.add(label_6);

		JPanel panel = new JPanel();
		JPanel panel_2 = new JPanel();
		salePanel.add(panel, BorderLayout.CENTER);

		jt = new JTable();

		jt.setModel(itemTable());
		JScrollPane sp = new JScrollPane();
		sp.setBounds(88, 251, 452, 155);
		sp.setViewportView(jt);
		panel.add(sp);

		JSplitPane split = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, panel, panel_2);
		panel_2.setLayout(null);
				
					JLabel lblTelefon = new JLabel("Telefon");
					lblTelefon.setBounds(12, 275, 56, 16);
					panel_2.add(lblTelefon);

					JLabel lblAdresse = new JLabel("Adresse");
					lblAdresse.setBounds(12, 161, 56, 16);
					panel_2.add(lblAdresse);

					JLabel lblNewLabel = new JLabel("Navn");
					lblNewLabel.setBounds(12, 123, 56, 16);
					panel_2.add(lblNewLabel);

					JLabel lblNewLabel_2 = new JLabel("By");
					lblNewLabel_2.setBounds(12, 200, 56, 16);
					panel_2.add(lblNewLabel_2);

					JLabel lblNewLabel_3 = new JLabel("Post Nr");
					lblNewLabel_3.setBounds(12, 236, 56, 16);
					panel_2.add(lblNewLabel_3);

					label = new JLabel("");
					label.setBounds(79, 123, 140, 16);
					panel_2.add(label);

					label_2 = new JLabel("");
					label_2.setBounds(78, 162, 141, 14);
					panel_2.add(label_2);

					label_3 = new JLabel("");
					label_3.setBounds(78, 201, 141, 14);
					panel_2.add(label_3);

					label_4 = new JLabel("");
					label_4.setBounds(78, 236, 131, 14);
					panel_2.add(label_4);

					label_5 = new JLabel("");
					label_5.setBounds(78, 276, 141, 14);
					panel_2.add(label_5);
		
		JButton btnNewButton = new JButton("Tilf\u00F8j Produkt");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				createItem();
			}
		});
		btnNewButton.setBounds(66, 62, 153, 25);
		panel_2.add(btnNewButton);

		JLabel lblNewLabel_1 = new JLabel("Barkode");
		lblNewLabel_1.setBounds(12, 30, 56, 16);
		panel_2.add(lblNewLabel_1);

		textField_4 = new JTextField();
		textField_4.setBounds(66, 27, 153, 30);
		panel_2.add(textField_4);
		textField_4.setColumns(10);
		

		salePanel.add(split);

		return salePanel;
	}

	public void customerDialog() {
		dialog = new JDialog();

		dialog.setBounds(100, 100, 580, 400);
		dialog.setVisible(true);

		JPanel panel_1 = new JPanel();
		dialog.getContentPane().add(panel_1, BorderLayout.CENTER);
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
				if (status == true) {
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
				setCustomerInfo();
			}
		});
		btnOpretOrdre.setBounds(12, 315, 157, 25);
		panel_1.add(btnOpretOrdre);
	}

	public void createOrder() {
		String address = textField_1.getText();
		phone = textField.getText();
		id = orderCtr.createOrder(status, address, phone);
		dialog.setVisible(false);
		tabbedPane.setEnabledAt(1, true);
		tabbedPane.setSelectedIndex(1);
	}

	public void setCustomerInfo() {
		Account accountObj = accountCtr.findCustomer(phone);
		label.setText(accountObj.getName());
		label_2.setText(accountObj.getAddress());
		label_3.setText(accountObj.getCity());
		label_4.setText(accountObj.getZip());
		label_5.setText(accountObj.getPhone());
	}

	public void createItem() {
		barcode = Integer.parseInt(textField_4.getText());
		if (productCtr.isUnique(barcode) == true) {
			uniqueProductDialog();
		} else {
			simpleProductDialog();
		}
	}
	
	public void simpleProductDialog() {
		JDialog dialog = new JDialog();

		dialog.setBounds(100, 100, 280, 300);
		dialog.setVisible(true);

		JPanel panel_1 = new JPanel();
		dialog.getContentPane().add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(null);

		JLabel lblTelefon = new JLabel("Angiv Antal");
		lblTelefon.setBounds(13, 59, 156, 16);
		panel_1.add(lblTelefon);

		textField_5 = new JTextField();
		textField_5.setBounds(13, 105, 210, 22);
		panel_1.add(textField_5);
		textField_5.setColumns(10);

		JButton btnOpretOrdre = new JButton("Opret Produkt");
		btnOpretOrdre.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int amount = Integer.parseInt(textField_5.getText());
				orderCtr.addProduct(id, barcode, amount);
				Product productObj = productCtr.findSpecificProduct(barcode);

				int tBarcode = productObj.getBarcode();
				String name = productObj.getName();
				String description = productObj.getDescription();
				double price = productObj.getPrice();
				totalPrice(price, amount);
				

				DefaultTableModel model = (DefaultTableModel) jt.getModel();
				model.addRow(new Object[] { tBarcode, name, description, price, amount });
				dialog.setVisible(false);
				dialog.dispose();
			}
		});
		btnOpretOrdre.setBounds(12, 215, 157, 25);
		panel_1.add(btnOpretOrdre);
	}

	public void uniqueProductDialog() {
		JDialog dialog = new JDialog();

		dialog.setBounds(100, 100, 280, 300);
		dialog.setVisible(true);

		JPanel panel_1 = new JPanel();
		dialog.getContentPane().add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(null);

		JLabel lblTelefon = new JLabel("Angiv Serie Nr");
		lblTelefon.setBounds(13, 59, 156, 16);
		panel_1.add(lblTelefon);

		textField_6 = new JTextField();
		textField_6.setBounds(13, 105, 210, 22);
		panel_1.add(textField_6);
		textField_6.setColumns(10);

		JButton btnOpretOrdre = new JButton("Opret Produkt");
		btnOpretOrdre.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int serial = Integer.parseInt(textField_6.getText());
				orderCtr.addItem(id, barcode, serial);
				Product productObj = productCtr.findSpecificProduct(barcode);

				int tBarcode = productObj.getBarcode();
				String name = productObj.getName();
				String description = productObj.getDescription();
				double price = productObj.getPrice();

				DefaultTableModel model = (DefaultTableModel) jt.getModel();
				model.addRow(new Object[] { tBarcode, name, description, price, 1 });
				dialog.setVisible(false);
				dialog.dispose();
			}
		});
		btnOpretOrdre.setBounds(12, 215, 157, 25);
		panel_1.add(btnOpretOrdre);
	}
	
	public void clearOrdreData() {
		label.setText("");
		label_2.setText("");
		label_3.setText("");
		label_4.setText("");
		label_5.setText("");
		label_6.setText("");
		textField_4.setText("");
		total = 0;
		DefaultTableModel model = (DefaultTableModel) jt.getModel();
		model.getDataVector().removeAllElements();
		model.fireTableDataChanged();
		tabbedPane.setSelectedIndex(0);
	}
	
	public void totalPrice(double p, int amount) {
		int price = (int) p; 
		int multiply = price * amount;
		total += multiply;
		label_6.setText(String.valueOf(total));		
	}

	public TableModel itemTable() {
		DefaultTableModel model = new DefaultTableModel(
				new Object[] { "Stregkode", "Navn", "Beskrivelse", "Pris", "Antal" }, 0);
		return model;

	}
}
