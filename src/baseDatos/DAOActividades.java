/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package baseDatos;

import elementos.Actividad;
import aplicacion.FachadaAplicacion;
import elementos.Empleado;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author alumnogreibd
 */
public class DAOActividades extends AbstractDAO{
    
    public DAOActividades (Connection conexion, FachadaAplicacion fa){
        super.setConexion(conexion); //Establecer a conexion
        super.setFachadaAplicacion(fa); //Establecer a fachada
    }
    
     public List<Actividad> buscarActividades(String nombre){
        ArrayList<Actividad> resultado = new ArrayList();
        Connection con;
        PreparedStatement stmActividad=null;
        PreparedStatement stmGuias = null;
        ResultSet rsActividad;
        con=this.getConexion();
/*select a.*, e.id, e.nombre
from actividades a left join coordinarActividad c on a.nombre = c.actividad, empleados e
where e.id = c.coordinador*/
        try {
            con.setAutoCommit(false);
            
        /*stmActividad=con.prepareStatement("select a.*, e.id, e.nombre nombreC "+
                                        " from actividades a left join coordinarActividad c on a.nombre = c.actividad left join empleados e on e.id = c.coordinador "+
                                        " where a.nombre like ? ");*/
        stmActividad = con.prepareStatement(" select * from actividades where nombre like ? ");
        stmActividad.setString(1, "%"+nombre+"%");
        rsActividad=stmActividad.executeQuery();
        while (rsActividad.next()) {
            String idActividad = rsActividad.getString("nombre");
            
            stmGuias = con.prepareStatement(" select e.* from coordinarActividad c join empleados e on c.coordinador = e.id "+
                                                                " where c.actividad = ? ");
            stmGuias.setString(1, idActividad);
            ResultSet rsGuias = stmGuias.executeQuery();
            ArrayList<Empleado> guias = new ArrayList<Empleado>();
            while (rsGuias.next()) {
                
            guias.add(new Empleado(rsGuias.getString("id"), rsGuias.getString("nombre")));
            //guias.add(new Empleado(rsGuias.getString("id"),rsGuias.getString("nombre"),rsGuias.getString("zona"),rsGuias.getString("dni"),rsGuias.getString("tipo"),rsGuias.getDouble("sueldo"),rsGuias.getString("telefono")));
            }
            
            resultado.add(new Actividad(rsActividad.getString("nombre"), rsActividad.getString("descripcion"),
                                      rsActividad.getString("zona"), rsActividad.getFloat("precio"),
                                      rsActividad.getString("peligrosidad"),rsActividad.getInt("participantes"), guias));
        }
        } catch (SQLException e){
          System.out.println(e.getMessage());
          this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
        }finally{
          try {
                if (stmActividad != null)
                    stmActividad.close();
                if (stmGuias != null)
                    stmGuias.close();
                con.commit();
                con.setAutoCommit(true);} catch (SQLException e){System.out.println("Imposible cerrar cursores");}
        }
        return resultado;
    }
     
     
     public void anhadirActividad (Actividad actividad){
        Connection con;
        PreparedStatement stmActividad=null;
      
        con=super.getConexion();

        try {
            stmActividad=con.prepareStatement("insert into actividades(nombre, descripcion, zona, precio, peligrosidad, participantes) "+
                                          "values (?,?,?,?,?,?) on conflict do nothing");
            stmActividad.setString(1, actividad.getNombre());
            stmActividad.setString(2, actividad.getDescripcion());
            stmActividad.setString(3, actividad.getZona());
            stmActividad.setFloat(4, actividad.getPrecio());
            stmActividad.setString(5, actividad.getPeligrosidad());
            stmActividad.setInt(6, actividad.getParticipantes());

            stmActividad.executeUpdate();
      
       } catch (SQLException e){
          System.out.println(e.getMessage());
          this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
        }
               finally{
          try {stmActividad.close();} catch (SQLException e){System.out.println("Imposible cerrar cursores");}
        }

   }
     
   
   public void modificarActividad(Actividad actividad, String nombre){
        Connection con;
        PreparedStatement stmActividad=null;
        con=super.getConexion();

        try {
        stmActividad=con.prepareStatement("update actividades "+
                                    "set nombre=?, "+
                                    "    descripcion=?, "+
                                    "    zona=?, "+
                                    "    precio=?, "+
                                    "    peligrosidad=?,"+
                                    "    participantes=? "+
                                    "where nombre=? ");
        stmActividad.setString(1, actividad.getNombre());
        stmActividad.setString(2, actividad.getDescripcion());
        stmActividad.setString(3, actividad.getZona());
        stmActividad.setFloat(4, actividad.getPrecio());
        stmActividad.setString(5,actividad.getPeligrosidad());
        stmActividad.setInt(6, actividad.getParticipantes());
        stmActividad.setString(7, nombre);
        stmActividad.executeUpdate();



        } catch (SQLException e){
          System.out.println(e.getMessage());
          this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
        }finally{
          try {stmActividad.close();} catch (SQLException e){System.out.println("Imposible cerrar cursores");}
        }
    }
     
    public void borrarActividad(String nombre){
        Connection con;
        PreparedStatement stmActividad=null;

        con=super.getConexion();

        try {
        stmActividad=con.prepareStatement("delete from actividades where nombre = ?");
        stmActividad.setString(1, nombre);
        stmActividad.executeUpdate();

        } catch (SQLException e){
          System.out.println(e.getMessage());
          this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
        }finally{
          try {stmActividad.close();} catch (SQLException e){System.out.println("Imposible cerrar cursores");}
        }
    }
}
