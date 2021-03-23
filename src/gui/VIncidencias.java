/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import aplicacion.FachadaAplicacion;
import elementos.Dinosaurio;
import elementos.Incidencia;
import elementos.Victima;
import java.sql.Date;
/**
 *
 * @author alumnogreibd
 */
public class VIncidencias extends javax.swing.JDialog {
    private final FachadaAplicacion fa;
    private boolean select = false;
    
    public VIncidencias(java.awt.Frame parent, boolean modal, FachadaAplicacion fa) {
        super(parent, modal);
        this.fa = fa;
        initComponents();
        btnAddVic.setEnabled(false);
        btnBorrarVic.setEnabled(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel3 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tablaIncidencias = new javax.swing.JTable();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        txtFecha = new javax.swing.JTextField();
        txtResponsable = new javax.swing.JTextField();
        btnBorrar = new javax.swing.JButton();
        btnModificar = new javax.swing.JButton();
        jLabel29 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        txtGravedad = new javax.swing.JTextField();
        jLabel24 = new javax.swing.JLabel();
        btnAdd = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        txtPersonas = new javax.swing.JTextField();
        buscaFecha = new javax.swing.JComboBox();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtDescripcion = new javax.swing.JTextPane();
        jLabel4 = new javax.swing.JLabel();
        buscaTags = new javax.swing.JTextField();
        btnBuscar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        txtID = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtVictimas = new javax.swing.JList<String>();
        btnAddVic = new javax.swing.JButton();
        btnBorrarVic = new javax.swing.JButton();
        txtAddVic = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel3.setText("Hace");

        tablaIncidencias.setModel(new ModeloTablaIncidencias());
        tablaIncidencias.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaIncidenciasMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tablaIncidencias);

        jLabel22.setText("Gravedad");

        jLabel23.setText("Núm. personas");

        txtFecha.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtFechaKeyReleased(evt);
            }
        });

        btnBorrar.setText("Borrar");
        btnBorrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBorrarActionPerformed(evt);
            }
        });

        btnModificar.setText("Modificar");
        btnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarActionPerformed(evt);
            }
        });

        jLabel31.setText("Fecha");

        jLabel24.setText("Descripción");

        btnAdd.setText("Añadir");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        btnSalir.setText("Salir");
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });

        jLabel25.setText("Responsable");

        jLabel26.setText("Víctimas");

        txtPersonas.setEditable(false);

        buscaFecha.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "1 semana", "2 semanas", "1 mes", "1 año", "Origen de los tiempos" }));

        txtDescripcion.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtDescripcionKeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(txtDescripcion);

        jLabel4.setText("Tags");

        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        jLabel1.setText("ID");

        txtID.setEditable(false);

        txtVictimas.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        txtVictimas.setModel(new ModeloListaStrings());
        txtVictimas.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        txtVictimas.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                txtVictimasValueChanged(evt);
            }
        });
        jScrollPane2.setViewportView(txtVictimas);

        btnAddVic.setText("Añadir");
        btnAddVic.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddVicActionPerformed(evt);
            }
        });

        btnBorrarVic.setText("Eliminar");
        btnBorrarVic.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBorrarVicActionPerformed(evt);
            }
        });

        txtAddVic.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtAddVicKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(15, 15, 15)
                                .addComponent(jLabel1)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(0, 11, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel31, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 23, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnBorrar, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtGravedad, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(txtFecha, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txtResponsable, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(btnAdd, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnModificar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel29)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addGap(0, 0, Short.MAX_VALUE)
                                        .addComponent(btnSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jScrollPane1)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel26)
                                            .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addGroup(layout.createSequentialGroup()
                                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                            .addComponent(jLabel25)
                                                            .addComponent(jLabel24))
                                                        .addGap(33, 33, 33))
                                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                        .addComponent(jLabel23)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                                                    .addComponent(txtPersonas)
                                                    .addComponent(txtAddVic))))
                                        .addGap(22, 22, 22)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(btnBorrarVic, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(btnAddVic, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addGap(1, 1, 1))))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(buscaFecha, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(buscaTags)))
                        .addGap(4, 4, 4)))
                .addGap(26, 26, 26))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(buscaFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(buscaTags, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(8, 8, 8)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(97, 97, 97)
                        .addComponent(jLabel29, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(25, 25, 25))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(btnBorrar)
                        .addGap(1, 1, 1)
                        .addComponent(btnModificar)
                        .addGap(1, 1, 1)
                        .addComponent(btnAdd)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(56, 56, 56)
                                .addComponent(btnAddVic)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnBorrarVic))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(17, 17, 17)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel1)
                                    .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(7, 7, 7)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel31, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txtFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel22, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txtGravedad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtResponsable, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtPersonas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel26, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtAddVic, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(24, 24, 24)))
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnSalir)
                .addGap(15, 15, 15))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
        // TODO add your handling code here:
         String responsable = null;
        int gravedad = 0;
        
        Dinosaurio d = fa.obtenerDinoVivo(txtResponsable.getText());
        if(d != null) responsable = d.getId();
        if(!txtGravedad.getText().isEmpty()) gravedad = Integer.parseInt(txtGravedad.getText());
        
        Incidencia modificada = new Incidencia(txtID.getText(), txtFecha.getText(), txtDescripcion.getText(), 
                                               gravedad, responsable);
        
        fa.modificarIncidencia(modificada);
        actualizarTabla(tablaIncidencias.getSelectedRow());
    }//GEN-LAST:event_btnModificarActionPerformed

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        // TODO add your handling code here:
        String responsable = null;
        int gravedad = 0;
        
        Dinosaurio d = fa.obtenerDinoVivo(txtResponsable.getText());
        if(d != null) responsable = d.getId();
        if(!txtGravedad.getText().isEmpty()) gravedad = Integer.parseInt(txtGravedad.getText());
        
        Incidencia nueva = new Incidencia(txtID.getText(), txtFecha.getText(), txtDescripcion.getText(),
                                          gravedad, responsable);
        if(fa.existeIncidencia(nueva)){
            fa.muestraExcepcion("Ya existe una incidencia con esa fecha, descripcion y responsable.");
            return;
        }
        fa.insertarIncidencia(nueva);
        actualizarTabla(-1);
    }//GEN-LAST:event_btnAddActionPerformed

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_btnSalirActionPerformed

    private void tablaIncidenciasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaIncidenciasMouseClicked
        // TODO add your handling code here:
        tablaIncidencias.getSelectedRow();
        ModeloTablaIncidencias m;
        m = (ModeloTablaIncidencias) tablaIncidencias.getModel();
        Incidencia i = m.obtenerIncidencia(tablaIncidencias.getSelectedRow());
        cubrirCampos(i);
        if(i.getVictimas().isEmpty() || select == false) btnBorrarVic.setEnabled(false);
        else btnBorrarVic.setEnabled(true);
    }//GEN-LAST:event_tablaIncidenciasMouseClicked

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        // TODO add your handling code here:
        buscarIncidencia(-1);
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void btnBorrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBorrarActionPerformed
        // TODO add your handling code here:
        tablaIncidencias.getSelectedRow();
        ModeloTablaIncidencias m;
        m = (ModeloTablaIncidencias) tablaIncidencias.getModel();
        Incidencia i = m.obtenerIncidencia(tablaIncidencias.getSelectedRow());
        fa.borrarIncidencia(i);
        actualizarTabla(-1);
        
    }//GEN-LAST:event_btnBorrarActionPerformed
    
    private void btnAddVicActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddVicActionPerformed
        // TODO add your handling code here:
         // TODO add your handling code here:
        if(txtAddVic.getText().isEmpty()) return;
        fa.anhadirVictima(new Victima(txtID.getText(), txtAddVic.getText()));
        actualizarTabla(tablaIncidencias.getSelectedRow());
        txtAddVic.setText("");
        btnAddVic.setEnabled(false);
        
    }//GEN-LAST:event_btnAddVicActionPerformed

    private void btnBorrarVicActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBorrarVicActionPerformed
        // TODO add your handling code here:
       fa.borrarVictima(new Victima(txtID.getText(),  txtVictimas.getSelectedValue()));
       actualizarTabla(tablaIncidencias.getSelectedRow());
    }//GEN-LAST:event_btnBorrarVicActionPerformed

    private void txtAddVicKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtAddVicKeyReleased
        // TODO add your handling code here:
        if(txtAddVic.getText().isEmpty()) btnAddVic.setEnabled(false);
        else if(fa.existeVictima(new Victima(txtID.getText(), txtAddVic.getText()))) btnAddVic.setEnabled(false);
        else btnAddVic.setEnabled(true);
    }//GEN-LAST:event_txtAddVicKeyReleased

    private void txtVictimasValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_txtVictimasValueChanged
        // TODO add your handling code here:
        btnBorrarVic.setEnabled(true);
        select = true;
    }//GEN-LAST:event_txtVictimasValueChanged

    private void txtFechaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtFechaKeyReleased
        // TODO add your handling code here:
        if(txtFecha.getText().isEmpty() || txtDescripcion.getText().isEmpty()){
            btnAdd.setEnabled(false);
            btnModificar.setEnabled(false);
        }
        else{
            btnAdd.setEnabled(true);
            btnModificar.setEnabled(true);
        }
    }//GEN-LAST:event_txtFechaKeyReleased

    private void txtDescripcionKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDescripcionKeyReleased
        // TODO add your handling code here:
        if(txtFecha.getText().isEmpty() || txtDescripcion.getText().isEmpty()){
            btnAdd.setEnabled(false);
            btnModificar.setEnabled(false);
        }
        else{
            btnAdd.setEnabled(true);
            btnModificar.setEnabled(true);
        }
    }//GEN-LAST:event_txtDescripcionKeyReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnAddVic;
    private javax.swing.JButton btnBorrar;
    private javax.swing.JButton btnBorrarVic;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnModificar;
    private javax.swing.JButton btnSalir;
    private javax.swing.JComboBox buscaFecha;
    private javax.swing.JTextField buscaTags;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable tablaIncidencias;
    private javax.swing.JTextField txtAddVic;
    private javax.swing.JTextPane txtDescripcion;
    private javax.swing.JTextField txtFecha;
    private javax.swing.JTextField txtGravedad;
    private javax.swing.JTextField txtID;
    private javax.swing.JTextField txtPersonas;
    private javax.swing.JTextField txtResponsable;
    private javax.swing.JList<String> txtVictimas;
    // End of variables declaration//GEN-END:variables
    
    private void buscarIncidencia(int fila){
        ModeloTablaIncidencias m;
        Incidencia i;
        int index = buscaFecha.getSelectedIndex();
        String tags = buscaTags.getText();
        if(buscaTags.getText().isEmpty()) tags="";
        int dias = -1;
        switch(index){
            case 0: dias = 7; break;
            case 1: dias = 14; break;
            case 2: dias = 30; break;
            case 3: dias = 365; break;
            default: break;
        }
        m = (ModeloTablaIncidencias)tablaIncidencias.getModel();
        m.setFilas(fa.obtenerIncidencias(dias, tags));
        if (m.getRowCount() > 0) {
            if(fila<0){
                tablaIncidencias.setRowSelectionInterval(0, 0);
                i = m.obtenerIncidencia(tablaIncidencias.getSelectedRow());
                //btnBorrarVic.setEnabled(false);
            }
            else{
                tablaIncidencias.setRowSelectionInterval(fila, fila);
                i = m.obtenerIncidencia(fila);
                //btnBorrarVic.setEnabled(true);
            }
            cubrirCampos(i);
        }
    }
    
    private void cubrirCampos(Incidencia i){
        txtID.setText(i.getId());
        txtFecha.setText(i.getFecha());
        txtGravedad.setText(i.getGravedad().toString());
        txtResponsable.setText(i.getResponsable());
        txtDescripcion.setText(i.getDescripcion());
        txtPersonas.setText(i.getPersonas().toString());        
        ModeloListaStrings m = (ModeloListaStrings) txtVictimas.getModel();
        m.setElementos(i.getVictimas());
    }

    private void actualizarTabla(int fila) { 
        buscarIncidencia(fila); 
    }
    
            
}
