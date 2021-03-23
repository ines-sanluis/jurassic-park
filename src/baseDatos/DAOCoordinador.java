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
public class DAOCoordinador extends AbstractDAO {
    
    public DAOCoordinador (Connection conexion, FachadaAplicacion fa){
            super.setConexion(conexion); //Establecer a conexion
            super.setFachadaAplicacion(fa); //Establecer a fachada
        }
    
    public List<Empleado> buscarEmpleado (String nombre){
        Connection con;
        PreparedStatement stmActividad=null;
        ResultSet rs = null;
        con=super.getConexion();
        List<Empleado> empleados = new ArrayList();
        
        try {
            stmActividad=con.prepareStatement(" select * "+
                                                " from empleados where tipo = 'Guía' and nombre like ? ");
            stmActividad.setString(1, "%"+nombre+"%");
            
            rs = stmActividad.executeQuery();
            
            while (rs.next()) {
                //String id, String nombre, String zona, String dni, String tipo, Double sueldo, String telf
                empleados.add(new Empleado(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getDouble(6),rs.getString(7)));
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
}
