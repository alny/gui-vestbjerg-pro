package TestGUI;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
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
import ModelLayer.Account;
import ModelLayer.Order;
import javax.swing.JSplitPane;
import javax.swing.JOptionPane;


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
	private JTable jt;
	private JTable customerTable;
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
	private String tilgode;
	private JLabel lblNewLabel;

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
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (JOptionPane.showConfirmDialog(null, "Er du sikker på du vil ændre stamdata?", "Advarsel",
						JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
//					accountCtr.setName(phone, nameField.getText());
//					accountCtr.setAdress(phone, StreetField.getText());
//					accountCtr.setZip(phone, ZipField.getText());
//					accountCtr.setCity(phone, cityField.getText());
					accountCtr.updateDBPhone(phone, phoneField.getText());
					refresh();
					JOptionPane.showMessageDialog(null, "Kunde oplysninger opdateret");
					tabbedPane.setSelectedIndex(0);
				} else {

				}

			}
		});
		btnNewButton.setBounds(36, 158, 143, 23);
		Kunde.add(btnNewButton);

		JButton btnAnnuller_1 = new JButton("Annuller");
		btnAnnuller_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name = accountCtr.findCustomer(phone).getName();
				String adress = accountCtr.findCustomer(phone).getAddress();
				String zip = accountCtr.findCustomer(phone).getZip();
				String city = accountCtr.findCustomer(phone).getCity();
				nameField.setText(name);
				StreetField.setText(adress);
				ZipField.setText(zip);
				cityField.setText(city);
				phoneField.setText(phone);
			}
		});
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

		JButton btnTilbageTilOversigt = new JButton("Tilbage til Oversigt");
		btnTilbageTilOversigt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tabbedPane.setSelectedIndex(0);
			}
		});
		btnTilbageTilOversigt.setBounds(14, 400, 143, 23);
		Kunde.add(btnTilbageTilOversigt);

		JLabel lblKundeTilgodehavende = new JLabel("Kunde Tilgodehavende:");
		lblKundeTilgodehavende.setBounds(36, 283, 164, 14);
		Kunde.add(lblKundeTilgodehavende);

		lblNewLabel = new JLabel("ingen kunde");
		lblNewLabel.setBounds(210, 283, 79, 14);
		Kunde.add(lblNewLabel);

		table_1 = new JTable();
		// table_1.setEnabled(false);
		// table_1.setRowSelectionAllowed(true);
		table_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if (arg0.getClickCount() == 2) {
					System.out.println("test");
				}
			}

		});
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

		JPanel showCustomers = new JPanel();
		showCustomers.setLayout(null);
		showCustomers.setLayout(null);

//		tableModel = new CustomerTableModel();
//		tableModel.setData(accountCtr.getDBCustomers());
		
		customerTable = new JTable();
		refresh();
//		jt = new JTable(tableModel);
		JScrollPane sp = new JScrollPane();
		sp.setBounds(0, 0, 735, 390);
		sp.setViewportView(customerTable);
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

		JButton btnDelete = new JButton("Slet Kunde");
		btnDelete.setBounds(290, 400, 100, 23);
		showCustomers.add(btnDelete);

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

				int row = customerTable.getSelectedRow();
				if (row > -1) {
					String getPhone = customerTable.getValueAt(row, 4).toString();
					String name = accountCtr.findDBCustomer(getPhone).getName();
					String adress = accountCtr.findDBCustomer(getPhone).getAddress();
					String zip = accountCtr.findDBCustomer(getPhone).getZip();
					String city = accountCtr.findDBCustomer(getPhone).getCity();
					double tilgode1 = accountCtr.findDBCustomer(getPhone).customerReceivable();
					tilgode = Double.toString(tilgode1);
					lblNewLabel.setText(tilgode);
					phone = getPhone;
//					table_1.setModel(orderTable(accountCtr.getOrders(phone)));
//
					nameField.setText(name);
					StreetField.setText(adress);
					ZipField.setText(zip);
					cityField.setText(city);
					phoneField.setText(phone);
					tabbedPane.setSelectedIndex(2);
				} else {
					JOptionPane.showMessageDialog(null, "Du skal vælge en kunde");
				}

			}
		});
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int row = customerTable.getSelectedRow();
				String getPhone = customerTable.getValueAt(row, 4).toString();
				accountCtr.removeDBAccount(getPhone);
				refresh();
//				tableModel.fireTableRowsDeleted(row, row);
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
				try {
					accountCtr.createDBAccount(name, address, zip, city, phone, type);

				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
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
		customerTable.setModel(customerTable(accountCtr.getDBCustomers()));
//		tableModel.fireTableDataChanged();
	}

	public TableModel orderTable(Map<Integer, Order> map) {

		DefaultTableModel model = new DefaultTableModel(new Object[] { "Order ID", "Date", "Total Price", "Betalt" },
				0) {
			@Override
			public boolean isCellEditable(int row, int column) {
				// all cells false
				return false;
			}

		};

		for (Map.Entry<Integer, Order> entry : map.entrySet()) {

			model.addRow(new Object[] { entry.getValue().getId(), entry.getValue().getDate(),
					entry.getValue().getTotalPrice(), entry.getValue().getbetalt(), });
		}

		return model;

	}

	public TableModel orderItemTable(Map<Integer, Order> map) {

		DefaultTableModel model = new DefaultTableModel(new Object[] { "Order ID", "Date", "Total Price", "Betalt" },
				0) {
			
			@Override
			public boolean isCellEditable(int row, int column) {
				// all cells false
				return false;
			}

		};

		for (Map.Entry<Integer, Order> entry : map.entrySet()) {

			model.addRow(new Object[] { entry.getValue().getId(), entry.getValue().getDate(),
					entry.getValue().getTotalPrice(), entry.getValue().getbetalt(), });
		}

		return model;

	}
	
	public TableModel customerTable(Map<String, Account> map) {

		DefaultTableModel model = new DefaultTableModel(new Object[] { "Navn", "Adresse", "Post Nr", "By", "Telefon" },
				0);
		for (Map.Entry<String, Account> entry : map.entrySet()) {

			model.addRow(new Object[] { entry.getValue().getName(), entry.getValue().getAddress(),
					entry.getValue().getZip(), entry.getValue().getCity(), entry.getValue().getPhone() });
		}
		return model;

	}
}
