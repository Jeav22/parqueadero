package modelo;

import java.time.LocalDateTime;

public class Tarifa {
    
    private int idTarifa;
    private int valorMinuto;
    private LocalDateTime fechaInicio;
    private LocalDateTime fechaExpira;
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

    public LocalDateTime getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(LocalDateTime fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public LocalDateTime getFechaExpira() {
        return fechaExpira;
    }

    public void setFechaExpira(LocalDateTime fechaExpira) {
        this.fechaExpira = fechaExpira;
    }

    public String getTipoTarifa() {
        return tipoTarifa;
    }

    public void setTipoTarifa(String tipoTarifa) {
        this.tipoTarifa = tipoTarifa;
    }
}
