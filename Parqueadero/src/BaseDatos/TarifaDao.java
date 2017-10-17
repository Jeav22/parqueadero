package BaseDatos;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalTime;
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
            Time horaInicio = null;
            Time horaExpira = null;
            int valorMinuto = 0;
            LocalDate ldt;

            while (rs.next()) {
                if (tarifas == null) {
                    tarifas = new ArrayList<Tarifa>();
                }

                Tarifa registro = new Tarifa();
                id = rs.getInt("id");
                registro.setIdTarifa(id);

                fechaInicio = rs.getDate("fechaInicio");
                ldt = LocalDate.parse(fechaInicio.toString());
                registro.setFechaInicio(ldt);
                
                horaInicio = rs.getTime("horaInicio");
                registro.setHoraInicio(LocalTime.parse(horaInicio.toString()));

                fechaExpira = rs.getDate("fechaExpira");
                ldt = LocalDate.parse(fechaExpira.toString());
                registro.setFechaExpira(ldt);
                
                horaExpira = rs.getTime("horaExpira");
                registro.setHoraExpira(LocalTime.parse(horaExpira.toString()));

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
        String query = " insert into Tarifa (valorMinuto, fechaInicio, horaInicio, fechaExpira, horaExpira)" + " values (?, ?, ?, ?, ?)";
        PreparedStatement preparedStmt = null;

        try {
            preparedStmt = connection.prepareStatement(query);
            preparedStmt.setInt(1, t.getValorMinuto());
            preparedStmt.setDate(2, Date.valueOf(t.getFechaInicio()));
            preparedStmt.setTime(3, Time.valueOf(t.getHoraInicio()));
            preparedStmt.setDate(4, Date.valueOf(t.getFechaExpira()));
            preparedStmt.setTime(5, Time.valueOf(t.getHoraExpira()));
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
        String query = "update Tarifa set valorMinuto = ?, fechaInicio = ?, horaInico = ?, fechaExpira=?, horaExpira = ? where id = ?";
        PreparedStatement preparedStmt = null;
        try {
            preparedStmt = connection.prepareStatement(query);
            preparedStmt.setInt(1, t.getValorMinuto());
            preparedStmt.setDate(2, Date.valueOf(t.getFechaInicio()));
            preparedStmt.setTime(3, Time.valueOf(t.getHoraInicio()));
            preparedStmt.setDate(4, Date.valueOf(t.getFechaExpira()));
            preparedStmt.setTime(5, Time.valueOf(t.getHoraExpira()));
            preparedStmt.setInt(6, t.getIdTarifa());
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
