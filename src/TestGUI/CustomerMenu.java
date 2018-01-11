package TestGUI;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import ControllerLayer.AccountController;
import ControllerLayer.OrderController;
import ControllerLayer.ProductController;
import ModelLayer.Account;
import ModelLayer.Order;

import javax.swing.JSplitPane;
import javax.swing.JSeparator;
import javax.swing.JList;
import javax.swing.border.LineBorder;
import java.awt.Rectangle;
import java.awt.ComponentOrientation;
import javax.swing.JScrollBar;

public class CustomerMenu extends JPanel {

	private AccountController accountCtr;
	private JTabbedPane tabbedPane;
	private JPanel parentPanel;
	private CardLayout parent;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private CustomerTableModel tableModel;
	private CustomerOrderTableModel tableOrderModel;
	private JTable jt;
	private JLabel label;
	private JTextField nameField;
	private JTextField StreetField;
	private JTextField ZipField;
	private JTextField cityField;
	private JTextField phoneField;
	private OrderController orderController;
	private String phone;
	private JTable ordertable;
	private JTable table;
	private JPanel panel_1;
	private JTable table_1;

	public CustomerMenu(JPanel mainPanel, CardLayout cardLayout, AccountController aCtr, OrderController oCtr) {
		parentPanel = mainPanel;
		parent = cardLayout;
		accountCtr = aCtr;
		orderController = oCtr;
		init();
	}

	private void init() {
		setBounds(100, 100, 750, 500);
		setLayout(new BorderLayout(0, 0));
		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		add(tabbedPane, BorderLayout.CENTER);
		tabbedPane.addTab("Kundeliste", null, showCustomers(), null);
		tabbedPane.addTab("Opret Kunde", null, createCustomers(), null);
		
		JPanel Kunde = new JPanel();
		tabbedPane.addTab("Kunde", null, Kunde, null);
		Kunde.setLayout(null);
		
		JLabel lblNavn_1 = new JLabel("Navn:");
		lblNavn_1.setBounds(36, 26, 46, 14);
		Kunde.add(lblNavn_1);
		
		JLabel lblAdresse_1 = new JLabel("Vejnavn:");
		lblAdresse_1.setBounds(36, 52, 46, 14);
		Kunde.add(lblAdresse_1);
		
		JLabel lblZip = new JLabel("ZIP:");
		lblZip.setBounds(36, 77, 46, 14);
		Kunde.add(lblZip);
		
		JLabel lblBy_1 = new JLabel("By:");
		lblBy_1.setBounds(36, 102, 46, 14);
		Kunde.add(lblBy_1);
		
		JLabel lblTelefon_1 = new JLabel("Telefon:");
		lblTelefon_1.setBounds(36, 127, 46, 14);
		Kunde.add(lblTelefon_1);
		
		nameField = new JTextField();
		nameField.setBounds(92, 23, 172, 23);
		Kunde.add(nameField);
		nameField.setColumns(10);
		
		StreetField = new JTextField();
		StreetField.setColumns(10);
		StreetField.setBounds(92, 49, 172, 23);
		Kunde.add(StreetField);
		
		JButton btnNewButton = new JButton("Opdater Stamdata");
		btnNewButton.setBounds(36, 158, 143, 23);
		Kunde.add(btnNewButton);
		
		JButton btnAnnuller_1 = new JButton("Annuller");
		btnAnnuller_1.setBounds(176, 158, 88, 23);
		Kunde.add(btnAnnuller_1);
		
		JLabel lblOrdreOversigt = new JLabel("Ordre Oversigt");
		lblOrdreOversigt.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblOrdreOversigt.setBounds(462, 20, 143, 20);
		Kunde.add(lblOrdreOversigt);
		
		
		
		
		
		
		ZipField = new JTextField();
		ZipField.setColumns(10);
		ZipField.setBounds(92, 74, 172, 23);
		Kunde.add(ZipField);
		
		cityField = new JTextField();
		cityField.setColumns(10);
		cityField.setBounds(92, 99, 172, 23);
		Kunde.add(cityField);
		
		phoneField = new JTextField();
		phoneField.setColumns(10);
		phoneField.setBounds(92, 124, 172, 23);
		Kunde.add(phoneField);
		
		JPanel panel = new JPanel();
		tabbedPane.addTab("Kunde Oplysninger", null, panel, null);
		panel.setLayout(new BorderLayout(0, 0));
		panel_1 = new JPanel();
		panel_1.setLayout(new BorderLayout(0, 0));
		
		
		
		JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, Kunde, panel_1);
		
		table_1 = new JTable();
		panel_1.add(table_1, BorderLayout.CENTER);
		//table_1.setModel(orderTable(accountCtr.getOrder("123")));
		JScrollPane sp = new JScrollPane();
		sp.setBounds(88, 251, 452, 155);
		sp.setViewportView(table_1);
		panel_1.add(sp);
		
	
		
	
		
		
		panel.add(splitPane, BorderLayout.CENTER);
		splitPane.setDividerLocation(300);
		
		
		JPanel ListPanel = new JPanel();
		ListPanel.setBounds(0, 0, 100, 200);
		
		
		
		
	}

	private JScrollPane JScrollPane() {
		// TODO Auto-generated method stub
		return null;
	}

	public JPanel showCustomers() {

		accountCtr.createAccount("Erik", "Erikvej 32", "9000", "Aalborg", "123", "type");
		accountCtr.createAccount("Findus", "Yolovej 32", "2100", "København", "321", "type");

		JPanel showCustomers = new JPanel();
		showCustomers.setLayout(null);
		showCustomers.setLayout(null);
		
		tableModel = new CustomerTableModel();
		tableModel.setData(accountCtr.getCustomers());
		
	

		jt = new JTable(tableModel);
		JScrollPane sp = new JScrollPane();
		sp.setBounds(0, 0, 735, 390);
		sp.setViewportView(jt);
		showCustomers.add(sp);

		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 0, 0);
		showCustomers.add(panel);
		FlowLayout fl_panel = new FlowLayout(FlowLayout.RIGHT, 5, 5);
		panel.setLayout(fl_panel);
		label = new JLabel("");
		label.setForeground(Color.RED);
		panel.add(label);
		
				JButton btnOpretKunde = new JButton("Opret Kunde");
				btnOpretKunde.setBounds(14, 400, 105, 23);
				showCustomers.add(btnOpretKunde);
				
						JButton btnOpret = new JButton("Slet Kunde");
						btnOpret.setBounds(290, 400, 100, 23);
						showCustomers.add(btnOpret);
						
						JButton btnKundeOplysninger = new JButton("Kunde Oplysninger");
						btnKundeOplysninger.setBounds(127, 400, 153, 23);
						showCustomers.add(btnKundeOplysninger);
						
								JButton btnTilbag = new JButton("Tilbage");
								btnTilbag.setBounds(400, 400, 80, 23);
								showCustomers.add(btnTilbag);
								btnTilbag.addActionListener(new ActionListener() {
									public void actionPerformed(ActionEvent e) {
										parent.show(parentPanel, "1");
									}
								});
						btnKundeOplysninger.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent arg0) {
								int row = jt.getSelectedRow();
								String getPhone = tableModel.removeRow(row);
								String name = accountCtr.findCustomer(getPhone).getName();
								String adress = accountCtr.findCustomer(getPhone).getAddress();
								String zip =  accountCtr.findCustomer(getPhone).getZip();
								String city =  accountCtr.findCustomer(getPhone).getCity();
								String phone = getPhone;
								table_1.setModel(orderTable(accountCtr.getOrders(phone)));
								
								
								nameField.setText(name);
								StreetField.setText(adress);
								ZipField.setText(zip);
								cityField.setText(city);
								phoneField.setText(phone);
								tabbedPane.setSelectedIndex(2);
								
								
								
								
							}
						});
						btnOpret.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								int row = jt.getSelectedRow();
								String getPhone = tableModel.removeRow(row);
								accountCtr.removeAccount(getPhone);
								tableModel.fireTableRowsDeleted(row, row);
							}
						});
				btnOpretKunde.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						tabbedPane.setSelectedIndex(1);
					}
				});

		return showCustomers;

	}

	public JPanel createCustomers() {
		JPanel createCustomers = new JPanel();
		createCustomers.setLayout(null);

		JLabel lblOpretKunde = new JLabel("Opret Kunde");
		lblOpretKunde.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblOpretKunde.setBounds(128, 21, 98, 41);
		createCustomers.add(lblOpretKunde);

		JLabel lblNavn = new JLabel("Navn");
		lblNavn.setBounds(80, 87, 46, 14);
		createCustomers.add(lblNavn);

		textField = new JTextField();
		textField.setBounds(141, 84, 475, 30);
		createCustomers.add(textField);
		textField.setColumns(10);

		JLabel lblAdresse = new JLabel("Adresse");
		lblAdresse.setBounds(80, 131, 58, 14);
		createCustomers.add(lblAdresse);

		textField_1 = new JTextField();
		textField_1.setBounds(141, 128, 475, 30);
		createCustomers.add(textField_1);
		textField_1.setColumns(10);

		JLabel lblBy = new JLabel("By");
		lblBy.setBounds(80, 176, 46, 14);
		createCustomers.add(lblBy);

		textField_2 = new JTextField();
		textField_2.setBounds(141, 173, 475, 30);
		createCustomers.add(textField_2);
		textField_2.setColumns(10);

		JLabel lblPostNr = new JLabel("Post Nr");
		lblPostNr.setBounds(80, 220, 46, 14);
		createCustomers.add(lblPostNr);

		textField_3 = new JTextField();
		textField_3.setBounds(141, 217, 475, 30);
		createCustomers.add(textField_3);
		textField_3.setColumns(10);

		JLabel lblTelefon = new JLabel("Telefon");
		lblTelefon.setBounds(80, 270, 46, 14);
		createCustomers.add(lblTelefon);

		textField_4 = new JTextField();
		textField_4.setBounds(141, 267, 475, 30);
		createCustomers.add(textField_4);
		textField_4.setColumns(10);

		JLabel lblType = new JLabel("Type");
		lblType.setBounds(80, 321, 46, 14);
		createCustomers.add(lblType);

		textField_5 = new JTextField();
		textField_5.setBounds(141, 318, 475, 30);
		createCustomers.add(textField_5);
		textField_5.setColumns(10);

		JButton btnOpreKunde = new JButton("Opret Kunde");
		btnOpreKunde.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String name = textField.getText();
				String address = textField_1.getText();
				String zip = textField_2.getText();
				String city = textField_3.getText();
				String phone = textField_4.getText();
				String type = textField_5.getText();

				accountCtr.createAccount(name, address, zip, city, phone, type);
				tabbedPane.setSelectedIndex(0);
				refresh();
			}
		});
		btnOpreKunde.setBounds(128, 371, 112, 23);
		createCustomers.add(btnOpreKunde);

		JButton btnAnnuller = new JButton("Annuller");
		btnAnnuller.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tabbedPane.setSelectedIndex(0);
			}
		});
		btnAnnuller.setBounds(250, 371, 89, 23);
		createCustomers.add(btnAnnuller);

		return createCustomers;

	}
	
	public void refresh() {
		tableModel.fireTableDataChanged();
	}
	
	public TableModel orderTable(Map<Integer, Order> map) {

		DefaultTableModel model = new DefaultTableModel(new Object[] { "Order ID", "Date", "Total Price","Betalt"},
				0);
		for (Map.Entry<Integer, Order> entry : map.entrySet()) {

			model.addRow(new Object[] { entry.getValue().getId(), entry.getValue().getDate(),
					entry.getValue().getTotalPrice(), entry.getValue().getbetalt(),});
		}
		return model;

	}
}
