package BaseDatos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import modelo.Propietario;

public class PropietarioDao implements IBaseDatos<Propietario> {

    @Override
    public List<Propietario> findAll() {
        List<Propietario> propietarios = null;
        String query = "SELECT * FROM Propietario";
        Connection connection = Conexion.getConnection();
        try {
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(query);
            int id = 0;
            String nombre = null;
            String correo = null;

            while (rs.next()) {
                if (propietarios == null) {
                    propietarios = new ArrayList<Propietario>();
                }

                Propietario registro = new Propietario();
                id = rs.getInt("id");
                registro.setId(id);

                nombre = rs.getString("nombre");
                registro.setNombre(nombre);

                correo = rs.getString("correo");
                registro.setCorreo(correo);

                propietarios.add(registro);
            }
            st.close();

        } catch (SQLException e) {
            System.out.println("Problemas al obtener la lista de propietarios");
            e.printStackTrace();
        }

        return propietarios;
    }

    @Override
    public boolean insert(Propietario t) {
        boolean result = false;
        Connection connection = Conexion.getConnection();
        String query = " insert into Propietario (nombre, correo)" + " values (?, ?)";
        PreparedStatement preparedStmt = null;

        try {
            preparedStmt = connection.prepareStatement(query);
            preparedStmt.setString(1, t.getNombre());
            preparedStmt.setString(2, t.getCorreo());
            result = preparedStmt.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public boolean update(Propietario t) {
        boolean result = false;
        Connection connection = Conexion.getConnection();
        String query = "update Propietario set nombre = ?, correo = ? where id = ?";
        PreparedStatement preparedStmt = null;
        try {
            preparedStmt = connection.prepareStatement(query);
            preparedStmt.setString(1, t.getNombre());
            preparedStmt.setString(2, t.getCorreo());
            preparedStmt.setInt(3, t.getId());
            if (preparedStmt.executeUpdate() > 0) {
                result = true;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public boolean delete(Propietario t) {
        boolean result = false;
        Connection connection = Conexion.getConnection();
        String query = "delete from Propietario where id = ? ";
        PreparedStatement preparedStmt = null;
        try {
            preparedStmt = connection.prepareStatement(query);
            preparedStmt.setInt(1, t.getId());
            result = preparedStmt.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

}
