package BaseDatos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import modelo.Vehiculo;

public class VehiculoDao implements IBaseDatos<Vehiculo> {

    @Override
    public List<Vehiculo> findAll() {
        List<Vehiculo> vehiculos = null;
        String query = "SELECT * FROM Vehiculo";
        Connection connection = Conexion.getConnection();
        try {
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(query);
            String placa = null;

            while (rs.next()) {
                if (vehiculos == null) {
                    vehiculos = new ArrayList<Vehiculo>();
                }

                Vehiculo registro = new Vehiculo();
                placa = rs.getString("placa");
                registro.setPlaca(placa);

                vehiculos.add(registro);
            }
            st.close();
        } catch (SQLException e) {
            System.out.println("Problemas al obtener la lista de vehiculos");
            e.printStackTrace();
        }
        return vehiculos;
    }

    @Override
    public boolean insert(Vehiculo t) {
        boolean result = false;
        Connection connection = Conexion.getConnection();
        String query = " insert into Vehiculo (placa)" + " values (?)";
        PreparedStatement preparedStmt = null;
        try {
            preparedStmt = connection.prepareStatement(query);
            preparedStmt.setString(1, t.getPlaca());
            result = preparedStmt.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public boolean update(Vehiculo t) {
        boolean result = false;
        Connection connection = Conexion.getConnection();
        String query = "update Vehiculo set placa = ? where id = ?";
        PreparedStatement preparedStmt = null;
        try {
            preparedStmt = connection.prepareStatement(query);
            preparedStmt.setString(1, t.getPlaca());
            preparedStmt.setInt(2, t.getId());
            if (preparedStmt.executeUpdate() > 0) {
                result = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public boolean delete(Vehiculo t) {
        boolean result = true;
        Connection connection = Conexion.getConnection();
        String query = "delete from Vehiculo where id =? and placa=?";
        PreparedStatement preparedStmt = null;
        try {
            preparedStmt = connection.prepareStatement(query);
            preparedStmt.setInt(1, t.getId());
            preparedStmt.setString(2, t.getPlaca());
            String r = "" + preparedStmt.execute();
            System.out.println(r);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }
}
