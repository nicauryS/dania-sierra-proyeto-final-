package vistas;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JSeparator;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;

import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.text.MaskFormatter;

import clases.Imagenes;
import clases.Registrar;
import clases.Tablas;
import conector.Conectar_Bd;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.Cursor;
import javax.swing.JFormattedTextField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.ComponentOrientation;

public class panel_administrador<Pn_ContenedorLogin> extends JPanel {
	private JTextField Jtf_CrearCodigo;
	private JTextField Jtf_CrearContrasena;
	private JFormattedTextField Jtf_Nombre;
	private JFormattedTextField Jtf_Identificacion;
	private JFormattedTextField Jtf_Telefono;
	private JFormattedTextField Jtf_Codigo;
	private JLabel Jl_BotonCrearEmpleado;
	private JComboBox Jcb_Posicion;
	JComboBox Jcb_Sucursal;
	JComboBox Jcb_Usuarios;
	JComboBox Jcb_Tanda;
	JTabbedPane Contenedor_Paneles;
	JComboBox Jcb_Sueldo;
	MaskFormatter nombre;
	MaskFormatter telefono;
	MaskFormatter identificacion;
	MaskFormatter codigo;
	MaskFormatter precio;
	MaskFormatter cantidad;
	JLabel Jl_MensajeBOM_1;
	JLabel Jl_MensajeBOM_2;
	
	Conectar_Bd bd = new Conectar_Bd();
	Connection con=bd.conectar();
	private JTextField Jtf_NombreNuevoProducto;
	private JFormattedTextField Jtf_PrecioNuevoProducto;
	private JTable Tbl_Productos;
	private JTextField Jtf_NombreEditarProducto;
	private JFormattedTextField Jtf_PrecioEditarProducto;
	private JFormattedTextField Jtf_CantidadNuevoProducto;
	private JFormattedTextField Jtf_CantidadEditarProducto;
	private JTable Tbl_Informacion;
	JComboBox Jcb_Inforamcion;
	JPanel panel_administrador;
	
	public panel_administrador() {
		setBackground(new Color(0, 64, 0));
		setLayout(null);
		
		try
		{
			nombre = new MaskFormatter("****************************************");
			telefono = new MaskFormatter("###-###-####");
			identificacion = new MaskFormatter("###-#######-#");
			codigo = new MaskFormatter("###*****");
			precio = new MaskFormatter("####");
			cantidad = new MaskFormatter("######");
			
		} catch(Exception ex) 
		{
			JOptionPane.showConfirmDialog(null, "Error de mascara");
		}
		
		
		
		Imagenes IconoCrearUsuario = new Imagenes();
		Imagenes IconoInformacion = new Imagenes();
		Imagenes IconoCerrarSesion = new Imagenes();
		
		panel_administrador = new JPanel();
		panel_administrador.setBorder(null);
		panel_administrador.setBackground(new Color(255, 255, 255));
		panel_administrador.setBounds(0, 0, 1094, 713);
		add(panel_administrador);
		panel_administrador.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Administrador");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("Roboto Thin", Font.BOLD | Font.ITALIC, 48));
		lblNewLabel_1.setBounds(766, 0, 318, 73);
		panel_administrador.add(lblNewLabel_1);
		
		JLabel Jl_FondoTitulo = new JLabel("");
		Jl_FondoTitulo.setIcon(new ImageIcon(panel_administrador.class.getResource("/imagenes/fondo_login.jpg")));
		Jl_FondoTitulo.setBounds(0, 0, 1094, 100);
		panel_administrador.add(Jl_FondoTitulo);
		
		Contenedor_Paneles = new JTabbedPane(JTabbedPane.TOP);
		Contenedor_Paneles.setBackground(new Color(16, 33, 40));
		Contenedor_Paneles.setBorder(null);
		Contenedor_Paneles.setBounds(-10, 70, 1117, 662);
		panel_administrador.add(Contenedor_Paneles);
		Imagenes IconoCrearEmpleado = new Imagenes();
		
		JPanel panel_Inicio = new JPanel();
		panel_Inicio.setBackground(new Color(37, 69, 81));
		Contenedor_Paneles.addTab("Panel Inicion", null, panel_Inicio, null);
		panel_Inicio.setLayout(null);
		
		JPanel panel_IrInventario = new JPanel();
		panel_IrInventario.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		panel_IrInventario.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				panel_IrInventario.setBorder(new LineBorder(new Color(16, 33, 40), 1, true));
				
			}
			@Override
			public void mouseExited(MouseEvent e) {
				panel_IrInventario.setBorder(new LineBorder(new Color(255, 255, 255), 0, true));
				
			}
			@Override
			public void mousePressed(MouseEvent e) {
				Contenedor_Paneles.setSelectedIndex(3);
			}
		});
		panel_IrInventario.setBounds(446, 229, 204, 179);
		panel_IrInventario.setLayout(null);
		panel_IrInventario.setForeground(new Color(16, 33, 40));
		panel_IrInventario.setBackground(new Color(37, 69, 81));
		panel_Inicio.add(panel_IrInventario);
		
		JLabel Jl_IconoInventario = new JLabel("");
		Jl_IconoInventario.setBorder(null);
		Jl_IconoInventario.setBounds(41, 10, 130, 130);
		panel_IrInventario.add(Jl_IconoInventario);
		Imagenes IconoInventario = new Imagenes(); 
		IconoInventario.Imagenes_IconoMedianos(Jl_IconoInventario, "C:/Users/abelito/eclipse-workspace/Trabajo_final/src/imagenes/listas-de-control.png");
		
		JLabel Jl_IrProductos = new JLabel("Productos");
		Jl_IrProductos.setForeground(Color.WHITE);
		Jl_IrProductos.setFont(new Font("Roboto Light", Font.ITALIC, 22));
		Jl_IrProductos.setBounds(51, 146, 105, 23);
		panel_IrInventario.add(Jl_IrProductos);
		
		JPanel panel_irCrearUsuario = new JPanel();
		panel_irCrearUsuario.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		panel_irCrearUsuario.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				panel_irCrearUsuario.setBorder(new LineBorder(new Color(16, 33, 40), 1, true));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				panel_irCrearUsuario.setBorder(new LineBorder(new Color(255, 255, 255), 0, true));
			}
			@Override
			public void mousePressed(MouseEvent e) {
				Contenedor_Paneles.setSelectedIndex(1);
			}
		});
		panel_irCrearUsuario.setBounds(784, 41, 204, 179);
		panel_irCrearUsuario.setLayout(null);
		panel_irCrearUsuario.setForeground(new Color(16, 33, 40));
		panel_irCrearUsuario.setBackground(new Color(37, 69, 81));
		panel_Inicio.add(panel_irCrearUsuario);
		
		JLabel Jl_IconoCrearUsuario = new JLabel("");
		Jl_IconoCrearUsuario.setBorder(null);
		Jl_IconoCrearUsuario.setBounds(27, 6, 130, 130);
		panel_irCrearUsuario.add(Jl_IconoCrearUsuario);
		IconoCrearUsuario.Imagenes_IconoMedianos(Jl_IconoCrearUsuario, "C:/Users/abelito/eclipse-workspace/Trabajo_final/src/imagenes/agregar-usuario.png");
		
		JLabel Jl_IrCrearUsuario = new JLabel("Crear Usuario");
		Jl_IrCrearUsuario.setForeground(Color.WHITE);
		Jl_IrCrearUsuario.setFont(new Font("Roboto Light", Font.ITALIC, 22));
		Jl_IrCrearUsuario.setBounds(23, 146, 155, 23);
		panel_irCrearUsuario.add(Jl_IrCrearUsuario);
		
		JPanel Panel_IrCrearEmpleado = new JPanel();
		Panel_IrCrearEmpleado.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		Panel_IrCrearEmpleado.setBorder(new LineBorder(new Color(255, 255, 255), 0, true));
		Panel_IrCrearEmpleado.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				//Panel_IrCrearEmpleado.setBackground(new Color(37, 69, 87));
				Panel_IrCrearEmpleado.setBorder(new LineBorder(new Color(16, 33, 40), 1, true));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				Panel_IrCrearEmpleado.setBorder(new LineBorder(new Color(37, 69, 87), 0, true));
			}
			@Override
			public void mousePressed(MouseEvent e) {
				Contenedor_Paneles.setSelectedIndex(2);
			}
		});
		Panel_IrCrearEmpleado.setBounds(100, 41, 204, 179);
		Panel_IrCrearEmpleado.setLayout(null);
		Panel_IrCrearEmpleado.setForeground(new Color(16, 33, 40));
		Panel_IrCrearEmpleado.setBackground(new Color(37, 69, 81));
		panel_Inicio.add(Panel_IrCrearEmpleado);
		
		JLabel Jl_IconoCrearEmpleado = new JLabel("");
		Jl_IconoCrearEmpleado.setBorder(null);
		Jl_IconoCrearEmpleado.setBounds(35, 10, 130, 130);
		Panel_IrCrearEmpleado.add(Jl_IconoCrearEmpleado);
		IconoCrearEmpleado.Imagenes_IconoMedianos(Jl_IconoCrearEmpleado, "C:/Users/abelito/eclipse-workspace/Trabajo_final/src/imagenes/agregar-usuario.png"); 
		
		JLabel Jl_IrCrearEmpleado = new JLabel("Crear Empleado");
		Jl_IrCrearEmpleado.setForeground(Color.WHITE);
		Jl_IrCrearEmpleado.setFont(new Font("Roboto Light", Font.ITALIC, 22));
		Jl_IrCrearEmpleado.setBounds(22, 150, 155, 23);
		Panel_IrCrearEmpleado.add(Jl_IrCrearEmpleado);
		
		JPanel panel_IrInformacion = new JPanel();
		panel_IrInformacion.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		panel_IrInformacion.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				panel_IrInformacion.setBorder(new LineBorder(new Color(16, 33, 40), 1, true));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				panel_IrInformacion.setBorder(new LineBorder(new Color(255, 255, 255), 0, true));
			}
			@Override
			public void mousePressed(MouseEvent e) {
				Contenedor_Paneles.setSelectedIndex(4);
			}
		});
		panel_IrInformacion.setBounds(100, 335, 204, 179);
		panel_IrInformacion.setLayout(null);
		panel_IrInformacion.setForeground(new Color(16, 33, 40));
		panel_IrInformacion.setBackground(new Color(37, 69, 81));
		panel_Inicio.add(panel_IrInformacion);
		
		JLabel Jl_IconoInformacion = new JLabel("");
		Jl_IconoInformacion.setBorder(null);
		Jl_IconoInformacion.setBounds(28, 4, 147, 132);
		panel_IrInformacion.add(Jl_IconoInformacion);
		IconoInformacion.Imagenes_IconoMedianos(Jl_IconoInformacion, "C:/Users/abelito/eclipse-workspace/Trabajo_final/src/imagenes/buscar.png");
		
		
		JLabel Jl_Informacion = new JLabel("Informacion");
		Jl_Informacion.setForeground(Color.WHITE);
		Jl_Informacion.setFont(new Font("Roboto Light", Font.ITALIC, 22));
		Jl_Informacion.setBounds(43, 146, 122, 23);
		panel_IrInformacion.add(Jl_Informacion);
		
		JPanel panel_CerrarSesion = new JPanel();
		panel_CerrarSesion.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		panel_CerrarSesion.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				panel_CerrarSesion.setBorder(new LineBorder(new Color(255, 00, 00), 1, true));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				panel_CerrarSesion.setBorder(new LineBorder(new Color(255, 255, 255), 0, true));
			}
			@Override
			public void mousePressed(MouseEvent e) {
				Jf_principal jfp = new Jf_principal();
				Jf_principal pn = new Jf_principal(); 
				Cerrar_Secion(pn.Pn_ContenedorLogin);
				
			}
		});
		panel_CerrarSesion.setBounds(784, 335, 204, 179);
		panel_CerrarSesion.setLayout(null);
		panel_CerrarSesion.setForeground(new Color(16, 33, 40));
		panel_CerrarSesion.setBackground(new Color(37, 69, 81));
		panel_Inicio.add(panel_CerrarSesion);
		
		JLabel Jl_IconoCerrarSesion = new JLabel("");
		Jl_IconoCerrarSesion.setBorder(null);
		Jl_IconoCerrarSesion.setBounds(37, 10, 130, 130);
		panel_CerrarSesion.add(Jl_IconoCerrarSesion);
		IconoCerrarSesion.Imagenes_IconoMedianos(Jl_IconoCerrarSesion, "C:/Users/abelito/eclipse-workspace/Trabajo_final/src/imagenes/cerrar-sesion.png") ;
		
		JLabel Jl_CerrarSecion = new JLabel("Cerrar secion");
		Jl_CerrarSecion.setForeground(Color.WHITE);
		Jl_CerrarSecion.setFont(new Font("Roboto Light", Font.ITALIC, 22));
		Jl_CerrarSecion.setBounds(37, 146, 130, 23);
		panel_CerrarSesion.add(Jl_CerrarSecion);
		
		JPanel panel_CrearUsuario = new JPanel();
		panel_CrearUsuario.setBackground(new Color(37, 69, 81));
		Contenedor_Paneles.addTab("panel_CrearUsuario", null, panel_CrearUsuario, null);
		Contenedor_Paneles.setBackgroundAt(1, new Color(16, 33, 40));
		panel_CrearUsuario.setLayout(null);
		
		JLabel Jl_Inicio2 = new JLabel("");
		Jl_Inicio2.setHorizontalAlignment(SwingConstants.CENTER);
		Jl_Inicio2.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				Contenedor_Paneles.setSelectedIndex(0);
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				Jl_Inicio2.setBorder(new LineBorder(new Color(16, 33, 40), 1, true));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				Jl_Inicio2.setBorder(new LineBorder(new Color(16, 33, 40), 0, true));
			}
		});
		Jl_Inicio2.setBounds(484, 549, 48, 48);
		Imagenes IconoInicio5 = new Imagenes();
		IconoInicio5.Imagenes_Icono(Jl_Inicio2, "C:/Users/abelito/eclipse-workspace/Trabajo_final/src/imagenes/Inicio.png");
		panel_CrearUsuario.add(Jl_Inicio2);
		
		
		JLabel Jl_CrearUsuario = new JLabel("Crear Usuario");
		Jl_CrearUsuario.setBounds(367, 10, 244, 60);
		Jl_CrearUsuario.setForeground(new Color(255, 255, 255));
		Jl_CrearUsuario.setFont(new Font("Poppins ExtraBold", Font.ITALIC, 34));
		panel_CrearUsuario.add(Jl_CrearUsuario);
		
		JLabel Jl_Codigo = new JLabel("Codigo");
		Jl_Codigo.setBounds(367, 80, 85, 44);
		Jl_Codigo.setForeground(Color.WHITE);
		Jl_Codigo.setFont(new Font("Roboto Light", Font.PLAIN, 24));
		panel_CrearUsuario.add(Jl_Codigo);
		
		JLabel Jl_CrearUsuario_2 = new JLabel("Contrasena");
		Jl_CrearUsuario_2.setBounds(367, 160, 130, 38);
		Jl_CrearUsuario_2.setForeground(Color.WHITE);
		Jl_CrearUsuario_2.setFont(new Font("Roboto Light", Font.PLAIN, 24));
		panel_CrearUsuario.add(Jl_CrearUsuario_2);
		
		Jtf_CrearCodigo = new JTextField();
		Jtf_CrearCodigo.setBounds(367, 131, 218, 19);
		Jtf_CrearCodigo.setBackground(new Color(37, 69, 81));
		Jtf_CrearCodigo.setBorder(null);
		Jtf_CrearCodigo.setForeground(new Color(192, 192, 192));
		Jtf_CrearCodigo.setFont(new Font("Roboto", Font.PLAIN, 20));
		panel_CrearUsuario.add(Jtf_CrearCodigo);
		Jtf_CrearCodigo.setColumns(10);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(367, 150, 289, 4);
		separator.setForeground(new Color(255, 255, 255));
		separator.setPreferredSize(new Dimension(0, 1));
		panel_CrearUsuario.add(separator);
		
		Jtf_CrearContrasena = new JTextField();
		Jtf_CrearContrasena.setBounds(367, 210, 218, 19);
		Jtf_CrearContrasena.setForeground(Color.LIGHT_GRAY);
		Jtf_CrearContrasena.setFont(new Font("Roboto", Font.PLAIN, 20));
		Jtf_CrearContrasena.setColumns(10);
		Jtf_CrearContrasena.setBorder(null);
		Jtf_CrearContrasena.setBackground(new Color(37, 69, 81));
		panel_CrearUsuario.add(Jtf_CrearContrasena);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(367, 229, 289, 4);
		separator_1.setForeground(new Color(255, 255, 255));
		separator_1.setPreferredSize(new Dimension(0, 1));
		panel_CrearUsuario.add(separator_1);
		
		JLabel Jl_CrearBotonCrear = new JLabel("Crear");
		Jl_CrearBotonCrear.setHorizontalAlignment(SwingConstants.CENTER);
		Jl_CrearBotonCrear.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				Jl_CrearBotonCrear.setBorder(new LineBorder(new Color(255, 255, 255), 2, true));
				Jl_CrearBotonCrear.setForeground(Color.GREEN);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				Jl_CrearBotonCrear.setBorder(new LineBorder(new Color(255, 255, 255), 1, true));
				Jl_CrearBotonCrear.setForeground(Color.WHITE);
			}
			@Override
			public void mousePressed(MouseEvent e) {
				Registrar Registrar_Usuario = new Registrar();
  
					if(Jtf_CrearCodigo.getText().equals("") || Jtf_CrearContrasena.getText().equals(""))
					{
						JOptionPane.showMessageDialog(null, "Porfavor rellena los campos");
						
					}
					else{ try {
						if(Jcb_Posicion.getSelectedItem().equals("CAJA")) 
							{	
							String SQL = "INSERT INTO tbl_us_caja (usuario, contrasena) VALUES (?, ?) ";
								Registrar_Usuario.ingresarUsuario(Jtf_CrearCodigo, Jtf_CrearContrasena, SQL);
						}
								if(Jcb_Usuarios.getSelectedItem().equals("ADMINISTRADOR")) 
								{
									String SQL = "INSERT INTO tbl_us_administrador (usuario, contrasena) VALUES (?, ?) ";
									Registrar_Usuario.ingresarUsuario(Jtf_CrearCodigo, Jtf_CrearContrasena, SQL);
								}	
								Jtf_CrearCodigo.setText("");
								Jtf_CrearContrasena.setText("");
								Jl_MensajeBOM_1 = new JLabel("Registro Exitoso");
								Jl_MensajeBOM_1.setVisible(true);
								Jl_MensajeBOM_1.setForeground(new Color(0, 255, 64));
								Jl_MensajeBOM_1.setFont(new Font("Roboto Thin", Font.PLAIN, 18));
								Jl_MensajeBOM_1.setBounds(548, 505, 209, 20);
								panel_CrearUsuario.add(Jl_MensajeBOM_1);
					} 		
					catch(Exception e12){
						JOptionPane.showMessageDialog(null, e12.getMessage());
						JOptionPane.showMessageDialog(null, "Las contrasenas son diferentes");
					}
								
				}  
			}
				

			});
		Jl_CrearBotonCrear.setBounds(367, 328, 107, 38);
		Jl_CrearBotonCrear.setBorder(new LineBorder(new Color(255, 255, 255), 1, true));
		Jl_CrearBotonCrear.setForeground(Color.WHITE);
		Jl_CrearBotonCrear.setFont(new Font("Roboto Light", Font.ITALIC, 24));
		panel_CrearUsuario.add(Jl_CrearBotonCrear);
		
		JLabel Jl_CrearBotonLimpiar = new JLabel("Limpiar");
		Jl_CrearBotonLimpiar.setHorizontalAlignment(SwingConstants.CENTER);
		Jl_CrearBotonLimpiar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				Jl_CrearBotonLimpiar.setBorder(new LineBorder(new Color(255, 255, 255), 2, true));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				Jl_CrearBotonLimpiar.setBorder(new LineBorder(new Color(255, 255, 255), 1, true));
			}
			@Override
			public void mousePressed(MouseEvent e) {
				Jtf_CrearCodigo.setText("");
				Jtf_CrearContrasena.setText("");
			}}
		);
		Jl_CrearBotonLimpiar.setBounds(550, 328, 106, 38);
		Jl_CrearBotonLimpiar.setForeground(Color.WHITE);
		Jl_CrearBotonLimpiar.setFont(new Font("Roboto Light", Font.ITALIC, 24));
		Jl_CrearBotonLimpiar.setBorder(new LineBorder(new Color(255, 255, 255), 1, true));
		panel_CrearUsuario.add(Jl_CrearBotonLimpiar);
		
		JLabel Jl_CrearUsuario_3_1 = new JLabel("Tipo");
		Jl_CrearUsuario_3_1.setBounds(367, 243, 235, 38);
		Jl_CrearUsuario_3_1.setForeground(Color.WHITE);
		Jl_CrearUsuario_3_1.setFont(new Font("Roboto Light", Font.PLAIN, 24));
		panel_CrearUsuario.add(Jl_CrearUsuario_3_1);
		
		Jcb_Usuarios = new JComboBox();
		Jcb_Usuarios.setBounds(367, 283, 263, 29);
		Jcb_Usuarios.setModel(new DefaultComboBoxModel(new String[] {"ADMINISTRADOR", "CAJA"}));
		Jcb_Usuarios.setOpaque(false);
		Jcb_Usuarios.setIgnoreRepaint(true);
		Jcb_Usuarios.setForeground(Color.WHITE);
		Jcb_Usuarios.setFont(new Font("Roboto Light", Font.ITALIC, 16));
		Jcb_Usuarios.setBorder(new LineBorder(new Color(255, 255, 255), 1, true));
		Jcb_Usuarios.setBackground(new Color(37, 69, 81));
		panel_CrearUsuario.add(Jcb_Usuarios);
		Tablas tb = new Tablas();
		Imagenes IconoInicio = new Imagenes();
		
		JPanel panel_CrearEmpleado = new JPanel();
		panel_CrearEmpleado.setBackground(new Color(37, 69, 81));
		Contenedor_Paneles.addTab("panel_CrearEmpleado", null, panel_CrearEmpleado, null);
		panel_CrearEmpleado.setLayout(null);
		
		JLabel Jl_Inicio3 = new JLabel("");
		Jl_Inicio3.setHorizontalAlignment(SwingConstants.CENTER);
		Jl_Inicio3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				Jl_Inicio3.setBorder(new LineBorder(new Color(16, 33, 40), 1, true));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				Jl_Inicio3.setBorder(new LineBorder(new Color(16, 33, 40), 1, true));
			}
			@Override
			public void mousePressed(MouseEvent e) {
				Contenedor_Paneles.setSelectedIndex(0);
			}
		});
		Jl_Inicio3.setLocation(470, 554);
		Jl_Inicio3.setSize(48, 48);
		Jl_Inicio2.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				Contenedor_Paneles.setSelectedIndex(0);
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				Jl_Inicio2.setBorder(new LineBorder(new Color(16, 33, 40), 1, true));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				Jl_Inicio2.setBorder(new LineBorder(new Color(16, 33, 40), 0, true));
			}
		});
		Jl_Inicio2.setBounds(499, 525, 48, 48);
		Imagenes IconoInicio55 = new Imagenes();
		IconoInicio5.Imagenes_Icono(Jl_Inicio3, "C:/Users/abelito/eclipse-workspace/Trabajo_final/src/imagenes/Inicio.png");
		panel_CrearEmpleado.add(Jl_Inicio3);
		
		JLabel Jl_CrearUsuario_1 = new JLabel("Crear Empleado");
		Jl_CrearUsuario_1.setBounds(316, 10, 299, 60);
		Jl_CrearUsuario_1.setForeground(Color.WHITE);
		Jl_CrearUsuario_1.setFont(new Font("Poppins ExtraBold", Font.ITALIC, 34));
		panel_CrearEmpleado.add(Jl_CrearUsuario_1);
		
		JLabel Jl_Nombre = new JLabel("Nombre");
		Jl_Nombre.setBounds(105, 119, 95, 44);
		Jl_Nombre.setForeground(Color.WHITE);
		Jl_Nombre.setFont(new Font("Roboto Light", Font.PLAIN, 24));
		panel_CrearEmpleado.add(Jl_Nombre);
		
		JLabel Jl_Identificacion = new JLabel("Identificacion");
		Jl_Identificacion.setBounds(105, 199, 151, 38);
		Jl_Identificacion.setForeground(Color.WHITE);
		Jl_Identificacion.setFont(new Font("Roboto Light", Font.PLAIN, 24));
		panel_CrearEmpleado.add(Jl_Identificacion);
		
		JLabel Jl_Telefono = new JLabel("Telefono");
		Jl_Telefono.setBounds(105, 278, 235, 38);
		Jl_Telefono.setForeground(Color.WHITE);
		Jl_Telefono.setFont(new Font("Roboto Light", Font.PLAIN, 24));
		panel_CrearEmpleado.add(Jl_Telefono);
		
		Jtf_Nombre = new JFormattedTextField();
		Jtf_Nombre.setBounds(117, 165, 218, 19);
		Jtf_Nombre.setForeground(Color.LIGHT_GRAY);
		Jtf_Nombre.setFont(new Font("Roboto", Font.PLAIN, 20));
		Jtf_Nombre.setColumns(10);
		Jtf_Nombre.setBorder(null);
		Jtf_Nombre.setBackground(new Color(37, 69, 81));
		panel_CrearEmpleado.add(Jtf_Nombre);
		
		JSeparator separator_3 = new JSeparator();
		separator_3.setBounds(105, 189, 289, 4);
		separator_3.setPreferredSize(new Dimension(0, 1));
		separator_3.setForeground(Color.WHITE);
		panel_CrearEmpleado.add(separator_3);
		
		Jtf_Identificacion = new JFormattedTextField(identificacion);
		Jtf_Identificacion.setBounds(117, 244, 218, 19);
		Jtf_Identificacion.setForeground(Color.LIGHT_GRAY);
		Jtf_Identificacion.setFont(new Font("Roboto", Font.PLAIN, 20));
		Jtf_Identificacion.setColumns(10);
		Jtf_Identificacion.setBorder(null);
		Jtf_Identificacion.setBackground(new Color(37, 69, 81));
		panel_CrearEmpleado.add(Jtf_Identificacion);
		
		JSeparator separator_1_1 = new JSeparator();
		separator_1_1.setBounds(105, 268, 289, 4);
		separator_1_1.setPreferredSize(new Dimension(0, 1));
		separator_1_1.setForeground(Color.WHITE);
		panel_CrearEmpleado.add(separator_1_1);
		
		Jtf_Telefono = new JFormattedTextField(telefono);
		Jtf_Telefono.setBounds(115, 318, 218, 19);
		Jtf_Telefono.setForeground(Color.LIGHT_GRAY);
		Jtf_Telefono.setFont(new Font("Roboto", Font.PLAIN, 20));
		Jtf_Telefono.setColumns(10);
		Jtf_Telefono.setBorder(null);
		Jtf_Telefono.setBackground(new Color(37, 69, 81));
		panel_CrearEmpleado.add(Jtf_Telefono);
		
		JSeparator separator_2_1 = new JSeparator();
		separator_2_1.setBounds(105, 342, 289, 4);
		separator_2_1.setPreferredSize(new Dimension(0, 1));
		separator_2_1.setForeground(Color.WHITE);
		panel_CrearEmpleado.add(separator_2_1);
		
		Jl_BotonCrearEmpleado = new JLabel("    Crear");
		Jl_BotonCrearEmpleado.setBounds(548, 457, 107, 38);
		Jl_BotonCrearEmpleado.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				Jl_BotonCrearEmpleado.setBorder(new LineBorder(new Color(255, 255, 255), 2, true));
				Jl_BotonCrearEmpleado.setForeground(Color.GREEN);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				Jl_BotonCrearEmpleado.setBorder(new LineBorder(new Color(255, 255, 255), 1, true));
				Jl_BotonCrearEmpleado.setForeground(Color.WHITE);
			}
			@Override
			public void mousePressed(MouseEvent e) {
				if(Jtf_Nombre.getText().equals("") || Jtf_Identificacion.getText().equals("") || Jtf_Telefono.getText().equals("") || Jtf_Codigo.getText().equals(""))
				{

				JOptionPane.showMessageDialog(null, "Rellena todos los campos, porfavor");

				}	if(Jcb_Posicion.getSelectedItem().equals("VENDEDOR")) {
					String SQL = "INSERT INTO tbl_vendedor (nombre, codigo) VALUES (?, ?)";
					Registrar rv = new Registrar();
					rv.ingresarVendedor(Jtf_Nombre, Jtf_Codigo, SQL);
					
					Jtf_Nombre.setText("");
					Jtf_Identificacion.setText("");
					Jtf_Telefono.setText("");
					Jtf_Codigo.setText("");
					
					String SQL2 = "INSERT INTO tbl_empleados (nombre, identificacion, telefono, codigo_empleado, posicion, sucursal, tanda, sueldo) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
					Registrar r = new Registrar();
					r.ingresarEmpleado(Jtf_Nombre, Jtf_Identificacion, Jtf_Telefono, Jtf_Codigo, Jcb_Posicion, Jcb_Sucursal, Jcb_Tanda, Jcb_Sueldo, SQL2);
					
					Jl_MensajeBOM_1 = new JLabel("Registro Exitoso");
					Jl_MensajeBOM_1.setVisible(true);
					Jl_MensajeBOM_1.setForeground(new Color(0, 255, 64));
					Jl_MensajeBOM_1.setFont(new Font("Roboto Thin", Font.PLAIN, 18));
					Jl_MensajeBOM_1.setBounds(548, 505, 209, 20);
					panel_CrearEmpleado.add(Jl_MensajeBOM_1);
				
				}
				else {
				String SQL = "INSERT INTO tbl_empleados (nombre, identificacion, telefono, codigo_empleado, posicion, sucursal, tanda, sueldo) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
				Registrar r = new Registrar();
				r.ingresarEmpleado(Jtf_Nombre, Jtf_Identificacion, Jtf_Telefono, Jtf_Codigo, Jcb_Posicion, Jcb_Sucursal, Jcb_Tanda, Jcb_Sueldo, SQL);
				
				Jl_MensajeBOM_1 = new JLabel("Registro Exitoso");
				Jl_MensajeBOM_1.setVisible(true);
				Jl_MensajeBOM_1.setForeground(new Color(0, 255, 64));
				Jl_MensajeBOM_1.setFont(new Font("Roboto Thin", Font.PLAIN, 18));
				Jl_MensajeBOM_1.setBounds(548, 505, 209, 20);
				panel_CrearEmpleado.add(Jl_MensajeBOM_1);
				
				Jtf_Nombre.setText("");
				Jtf_Identificacion.setText("");
				Jtf_Telefono.setText("");
				Jtf_Codigo.setText("");
				
				}
				}
		});
		Jl_BotonCrearEmpleado.setForeground(Color.WHITE);
		Jl_BotonCrearEmpleado.setFont(new Font("Roboto Light", Font.ITALIC, 24));
		Jl_BotonCrearEmpleado.setBorder(new LineBorder(new Color(255, 255, 255), 1, true));
		panel_CrearEmpleado.add(Jl_BotonCrearEmpleado);
		
		JLabel Jl_Limpiar = new JLabel("  Limpiar");
		Jl_Limpiar.setBounds(691, 457, 106, 38);
		Jl_Limpiar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				Jl_Limpiar.setBorder(new LineBorder(new Color(255, 255, 255), 2, true));
				Jl_BotonCrearEmpleado.setForeground(Color.GREEN);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				Jl_Limpiar.setBorder(new LineBorder(new Color(255, 255, 255), 1, true));
				Jl_BotonCrearEmpleado.setForeground(Color.WHITE);
				
			}
			@Override
			public void mousePressed(MouseEvent e) {
				Jtf_Nombre.setText("");
				Jtf_Identificacion.setText("");
				Jtf_Telefono.setText("");
				Jtf_Codigo.setText("");
			
			}
		});
		Jl_Limpiar.setForeground(Color.WHITE);
		Jl_Limpiar.setFont(new Font("Roboto Light", Font.ITALIC, 24));
		Jl_Limpiar.setBorder(new LineBorder(new Color(255, 255, 255), 1, true));
		panel_CrearEmpleado.add(Jl_Limpiar);
		
		JLabel Jl_CrearUsuario_3_1_1 = new JLabel("Posicion");
		Jl_CrearUsuario_3_1_1.setBounds(548, 119, 235, 38);
		Jl_CrearUsuario_3_1_1.setForeground(Color.WHITE);
		Jl_CrearUsuario_3_1_1.setFont(new Font("Roboto Light", Font.PLAIN, 24));
		panel_CrearEmpleado.add(Jl_CrearUsuario_3_1_1);
		
		Jcb_Posicion = new JComboBox();
		Jcb_Posicion.setBounds(548, 161, 263, 29);
		Jcb_Posicion.setModel(new DefaultComboBoxModel(new String[] {"ADMINISTRADOR", "GERENTE", "CAJARO", "MESERO", "VENDEDOR"}));
		Jcb_Posicion.setOpaque(false);
		Jcb_Posicion.setIgnoreRepaint(true);
		Jcb_Posicion.setForeground(Color.WHITE);
		Jcb_Posicion.setFont(new Font("Roboto Light", Font.ITALIC, 16));
		Jcb_Posicion.setBorder(new LineBorder(new Color(255, 255, 255), 1, true));
		Jcb_Posicion.setBackground(new Color(37, 69, 81));
		panel_CrearEmpleado.add(Jcb_Posicion);
		
		JLabel Jl_Codigo_1_1 = new JLabel("Codigo ");
		Jl_Codigo_1_1.setBounds(105, 373, 85, 44);
		Jl_Codigo_1_1.setForeground(Color.WHITE);
		Jl_Codigo_1_1.setFont(new Font("Roboto Light", Font.PLAIN, 24));
		panel_CrearEmpleado.add(Jl_Codigo_1_1);
		
		Jtf_Codigo = new JFormattedTextField(codigo);
		Jtf_Codigo.setBounds(117, 419, 218, 19);
		Jtf_Codigo.setForeground(Color.LIGHT_GRAY);
		Jtf_Codigo.setFont(new Font("Roboto", Font.PLAIN, 20));
		Jtf_Codigo.setColumns(10);
		Jtf_Codigo.setBorder(null);
		Jtf_Codigo.setBackground(new Color(37, 69, 81));
		panel_CrearEmpleado.add(Jtf_Codigo);
		
		JSeparator separator_3_1 = new JSeparator();
		separator_3_1.setBounds(105, 443, 289, 4);
		separator_3_1.setPreferredSize(new Dimension(0, 1));
		separator_3_1.setForeground(Color.WHITE);
		panel_CrearEmpleado.add(separator_3_1);
		
		JLabel Jl_Tanda = new JLabel("Tanda");
		Jl_Tanda.setBounds(548, 203, 235, 38);
		Jl_Tanda.setForeground(Color.WHITE);
		Jl_Tanda.setFont(new Font("Roboto Light", Font.PLAIN, 24));
		panel_CrearEmpleado.add(Jl_Tanda);
		
		Jcb_Tanda = new JComboBox();
		Jcb_Tanda.setBounds(548, 245, 263, 29);
		Jcb_Tanda.setModel(new DefaultComboBoxModel(new String[] {"Manana", "Tarde"}));
		Jcb_Tanda.setOpaque(false);
		Jcb_Tanda.setIgnoreRepaint(true);
		Jcb_Tanda.setForeground(Color.WHITE);
		Jcb_Tanda.setFont(new Font("Roboto Light", Font.ITALIC, 16));
		Jcb_Tanda.setBorder(new LineBorder(new Color(255, 255, 255), 1, true));
		Jcb_Tanda.setBackground(new Color(37, 69, 81));
		panel_CrearEmpleado.add(Jcb_Tanda);
		
		JLabel Jl_Sucursal = new JLabel("Sucursal");
		Jl_Sucursal.setBounds(548, 284, 235, 38);
		Jl_Sucursal.setForeground(Color.WHITE);
		Jl_Sucursal.setFont(new Font("Roboto Light", Font.PLAIN, 24));
		panel_CrearEmpleado.add(Jl_Sucursal);
		
		Jcb_Sucursal = new JComboBox();
		Jcb_Sucursal.setBounds(548, 326, 263, 29);
		Jcb_Sucursal.setModel(new DefaultComboBoxModel(new String[] {"Av. Venezuela", "Av. Luperon", "Av. Charles"}));
		Jcb_Sucursal.setOpaque(false);
		Jcb_Sucursal.setIgnoreRepaint(true);
		Jcb_Sucursal.setForeground(Color.WHITE);
		Jcb_Sucursal.setFont(new Font("Roboto Light", Font.ITALIC, 16));
		Jcb_Sucursal.setBorder(new LineBorder(new Color(255, 255, 255), 1, true));
		Jcb_Sucursal.setBackground(new Color(37, 69, 81));
		panel_CrearEmpleado.add(Jcb_Sucursal);
		
		JLabel Jl_Sueldo = new JLabel("Prestaciones");
		Jl_Sueldo.setForeground(Color.WHITE);
		Jl_Sueldo.setFont(new Font("Roboto Light", Font.PLAIN, 24));
		Jl_Sueldo.setBounds(548, 365, 235, 38);
		panel_CrearEmpleado.add(Jl_Sueldo);
		
		Jcb_Sueldo = new JComboBox();
		Jcb_Sueldo.setModel(new DefaultComboBoxModel(new String[] {"18000", "22000", "25000", "35000", "50000", "120000"}));
		Jcb_Sueldo.setOpaque(false);
		Jcb_Sueldo.setIgnoreRepaint(true);
		Jcb_Sueldo.setForeground(Color.WHITE);
		Jcb_Sueldo.setFont(new Font("Roboto Light", Font.ITALIC, 16));
		Jcb_Sueldo.setBorder(new LineBorder(new Color(255, 255, 255), 1, true));
		Jcb_Sueldo.setBackground(new Color(37, 69, 81));
		Jcb_Sueldo.setBounds(548, 407, 263, 29);
		panel_CrearEmpleado.add(Jcb_Sueldo);
		

		
		
		
		Imagenes IconoInicio1 = new Imagenes();
		
				
				JPanel panel_Productos = new JPanel();
				panel_Productos.setLayout(null);
				panel_Productos.setBackground(new Color(37, 69, 81));
				Contenedor_Paneles.addTab("panel_CrearProductos", null, panel_Productos, null);
				
				JLabel Jl_CrearUsuario_1_1 = new JLabel("Nuevo Producto");
				Jl_CrearUsuario_1_1.setForeground(Color.WHITE);
				Jl_CrearUsuario_1_1.setFont(new Font("Poppins ExtraBold", Font.ITALIC, 30));
				Jl_CrearUsuario_1_1.setBounds(7, 10, 338, 60);
				panel_Productos.add(Jl_CrearUsuario_1_1);
				
				JLabel Jl_NombreNProducto = new JLabel("Nombre");
				Jl_NombreNProducto.setForeground(Color.WHITE);
				Jl_NombreNProducto.setFont(new Font("Roboto Light", Font.PLAIN, 24));
				Jl_NombreNProducto.setBounds(17, 59, 95, 44);
				panel_Productos.add(Jl_NombreNProducto);
				
				Jtf_NombreNuevoProducto = new JTextField();
				Jtf_NombreNuevoProducto.setForeground(Color.LIGHT_GRAY);
				Jtf_NombreNuevoProducto.setFont(new Font("Roboto", Font.PLAIN, 20));
				Jtf_NombreNuevoProducto.setColumns(10);
				Jtf_NombreNuevoProducto.setBorder(null);
				Jtf_NombreNuevoProducto.setBackground(new Color(37, 69, 81));
				Jtf_NombreNuevoProducto.setBounds(122, 73, 133, 19);
				panel_Productos.add(Jtf_NombreNuevoProducto);
				
				JSeparator separator_3_2_1 = new JSeparator();
				separator_3_2_1.setPreferredSize(new Dimension(0, 1));
				separator_3_2_1.setForeground(Color.WHITE);
				separator_3_2_1.setBounds(122, 93, 133, 4);
				panel_Productos.add(separator_3_2_1);
				
				JLabel Jl_PrecioNProducto = new JLabel("Precio");
				Jl_PrecioNProducto.setForeground(Color.WHITE);
				Jl_PrecioNProducto.setFont(new Font("Roboto Light", Font.PLAIN, 24));
				Jl_PrecioNProducto.setBounds(17, 116, 95, 44);
				panel_Productos.add(Jl_PrecioNProducto);
				
				Jtf_PrecioNuevoProducto = new JFormattedTextField(precio);
				Jtf_PrecioNuevoProducto.setForeground(Color.LIGHT_GRAY);
				Jtf_PrecioNuevoProducto.setFont(new Font("Roboto", Font.PLAIN, 20));
				Jtf_PrecioNuevoProducto.setColumns(10);
				Jtf_PrecioNuevoProducto.setBorder(null);
				Jtf_PrecioNuevoProducto.setBackground(new Color(37, 69, 81));
				Jtf_PrecioNuevoProducto.setBounds(122, 130, 133, 19);
				panel_Productos.add(Jtf_PrecioNuevoProducto);
				
				JSeparator separator_3_2_2 = new JSeparator();
				separator_3_2_2.setPreferredSize(new Dimension(0, 1));
				separator_3_2_2.setForeground(Color.WHITE);
				separator_3_2_2.setBounds(122, 150, 133, 4);
				panel_Productos.add(separator_3_2_2);
				
				JLabel Jl_CantidadNProducto = new JLabel("Cantidad");
				Jl_CantidadNProducto.setForeground(Color.WHITE);
				Jl_CantidadNProducto.setFont(new Font("Roboto Light", Font.PLAIN, 24));
				Jl_CantidadNProducto.setBounds(17, 170, 95, 44);
				panel_Productos.add(Jl_CantidadNProducto);
				
				JLabel Jl_BotonCrearNProducto = new JLabel("Crear");
				Jl_BotonCrearNProducto.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseEntered(MouseEvent e) {
						Jl_BotonCrearNProducto.setBorder(new LineBorder(new Color(255, 255, 255), 2, true));
						Jl_BotonCrearNProducto.setForeground(Color.GREEN);
					}
					@Override
					public void mouseExited(MouseEvent e) {
						Jl_BotonCrearNProducto.setBorder(new LineBorder(new Color(255, 255, 255), 1, true));
						Jl_BotonCrearNProducto.setForeground(Color.WHITE);
					}
					@Override
					public void mousePressed(MouseEvent e) {	
					Registrar Registrar_Producto = new Registrar();
						if(Jtf_NombreNuevoProducto.getText().equals("") || Jtf_PrecioNuevoProducto.getText().equals("") || Jtf_CantidadNuevoProducto.getText().equals("")) 
						{
							JOptionPane.showMessageDialog(null, "Porfavor rellena todos los campos");
						}
						else 
						{
						try {	
								String sql = "INSERT INTO tbl_productos (nombre, precio, existencia) VALUES (?, ?, ?) "  ;                   
								Registrar_Producto.IngresarProductos(Jtf_NombreNuevoProducto, Jtf_PrecioNuevoProducto, Jtf_CantidadNuevoProducto, sql);
								Tablas tb1 = new Tablas();
								tb1.MostrarProductos(Tbl_Productos);
								Jtf_PrecioNuevoProducto.setText("");
								Jtf_NombreNuevoProducto.setText("");
								Jtf_CantidadNuevoProducto.setText("");
						}	
							
						catch(Exception e12){
							JOptionPane.showMessageDialog(null, e12.getMessage());
						}
						}
						
					}
				});
				Jl_BotonCrearNProducto.setHorizontalAlignment(SwingConstants.CENTER);
				Jl_BotonCrearNProducto.setForeground(Color.WHITE);
				Jl_BotonCrearNProducto.setFont(new Font("Roboto Light", Font.ITALIC, 24));
				Jl_BotonCrearNProducto.setBorder(new LineBorder(new Color(255, 255, 255), 1, true));
				Jl_BotonCrearNProducto.setBounds(17, 235, 95, 38);
				panel_Productos.add(Jl_BotonCrearNProducto);
				
				JLabel Jl_BotonLimpiarNProducto = new JLabel("Limpiar");
				Jl_BotonLimpiarNProducto.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseEntered(MouseEvent e) {
						Jl_BotonLimpiarNProducto.setBorder(new LineBorder(new Color(255, 255, 255), 2, true));
					}
					@Override
					public void mouseExited(MouseEvent e) {
						Jl_BotonLimpiarNProducto.setBorder(new LineBorder(new Color(255, 255, 255), 1, true));
					}
					@Override
					public void mousePressed(MouseEvent e) {
						Jtf_PrecioNuevoProducto.setText("");
						Jtf_NombreNuevoProducto.setText("");
						Jtf_CantidadNuevoProducto.setText("");
					}
				});
				Jl_BotonLimpiarNProducto.setHorizontalAlignment(SwingConstants.CENTER);
				Jl_BotonLimpiarNProducto.setForeground(Color.WHITE);
				Jl_BotonLimpiarNProducto.setFont(new Font("Roboto Light", Font.ITALIC, 24));
				Jl_BotonLimpiarNProducto.setBorder(new LineBorder(new Color(255, 255, 255), 1, true));
				Jl_BotonLimpiarNProducto.setBounds(148, 235, 107, 38);
				panel_Productos.add(Jl_BotonLimpiarNProducto);
				
				JScrollPane scrollPane = new JScrollPane();
				scrollPane.setBounds(604, 31, 411, 415);
				panel_Productos.add(scrollPane);
				
		Tbl_Productos = new JTable();
		Tbl_Productos.setColumnSelectionAllowed(true);
		Tbl_Productos.setCellSelectionEnabled(true);
		tb.MostrarProductos(Tbl_Productos);
		
		
		scrollPane.setViewportView(Tbl_Productos);
		
		JLabel Jl_Inicio = new JLabel("");
		Jl_Inicio.setHorizontalAlignment(SwingConstants.CENTER);
		Jl_Inicio.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				Contenedor_Paneles.setSelectedIndex(0);
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				Jl_Inicio.setBorder(new LineBorder(new Color(16, 33, 40), 1, true));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				Jl_Inicio.setBorder(new LineBorder(new Color(16, 33, 40), 0, true));
			}
		});
		Jl_Inicio.setBounds(496, 554, 48, 48);
		IconoInicio.Imagenes_Icono(Jl_Inicio, "C:/Users/abelito/eclipse-workspace/Trabajo_final/src/imagenes/Inicio.png");
		panel_Productos.add(Jl_Inicio);
		
		JLabel Jl_EditarProducto = new JLabel("Editar Producto");
		Jl_EditarProducto.setForeground(Color.WHITE);
		Jl_EditarProducto.setFont(new Font("Poppins ExtraBold", Font.ITALIC, 30));
		Jl_EditarProducto.setBounds(7, 283, 338, 60);
		panel_Productos.add(Jl_EditarProducto);
		
		JLabel Jl_NombreProducto_1 = new JLabel("Nombre");
		Jl_NombreProducto_1.setForeground(Color.WHITE);
		Jl_NombreProducto_1.setFont(new Font("Roboto Light", Font.PLAIN, 24));
		Jl_NombreProducto_1.setBounds(17, 336, 95, 44);
		panel_Productos.add(Jl_NombreProducto_1);
		
		Jtf_NombreEditarProducto = new JTextField();
		Jtf_NombreEditarProducto.setForeground(Color.LIGHT_GRAY);
		Jtf_NombreEditarProducto.setFont(new Font("Roboto", Font.PLAIN, 20));
		Jtf_NombreEditarProducto.setColumns(10);
		Jtf_NombreEditarProducto.setBorder(null);
		Jtf_NombreEditarProducto.setBackground(new Color(37, 69, 81));
		Jtf_NombreEditarProducto.setBounds(122, 350, 133, 19);
		panel_Productos.add(Jtf_NombreEditarProducto);
		
		JSeparator separator_3_2_1_1 = new JSeparator();
		separator_3_2_1_1.setPreferredSize(new Dimension(0, 1));
		separator_3_2_1_1.setForeground(Color.WHITE);
		separator_3_2_1_1.setBounds(122, 370, 133, 4);
		panel_Productos.add(separator_3_2_1_1);
		
		JLabel Jl_Precio_1 = new JLabel("Precio");
		Jl_Precio_1.setForeground(Color.WHITE);
		Jl_Precio_1.setFont(new Font("Roboto Light", Font.PLAIN, 24));
		Jl_Precio_1.setBounds(17, 393, 95, 44);
		panel_Productos.add(Jl_Precio_1);
		
		Jtf_PrecioEditarProducto = new JFormattedTextField(precio);
		Jtf_PrecioEditarProducto.setForeground(Color.LIGHT_GRAY);
		Jtf_PrecioEditarProducto.setFont(new Font("Roboto", Font.PLAIN, 20));
		Jtf_PrecioEditarProducto.setColumns(10);
		Jtf_PrecioEditarProducto.setBorder(null);
		Jtf_PrecioEditarProducto.setBackground(new Color(37, 69, 81));
		Jtf_PrecioEditarProducto.setBounds(122, 407, 133, 19);
		panel_Productos.add(Jtf_PrecioEditarProducto);
		
		JSeparator separator_3_2_2_1 = new JSeparator();
		separator_3_2_2_1.setPreferredSize(new Dimension(0, 1));
		separator_3_2_2_1.setForeground(Color.WHITE);
		separator_3_2_2_1.setBounds(122, 427, 133, 4);
		panel_Productos.add(separator_3_2_2_1);
		
		JLabel Jl_Cantidad_1 = new JLabel("Cantidad");
		Jl_Cantidad_1.setForeground(Color.WHITE);
		Jl_Cantidad_1.setFont(new Font("Roboto Light", Font.PLAIN, 24));
		Jl_Cantidad_1.setBounds(17, 447, 95, 44);
		panel_Productos.add(Jl_Cantidad_1);
		
		JLabel Jl_BotonEditarrProducto = new JLabel("Editar");
		Jl_BotonEditarrProducto.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				Jl_BotonEditarrProducto.setBorder(new LineBorder(new Color(255, 255, 255), 2, true));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				Jl_BotonEditarrProducto.setBorder(new LineBorder(new Color(255, 255, 255), 1, true));
			}
			@Override
			public void mousePressed(MouseEvent e) {

				Conectar_Bd bd = new Conectar_Bd();
				Connection con=bd.conectar();
				
				if(Jtf_CantidadEditarProducto.getText().equals("") || Jtf_PrecioEditarProducto.getText().equals("") || Jtf_CantidadEditarProducto.getText().equals(""))
				{
					JOptionPane.showMessageDialog(null, "Porfavor llena los campos");
					
					
				} else {
					PreparedStatement ps = null;
					
					try {	
						int Fila = Tbl_Productos.getSelectedRow();
						String codigo = Tbl_Productos.getValueAt(Fila, 0).toString();
						
						ps = con.prepareStatement("UPDATE tbl_productos SET nombre =?, precio =?, existencia=? WHERE codigo = '"+codigo+"'" );
						//ps.setString(1, codigo);
						ps.setString(1, Jtf_NombreEditarProducto.getText());
						ps.setString(2, Jtf_PrecioEditarProducto.getText());
						ps.setString(3, Jtf_CantidadEditarProducto.getText());
						
						Jtf_NombreEditarProducto.setText("");
						Jtf_PrecioEditarProducto.setText("");
						Jtf_CantidadEditarProducto.setText("");
						
						ps.execute();
						
						
						
						Tbl_Productos.removeRowSelectionInterval(Fila, Fila);
						JOptionPane.showMessageDialog(null, "Registro Editado");
						
						Tablas tb1 = new Tablas();
						tb1.MostrarProductos(Tbl_Productos);
						
					} catch(SQLException ex) {
						JOptionPane.showMessageDialog(null, ex.getMessage());
					}
				}
					
				}
				
				
				
				
				
				
				
			}
		);
		Jl_BotonEditarrProducto.setHorizontalAlignment(SwingConstants.CENTER);
		Jl_BotonEditarrProducto.setForeground(Color.WHITE);
		Jl_BotonEditarrProducto.setFont(new Font("Roboto Light", Font.ITALIC, 24));
		Jl_BotonEditarrProducto.setBorder(new LineBorder(new Color(255, 255, 255), 1, true));
		Jl_BotonEditarrProducto.setBounds(17, 499, 107, 38);
		panel_Productos.add(Jl_BotonEditarrProducto);
		
		JLabel Jl_BotonLimpiarActualizar = new JLabel("Cancelar");
		Jl_BotonLimpiarActualizar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				Jl_BotonLimpiarActualizar.setBorder(new LineBorder(new Color(255, 255, 255), 2, true));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				Jl_BotonLimpiarActualizar.setBorder(new LineBorder(new Color(255, 255, 255), 1, true));
			}
			@Override
			public void mousePressed(MouseEvent e) {
				Jtf_NombreEditarProducto.setText("");
				Jtf_PrecioEditarProducto.setText("");
				Jtf_CantidadEditarProducto.setText("");
				
			}
		});
		Jl_BotonLimpiarActualizar.setHorizontalAlignment(SwingConstants.CENTER);
		Jl_BotonLimpiarActualizar.setForeground(Color.WHITE);
		Jl_BotonLimpiarActualizar.setFont(new Font("Roboto Light", Font.ITALIC, 24));
		Jl_BotonLimpiarActualizar.setBorder(new LineBorder(new Color(255, 255, 255), 1, true));
		Jl_BotonLimpiarActualizar.setBounds(148, 499, 107, 38);
		panel_Productos.add(Jl_BotonLimpiarActualizar);
		
		Jtf_CantidadNuevoProducto = new JFormattedTextField(cantidad);
		Jtf_CantidadNuevoProducto.setForeground(Color.LIGHT_GRAY);
		Jtf_CantidadNuevoProducto.setFont(new Font("Roboto", Font.PLAIN, 20));
		Jtf_CantidadNuevoProducto.setColumns(10);
		Jtf_CantidadNuevoProducto.setBorder(null);
		Jtf_CantidadNuevoProducto.setBackground(new Color(37, 69, 81));
		Jtf_CantidadNuevoProducto.setBounds(122, 180, 133, 19);
		panel_Productos.add(Jtf_CantidadNuevoProducto);
		
		JSeparator separator_3_2_2_2 = new JSeparator();
		separator_3_2_2_2.setPreferredSize(new Dimension(0, 1));
		separator_3_2_2_2.setForeground(Color.WHITE);
		separator_3_2_2_2.setBounds(122, 200, 133, 4);
		panel_Productos.add(separator_3_2_2_2);
		
		Jtf_CantidadEditarProducto = new JFormattedTextField(cantidad);
		Jtf_CantidadEditarProducto.setForeground(Color.LIGHT_GRAY);
		Jtf_CantidadEditarProducto.setFont(new Font("Roboto", Font.PLAIN, 20));
		Jtf_CantidadEditarProducto.setColumns(10);
		Jtf_CantidadEditarProducto.setBorder(null);
		Jtf_CantidadEditarProducto.setBackground(new Color(37, 69, 81));
		Jtf_CantidadEditarProducto.setBounds(122, 459, 133, 19);
		panel_Productos.add(Jtf_CantidadEditarProducto);
		
		JSeparator separator_3_2_2_1_1 = new JSeparator();
		separator_3_2_2_1_1.setPreferredSize(new Dimension(0, 1));
		separator_3_2_2_1_1.setForeground(Color.WHITE);
		separator_3_2_2_1_1.setBounds(122, 479, 133, 4);
		panel_Productos.add(separator_3_2_2_1_1);
		
		JLabel Jl_BotonModificarTabla = new JLabel("Modificar");
		Jl_BotonModificarTabla.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				Jl_BotonModificarTabla.setBorder(new LineBorder(new Color(255, 255, 255), 2, true));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				Jl_BotonModificarTabla.setBorder(new LineBorder(new Color(255, 255, 255), 1, true));
			}
			@Override
			public void mousePressed(MouseEvent e) {
				if(Tbl_Productos.getSelectedRow()<0) 
				{		
					JOptionPane.showMessageDialog(null, "Porfavor selecciona un Evento");
				} else {
					PreparedStatement ps = null;
					ResultSet rs = null;
					
				try {
					Conectar_Bd bd = new Conectar_Bd();
					Connection con=bd.conectar();
					
					int Fila = Tbl_Productos.getSelectedRow();
					String codigo = Tbl_Productos.getValueAt(Fila, 0).toString();
					
					ps = con.prepareStatement("SELECT nombre, precio, existencia FROM tbl_productos WHERE codigo =?");
					ps.setString(1, codigo);
					rs = ps.executeQuery();
					
					while(rs.next()) {
						
						Jtf_NombreEditarProducto.setText(rs.getString("nombre"));
						Jtf_PrecioEditarProducto.setText(rs.getString("precio"));
						Jtf_CantidadEditarProducto.setText(rs.getString("existencia"));
					}
					
					
				} catch(SQLException ex) {
					JOptionPane.showMessageDialog(null, ex.getMessage());
				}
				}
				
				
				
				
				
			}
		});
		Jl_BotonModificarTabla.setHorizontalAlignment(SwingConstants.CENTER);
		Jl_BotonModificarTabla.setForeground(Color.WHITE);
		Jl_BotonModificarTabla.setFont(new Font("Roboto Light", Font.ITALIC, 24));
		Jl_BotonModificarTabla.setBorder(new LineBorder(new Color(255, 255, 255), 1, true));
		Jl_BotonModificarTabla.setBounds(668, 456, 133, 38);
		panel_Productos.add(Jl_BotonModificarTabla);
		
		JLabel Jl_BotonBorrarTabla = new JLabel("Borrar");
		Jl_BotonBorrarTabla.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				if(Tbl_Productos.getSelectedRow()<0) 
				{		
					JOptionPane.showMessageDialog(null, "Porfavor selecciona un Evento");
				} else {
					PreparedStatement ps = null;
				
				try {
					Conectar_Bd bd = new Conectar_Bd();
					Connection con=bd.conectar();
					
					int Fila = Tbl_Productos.getSelectedRow();
					String codigo = Tbl_Productos.getValueAt(Fila, 0).toString();
					
					ps = con.prepareStatement("DELETE FROM tbl_productos WHERE codigo =?");
					ps.setString(1, codigo);
					ps.execute();
					
					Tbl_Productos.removeRowSelectionInterval(Fila, Fila);
					JOptionPane.showMessageDialog(null, "Registro eliminado");
					
					Tablas tb1 = new Tablas();
					tb1.MostrarProductos(Tbl_Productos);
					
				} catch(SQLException ex) {
					JOptionPane.showMessageDialog(null, ex.getMessage());
				}
				}
				
				
				
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				Jl_BotonBorrarTabla.setBorder(new LineBorder(new Color(255, 255, 255), 2, true));
				Jl_BotonBorrarTabla.setForeground(Color.RED);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				Jl_BotonBorrarTabla.setBorder(new LineBorder(new Color(255, 255, 255), 1, true));
				Jl_BotonBorrarTabla.setForeground(Color.WHITE);
			}
		});
		Jl_BotonBorrarTabla.setHorizontalAlignment(SwingConstants.CENTER);
		Jl_BotonBorrarTabla.setForeground(Color.WHITE);
		Jl_BotonBorrarTabla.setFont(new Font("Roboto Light", Font.ITALIC, 24));
		Jl_BotonBorrarTabla.setBorder(new LineBorder(new Color(255, 255, 255), 1, true));
		Jl_BotonBorrarTabla.setBounds(835, 456, 133, 38);
		panel_Productos.add(Jl_BotonBorrarTabla);
		
			
			
			
			JPanel panel_Informacion = new JPanel();
			panel_Informacion.setLayout(null);
			panel_Informacion.setBackground(new Color(37, 69, 81));
			Contenedor_Paneles.addTab("panel_Informacion", null, panel_Informacion, null);
			
			JLabel Jl_Inicio33 = new JLabel("");
			Jl_Inicio33.setHorizontalAlignment(SwingConstants.CENTER);
			Jl_Inicio33.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseEntered(MouseEvent e) {
					Jl_Inicio33.setBorder(new LineBorder(new Color(16, 33, 40), 1, true));
				}
				@Override
				public void mouseExited(MouseEvent e) {
					Jl_Inicio33.setBorder(new LineBorder(new Color(16, 33, 40), 0, true));
					
				}
				@Override
				public void mousePressed(MouseEvent e) {
					Contenedor_Paneles.setSelectedIndex(0);
				}
			});
			Jl_Inicio33.setLocation(509, 558);
			Jl_Inicio33.setSize(48, 48);
			Jl_Inicio2.addMouseListener(new MouseAdapter() {
				@Override
				public void mousePressed(MouseEvent e) {
					Contenedor_Paneles.setSelectedIndex(0);
				}
				@Override
				public void mouseEntered(MouseEvent e) {
					Jl_Inicio33.setBorder(new LineBorder(new Color(16, 33, 40), 1, true));
				}
				@Override
				public void mouseExited(MouseEvent e) {
					Jl_Inicio33.setBorder(new LineBorder(new Color(16, 33, 40), 0, true));
				}
			});
			Jl_Inicio2.setBounds(499, 525, 48, 48);
			Imagenes IconoInicio555 = new Imagenes();
			IconoInicio555.Imagenes_Icono(Jl_Inicio33, "C:/Users/abelito/eclipse-workspace/Trabajo_final/src/imagenes/Inicio.png");
			panel_Informacion.add(Jl_Inicio33);
			
			JLabel Jl_Informacion_Title = new JLabel("Informacion");
			Jl_Informacion_Title.setForeground(Color.WHITE);
			Jl_Informacion_Title.setFont(new Font("Poppins ExtraBold", Font.ITALIC, 34));
			Jl_Informacion_Title.setBounds(398, 10, 338, 60);
			panel_Informacion.add(Jl_Informacion_Title);
			
			
			JLabel Jl_InformacionBotonActualizar = new JLabel("Actualizar");
			Jl_InformacionBotonActualizar.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseEntered(MouseEvent e) {
					Jl_InformacionBotonActualizar.setBorder(new LineBorder(new Color(255, 255, 255), 2, true));
					Jl_InformacionBotonActualizar.setForeground(Color.GREEN);
				}
				@Override
				public void mouseExited(MouseEvent e) {
					Jl_InformacionBotonActualizar.setBorder(new LineBorder(new Color(255, 255, 255), 1, true));
					Jl_InformacionBotonActualizar.setForeground(Color.WHITE);
				}
				@Override
				public void mousePressed(MouseEvent e) {
					Tablas tb1 = new Tablas();
					if(Jcb_Inforamcion.getSelectedItem().equals("Productos")) {
						tb1.MostrarProductos(Tbl_Informacion);			
					}
					if(Jcb_Inforamcion.getSelectedItem().equals("Empleados")) {
						tb1.MostrarEmpleados(Tbl_Informacion);			
					}
					if(Jcb_Inforamcion.getSelectedItem().equals("Usuarios")) {
						tb1.MostrarUsuarios(Tbl_Informacion);
					}
					if(Jcb_Inforamcion.getSelectedItem().equals("Facturas")) {
						tb1.MostrarProductos(Tbl_Informacion);			
					}
					
					
				}
			});
			Jl_InformacionBotonActualizar.setHorizontalAlignment(SwingConstants.CENTER);
			Jl_InformacionBotonActualizar.setForeground(Color.WHITE);
			Jl_InformacionBotonActualizar.setFont(new Font("Roboto Light", Font.ITALIC, 24));
			Jl_InformacionBotonActualizar.setBorder(new LineBorder(new Color(255, 255, 255), 1, true));
			Jl_InformacionBotonActualizar.setBounds(125, 510, 132, 38);
			panel_Informacion.add(Jl_InformacionBotonActualizar);
			
			JScrollPane scrollPane_1 = new JScrollPane();
			scrollPane_1.setBounds(115, 85, 874, 415);
			panel_Informacion.add(scrollPane_1);
			
			Tbl_Informacion = new JTable();
			scrollPane_1.setViewportView(Tbl_Informacion);
			
			Jcb_Inforamcion = new JComboBox();
			Jcb_Inforamcion.setModel(new DefaultComboBoxModel(new String[] {"Empleados", "Usuarios", "Productos", "Facturas"}));
			Jcb_Inforamcion.setOpaque(false);
			Jcb_Inforamcion.setIgnoreRepaint(true);
			Jcb_Inforamcion.setForeground(Color.WHITE);
			Jcb_Inforamcion.setFont(new Font("Roboto Light", Font.ITALIC, 22));
			Jcb_Inforamcion.setBorder(new LineBorder(new Color(255, 255, 255), 1, true));
			Jcb_Inforamcion.setBackground(new Color(37, 69, 81));
			Jcb_Inforamcion.setBounds(726, 510, 263, 38);
			panel_Informacion.add(Jcb_Inforamcion);
		Jl_Inicio.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				Contenedor_Paneles.setSelectedIndex(0);
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				Jl_BotonLimpiarNProducto.setBorder(new LineBorder(new Color(16, 33, 40), 1, true));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				Jl_BotonLimpiarNProducto.setBorder(new LineBorder(new Color(255, 255, 255), 0, true));
			}
		});

		
}
	public void Cerrar_Secion(JPanel pn){
		
			pn.setSize(1094, 713);
		pn.setLocation(0, 0);
			panel_administrador.removeAll();
			panel_administrador.add(pn, BorderLayout.CENTER);
			panel_administrador.revalidate();
			panel_administrador.repaint();
		}
		
	}
	
