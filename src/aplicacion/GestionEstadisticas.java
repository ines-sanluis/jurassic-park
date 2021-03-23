/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion;

import baseDatos.FachadaBaseDatos;
import gui.FachadaGui;

/**
 *
 * @author alumnogreibd
 */
public class GestionEstadisticas {
    private final FachadaGui fgui;
    private final FachadaBaseDatos fbd;

    public GestionEstadisticas(FachadaGui fgui, FachadaBaseDatos fbd) {
        this.fgui = fgui;
        this.fbd = fbd;
    }

    public Integer numeroIncidencias() {
        return fbd.numeroIncidencias();
    }
    
    public Integer numeroIncidenciasMortales(){
        return fbd.numeroIncidenciasMortales();
    }

    public Integer diasUltimaIncidencia() {
        return fbd.diasUltimaIncidencia();
    }
    
    public Integer numeroDinosVivos(){
        return fbd.numeroDinosVivos();
    }
    
    public Integer numeroDinosMuertos(){
        return fbd.numeroDinosMuertos();
    }
    
    public Integer numeroTotalDinos() {
        return numeroDinosVivos()+numeroDinosMuertos();
    }
    
    public double porcentajeDinosMuertos(){
        return (100*numeroDinosMuertos())/numeroTotalDinos();
    }
    
    public double porcentajeDinosVivos(){
        return 100 - porcentajeDinosMuertos();
    }
    
    public Integer mediaDiasDinos(){
         return fbd.mediaDiasDinos();
     }
     
    public java.util.List<String> dinoConflictivo(){
         return fbd.dinoConflictivo();
     }
     
    public double gastoMedioEmpleado(){
        return fbd.gastoMedioEmpleado();
    }
             
    public Integer numeroEspecies(){
        return fbd.numeroEspecies();
    }

    public java.util.List<String> dietaComun(){
        return fbd.dietaComun();
    }

    public Integer empleadosMejorSueldo(){
        return fbd.empleadosMejorSueldo();
    }
    
    public String guiaMasActividades(){
        return fbd.guiaMasActividades();
    }

    public Integer anhoMasIncidencias(){
        return fbd.anhoMasIncidencias();
    }
    
    public java.util.List<String> dinoNoConflictivo(){
         return fbd.dinoNoConflictivo();
    }   
    
    public String actividadCara(){
        return fbd.actividadCara();
    }
}
