package controlador;

import BaseDatos.IBaseDatos;
import java.util.List;
import modelo.AdministradorVehiculo;

public class ControladorVehiculo {
    
    private static AdministradorVehiculo adminVehiculo;

    public ControladorVehiculo(IBaseDatos mVehiculo, IBaseDatos mServicio, IBaseDatos mPropietario) {
        adminVehiculo = new AdministradorVehiculo(mVehiculo, mServicio, mPropietario);
    }
    
    public boolean registrarVehiculo(String placa, String descripcion){
        return adminVehiculo.registrarVehiculo(placa, descripcion);
    }
    
    public List<String> listarVehiculos(){
        return adminVehiculo.listarVehiculos();
    }
    
    public String obtenerDatosVehiculo(String placa){
        return adminVehiculo.obtenerDatosVehiculo(placa);
    }
}
