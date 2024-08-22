package com.jhonatan.sistemahospital.Igu;

import com.jhonatan.sistemahospital.ClaseMain.Clases.Paciente;
import com.jhonatan.sistemahospital.ClaseMain.Clases.Provincia;
import com.jhonatan.sistemahospital.ConexionBD.Conexion;
import com.jhonatan.sistemahospital.DaoImplementacion.ImplePacienteDao;
import java.awt.Color;
import java.awt.HeadlessException;
import java.util.List;
import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;

public class RegistroPacientes extends javax.swing.JPanel {

    ImplePacienteDao implePacienteDao = new ImplePacienteDao();

    /*variables parar poder conectarnos*/
    Connection conexion = null;
    Conexion instanciaMYSQL = Conexion.getInstancia();

    /*variables para editar un paciente*/
    private boolean isEdition = false;
    private Paciente pacienteEditado;

    public RegistroPacientes() {
        initComponents();
        InitStyles();
        this.llenarCombo();
    }

    /*constructor para editar*/
    public RegistroPacientes(Paciente paciente) {
        initComponents();
        this.isEdition = true;
        this.pacienteEditado = paciente;
        InitStyles();
    }

    private void InitStyles() {
        lblTitulo.putClientProperty("FlatLaf.styleClass", "h1");
        lblTitulo.setForeground(Color.black);
        txtNombre.putClientProperty("JTextField.placeholderText", "Ingrese el nombre del Paciente.");
        txtApellido.putClientProperty("JTextField.placeholderText", "Ingrese el apellido del Paciente.");
        txtFechaNacimiento.putClientProperty("JTextField.placeholderText", "Fecha de Nacimiento.");
        txtCiudad.putClientProperty("JTextField.placeholderText", "Ingrese la ciudad del Paciente");
        txtPeso.putClientProperty("JTextField.placeholderText", "Peso del Paciente");
        txtAltura.putClientProperty("JTextField.placeholderText", "Altura del Paciente.");
        if (isEdition) {
            lblTitulo.setText("Informacion del Paciente");
            btnSubir.setText("Guardar");

            if (pacienteEditado != null) {
                txtNombre.setText(pacienteEditado.getNombre());
                txtApellido.setText(pacienteEditado.getApellido());
                if (String.valueOf(pacienteEditado.getGenero()).equals("F")) {
                    rtbFemenino.setSelected(true);
                }

                if (String.valueOf(pacienteEditado.getGenero()).equals("M")) {
                    rtbMasculino.setSelected(true);
                }

                txtFechaNacimiento.setText(pacienteEditado.getFechaNacimiento().toString());
                txtCiudad.setText(pacienteEditado.getCiudad());
                txtAlergias.setText(pacienteEditado.getAlergias());
                llenarComboIUnaSolaProvincia(pacienteEditado.getIdProvincia());
                txtPeso.setText(pacienteEditado.getPeso() + "");
                txtAltura.setText(pacienteEditado.getAltura() + "");
            }
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        bg = new javax.swing.JPanel();
        lblTitulo = new javax.swing.JLabel();
        titleLbl = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        dateLbl = new javax.swing.JLabel();
        txtApellido = new javax.swing.JTextField();
        authorLbl = new javax.swing.JLabel();
        catLbl = new javax.swing.JLabel();
        txtFechaNacimiento = new javax.swing.JTextField();
        edLbl = new javax.swing.JLabel();
        txtCiudad = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        langLbl = new javax.swing.JLabel();
        pagsLbl = new javax.swing.JLabel();
        stockLbl = new javax.swing.JLabel();
        txtPeso = new javax.swing.JTextField();
        txtAltura = new javax.swing.JTextField();
        dispLbl = new javax.swing.JLabel();
        btnSubir = new javax.swing.JButton();
        rtbMasculino = new javax.swing.JRadioButton();
        rtbFemenino = new javax.swing.JRadioButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtAlergias = new javax.swing.JTextArea();
        cbxProvincia = new javax.swing.JComboBox<>();

        setBackground(new java.awt.Color(255, 255, 255));

        bg.setBackground(new java.awt.Color(255, 255, 255));

        lblTitulo.setText("Subir Paciente");

        titleLbl.setText("Nombre");

        dateLbl.setText("Apellido");

        authorLbl.setText("Género");

        catLbl.setText("Fe. Naci");

        edLbl.setText("Ciudad");

        txtCiudad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCiudadActionPerformed(evt);
            }
        });

        jSeparator1.setForeground(new java.awt.Color(204, 204, 204));
        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jSeparator1.setPreferredSize(new java.awt.Dimension(200, 10));

        langLbl.setText("Provincia");

        pagsLbl.setText("Alergias");

        stockLbl.setText("Peso");
        stockLbl.setToolTipText("");

        txtPeso.setToolTipText("");

        txtAltura.setToolTipText("");

        dispLbl.setText("Altura");

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

        buttonGroup1.add(rtbMasculino);
        rtbMasculino.setText("M");

        buttonGroup1.add(rtbFemenino);
        rtbFemenino.setText("F");

        txtAlergias.setColumns(20);
        txtAlergias.setRows(5);
        jScrollPane2.setViewportView(txtAlergias);

        cbxProvincia.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cbxProvinciaMouseClicked(evt);
            }
        });
        cbxProvincia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxProvinciaActionPerformed(evt);
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
                        .addGroup(bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(bgLayout.createSequentialGroup()
                                .addGroup(bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtFechaNacimiento)
                                    .addGroup(bgLayout.createSequentialGroup()
                                        .addComponent(authorLbl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGap(233, 233, 233))
                                    .addGroup(bgLayout.createSequentialGroup()
                                        .addComponent(catLbl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGap(213, 213, 213))
                                    .addGroup(bgLayout.createSequentialGroup()
                                        .addComponent(titleLbl, javax.swing.GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE)
                                        .addGap(234, 234, 234))
                                    .addComponent(txtNombre)
                                    .addGroup(bgLayout.createSequentialGroup()
                                        .addComponent(dateLbl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGap(161, 161, 161))
                                    .addComponent(txtApellido)
                                    .addComponent(txtCiudad, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(bgLayout.createSequentialGroup()
                                        .addComponent(edLbl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGap(227, 227, 227)))
                                .addGap(68, 68, 68))
                            .addGroup(bgLayout.createSequentialGroup()
                                .addGap(108, 108, 108)
                                .addComponent(rtbMasculino)
                                .addGap(18, 18, 18)
                                .addComponent(rtbFemenino)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(70, 70, 70)
                        .addGroup(bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(bgLayout.createSequentialGroup()
                                .addGroup(bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(bgLayout.createSequentialGroup()
                                        .addComponent(langLbl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGap(228, 228, 228))
                                    .addGroup(bgLayout.createSequentialGroup()
                                        .addComponent(pagsLbl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGap(223, 223, 223))
                                    .addComponent(btnSubir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, bgLayout.createSequentialGroup()
                                        .addGroup(bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txtPeso)
                                            .addGroup(bgLayout.createSequentialGroup()
                                                .addComponent(stockLbl, javax.swing.GroupLayout.DEFAULT_SIZE, 39, Short.MAX_VALUE)
                                                .addGap(94, 94, 94)))
                                        .addGap(20, 20, 20)
                                        .addGroup(bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(bgLayout.createSequentialGroup()
                                                .addComponent(dispLbl, javax.swing.GroupLayout.DEFAULT_SIZE, 81, Short.MAX_VALUE)
                                                .addGap(67, 67, 67))
                                            .addComponent(txtAltura)))
                                    .addComponent(jScrollPane2))
                                .addGap(72, 72, 72))
                            .addGroup(bgLayout.createSequentialGroup()
                                .addComponent(cbxProvincia, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(183, 183, 183))))
                    .addGroup(bgLayout.createSequentialGroup()
                        .addComponent(lblTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(553, 553, 553))))
        );
        bgLayout.setVerticalGroup(
            bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bgLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(bgLayout.createSequentialGroup()
                        .addComponent(langLbl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbxProvincia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(9, 9, 9)
                        .addComponent(pagsLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(stockLbl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(dispLbl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtPeso, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtAltura, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(78, 78, 78)
                        .addComponent(btnSubir, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jSeparator1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(bgLayout.createSequentialGroup()
                        .addComponent(titleLbl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(dateLbl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtApellido, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(authorLbl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(7, 7, 7)
                        .addGroup(bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(rtbMasculino)
                            .addComponent(rtbFemenino))
                        .addGap(3, 3, 3)
                        .addComponent(catLbl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtFechaNacimiento, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(edLbl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtCiudad, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)))
                .addGap(22, 22, 22))
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
        this.registrar();
    }//GEN-LAST:event_btnSubirActionPerformed

    private void txtCiudadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCiudadActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCiudadActionPerformed

    private void cbxProvinciaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxProvinciaActionPerformed
        this.getIdProvincia();
    }//GEN-LAST:event_cbxProvinciaActionPerformed

    private void cbxProvinciaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cbxProvinciaMouseClicked

        /*
        llenamos el combo otra vez
         */
        this.llenarCombo();
    }//GEN-LAST:event_cbxProvinciaMouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel authorLbl;
    private javax.swing.JPanel bg;
    private javax.swing.JButton btnSubir;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel catLbl;
    private javax.swing.JComboBox<String> cbxProvincia;
    private javax.swing.JLabel dateLbl;
    private javax.swing.JLabel dispLbl;
    private javax.swing.JLabel edLbl;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel langLbl;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JLabel pagsLbl;
    private javax.swing.JRadioButton rtbFemenino;
    private javax.swing.JRadioButton rtbMasculino;
    private javax.swing.JLabel stockLbl;
    private javax.swing.JLabel titleLbl;
    private javax.swing.JTextArea txtAlergias;
    private javax.swing.JTextField txtAltura;
    private javax.swing.JTextField txtApellido;
    private javax.swing.JTextField txtCiudad;
    private javax.swing.JTextField txtFechaNacimiento;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtPeso;
    // End of variables declaration//GEN-END:variables

    private void llenarCombo() {
        cbxProvincia.removeAllItems();
        List<Provincia> provincias = implePacienteDao.listarProvincias();
        for (Provincia provincia : provincias) {
            cbxProvincia.addItem(provincia.getNombre());
        }
    }

    private void llenarComboIUnaSolaProvincia(int idProvincia) {
        cbxProvincia.removeAllItems();
        List<Provincia> provincias = implePacienteDao.listarUnaSolaProvincia(idProvincia);
        for (Provincia provincia : provincias) {
            cbxProvincia.addItem(provincia.getNombre());
        }
    }

    private int getIdProvincia() {
        int idProvincia;
        idProvincia = (cbxProvincia.getSelectedIndex()) + 1;
        System.out.println(String.valueOf(idProvincia));
        return idProvincia;
    }

    private String validarDatos() {
        if (txtAlergias.getText().isBlank()) {
            txtAlergias.requestFocus();
            return "Alergias.";
        }

        if (txtAltura.getText().isBlank()) {
            txtAltura.requestFocus();
            return "Altura.";
        }

        if (txtApellido.getText().isBlank()) {
            txtApellido.requestFocus();
            return "Apellido.";
        }

        if (txtCiudad.getText().isBlank()) {
            txtCiudad.requestFocus();
            return "Ciudad.";
        }

        if (txtFechaNacimiento.getText().isBlank()) {
            txtFechaNacimiento.requestFocus();
            return "Fecha de Nacimiento.";
        }

        if (txtNombre.getText().isBlank()) {
            txtNombre.requestFocus();
            return "Nombre.";
        }

        if (txtPeso.getText().isBlank()) {
            txtPeso.requestFocus();
            return "Peso.";
        }

        if (buttonGroup1.getSelection() == null) {
            return "Sexo.";
        }
        return "";
    }

    public void limpiarCamposFormulario() {
        txtAlergias.setText("");
        txtAltura.setText("");
        txtApellido.setText("");
        txtCiudad.setText("");
        txtFechaNacimiento.setText("");
        txtNombre.setText("");
        txtPeso.setText("");
        txtNombre.requestFocus();
        cbxProvincia.setSelectedIndex(0);

    }

    private void registrar() {
        String mensaje = this.validarDatos();

        if (mensaje.equals("")) {
            try {
                conexion = instanciaMYSQL.conectarConBaseDatos();

                if (conexion.getAutoCommit()) {
                    conexion.setAutoCommit(false);
                }

                // atributos
                int idPaciente;
                String nombre;
                String apellido;
                char genero = 0;
                java.util.Date fechaNacimiento;
                String ciudad;
                int idProvincia;
                String alergias;
                double peso;
                double altura;

                nombre = txtNombre.getText();
                apellido = txtApellido.getText();

                //para el genero de la persona
                if (rtbMasculino.isSelected()) {
                    genero = 'M';
                }
                if (rtbFemenino.isSelected()) {
                    genero = 'F';
                }

                fechaNacimiento = this.obtenerFecha(txtFechaNacimiento.getText());

                ciudad = txtCiudad.getText();

                idProvincia = cbxProvincia.getSelectedIndex() + 1;

                alergias = txtAlergias.getText();

                peso = Double.parseDouble(txtPeso.getText());
                altura = Double.parseDouble(txtAltura.getText());

                System.out.println(idProvincia);

                //creamos el paciente
                Paciente paciente = new Paciente(nombre, apellido, genero, fechaNacimiento, ciudad, idProvincia, alergias, peso, altura);
                implePacienteDao.insertarPaciente(paciente);
                conexion.commit();
                JOptionPane.showMessageDialog(null, "Paciente registrado correctamente ", "REGISTRO DE DOCTOR",
                        JOptionPane.INFORMATION_MESSAGE);
                this.limpiarCamposFormulario();
            } catch (HeadlessException | NumberFormatException | SQLException e) {
                System.out.println("error en el boton registrar: " + e.getMessage());
                try {
                    conexion.rollback();
                } catch (SQLException ex) {
                    System.out.println("Error boton guardar paciente: " + ex.toString());
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "Por favor verificar el campo " + mensaje + "!.", "ATENCIÓN",
                    JOptionPane.INFORMATION_MESSAGE);
        }
    }

    private java.util.Date obtenerFecha(String fechaIngresada) {
        SimpleDateFormat formatoFecha = new SimpleDateFormat("yyyy-MM-dd");
        java.util.Date fecha = null;
        try {
            fecha = formatoFecha.parse(fechaIngresada);
        } catch (ParseException e) {
            System.out.println("error al convertir fecha " + e.getMessage());
        }
        return fecha;
    }
}
