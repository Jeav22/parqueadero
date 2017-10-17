package BaseDatos;

import java.sql.Connection;
import java.sql.Date;
import java.sql.Time;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.time.ZoneOffset;
import java.util.List;
import modelo.Servicio;

public class ServicioDao implements IBaseDatos<Servicio> {

    @Override
    public List<Servicio> findAll() {
        List<Servicio> listaServicios = null;
        String query = "SELECT * FROM Servicio";
        Connection connection = Conexion.getConnection();
        try {
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(query);
            int id = 0;
            Date fechaIngreso = null;
            Time horaIngreso = null;
            Date fechaSalida = null;
            Time horaSalida = null;
            double valorServicio = 0;
            String placa = null;
            int idPropietario = -1;
            int ubicacion = -1;
            LocalDate ldt;
            LocalTime lt;
            LocalDate ldt1;
            LocalTime lt1;

            if (listaServicios == null) {
                listaServicios = new ArrayList<>();
            }

            while (rs.next()) {

                id = rs.getInt("id");

                fechaIngreso = rs.getDate("fechaIngreso");
                ldt = LocalDate.parse(fechaIngreso.toString());
                
                horaIngreso = rs.getTime("horaIngreso");
                lt = LocalTime.parse(horaIngreso.toString());
                
                fechaSalida = rs.getDate("fechaSalida");
                try {
                    ldt1 = LocalDate.parse(fechaSalida.toString());
                } catch (Exception e) {
                    ldt1 = null;
                }
                
                horaSalida = rs.getTime("horaSalida");
                try{
                    lt1 = LocalTime.parse(horaSalida.toString());
                }catch(Exception e){
                    lt1 = null;
                }
                
                valorServicio = rs.getDouble("valor");

                placa = rs.getString("placa");

                idPropietario = rs.getInt("idPropietario");

                ubicacion = rs.getInt("ubicacion");

                listaServicios.add(new Servicio(id,ldt,lt,ldt1,lt1,valorServicio,placa,idPropietario,ubicacion));
            }
            st.close();

        } catch (SQLException e) {
            System.out.println("Problemas al obtener la lista de servicios");
            e.printStackTrace();
        }
        return listaServicios;
    }

    @Override
    public boolean insert(Servicio t) {
        boolean result = true;
        Connection connection = Conexion.getConnection();
        String query = " insert into Servicio (fechaIngreso, horaIngreso, valor, placa, idPropietario, ubicacion)" + " values ( ?, ?, ?, ?, ?, ?)";
        PreparedStatement preparedStmt = null;

        try {
            preparedStmt = connection.prepareStatement(query);
            preparedStmt.setDate(1, Date.valueOf(t.getFechaIngreso().toString()));
            preparedStmt.setTime(2, Time.valueOf(t.getHoraIngreso()));
            preparedStmt.setDouble(3, t.getValorServicio());
            preparedStmt.setString(4, t.getPlaca());
            preparedStmt.setInt(5, t.getIdPropietario());
            preparedStmt.setInt(6, t.getUbicacion());
            result = preparedStmt.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public boolean update(Servicio t) {
        boolean result = true;
        Connection connection = Conexion.getConnection();
        String query = "update Servicio set fechaIngreso = ?, horaIngreso = ?, fechaSalida = ?, horaSalida = ?, valor=?, placa = ?, idPropietario = ?, ubicacion = ? where id = ?";
        PreparedStatement preparedStmt = null;
        try {
            preparedStmt = connection.prepareStatement(query);
            preparedStmt.setDate(1, Date.valueOf(t.getFechaIngreso()));
            preparedStmt.setTime(2, Time.valueOf(t.getHoraIngreso()));
            preparedStmt.setDate(3, Date.valueOf(t.getFechaSalida()));
            preparedStmt.setTime(4, Time.valueOf(t.getHoraSalida()));
            preparedStmt.setDouble(5, t.getValorServicio());
            preparedStmt.setString(6, t.getPlaca());
            preparedStmt.setInt(7, t.getIdPropietario());
            preparedStmt.setInt(8, t.getUbicacion());
            preparedStmt.setInt(9, t.getIdServicio());
            if (preparedStmt.executeUpdate() > 0) {
                result = true;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public boolean delete(Servicio t) {
        boolean result = true;
        Connection connection = Conexion.getConnection();
        String query = "delete from Servicio where id = ? ";
        PreparedStatement preparedStmt = null;
        try {
            preparedStmt = connection.prepareStatement(query);
            preparedStmt.setInt(1, t.getIdServicio());
            result = preparedStmt.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }
}
