package TestGUI;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import java.awt.BorderLayout;
import java.awt.CardLayout;

import javax.swing.JTable;
import javax.management.modelmbean.ModelMBean;
import javax.swing.JButton;
import javax.swing.JComboBox;

import java.awt.event.ActionListener;
import java.util.Map;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import ControllerLayer.ProductController;
import ModelLayer.Account;
import ModelLayer.Product;

import java.awt.FlowLayout;

public class ProductMenu extends JPanel {
	private JTable table;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JPanel parentPanel;
	private CardLayout parent;
	private ProductController pCtr;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_9;
	private JTextField textField_10;
	private JTextField textField_12;
	private JTextField textField_13;
	private JTextField barcodeField;
	private JTextField nameField;
	private JTextField descriptioneField;
	private JTextField priceField;
	private ProductTableModel tableModel;

	public ProductMenu(JPanel mainPanel, CardLayout cardLayout, ProductController p) {
		parentPanel = mainPanel;
		parent = cardLayout;
		pCtr = p;
		pCtr.createdummydata();
		pCtr.createdummydata();
		pCtr.createdummydata();
		setLayout(null);

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(0, 0, 730, 460);
		add(tabbedPane);

		JPanel Forside = new JPanel();
		tabbedPane.addTab("Forside", null, Forside, null);
		Forside.setLayout(null);

		JButton btnNewButton_2 = new JButton("Unikt Produkt");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tabbedPane.setSelectedIndex(3);
			}
		});
		btnNewButton_2.setBounds(254, 212, 239, 84);
		Forside.add(btnNewButton_2);

		JButton btnNewButton = new JButton("Tilbage");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				parent.show(parentPanel, "1");
			}
		});
		btnNewButton.setBounds(10, 291, 89, 23);
		Forside.add(btnNewButton);

		JButton button = new JButton("Masse Produkt");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				tabbedPane.setSelectedIndex(1);
			}
		});
		button.setBounds(254, 90, 239, 84);
		Forside.add(button);

		JPanel MasseProdukt = new JPanel();
		tabbedPane.addTab("Produkter", null, MasseProdukt, null);
		MasseProdukt.setLayout(new BorderLayout(0, 0));

		tableModel = new ProductTableModel();
		tableModel.setData(pCtr.getMap());
		table = new JTable(tableModel);

		JScrollPane sp = new JScrollPane();
		sp.setViewportView(table);
		MasseProdukt.add(sp);

		JPanel panel_2 = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel_2.getLayout();
		flowLayout.setAlignment(FlowLayout.LEFT);
		MasseProdukt.add(panel_2, BorderLayout.SOUTH);

		JButton btnOpretProdukt = new JButton("Opret Produkt");
		btnOpretProdukt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				tabbedPane.setSelectedIndex(2);
			}
		});
		btnOpretProdukt.setHorizontalAlignment(SwingConstants.LEFT);
		panel_2.add(btnOpretProdukt);

		JButton btnSletProdukt = new JButton("Slet Produkt");
		btnSletProdukt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int row = table.getSelectedRow();
				int barcode = Integer.parseInt(table.getValueAt(row, 0).toString());
				pCtr.removeProduct(barcode);
				tableModel.fireTableRowsDeleted(row, row);
			}
		});
		btnSletProdukt.setHorizontalAlignment(SwingConstants.LEFT);
		panel_2.add(btnSletProdukt);

		JButton btnTilbage = new JButton("Tilbage");
		btnTilbage.setHorizontalAlignment(SwingConstants.LEFT);
		btnTilbage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tabbedPane.setSelectedIndex(0);

			}
		});
		panel_2.add(btnTilbage);

		JPanel OpretMasseProdukt = new JPanel();
		tabbedPane.addTab("Opret Produkt", null, OpretMasseProdukt, null);
		OpretMasseProdukt.setLayout(null);

		JPanel panel_3 = new JPanel();
		panel_3.setBounds(217, 5, 10, 10);
		OpretMasseProdukt.add(panel_3);

		JLabel lblBarcode = new JLabel("Barcode");
		lblBarcode.setBounds(21, 39, 89, 14);
		OpretMasseProdukt.add(lblBarcode);

		JLabel lblNavn = new JLabel("Navn");
		lblNavn.setBounds(21, 66, 46, 14);
		OpretMasseProdukt.add(lblNavn);

		JLabel lblBeskrivelse = new JLabel("Beskrivelse");
		lblBeskrivelse.setBounds(21, 91, 89, 14);
		OpretMasseProdukt.add(lblBeskrivelse);

		JLabel lblPris = new JLabel("Pris");
		lblPris.setBounds(21, 116, 46, 14);
		OpretMasseProdukt.add(lblPris);

		JLabel lblAntal = new JLabel("Antal");
		lblAntal.setBounds(21, 141, 46, 14);
		OpretMasseProdukt.add(lblAntal);

		JLabel lblMinAmount = new JLabel("Min Amount");
		lblMinAmount.setBounds(21, 166, 89, 14);
		OpretMasseProdukt.add(lblMinAmount);

		JLabel lblMaxAmount = new JLabel("Max Amount");
		lblMaxAmount.setBounds(21, 191, 99, 30);
		OpretMasseProdukt.add(lblMaxAmount);

		textField = new JTextField();
		textField.setBounds(123, 36, 294, 30);
		OpretMasseProdukt.add(textField);
		textField.setColumns(10);

		textField_1 = new JTextField();
		textField_1.setBounds(123, 63, 294, 30);
		OpretMasseProdukt.add(textField_1);
		textField_1.setColumns(10);

		textField_2 = new JTextField();
		textField_2.setBounds(123, 88, 294, 30);
		OpretMasseProdukt.add(textField_2);
		textField_2.setColumns(10);

		textField_3 = new JTextField();
		textField_3.setBounds(123, 113, 294, 30);
		OpretMasseProdukt.add(textField_3);
		textField_3.setColumns(10);

		textField_4 = new JTextField();
		textField_4.setBounds(123, 138, 294, 30);
		OpretMasseProdukt.add(textField_4);
		textField_4.setColumns(10);

		textField_5 = new JTextField();
		textField_5.setBounds(123, 163, 294, 30);
		OpretMasseProdukt.add(textField_5);
		textField_5.setColumns(10);

		textField_6 = new JTextField();
		textField_6.setBounds(123, 191, 294, 30);
		OpretMasseProdukt.add(textField_6);
		textField_6.setColumns(10);

		JButton btnOpretProdukt_1 = new JButton("Opret Produkt");
		btnOpretProdukt_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int barcode = Integer.parseInt(textField.getText());
				String name = textField_1.getText();
				String description = textField_2.getText();
				double price = Double.parseDouble(textField_3.getText());
				int amount = Integer.parseInt(textField_4.getText());
				int min = Integer.parseInt(textField_5.getText());
				int max = Integer.parseInt(textField_6.getText());

				if (JOptionPane.showConfirmDialog(null, "Bekræft Oprettelse?", "Advarsel",
						JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
					pCtr.createMassProduct(barcode, name, description, price, amount, min, max);
					refresh();
					cleatTextFieldMassProduct();
					JOptionPane.showMessageDialog(null, "Produkt Oprettet");
					tabbedPane.setSelectedIndex(0);
				} else {

				}

			}
		});
		btnOpretProdukt_1.setBounds(21, 238, 113, 23);
		OpretMasseProdukt.add(btnOpretProdukt_1);

		JButton btnAnuller = new JButton("Anuller");
		btnAnuller.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tabbedPane.setSelectedIndex(0);
				cleatTextFieldMassProduct();
			}
		});
		btnAnuller.setBounds(138, 238, 89, 23);
		OpretMasseProdukt.add(btnAnuller);

		JPanel OpretUnikProdukt = new JPanel();
		tabbedPane.addTab("Opret Unikt Produkt", null, OpretUnikProdukt, null);
		OpretUnikProdukt.setLayout(null);

		JLabel label = new JLabel("Barcode");
		label.setBounds(10, 39, 89, 14);
		OpretUnikProdukt.add(label);

		textField_7 = new JTextField();
		textField_7.setColumns(10);
		textField_7.setBounds(112, 36, 294, 30);
		OpretUnikProdukt.add(textField_7);

		textField_8 = new JTextField();
		textField_8.setColumns(10);
		textField_8.setBounds(112, 63, 294, 30);
		OpretUnikProdukt.add(textField_8);

		JLabel label_1 = new JLabel("Navn");
		label_1.setBounds(10, 66, 46, 14);
		OpretUnikProdukt.add(label_1);

		JLabel label_2 = new JLabel("Beskrivelse");
		label_2.setBounds(10, 91, 89, 14);
		OpretUnikProdukt.add(label_2);

		textField_9 = new JTextField();
		textField_9.setColumns(10);
		textField_9.setBounds(112, 88, 294, 30);
		OpretUnikProdukt.add(textField_9);

		textField_10 = new JTextField();
		textField_10.setColumns(10);
		textField_10.setBounds(112, 113, 294, 30);
		OpretUnikProdukt.add(textField_10);

		JLabel label_3 = new JLabel("Pris");
		label_3.setBounds(10, 116, 46, 14);
		OpretUnikProdukt.add(label_3);

		textField_12 = new JTextField();
		textField_12.setColumns(10);
		textField_12.setBounds(112, 138, 294, 30);
		OpretUnikProdukt.add(textField_12);

		JLabel label_5 = new JLabel("Min Amount");
		label_5.setBounds(10, 141, 89, 14);
		OpretUnikProdukt.add(label_5);

		JLabel label_6 = new JLabel("Max Amount");
		label_6.setBounds(10, 163, 99, 21);
		OpretUnikProdukt.add(label_6);

		textField_13 = new JTextField();
		textField_13.setColumns(10);
		textField_13.setBounds(112, 163, 294, 30);
		OpretUnikProdukt.add(textField_13);

		JButton button_1 = new JButton("Opret Produkt");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int barcode = Integer.parseInt(textField_7.getText());
				String name = textField_8.getText();
				String description = textField_9.getText();
				double price = Double.parseDouble(textField_10.getText());
				int amount = 0;
				int min = Integer.parseInt(textField_12.getText());
				int max = Integer.parseInt(textField_13.getText());

				if (JOptionPane.showConfirmDialog(null, "Bekræft Oprettelse?", "Advarsel",
						JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
					// yes option

					clearTextFieldOpretUnikProdukt();

					pCtr.createUniqueProduct(barcode, name, description, price, amount, min, max);
					refresh();
					JOptionPane.showMessageDialog(null, "Produkt Oprettet");
					tabbedPane.setSelectedIndex(0);
				} else {

				}
			}
		});
		button_1.setBounds(10, 238, 137, 23);
		OpretUnikProdukt.add(button_1);

		JButton button_2 = new JButton("Anuller");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				tabbedPane.setSelectedIndex(0);
				clearTextFieldOpretUnikProdukt();
			}
		});
		button_2.setBounds(157, 238, 89, 23);
		OpretUnikProdukt.add(button_2);

		JPanel UniktEksemplar = new JPanel();
		tabbedPane.addTab("Unikt Eksemplar", null, UniktEksemplar, null);
		UniktEksemplar.setLayout(null);

		barcodeField = new JTextField();
		barcodeField.setColumns(10);
		barcodeField.setBounds(124, 28, 294, 30);
		UniktEksemplar.add(barcodeField);

		JLabel label_4 = new JLabel("Barcode");
		label_4.setBounds(22, 31, 89, 14);
		UniktEksemplar.add(label_4);

		JLabel label_10 = new JLabel("Udlevering");
		label_10.setBounds(22, 63, 89, 14);
		UniktEksemplar.add(label_10);

		JComboBox comboBox = new JComboBox();
		comboBox.addItem("Ja");
		comboBox.addItem("Nej");
		comboBox.setSelectedItem(null);
		comboBox.setBounds(124, 63, 294, 30);
		UniktEksemplar.add(comboBox);

		JButton button_3 = new JButton("Opret Produkt");
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				if (JOptionPane.showConfirmDialog(null, "Bekræft Oprettelse?", "Advarsel",
						JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
					// yes option

					if (comboBox.getSelectedItem() == null) {
						JOptionPane.showMessageDialog(null, "Vælg venligst udlevering");
					} else {
						int bar = Integer.parseInt(barcodeField.getText());
						Product productObj = pCtr.findSpecificProduct(bar);
						String name = productObj.getName();
						String description = productObj.getDescription();
						double price = productObj.getPrice();
						boolean udlevering;
						if (comboBox.getSelectedItem() == "ja") {
							udlevering = true;
						} else {
							udlevering = false;
						}

						String result = pCtr.createItem(bar, name, description, price, udlevering);
						JOptionPane.showMessageDialog(null, result);
						comboBox.setSelectedItem(null);
						clearTextFieldOpretEksemplar();
						tabbedPane.setSelectedIndex(1);
					}
				} else {

				}
			}

		});
		button_3.setBounds(22, 120, 137, 23);
		UniktEksemplar.add(button_3);

		JButton button_4 = new JButton("Anuller");
		button_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tabbedPane.setSelectedIndex(0);
				clearTextFieldOpretEksemplar();
			}
		});
		button_4.setBounds(169, 120, 89, 23);
		UniktEksemplar.add(button_4);
	}

	public void refresh() {
		tableModel.fireTableDataChanged();
	}

	public void clearTextFieldOpretUnikProdukt() {
		textField_7.setText("");
		textField_8.setText("");
		textField_9.setText("");
		textField_10.setText("");
		textField_12.setText("");
		textField_13.setText("");
	}

	public void clearTextFieldOpretEksemplar() {
		barcodeField.setText("");
	}

	public void cleatTextFieldMassProduct() {
		textField.setText("");
		textField_1.setText("");
		textField_2.setText("");
		textField_3.setText("");
		textField_4.setText("");
		textField_5.setText("");
		textField_6.setText("");
	}

}
