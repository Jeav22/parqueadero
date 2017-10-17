package controlador;

import BaseDatos.IBaseDatos;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import modelo.AdministradorTarifa;

public class ControladorTarifa {
    
    private static AdministradorTarifa adminTarifa;

    public ControladorTarifa(IBaseDatos mTarifa) {
        adminTarifa = new AdministradorTarifa(mTarifa);
    }
    
    public boolean crearTarifa(LocalDate inicio, LocalTime hInicio, LocalDate expira, LocalTime hExpira, int valor, String tipo){
        return adminTarifa.crearTarifa(inicio, hInicio, expira, hExpira, valor, tipo);
    }
    
    public List<String> listarTarifas(){
        return adminTarifa.listarTarifas();
    }
    
    public String obtenerDatosTarifa(int id){
        return adminTarifa.obtenerDatosTarifa(id);
    }
    
}
