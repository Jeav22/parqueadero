package controlador;

import BaseDatos.IBaseDatos;
import java.time.LocalDateTime;
import java.util.List;
import modelo.AdministradorTarifa;

public class ControladorTarifa {
    
    private static AdministradorTarifa adminTarifa;

    public ControladorTarifa(IBaseDatos mTarifa) {
        adminTarifa = new AdministradorTarifa(mTarifa);
    }
    
    public boolean crearTarifa(LocalDateTime inicio, LocalDateTime expira, int valor, String tipo){
        return adminTarifa.crearTarifa(inicio, expira, valor, tipo);
    }
    
    public List<String> listarTarifas(){
        return adminTarifa.listarTarifas();
    }
    
    public String obtenerDatosTarifa(int id){
        return adminTarifa.obtenerDatosTarifa(id);
    }
    
}
