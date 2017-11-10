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
public class Flexi extends Pasaje implements Reembolsable{
    
    private String silla; 

    public Flexi(String silla, int id, double valor, String pasajero, int tipo, int vuelo) {
        super(id, valor, pasajero, tipo, vuelo);
        this.silla = silla;
    }
    
    public String getSilla() {
        return silla;
    }

    public void setSilla(String silla) {
        this.silla = silla;
    }
    
    @Override
    public double calcularReembolso() {
        return super.getValor()-70;
    }
    
}
