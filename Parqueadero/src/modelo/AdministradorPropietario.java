package modelo;

import BaseDatos.IBaseDatos;
import java.util.ArrayList;
import java.util.List;

public class AdministradorPropietario {
    
    private IBaseDatos mPropietario;
    private IBaseDatos mServicio;

    public AdministradorPropietario(IBaseDatos mPropietario, IBaseDatos mServicio) {
        this.mPropietario = mPropietario;
        this.mServicio = mServicio;
    }
    
    public boolean registrarPropietario(String nombre, String correo){
        Propietario p = new Propietario();
        p.setNombre(nombre);
        p.setCorreo(correo);
        return mPropietario.insert(p);

    }
    
    public List<String> listarPropietarios(){
        List<String> propietarios = new ArrayList<>();
        List<Propietario> listaPropietarios = mPropietario.findAll();
        
        for (Propietario listaPropietario : listaPropietarios) {
            String p = "Id: "+listaPropietario.getId()+" Nombre: "+listaPropietario.getNombre()+" Correo: "+listaPropietario.getCorreo();
            propietarios.add(p);
        }
        return propietarios;
    }
    
    public String obtenerDatosPropietario(String correo){
        String propietario = null;
        String servicio = null;
        List<Propietario> listaPropietarios = mPropietario.findAll();
        List<Servicio> listaServicios = mServicio.findAll();
        
        try{
            for (Propietario listaPropietario : listaPropietarios) {
                if (listaPropietario.getCorreo().equalsIgnoreCase(correo)) {
                    propietario = "Id: "+listaPropietario.getId()+" Nombre: "+listaPropietario.getNombre()+" Correo: "+listaPropietario.getCorreo()+"\n\n";
                    for (Servicio listaServicio : listaServicios) {
                        if (listaServicio.getIdPropietario() == listaPropietario.getId()) {
                            servicio += "Servicio: "+listaServicio.getIdServicio()+" Valor: "+listaServicio.getValorServicio()+" Ingreso: "+listaServicio.getFechaIngreso()+" Salida: "+listaServicio.getFechaSalida()+" Ubicacion: "+listaServicio.getUbicacion()+" Propietario: "+listaPropietario.getNombre()+"\n";
                        }
                    }
                    return propietario+servicio;
                }
            }
        }catch(Exception e){
        }
                
        return "No se encuentra el propietario con correo: "+correo;
    }
}
