package com.jhonatan.sistemahospital.Igu;

import java.awt.Color;

import javax.swing.JOptionPane;
import java.sql.*;

import com.jhonatan.sistemahospital.ClaseMain.Clases.Doctor;
import com.jhonatan.sistemahospital.ClasesEstaticas.ValidacionCamposDoctor;
import com.jhonatan.sistemahospital.ConexionBD.Conexion;
import com.jhonatan.sistemahospital.DaoImplementacion.ImpleDoctorDao;

public class registroDoctor extends javax.swing.JPanel {

    /*Instancias de tipo de ImpleDoctorDao y Doctor */
    ImpleDoctorDao impleDoctorDao = new ImpleDoctorDao();
    Doctor doctor = new Doctor();

    /* Variable de tipo conexion */
    Connection conexion = null;
    Conexion instanciaMYSQL = Conexion.getInstancia();

    public registroDoctor() {
        initComponents();
        InitStyles();
    }

    private void InitStyles() {
        folioLbl.putClientProperty("FlatLaf.styleClass", "large");
        folioLbl.setForeground(Color.black);
        libroIdLbl.putClientProperty("FlatLaf.styleClass", "large");
        libroIdLbl.setForeground(Color.black);
        txtNombre.putClientProperty("JTextField.placeholderText", "Ingrese el nombre del doctor.");
        txtApellido.putClientProperty("JTextField.placeholderText", "Ingrese el apellido del doctor.");
        txtEspecialidad.putClientProperty("JTextField.placeholderText", "Ingrese la especialida del doctor.");

    }

    private void limpiarCampos() {
        txtNombre.setText("");
        txtApellido.setText("");
        txtEspecialidad.setText("");
        txtNombre.requestFocus();
    }

 

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated
    // Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bg = new javax.swing.JPanel();
        jSeparator1 = new javax.swing.JSeparator();
        folioLbl = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        libroIdLbl = new javax.swing.JLabel();
        txtApellido = new javax.swing.JTextField();
        btnSubir = new javax.swing.JButton();
        image = new javax.swing.JLabel();
        txtEspecialidad = new javax.swing.JTextField();
        libroIdLbl1 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));

        bg.setBackground(new java.awt.Color(255, 255, 255));

        jSeparator1.setForeground(new java.awt.Color(204, 204, 204));
        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jSeparator1.setPreferredSize(new java.awt.Dimension(200, 10));

        folioLbl.setText("Nombre");

        txtNombre.setToolTipText("");

        libroIdLbl.setText("Apellido");

        btnSubir.setBackground(new java.awt.Color(18, 90, 173));
        btnSubir.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnSubir.setForeground(new java.awt.Color(255, 255, 255));
        btnSubir.setText("Prestar");
        btnSubir.setBorderPainted(false);
        btnSubir.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnSubir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSubirActionPerformed(evt);
            }
        });

        image.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        image.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/provincia (1).png"))); // NOI18N

        libroIdLbl1.setText("Especialida");

        javax.swing.GroupLayout bgLayout = new javax.swing.GroupLayout(bg);
        bg.setLayout(bgLayout);
        bgLayout.setHorizontalGroup(
                bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(bgLayout.createSequentialGroup()
                                .addComponent(image, javax.swing.GroupLayout.PREFERRED_SIZE, 428,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(22, 22, 22)
                                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(bgLayout.createSequentialGroup()
                                                .addGap(10, 10, 10)
                                                .addGroup(bgLayout
                                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(bgLayout.createSequentialGroup()
                                                                .addComponent(txtNombre)
                                                                .addContainerGap())
                                                        .addGroup(bgLayout.createSequentialGroup()
                                                                .addComponent(folioLbl,
                                                                        javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                        javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                        Short.MAX_VALUE)
                                                                .addGap(219, 219, 219))))
                                        .addGroup(bgLayout.createSequentialGroup()
                                                .addGroup(bgLayout
                                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(bgLayout.createSequentialGroup()
                                                                .addPreferredGap(
                                                                        javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                                .addGroup(bgLayout.createParallelGroup(
                                                                        javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addGroup(bgLayout.createSequentialGroup()
                                                                                .addComponent(libroIdLbl,
                                                                                        javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                        javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                        Short.MAX_VALUE)
                                                                                .addGap(223, 223, 223))
                                                                        .addComponent(txtApellido)
                                                                        .addComponent(btnSubir,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                Short.MAX_VALUE)))
                                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, bgLayout
                                                                .createSequentialGroup()
                                                                .addPreferredGap(
                                                                        javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addGroup(bgLayout.createParallelGroup(
                                                                        javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addGroup(bgLayout.createSequentialGroup()
                                                                                .addComponent(libroIdLbl1,
                                                                                        javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                        javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                        Short.MAX_VALUE)
                                                                                .addGap(223, 223, 223))
                                                                        .addComponent(txtEspecialidad))))
                                                .addContainerGap()))));
        bgLayout.setVerticalGroup(
                bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(image, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, bgLayout.createSequentialGroup()
                                .addGroup(bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(bgLayout.createSequentialGroup()
                                                .addGap(50, 50, 50)
                                                .addComponent(folioLbl, javax.swing.GroupLayout.DEFAULT_SIZE,
                                                        javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addGap(16, 16, 16)
                                                .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 40,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(libroIdLbl, javax.swing.GroupLayout.DEFAULT_SIZE,
                                                        javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addGap(16, 16, 16)
                                                .addComponent(txtApellido, javax.swing.GroupLayout.PREFERRED_SIZE, 40,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(libroIdLbl1, javax.swing.GroupLayout.DEFAULT_SIZE,
                                                        javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addGap(16, 16, 16)
                                                .addComponent(txtEspecialidad, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                        40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(35, 35, 35)
                                                .addComponent(btnSubir, javax.swing.GroupLayout.PREFERRED_SIZE, 50,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(bgLayout.createSequentialGroup()
                                                .addGap(20, 20, 20)
                                                .addComponent(jSeparator1, javax.swing.GroupLayout.DEFAULT_SIZE,
                                                        javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                .addGap(60, 60, 60)));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(bg, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
                                Short.MAX_VALUE));
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(bg, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
                                Short.MAX_VALUE));
    }// </editor-fold>//GEN-END:initComponents

    private void btnSubirActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnSubirActionPerformed
        System.out.println("");
        this.ingresarDatos();
    }// GEN-LAST:event_btnSubirActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel bg;
    private javax.swing.JButton btnSubir;
    private javax.swing.JLabel folioLbl;
    private javax.swing.JLabel image;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel libroIdLbl;
    private javax.swing.JLabel libroIdLbl1;
    private javax.swing.JTextField txtApellido;
    private javax.swing.JTextField txtEspecialidad;
    private javax.swing.JTextField txtNombre;
    // End of variables declaration//GEN-END:variables
}
