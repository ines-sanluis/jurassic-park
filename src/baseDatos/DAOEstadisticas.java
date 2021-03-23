package baseDatos;

import aplicacion.FachadaAplicacion;
import java.sql.*;
import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author alumnogreibd
 */
public class DAOEstadisticas extends AbstractDAO{
    
    public DAOEstadisticas (Connection conexion, FachadaAplicacion fa){
        super.setConexion(conexion); //Establecer a conexion
        super.setFachadaAplicacion(fa); //Establecer a fachada
    }
    
    public Integer numeroDinosVivos(){
        Integer resultado = 0;
        Connection con;
        PreparedStatement stmDinos=null;
        ResultSet rsDinos;
        con=this.getConexion();
        try {
            stmDinos = con.prepareStatement("select count(*) from dinosaurios");
            rsDinos = stmDinos.executeQuery();
            if (rsDinos.next()){resultado = rsDinos.getInt("count"); }
        } catch (SQLException e){
          System.out.println(e.getMessage());
          this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
        }finally{
          try {stmDinos.close();} catch (SQLException e){System.out.println("Imposible cerrar cursores");}
        }
        return resultado;
    }
    
    public Integer numeroDinosMuertos(){
        Integer resultado = 0;
        Connection con;
        PreparedStatement stmDinos=null;
        ResultSet rsDinos;
        con=this.getConexion();
        try {
            stmDinos = con.prepareStatement("select count(*) from dmuertos");
            rsDinos = stmDinos.executeQuery();
            if (rsDinos.next()){resultado = rsDinos.getInt("count"); }
        } catch (SQLException e){
          System.out.println(e.getMessage());
          this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
        }finally{
          try {stmDinos.close();} catch (SQLException e){System.out.println("Imposible cerrar cursores");}
        }
        return resultado;
    }
    
    public Integer mediaDiasDinos(){
        Integer resultado = 0;
        Connection con;
        PreparedStatement stmDinos=null;
        ResultSet rsDinos;
        con=this.getConexion();
        try {
            stmDinos = con.prepareStatement("select avg(fechamuerte-fechallegada) as media from dmuertos");
            rsDinos = stmDinos.executeQuery();
            if (rsDinos.next()){resultado = rsDinos.getInt("media"); }
        } catch (SQLException e){
          System.out.println(e.getMessage());
          this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
        }finally{
          try {stmDinos.close();} catch (SQLException e){System.out.println("Imposible cerrar cursores");}
        }
        return resultado;
    }
    
    //Obtener el dinosaurio que se ha visto implicado en mas incidencias
    public java.util.List<String> dinoConflictivo(){
        java.util.List<String> resultado = new java.util.ArrayList<String>();
        Connection con;
        PreparedStatement stmDinos=null;
        ResultSet rsDinos;
        con=this.getConexion();
        try {
            stmDinos = con.prepareStatement("select d.nombre " +
                                            "from incidencias i, dinosaurios d where responsable = d.id " +
                                            "group by responsable, d.nombre " +
                                            "having count(*) >= " +
                                            "(select count(*) as c " +
                                            " from incidencias group by responsable order by c desc limit 1)");
            rsDinos = stmDinos.executeQuery();
            while (rsDinos.next()){resultado.add(rsDinos.getString("nombre"));}
        } catch (SQLException e){
          System.out.println(e.getMessage());
          this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
        }finally{
          try {stmDinos.close();} catch (SQLException e){System.out.println("Imposible cerrar cursores");}
        }
        return resultado;
    }
    
    public Integer numeroIncidencias(){
        Integer resultado = 0;
        Connection con;
        PreparedStatement stmIncidencia=null;
        ResultSet rsIncidencia;
        con=this.getConexion();
        try {
            stmIncidencia = con.prepareStatement("select count(*) from incidencias");
            rsIncidencia = stmIncidencia.executeQuery();
            if (rsIncidencia.next()){resultado = rsIncidencia.getInt("count"); }
        } catch (SQLException e){
          System.out.println(e.getMessage());
          this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
        }finally{
          try {stmIncidencia.close();} catch (SQLException e){System.out.println("Imposible cerrar cursores");}
        }
        return resultado;
    }
    
    public Integer numeroIncidenciasMortales(){
        Integer resultado = 0;
        Connection con;
        PreparedStatement stmIncidencia=null;
        ResultSet rsIncidencia;
        con=this.getConexion();
        try {
            stmIncidencia = con.prepareStatement("select count(*) from incidencias where descripcion like '%#muerte%'");
            rsIncidencia = stmIncidencia.executeQuery();
            if (rsIncidencia.next()){resultado = rsIncidencia.getInt("count"); }
        } catch (SQLException e){
          System.out.println(e.getMessage());
          this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
        }finally{
          try {stmIncidencia.close();} catch (SQLException e){System.out.println("Imposible cerrar cursores");}
        }
        return resultado;
    }
    
    public Integer diasUltimaIncidencia(){
        Integer resultado = 0;
        Connection con;
        PreparedStatement stmIncidencia=null;
        ResultSet rsIncidencia;
        con=this.getConexion();
        try {
            stmIncidencia = con.prepareStatement("select current_date - max(fecha) as dias from incidencias");
            rsIncidencia = stmIncidencia.executeQuery();
            if (rsIncidencia.next()){ resultado = rsIncidencia.getInt("dias");}
        } catch (SQLException e){
          System.out.println(e.getMessage());
          this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
        }finally{
          try {stmIncidencia.close();} catch (SQLException e){System.out.println("Imposible cerrar cursores");}
        }
        return resultado;
    }
    
    public double gastoMedioEmpleado(){
        double resultado = 0.0;
        Connection con;
        PreparedStatement stmIncidencia=null;
        ResultSet rsIncidencia;
        con=this.getConexion();
        try {
            stmIncidencia = con.prepareStatement("select avg(sueldo) as media from empleados");
            rsIncidencia = stmIncidencia.executeQuery();
            if (rsIncidencia.next()){ resultado = rsIncidencia.getDouble("media");}
        } catch (SQLException e){
          System.out.println(e.getMessage());
          this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
        }finally{
          try {stmIncidencia.close();} catch (SQLException e){System.out.println("Imposible cerrar cursores");}
        }
        return resultado;
    }
    
    public Integer numeroEspecies(){
        Integer resultado = 0;
        Connection con;
        PreparedStatement stmEspecie=null;
        ResultSet rsEspecie;
        con=this.getConexion();
        try {
            stmEspecie = con.prepareStatement("select count(*) from especies");
            rsEspecie = stmEspecie.executeQuery();
            if (rsEspecie.next()){resultado = rsEspecie.getInt("count"); }
        } catch (SQLException e){
          System.out.println(e.getMessage());
          this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
        }finally{
          try {stmEspecie.close();} catch (SQLException e){System.out.println("Imposible cerrar cursores");}
        }
        return resultado;
    }
    
    public List<String> dietaComun(){
        java.util.List<String> resultado = new java.util.ArrayList<String>();
        Connection con;
        PreparedStatement stmDieta=null;
        ResultSet rsDieta;
        con=this.getConexion();
        try {
            stmDieta = con.prepareStatement("select dieta " +
                                            "from dinosaurios " +
                                            "group by dieta " +
                                            "having count(*) >= " +
                                            "(select count(*) as c " +
                                            " from dinosaurios group by dieta order by c desc limit 1)");
            rsDieta = stmDieta.executeQuery();
            while (rsDieta.next()){resultado.add(rsDieta.getString("dieta"));}
        } catch (SQLException e){
          System.out.println(e.getMessage());
          this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
        }finally{
          try {stmDieta.close();} catch (SQLException e){System.out.println("Imposible cerrar cursores");}
        }
        return resultado;
    }
    
    public Integer empleadosMejorSueldo(){
        Integer resultado = 0;
        Connection con;
        PreparedStatement stmEmpleados=null;
        ResultSet rsEmpleados;
        con=this.getConexion();
        try {
            stmEmpleados = con.prepareStatement("select count(*) \n" +
                                                "from empleados\n" +
                                                "where sueldo > (select avg(e.sueldo) from empleados as e)");
            rsEmpleados = stmEmpleados.executeQuery();
            if (rsEmpleados.next()){resultado = rsEmpleados.getInt("count"); }
        } catch (SQLException e){
          System.out.println(e.getMessage());
          this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
        }finally{
          try {stmEmpleados.close();} catch (SQLException e){System.out.println("Imposible cerrar cursores");}
        }
        return resultado;  
    }
    
    public Integer sueldoMedio(){
        Integer resultado = 0;
        Connection con;
        PreparedStatement stmEmpleados=null;
        ResultSet rsEmpleados;
        con=this.getConexion();
        try {
            stmEmpleados = con.prepareStatement("select avg(e.sueldo) from empleados as e");
            rsEmpleados = stmEmpleados.executeQuery();
            if (rsEmpleados.next()){resultado = rsEmpleados.getInt("avg"); }
        } catch (SQLException e){
          System.out.println(e.getMessage());
          this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
        }finally{
          try {stmEmpleados.close();} catch (SQLException e){System.out.println("Imposible cerrar cursores");}
        }
        return resultado;  
    }
    
    public String guiaMasActividades(){
        String resultado = null;
        Connection con;
        PreparedStatement stmActividades=null;
        ResultSet rsActividades;
        con=this.getConexion();
        try {
            stmActividades = con.prepareStatement("select e.nombre, count(c.coordinador) as num\n" +
                                                "from coordinaractividad c, empleados e\n" +
                                                "where c.coordinador = e.id\n" +
                                                "group by e.nombre\n" +
                                                "order by num desc limit 1");
            rsActividades = stmActividades.executeQuery();
            if (rsActividades.next()){resultado = rsActividades.getString("nombre"); }
        } catch (SQLException e){
          System.out.println(e.getMessage());
          this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
        }finally{
          try {stmActividades.close();} catch (SQLException e){System.out.println("Imposible cerrar cursores");}
        }
        return resultado;  
    }
    
    public Integer anhoMasIncidencias(){
        Integer resultado = 0;
        Connection con;
        PreparedStatement stmIncidencias=null;
        ResultSet rsIncidencias;
        con=this.getConexion();
        try {
            stmIncidencias = con.prepareStatement("select extract (year from fecha) as anho, count(extract (year from fecha)) as num\n" +
                                                    "from incidencias\n" +
                                                    "group by fecha\n" +
                                                    "order by anho desc limit 1");
            rsIncidencias = stmIncidencias.executeQuery();
            if (rsIncidencias.next()){resultado = rsIncidencias.getInt("anho"); }
        } catch (SQLException e){
          System.out.println(e.getMessage());
          this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
        }finally{
          try {stmIncidencias.close();} catch (SQLException e){System.out.println("Imposible cerrar cursores");}
        }
        return resultado;  
    }
   
    public List<String> dinosauriosNoConflictivos(){
        java.util.List<String> resultado = new java.util.ArrayList<String>();
        Connection con;
        PreparedStatement stmDinosaurios=null;
        ResultSet rsDinosaurios;
        con=this.getConexion();
        try {
            stmDinosaurios = con.prepareStatement("select nombre\n" +
                                                "from dinosaurios as d\n" +
                                                "where id NOT IN (select responsable \n" +
                                                "		from incidencias)");
            rsDinosaurios = stmDinosaurios.executeQuery();
            while (rsDinosaurios.next()){resultado.add(rsDinosaurios.getString("nombre"));}
        } catch (SQLException e){
          System.out.println(e.getMessage());
          this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
        }finally{
          try {stmDinosaurios.close();} catch (SQLException e){System.out.println("Imposible cerrar cursores");}
        }
        return resultado;
    }
    
    public String actividadCara(){
        String resultado = null;
        Connection con;
        PreparedStatement stmActividades=null;
        ResultSet rsActividades;
        con=this.getConexion();
        try {
            stmActividades = con.prepareStatement("select nombre, MAX(precio) as precio\n" +
                                                    "from actividades\n" +
                                                    "group by nombre\n" +
                                                    "order by precio desc limit 1");
            rsActividades = stmActividades.executeQuery();
            if (rsActividades.next()){resultado = rsActividades.getString("precio"); }
        } catch (SQLException e){
          System.out.println(e.getMessage());
          this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
        }finally{
          try {stmActividades.close();} catch (SQLException e){System.out.println("Imposible cerrar cursores");}
        }
        return resultado;  
    }
}
