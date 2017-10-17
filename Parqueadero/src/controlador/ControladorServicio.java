package controlador;

import BaseDatos.IBaseDatos;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import modelo.AdministradorServicio;

public class ControladorServicio {
    
    private static AdministradorServicio adminServicio;

    public ControladorServicio(IBaseDatos mServicio, IBaseDatos mTarifa, IBaseDatos mPropietario, IBaseDatos mLugarParqueo) {
        adminServicio = new AdministradorServicio(mServicio, mTarifa, mPropietario, mLugarParqueo);
    }
    
    public boolean CrearServicio(LocalDate fechaIngreso, LocalTime horaIngreso, String placa, int ubicacion){
        return adminServicio.CrearServicio(fechaIngreso, horaIngreso, placa, ubicacion);
    }
    
    public double liquidarServicio(LocalDate fechaSalida, String placa, String correo){
        return adminServicio.liquidarServicio(fechaSalida, placa, correo);
    }
    
    public List<String> listarServicios(LocalDate fecha){
        return adminServicio.listarServicios(fecha);
    }
    
    public String obtenerDatosServicio(int id){
        return adminServicio.obtenerDatosServicio(id);
    }

    public String obtenerLugarParqueo(String placa) {
        return adminServicio.obtenerLugarParqueo(placa);
    }
}
