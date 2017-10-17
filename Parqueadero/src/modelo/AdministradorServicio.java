package modelo;

import BaseDatos.IBaseDatos;
import BaseDatos.ServicioDao;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class AdministradorServicio {

    private IBaseDatos mServicio;
    private IBaseDatos mTarifa;
    private IBaseDatos mPropietario;
    private IBaseDatos mLugarParqueo;

    public AdministradorServicio(IBaseDatos mServicio, IBaseDatos mTarifa, IBaseDatos mPropietario, IBaseDatos mLugarParqueo) {
        this.mServicio = new ServicioDao();
        this.mTarifa = mTarifa;
        this.mPropietario = mPropietario;
        this.mLugarParqueo = mLugarParqueo;
    }

    public boolean CrearServicio(LocalDate fechaIngreso, LocalTime horaIngreso, String placa, int ubicacion) {
        Servicio s = new Servicio();
        s.setFechaIngreso(fechaIngreso);
        s.setHoraIngreso(horaIngreso);
        s.setPlaca(placa);
        s.setUbicacion(ubicacion);
        s.setIdPropietario(-1);
        return mServicio.insert(s);
    }

    public double liquidarServicio(LocalDate fechaSalida, String placa, String correo) {
        List<Tarifa> tarifas = mTarifa.findAll();
        List<Servicio> servicios = mServicio.findAll();
        List<Propietario> propietarios = mPropietario.findAll();
        List<LugarParqueo> ubicaciones = mLugarParqueo.findAll();
        double valor = 0;
        try {
            for (Servicio servicio : servicios) {
                if (servicio.getPlaca().equalsIgnoreCase(placa) && servicio.getFechaSalida().equals(null)) {
                    for (Tarifa tarifa : tarifas) {
                        if (servicio.getFechaIngreso().isAfter(tarifa.getFechaInicio()) || fechaSalida.isBefore(tarifa.getFechaExpira())) {
                            //long time[] = getTime(servicio.getFechaIngreso(), tarifa.getFechaExpira());
                            //System.out.println(time[0] + ":" + time[1]);
                            //valor += tarifa.getValorMinuto() * (time[0] * 60) + tarifa.getValorMinuto() * (time[1]);
                        }
                    }
                    for (LugarParqueo ubicacion : ubicaciones) {
                        if (ubicacion.getIdLugarParqueo() == servicio.getUbicacion()) {
                            ubicacion.setEstadoLugarParqueo(1);
                            mLugarParqueo.update(ubicacion);
                        }
                    }
                    if (correo.equals("Anonimo")) {
                        servicio.setIdPropietario(-1);
                    } else {
                        for (Propietario propietario : propietarios) {
                            if (correo.equalsIgnoreCase(propietario.getCorreo())) {
                                servicio.setIdPropietario(propietario.getId());
                            }
                        }
                    }
                    servicio.setFechaSalida(fechaSalida);
                    servicio.setValorServicio(valor);

                    mServicio.update(servicio);
                }
            }
        } catch (Exception e) {

        }
        return valor;
    }

    public List<String> listarServicios(LocalDate fecha) {
        List<String> servicios = new ArrayList<>();
        List<Servicio> listaServicios = mServicio.findAll();
        List<Propietario> listaPropietarios = mPropietario.findAll();
        try {
            for (Servicio listaServicio : listaServicios) {
                if (listaServicio.getFechaIngreso().isEqual(fecha) || listaServicio.getFechaSalida().isEqual(fecha)) {
                    String dueño = null;
                    if (listaServicio.getIdPropietario() == -1) {
                        dueño = "Anonimo";
                    } else {
                        for (Propietario listaPropietario : listaPropietarios) {
                            if (listaPropietario.getId() == listaServicio.getIdPropietario()) {
                                dueño = listaPropietario.getNombre();
                            }
                        }
                    }
                    String s = "Servicio: " + listaServicio.getIdServicio() + " Placa: " + listaServicio.getPlaca() + " Valor: " + listaServicio.getValorServicio() + " Ingreso: " + listaServicio.getFechaIngreso()+" "+listaServicio.getHoraIngreso()+" Salida: " + listaServicio.getFechaSalida()+" "+listaServicio.getHoraSalida()+" Ubicacion: " + listaServicio.getUbicacion() + " Propietario: " + dueño + "\n";
                    servicios.add(s);
                }
            }
        } catch (Exception e) {
            if (servicios.isEmpty()) {
                servicios.add("No se encontraron resultados para " + fecha);
            }
        }
        return servicios;
    }

    public String obtenerDatosServicio(int id) {
        String servicio = null;
        List<Servicio> listaServicios = mServicio.findAll();
        List<Propietario> listaPropietarios = mPropietario.findAll();

        for (Servicio listaServicio : listaServicios) {
            if (listaServicio.getIdServicio() == id) {
                String dueño = null;
                if (listaServicio.getIdPropietario() == -1) {
                    dueño = "Anonimo";
                } else {
                    for (Propietario listaPropietario : listaPropietarios) {
                        if (listaPropietario.getId() == listaServicio.getIdPropietario()) {
                            dueño = listaPropietario.getNombre();
                        }
                    }
                }
                servicio = "Servicio: " + listaServicio.getIdServicio() + " Valor: " + listaServicio.getValorServicio() + " Ingreso: " + listaServicio.getFechaIngreso() + " Salida: " + listaServicio.getFechaSalida() + " Ubicacion: " + listaServicio.getUbicacion() + " Propietario: " + dueño + "\n";
            }
        }
        return servicio;
    }

    public String obtenerLugarParqueo(String placa) {
        String respuesta = null;
        List<Servicio> listaServicios = mServicio.findAll();

        for (Servicio listaServicio : listaServicios) {
            if (listaServicio.getPlaca().equalsIgnoreCase(placa) && listaServicio.getValorServicio() == 0.0) {
                respuesta = "El vehiculo con placa " + placa + " se encuentra en " + listaServicio.getUbicacion();
            }
        }

        return respuesta;
    }
}
