/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion;

import elementos.Actividad;
import baseDatos.FachadaBaseDatos;
import gui.FachadaGui;
import java.util.List;

/**
 *
 * @author alumnogreibd
 */
public class GestionActividades {
    private FachadaGui fgui;
    private FachadaBaseDatos fbd;

    public GestionActividades(FachadaGui fgui, FachadaBaseDatos fbd) {
        this.fgui = fgui;
        this.fbd = fbd;
    }
    public List<Actividad> buscarActividades(String nombre) {
        return fbd.buscarActividades(nombre);
    }
    public void anhadirActividad(Actividad a) {
         fbd.anhadirActividad(a);
    }
    public void modificarActividad(Actividad a,String nombre) {
        fbd.modificarActividad(a,nombre);
    }

    public void borrarActividad(String nombre) {
        fbd.borrarActividad(nombre);
    }
}
