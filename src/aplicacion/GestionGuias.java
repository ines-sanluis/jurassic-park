/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion;

import baseDatos.FachadaBaseDatos;
import elementos.Empleado;
import gui.FachadaGui;
import java.util.List;

/**
 *
 * @author alumnogreibd
 */
public class GestionGuias {
    
    private FachadaGui fgui;
    private FachadaBaseDatos fbd;

    public GestionGuias(FachadaGui fgui, FachadaBaseDatos fbd) {
        this.fgui = fgui;
        this.fbd = fbd;
    }
    
    public List<Empleado> buscarEmpleado(String nombre, String actividad) {
        return fbd.buscarEmpleado(nombre, actividad);
    }
    
    public void asignarGuia(String id, String a) {
        fbd.asignarGuia(id, a);
    }
    
    public void desasignarGuia(String id, String a) {
        fbd.desasignarGuia(id, a);
    }
}
