package modelo;

import BaseDatos.IBaseDatos;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class AdministradorTarifa {
    
    private IBaseDatos mTarifa;

    public AdministradorTarifa(IBaseDatos mTarifa) {
        this.mTarifa = mTarifa;
    }
    
    public boolean crearTarifa(LocalDate inicio, LocalTime hInicio, LocalDate expira, LocalTime hExpira, int valor, String tipo){
        Tarifa t = new Tarifa();
        t.setFechaInicio(inicio);
        t.setHoraInicio(hInicio);
        t.setFechaExpira(expira);
        t.setHoraExpira(hExpira);
        t.setValorMinuto(valor);
        t.setTipoTarifa(tipo);
        mTarifa.insert(t);
        return true;
    }
    
    public List<String> listarTarifas(){
        List<String> tarifas = new ArrayList<>();
        List<Tarifa> listaTarifas = mTarifa.findAll();
        
        for (Tarifa listaTarifa : listaTarifas) {
            String t = "Tarifa: "+listaTarifa.getIdTarifa()+" Valor Minuto: $"+listaTarifa.getValorMinuto()+" Duracion: "+listaTarifa.getFechaInicio()+" - "+listaTarifa.getFechaExpira()+" Tipo: "+listaTarifa.getTipoTarifa();
            tarifas.add(t);
        }
        
        return tarifas;
    }
    
    public String obtenerDatosTarifa(int id){
        List<Tarifa> listaTarifas = mTarifa.findAll();
        
        for (Tarifa listaTarifa : listaTarifas) {
            if (listaTarifa.getIdTarifa() == id) {
                return "Tarifa: "+listaTarifa.getIdTarifa()+" Valor Minuto: $"+listaTarifa.getValorMinuto()+" Duracion: "+listaTarifa.getFechaInicio()+" - "+listaTarifa.getFechaExpira()+" Tipo: "+listaTarifa.getTipoTarifa();
            }
        }
        
        return "No se encuentra la tarifa "+id;
    }
}
