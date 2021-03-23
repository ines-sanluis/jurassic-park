/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package baseDatos;

import elementos.Actividad;
import elementos.Empleado;
import aplicacion.FachadaAplicacion;
import elementos.Dinosaurio;
import elementos.Incidencia;
import elementos.Victima;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Properties;

/**
 *
 * @author alumnogreibd
 */
public class FachadaBaseDatos {
    private FachadaAplicacion fa;
    private java.sql.Connection conexion;
    private DAODinosaurios daoDinosaurios;
    private DAOActividades daoActividades;
    private DAOEmpleados daoEmpleados;
    private DAOEspecies daoEspecies;
    private DAOIncidencias daoIncidencias;
    private DAOPedidos daoPedidos;
    private DAOEstadisticas daoEstadisticas;
    private DAOGuias daoGuias;

    public FachadaBaseDatos(FachadaAplicacion fa) {
        Properties configuracion = new Properties();
        this.fa=fa;
        FileInputStream arqConfiguracion;
        try {
            arqConfiguracion = new FileInputStream("baseDatos.properties");
            configuracion.load(arqConfiguracion);
            arqConfiguracion.close();
            Properties usuario = new Properties();
            String gestor = configuracion.getProperty("gestor");
            usuario.setProperty("user", configuracion.getProperty("usuario"));
            usuario.setProperty("password", configuracion.getProperty("clave"));
            this.conexion=java.sql.DriverManager.getConnection("jdbc:"+gestor+"://"+
                    configuracion.getProperty("servidor")+":"+
                    configuracion.getProperty("puerto")+"/"+
                    configuracion.getProperty("baseDatos"),
                    usuario);
            daoDinosaurios = new DAODinosaurios(conexion, fa);
            daoEspecies = new DAOEspecies(conexion, fa);
            daoActividades = new DAOActividades(conexion, fa);
            daoEmpleados = new DAOEmpleados(conexion, fa);
            daoIncidencias = new DAOIncidencias(conexion, fa);
            daoPedidos = new DAOPedidos(conexion, fa);
            daoEstadisticas = new DAOEstadisticas(conexion, fa);
            daoGuias = new DAOGuias(conexion, fa);
        } catch (FileNotFoundException f){
            System.out.println(f.getMessage());
            fa.muestraExcepcion(f.getMessage());
        } catch (IOException i){
            System.out.println(i.getMessage());
            fa.muestraExcepcion(i.getMessage());
        } 
        catch (java.sql.SQLException e){
            System.out.println(e.getMessage());
            fa.muestraExcepcion(e.getMessage());
        }
    }
   
    /* DINOSAURIOS ************************************************************/
     public Dinosaurio obtenerDinoVivo(String nombre) {
        return daoDinosaurios.obtenerDinoVivo(nombre);
     }
    /* EMPLEADOS ***************************************************************/
    
    public Empleado validarUsuario(String idUsuario, String clave){
        return daoEmpleados.validarUsuario(idUsuario, clave);
    }

    /* INCIDENCIAS *************************************************************/
    public List<Incidencia> obtenerIncidencias(int dias, String tag) {
        return daoIncidencias.obtenerIncidencias(dias, tag);
    }

    public void borrarIncidencia(Incidencia i) {
        daoIncidencias.borrarIncidencia(i);
    }

    public void modificarIncidencia(Incidencia i) {
        daoIncidencias.modificarIncidencia(i);
    }
    
    public List<Actividad> buscarActividades(String nombre) {
        return daoActividades.buscarActividades(nombre);
    }

    public void insertarIncidencia(Incidencia i) {
        daoIncidencias.insertarIncidencia(i);
    }
   
    public boolean existeIncidencia(Incidencia i){
        return daoIncidencias.existeIncidencia(i);
    }
    
    public void anhadirVictima(Victima v) {
        daoIncidencias.anhadirVictima(v);
    }
    
    public void borrarVictima(Victima v) {
        daoIncidencias.borrarVictima(v);
    }
    
    public boolean existeVictima(Victima v){
        return daoIncidencias.existeVictima(v);
    }
    
    /* ESTADISTICAS ***********************************************************/
    public Integer numeroIncidencias(){
        return daoEstadisticas.numeroIncidencias();
    }
    
    public Integer numeroIncidenciasMortales(){
        return daoEstadisticas.numeroIncidenciasMortales();
    }

    public Integer diasUltimaIncidencia() {
        return daoEstadisticas.diasUltimaIncidencia();
    }
    
    public Integer numeroDinosVivos(){
        return daoEstadisticas.numeroDinosVivos();
    }
    
    public Integer numeroDinosMuertos(){
        return daoEstadisticas.numeroDinosMuertos();
    }
    
    public Integer mediaDiasDinos(){
         return daoEstadisticas.mediaDiasDinos();
     }
     
    public java.util.List<String> dinoConflictivo(){
         return daoEstadisticas.dinoConflictivo();
     }
     
    public double gastoMedioEmpleado(){
        return daoEstadisticas.gastoMedioEmpleado();
    }
             
    public Integer numeroEspecies(){
        return daoEstadisticas.numeroEspecies();
    }
    
    public List<String> dietaComun(){
        return daoEstadisticas.dietaComun();
    }

    public Integer empleadosMejorSueldo(){
        return daoEstadisticas.empleadosMejorSueldo();
    }
            
    public String guiaMasActividades(){
        return daoEstadisticas.guiaMasActividades();
    }
    
    public Integer anhoMasIncidencias(){
        return daoEstadisticas.anhoMasIncidencias();
    }
    
    public java.util.List<String> dinoNoConflictivo(){
         return daoEstadisticas.dinosauriosNoConflictivos();
    }   
    
    public String actividadCara(){
        return daoEstadisticas.actividadCara();
    }
    
    
    /* ACTIVIDADES ************************************************************/
    public void anhadirActividad(Actividad a) {
         daoActividades.anhadirActividad(a);
    }
    
    public void modificarActividad(Actividad a,String nombre) {
        daoActividades.modificarActividad(a,nombre);
    }
    
    public void borrarActividad(String nombre) {
        daoActividades.borrarActividad(nombre);
    }
    
    public List<Empleado> buscarEmpleado(String nombre, String actividad) {
        return daoGuias.buscarEmpleado(nombre, actividad);
    }
    
    public void asignarGuia(String id, String a) {
        daoGuias.asignarGuia(id, a);
    }
    
    public void desasignarGuia(String id, String a) {
        daoGuias.desasignarGuia(id, a);
    }

    
}
