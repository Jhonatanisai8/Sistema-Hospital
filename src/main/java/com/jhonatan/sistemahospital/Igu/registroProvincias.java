package com.jhonatan.sistemahospital.Igu;

import com.jhonatan.sistemahospital.ClaseMain.Clases.Provincia;
import com.jhonatan.sistemahospital.ConexionBD.Conexion;
import com.jhonatan.sistemahospital.DaoImplementacion.ImpleProvinciaDao;
import java.awt.Color;
import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class registroProvincias extends javax.swing.JPanel {

    ImpleProvinciaDao impleProvinciaDao = new ImpleProvinciaDao();
    Provincia provincia = new Provincia();

    /*conexion*/
    Connection conexion = null;
    Conexion instanciaMYSQL = Conexion.getInstancia();

    public registroProvincias() {
        initComponents();
        InitStyles();
        txtID.setEnabled(false);
        txtID.setEnabled(false);
    }

    private void InitStyles() {
        folioLbl.putClientProperty("FlatLaf.styleClass", "large");
        folioLbl.setForeground(Color.black);
        libroIdLbl.putClientProperty("FlatLaf.styleClass", "large");
        libroIdLbl.setForeground(Color.black);
        txtID.putClientProperty("JTextField.placeholderText", "Ingrese el folio del usuario.");
        txtNombre.putClientProperty("JTextField.placeholderText", "Ingrese el ID del Libro a prestar.");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bg = new javax.swing.JPanel();
        jSeparator1 = new javax.swing.JSeparator();
        folioLbl = new javax.swing.JLabel();
        txtID = new javax.swing.JTextField();
        libroIdLbl = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        btnSubir = new javax.swing.JButton();
        image = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));

        bg.setBackground(new java.awt.Color(255, 255, 255));

        jSeparator1.setForeground(new java.awt.Color(204, 204, 204));
        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jSeparator1.setPreferredSize(new java.awt.Dimension(200, 10));

        folioLbl.setText("ID");

        txtID.setToolTipText("");

        libroIdLbl.setText("Nombre");

        btnSubir.setBackground(new java.awt.Color(18, 90, 173));
        btnSubir.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnSubir.setForeground(new java.awt.Color(255, 255, 255));
        btnSubir.setText("Subir");
        btnSubir.setBorderPainted(false);
        btnSubir.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnSubir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSubirActionPerformed(evt);
            }
        });

        image.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        image.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/provincia (1).png"))); // NOI18N

        javax.swing.GroupLayout bgLayout = new javax.swing.GroupLayout(bg);
        bg.setLayout(bgLayout);
        bgLayout.setHorizontalGroup(
            bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bgLayout.createSequentialGroup()
                .addComponent(image, javax.swing.GroupLayout.PREFERRED_SIZE, 428, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addGroup(bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(bgLayout.createSequentialGroup()
                        .addComponent(folioLbl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(199, 199, 199))
                    .addComponent(txtID)
                    .addGroup(bgLayout.createSequentialGroup()
                        .addComponent(libroIdLbl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(223, 223, 223))
                    .addComponent(txtNombre)
                    .addComponent(btnSubir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(20, 20, 20))
        );
        bgLayout.setVerticalGroup(
            bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bgLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jSeparator1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(60, 60, 60))
            .addGroup(bgLayout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(folioLbl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(16, 16, 16)
                .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(libroIdLbl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(16, 16, 16)
                .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50)
                .addComponent(btnSubir, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(110, 110, 110))
            .addComponent(image, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
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

    private void btnSubirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSubirActionPerformed
        this.registrarProvincia();
    }//GEN-LAST:event_btnSubirActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel bg;
    private javax.swing.JButton btnSubir;
    private javax.swing.JLabel folioLbl;
    private javax.swing.JLabel image;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel libroIdLbl;
    private javax.swing.JTextField txtID;
    private javax.swing.JTextField txtNombre;
    // End of variables declaration//GEN-END:variables

    private void limpiarCampos() {
        txtNombre.setText("");
    }

    private void registrarProvincia() {
        String mensaje = this.validadCampos8(txtNombre);
        int idProvincia;
        String nombre;
        if (mensaje.equals("")) {
            try {
                conexion = instanciaMYSQL.conectarConBaseDatos();

                if (conexion.getAutoCommit()) {
                    conexion.setAutoCommit(false);
                }

                nombre = txtNombre.getText();

                provincia = new Provincia(nombre);
                impleProvinciaDao.insertarProvincia(provincia);

                conexion.commit();

                JOptionPane.showMessageDialog(null, "Provincia con nombre: " + provincia.getNombre() + " registrada.", "ATENCIÓN", JOptionPane.INFORMATION_MESSAGE);
                this.limpiarCampos();
            } catch (HeadlessException | SQLException e) {
                System.out.println("Error al insertar ooton:  " + e.getMessage());
                try {
                    conexion.rollback();
                } catch (SQLException ex) {
                    System.out.println("Error al insertar boton: " + ex.getMessage());
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "Por Favor verificar el campo " + mensaje, "ATENCIÓN", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    private String validadCampos8(JTextField txtNombre2) {
        if (txtNombre2.getText().trim().isEmpty()) {
            txtNombre2.requestFocus();
            return "Nombre";
        }
        return "";
    }
}
