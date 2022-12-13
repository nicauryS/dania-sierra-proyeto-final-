package conector;
import java.sql.*;

public class Conectar_Bd {

		private static final String nombreBd="bd_trabajofinal";
		private static final String usuario="root";
		private static final String password="123456";
		private static final String url = "jdbc:mysql://localhost:3306/"+nombreBd+"?useUnicode=true&use"
				+"JDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&"
				+"ServerTimezone";
		static final String controlador = "com.mysql.cj.jdbc.Driver";
		
		static{ //buena practica
			try {
				Class.forName(controlador);
			} catch (Exception e) {
				System.out.print("Error al cargar el controlador\n");
				e.printStackTrace();
			}
		}
		
		public Connection conectar() {
			Connection conexion = null;
			
			try {
				
				conexion = DriverManager.getConnection(url, usuario, password);
				//System.out.print("Se pudo conectar");
			}  
				
			
			
			catch (SQLException e) {
				System.out.print("Error al cargar en la conexion\n");
				e.printStackTrace();
			}
			return conexion;
			
		}
		
		
		
	}

