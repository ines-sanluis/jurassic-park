package gui;

import elementos.Actividad;
import elementos.Empleado;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author joaquin
 */
public class ModeloTablaEmpleados extends AbstractTableModel {

    private List<Empleado> empleados;
    
    public ModeloTablaEmpleados() {
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
            case 2: nombre="Tipo"; break;
        }
        return nombre;
    }
    
    @Override
    public int getColumnCount() {
        return 3;
    }
    
    @Override
    public Class getColumnClass(int col) {
        //rellenar
        return Object.class;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public void setFilas(List<Empleado> empleados) {
        this.empleados = new ArrayList(empleados);
        fireTableDataChanged();
    }
    
}
