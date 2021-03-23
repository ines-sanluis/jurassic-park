/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package elementos;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author alumnogreibd
 */
public class Actividad {
    
    private String nombre;
    private String descripcion;
    private String zona;
    private float precio;
    private String peligrosidad;
    private int participantes;
    private List<Empleado> coordinadores;

    public Actividad(String nombre, String descripcion, String zona, float precio, String peligrosidad, int partipantes) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.zona = zona;
        this.precio = precio;
        this.peligrosidad = peligrosidad;
        this.participantes = partipantes;
        this.coordinadores = new ArrayList();
    }
    
    public Actividad(String nombre, String descripcion, String zona, float precio, String peligrosidad, int partipantes, Empleado coordinador) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.zona = zona;
        this.precio = precio;
        this.peligrosidad = peligrosidad;
        this.participantes = partipantes;
        this.coordinadores = new ArrayList<Empleado>();
        this.coordinadores.add(coordinador);
    }
    
    public Actividad(String nombre, String descripcion, String zona, float precio, String peligrosidad, int partipantes, List<Empleado> coordinadores) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.zona = zona;
        this.precio = precio;
        this.peligrosidad = peligrosidad;
        this.participantes = partipantes;
        this.coordinadores = new ArrayList<Empleado>(coordinadores);
    }
    

    public String getNombre() {
        return nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public String getZona() {
        return zona;
    }

    public float getPrecio() {
        return precio;
    }

    public String getPeligrosidad() {
        return peligrosidad;
    }

    public int getParticipantes() {
        return participantes;
    }
    
    public List<String> getNombreCoords() {
        ArrayList<String> nombres = new ArrayList<String>();
        for (Empleado e : coordinadores) {
            nombres.add(e.getNombre());
        }
        return nombres;
    }
    
    public String getNombreCoord(int i) {
        
        return coordinadores.get(i).getNombre();
    }
    
    public List<String> getIdCoords() {
        ArrayList<String> ids = new ArrayList<String>();
        for (Empleado e : coordinadores) {
            ids.add(e.getId());
        }
        return ids;
    }
    
    public String getIdCoord(int i) {
        return coordinadores.get(i).getId();
    }
    
    public Empleado getCoordinador(int i) {
        return this.coordinadores.get(i);
    }
    
    public List<Empleado> getCoords() {
        return this.coordinadores;
    }
    
    
}
