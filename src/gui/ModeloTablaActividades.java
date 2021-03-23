package gui;

import elementos.Actividad;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author joaquin
 */
public class ModeloTablaActividades extends AbstractTableModel {
    
    private List<Actividad> actividades;

    
    public ModeloTablaActividades() {
        this.actividades = new ArrayList();
    }
    
    public int getRowCount() {
        return actividades.size();
    }

    public int getColumnCount() {
        return 5;
    }
    
    @Override
    public String getColumnName(int col){
        String nombre="";
        switch (col){
            case 0: nombre= "Nombre"; break;
            case 1: nombre="Zona"; break;
            case 2: nombre="Precio"; break;
            case 3: nombre="Peligro"; break;
            case 4: nombre="Capacidad"; break;
        }
        return nombre;
    }
    
    @Override
    public Class getColumnClass(int col){
        if (col == 2) return Float.class;
        else if (col == 4) return Integer.class;
        else return String.class;
    }
    
    @Override
    public boolean isCellEditable(int row, int col){
       return false;
    }

    public Object getValueAt(int rowIndex, int columnIndex) {
        Actividad a = actividades.get(rowIndex);
        Object res = null;
        switch(columnIndex) {
            case 0:
                res = a.getNombre();
                break;
            case 1:
                res = a.getZona();
                break;
            case 2:
                float precio = a.getPrecio();
                int i = (int) precio;
                res = i;
                break;
            case 3:
                res = a.getPeligrosidad();
                break;
            case 4:
                res = a.getParticipantes();
        }
        return res;
    }
    
    public void setFilas(List<Actividad> actividades) {
        this.actividades = new ArrayList(actividades);
        fireTableDataChanged();
    }
    public Actividad getActividad(int i) {
        return actividades.get(i);
    }
}
