
package modelo;

import BaseDatos.IBaseDatos;
import java.util.List;

public class AdministradorLugarParqueo {
    
    private IBaseDatos mLugarParqueo;

    public AdministradorLugarParqueo(IBaseDatos mLugarParqueo) {
        this.mLugarParqueo = mLugarParqueo;
    }
    
    public boolean actualizarEstadoLugarParqueo(int idLugarParqueo, int estado){
        List<LugarParqueo> listaLugarParqueos = mLugarParqueo.findAll();
        for (int i = 0; i < listaLugarParqueos.size(); i++) {
            LugarParqueo listaLugarParqueo = listaLugarParqueos.get(i);
            if (listaLugarParqueo.getIdLugarParqueo() == idLugarParqueo) {
                listaLugarParqueo.setEstadoLugarParqueo(estado);
                return mLugarParqueo.update(listaLugarParqueo);
            }
        }
        return false;
    }
    
    public int consultarEstadoLugarParqueo(int idLugarParqueo){
        List<LugarParqueo> listaLugarParqueos = mLugarParqueo.findAll();

        for (LugarParqueo listaLugarParqueo : listaLugarParqueos) {
            if (listaLugarParqueo.getIdLugarParqueo() == idLugarParqueo) {
                return listaLugarParqueo.getEstadoLugarParqueo();
            }
        }
        return -1;
    }
    
    public String obtenerTipoLugarParqueo(int idLugarParqueo){
        List<LugarParqueo> listaLugarParqueos = mLugarParqueo.findAll();

        for (LugarParqueo listaLugarParqueo : listaLugarParqueos) {
            if (listaLugarParqueo.getIdLugarParqueo() == idLugarParqueo) {
                return listaLugarParqueo.getTipoLugarParqueo();
            }
        }
        return "Lugar "+idLugarParqueo+" no encontrado";
    }
    
    public boolean modificarTipoLugarParqueo(int idLugarParqueo, String tipo){
        List<LugarParqueo> listaLugarParqueos = mLugarParqueo.findAll();

        for (LugarParqueo listaLugarParqueo : listaLugarParqueos) {
            if (listaLugarParqueo.getIdLugarParqueo() == idLugarParqueo) {
                listaLugarParqueo.setTipoLugarParqueo(tipo);
                return mLugarParqueo.update(listaLugarParqueo);
            }
        }
        return false;
    }
}