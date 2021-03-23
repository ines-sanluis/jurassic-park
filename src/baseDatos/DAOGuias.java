package baseDatos;

import aplicacion.FachadaAplicacion;
import elementos.Actividad;
import elementos.Empleado;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author joaquin
 */
public class DAOGuias extends AbstractDAO {
    
    public DAOGuias (Connection conexion, FachadaAplicacion fa){
            super.setConexion(conexion); //Establecer a conexion
            super.setFachadaAplicacion(fa); //Establecer a fachada
        }
    
    public List<Empleado> buscarEmpleado (String nombre, String actividad){
        Connection con;
        PreparedStatement stmActividad=null;
        ResultSet rs = null;
        con=super.getConexion();
        List<Empleado> empleados = new ArrayList();
        
        try {
            stmActividad=con.prepareStatement(" select e.id, e.nombre, e.zona, e.dni "+
                                                " from empleados as e where tipo = 'Guía' and nombre like ? "+
                                                " and e.id not in (select coordinador from coordinarActividad where actividad = ?) ");
            stmActividad.setString(1, "%"+nombre+"%");
            stmActividad.setString(2, actividad);
            
            rs = stmActividad.executeQuery();
            
            while (rs.next()) {
                //String id, String nombre, String zona, String dni, String tipo, Double sueldo, String telf
                empleados.add(new Empleado(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),null,null,null));
            }
            
       } catch (SQLException e){
          System.out.println(e.getMessage());
          this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
        }
               finally{
          try {stmActividad.close();} catch (SQLException e){System.out.println("Imposible cerrar cursores");}
        }
        return empleados;
   }
    
    public void asignarGuia(String idGuia, String nombreActividad) {
        Connection con;
        PreparedStatement stmAsignar=null;
        ResultSet rs = null;
        con=super.getConexion();
        List<Empleado> empleados = new ArrayList();
        
        try {
            stmAsignar=con.prepareStatement(" insert into coordinarActividad values (?,?) on conflict do nothing ");
            stmAsignar.setString(1, nombreActividad);
            stmAsignar.setString(2, idGuia);
            
            stmAsignar.executeUpdate();     
            
       } catch (SQLException e){
          System.out.println(e.getMessage());
          this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
        }
               finally{
          try {stmAsignar.close();} catch (SQLException e){System.out.println("Imposible cerrar cursores");}
        }
    }
    
    public void desasignarGuia(String idGuia, String nombreActividad) {
        Connection con;
        PreparedStatement stmAsignar=null;
        ResultSet rs = null;
        con=super.getConexion();
        List<Empleado> empleados = new ArrayList();
        
        try {
            stmAsignar=con.prepareStatement(" delete from coordinarActividad where coordinador=? and actividad=? ");
            stmAsignar.setString(1, idGuia);
            stmAsignar.setString(2, nombreActividad);
            
            stmAsignar.executeUpdate();     
            
       } catch (SQLException e){
          System.out.println(e.getMessage());
          this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
        }
               finally{
          try {stmAsignar.close();} catch (SQLException e){System.out.println("Imposible cerrar cursores");}
        }
    }

}
