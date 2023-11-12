package Consola;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import Loader.RentaCar;
import Model.Usuario;

public class ConsolaCliente implements ActionListener{

	JFrame frame;
	Usuario usuarioActual;
	RentaCar rentaCarros;
	JLabel bienvenida;
	JButton nuevaReserva = new JButton("Nueva Reserva");
	JButton consultarReserva = new JButton("Consultar Reserva");
	JButton cerrarSesion  = new JButton();
	JPanel panel = new JPanel();
	ImageIcon imageCerrar = new ImageIcon("./imagenes/cerrarSesion.png");
	
	public ConsolaCliente(JFrame frame, Usuario usuario_actual, RentaCar renta_carros) {
		this.frame = frame;
		this.usuarioActual = usuario_actual;
		this.rentaCarros = renta_carros;
		
		frame.getContentPane().removeAll();
		frame.repaint();
		frame.setPreferredSize(new Dimension(700,500));
		frame.setLayout(new BorderLayout());
		frame.setResizable(false);
		
		bienvenida = new JLabel("Bienvenido " + this.usuarioActual.getNombre(), SwingConstants.CENTER);
		bienvenida.setFont(new Font("Times New Roman", Font.BOLD, 30));
		bienvenida.setPreferredSize(new Dimension(700,100));
		frame.add(bienvenida, BorderLayout.NORTH);
		
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		panel.add(Box.createVerticalStrut(60));
		
		JPanel reserva = new JPanel();
		reserva.setPreferredSize(new Dimension(600,40));
		
		nuevaReserva.setPreferredSize(new Dimension(600,40));
		nuevaReserva.setBackground(new Color(0xFF5757));
		nuevaReserva.setFont(new Font("Times New Roman", Font.BOLD, 20));
		nuevaReserva.addActionListener(this);
		reserva.add(nuevaReserva);
		panel.add(reserva);
		
		JPanel consultar = new JPanel();
		consultar.setPreferredSize(new Dimension(600,40));
		consultarReserva.setPreferredSize(new Dimension(600,40));
		consultarReserva.setBackground(new Color(0xFAB0B9));
		consultarReserva.setFont(new Font("Times New Roman", Font.BOLD, 20));
		consultarReserva.addActionListener(this);
		consultar.add(consultarReserva);
		panel.add(consultar);
		
		frame.add(panel, BorderLayout.CENTER);
		
		JPanel cerrar = new JPanel();
		cerrar.setLayout(new BorderLayout());
		ImageIcon imagenArreglada = new ImageIcon(imageCerrar.getImage().getScaledInstance(50,50, Image.SCALE_SMOOTH));
		cerrarSesion.setIcon(imagenArreglada);
		cerrarSesion.setPreferredSize(new Dimension(70,70));
		cerrarSesion.addActionListener(this);
		cerrar.add(cerrarSesion, BorderLayout.EAST);
		frame.add(cerrar, BorderLayout.SOUTH);
		
		frame.getContentPane().revalidate();
		frame.pack();
	    frame.repaint(); 
	    frame.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

}
