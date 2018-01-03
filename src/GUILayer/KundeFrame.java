package GUILayer;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import ControllerLayer.ProductController;

public class KundeFrame extends JFrame {

	private JPanel contentPane;
	private MainFrame mainFrame;
	private JTextField textField;
	private ProductController productCtr;
	private SpecificProduct speProduct;

	public KundeFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 742, 555);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JLabel lblKundeFrame = new JLabel("Kunde Frame");
		lblKundeFrame.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblKundeFrame, BorderLayout.NORTH);
		
		JPanel panel = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel.getLayout();
		flowLayout.setAlignment(FlowLayout.RIGHT);
		contentPane.add(panel, BorderLayout.SOUTH);
		
		JButton btnNewButton = new JButton("Tilføj Salg");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				speProduct = new SpecificProduct();
				int bar = Integer.parseInt(textField.getText());
				speProduct.setLabels(bar);
				speProduct.setVisible(true);
			}
		});
		panel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Cancel");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mainFrame = new MainFrame();
				mainFrame.setVisible(true);
				setVisible(false);
				dispose();
			}
		});
		panel.add(btnNewButton_1);
		
		textField = new JTextField();
		contentPane.add(textField, BorderLayout.CENTER);
		textField.setColumns(10);
	}

}
