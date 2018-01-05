package TestGUI;

import java.awt.BorderLayout;
import java.awt.CardLayout;

import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import ControllerLayer.OrderController;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JSplitPane;

public class OrderMenu extends JPanel {
	
	private CardLayout parent;
	private JPanel parentPanel;
	private OrderController orderCtr;
	private JTabbedPane tabbedPane;
	private JTable table;
	private JTable jt;
	private JSplitPane split;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	
	public OrderMenu(JPanel mainPanel, CardLayout cardLayout) {
		init();
		parentPanel = mainPanel;
		parent = cardLayout;
	}

	private void init() {
		setBounds(100, 100, 750, 500);
		setLayout(new BorderLayout(0, 0));
		
		orderCtr = new OrderController();

		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		add(tabbedPane, BorderLayout.CENTER);
		tabbedPane.addTab("Ordre Menu", null, orderMainMenu(), null);
		tabbedPane.addTab("Salg m. Kunde", null, saleWithCustomer(), null);
		tabbedPane.addTab("Salg u. Kunde", null, null, null);
		
		
		

	}
	
	
	private JPanel orderMainMenu() {
		
		JPanel mainPanel = new JPanel();
		mainPanel.setLayout(null);
		
		JButton btnSalgMKunde = new JButton("Salg m. Kunde");
		btnSalgMKunde.setBounds(274, 125, 196, 79);
		mainPanel.add(btnSalgMKunde);
		
		JButton btnSalgUKunde = new JButton("Salg u. Kunde");
		btnSalgUKunde.setBounds(274, 270, 196, 72);
		mainPanel.add(btnSalgUKunde);
		
		JButton btnTilbage = new JButton("Tilbage");
		btnTilbage.setBounds(24, 367, 97, 25);
		mainPanel.add(btnTilbage);
		
		
		return mainPanel;
	}
	
	
	private JPanel saleWithCustomer() {
		JPanel salePanel = new JPanel();
		salePanel.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_1 = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel_1.getLayout();
		flowLayout.setAlignment(FlowLayout.LEFT);
		salePanel.add(panel_1, BorderLayout.SOUTH);
		
		JButton btnAfslutSalg = new JButton("Afslut Salg");
		panel_1.add(btnAfslutSalg);
		
		JButton btnAnnuller = new JButton("Annuller");
		panel_1.add(btnAnnuller);
		
		JPanel panel = new JPanel();
		JPanel panel_2 = new JPanel();
		salePanel.add(panel, BorderLayout.CENTER);
		
		
		jt = new JTable();
		JScrollPane sp = new JScrollPane();
		sp.setBounds(88, 251, 452, 155);
		sp.setViewportView(jt);
		panel.add(sp);
		
		JSplitPane split = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, panel, panel_2);
		panel_2.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Navn");
		lblNewLabel.setBounds(12, 44, 56, 16);
		panel_2.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(66, 41, 153, 22);
		panel_2.add(textField);
		textField.setColumns(10);
		
		JLabel lblTelefon = new JLabel("Telefon");
		lblTelefon.setBounds(12, 98, 56, 16);
		panel_2.add(lblTelefon);
		
		textField_1 = new JTextField();
		textField_1.setBounds(66, 95, 153, 22);
		panel_2.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblAdresse = new JLabel("Adresse");
		lblAdresse.setBounds(12, 150, 56, 16);
		panel_2.add(lblAdresse);
		
		textField_2 = new JTextField();
		textField_2.setBounds(66, 147, 153, 22);
		panel_2.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblPostNr = new JLabel("Post Nr");
		lblPostNr.setBounds(12, 197, 56, 16);
		panel_2.add(lblPostNr);
		
		textField_3 = new JTextField();
		textField_3.setBounds(66, 194, 153, 22);
		panel_2.add(textField_3);
		textField_3.setColumns(10);
		
		JButton btnNewButton = new JButton("Tilf\u00F8j Produkt");
		btnNewButton.setBounds(66, 336, 153, 25);
		panel_2.add(btnNewButton);
		
		JLabel lblNewLabel_1 = new JLabel("Barkode");
		lblNewLabel_1.setBounds(12, 304, 56, 16);
		panel_2.add(lblNewLabel_1);
		
		textField_4 = new JTextField();
		textField_4.setBounds(66, 301, 153, 22);
		panel_2.add(textField_4);
		textField_4.setColumns(10);
		salePanel.add(split);
		
		return salePanel;
	}
}
