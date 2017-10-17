package BaseDatos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import modelo.LugarParqueo;

public class LugarParqueoDao implements IBaseDatos<LugarParqueo> {

    @Override
    public List<LugarParqueo> findAll() {
        List<LugarParqueo> lugarParqueos = null;
        String query = "SELECT * FROM LugarParqueo";
        Connection connection = Conexion.getConnection();
        try {
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(query);
            int id = 0;
            String tipoLugar = null;
            int estado = 0;

            while (rs.next()) {
                if (lugarParqueos == null) {
                    lugarParqueos = new ArrayList<LugarParqueo>();
                }

                LugarParqueo registro = new LugarParqueo();
                
                id = rs.getInt("id");
                registro.setIdLugarParqueo(id);

                tipoLugar = rs.getString("tipo");
                registro.setTipoLugarParqueo(tipoLugar);

                estado = rs.getInt("estado");
                registro.setEstadoLugarParqueo(estado);

                lugarParqueos.add(registro);
            }
            st.close();

        } catch (SQLException e) {
            System.out.println("Problemas al obtener la lista de lugares de parqueo");
            e.printStackTrace();
        }

        return lugarParqueos;
    }

    @Override
    public boolean insert(LugarParqueo t) {
        boolean result = false;
        Connection connection = Conexion.getConnection();
        String query = " insert into LugarParqueo (tipo, estado)" + " values (?, ?)";
        PreparedStatement preparedStmt = null;

        try {
            preparedStmt = connection.prepareStatement(query);
            preparedStmt.setString(1, t.getTipoLugarParqueo());
            preparedStmt.setInt(2, t.getEstadoLugarParqueo());
            result = preparedStmt.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public boolean update(LugarParqueo t) {
        boolean result = false;
        Connection connection = Conexion.getConnection();
        String query = "update LugarParqueo set tipo = ?, estado = ? where id = ?";
        PreparedStatement preparedStmt = null;
        try {
            preparedStmt = connection.prepareStatement(query);
            preparedStmt.setString(1, t.getTipoLugarParqueo());
            preparedStmt.setInt(2, t.getEstadoLugarParqueo());
            preparedStmt.setInt(3, t.getIdLugarParqueo());
            if (preparedStmt.executeUpdate() > 0) {
                result = true;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public boolean delete(LugarParqueo t) {
        boolean result = false;
        Connection connection = Conexion.getConnection();
        String query = "delete from LugarParqueo where id = ? ";
        PreparedStatement preparedStmt = null;
        try {
            preparedStmt = connection.prepareStatement(query);
            preparedStmt.setInt(1, t.getIdLugarParqueo());
            result = preparedStmt.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }
}
