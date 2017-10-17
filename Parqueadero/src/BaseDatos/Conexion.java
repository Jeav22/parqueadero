package BaseDatos;

import java.sql.*;

public class Conexion {
	
    private static Connection CONEXION=null;

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
                CONEXION = DriverManager.getConnection("jdbc:mysql://localhost:3306/parqueadero","root", "root");

            } catch (SQLException e) {
                System.out.println("Connection Failed! Check output console");
                e.printStackTrace();
            }
        }
        return CONEXION;
    }
	
    public static void closeConnection(){
        try {
            if(CONEXION!=null){
                CONEXION.close();
                CONEXION=null;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }	    
    }
	
}
