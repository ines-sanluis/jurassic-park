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
public class Dinosaurio {
    private final String id;
    private final String nombre;
    private final String especie;
    private final String dieta;
    private final Integer unidades;
    private final String zona;
    private final String fechaLlegada;
    private final String estado;
    private final String cuidador;
    private final String veterinario;

    public Dinosaurio(String id, String nombre, String especie, String dieta, String zona, String fechaLlegada, String estado, Integer unidades, String cuidador, String veterinario) {
        this.id = id;
        this.nombre = nombre;
        this.especie = especie;
        this.dieta = dieta;
        this.zona = zona;
        this.fechaLlegada = fechaLlegada;
        this.estado = estado;
        this.unidades = unidades;
        this.cuidador = cuidador;
        this.veterinario = veterinario;
    }

    public String getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getEspecie() {
        return especie;
    }

    public String getDieta() {
        return dieta;
    }

    public String getZona() {
        return zona;
    }

    public String getFechaLlegada() {
        return fechaLlegada;
    }

    public String getEstado() {
        return estado;
    }

    public String getCuidador() {
        return cuidador;
    }

    public String getVeterinario() {
        return veterinario;
    }

    public Integer getUnidades() {
        return unidades;
    }
    
    
    
    
    
}
