
package modelo;

import java.time.LocalDate;
import java.time.LocalTime;

public class Servicio {
    
    private int idServicio;
    private LocalDate fechaIngreso;
    private LocalTime horaIngreso;
    private LocalDate fechaSalida;
    private LocalTime horaSalida;
    private double valorServicio;
    private String placa;
    private int idPropietario;
    private int ubicacion;
    
    public Servicio() {

    }

    public Servicio(int id, LocalDate ldt,LocalTime lt, LocalDate ldt1, LocalTime lt1, double valorServicio, String placa, int idPropietario, int ubicacion) {
        this.idServicio = id;
        this.fechaIngreso = ldt;
        this.horaIngreso = lt;
        this.fechaSalida = ldt1;
        this.horaSalida = lt1;
        this.valorServicio = valorServicio;
        this.placa = placa;
        this.idPropietario = idPropietario;
        this.ubicacion = ubicacion;
    }

    public int getIdServicio() {
        return idServicio;
    }

    public void setIdServicio(int idServicio) {
        this.idServicio = idServicio;
    }

    public LocalDate getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(LocalDate fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public LocalTime getHoraIngreso() {
        return horaIngreso;
    }

    public void setHoraIngreso(LocalTime horaIngreso) {
        this.horaIngreso = horaIngreso;
    }

    public LocalDate getFechaSalida() {
        return fechaSalida;
    }

    public void setFechaSalida(LocalDate fechaSalida) {
        this.fechaSalida = fechaSalida;
    }

    public LocalTime getHoraSalida() {
        return horaSalida;
    }

    public void setHoraSalida(LocalTime horaSalida) {
        this.horaSalida = horaSalida;
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
