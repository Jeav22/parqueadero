package BaseDatos;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.Instant;
import java.time.LocalDateTime;
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
            Date fechaSalida = null;
            double valorServicio = 0;
            String placa = null;
            int idPropietario = -1;
            int ubicacion = -1;
            Instant instant;
            LocalDateTime ldt;
            LocalDateTime ldt1;

            if (listaServicios == null) {
                listaServicios = new ArrayList<>();
            }

            while (rs.next()) {
                //Servicio registro = new Servicio();

                id = rs.getInt("id");
                //registro.setIdServicio(id);

                fechaIngreso = rs.getDate("fechaIngreso");
                instant = Instant.ofEpochMilli(fechaIngreso.getTime());
                ldt = LocalDateTime.ofInstant(instant, ZoneOffset.UTC);
                //registro.setFechaIngreso(ldt);

                fechaSalida = rs.getDate("fechaSalida");
                try {
                    instant = Instant.ofEpochMilli(fechaSalida.getTime());
                    ldt1 = LocalDateTime.ofInstant(instant, ZoneOffset.UTC);
                } catch (Exception e) {
                    ldt1 = null;
                }
                //registro.setFechaSalida(ldt1);

                valorServicio = rs.getDouble("valor");
                //registro.setValorServicio(valorServicio);

                placa = rs.getString("placa");
                System.out.println("plaaaca " + placa);
                //registro.setPlaca(placa);

                idPropietario = rs.getInt("idPropietario");
                //registro.setIdPropietario(idPropietario);

                ubicacion = rs.getInt("ubicacion");
                //registro.setUbicacion(ubicacion);

                listaServicios.add(new Servicio(id,ldt,ldt1,valorServicio,placa,idPropietario,ubicacion));
        System.out.println("id " + listaServicios.get(0).getPlaca());
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
        String query = " insert into Servicio (fechaIngreso, valor, placa, idPropietario, ubicacion)" + " values ( ?, ?, ?, ?, ?)";
        PreparedStatement preparedStmt = null;

        try {
            preparedStmt = connection.prepareStatement(query);
            Instant instant = t.getFechaIngreso().toInstant(ZoneOffset.UTC);
            preparedStmt.setDate(1, Date.valueOf(t.getFechaIngreso().toLocalDate()));
            preparedStmt.setDouble(2, t.getValorServicio());
            preparedStmt.setString(3, t.getPlaca());
            preparedStmt.setInt(4, t.getIdPropietario());
            preparedStmt.setInt(5, t.getUbicacion());
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
        String query = "update Servicio set fechaIngreso = ?, fechaSalida = ? , valor=?, placa = ?, idPropietario = ?, ubicacion = ? where id = ?";
        PreparedStatement preparedStmt = null;
        try {
            preparedStmt = connection.prepareStatement(query);
            Instant instant = t.getFechaIngreso().toInstant(ZoneOffset.UTC);
            preparedStmt.setDate(1, (Date) Date.from(instant));
            instant = t.getFechaSalida().toInstant(ZoneOffset.UTC);
            preparedStmt.setDate(2, (Date) Date.from(instant));
            preparedStmt.setDouble(3, t.getValorServicio());
            preparedStmt.setString(4, t.getPlaca());
            preparedStmt.setInt(5, t.getIdPropietario());
            preparedStmt.setInt(6, t.getUbicacion());
            preparedStmt.setInt(7, t.getIdServicio());
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
