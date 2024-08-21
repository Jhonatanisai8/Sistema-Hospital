package com.jhonatan.sistemahospital.Igu;

import com.jhonatan.sistemahospital.ClaseMain.Clases.Doctor;
import com.jhonatan.sistemahospital.ConexionBD.Conexion;
import com.jhonatan.sistemahospital.DaoImplementacion.ImpleDoctorDao;
import java.awt.Color;
import java.awt.HeadlessException;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

public class Doctores extends javax.swing.JPanel {

    /*instancia de la clase clase ImpleDoctorDao*/
    ImpleDoctorDao impleDoctorDao = new ImpleDoctorDao();
    final String[] itulos = {"ID DOCTOR", "NOMBRE", "APELLIDO", "ESPECIALIDAD"};
    DefaultTableModel modelo = new DefaultTableModel(itulos, 0);

    /*variables para busccar*/
    private TableRowSorter tbRowSorter;
    String filtroNombre;

    /*variables de conexion */
    Connection conexion = null;
    Conexion instanciaMYSQL = Conexion.getInstancia();

    public Doctores() {
        initComponents();
        InitStyles();
        tblDoctores.setModel(modelo);
        /*this.mostrarListaDoctores(modelo, tblDoctores);*/
        this.mostrarListaDoctores();
    }

    /*
    private void mostrarListaDoctores(DefaultTableModel model, JTable tblDoctores) {
        try {
            modelo = (DefaultTableModel) tblDoctores.getModel();
            impleDoctorDao.listarDoctores().forEach((u) -> model.addRow(new Object[]{u.getIdDoctor(), u.getNombre(), u.getApellido(), u.getEspecialidad()}));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al listar en tabla", "ATENCIÓN", JOptionPane.WARNING_MESSAGE);
        }
    }
     */
    private void filtroNombre() {
        if (txtBuscar == null) {
        } else {
            try {
                filtroNombre = txtBuscar.getText();
                tbRowSorter.setRowFilter(RowFilter.regexFilter(filtroNombre, 1));
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Error al buscar: " + e.toString(), "ATENCIÓN", JOptionPane.WARNING_MESSAGE);
            }
        }
    }

    private void buscar() {
        txtBuscar.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(final KeyEvent e) {
                String cadena = txtBuscar.getText();
                txtBuscar.setText(cadena);
                repaint();

                // Verificar si trsFiltro está inicializado antes de llamar a filtro()
                if (tbRowSorter != null) {
                    filtroNombre();
                }
            }
        });
    }

    private void InitStyles() {
        title.putClientProperty("FlatLaf.styleClass", "h1");
        title.setForeground(Color.black);
        txtBuscar.putClientProperty("JTextField.placeholderText", "Ingrese el nombre del doctor a buscar.");
    }

    private void mostrarListaDoctores() {
        impleDoctorDao.mostrarLista(modelo, tblDoctores);
    }

    private void eliminarDoctor() {
        int idDoctor, filaSeleccionadas[];

        /*Obtenemos el número de filas seleccionadas*/
        filaSeleccionadas = tblDoctores.getSelectedRows();

        if (filaSeleccionadas.length == 0) {
            JOptionPane.showMessageDialog(null, "Por favor seleccionar una o mas filas para "
                    + "\npoder eliminae!.", "ATENCIÓN", JOptionPane.WARNING_MESSAGE);
            return;
        }

        String cantIds = "";
        for (int i = 0; i < filaSeleccionadas.length; i++) {
            int idsDoctores = (int) tblDoctores.getValueAt(filaSeleccionadas[i], 0);
            if (!cantIds.isBlank()) {
                cantIds += ", ";
            }
            cantIds += idsDoctores;
        }

        try {
            conexion = instanciaMYSQL.conectarConBaseDatos();
            if (conexion.getAutoCommit()) {
                conexion.setAutoCommit(false);
            }
            int opcion = JOptionPane.showConfirmDialog(null, "¿Estas seguro de eliminar los registros con ID:" + cantIds + " ?", "ATENCIÓN", JOptionPane.WARNING_MESSAGE);
            /*si la opcion es si */
            if (opcion == 0) {
                for (int i = filaSeleccionadas.length - 1; i >= 0; i--) {
                    idDoctor = (int) tblDoctores.getValueAt(filaSeleccionadas[i], 0);
                    Doctor doctorEliminado = new Doctor(idDoctor);

                    /*llamamos al metodo de la clase impledotr*/
                    impleDoctorDao.eliminarDoctor(doctorEliminado);
                    //modelo.removeRow(filaSeleccionadas[i]);

                    /*hace un commit osea una confirmacion*/
                    conexion.commit();
                }
                /*si el usuario decide buscar el nombre y elimar el doctor*/
                this.mostrarListaDoctores();
                JOptionPane.showMessageDialog(null, "Registros Eliminados", "ATENCION", JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (HeadlessException | SQLException e) {
            System.out.println("Error el boton eliminar: " + e.toString());
            try {
                conexion.rollback();
            } catch (SQLException ex) {
                System.out.println("conexion.rollback(): " + ex.toString());
            }
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bg = new javax.swing.JPanel();
        title = new javax.swing.JLabel();
        txtBuscar = new javax.swing.JTextField();
        btnBuscar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblDoctores = new javax.swing.JTable();
        btnBorrar = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        btnNuevo = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));

        bg.setBackground(new java.awt.Color(255, 255, 255));

        title.setText("Doctores");

        txtBuscar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtBuscarMouseClicked(evt);
            }
        });
        txtBuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtBuscarKeyTyped(evt);
            }
        });

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

        tblDoctores.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        tblDoctores.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Nombre", "Apellido", "Especialidad"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, true, true, true
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
        jScrollPane1.setViewportView(tblDoctores);

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
                                .addComponent(btnBorrar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 272, javax.swing.GroupLayout.PREFERRED_SIZE)
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

    private void tblDoctoresMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblDoctoresMousePressed

    }//GEN-LAST:event_tblDoctoresMousePressed

    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed
        Dashboard.ShowJPanel(new Registro_Doctor());
    }//GEN-LAST:event_btnNuevoActionPerformed

    private void btnBorrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBorrarActionPerformed
        this.eliminarDoctor();
    }//GEN-LAST:event_btnBorrarActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        this.selecionarDoctorEditar();
    }//GEN-LAST:event_btnEditarActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        if (txtBuscar.getText().trim().isBlank()) {
            JOptionPane.showMessageDialog(null, "Por favor ingrese el  nombre " + "\n del doctor a buscar", "ATENCIÓN", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void txtBuscarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtBuscarMouseClicked
        this.buscar();
    }//GEN-LAST:event_txtBuscarMouseClicked

    private void txtBuscarKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarKeyTyped
        tbRowSorter = new TableRowSorter(tblDoctores.getModel());
        tblDoctores.setRowSorter(tbRowSorter);
    }//GEN-LAST:event_txtBuscarKeyTyped


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel bg;
    private javax.swing.JButton btnBorrar;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnNuevo;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblDoctores;
    private javax.swing.JLabel title;
    private javax.swing.JTextField txtBuscar;
    // End of variables declaration//GEN-END:variables

    private void selecionarDoctorEditar() {
        int fila = tblDoctores.getSelectedRow();

        if (fila > -1) {
            try {
                int idDoctor = (int) tblDoctores.getValueAt(fila, 0);
                Doctor doctor = impleDoctorDao.obtenerInformacion(idDoctor);

                /*llamamos al formulario*/
                Dashboard.ShowJPanel(new Registro_Doctor(doctor));
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Error al selecionar fila.", "ATENCIÓN", JOptionPane.WARNING_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(null, """
                                                Por favor selecione una fila
                                                 para poder editar la informacion del Doctor.""", "ATENCIÓN", JOptionPane.WARNING_MESSAGE);
        }
    }
}
