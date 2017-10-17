package modelo;

import BaseDatos.IBaseDatos;
import java.util.ArrayList;
import java.util.List;

public class AdministradorVehiculo {

    private IBaseDatos mVehiculo;
    private IBaseDatos mServicio;
    private IBaseDatos mPropietario;

    public AdministradorVehiculo(IBaseDatos vehiculo, IBaseDatos servicio, IBaseDatos propietario) {
        super();
        this.mVehiculo = vehiculo;
        this.mServicio = servicio;
        this.mPropietario = propietario;
    }

    public boolean registrarVehiculo(String placa, String descripcion) {
        Vehiculo v = new Vehiculo();
        v.setPlaca(placa);
        v.setDescripcion(descripcion);
        return mVehiculo.insert(v);
    }

    public List<String> listarVehiculos() {
        List<Vehiculo> listaVehiculos = mVehiculo.findAll();
        List<String> vehiculos = new ArrayList<>();
        
        for (Vehiculo listaVehiculo : listaVehiculos) {
            String v ="Placa: " + listaVehiculo.getPlaca() + " Descripcion: " + listaVehiculo.getDescripcion()+"\n";
            vehiculos.add(v);
        }
                
        return vehiculos;
    }

    public String obtenerDatosVehiculo(String placa) {
        List<Vehiculo> listaVehiculos = mVehiculo.findAll();
        List<Servicio> listaServicios = mServicio.findAll();
        List<Propietario> listaPropietarios = mPropietario.findAll();
        String vehiculo = "";
        String servicios = "";
        for (Vehiculo listaVehiculo : listaVehiculos) {
            if (listaVehiculo.getPlaca().equalsIgnoreCase(placa)) {
                vehiculo = "Placa: " + listaVehiculo.getPlaca() + " Descripcion: " + listaVehiculo.getDescripcion()+"\n\n";

                for (Servicio listaServicio : listaServicios) {
                    if (listaServicio.getPlaca().equalsIgnoreCase(placa)) {
                        String dueño= null;
                        if (listaServicio.getIdPropietario() == -1) {
                            dueño = "Anonimo";
                        }else{
                            try{
                                for (Propietario listaPropietario : listaPropietarios) {
                                    if (listaPropietario.getId() == listaServicio.getIdPropietario()) {
                                        dueño = listaPropietario.getNombre();
                                    }
                                }
                            }catch(Exception e){
                                
                            }
                        }
                        servicios += "Servicio: "+listaServicio.getIdServicio()+" Valor: "+listaServicio.getValorServicio()+" Ingreso: "+listaServicio.getFechaIngreso()+" Salida: "+listaServicio.getFechaSalida()+" Ubicacion: "+listaServicio.getUbicacion()+" Propietario: "+dueño+"\n";
                    }
                }
                return vehiculo+servicios;
            }
        }
        return "No se encuentra el vehiculo con placa " + placa;
    }
}
