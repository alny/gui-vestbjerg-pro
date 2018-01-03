package TestGUI;

import java.awt.CardLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MainMenu extends JFrame {

	private JPanel parentPanel;
	private JPanel menuPanel;
	private JPanel productPanel;
	private JPanel orderPanel;
	private CustomerMenu customerMenu;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainMenu frame = new MainMenu();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public MainMenu() {
		CardLayout cl = new CardLayout();
		parentPanel = new JPanel();
		menuPanel = new JPanel();
		customerMenu = new CustomerMenu(parentPanel, cl);
		productPanel = new JPanel();
		orderPanel = new JPanel();

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 750, 500);
		setContentPane(parentPanel);

		parentPanel.setLayout(cl);
		cl.show(parentPanel, "1");

		parentPanel.add(menuPanel, "1");
		parentPanel.add(customerMenu, "2");
		parentPanel.add(productPanel, "3");
		parentPanel.add(orderPanel, "4");

		menuPanel.setLayout(null);

		JLabel lblVelkommenTilVestbjerg = new JLabel("Vestbjerg Byggecenter's IT System");
		lblVelkommenTilVestbjerg.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblVelkommenTilVestbjerg.setBounds(217, 93, 300, 32);
		menuPanel.add(lblVelkommenTilVestbjerg);

		JButton btnKunder = new JButton("Kunder");
		btnKunder.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cl.show(parentPanel, "2");
			}
		});
		btnKunder.setBounds(233, 210, 105, 32);
		menuPanel.add(btnKunder);

		JButton btnProdukter = new JButton("Produkter");
		btnProdukter.setBounds(397, 210, 105, 32);
		menuPanel.add(btnProdukter);

		JButton btnNewButton = new JButton("Ordre");
		btnNewButton.setBounds(233, 290, 105, 32);
		menuPanel.add(btnNewButton);

		JButton btnNewButton_1 = new JButton("L�n");
		btnNewButton_1.setBounds(397, 290, 105, 32);
		menuPanel.add(btnNewButton_1);

		JButton btnAfslut = new JButton("Afslut");
		btnAfslut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				dispose();
			}
		});
		btnAfslut.setBounds(325, 368, 89, 23);
		menuPanel.add(btnAfslut);

	}

}
