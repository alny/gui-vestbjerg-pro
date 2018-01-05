package TestGUI;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.FlowLayout;
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

import ControllerLayer.OrderController;
import UILayer.CustomerDialog;

public class OrderMenu extends JPanel {
	
	private CardLayout parent;
	private JPanel parentPanel;
	private OrderController orderCtr;
	private JTabbedPane tabbedPane;
	private JTable table;
	private JTable jt;
	private JSplitPane split;
	private JTextField textField_4;
	private boolean status = false;
	private JDialog d;
	private CustomerDialog customerDialog;
	
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
		btnSalgMKunde.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				customerDialog = new CustomerDialog(orderCtr);
			}
		});
		btnSalgMKunde.setBounds(274, 125, 196, 79);
		mainPanel.add(btnSalgMKunde);
		
		JButton btnSalgUKunde = new JButton("Salg u. Kunde");
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
		
		jt.setModel(itemTable());
		JScrollPane sp = new JScrollPane();
		sp.setBounds(88, 251, 452, 155);
		sp.setViewportView(jt);
		panel.add(sp);
		
		JSplitPane split = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, panel, panel_2);
		panel_2.setLayout(null);
		
		JLabel lblTelefon = new JLabel("Telefon");
		lblTelefon.setBounds(12, 165, 56, 16);
		panel_2.add(lblTelefon);
		
		JLabel lblAdresse = new JLabel("Adresse");
		lblAdresse.setBounds(12, 51, 56, 16);
		panel_2.add(lblAdresse);
		
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
		
		
		JLabel lblNewLabel = new JLabel("Navn");
		lblNewLabel.setBounds(12, 13, 56, 16);
		panel_2.add(lblNewLabel);
		
		JLabel lblNewLabel_2 = new JLabel("By");
		lblNewLabel_2.setBounds(12, 90, 56, 16);
		panel_2.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Post Nr");
		lblNewLabel_3.setBounds(12, 126, 56, 16);
		panel_2.add(lblNewLabel_3);
		
		JLabel label = new JLabel("");
		label.setBounds(79, 13, 140, 16);
		panel_2.add(label);
		
		
		salePanel.add(split);
		
		
		
		return salePanel;
	}
	
	
	
	public TableModel itemTable() {

		DefaultTableModel model = new DefaultTableModel(new Object[] { "Stregkode", "Navn", "Beskrivelse", "Pris", "Antal" }, 0);

		return model;

	}
	
	
}
