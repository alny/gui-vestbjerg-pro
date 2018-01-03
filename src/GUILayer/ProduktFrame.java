package GUILayer;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import ControllerLayer.ProductController;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ProduktFrame extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private ProductController productCtr;
	private JTextField textField_4;
	private MainFrame mainFrame;

	public ProduktFrame() {
		productCtr = new ProductController();
		init();
	}

	private void init() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 742, 555);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JLabel lblOprettelseAfProdukt = new JLabel("Oprettelse af Produkt");
		lblOprettelseAfProdukt.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblOprettelseAfProdukt, BorderLayout.NORTH);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel lblProduktNavn = new JLabel("Barkode: ");
		lblProduktNavn.setBounds(160, 95, 102, 14);
		panel.add(lblProduktNavn);
		
		textField = new JTextField();
		textField.setBounds(237, 92, 237, 20);
		panel.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Navn: ");
		lblNewLabel.setBounds(160, 143, 46, 14);
		panel.add(lblNewLabel);
		
		textField_1 = new JTextField();
		textField_1.setBounds(237, 140, 237, 20);
		panel.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(237, 190, 237, 20);
		panel.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblBeskrivelse = new JLabel("Beskrivelse:");
		lblBeskrivelse.setBounds(160, 193, 67, 14);
		panel.add(lblBeskrivelse);
		
		JLabel lblPris = new JLabel("Pris: ");
		lblPris.setBounds(160, 237, 46, 14);
		panel.add(lblPris);
		
		textField_3 = new JTextField();
		textField_3.setBounds(237, 234, 237, 20);
		panel.add(textField_3);
		textField_3.setColumns(10);
		
		JLabel lblAntal = new JLabel("Antal: ");
		lblAntal.setBounds(160, 280, 46, 14);
		panel.add(lblAntal);
		
		textField_4 = new JTextField();
		textField_4.setBounds(237, 277, 237, 20);
		panel.add(textField_4);
		textField_4.setColumns(10);
		
		JPanel panel_1 = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel_1.getLayout();
		flowLayout.setAlignment(FlowLayout.RIGHT);
		contentPane.add(panel_1, BorderLayout.SOUTH);
		
		JButton btnOpret = new JButton("Opret");
		btnOpret.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int barcode = Integer.parseInt(textField.getText());
				String name = textField_1.getText();
				String description = textField_2.getText();
				int price = Integer.parseInt(textField_3.getText());
				int amount = Integer.parseInt(textField_4.getText());
				productCtr.createMassProduct(barcode, name, description, price, amount, 2, 4);
				System.out.println("Produkt oprettet");
				mainFrame = new MainFrame();
				mainFrame.setVisible(true);
				dispose();
				
			}
		});
		panel_1.add(btnOpret);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				mainFrame = new MainFrame();
				mainFrame.setVisible(true);
				dispose();
			}
		});
		panel_1.add(btnCancel);
	}
}
