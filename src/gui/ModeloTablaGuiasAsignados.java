package gui;

import elementos.Empleado;

/**
 *
 * @author joaquin
 */
public class ModeloTablaGuiasAsignados extends ModeloTablaGuias {
    
    public ModeloTablaGuiasAsignados() {
        super();
    }
    
    @Override
    public int getColumnCount() {
        return 2;
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
        }
        return res;
    }
    
        @Override
    public String getColumnName(int col) {
        String nombre="";
        switch (col){
            case 0: nombre= "Id"; break;
            case 1: nombre="Nombre"; break;
        }
        return nombre;
    }
    
    public void quitarGuia(String id) {
        for (int i = 0; i < empleados.size(); i++) {
            if (empleados.get(i).getNombre().equals(id)) {
                empleados.remove(i);
                break;
            }
        }
        
    }

}
