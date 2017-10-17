package BaseDatos;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.List;
import modelo.Tarifa;

public class TarifaDao implements IBaseDatos<Tarifa>{

    @Override
    public List<Tarifa> findAll() {
        List<Tarifa> tarifas = null;
        String query = "SELECT * FROM Tarifa";
        Connection connection = Conexion.getConnection();
        try {
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(query);
            int id = 0;
            Date fechaInicio = null;
            Date fechaExpira = null;
            int valorMinuto = 0;
            Instant instant;
            LocalDateTime ldt;

            while (rs.next()) {
                if (tarifas == null) {
                    tarifas = new ArrayList<Tarifa>();
                }

                Tarifa registro = new Tarifa();
                id = rs.getInt("id");
                registro.setIdTarifa(id);

                fechaInicio = rs.getDate("fechaInicio");
                instant = Instant.ofEpochMilli(fechaInicio.getTime());
                ldt = LocalDateTime.ofInstant(instant, ZoneOffset.UTC);
                registro.setFechaInicio(ldt);


                fechaExpira = rs.getDate("fechaExpira");
                instant = Instant.ofEpochMilli(fechaExpira.getTime());
                ldt = LocalDateTime.ofInstant(instant, ZoneOffset.UTC);
                registro.setFechaExpira(ldt);


                valorMinuto = rs.getInt("valorMinuto");
                registro.setValorMinuto(valorMinuto);

                tarifas.add(registro);
            }
            st.close();

        } catch (SQLException e) {
            System.out.println("Problemas al obtener la lista de lugares de parqueo");
            e.printStackTrace();
        }

        return tarifas;
    }

    @Override
    public boolean insert(Tarifa t) {
        boolean result = false;
        Connection connection = Conexion.getConnection();
        String query = " insert into Tarifa (valorMinuto, fechaInicio, fechaExpira)" + " values (?, ?, ?)";
        PreparedStatement preparedStmt = null;

        try {
            preparedStmt = connection.prepareStatement(query);
            preparedStmt.setInt(1, t.getValorMinuto());
            Instant instant = t.getFechaInicio().toInstant(ZoneOffset.UTC);
            preparedStmt.setDate(2, (Date) Date.from(instant));
            instant = t.getFechaExpira().toInstant(ZoneOffset.UTC);
            preparedStmt.setDate(3, (Date) Date.from(instant));
            result = preparedStmt.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public boolean update(Tarifa t) {
        boolean result = false;
        Connection connection = Conexion.getConnection();
        String query = "update Tarifa set valorMinuto = ?, fechaInicio = ?, fechaExpira=? where id = ?";
        PreparedStatement preparedStmt = null;
        try {
            preparedStmt = connection.prepareStatement(query);
            preparedStmt.setInt(1, t.getValorMinuto());
            Instant instant = t.getFechaInicio().toInstant(ZoneOffset.UTC);
            preparedStmt.setDate(2, (Date) Date.from(instant));
            instant = t.getFechaExpira().toInstant(ZoneOffset.UTC);
            preparedStmt.setDate(3, (Date) Date.from(instant));
            preparedStmt.setInt(4, t.getIdTarifa());
            if (preparedStmt.executeUpdate() > 0) {
                result = true;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public boolean delete(Tarifa t) {
        boolean result = false;
        Connection connection = Conexion.getConnection();
        String query = "delete from Tarifa where id = ? ";
        PreparedStatement preparedStmt = null;
        try {
            preparedStmt = connection.prepareStatement(query);
            preparedStmt.setInt(1, t.getIdTarifa());
            result = preparedStmt.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }
}
