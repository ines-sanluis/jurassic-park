/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import elementos.Incidencia;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author alumnogreibd
 */
public class ModeloTablaIncidencias extends AbstractTableModel{
    private java.util.List<Incidencia> incidencias;

    public ModeloTablaIncidencias() {
        this.incidencias = new java.util.ArrayList<Incidencia>();
    }
    
    public int getColumnCount(){
        return 3;
    }
    
    public int getRowCount(){
        return incidencias.size();
    }
    
    @Override
    public String getColumnName(int col){
        String nombre="";
        switch (col){
            case 0: nombre= "Fecha"; break;
            case 1: nombre= "Gravedad"; break;
            case 2: nombre= "Responsable"; break;
            //case 3: nombre= "Descripción"; break;
        }
        return nombre;
    }
    
    @Override
    public Class getColumnClass(int col){
        Class clase=null;

        switch (col){
            case 0: clase= String.class; break;
            case 1: clase= Integer.class; break;
            case 2: clase= String.class; break;
        }
        return clase;
    }
    
    @Override
    public boolean isCellEditable(int row, int col){
       return false; //Esto haberia que decidilo
    }
    
    public Object getValueAt(int row, int col) {
        Object resultado = null;
        switch (col) {
            case 0:
                resultado = incidencias.get(row).getFecha();
                break;
            case 1:
                resultado = incidencias.get(row).getGravedad();
                break;
            case 2:
                resultado = incidencias.get(row).getIdResponsable();
                break;
        }
        return resultado;
    }
    
    @Override
    public void setValueAt(Object v, int row, int col){
        switch (col){
            case 0: incidencias.get(row).setFecha((String) v); break;
            case 1: incidencias.get(row).setGravedad((Integer) v); break;
            case 3: incidencias.get(row).setIdResponsable((String)v); break;
        }
    }

    public void setFilas(java.util.List<Incidencia> incidencias){
        this.incidencias = incidencias;
        fireTableDataChanged();
    }

    public void nuevaIncidencia(Incidencia i){
        incidencias.add(i);
        fireTableRowsInserted(incidencias.size()-1, incidencias.size()-1);
    }

    public void borrarIncidencia(int indice){
        incidencias.remove(indice);
        fireTableRowsDeleted(indice, indice);
    }

    public java.util.List<Incidencia> getFilas(){
        return incidencias;
    }

    public Incidencia obtenerIncidencia(int i){
        return incidencias.get(i);
    }
    
    
}
