/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package baseDatos;

import elementos.Dinosaurio;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author alumnogreibd
 */
public class DAODinosaurios extends AbstractDAO{
    public DAODinosaurios (Connection conexion, aplicacion.FachadaAplicacion fa){
        super.setConexion(conexion); //Establecer a conexion
        super.setFachadaAplicacion(fa); //Establecer a fachada
    }
    
     public Dinosaurio obtenerDinoVivo(String nombre) {
        Dinosaurio resultado = null;
        Connection con;
        PreparedStatement stmDino = null;
        ResultSet rsDino;
        con=this.getConexion();
        try {
            stmDino = con.prepareStatement("select * from dinosaurios where nombre=?");
            stmDino.setString(1, nombre);
            rsDino = stmDino.executeQuery();
            if(rsDino.next()){
                resultado = new Dinosaurio(rsDino.getString("id"), rsDino.getString("nombre"),
                                           rsDino.getString("especie"), rsDino.getString("dieta"),
                                           rsDino.getString("zona"), rsDino.getString("fechaLlegada"),
                                           rsDino.getString("estado"), rsDino.getInt("unidades"),
                                           rsDino.getString("cuidador"), rsDino.getString("veterinario")
                                          );
            }
        }catch (SQLException e){
          System.out.println(e.getMessage());
          this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
        }finally{
          try {stmDino.close(); } catch (SQLException e){System.out.println("Imposible cerrar cursores");}
        }
        return resultado;
    }
}
