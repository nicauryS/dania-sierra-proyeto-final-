package vistas;

import javax.swing.JPanel;

import clases.Imagenes;
import clases.Registrar;
import conector.Conectar_Bd;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JSpinner;
import javax.swing.border.LineBorder;
import javax.swing.text.MaskFormatter;
import javax.swing.JFormattedTextField;
import javax.swing.JSeparator;
import java.awt.Dimension;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.DefaultComboBoxModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.JFormattedTextField$AbstractFormatter;
import javax.swing.JTextField;

public class panel_caja extends JPanel {
	private JTable Tbl_Factura;
	Conectar_Bd bd = new Conectar_Bd();
	Connection con=bd.conectar();
	PreparedStatement ps = null;
	ResultSet rs = null;	
	MaskFormatter precio;
	MaskFormatter nombre;
	int precio_;
	int subtotal;
	String subtotal_txt;
	int total;
	JFormattedTextField Jff_Vendedor;
	JFormattedTextField Jff_Producto;
	JFormattedTextField Jff_Precio;
	JTextField Jff_SubTotal;
	JLabel Jl_SubTotal1;
	
	/**
	 * Create the panel.
	 */
	public panel_caja() {
		setLayout(null);
		
		try
		{
			precio = new MaskFormatter("####");
			nombre = new MaskFormatter("****************************************");
		} catch(Exception ex) 
		{
			JOptionPane.showConfirmDialog(null, "Error de mascara");
		}
		
		JPanel panel_caja = new JPanel();
		panel_caja.setBackground(new Color(37, 69, 81));
		panel_caja.setForeground(new Color(192, 192, 192));
		panel_caja.setBounds(10, 10, 1094, 713);
		add(panel_caja);
		Imagenes img = new Imagenes();
		panel_caja.setLayout(null);
		
		JLabel Jtf_Producto = new JLabel("Producto");
		Jtf_Producto.setBounds(28, 104, 98, 35);
		Jtf_Producto.setForeground(new Color(255, 255, 255));
		Jtf_Producto.setFont(new Font("Roboto", Font.BOLD, 22));
		panel_caja.add(Jtf_Producto);
		
		JLabel Jtf_Cantidad = new JLabel("Cantidad");
		Jtf_Cantidad.setBounds(28, 147, 98, 35);
		Jtf_Cantidad.setForeground(Color.WHITE);
		Jtf_Cantidad.setFont(new Font("Roboto", Font.BOLD, 22));
		panel_caja.add(Jtf_Cantidad);
		
		JLabel Jl_Precio = new JLabel("Precio");
		Jl_Precio.setBounds(28, 186, 82, 35);
		Jl_Precio.setForeground(Color.WHITE);
		Jl_Precio.setFont(new Font("Roboto", Font.BOLD, 22));
		panel_caja.add(Jl_Precio);
		
		Registrar ComboBoxProducto = new Registrar();
		
		JFormattedTextField Jff_Cantidad = new JFormattedTextField(precio);
		Jff_Cantidad.setBounds(137, 147, 159, 22);
		Jff_Cantidad.setBorder(null);
		Jff_Cantidad.setBackground(new Color(37, 69, 81));
		Jff_Cantidad.setForeground(new Color(255, 255, 255));
		Jff_Cantidad.setFont(new Font("Roboto", Font.PLAIN, 16));
		panel_caja.add(Jff_Cantidad);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(136, 170, 164, 2);
		separator.setPreferredSize(new Dimension(0, 1));
		separator.setForeground(new Color(255, 255, 255));
		panel_caja.add(separator);
		
		JLabel Jl_Vendedor = new JLabel("Vendedor");
		Jl_Vendedor.setBounds(376, 104, 98, 35);
		Jl_Vendedor.setForeground(Color.WHITE);
		Jl_Vendedor.setFont(new Font("Roboto", Font.BOLD, 22));
		panel_caja.add(Jl_Vendedor);
			Registrar Jvendedor = new Registrar();
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(28, 270, 789, 379);
		panel_caja.add(scrollPane);
		
		Tbl_Factura = new JTable();
		scrollPane.setViewportView(Tbl_Factura);
		
		JLabel Jtf_Pago = new JLabel("Pago");
		Jtf_Pago.setForeground(Color.WHITE);
		Jtf_Pago.setFont(new Font("Roboto", Font.BOLD, 22));
		Jtf_Pago.setBounds(837, 270, 72, 35);
		panel_caja.add(Jtf_Pago);
		
		JComboBox Jcb_Pago = new JComboBox();
		Jcb_Pago.setModel(new DefaultComboBoxModel(new String[] {"Efectivo\t", "Tarjeta"}));
		Jcb_Pago.setForeground(Color.WHITE);
		Jcb_Pago.setFont(new Font("Roboto", Font.PLAIN, 18));
		Jcb_Pago.setBackground(new Color(37, 69, 81));
		Jcb_Pago.setBounds(935, 275, 121, 28);
		panel_caja.add(Jcb_Pago);
		
	 Jff_SubTotal = new JTextField();
		
		Jff_SubTotal.setForeground(Color.WHITE);
		Jff_SubTotal.setFont(new Font("Roboto", Font.PLAIN, 16));
		Jff_SubTotal.setBorder(null);
		Jff_SubTotal.setBackground(new Color(37, 69, 81));
		Jff_SubTotal.setBounds(935, 313, 100, 22);
		panel_caja.add(Jff_SubTotal);
		
		JSeparator separator_2_1 = new JSeparator();
		separator_2_1.setPreferredSize(new Dimension(0, 1));
		separator_2_1.setForeground(Color.WHITE);
		separator_2_1.setBounds(935, 338, 100, 2);
		panel_caja.add(separator_2_1);
		
		JLabel Jl_SubTotal = new JLabel("Sub Total");
		Jl_SubTotal.setForeground(Color.WHITE);
		Jl_SubTotal.setFont(new Font("Roboto", Font.BOLD, 22));
		Jl_SubTotal.setBounds(827, 315, 98, 35);
		panel_caja.add(Jl_SubTotal);
		
		JFormattedTextField Jff_Descuento = new JFormattedTextField();
		Jff_Descuento.setForeground(Color.WHITE);
		Jff_Descuento.setFont(new Font("Roboto", Font.PLAIN, 16));
		Jff_Descuento.setBorder(null);
		Jff_Descuento.setBackground(new Color(37, 69, 81));
		Jff_Descuento.setBounds(941, 359, 100, 22);
		panel_caja.add(Jff_Descuento);
		
		JSeparator separator_2_2 = new JSeparator();
		separator_2_2.setPreferredSize(new Dimension(0, 1));
		separator_2_2.setForeground(Color.WHITE);
		separator_2_2.setBounds(941, 382, 100, 2);
		panel_caja.add(separator_2_2);
		
		JLabel Jl_Descuento = new JLabel("Descuento");
		Jl_Descuento.setForeground(Color.WHITE);
		Jl_Descuento.setFont(new Font("Roboto", Font.BOLD, 22));
		Jl_Descuento.setBounds(827, 360, 107, 35);
		panel_caja.add(Jl_Descuento);
		
		JFormattedTextField Jff_Impuestos = new JFormattedTextField();
		Jff_Impuestos.setForeground(Color.WHITE);
		Jff_Impuestos.setFont(new Font("Roboto", Font.PLAIN, 16));
		Jff_Impuestos.setBorder(null);
		Jff_Impuestos.setBackground(new Color(37, 69, 81));
		Jff_Impuestos.setBounds(942, 404, 100, 22);
		panel_caja.add(Jff_Impuestos);
		
		JSeparator separator_2_3 = new JSeparator();
		separator_2_3.setPreferredSize(new Dimension(0, 1));
		separator_2_3.setForeground(Color.WHITE);
		separator_2_3.setBounds(941, 427, 101, 2);
		panel_caja.add(separator_2_3);
		
		JLabel Jl_Total = new JLabel("Total");
		Jl_Total.setForeground(Color.WHITE);
		Jl_Total.setFont(new Font("Roboto", Font.BOLD, 22));
		Jl_Total.setBounds(837, 451, 65, 35);
		panel_caja.add(Jl_Total);
		
		JFormattedTextField Jff_Total = new JFormattedTextField();
		Jff_Total.setForeground(Color.WHITE);
		Jff_Total.setFont(new Font("Roboto", Font.PLAIN, 16));
		Jff_Total.setBorder(null);
		Jff_Total.setBackground(new Color(37, 69, 81));
		Jff_Total.setBounds(941, 449, 101, 22);
		panel_caja.add(Jff_Total);
		
		JSeparator separator_2_3_1 = new JSeparator();
		separator_2_3_1.setPreferredSize(new Dimension(0, 1));
		separator_2_3_1.setForeground(Color.WHITE);
		separator_2_3_1.setBounds(941, 472, 100, 2);
		panel_caja.add(separator_2_3_1);
		
		JLabel Total = new JLabel("Impuestos");
		Total.setForeground(Color.WHITE);
		Total.setFont(new Font("Roboto", Font.BOLD, 22));
		Total.setBounds(827, 404, 121, 35);
		panel_caja.add(Total);
		
		JLabel lblNewLabel = new JLabel("Factura");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Roboto Thin", Font.BOLD | Font.ITALIC, 40));
		lblNewLabel.setBounds(911, 0, 145, 54);
		panel_caja.add(lblNewLabel);
		
		JLabel Jl_BotonAgregar = new JLabel("Agregar");
		Jl_BotonAgregar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				Jl_BotonAgregar.setBorder(new LineBorder(new Color(255, 255, 255), 2, true));
				Jl_BotonAgregar.setForeground(Color.GREEN);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				Jl_BotonAgregar.setBorder(new LineBorder(new Color(255, 255, 255), 1, true));
				Jl_BotonAgregar.setForeground(Color.WHITE);
			}
			@Override
			public void mousePressed(MouseEvent e) {
				Registrar venta = new Registrar();
					String sql = "INSERT INTO tbl_factura (producto, cantidad, vendedor) values (?, ?, ?)";
			
				venta.IngresarVenta(Jff_Producto, Jff_Vendedor, Jff_Cantidad, sql);
				Jff_Producto.setText("");
				Jff_Vendedor.setText(""); 
				Jff_Cantidad.setText("");
				Jff_Precio.setText("");
				precio_ = Integer.parseInt(Jff_Precio.getText());
				subtotal = subtotal + precio_;
				subtotal_txt = String.valueOf(subtotal);
				Jff_SubTotal.setText("Probando");
				
				//Jff_SubTotal.setText(subtotal_txt);
				
				
				
			}
		});
		Jl_BotonAgregar.setHorizontalAlignment(SwingConstants.CENTER);
		Jl_BotonAgregar.setBorder(new LineBorder(new Color(255, 255, 255), 1, true));
		Jl_BotonAgregar.setForeground(Color.WHITE);
		Jl_BotonAgregar.setFont(new Font("Roboto Light", Font.BOLD, 22));
		Jl_BotonAgregar.setBounds(376, 147, 98, 35);
		panel_caja.add(Jl_BotonAgregar);
		
		JLabel Jl_BotonRegistrar = new JLabel("Registrar");
		Jl_BotonRegistrar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				Jl_BotonRegistrar.setBorder(new LineBorder(new Color(255, 255, 255), 2, true));
				Jl_BotonRegistrar.setForeground(Color.YELLOW);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				Jl_BotonRegistrar.setBorder(new LineBorder(new Color(255, 255, 255), 1, true));
				Jl_BotonRegistrar.setForeground(Color.WHITE);
			}
			@Override
			public void mousePressed(MouseEvent e) {
			}
		});
		Jl_BotonRegistrar.setHorizontalAlignment(SwingConstants.CENTER);
		Jl_BotonRegistrar.setForeground(Color.WHITE);
		Jl_BotonRegistrar.setFont(new Font("Roboto Light", Font.BOLD, 22));
		Jl_BotonRegistrar.setBorder(new LineBorder(new Color(255, 255, 255), 1, true));
		Jl_BotonRegistrar.setBounds(943, 495, 113, 35);
		panel_caja.add(Jl_BotonRegistrar);
		
		Jff_Precio = new JFormattedTextField(precio);
		Jff_Precio.setForeground(Color.WHITE);
		Jff_Precio.setFont(new Font("Roboto", Font.PLAIN, 16));
		Jff_Precio.setBorder(null);
		Jff_Precio.setBackground(new Color(37, 69, 81));
		Jff_Precio.setBounds(140, 186, 159, 22);
		panel_caja.add(Jff_Precio);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setPreferredSize(new Dimension(0, 1));
		separator_1.setForeground(Color.WHITE);
		separator_1.setBounds(139, 209, 164, 2);
		panel_caja.add(separator_1);
		
		Jff_Producto = new JFormattedTextField();
		Jff_Producto.setForeground(Color.WHITE);
		Jff_Producto.setFont(new Font("Roboto", Font.PLAIN, 16));
		Jff_Producto.setBorder(null);
		Jff_Producto.setBackground(new Color(37, 69, 81));
		Jff_Producto.setBounds(133, 104, 159, 22);
		panel_caja.add(Jff_Producto);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setPreferredSize(new Dimension(0, 1));
		separator_2.setForeground(Color.WHITE);
		separator_2.setBounds(132, 127, 164, 2);
		panel_caja.add(separator_2);
		
		Jff_Vendedor = new JFormattedTextField(nombre);
		Jff_Vendedor.setForeground(Color.WHITE);
		Jff_Vendedor.setFont(new Font("Roboto", Font.PLAIN, 16));
		Jff_Vendedor.setBorder(null);
		Jff_Vendedor.setBackground(new Color(37, 69, 81));
		Jff_Vendedor.setBounds(485, 104, 159, 22);
		panel_caja.add(Jff_Vendedor);
		
		JSeparator separator_3 = new JSeparator();
		separator_3.setPreferredSize(new Dimension(0, 1));
		separator_3.setForeground(Color.WHITE);
		separator_3.setBounds(484, 127, 164, 2);
		panel_caja.add(separator_3);
		
	 Jl_SubTotal1 = new JLabel("");
	 Jl_SubTotal1.setText(subtotal_txt);
		Jl_SubTotal1.setForeground(new Color(255, 255, 255));
		Jl_SubTotal1.setFont(new Font("Roboto", Font.PLAIN, 16));
		Jl_SubTotal1.setBounds(730, 158, 101, 24);
		panel_caja.add(Jl_SubTotal1);
		

			
}	
}
