package vistas;

import java.awt.EventQueue;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;

import javax.swing.border.LineBorder;

import clases.Imagenes;
import conector.Conectar_Bd;


import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

//import javax.swing.DefaultComboBoxModel;
//import javax.swing.JRadioButton;
import javax.swing.*;

public class Jf_principal {

	private JFrame frame;
	JTextField Jtf_Usuario;
	JPasswordField Jft_Contrasena;
	JComboBox Jcb_Usuarios;
	JPanel Pn_ContenedorLogin;
	JPanel Pn_Login;
	JLabel Jtl_MensajeErrorUsuario;
	JSeparator Sp_Contrasena; 
	JSeparator Sp_Usuario;
	
	Conectar_Bd bd = new Conectar_Bd();
	Connection con=bd.conectar();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Jf_principal window = new Jf_principal();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


		
	public Jf_principal() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setResizable(false);
		frame.setLocationByPlatform(true);
		frame.setBounds(100, 100, 1113, 751);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		Pn_ContenedorLogin = new JPanel();
		Pn_ContenedorLogin.setBounds(0, 0, 1094, 713);
		frame.getContentPane().add(Pn_ContenedorLogin);
		Pn_ContenedorLogin.setLayout(null);
		
		Pn_Login = new JPanel();
		Pn_Login.setBounds(362, 59, 385, 488);
		Pn_ContenedorLogin.add(Pn_Login);
		Pn_Login.setBackground(new Color(37, 69, 81));
		Pn_Login.setLayout(null);
		
		Sp_Usuario = new JSeparator();
		Sp_Usuario.setForeground(new Color(255, 255, 255));
		Sp_Usuario.setBounds(69, 260, 263, 1);
		Pn_Login.add(Sp_Usuario);
		
		Sp_Contrasena = new JSeparator();
		Sp_Contrasena.setForeground(Color.WHITE);
		Sp_Contrasena.setBounds(69, 330, 263, 1);
		Pn_Login.add(Sp_Contrasena);
		
		Jtf_Usuario = new JTextField();
		Jtf_Usuario.setHorizontalAlignment(SwingConstants.LEFT);
		Jtf_Usuario.setFont(new Font("Roboto Light", Font.PLAIN, 14));
		Jtf_Usuario.setForeground(new Color(192, 192, 192));
		Jtf_Usuario.setBorder(null);
		Jtf_Usuario.setBackground(new Color(37, 69, 81));
		Jtf_Usuario.setBounds(69, 239, 263, 19);
		Pn_Login.add(Jtf_Usuario);
		Jtf_Usuario.setColumns(10);
		
		JLabel Jl_Ingresar = new JLabel("Ingresar");
		Jl_Ingresar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				Jl_Ingresar.setBorder(new LineBorder(new Color(255, 255, 255), 2, true));
				
			}
			@Override
			public void mouseExited(MouseEvent e) {
				Jl_Ingresar.setBorder(new LineBorder(new Color(255, 255, 255), 1, true));
			}
			@Override
			public void mousePressed(MouseEvent e) {

				
				try {if
					(Jcb_Usuarios.getSelectedItem().equals("CAJA")) 
				{
					
					String usuario = Jtf_Usuario.getText();
					String password = String.valueOf(Jft_Contrasena.getPassword());
					String SQL = "SELECT * FROM tbl_us_caja WHERE usuario = '"+usuario+"' and contrasena = '"+password+"'  ";
					panel_caja pc = new panel_caja();
					Llamar_Usuario(pc, SQL);
				} 
						if(Jcb_Usuarios.getSelectedItem().equals("GERENTE")) 
						{
							String usuario = Jtf_Usuario.getText();
							String password = String.valueOf(Jft_Contrasena.getPassword());
							String SQL = "SELECT * FROM tbl_us_gerente WHERE usuario = '"+usuario+"' and contrasena = '"+password+"'  ";
							panel_gerente pg = new panel_gerente();
							Llamar_Usuario(pg, SQL);
						} 
				if(Jcb_Usuarios.getSelectedItem().equals("ADMINISTRADOR")) 
				{
					String usuario = Jtf_Usuario.getText();
					String password = String.valueOf(Jft_Contrasena.getPassword());
					String SQL = "SELECT * FROM tbl_us_administrador WHERE usuario = '"+usuario+"' and contrasena = '"+password+"'  ";
					panel_administrador pa = new panel_administrador();
					pa.Contenedor_Paneles.setSelectedIndex(0);
					Llamar_Usuario(pa, SQL);
					
				}
				else {
					//JOptionPane.showMessageDialog(null, "Sigue intentando");
				}} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, "Eror de ingreso" + e1.getMessage());//e nos ayuda a encontrar mas rapido el error
					
					
					// TODO: handle exception
				}}
				
				
				//if(TfRuta.getText().equals(""))
				
			
		});
		Jl_Ingresar.setForeground(new Color(255, 255, 255));
		Jl_Ingresar.setBorder(new LineBorder(new Color(255, 255, 255), 1, true));
		Jl_Ingresar.setHorizontalAlignment(SwingConstants.CENTER);
		Jl_Ingresar.setFont(new Font("Roboto Light", Font.ITALIC, 18));
		Jl_Ingresar.setBackground(new Color(255, 255, 255));
		Jl_Ingresar.setBounds(132, 362, 115, 37);
		Pn_Login.add(Jl_Ingresar);
		
		JLabel Jl_LogoLogin = new JLabel("");
		Jl_LogoLogin.setBounds(131, 10, 136, 100);
		Pn_Login.add(Jl_LogoLogin);
		
		JLabel Lb_Fondo = new JLabel("");
		Lb_Fondo.setForeground(new Color(255, 255, 255));
		Lb_Fondo.setFont(new Font("Roboto Light", Font.PLAIN, 16));
		Lb_Fondo.setBorder(null);
		Lb_Fondo.setIcon(new ImageIcon(Jf_principal.class.getResource("/imagenes/fondo_login.jpg")));
		Lb_Fondo.setBounds(0, 0, 1094, 713);
		Pn_ContenedorLogin.add(Lb_Fondo);
		Imagenes img = new Imagenes();
		img.Imagenes_Grandes(Jl_LogoLogin, "C:/Users/abelito/eclipse-workspace/Trabajo_final/src/imagenes/Logo_Login.png");
		
		JLabel Jl_Contrasena = new JLabel("Contrasena");
		Jl_Contrasena.setForeground(new Color(255, 255, 255));
		Jl_Contrasena.setFont(new Font("Roboto Light", Font.ITALIC, 20));
		Jl_Contrasena.setBounds(69, 285, 150, 29);
		Pn_Login.add(Jl_Contrasena);
		
		JLabel Jtl_Usuario = new JLabel("Usuario");
		Jtl_Usuario.setForeground(new Color(255, 255, 255));
		Jtl_Usuario.setFont(new Font("Roboto Light", Font.ITALIC, 20));
		Jtl_Usuario.setBounds(69, 132, 150, 37);
		Pn_Login.add(Jtl_Usuario);
		
		Jft_Contrasena = new JPasswordField();
		Jft_Contrasena.setFont(new Font("Roboto Light", Font.PLAIN, 14));
		Jft_Contrasena.setForeground(new Color(255, 255, 255));
		Jft_Contrasena.setBackground(new Color(37, 69, 81));
		Jft_Contrasena.setBorder(null);
		Jft_Contrasena.setBounds(69, 309, 263, 19);
		Pn_Login.add(Jft_Contrasena);
		
		Jcb_Usuarios = new JComboBox();
		Jcb_Usuarios.setOpaque(false);
		Jcb_Usuarios.setIgnoreRepaint(true);
		Jcb_Usuarios.setBackground(new Color(37, 69, 81));
		Jcb_Usuarios.setBorder(new LineBorder(new Color(255, 255, 255), 1, true));
		Jcb_Usuarios.setModel(new DefaultComboBoxModel(new String[] {"ADMINISTRADOR", "CAJA"}));
		Jcb_Usuarios.setForeground(new Color(255, 255, 255));
		Jcb_Usuarios.setFont(new Font("Roboto Light", Font.ITALIC, 16));
		Jcb_Usuarios.setBounds(69, 171, 263, 29);
		Pn_Login.add(Jcb_Usuarios);
		
		JLabel Jtl_CodigoEmpleado = new JLabel("Codigo");
		Jtl_CodigoEmpleado.setForeground(Color.WHITE);
		Jtl_CodigoEmpleado.setFont(new Font("Roboto Light", Font.ITALIC, 20));
		Jtl_CodigoEmpleado.setBounds(69, 210, 150, 29);
		Pn_Login.add(Jtl_CodigoEmpleado);
		
		Jtl_MensajeErrorUsuario = new JLabel("No se ha podido encontrar este usuario");
		Jtl_MensajeErrorUsuario.setVisible(false);
		Jtl_MensajeErrorUsuario.setForeground(new Color(255, 0, 0));
		Jtl_MensajeErrorUsuario.setFont(new Font("Roboto Light", Font.PLAIN, 13));
		Jtl_MensajeErrorUsuario.setBounds(90, 331, 227, 26);
		Pn_Login.add(Jtl_MensajeErrorUsuario);

				
	}

public void Cambio_Paneles(JPanel p) {
	p.setSize(1094, 713);
	p.setLocation(0, 0);
	//contenedor_panel.getSelectedIndex();
}

public void Llamar_Usuario(JPanel p, String SQL){
	
	try {
		int resultado = 0;
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery(SQL);
		
		
			if (rs.next()) {//recorera los registros de mi bdd
				
				resultado = 1;
				
					if(resultado == 1) {
						Cambio_Paneles(p);
						Pn_ContenedorLogin.removeAll();
						Pn_ContenedorLogin.add(p, BorderLayout.CENTER);
						Pn_ContenedorLogin.revalidate();
						Pn_ContenedorLogin.repaint();
						
					}
				
			} else {
				JLabel Jtl_ImgError = new JLabel("");
				Jtl_ImgError.setBounds(69, 335, 19, 19);
				Pn_Login.add(Jtl_ImgError);
				Imagenes imgError = new Imagenes();
				imgError.Imagenes_Error(Jtl_ImgError, "C:/Users/abelito/eclipse-workspace/Trabajo_final/src/imagenes/error.png");
				Jtl_MensajeErrorUsuario.setVisible(true);				
				Sp_Usuario.setForeground(new Color(255, 0, 0));
				Sp_Contrasena.setForeground(new Color(255, 0, 0));				
				

			}
		
	} catch (Exception e) {
		JOptionPane.showMessageDialog(null, "Eror de ingreso\n" + e.getMessage());//e nos ayuda a encontrar mas rapido el error
		
}
	}	
}
