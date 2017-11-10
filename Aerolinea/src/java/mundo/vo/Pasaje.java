/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mundo.vo;

/**
 *
 * @author JEAV
 */
public class Pasaje{
    private int id;
    private Double valor;
    private String pasajero;
    private int tipo;
    private int vuelo; 
    
    public Pasaje(){
    
    }
    
    public Pasaje(int id, Double valor, String pasajero, int tipo, int vuelo) {
        this.id = id;
        this.valor = valor;
        this.pasajero = pasajero;
        this.tipo = tipo;
        this.vuelo = vuelo;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public String getPasajero() {
        return pasajero;
    }

    public void setPasajero(String pasajero) {
        this.pasajero = pasajero;
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    public int getVuelo() {
        return vuelo;
    }

    public void setVuelo(int vuelo) {
        this.vuelo = vuelo;
    }
}
