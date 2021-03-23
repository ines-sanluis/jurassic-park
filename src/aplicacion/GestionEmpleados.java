/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion;

import elementos.Empleado;
import baseDatos.FachadaBaseDatos;
import gui.FachadaGui;

/**
 *
 * @author alumnogreibd
 */
public class GestionEmpleados {
    FachadaGui fgui;
    FachadaBaseDatos fbd;

    public GestionEmpleados(FachadaGui fgui, FachadaBaseDatos fbd) {
        this.fgui = fgui;
        this.fbd = fbd;
    }
      
    public boolean comprobarAutentificacion(String idUsuario, String clave){
      Empleado e = fbd.validarUsuario(idUsuario, clave);
      if(e != null) fgui.setTipoUser(e.getTipo()); //Entran todos os da tabla usuarios
      return e != null;
    }
}
