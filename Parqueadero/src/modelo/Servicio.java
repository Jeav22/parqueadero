
package modelo;

import java.time.LocalDateTime;

public class Servicio {
    
    private int idServicio;
    private LocalDateTime fechaIngreso;
    private LocalDateTime fechaSalida;
    private double valorServicio;
    private String placa;
    private int idPropietario;
    private int ubicacion;
    
  
    public Servicio(int id, LocalDateTime ldt, LocalDateTime ldt1, double valorServicio, String placa, int idPropietario, int ubicacion) {
        this.idServicio = id;
        this.fechaIngreso = ldt;
        this.fechaSalida = ldt1;
        this.valorServicio = valorServicio;
        this.placa = placa;
        this.idPropietario = idPropietario;
        this.ubicacion = ubicacion;
    }

    public Servicio() {

    }

    public int getIdServicio() {
        return idServicio;
    }

    public void setIdServicio(int idServicio) {
        this.idServicio = idServicio;
    }

    public LocalDateTime getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(LocalDateTime fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public LocalDateTime getFechaSalida() {
        return fechaSalida;
    }

    public void setFechaSalida(LocalDateTime fechaSalida) {
        this.fechaSalida = fechaSalida;
    }

    public double getValorServicio() {
        return valorServicio;
    }

    public void setValorServicio(double valorServicio) {
        this.valorServicio = valorServicio;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public int getIdPropietario() {
        return idPropietario;
    }

    public void setIdPropietario(int idPropietario) {
        this.idPropietario = idPropietario;
    }

    public int getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(int ubicacion) {
        this.ubicacion = ubicacion;
    }

}
