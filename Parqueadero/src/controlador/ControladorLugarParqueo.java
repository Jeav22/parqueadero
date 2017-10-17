package controlador;

import BaseDatos.IBaseDatos;
import modelo.AdministradorLugarParqueo;

public class ControladorLugarParqueo {
    
     private static AdministradorLugarParqueo adminLugarParqueo;

    public ControladorLugarParqueo(IBaseDatos mLugarParqueo) {
        adminLugarParqueo = new AdministradorLugarParqueo(mLugarParqueo);
    }
    
    public boolean actualizarEstadoLugarParqueo(int idLugarParqueo, int estado){
        return adminLugarParqueo.actualizarEstadoLugarParqueo(idLugarParqueo, estado);
    }
    
    public int consultarEstadoLugarParqueo(int idLugarParqueo){
        return adminLugarParqueo.consultarEstadoLugarParqueo(idLugarParqueo);
    }
    
    public String obtenerTipoEstadoLugarParqueo(int idLugarParqueo){
        return adminLugarParqueo.obtenerTipoLugarParqueo(idLugarParqueo);
    }
    
    public boolean modificarTipoLugarParqueo(int idLugarParqueo, String tipo){
        return adminLugarParqueo.modificarTipoLugarParqueo(idLugarParqueo, tipo);
    }
}
