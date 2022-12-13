package vistas;

import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;

public class panel_gerente extends JPanel {

	/**
	 * Create the panel.
	 */
	public panel_gerente() {
		setLayout(null);
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 128, 192));
		panel.setBounds(0, 0, 1094, 713);
		add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Gerente");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 38));
		lblNewLabel.setBounds(299, 150, 159, 122);
		panel.add(lblNewLabel);
	}

}
