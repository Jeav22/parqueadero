/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mundo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import mundo.vo.Pasaje;

/**
 *
 * @author JEAV
 */
public class PasajeDao implements IBaseDatos<Pasaje>{

    @Override
    public List<Pasaje> findAll() {
       List<Pasaje> pasajes = null;
       String query="SELECT * FROM pasaje";
       Connection connection = Conexion.getConnection();
        try {
            Statement st= connection.createStatement();
            ResultSet rs= st.executeQuery(query);
            int id= 0;
            double valor= 0.0;
            String pasajero=null;
            int tipo=0;
            int vuelo=0;
            
            while (rs.next()) {                
                if(pasajes== null){
                    pasajes = new ArrayList<Pasaje>();
                }
                Pasaje registro= new Pasaje();
                
                id= rs.getInt("id");
                registro.setId(id);
                
                valor= rs.getDouble("valor");
                registro.setValor(valor);
                
                pasajero= rs.getString("pasajero");
                registro.setPasajero(pasajero);
                
                tipo= rs.getInt("tipo");
                registro.setTipo(tipo);
                
                vuelo= rs.getInt("id_vuelo");
                registro.setVuelo(vuelo);
                
                pasajes.add(registro);
            }
            st.close();
        } catch (Exception e) {
            System.out.println("Error al obtener la lista de pasajes");
            e.printStackTrace();
        }
       return pasajes;
    }

    @Override
    public boolean insert(Pasaje t) {
        boolean result=false;
        Connection connection = Conexion.getConnection();
        String query = " insert into pasaje (valor,pasajero,tipo,id_vuelo)"  + " values (?, ?, ?, ?)";
        PreparedStatement preparedStmt=null;
	    try {
                preparedStmt = connection.prepareStatement(query);
                preparedStmt.setDouble(1, t.getValor());
                preparedStmt.setString(2, t.getPasajero());
                preparedStmt.setInt(3, t.getTipo());
                preparedStmt.setInt(4, t.getVuelo());
                result= preparedStmt.execute();
	    } catch (SQLException e) {
                e.printStackTrace();
            }
        return result;
    }

    @Override
    public boolean update(Pasaje t) {
        boolean result=false;
        Connection connection = Conexion.getConnection();
        String query = "update pasaje set valor = ?, pasajero = ?, tipo = ? id_vuelo = ?";
        PreparedStatement preparedStmt=null;
        try {
            preparedStmt = connection.prepareStatement(query);
            preparedStmt.setDouble(1, t.getValor());
            preparedStmt.setString(4, t.getPasajero());
            preparedStmt.setInt(2, t.getTipo());
            preparedStmt.setInt(3, t.getVuelo());
            if (preparedStmt.executeUpdate() > 0){
                result=true;
            }
        } catch (SQLException e) {
                        e.printStackTrace();
        }
        return result;
    }

    @Override
    public boolean delete(Pasaje t) {
        boolean result=false;
        Connection connection = Conexion.getConnection();
        String query = "delete from pasaje where id = ? ";
        PreparedStatement preparedStmt=null;
        try {
            preparedStmt = connection.prepareStatement(query);
            preparedStmt.setInt(1, t.getId());
            result= preparedStmt.execute();
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }
    
}
