package com.jhonatan.sistemahospital.Igu;

import com.jhonatan.sistemahospital.ClaseMain.Clases.Paciente;
import com.jhonatan.sistemahospital.ConexionBD.Conexion;
import com.jhonatan.sistemahospital.DaoImplementacion.ImplePacienteDao;
import java.awt.Color;
import java.awt.HeadlessException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.sql.*;

public class Pacientes extends javax.swing.JPanel {
    
    ImplePacienteDao implePacienteDao = new ImplePacienteDao();
    private final String[] columnas = {"ID PACIENTE", "NOMBRE", "APELLIDO", "GENERO", "FECHA DE NACIMIENTO", "CIUDAD", "PROVINCIA", "ALERGIAS", "PESO", "ALTURA"};
    DefaultTableModel modelo = new DefaultTableModel(columnas, 0);
    /*variable de tipo conexion*/
    Connection conexion = null;
    Conexion instanciaMYSQL = Conexion.getInstancia();
    
    public Pacientes() {
        initComponents();
        InitStyles();
        //   this.listarTabla();
        this.listarEnTabla();
    }
    
    private void InitStyles() {
        lblTitulo.putClientProperty("FlatLaf.styleClass", "h1");
        lblTitulo.setForeground(Color.black);
        txtBuscar.putClientProperty("JTextField.placeholderText", "Ingrese el nombre del paciente a buscar.");
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bg = new javax.swing.JPanel();
        lblTitulo = new javax.swing.JLabel();
        txtBuscar = new javax.swing.JTextField();
        btnBuscar = new javax.swing.JButton();
        btnBorrar = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        btnNuevo = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblPacientes = new javax.swing.JTable();

        setBackground(new java.awt.Color(255, 255, 255));

        bg.setBackground(new java.awt.Color(255, 255, 255));

        lblTitulo.setText("Pacient");

        btnBuscar.setBackground(new java.awt.Color(18, 90, 173));
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

        btnBorrar.setBackground(new java.awt.Color(18, 90, 173));
        btnBorrar.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnBorrar.setForeground(new java.awt.Color(255, 255, 255));
        btnBorrar.setText("Borrar");
        btnBorrar.setBorderPainted(false);
        btnBorrar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnBorrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBorrarActionPerformed(evt);
            }
        });

        btnEditar.setBackground(new java.awt.Color(18, 90, 173));
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

        btnNuevo.setBackground(new java.awt.Color(18, 90, 173));
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

        tblPacientes.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        tblPacientes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Nombre", "Apellido", "Género", "Fecha Nacimiento", "Ciudad", "Provincia", "Alergias", "Peso", "Altura"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, true, true, true, true, true, true, true, true, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblPacientes.getTableHeader().setReorderingAllowed(false);
        tblPacientes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tblPacientesMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(tblPacientes);

        javax.swing.GroupLayout bgLayout = new javax.swing.GroupLayout(bg);
        bg.setLayout(bgLayout);
        bgLayout.setHorizontalGroup(
            bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bgLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(bgLayout.createSequentialGroup()
                        .addComponent(lblTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(699, 699, 699))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, bgLayout.createSequentialGroup()
                        .addGroup(bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(bgLayout.createSequentialGroup()
                                .addGap(427, 427, 427)
                                .addComponent(btnNuevo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnEditar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnBorrar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                .addComponent(lblTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 278, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnBorrar)
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

    private void tblPacientesMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblPacientesMousePressed

    }//GEN-LAST:event_tblPacientesMousePressed

    private void btnBorrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBorrarActionPerformed
        this.eliminarPaciente();
    }//GEN-LAST:event_btnBorrarActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        this.seleccionarPaciente();
    }//GEN-LAST:event_btnEditarActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        System.out.println("");
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed
        Dashboard.ShowJPanel(new RegistroPacientes());
    }//GEN-LAST:event_btnNuevoActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel bg;
    private javax.swing.JButton btnBorrar;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnNuevo;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JTable tblPacientes;
    private javax.swing.JTextField txtBuscar;
    // End of variables declaration//GEN-END:variables

    private void listarTabla() {
        try {
            DefaultTableModel model = (DefaultTableModel) tblPacientes.getModel();
            implePacienteDao.listarPacientes("").forEach(
                    (u) -> model.addRow(
                            new Object[]{u.getIdPaciente(),
                                u.getNombre(),
                                u.getApellido(),
                                u.getGenero(),
                                u.getFechaNacimiento(),
                                u.getCiudad(),
                                u.getIdProvincia(),
                                u.getAlergias(),
                                u.getPeso(),
                                u.getAltura()}
                    ));
        } catch (Exception e) {
            System.out.println("error al listar tabla: " + e.getMessage());
        }
    }
    
    private void listarEnTabla() {
        while (modelo.getRowCount() > 0) {
            modelo.removeRow(0);
        }
        implePacienteDao.listarTabla(modelo);
        tblPacientes.setModel(modelo);
    }
    
    private void eliminarPaciente() {
        int filasSeleccionadas[] = tblPacientes.getSelectedRows();
        if (filasSeleccionadas.length == 0) {
            JOptionPane.showMessageDialog(null, "Por favor selecciona una o más filas para eliminar.", "ATENCIÓN", JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        StringBuilder cantIds = new StringBuilder();
        for (int i = 0; i < filasSeleccionadas.length; i++) {
            String idPaciente = tblPacientes.getValueAt(filasSeleccionadas[i], 0).toString();
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
                    int idPaciente = (int) tblPacientes.getValueAt(filasSeleccionadas[i], 0);
                    Paciente pacienteEliminado = new Paciente(idPaciente);
                    implePacienteDao.eliminarPaciente(pacienteEliminado);
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
    
    private void seleccionarPaciente() {
        int fila[] = tblPacientes.getSelectedRows();
        if (fila.length == 0) {
            JOptionPane.showMessageDialog(null, "Por favor debe seleccionar una fila.", "ATENCIÓN", JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        if (fila.length > 1) {
            JOptionPane.showMessageDialog(null, "Por favor solo debe seleccionar una fila, no varias.", "ATENCIÓN", JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        int filaVerdad = tblPacientes.getSelectedRow();
        int idPaciente = (int) tblPacientes.getValueAt(filaVerdad, 0);
        Paciente paciente = implePacienteDao.obtenerInformacionPaciente(idPaciente);
        Dashboard.ShowJPanel(new RegistroPacientes(paciente));
    }
    
}
