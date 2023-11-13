package Consola;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class PanelRemoveCar extends JPanel implements ActionListener{
	private JLabel bienvenida;
	private JButton back = new JButton("Back");
	private JButton send = new JButton("Send");
	private JTextField placaTF;
	
	public PanelRemoveCar() {
		setLayout(new BorderLayout());
		
		bienvenida = new JLabel("Eliminar Vehiculo", SwingConstants.CENTER);
		bienvenida.setFont(new Font("Times New Roman", Font.BOLD, 30));
		bienvenida.setPreferredSize(new Dimension(900,40));
		bienvenida.setBackground(new Color(0xFAB0B9));
		bienvenida.setOpaque(true);
		add(bienvenida,BorderLayout.NORTH);
		
		JPanel options = new JPanel();
		
		JLabel placa = new JLabel("Placa");
		placa.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		placaTF = new JTextField();
		
		send.setFont(new Font("Times New Roman", Font.BOLD, 20));
		send.setBackground(new Color(0xFF5757));
		send.addActionListener(this);
		

		back.setFont(new Font("Times New Roman", Font.BOLD, 20));
		back.setBackground(new Color(0xFAB0B9));
		back.addActionListener(this);
		
		
		options.setLayout(new GridLayout(0,2,0,20));
		options.add(placa);
		options.add(placaTF);
		options.add(back);
		options.add(send);
		
		add(options);
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == back) {
			ConsolaRentaCar.consolaAdminG();
		}
		else if(e.getSource()==send) {
			String placa = placaTF.getText();
			try {
				boolean ret = ConsolaRentaCar.eliminarVehiculo(placa);
				if (ret) {
					placaTF.setText("");
					JOptionPane.showMessageDialog(this, "Car eliminated succesfully", "Success", JOptionPane.PLAIN_MESSAGE);
				}
				else {
					JOptionPane.showMessageDialog(this, "Error Please Verify Information", "Error", JOptionPane.ERROR_MESSAGE);
				}
			}
			catch(IOException e1) {
				JOptionPane.showMessageDialog(this, "Error Please Verify Information", "Error", JOptionPane.ERROR_MESSAGE);
			}
		}
	}
	
}
