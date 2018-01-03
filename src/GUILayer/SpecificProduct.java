package GUILayer;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import ControllerLayer.ProductController;
import ModelLayer.Product;

public class SpecificProduct extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private ProductController productCtr;
	private JLabel name;

	public SpecificProduct() {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		{
			name = new JLabel("Produkt Navn");
			name.setHorizontalAlignment(SwingConstants.CENTER);
			contentPanel.add(name, BorderLayout.NORTH);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
	
	public void setLabels(int bar) {
		Product productObj = productCtr.findSpecificProduct(bar);
		name.setText(productObj.getName());
	}

}
