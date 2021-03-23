/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package baseDatos;

import aplicacion.FachadaAplicacion;
import java.sql.Connection;

/**
 *
 * @author alumnogreibd
 */
public class DAOPedidos extends AbstractDAO{
    public DAOPedidos (Connection conexion, FachadaAplicacion fa){
        super.setConexion(conexion); //Establecer a conexion
        super.setFachadaAplicacion(fa); //Establecer a fachada
    } 
}
