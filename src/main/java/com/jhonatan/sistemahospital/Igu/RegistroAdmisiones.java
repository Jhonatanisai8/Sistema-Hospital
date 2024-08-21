package com.jhonatan.sistemahospital.Igu;

import com.jhonatan.sistemahospital.ClaseMain.Clases.Admision;
import com.jhonatan.sistemahospital.ClasesEstaticas.ValidarCamposRegistroAdmision;
import com.jhonatan.sistemahospital.ConexionBD.Conexion;
import com.jhonatan.sistemahospital.DaoImplementacion.ImpleAdmisionDao;
import java.sql.*;
import java.awt.Color;
import java.awt.HeadlessException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class RegistroAdmisiones extends javax.swing.JPanel {

    ImpleAdmisionDao admisionDao = new ImpleAdmisionDao();
    private final String[] columnasPacientes = {"ID PACIENTE", "NOMBRE"};
    DefaultTableModel modeloPacientes = new DefaultTableModel(columnasPacientes, 0);

    private final String[] columnasDoctores = {"ID DOCTOR", "NOMBRE"};
    DefaultTableModel modeloDoctores = new DefaultTableModel(columnasDoctores, 0);
    /*variable de tipo conexion*/
    Connection conexion = null;
    Conexion instanciaMYSQL = Conexion.getInstancia();

    public RegistroAdmisiones() {
        initComponents();
        InitStyles();
        this.listarPacientes();
        this.listarDoctores();
    }

    private void InitStyles() {
        title.putClientProperty("FlatLaf.styleClass", "h1");
        title.setForeground(Color.black);
        txtBuscar.putClientProperty("JTextField.placeholderText", "Ingrese el nombre de usuario a buscar.");
        txtFechaAlta.putClientProperty("JTextField.placeholderText", "Ingrese la fecha de Alta.");
        txtFechaIngreso.putClientProperty("JTextField.placeholderText", "Ingrese la fecha de Ingreso.");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bg = new javax.swing.JPanel();
        title = new javax.swing.JLabel();
        txtBuscar = new javax.swing.JTextField();
        btnBuscar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblPacientez = new javax.swing.JTable();
        btnBorrar = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        btnNueva = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblDoctores = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        txtFechaIngreso = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtFechaAlta = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        txtDiagnostico = new javax.swing.JTextArea();

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

        tblPacientez.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        tblPacientez.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID Paciente", "Nombre"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblPacientez.getTableHeader().setReorderingAllowed(false);
        tblPacientez.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tblPacientezMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(tblPacientez);

        btnBorrar.setBackground(new java.awt.Color(0, 153, 255));
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

        btnNueva.setBackground(new java.awt.Color(0, 153, 255));
        btnNueva.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnNueva.setForeground(new java.awt.Color(255, 255, 255));
        btnNueva.setText("Save");
        btnNueva.setBorderPainted(false);
        btnNueva.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnNueva.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevaActionPerformed(evt);
            }
        });

        tblDoctores.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        tblDoctores.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID Doctor", "Nombre"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblDoctores.getTableHeader().setReorderingAllowed(false);
        tblDoctores.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tblDoctoresMousePressed(evt);
            }
        });
        jScrollPane2.setViewportView(tblDoctores);

        jLabel1.setText("Fecha de Ingreso:");

        txtFechaIngreso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFechaIngresoActionPerformed(evt);
            }
        });

        jLabel2.setText("Fecha de Alta:");

        txtFechaAlta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFechaAltaActionPerformed(evt);
            }
        });

        jLabel3.setText("Diagnostico");

        txtDiagnostico.setColumns(20);
        txtDiagnostico.setRows(5);
        jScrollPane3.setViewportView(txtDiagnostico);

        javax.swing.GroupLayout bgLayout = new javax.swing.GroupLayout(bg);
        bg.setLayout(bgLayout);
        bgLayout.setHorizontalGroup(
            bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bgLayout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addGap(60, 60, 60)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addGap(89, 89, 89))
            .addGroup(bgLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(160, 160, 160)
                .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(131, 131, 131))
            .addGroup(bgLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtFechaAlta)
                    .addComponent(txtFechaIngreso, javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, bgLayout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(90, 90, 90)))
                .addGroup(bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(bgLayout.createSequentialGroup()
                        .addGap(70, 70, 70)
                        .addComponent(jScrollPane3)
                        .addGap(61, 61, 61))
                    .addGroup(bgLayout.createSequentialGroup()
                        .addGap(133, 133, 133)
                        .addComponent(btnNueva, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)
                        .addComponent(btnEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)
                        .addComponent(btnBorrar, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(50, 50, 50))))
            .addGroup(bgLayout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addGroup(bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(title, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(bgLayout.createSequentialGroup()
                        .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 612, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(btnBuscar)))
                .addGap(0, 50, Short.MAX_VALUE))
        );
        bgLayout.setVerticalGroup(
            bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bgLayout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(title, javax.swing.GroupLayout.PREFERRED_SIZE, 11, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addGroup(bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(9, 9, 9)
                .addGroup(bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(bgLayout.createSequentialGroup()
                        .addComponent(txtFechaIngreso, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtFechaAlta, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(bgLayout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addGroup(bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnNueva)
                            .addComponent(btnEditar)
                            .addComponent(btnBorrar)))))
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

    private void btnNuevaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevaActionPerformed
        this.registrarAdmision();
    }//GEN-LAST:event_btnNuevaActionPerformed

    private void btnBorrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBorrarActionPerformed
        System.out.println("");
    }//GEN-LAST:event_btnBorrarActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        System.out.println("");
    }//GEN-LAST:event_btnEditarActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        System.out.println("");
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void txtFechaIngresoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFechaIngresoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFechaIngresoActionPerformed

    private void txtFechaAltaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFechaAltaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFechaAltaActionPerformed

    private void tblPacientezMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblPacientezMousePressed

    }//GEN-LAST:event_tblPacientezMousePressed

    private void tblDoctoresMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblDoctoresMousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_tblDoctoresMousePressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel bg;
    private javax.swing.JButton btnBorrar;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnNueva;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable tblDoctores;
    private javax.swing.JTable tblPacientez;
    private javax.swing.JLabel title;
    private javax.swing.JTextField txtBuscar;
    private javax.swing.JTextArea txtDiagnostico;
    private javax.swing.JTextField txtFechaAlta;
    private javax.swing.JTextField txtFechaIngreso;
    // End of variables declaration//GEN-END:variables

    private void listarPacientes() {
        while (modeloPacientes.getRowCount() > 0) {
            modeloPacientes.removeRow(0);
        }
        admisionDao.listarEnTablaPacientes(modeloPacientes, "");
        tblPacientez.setModel(modeloPacientes);
    }

    private void listarDoctores() {
        while (modeloDoctores.getRowCount() > 0) {
            modeloDoctores.removeRow(0);
        }
        admisionDao.listarEnTablaPacientes(modeloDoctores, "123456");
        tblDoctores.setModel(modeloDoctores);
    }

    private void registrarAdmision() {
        String mensaje = ValidarCamposRegistroAdmision.validarCamposADmicion(tblPacientez, tblDoctores, txtFechaIngreso, txtFechaAlta, txtDiagnostico);
        if (mensaje.equals("")) {
            try {
                conexion = instanciaMYSQL.conectarConBaseDatos();
                if (conexion.getAutoCommit()) {
                    conexion.setAutoCommit(false);
                }
                int idPaciente;
                java.util.Date fechaAdmision;
                java.util.Date fechaAlta;
                String diagnostico;
                int idDoctor;

                int filaIdPaciente = tblPacientez.getSelectedRow();
                idPaciente = (int) tblPacientez.getValueAt(filaIdPaciente, 0);

                fechaAdmision = ValidarCamposRegistroAdmision.obtenerFecha(txtFechaIngreso.getText());
                fechaAlta = ValidarCamposRegistroAdmision.obtenerFecha(txtFechaAlta.getText());
                System.out.println(fechaAdmision);
                System.out.println(fechaAlta);

                int filaIdDoctor = tblDoctores.getSelectedRow();
                idDoctor = (int) tblDoctores.getValueAt(filaIdDoctor, 0);

                diagnostico = txtDiagnostico.getText();

                //creamos el objetos
                Admision admisionNueva = new Admision(idPaciente, fechaAdmision, fechaAlta, diagnostico, idDoctor);

                admisionDao.insertarAdmision(admisionNueva);

                conexion.commit();
                JOptionPane.showMessageDialog(null, "Admición Registrado", "ATENCIÓN", JOptionPane.INFORMATION_MESSAGE);
                limpiarCampos();
            } catch (HeadlessException | SQLException e) {
                System.out.println("error en el boton registrar: " + e.getMessage());
                try {
                    conexion.rollback();
                } catch (SQLException ex) {
                    System.out.println("Error al guardar admision boton: " + ex.toString());
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "Verificar el campo: " + mensaje, "ATENCIÓN", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    private void limpiarCampos(){
        txtDiagnostico.setText("");
        txtFechaAlta.setText("");
        txtFechaIngreso.setText("");
        listarDoctores();
        listarPacientes();
    }
}
