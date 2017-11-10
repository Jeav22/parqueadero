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
public class Econo extends Pasaje implements Reembolsable{

    public Econo(int id, double valor, String pasajero, int tipo, int vuelo) {
        super(id, valor, pasajero, tipo, vuelo);
    }

    @Override
    public double calcularReembolso() {
        return super.getValor()-100;
    }
    
}
