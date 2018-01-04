package TestGUI;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import java.awt.BorderLayout;
import java.awt.CardLayout;

import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.Map;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
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
	public ProductMenu(JPanel mainPanel, CardLayout cardLayout) {
		parentPanel = mainPanel;
		parent = cardLayout;
		pCtr = new ProductController();
		setLayout(new BorderLayout(0, 0));
		pCtr.createdummydata();
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		add(tabbedPane);
		
		JPanel panel = new JPanel();
		tabbedPane.addTab("Produkter", null, panel, null);
		panel.setLayout(new BorderLayout(0, 0));
		
		
		
		table = new JTable();
		panel.add(table, BorderLayout.CENTER);
		table.setModel(productTable(pCtr.getMap()));
		JScrollPane sp = new JScrollPane();
		sp.setBounds(88, 251, 452, 155);
		sp.setViewportView(table);
		panel.add(sp);
		
		
		JPanel panel_2 = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel_2.getLayout();
		flowLayout.setAlignment(FlowLayout.LEFT);
		panel.add(panel_2, BorderLayout.SOUTH);
		
		JButton btnOpretProdukt = new JButton("Opret Produkt");
		btnOpretProdukt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			tabbedPane.setSelectedIndex(1);
			}
		});
		btnOpretProdukt.setHorizontalAlignment(SwingConstants.LEFT);
		panel_2.add(btnOpretProdukt);
		
		JButton btnSletProdukt = new JButton("Slet Produkt");
		btnSletProdukt.setHorizontalAlignment(SwingConstants.LEFT);
		panel_2.add(btnSletProdukt);
		
		JButton btnTilbage = new JButton("Tilbage");
		btnTilbage.setHorizontalAlignment(SwingConstants.LEFT);
		btnTilbage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				parent.show(parentPanel, "1");
				
			}
		});
		panel_2.add(btnTilbage);
		
		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("Opret Produkt", null, panel_1, null);
		panel_1.setLayout(null);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBounds(217, 5, 10, 10);
		panel_1.add(panel_3);
		
		JLabel lblBarcode = new JLabel("Barcode");
		lblBarcode.setBounds(21, 39, 89, 14);
		panel_1.add(lblBarcode);
		
		JLabel lblNavn = new JLabel("Navn");
		lblNavn.setBounds(21, 66, 46, 14);
		panel_1.add(lblNavn);
		
		JLabel lblBeskrivelse = new JLabel("Beskrivelse");
		lblBeskrivelse.setBounds(21, 91, 89, 14);
		panel_1.add(lblBeskrivelse);
		
		JLabel lblPris = new JLabel("Pris");
		lblPris.setBounds(21, 116, 46, 14);
		panel_1.add(lblPris);
		
		JLabel lblAntal = new JLabel("Antal");
		lblAntal.setBounds(21, 141, 46, 14);
		panel_1.add(lblAntal);
		
		JLabel lblMinAmount = new JLabel("Min Amount");
		lblMinAmount.setBounds(21, 166, 89, 14);
		panel_1.add(lblMinAmount);
		
		JLabel lblMaxAmount = new JLabel("Max Amount");
		lblMaxAmount.setBounds(21, 191, 99, 21);
		panel_1.add(lblMaxAmount);
		
		textField = new JTextField();
		textField.setBounds(123, 36, 294, 20);
		panel_1.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(123, 63, 294, 20);
		panel_1.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(123, 88, 294, 20);
		panel_1.add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(123, 113, 294, 20);
		panel_1.add(textField_3);
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setBounds(123, 138, 294, 20);
		panel_1.add(textField_4);
		textField_4.setColumns(10);
		
		textField_5 = new JTextField();
		textField_5.setBounds(123, 163, 294, 20);
		panel_1.add(textField_5);
		textField_5.setColumns(10);
		
		textField_6 = new JTextField();
		textField_6.setBounds(123, 191, 294, 20);
		panel_1.add(textField_6);
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
			
			pCtr.createMassProduct(barcode, name, description, price, amount, min, max);
			DefaultTableModel model = (DefaultTableModel) table.getModel();
			model.addRow(new Object[] {barcode, name, description, price, amount, min, max});
			tabbedPane.setSelectedIndex(0);
			
			
			
			
			}
		});
		btnOpretProdukt_1.setBounds(21, 238, 113, 23);
		panel_1.add(btnOpretProdukt_1);
		
		JButton btnAnuller = new JButton("Anuller");
		btnAnuller.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tabbedPane.setSelectedIndex(0);
			}
		});
		btnAnuller.setBounds(138, 238, 89, 23);
		panel_1.add(btnAnuller);
	}
	public TableModel productTable(Map<Integer, Product> map) {

		DefaultTableModel model = new DefaultTableModel(new Object[] { "barcode", "name", "beskrivelse", "pris", "antal", "min", "max" },
				0);
		for (Map.Entry<Integer, Product> entry : map.entrySet()) {

			model.addRow(new Object[] { entry.getValue().getBarcode(), entry.getValue().getName(), entry.getValue().getDescription(),entry.getValue().getPrice(), entry.getValue().getAmount(), entry.getValue().getMinAmount(), entry.getValue().getMaxAmount() });
		}
		return model;

	}
}
