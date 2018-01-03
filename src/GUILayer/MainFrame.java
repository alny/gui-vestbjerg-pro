package GUILayer;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MainFrame extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainFrame frame = new MainFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MainFrame() {
		initGUI();
	}

	private void initGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 742, 555);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JButton btnNewButton = new JButton("Salg med Kunde");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				KundeFrame kundeFrame = new KundeFrame();
				kundeFrame.setVisible(true);
				dispose();
			}
		});
		btnNewButton.setBounds(283, 181, 152, 23);
		panel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Salg uden Kunde");
		btnNewButton_1.setBounds(283, 231, 152, 23);
		panel.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Opret Produkt");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ProduktFrame produktFrame = new ProduktFrame();
				produktFrame.setVisible(true);
				dispose();
				
			}
		});
		btnNewButton_2.setBounds(283, 278, 152, 23);
		panel.add(btnNewButton_2);
	}

}
