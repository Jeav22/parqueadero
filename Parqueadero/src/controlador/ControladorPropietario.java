package controlador;

import BaseDatos.IBaseDatos;
import java.util.List;
import modelo.AdministradorPropietario;

public class ControladorPropietario {
    
    private static AdministradorPropietario adminPropietario;

    public ControladorPropietario(IBaseDatos mPropietario, IBaseDatos mServicio) {
        adminPropietario = new AdministradorPropietario(mPropietario, mServicio);
    }
    
    public boolean registrarPropietario(String nombre, String correo){
        return adminPropietario.registrarPropietario(nombre, correo);
    }
    
    public List<String> listarPropietarios(){
        return adminPropietario.listarPropietarios();
    }
    
    public String obtenerDatosPropietario(String correo){
        return adminPropietario.obtenerDatosPropietario(correo);
    }
}
