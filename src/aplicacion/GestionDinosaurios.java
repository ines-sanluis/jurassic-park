/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion;

import baseDatos.FachadaBaseDatos;
import elementos.Dinosaurio;
import gui.FachadaGui;

/**
 *
 * @author alumnogreibd
 */
public class GestionDinosaurios {
    FachadaGui fgui;
    FachadaBaseDatos fbd;

    public GestionDinosaurios(FachadaGui fgui, FachadaBaseDatos fbd) {
        this.fgui = fgui;
        this.fbd = fbd;
    }
    
     public Dinosaurio obtenerDinoVivo(String nombre) {
        return fbd.obtenerDinoVivo(nombre);
     }
}
