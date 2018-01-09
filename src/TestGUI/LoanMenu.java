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
		allLoanButton.setBounds(29, 116, 131, 59);
		panel.add(allLoanButton);
		
		JButton createLoanButton = new JButton("Opret L\u00E5n");
		createLoanButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tabbedPane.setSelectedIndex(2);
			}
		});
		createLoanButton.setBounds(170, 116, 131, 59);
		panel.add(createLoanButton);
		
		JButton returnLoan = new JButton("Returner L\u00E5n");
		returnLoan.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tabbedPane.setSelectedIndex(3);
			}
		});
		returnLoan.setBounds(311, 116, 131, 59);
		panel.add(returnLoan);
		
		JButton returntomain = new JButton("Tilbage");
		returntomain.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				parent.show(parentPanel, "1");
				
			}
		});
		returntomain.setBounds(29, 242, 89, 23);
		panel.add(returntomain);
		
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
			lCtr.createLoan(day, phone);
			clearCreateLoan();
			JOptionPane.showMessageDialog(null, "Lån Oprettet");
			tabbedPane.setSelectedIndex(1);
			}else {
				
			}
			
			}
		});
		btnOpretLn.setBounds(38, 109, 89, 23);
		panel_2.add(btnOpretLn);
		
		JButton button = new JButton("Annuller");
		button.setBounds(137, 109, 89, 23);
		panel_2.add(button);
		
		JPanel panel_3 = new JPanel();
		tabbedPane.addTab("Returner Lån", null, panel_3, null);

	}
	public void clearCreateLoan() {
	custumerPhoneField.setText("");
	loanPeriodeField.setText("");
	}
	}

