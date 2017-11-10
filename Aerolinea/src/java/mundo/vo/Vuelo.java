/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mundo.vo;

import java.sql.Date;
import java.util.ArrayList;

/**
 *
 * @author JEAV
 */
public class Vuelo {
    private int codigo;
    private String destino;
    private Date fecha;
    private int cantidad;
    private int disponiblesPromo;
    private int disponiblesEcono;
    private int disponiblesFlexi;
    private String img;
    private ArrayList<Pasaje> pasajes;

    public Vuelo(int codigo, Date fecha, int cantidad, int disponiblesPromo, int disponiblesEcono, int disponiblesFlexi, ArrayList<Pasaje> pasajes) {
        this.codigo = codigo;
        this.fecha = fecha;
        this.cantidad = cantidad;
        this.disponiblesPromo = disponiblesPromo;
        this.disponiblesEcono = disponiblesEcono;
        this.disponiblesFlexi = disponiblesFlexi;
        this.pasajes = pasajes;
    }

    public Vuelo() {
    }
    
    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }
    
    public ArrayList<Pasaje> getPasajes() {
        return pasajes;
    }

    public void setPasajes(ArrayList<Pasaje> pasajes) {
        this.pasajes = pasajes;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public int getDisponiblesPromo() {
        return disponiblesPromo;
    }

    public void setDisponiblesPromo(int disponiblesPromo) {
        this.disponiblesPromo = disponiblesPromo;
    }

    public int getDisponiblesEcono() {
        return disponiblesEcono;
    }

    public void setDisponiblesEcono(int disponiblesEcono) {
        this.disponiblesEcono = disponiblesEcono;
    }

    public int getDisponiblesFlexi() {
        return disponiblesFlexi;
    }

    public void setDisponiblesFlexi(int disponiblesFlexi) {
        this.disponiblesFlexi = disponiblesFlexi;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }
}
