package com.jhonatan.sistemahospital.Igu;

import com.jhonatan.sistemahospital.ClaseMain.Clases.Admision;
import com.jhonatan.sistemahospital.ConexionBD.Conexion;
import com.jhonatan.sistemahospital.DaoImplementacion.ImpleAdmisionDao;
import java.awt.Color;
import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class admisiones extends javax.swing.JPanel {

    /*variable de tipo conexion*/
    private Connection conexion = null;
    private final Conexion instanciaMYSQL = Conexion.getInstancia();
    private final ImpleAdmisionDao admisionDao = new ImpleAdmisionDao();
    private final String[] columnas = {"ID Admision", "ID PACIENTE", "PACIENTE", "FECHA ADMISION", "FECHA ALTA", "DIAGNOSTICO", "ID DOCTOR", "DOCTOR"};
    private final DefaultTableModel modelo = new DefaultTableModel(columnas, 0);

    public admisiones() {
        initComponents();
        InitStyles();

    }

    private void InitStyles() {
        title.putClientProperty("FlatLaf.styleClass", "h1");
        title.setForeground(Color.black);
        txtBuscar.putClientProperty("JTextField.placeholderText", "Ingrese el nombre de usuario a buscar.");
        this.listarEnTabla();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bg = new javax.swing.JPanel();
        title = new javax.swing.JLabel();
        txtBuscar = new javax.swing.JTextField();
        btnBuscar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblAdmisiones = new javax.swing.JTable();
        btnBorar = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        btnNuevo = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));

        bg.setBackground(new java.awt.Color(255, 255, 255));

        title.setText("Admin");

        btnBuscar.setBackground(new java.awt.Color(0, 153, 255));
        btnBuscar.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnBuscar.setForeground(new java.awt.Color(255, 255, 255));
        btnBuscar.setText("Buscar");
        btnBuscar.setBorderPainted(false);
        btnBuscar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        tblAdmisiones.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        tblAdmisiones.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID Admision", "ID Paciente", "Paciente", "Fecha Admisión", "Fecha Alta", "Diagnostico", "ID Doctor", "Doctor"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                true, false, true, true, true, true, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblAdmisiones.getTableHeader().setReorderingAllowed(false);
        tblAdmisiones.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tblAdmisionesMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(tblAdmisiones);

        btnBorar.setBackground(new java.awt.Color(0, 153, 255));
        btnBorar.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnBorar.setForeground(new java.awt.Color(255, 255, 255));
        btnBorar.setText("Borrar");
        btnBorar.setBorderPainted(false);
        btnBorar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnBorar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBorarActionPerformed(evt);
            }
        });

        btnEditar.setBackground(new java.awt.Color(0, 153, 255));
        btnEditar.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnEditar.setForeground(new java.awt.Color(255, 255, 255));
        btnEditar.setText("Editar");
        btnEditar.setBorderPainted(false);
        btnEditar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });

        btnNuevo.setBackground(new java.awt.Color(0, 153, 255));
        btnNuevo.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnNuevo.setForeground(new java.awt.Color(255, 255, 255));
        btnNuevo.setText("Nuevo");
        btnNuevo.setBorderPainted(false);
        btnNuevo.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout bgLayout = new javax.swing.GroupLayout(bg);
        bg.setLayout(bgLayout);
        bgLayout.setHorizontalGroup(
            bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bgLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(bgLayout.createSequentialGroup()
                        .addComponent(title, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(699, 699, 699))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, bgLayout.createSequentialGroup()
                        .addGroup(bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(bgLayout.createSequentialGroup()
                                .addGap(427, 427, 427)
                                .addComponent(btnNuevo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnEditar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnBorar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(bgLayout.createSequentialGroup()
                                .addComponent(txtBuscar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnBuscar)))
                        .addGap(50, 50, 50))))
        );
        bgLayout.setVerticalGroup(
            bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bgLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(title, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 272, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnBorar)
                    .addComponent(btnEditar)
                    .addComponent(btnNuevo))
                .addGap(25, 25, 25))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bg, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bg, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void tblAdmisionesMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblAdmisionesMousePressed

    }//GEN-LAST:event_tblAdmisionesMousePressed

    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed
        Dashboard.ShowJPanel(new RegistroAdmisiones());
    }//GEN-LAST:event_btnNuevoActionPerformed

    private void btnBorarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBorarActionPerformed
        this.eliminarAdmision();
    }//GEN-LAST:event_btnBorarActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        System.out.println("");
    }//GEN-LAST:event_btnEditarActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        System.out.println("");
    }//GEN-LAST:event_btnBuscarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel bg;
    private javax.swing.JButton btnBorar;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnNuevo;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblAdmisiones;
    private javax.swing.JLabel title;
    private javax.swing.JTextField txtBuscar;
    // End of variables declaration//GEN-END:variables

    private void listarEnTabla() {
        while (modelo.getRowCount() > 0) {
            modelo.removeRow(0);
        }
        admisionDao.listarEnTablaAdmisiones(modelo);
        tblAdmisiones.setModel(modelo);
    }

    private void eliminarAdmision() {
        int filasSeleccionadas[] = tblAdmisiones.getSelectedRows();
        if (filasSeleccionadas.length == 0) {
            JOptionPane.showMessageDialog(null, "Por favor selecciona una o más filas para eliminar.", "ATENCIÓN", JOptionPane.WARNING_MESSAGE);
            return;
        }

        StringBuilder cantIds = new StringBuilder();
        for (int i = 0; i < filasSeleccionadas.length; i++) {
            String idPaciente = tblAdmisiones.getValueAt(filasSeleccionadas[i], 0).toString();
            if (cantIds.length() > 0) {
                cantIds.append(",");
            }
            cantIds.append(idPaciente);
        }
        try {
            conexion = instanciaMYSQL.conectarConBaseDatos();
            if (conexion.getAutoCommit()) {
                conexion.setAutoCommit(false);
            }
            int opcion = JOptionPane.showConfirmDialog(null, "¿Estás seguro de eliminar los registros con ID: " + cantIds + "?", "ATENCIÓN", JOptionPane.WARNING_MESSAGE);

            if (opcion == JOptionPane.YES_OPTION) {
                for (int i = filasSeleccionadas.length - 1; i >= 0; i--) {
                    int idAdmision = (int) tblAdmisiones.getValueAt(filasSeleccionadas[i], 0);
                    Admision admisionEliminada = new Admision(idAdmision);
                    admisionDao.eliminarAdmision(admisionEliminada);
                }
                conexion.commit();
                JOptionPane.showMessageDialog(null, "Registros eliminados", "ATENCIÓN", JOptionPane.INFORMATION_MESSAGE);
            }
            this.listarEnTabla();
        } catch (HeadlessException | SQLException e) {
            System.out.println("Error el boton eliminar: " + e.toString());
            try {
                conexion.rollback();
            } catch (SQLException ex) {
                System.out.println("conexion.rollback(): " + ex.toString());
            }
        }
    }

}
