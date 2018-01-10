package TestGUI;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.CardLayout;

import javax.swing.JTabbedPane;
import java.awt.FlowLayout;
import javax.swing.JTable;

import ControllerLayer.LoanController;
import ControllerLayer.ProductController;

import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;


public class LoanMenu extends JPanel {
	private JTable table;
	private JPanel parentPanel;
	private CardLayout parent;
	private LoanController lCtr;
	private JTextField loanPeriodeField;
	private JTextField custumerPhoneField;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private int id;
	private JTextField loanid;
	private JTextField barcodeRLoan;
	private JTextField serialRno;

	/**
	 * Create the panel.
	 */
	public LoanMenu(JPanel mainPanel, CardLayout cardLayout, LoanController L) {
		parentPanel = mainPanel;
		parent = cardLayout;
		lCtr = L;
		setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(0, 0, 730, 460);
		add(tabbedPane);
		
		JPanel panel = new JPanel();
		tabbedPane.addTab("Forside", null, panel, null);
		panel.setLayout(null);
		
		JButton allLoanButton = new JButton("Se alle lån");
		allLoanButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				tabbedPane.setSelectedIndex(1);
			}
		});
		allLoanButton.setBounds(29, 84, 131, 59);
		panel.add(allLoanButton);
		
		JButton createLoanButton = new JButton("Opret L\u00E5n");
		createLoanButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tabbedPane.setSelectedIndex(2);
			}
		});
		createLoanButton.setBounds(170, 84, 131, 59);
		panel.add(createLoanButton);
		
		JButton returnLoan = new JButton("Returner L\u00E5n");
		returnLoan.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tabbedPane.setSelectedIndex(3);
			}
		});
		returnLoan.setBounds(311, 84, 131, 59);
		panel.add(returnLoan);
		
		JButton returntomain = new JButton("Tilbage");
		returntomain.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				parent.show(parentPanel, "1");
				
			}
		});
		returntomain.setBounds(29, 242, 89, 23);
		panel.add(returntomain);
		
		JButton button_1 = new JButton("Tilf\u00F8j produkt til l\u00E5n");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tabbedPane.setSelectedIndex(4);
			}
		});
		button_1.setBounds(170, 154, 131, 59);
		panel.add(button_1);
		
		JPanel allLoan = new JPanel();
		tabbedPane.addTab("Liste over lån", null, allLoan, null);
		allLoan.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_1 = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel_1.getLayout();
		flowLayout.setAlignment(FlowLayout.LEFT);
		allLoan.add(panel_1, BorderLayout.SOUTH);
		
		JButton btnNewButton_2 = new JButton("Opret L\u00E5n");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tabbedPane.setSelectedIndex(2);
			}
		});
		panel_1.add(btnNewButton_2);
		
		JButton btnNewButton_1 = new JButton("Returner L\u00E5n");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			tabbedPane.setSelectedIndex(3);
			}
		});
		panel_1.add(btnNewButton_1);
		
		JButton btnNewButton = new JButton("Tilbage");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			tabbedPane.setSelectedIndex(0);
			}
		});
		panel_1.add(btnNewButton);
		
		table = new JTable();
		allLoan.add(table, BorderLayout.CENTER);
		
		JPanel panel_2 = new JPanel();
		tabbedPane.addTab("Opret Lån", null, panel_2, null);
		panel_2.setLayout(null);
		
		JLabel lblAngivLnePeriode = new JLabel("Angiv l\u00E5ne periode i dage");
		lblAngivLnePeriode.setBounds(38, 32, 144, 14);
		panel_2.add(lblAngivLnePeriode);
		
		JLabel label = new JLabel("Kundens Telefon nr. ");
		label.setBounds(38, 57, 144, 14);
		panel_2.add(label);
		
		loanPeriodeField = new JTextField();
		loanPeriodeField.setBounds(179, 29, 144, 20);
		panel_2.add(loanPeriodeField);
		loanPeriodeField.setColumns(10);
		
		custumerPhoneField = new JTextField();
		custumerPhoneField.setColumns(10);
		custumerPhoneField.setBounds(179, 57, 144, 20);
		panel_2.add(custumerPhoneField);
		
		JButton btnOpretLn = new JButton("Opret L\u00E5n");
		btnOpretLn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			int day =Integer.parseInt(loanPeriodeField.getText());
			String phone =custumerPhoneField.getText();
			if (JOptionPane.showConfirmDialog(null, "Bekræft Oprettelse?", "Advarsel",
					JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
			id = lCtr.createLoan(day, phone);
			clearCreateLoan();
			JOptionPane.showMessageDialog(null, "Lån Oprettet låne ID:" + id );
			textField.setText(Integer.toString(id));
			tabbedPane.setSelectedIndex(4);
			}else {
				
			}
			
			}
		});
		btnOpretLn.setBounds(38, 109, 89, 23);
		panel_2.add(btnOpretLn);
		
		JButton button = new JButton("Annuller");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clearCreateLoan();
				tabbedPane.setSelectedIndex(0);
			}
		});
		button.setBounds(137, 109, 89, 23);
		panel_2.add(button);
		
		JPanel panel_3 = new JPanel();
		tabbedPane.addTab("Returner Lån", null, panel_3, null);
		panel_3.setLayout(null);
		
		JLabel lblLneId = new JLabel("L\u00E5ne ID");
		lblLneId.setBounds(64, 39, 76, 14);
		panel_3.add(lblLneId);
		
		JLabel label_1 = new JLabel("Stregkode");
		label_1.setBounds(64, 64, 76, 14);
		panel_3.add(label_1);
		
		JLabel label_2 = new JLabel("Serie nr. ");
		label_2.setBounds(64, 89, 76, 14);
		panel_3.add(label_2);
		
		loanid = new JTextField();
		loanid.setBounds(150, 36, 144, 20);
		panel_3.add(loanid);
		loanid.setColumns(10);
		
		barcodeRLoan = new JTextField();
		barcodeRLoan.setColumns(10);
		barcodeRLoan.setBounds(150, 61, 144, 20);
		panel_3.add(barcodeRLoan);
		
		serialRno = new JTextField();
		serialRno.setColumns(10);
		serialRno.setBounds(150, 86, 144, 20);
		panel_3.add(serialRno);
		
		JButton btnReturnerLn = new JButton("Returner L\u00E5n");
		btnReturnerLn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (JOptionPane.showConfirmDialog(null, "Bekræft Returnering?", "Advarsel",
						JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
				int rid = Integer.parseInt(loanid.getText());
				int bar = Integer.parseInt(barcodeRLoan.getText());
				int serial = Integer.parseInt(serialRno.getText());
				lCtr.returnItem(rid, bar, serial);
				JOptionPane.showMessageDialog(null, "Produkt returneret");
				clearReturn();
				
			}else {
			
			}
				
				}});
		btnReturnerLn.setBounds(64, 117, 107, 23);
		panel_3.add(btnReturnerLn);
		
		JButton button_3 = new JButton("Annuller");
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clearReturn();
				tabbedPane.setSelectedIndex(0);
				
			}
		});
		button_3.setBounds(181, 117, 107, 23);
		panel_3.add(button_3);
		
		JPanel panel_4 = new JPanel();
		tabbedPane.addTab("Tilføj produkter til et lån", null, panel_4, null);
		panel_4.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("L\u00E5ne ID");
		lblNewLabel.setBounds(57, 57, 98, 14);
		panel_4.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Stregkode");
		lblNewLabel_1.setBounds(57, 82, 98, 14);
		panel_4.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Serialnr.");
		lblNewLabel_2.setBounds(57, 107, 98, 14);
		panel_4.add(lblNewLabel_2);
		
		textField = new JTextField();
		textField.setBounds(146, 54, 170, 20);
		panel_4.add(textField);
		textField.setColumns(10);
		
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(146, 79, 170, 20);
		panel_4.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(146, 107, 170, 20);
		panel_4.add(textField_2);
		
		JButton btnTilfjProdukt = new JButton("Tilf\u00F8j Produkt");
		btnTilfjProdukt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
			if (JOptionPane.showConfirmDialog(null, "Bekræft Oprettelse?", "Advarsel",
			JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {	
				int lid = Integer.parseInt(textField.getText());
				int bar = Integer.parseInt(textField_1.getText());
				int serial = Integer.parseInt(textField_2.getText());
				lCtr.addItem(lid, bar, serial);
				JOptionPane.showMessageDialog(null, "Produkt tilføjet");
				clearAddItem();
				tabbedPane.setSelectedIndex(1);
			}else {
				
			
			}
			}
		});
		btnTilfjProdukt.setBounds(57, 152, 110, 23);
		panel_4.add(btnTilfjProdukt);
		
		JButton button_2 = new JButton("Annuller");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tabbedPane.setSelectedIndex(0);
				clearAddItem();
			}
		});
		button_2.setBounds(177, 152, 110, 23);
		panel_4.add(button_2);

	}
	public void clearCreateLoan() {
	custumerPhoneField.setText("");
	loanPeriodeField.setText("");
	}
	public void clearAddItem() {
	textField.setText("");
	textField_1.setText("");
	textField_2.setText("");
	}
	public void clearReturn() {
	loanid.setText("");
	barcodeRLoan.setText("");
	serialRno.setText("");
	}
	
	}