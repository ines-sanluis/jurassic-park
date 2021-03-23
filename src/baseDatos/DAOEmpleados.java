/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package baseDatos;

import elementos.Empleado;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author alumnogreibd
 */
public class DAOEmpleados extends AbstractDAO{
        
    public DAOEmpleados (Connection conexion, aplicacion.FachadaAplicacion fa){
        super.setConexion(conexion); //Establecer a conexion
        super.setFachadaAplicacion(fa); //Establecer a fachada
    }
    
    /*public static String MD5(String md5) {
        try {
             java.security.MessageDigest md = java.security.MessageDigest.getInstance("MD5");
             byte[] array = md.digest(md5.getBytes());
             StringBuffer sb = new StringBuffer();
             for (int i = 0; i < array.length; ++i) {
               sb.append(Integer.toHexString((array[i] & 0xFF) | 0x100).substring(1,3));
            }
             return sb.toString();
         } catch (java.security.NoSuchAlgorithmException e) {
             
         }
         return null;
}*/
    
    public Empleado validarUsuario(String idUsuario, String clave){
        Empleado resultado=null;
        Connection con;
        PreparedStatement stmUsuario=null;
        ResultSet rsUsuario;
        con=this.getConexion();
        
        //String claveHash = MD5(clave);       
        try {
           stmUsuario=con.prepareStatement("select id, nombre, zona, dni, sueldo, telefono, tipo "+
                                            "from empleados e JOIN usuarios u USING(id)"+
                                            "where username = ? and clave = crypt(?, u.clave)");
            stmUsuario.setString(1, idUsuario);
            stmUsuario.setString(2, clave);
            rsUsuario=stmUsuario.executeQuery();
            if (rsUsuario.next()){
                resultado = new Empleado (rsUsuario.getString("id"), rsUsuario.getString("nombre"),
                                        rsUsuario.getString("zona"), rsUsuario.getString("dni"),
                                        rsUsuario.getString("tipo"), rsUsuario.getDouble("sueldo"), 
                                        rsUsuario.getString("telefono"));
                }
        } catch (SQLException e){
          System.out.println(e.getMessage());
          this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
        }finally{
          try {stmUsuario.close();} catch (SQLException e){System.out.println("Imposible cerrar cursores");}
        }
        return resultado;
    }
    
}
