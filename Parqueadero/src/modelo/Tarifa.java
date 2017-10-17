package modelo;

import java.time.LocalDate;
import java.time.LocalTime;

public class Tarifa {
    
    private int idTarifa;
    private int valorMinuto;
    private LocalDate fechaInicio;
    private LocalTime horaInicio;
    private LocalDate fechaExpira;
    private LocalTime horaExpira;
    private String tipoTarifa;

    public int getIdTarifa() {
        return idTarifa;
    }

    public void setIdTarifa(int idTarifa) {
        this.idTarifa = idTarifa;
    }

    public int getValorMinuto() {
        return valorMinuto;
    }

    public void setValorMinuto(int valorMinuto) {
        this.valorMinuto = valorMinuto;
    }

    public LocalDate getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(LocalDate fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public LocalTime getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(LocalTime horaInicio) {
        this.horaInicio = horaInicio;
    }

    public LocalDate getFechaExpira() {
        return fechaExpira;
    }

    public void setFechaExpira(LocalDate fechaExpira) {
        this.fechaExpira = fechaExpira;
    }

    public LocalTime getHoraExpira() {
        return horaExpira;
    }

    public void setHoraExpira(LocalTime horaExpira) {
        this.horaExpira = horaExpira;
    }

    public String getTipoTarifa() {
        return tipoTarifa;
    }

    public void setTipoTarifa(String tipoTarifa) {
        this.tipoTarifa = tipoTarifa;
    }
}
