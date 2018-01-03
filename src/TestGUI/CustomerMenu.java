package TestGUI;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import ControllerLayer.AccountController;
import ModelLayer.Account;
import java.awt.Font;
import javax.swing.JTextField;
import java.awt.Color;

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
	private JTable jt;
	private JLabel label;

	public CustomerMenu(JPanel mainPanel, CardLayout cardLayout) {
		init();
		parentPanel = mainPanel;
		parent = cardLayout;
	}

	private void init() {
		setBounds(100, 100, 750, 500);
		setLayout(new BorderLayout(0, 0));

		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		add(tabbedPane, BorderLayout.CENTER);
		tabbedPane.addTab("Kundeliste", null, showCustomers(), null);
		tabbedPane.addTab("Opret Kunde", null, createCustomers(), null);

	}

	public JPanel showCustomers() {

		accountCtr = new AccountController();

		accountCtr.createAccount("Erik", "Erikvej 32", "9000", "Aalborg", "123", "type");
		accountCtr.createAccount("Findus", "Yolovej 32", "2100", "København", "321", "type");

		JPanel showCustomers = new JPanel();
		showCustomers.setLayout(new BorderLayout(0, 0));
		// showCustomers.setLayout(null);

		jt = new JTable();
		jt.setModel(customerTable(accountCtr.getCustomers()));
		JScrollPane sp = new JScrollPane();
		sp.setBounds(88, 251, 452, 155);
		sp.setViewportView(jt);
		showCustomers.add(sp);

		JPanel panel = new JPanel();
		showCustomers.add(panel, BorderLayout.SOUTH);
		panel.setLayout(new FlowLayout(FlowLayout.LEADING, 5, 5));

		JButton btnOpretKunde = new JButton("Opret Kunde");
		btnOpretKunde.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				tabbedPane.setSelectedIndex(1);
			}
		});
		panel.add(btnOpretKunde);

		JButton btnOpret = new JButton("Slet Kunde");
		btnOpret.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (jt.getSelectedRow() == -1) {
					label.setText("Vælg den kunde du vil slette");
				} else {
					DefaultTableModel model = (DefaultTableModel) jt.getModel();

					Object element = model.getDataVector().elementAt(jt.getSelectedRow());

					String toString = element.toString();
					String last = toString.substring(toString.lastIndexOf(',') + 1);
					String phone = last.replaceAll("[\\[\\](){}]", "");
					accountCtr.removeAccount(phone);
					model.removeRow(jt.getSelectedRow());
				}
			}
		});
		panel.add(btnOpret);

		JButton btnTilbag = new JButton("Tilbage");
		btnTilbag.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				parent.show(parentPanel, "1");
			}
		});
		panel.add(btnTilbag);
		label = new JLabel("");
		label.setForeground(Color.RED);
		panel.add(label);

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
		textField.setBounds(141, 84, 475, 20);
		createCustomers.add(textField);
		textField.setColumns(10);

		JLabel lblAdresse = new JLabel("Adresse");
		lblAdresse.setBounds(80, 131, 58, 14);
		createCustomers.add(lblAdresse);

		textField_1 = new JTextField();
		textField_1.setBounds(141, 128, 475, 20);
		createCustomers.add(textField_1);
		textField_1.setColumns(10);

		JLabel lblBy = new JLabel("By");
		lblBy.setBounds(80, 176, 46, 14);
		createCustomers.add(lblBy);

		textField_2 = new JTextField();
		textField_2.setBounds(141, 173, 475, 20);
		createCustomers.add(textField_2);
		textField_2.setColumns(10);

		JLabel lblPostNr = new JLabel("Post Nr");
		lblPostNr.setBounds(80, 220, 46, 14);
		createCustomers.add(lblPostNr);

		textField_3 = new JTextField();
		textField_3.setBounds(141, 217, 475, 20);
		createCustomers.add(textField_3);
		textField_3.setColumns(10);

		JLabel lblTelefon = new JLabel("Telefon");
		lblTelefon.setBounds(80, 270, 46, 14);
		createCustomers.add(lblTelefon);

		textField_4 = new JTextField();
		textField_4.setBounds(141, 267, 475, 20);
		createCustomers.add(textField_4);
		textField_4.setColumns(10);

		JLabel lblType = new JLabel("Type");
		lblType.setBounds(80, 321, 46, 14);
		createCustomers.add(lblType);

		textField_5 = new JTextField();
		textField_5.setBounds(141, 318, 475, 20);
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

				DefaultTableModel model = (DefaultTableModel) jt.getModel();
				model.addRow(new Object[] { name, address, zip, city, phone, type });

				accountCtr.createAccount(name, address, zip, city, phone, type);
				tabbedPane.setSelectedIndex(0);
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
