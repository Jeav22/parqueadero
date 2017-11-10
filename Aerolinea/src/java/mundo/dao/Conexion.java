    package mundo.dao;
import java.sql.*;
/**
* Clase Conexion: Es la clase que permite que haya una conexion con la base de datos de MySQL
* @author Nicolás Chicuazuque
* @author Jorge Arenas 
* @author Paola Vargas 
* @author Alejandra Castillo
* @author Alejandro Rodriguez
* @version 2
* @since SistemaAlmacen
*/
public class Conexion {
	
	private static Connection CONEXION=null;
        /**
	 * metodo getConnection permite obtener una coneccion con  la base de datos
     * @return la coneccion dada hacia MySQL
	 */
	public static Connection getConnection(){
		   if(CONEXION == null){
			   try {
					Class.forName("com.mysql.jdbc.Driver").newInstance();
			   } catch (ClassNotFoundException e) {
					System.out.println("Where is your MySQL JDBC Driver?");
					e.printStackTrace();
			   } catch (InstantiationException e) {
				   System.out.println("Where is your MySQL JDBC Driver?");
				   e.printStackTrace();
			   } catch (IllegalAccessException e) {
				   System.out.println("Where is your MySQL JDBC Driver?");
					e.printStackTrace();
			   }

				try {
					CONEXION = DriverManager.getConnection("jdbc:mysql://localhost:3306/aerolinea","root", "root");

				} catch (SQLException e) {
					System.out.println("Connection Failed! Check output console");
					e.printStackTrace();
				}

				
		   }
		   return CONEXION;
	}
	/**
	 * metodo closeConnection permite cerrar la coneccion hacia la base de datos
	 */
	public static void closeConnection(){
		 try {
			 if(CONEXION!=null){
				 CONEXION.close();
				 CONEXION=null;
			 }
			 
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		    
	}
	

}
