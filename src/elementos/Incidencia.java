/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package elementos;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author alumnogreibd
 */
public class Incidencia {
    private  String id;
    private  String fecha;
    private  String descripcion;
    private  Integer gravedad;
    private  String idResponsable;
    private  String responsable;
    private  Integer personas;
    private  List<String> victimas;

    public Incidencia(String id, String fecha, String descripcion, Integer gravedad, String responsable, String idResponsable,  List<String> victimas) {
        this.id = id;
        this.fecha = fecha;
        this.descripcion = descripcion;
        this.gravedad = gravedad;
        this.responsable = responsable;
        this.idResponsable = idResponsable;
        this.victimas = new ArrayList<String>(victimas);
        this.personas = victimas.size();
    }

    public Incidencia(String id, String fecha, String descripcion, Integer gravedad, String idResponsable, List<String> victimas) {
        this.id = id;
        this.fecha = fecha;
        this.descripcion = descripcion;
        this.gravedad = gravedad;
        this.idResponsable = idResponsable;
        this.responsable = null;
        this.victimas = new ArrayList<String>(victimas);
        this.personas = victimas.size();
    }
    
    public Incidencia(String id, String fecha, String descripcion, Integer gravedad, String idResponsable) {
        this.id = id;
        this.fecha = fecha;
        this.descripcion = descripcion;
        this.gravedad = gravedad;
        this.idResponsable = idResponsable;
        this.responsable = null;
        this.victimas = null;
        this.personas = 0;
    }
    
    public String getId() {
        return id;
    }

    public String getFecha() {
        return fecha;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public Integer getGravedad() {
        return gravedad;
    }

    public String getResponsable() {
        return responsable;
    }
    public String getIdResponsable() {
        return idResponsable;
    }
    

    public Integer getPersonas() {
        return personas;
    }

    public List<String> getVictimas() {
        return victimas;
    }
    
    public String getVictima(int i) {
        return victimas.get(i);
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setGravedad(Integer gravedad) {
        this.gravedad = gravedad;
    }

    public void setResponsable(String responsable) {
        this.responsable = responsable;
    }
    
    public void setIdResponsable(String idResponsable) {
        this.idResponsable = idResponsable;
    }


    public void setPersonas(Integer personas) {
        this.personas = personas;
    }

    public void setVictimas(List<String> victimas) {
        this.victimas = victimas;
    }

    
    
    
}
