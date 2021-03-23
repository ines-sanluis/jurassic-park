/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import elementos.Empleado;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author alumnogreibd
 */
public class ModeloTablaGuias extends AbstractTableModel {
    
    protected List<Empleado> empleados;
    
    public ModeloTablaGuias() {
        empleados = new ArrayList<Empleado>();
    }
    
    
     @Override
    public int getRowCount() {
        return empleados.size();
    }
    
    @Override
    public String getColumnName(int col) {
        String nombre="";
        switch (col){
            case 0: nombre= "Id"; break;
            case 1: nombre="Nombre"; break;
            case 2: nombre="Zona"; break;
            case 3: nombre="DNI"; break;
        }
        return nombre;
    }
    
    @Override
    public int getColumnCount() {
        return 4;
    }
    
    @Override
    public Class getColumnClass(int col) {
        return String.class;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Object res = null;
        Empleado e = empleados.get(rowIndex);
        switch(columnIndex) {
            case 0:
                res = e.getId();
                break;
            case 1:
                res = e.getNombre();
                break;
            case 2:
                res = e.getZona();
                break;
            case 3:
                res = e.getDni();
                break;
        }
        return res;
    }
    
    public void setFilas(List<Empleado> empleados) {
        this.empleados = new ArrayList(empleados);
        fireTableDataChanged();
    }
}
