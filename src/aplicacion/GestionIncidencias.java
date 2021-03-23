/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion;

import elementos.Incidencia;
import baseDatos.FachadaBaseDatos;
import elementos.Victima;
import gui.FachadaGui;
import java.util.List;

/**
 *
 * @author alumnogreibd
 */
public class GestionIncidencias {
    private final FachadaGui fgui;
    private final FachadaBaseDatos fbd;

    public GestionIncidencias(FachadaGui fgui, FachadaBaseDatos fbd) {
        this.fgui = fgui;
        this.fbd = fbd;
    }

    public List<Incidencia> obtenerIncidencias(int dias, String tag) {
        return fbd.obtenerIncidencias(dias, tag);
    }

    public void borrarIncidencia(Incidencia i) {
        fbd.borrarIncidencia(i);
    }

    public void modificarIncidencia(Incidencia i) {
        fbd.modificarIncidencia(i);
    }

    public void insertarIncidencia(Incidencia i) {
        fbd.insertarIncidencia(i);
    }

    public boolean existeIncidencia(Incidencia i){
        return fbd.existeIncidencia(i);
    }
    
    public void anhadirVictima(Victima v) {
        fbd.anhadirVictima(v);
    }
    
    public void borrarVictima(Victima v) {
        fbd.borrarVictima(v);
    }
    
    public boolean existeVictima(Victima v) {
        return fbd.existeVictima(v);
    }
}
