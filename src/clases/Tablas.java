package clases;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import conector.Conectar_Bd;

public class Tablas {
	Conectar_Bd bd = new Conectar_Bd();
	Connection con=bd.conectar();
	DefaultTableModel modelo;
	
	
	public DefaultTableModel MostrarProductos(JTable table){
		table.setEnabled(true);
		table.setCellSelectionEnabled(true);
		table.setColumnSelectionAllowed(true);
		table.setFillsViewportHeight(true);
		table.setShowVerticalLines(true);
		table.setFocusable(true);
		table.setSelectionBackground(new Color(230, 230, 230));
		table.setRowMargin(0);
		table.setRowHeight(20);
		table.setIntercellSpacing(new Dimension(0, 0));
		table.setGridColor(new Color(255, 255, 255));
		table.setBorder(new LineBorder(new Color(255, 255, 255), 1, true));
		table.setBackground(new Color(230, 230, 230));
		table.setSelectionForeground(new Color(0, 0, 0));
		table.setFont(new Font("Roboto Light", Font.ITALIC, 16));
		table.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 20));
		table.getTableHeader().setOpaque(false);
		table.getTableHeader().setBackground(new Color(48, 118, 137));
		table.getTableHeader().setForeground(new Color(255, 255, 255));
		table.setRowHeight(25);
		
		String [] nombresColumnas = {"Id", "Producto", "Precio", "Unidades"};
		String [] registros = new String [4];
		modelo = new DefaultTableModel(null, nombresColumnas); 
		String sql = "SELECT * FROM tbl_productos";
		Connection cn = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		
		
		try{
			

			cn = bd.conectar();
		
		pst = cn.prepareStatement(sql);
		rs = pst.executeQuery();
			while(rs.next()) {
				registros[0] = rs.getString("codigo");
				registros[1] = rs.getString("nombre");
				registros[2] = rs.getString("precio");
				registros[3] = rs.getString("existencia");
				modelo.addRow(registros);
			}
		
		}
	 catch(SQLException e) 
		{
		JOptionPane.showMessageDialog(null, "Error al conectar\n");
		JOptionPane.showMessageDialog(null, e.getMessage());	
	}
		finally 
		{
				try 
				{
					if (rs != null) rs.close();
					if (pst != null) pst.close();
					if (cn != null) cn.close();
				}
				catch(SQLException ex) 
				{
					JOptionPane.showMessageDialog(null, ex.getMessage());
				} 
	
		} 
		table.setModel(modelo);
		return modelo;
	
}
	public DefaultTableModel MostrarEmpleados(JTable table){
		table.setEnabled(true);
		table.setCellSelectionEnabled(true);
		table.setColumnSelectionAllowed(true);
		table.setFillsViewportHeight(true);
		table.setShowVerticalLines(true);
		table.setFocusable(true);
		table.setSelectionBackground(new Color(230, 230, 230));
		table.setRowMargin(0);
		table.setRowHeight(20);
		table.setIntercellSpacing(new Dimension(0, 0));
		table.setGridColor(new Color(255, 255, 255));
		table.setBorder(new LineBorder(new Color(255, 255, 255), 1, true));
		table.setBackground(new Color(230, 230, 230));
		table.setSelectionForeground(new Color(0, 0, 0));
		table.setFont(new Font("Roboto Light", Font.ITALIC, 12));
		table.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 20));
		table.getTableHeader().setOpaque(false);
		table.getTableHeader().setBackground(new Color(48, 118, 137));
		table.getTableHeader().setForeground(new Color(255, 255, 255));
		table.setRowHeight(20);
		
		String [] nombresColumnas = {"Id", "Nombre", "Cedula", "telefono", "Codigo", "Posicion", "Sucursal", "tanda", "Sueldo"};
		String [] registros = new String [9];
		modelo = new DefaultTableModel(null, nombresColumnas); 
		String sql = "SELECT * FROM tbl_empleados";
		Connection cn = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		
		
		try{
			

			cn = bd.conectar();
		
		pst = cn.prepareStatement(sql);
		rs = pst.executeQuery();
			while(rs.next()) {
				registros[0] = rs.getString("id");
				registros[1] = rs.getString("nombre");
				registros[2] = rs.getString("identificacion");
				registros[3] = rs.getString("telefono");
				registros[4] = rs.getString("codigo_empleado");
				registros[5] = rs.getString("posicion");
				registros[6] = rs.getString("sucursal");
				registros[7] = rs.getString("tanda");
				registros[8] = rs.getString("sueldo");

				modelo.addRow(registros);
			}
		
		}
	 catch(SQLException e) 
		{
		JOptionPane.showMessageDialog(null, "Error al conectar\n");
		JOptionPane.showMessageDialog(null, e.getMessage());	
	}
		finally 
		{
				try 
				{
					if (rs != null) rs.close();
					if (pst != null) pst.close();
					if (cn != null) cn.close();
				}
				catch(SQLException ex) 
				{
					JOptionPane.showMessageDialog(null, ex.getMessage());
				} 
	
		} 
		table.setModel(modelo);
		return modelo;				
}
	public DefaultTableModel MostrarUsuarios(JTable table){
		table.setEnabled(true);
		table.setCellSelectionEnabled(true);
		table.setColumnSelectionAllowed(true);
		table.setFillsViewportHeight(true);
		table.setShowVerticalLines(true);
		table.setFocusable(true);
		table.setSelectionBackground(new Color(230, 230, 230));
		table.setRowMargin(0);
		table.setRowHeight(20);
		table.setIntercellSpacing(new Dimension(0, 0));
		table.setGridColor(new Color(255, 255, 255));
		table.setBorder(new LineBorder(new Color(255, 255, 255), 1, true));
		table.setBackground(new Color(230, 230, 230));
		table.setSelectionForeground(new Color(0, 0, 0));
		table.setFont(new Font("Roboto Light", Font.ITALIC, 16));
		table.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 20));
		table.getTableHeader().setOpaque(false);
		table.getTableHeader().setBackground(new Color(48, 118, 137));
		table.getTableHeader().setForeground(new Color(255, 255, 255));
		table.setRowHeight(25);
		
		String [] nombresColumnas = {"Id", "Usuario", "Contrasena"};
		String [] registros = new String [3];
		modelo = new DefaultTableModel(null, nombresColumnas); 
		String sql = "SELECT * FROM tbl_us_administrador";
		String sql2 = "SELECT * FROM tbl_us_administrador";
		String sql3 = "SELECT * FROM tbl_us_administrador";
		Connection cn = null;
		PreparedStatement pst = null;
		PreparedStatement pst2 = null;
		PreparedStatement pst3 = null;
		ResultSet rs = null;
		ResultSet rs2 = null;
		ResultSet rs3 = null;

		try{
			

			cn = bd.conectar();
		
		pst = cn.prepareStatement(sql);
		rs = pst.executeQuery();
			while(rs.next()) {
				registros[0] = rs.getString("id");
				registros[1] = rs.getString("usuario");
				registros[2] = rs.getString("contrasena");
				modelo.addRow(registros);
			}
		
		}
	 catch(SQLException e) 
		{
		JOptionPane.showMessageDialog(null, "Error al conectar\n");
		JOptionPane.showMessageDialog(null, e.getMessage());	
	}
		finally 
		{
				try 
				{
					if (rs != null) rs.close();
					if (pst != null) pst.close();
					if (cn != null) cn.close();
				}
				catch(SQLException ex) 
				{
					JOptionPane.showMessageDialog(null, ex.getMessage());
				} 
	
		} 
		table.setModel(modelo);
		return modelo;
	
}
	
	
	public void EliminarRegistro(JLabel j, JTable jt) {
		PreparedStatement ps = null;
		try {
			Conectar_Bd bd = new Conectar_Bd();
			Connection con=bd.conectar();
			
			int Fila = jt.getSelectedRow();
			String codigo = jt.getValueAt(Fila, 0).toString();
			
			ps = con.prepareStatement("DELETE FROM tbl_productos WHERE codigo=?");
			ps.setString(1, codigo);
			ps.execute();
			
			modelo.removeRow(Fila);
			JOptionPane.showMessageDialog(null, "Registro eliminado");
			
			
			
		} catch(SQLException ex) {
			JOptionPane.showMessageDialog(null, ex.getMessage());
		}
		
	}
	
	
	
	
	
	}
