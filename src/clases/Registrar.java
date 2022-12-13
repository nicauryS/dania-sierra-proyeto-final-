package clases;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import javax.swing.JTextField;

import conector.Conectar_Bd;

public class Registrar {
	Conectar_Bd bd = new Conectar_Bd();
	Connection con=bd.conectar();
	
	public void ingresarUsuario(JTextField jf, JTextField jf2, String SQL ){
			
			try {
				PreparedStatement pat = con.prepareStatement(SQL);
				pat.setString(1, jf.getText());
				pat.setString(2, jf2.getText());
				
					pat.executeUpdate();
					
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "Eror de ingreso" + e.getMessage());//e nos ayuda a encontrar mas rapido el error
				
				
				// TODO: handle exception
			}}
	public void ingresarEmpleado(JTextField jf, JTextField jf2, JTextField jf3, JTextField jf4, JComboBox jcb, JComboBox jcb2, JComboBox jcb3,JComboBox jcb4, String SQL ){
		
		try {
			PreparedStatement pat = con.prepareStatement(SQL);
			pat.setString(1, jf.getText());
			pat.setString(2, jf2.getText());
			pat.setString(3, jf3.getText());
			pat.setString(4, jf4.getText());
			pat.setString(5, (String) jcb.getSelectedItem());
			pat.setString(6, (String) jcb2.getSelectedItem());
			pat.setString(7, (String) jcb3.getSelectedItem());
			pat.setString(8, (String) jcb4.getSelectedItem());
			
			
				pat.executeUpdate();
				//JOptionPane.showMessageDialog(null, "Registro exitoso");
				
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Eror de ingreso" + e.getMessage());//e nos ayuda a encontrar mas rapido el error
			
			
			// TODO: handle exception
		}}
	public void ingresarVendedor(JTextField jf, JTextField jf2, String SQL ){
		
		try {
			PreparedStatement pat = con.prepareStatement(SQL);
			pat.setString(1, jf.getText());
			pat.setString(2, jf2.getText());			
			
				pat.executeUpdate();
				//JOptionPane.showMessageDialog(null, "Registro exitoso");
				
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Eror de ingreso" + e.getMessage());//e nos ayuda a encontrar mas rapido el error
			
			
			// TODO: handle exception
		}}	
	

	public void IngresarProductos(JTextField jf, JFormattedTextField jf2, JFormattedTextField jf3, String SQL) {
		
		try { PreparedStatement pat = con.prepareStatement(SQL);
		pat.setString(1, jf.getText());
		pat.setString(2, jf2.getText());
		pat.setString(3, jf3.getText());
		pat.executeUpdate();
		//JOptionPane.showMessageDialog(null, "Registro exitoso");
		

		} catch (Exception e) {
	
			JOptionPane.showMessageDialog(null, "Eror de Producto" + e.getMessage());//e nos ayuda a encontrar mas rapido el error
	
	
	// TODO: handle exception
}}
	public void IngresarVenta(JFormattedTextField jb, JFormattedTextField jb2, JFormattedTextField Jff_Cantidad, String SQL) {
		
		try { 
		PreparedStatement pat = con.prepareStatement(SQL);
		pat.setString(1, (String) jb.getText());
		pat.setString(2, Jff_Cantidad.getText());
		pat.setString(3, (String) jb2.getText());
		pat.executeUpdate();
		JOptionPane.showMessageDialog(null, "Registro exitoso");
		

		} catch (Exception e) {
	
			JOptionPane.showMessageDialog(null, "Eror de Producto" + e.getMessage());//e nos ayuda a encontrar mas rapido el error
	
	
	// TODO: handle exception
}}
	
	public void LlenarComboBox(JComboBox<String> jc ) {
		String sql = "SELECT * FROM tbl_productos";
		//String Sql_Campo = "nombre";
		
		try {
			PreparedStatement ps = con.prepareStatement(sql);
				ResultSet result = ps.executeQuery(sql);
			
				while(result.next()) {
					jc.addItem(result.getString("nombre"));				
				}
			
		} catch (Exception e) 
		{
			JOptionPane.showConfirmDialog(null, e.getMessage());
	
		} finally
		{
			if(con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					JOptionPane.showMessageDialog(null, e.getMessage());
				}				
			}			
		}	
	}		
	public void LlenarComboBoxVendedor(JComboBox<String> jc ) {
		String sql = "SELECT * FROM tbl_vendedor";
		//String Sql_Campo = "nombre";
		
		try {
			PreparedStatement ps = con.prepareStatement(sql);
				ResultSet result = ps.executeQuery(sql);
			
				while(result.next()) {
					jc.addItem(result.getString("nombre"));				
				}
			
		} catch (Exception e) 
		{
			JOptionPane.showConfirmDialog(null, e.getMessage());
	
		} finally
		{
			if(con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					JOptionPane.showMessageDialog(null, e.getMessage());
				}				
			}			
		}	
	}	
		
	}






			
		

