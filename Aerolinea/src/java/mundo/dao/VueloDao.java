/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mundo.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import mundo.vo.Vuelo;

/**
 *
 * @author JEAV
 */
public class VueloDao implements IBaseDatos<Vuelo>{

    @Override
    public List findAll() {
        List<Vuelo> vuelos = null;
        String query ="SELECT * FROM vuelo";
        Connection connection = Conexion.getConnection();
        try {
            Statement st= connection.createStatement();
            ResultSet rs= st.executeQuery(query);
            int codigo=0;
            String destino= null;
            Date fecha= null;
            int cantidad= 0;
            int disp_promo=0;
            int disp_econo=0;
            int disp_flexi=0;
            String img=null;
            
            while (rs.next()) {                
                if(vuelos == null){
                    vuelos = new ArrayList<Vuelo>();
                }
                Vuelo registro= new Vuelo();
                
                codigo= rs.getInt("id");
                registro.setCodigo(codigo);
                
                destino=rs.getString("destino");
                registro.setDestino(destino);
                
                fecha= rs.getDate("fecha");
                registro.setFecha(fecha);
                
                cantidad= rs.getInt("cantidad");
                registro.setCantidad(cantidad);
                
                disp_promo= rs.getInt("promo");
                registro.setDisponiblesPromo(disp_promo);
                
                disp_econo= rs.getInt("econo");
                registro.setDisponiblesEcono(disp_econo);
                
                disp_flexi= rs.getInt("flexi");
                registro.setDisponiblesFlexi(disp_flexi);
                
                img= rs.getString("img");
                registro.setImg(img);
                
                vuelos.add(registro);
            }
            st.close();
        } catch (Exception e) {
            System.out.println("Error al obtener la lista de vuelos");
        }
       return vuelos;
    }

    @Override
    public boolean insert(Vuelo t) {
        boolean result=false;
        Connection connection = Conexion.getConnection();
        String query = " insert into vuelo (destino,fecha,cantidad,promo,flexi,id_aerolinea)"  + " values (?, ?, ?, ?, ?, 1)";
        PreparedStatement preparedStmt=null;
	    try {
                preparedStmt = connection.prepareStatement(query);
                preparedStmt.setString(1, t.getDestino());
                preparedStmt.setDate(2, t.getFecha());
                preparedStmt.setInt(3, t.getCantidad());
                preparedStmt.setInt(4, t.getDisponiblesPromo());
                preparedStmt.setInt(5, t.getDisponiblesEcono());
                preparedStmt.setInt(6, t.getDisponiblesFlexi());
                result= preparedStmt.execute();
	    } catch (SQLException e) {
                e.printStackTrace();
            }
        return result;
    }

    @Override
    public boolean update(Vuelo t) {
        boolean result=false;
        Connection connection = Conexion.getConnection();
        String query = "update vuelo set destino = ?, fecha = ?, cantidad = ?, promo = ?, econo = ?, flexi = ? where id=?";
        PreparedStatement preparedStmt=null;
        try {
            preparedStmt = connection.prepareStatement(query);
            preparedStmt.setString(1, t.getDestino());
            preparedStmt.setDate(2, t.getFecha());
            preparedStmt.setInt(3, t.getCantidad());
            preparedStmt.setInt(4, t.getDisponiblesPromo());
            preparedStmt.setInt(5, t.getDisponiblesEcono());
            preparedStmt.setInt(6, t.getDisponiblesFlexi());
            preparedStmt.setInt(7, t.getCodigo());
            if (preparedStmt.executeUpdate() > 0){
                result=true;
            }
        } catch (SQLException e) {
                        e.printStackTrace();
        }
        return result;
    }

    @Override
    public boolean delete(Vuelo t) {
        boolean result=false;
        Connection connection = Conexion.getConnection();
        String query = "delete from vuelo where id = ? ";
        PreparedStatement preparedStmt=null;
        try {
            preparedStmt = connection.prepareStatement(query);
            preparedStmt.setInt(1, t.getCodigo());
            result= preparedStmt.execute();
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }
    
}
