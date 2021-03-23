package aplicacion;

import elementos.Incidencia;
import elementos.Actividad;
import baseDatos.FachadaBaseDatos;
import elementos.Dinosaurio;
import elementos.Empleado;
import elementos.Victima;
import gui.FachadaGui;
import gui.VActividades;
import gui.VIncidencias;
import java.util.List;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 *
 * @author alumnogreibd
 */
public class FachadaAplicacion {
    private final FachadaGui fgui;
    private final FachadaBaseDatos fbd;
    private final GestionDinosaurios gDinos;
    private final GestionEspecies gEspecies;
    private final GestionEmpleados gEmpleados;
    private final GestionIncidencias gIncidencias;
    private final GestionActividades gActividades;
    private final GestionPedidos gPedidos;
    private final GestionEstadisticas gEstadisticas;
    private final GestionGuias gGuias;

    public FachadaAplicacion() {
        fgui = new FachadaGui(this); //Crear fachada da interfaz de usuario
        fbd = new FachadaBaseDatos(this); //Crear fachada da BD
        
        gDinos = new GestionDinosaurios(fgui, fbd);
        gEspecies = new GestionEspecies(fgui, fbd);
        gEmpleados = new GestionEmpleados(fgui, fbd);
        gIncidencias = new GestionIncidencias(fgui, fbd);
        gActividades = new GestionActividades(fgui, fbd);
        gPedidos = new GestionPedidos(fgui, fbd);
        gEstadisticas = new GestionEstadisticas(fgui, fbd);
        gGuias = new GestionGuias(fgui,fbd);
    }
    
    public static void main(String args[]) {
        FachadaAplicacion fa = new FachadaAplicacion(); //Crea instancia de si misma
        fa.iniciarInterfazUsuario();  //Inicia a vista
    }
    
    /* INICIAR ENTORNO GRAFICO ************************************************/
    public void iniciarInterfazUsuario() {
        fgui.iniciaLog();
    }  
    public void iniciarVista() {
        fgui.iniciaVista();
    }
    
    public void muestraExcepcion(String e) {
        fgui.muestraExcepcion(e);
    }
    
    public void iniciarGestionEspecies() {
        fgui.iniciaGestionEspecies();
    }

    public void iniciarGestionDinos() {
        fgui.iniciaGestionDinos();
    }

    public void iniciarGestionInc() {
        fgui.iniciaGestionInc(); 
    }

    public void iniciarGestionEmp() {
        fgui.iniciaGestionEmp(); 
    }

    public void iniciarGestionAct() {
        fgui.iniciaGestionAct(); 
    }
    
    public void iniciarGestionEstadisticas() {
        fgui.iniciaGestionEstadisticas();
    }
    
    public void iniciarGestionGuias(VActividades vp, String a) {
        fgui.iniciaGestionGuias(vp, a);
    }
    
    
    /* DINOSAURIOS **************************************************************/
    public Dinosaurio obtenerDinoVivo(String nombre){
        return gDinos.obtenerDinoVivo(nombre);
    }
    
    /* EMPLEADOS **************************************************************/
    public Boolean comprobarAutentificacion(String idUsuario, String clave) {
        return gEmpleados.comprobarAutentificacion(idUsuario, clave);
    }
    
    /* INCIDENCIAS ************************************************************/
    public List<Incidencia> obtenerIncidencias(int dias, String tag) {
        return gIncidencias.obtenerIncidencias(dias, tag);
    }

    public void borrarIncidencia(Incidencia i) {
        gIncidencias.borrarIncidencia(i);
    }

    public void modificarIncidencia(Incidencia i) {
        gIncidencias.modificarIncidencia(i);
    }
    
    public void insertarIncidencia(Incidencia i) {
        gIncidencias.insertarIncidencia(i);
    }
    
    public boolean existeIncidencia(Incidencia i){
        return gIncidencias.existeIncidencia(i);
    }
    
    public void anhadirVictima(Victima v) {
        gIncidencias.anhadirVictima(v);
    }
    
    public void borrarVictima(Victima v) {
        gIncidencias.borrarVictima(v);
    }
    
    public boolean existeVictima(Victima v){
        return gIncidencias.existeVictima(v);
    }
    
    /* ESTADISTICAS ***********************************************************/
    public Integer numeroIncidencias() {
        return gEstadisticas.numeroIncidencias();
    }
    
    public Integer numeroIncidenciasMortales(){
        return gEstadisticas.numeroIncidenciasMortales();
    }
    
    public Integer diasUltimaIncidencia() {
        return gEstadisticas.diasUltimaIncidencia();
    }
    
    public Integer numeroDinosVivos(){
        return gEstadisticas.numeroDinosVivos();
    }
    
    public Integer numeroDinosMuertos(){
        return gEstadisticas.numeroDinosMuertos();
    }
    
    public Integer numeroTotalDinos(){
        return gEstadisticas.numeroTotalDinos();
    }
   
    public double porcentajeDinosMuertos(){
        return gEstadisticas.porcentajeDinosMuertos();
    }
    
    public double porcentajeDinosVivos(){
        return gEstadisticas.porcentajeDinosVivos();
    }
    
    public Integer mediaDiasDinos(){
         return gEstadisticas.mediaDiasDinos();
     }
     
    public java.util.List<String> dinoConflictivo(){
         return gEstadisticas.dinoConflictivo();
    }
    
     public java.util.List<String> dietaComun(){
        return gEstadisticas.dietaComun();
    }
     
    public double gastoMedioEmpleado(){
        return gEstadisticas.gastoMedioEmpleado();
    }
             
    public Integer numeroEspecies(){
        return gEstadisticas.numeroEspecies();
    }
    
    public Integer empleadosMejorSueldo(){
        return gEstadisticas.empleadosMejorSueldo();
    }
    
    public String guiaMasActividades(){
        return gEstadisticas.guiaMasActividades();
    }
    
    public Integer anhoMasIncidencias(){
        return gEstadisticas.anhoMasIncidencias();
    }
    
    public java.util.List<String> dinoNoConflictivo(){
         return gEstadisticas.dinoNoConflictivo();
    }   
    
    public String actividadCara(){
        return gEstadisticas.actividadCara();
    }
    
    /* ACTIVIDADES ************************************************************/
    public List<Actividad> buscarActividades(String nombre) {
        return gActividades.buscarActividades(nombre);
    }

    public void anhadirActividad(Actividad a) {
         gActividades.anhadirActividad(a);
    }

    public void modificarActividad(Actividad a,String nombre) {
        gActividades.modificarActividad(a,nombre);
    }
    
    public void borrarActividad(String nombre) {
        gActividades.borrarActividad(nombre);
    }
    
    public List<Empleado> buscarEmpleado(String nombre, String actividad) {
        return gGuias.buscarEmpleado(nombre, actividad);
    }
    
    public void asignarGuia(String id, String a) {
        gGuias.asignarGuia(id, a);
    }
    
    public void desasignarGuia(String id, String a) {
        gGuias.desasignarGuia(id, a);
    }

   
    
}
