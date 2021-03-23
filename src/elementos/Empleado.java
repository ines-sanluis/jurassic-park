/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package elementos;

/**
 *
 * @author alumnogreibd
 */
public class Empleado {
    private final String id;
    private final String nombre;
    private final String zona;
    private final String dni;
    private final String tipo;
    private final Double sueldo;
    private final String telf;
    
    public Empleado(String id, String nombre) {
        this.id = id;
        this.nombre = nombre;
        this.zona = null;
        this.dni = null;
        this.tipo = null;
        this.sueldo = null;
        this.telf = null;
    }

    public Empleado(String id, String nombre, String zona, String dni, String tipo, Double sueldo, String telf) {
        this.id = id;
        this.nombre = nombre;
        this.zona = zona;
        this.dni = dni;
        this.tipo = tipo;
        this.sueldo = sueldo;
        this.telf = telf;
    }

    public String getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getZona() {
        return zona;
    }

    public String getDni() {
        return dni;
    }

    public String getTipo() {
        return tipo;
    }

    public Double getSueldo() {
        return sueldo;
    }

    public String getTelf() {
        return telf;
    }

    
}
