/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package baseDatos;

import java.sql.Connection;

/**
 *
 * @author alumnogreibd
 */
public class DAOEspecies extends AbstractDAO{
    public DAOEspecies (Connection conexion, aplicacion.FachadaAplicacion fa){
        super.setConexion(conexion); //Establecer a conexion
        super.setFachadaAplicacion(fa); //Establecer a fachada
    }
}
