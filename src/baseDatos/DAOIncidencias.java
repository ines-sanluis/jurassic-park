/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package baseDatos;

import elementos.Incidencia;
import elementos.Victima;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author alumnogreibd
 */
public class DAOIncidencias extends AbstractDAO{
    public DAOIncidencias (Connection conexion, aplicacion.FachadaAplicacion fa){
        super.setConexion(conexion); //Establecer a conexion
        super.setFachadaAplicacion(fa); //Establecer a fachada
    }

    public List<Incidencia> obtenerIncidencias(int dias, String tag) {
        List<Incidencia> resultado = new java.util.ArrayList<Incidencia>();
        Connection con;
        PreparedStatement stmIncidencia = null;
        PreparedStatement stmVictimas = null;
        ResultSet rsIncidencia;
        con=this.getConexion();
        try {
            con.setAutoCommit(false);
            if(dias >= 0){
                stmIncidencia=con.prepareStatement("select i.*, d.nombre "
                                                 + " from incidencias as i left join dinosaurios as d on (i.responsable = d.id)"
                                                 + " where current_date - fecha < ? "
                                                 + " and descripcion LIKE ?"
                                                 + " order by fecha desc, gravedad desc"); //la ultima primero
                stmIncidencia.setInt(1, dias);
                stmIncidencia.setString(2, "%"+tag+"%");
            }
            else{
                stmIncidencia=con.prepareStatement("select i.*, d.nombre "
                                                 + " from incidencias as i left join dinosaurios as d on (i.responsable = d.id)"
                                                 + " where descripcion LIKE ?"
                                                 + " order by fecha desc, gravedad desc ");
                stmIncidencia.setString(1, "%"+tag+"%");
            }
            rsIncidencia=stmIncidencia.executeQuery();
            while (rsIncidencia.next()){
                String id = rsIncidencia.getString("id");
                stmVictimas = con.prepareStatement("select nombre from victimas where id=? ");
                stmVictimas.setString(1, id);
                ResultSet rsVictimas = stmVictimas.executeQuery();
                ArrayList<String> victimas = new ArrayList<String>();
                while (rsVictimas.next()) {
                    victimas.add(rsVictimas.getString("nombre"));
                }
                resultado.add(new Incidencia (rsIncidencia.getString("id"), rsIncidencia.getString("fecha"), rsIncidencia.getString("descripcion"),
                                              rsIncidencia.getInt("gravedad"), rsIncidencia.getString("nombre"),
                                              rsIncidencia.getString("responsable"), victimas)
                             );
            }
        } catch (SQLException e){
          System.out.println(e.getMessage());
          this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
        }finally{
          try {
              if (stmIncidencia != null) stmIncidencia.close();
              if (stmVictimas != null) stmVictimas.close();
               con.commit();
               con.setAutoCommit(true);} catch (SQLException e){System.out.println("Imposible cerrar cursores");}
        }
        return resultado;
    }

    void borrarIncidencia(Incidencia i) {
        Connection con;
        PreparedStatement stmIncidencia = null;
        PreparedStatement stmVictimas = null;
        con = super.getConexion();

        try {
            con.setAutoCommit(false);
            stmVictimas = con.prepareStatement("delete from victimas where id=?");
            stmVictimas.setString(1, i.getId());
            stmIncidencia = con.prepareStatement("delete from incidencias where id=?");
            stmIncidencia.setString(1, i.getId());
            stmIncidencia.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
        } finally {
            try {
                if(stmIncidencia != null) stmIncidencia.close();
                if(stmVictimas != null) stmVictimas.close();
                con.commit();
                con.setAutoCommit(true);} catch (SQLException e) {System.out.println("Imposible cerrar cursores");
            }
        }
    }

    void modificarIncidencia(Incidencia i) {
        Connection con;
        PreparedStatement stmIncidencia = null;
        con = this.getConexion();
        try {
            stmIncidencia = con.prepareStatement("update incidencias "
                                            + "set fecha=cast(? as date), "
                                            + "    descripcion=?, "
                                            + "    gravedad=?, "
                                            + "    responsable=? "
                                            + "where id=?");
            //SE QUERO FACER UPDATE DE VICTIMAS?
            stmIncidencia.setString(1, i.getFecha());
            stmIncidencia.setString(2, i.getDescripcion());
            stmIncidencia.setInt(3, i.getGravedad());
            stmIncidencia.setString(4, i.getIdResponsable());
            stmIncidencia.setString(5, i.getId());
            stmIncidencia.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
        } finally {
            try {
                if(stmIncidencia != null) stmIncidencia.close();
            } catch (SQLException e) {
                System.out.println("Imposible cerrar cursores");
            }
        }
    }
    
    public void insertarIncidencia(Incidencia i){
        //pODER INSERTAR VICTIMAS!!!
        Connection con;
        PreparedStatement stmIncidencia = null;
            con = this.getConexion();
            try {
                stmIncidencia = con.prepareStatement("insert into "+
                                                    " incidencias(fecha, descripcion, gravedad, responsable ) "+
                                                    " values(cast(? as date), ?, ?, ?);");
                stmIncidencia.setString(1,  i.getFecha());
                stmIncidencia.setString(2, i.getDescripcion());
                stmIncidencia.setInt(3, i.getGravedad());
                stmIncidencia.setString(4, i.getIdResponsable());
                stmIncidencia.executeUpdate();
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            } finally {
                try { if(stmIncidencia != null) stmIncidencia.close();} catch (SQLException e) {
                    System.out.println("Imposible cerrar cursores");
                }
            }
        
    }

    void borrarVictima(Victima v) {
        Connection con;
        PreparedStatement stmVictima = null;
        con = this.getConexion();
        try {
            stmVictima = con.prepareStatement("delete from victimas where id=? and nombre=?");
            stmVictima.setString(1, v.getId());
            stmVictima.setString(2, v.getNombre());
            stmVictima.executeUpdate();
        }catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            try { if(stmVictima != null) stmVictima.close();} catch (SQLException e) {
                System.out.println("Imposible cerrar cursores");
                }
        }
    }
    
    void anhadirVictima(Victima v) {
        Connection con;
        PreparedStatement stmVictima = null;
        con = this.getConexion();
        try {
            stmVictima = con.prepareStatement("insert into victimas values(?, ?);");
            stmVictima.setString(1, v.getId());
            stmVictima.setString(2, v.getNombre());
            stmVictima.executeUpdate();
        }catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            try { if(stmVictima != null) stmVictima.close();} catch (SQLException e) {
                System.out.println("Imposible cerrar cursores");
                }
        }
    }
    
    public boolean existeVictima(Victima v) {
        Connection con;
        PreparedStatement stmVictima = null;
        ResultSet rsVictima;
        boolean resultado = false;
        con = this.getConexion();
        try {
            stmVictima = con.prepareStatement("select nombre from victimas where id=? and nombre=?;");
            stmVictima.setString(1, v.getId());
            stmVictima.setString(2, v.getNombre());
            rsVictima = stmVictima.executeQuery();
            if(rsVictima.next()) resultado = true;
        }catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            try { if(stmVictima != null) stmVictima.close();} catch (SQLException e) {
                System.out.println("Imposible cerrar cursores");
                }
        }
        return resultado;
    }
    
    public boolean existeIncidencia(Incidencia i){
        Connection con;
        PreparedStatement stmIncidencia = null;
        ResultSet rsIncidencia;
        boolean resultado = false;
        con = this.getConexion();
        try {
            stmIncidencia = con.prepareStatement("select id from incidencias "
                                               + "where fecha=cast(? as date) and descripcion=? and responsable=?");
            stmIncidencia.setString(1, i.getFecha());
            stmIncidencia.setString(2, i.getDescripcion());
            stmIncidencia.setString(3, i.getIdResponsable());
            rsIncidencia = stmIncidencia.executeQuery();
            if(rsIncidencia.next()) resultado = true;
        }catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            try { if(stmIncidencia != null) stmIncidencia.close();} catch (SQLException e) {
                System.out.println("Imposible cerrar cursores");
                }
        }
        return resultado;
    }
    
}
