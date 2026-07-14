/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package ec.edu.ups.sistemabiblioteca.view.autor;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author Usuario
 */
public class CrearAutor extends javax.swing.JInternalFrame {

    /**
     * Creates new form CrearAutor
     */
    public CrearAutor() {
        initComponents();
    }

    public JButton getjButtonCACancelar() {
        return jButtonCACancelar;
    }

    public void setjButtonCACancelar(JButton jButtonCACancelar) {
        this.jButtonCACancelar = jButtonCACancelar;
    }

    public JButton getjButtonCACrear() {
        return jButtonCACrear;
    }

    public void setjButtonCACrear(JButton jButtonCACrear) {
        this.jButtonCACrear = jButtonCACrear;
    }

    public JTextField getjTextFieldCAApellido() {
        return jTextFieldCAApellido;
    }

    public void setjTextFieldCAApellido(JTextField jTextFieldCAApellido) {
        this.jTextFieldCAApellido = jTextFieldCAApellido;
    }

    public JTextField getjTextFieldCABibliografia() {
        return jTextFieldCABibliografia;
    }

    public void setjTextFieldCABibliografia(JTextField jTextFieldCABibliografia) {
        this.jTextFieldCABibliografia = jTextFieldCABibliografia;
    }

    public JTextField getjTextFieldCACedula() {
        return jTextFieldCACedula;
    }

    public void setjTextFieldCACedula(JTextField jTextFieldCACedula) {
        this.jTextFieldCACedula = jTextFieldCACedula;
    }

    public JTextField getjTextFieldCAFecha() {
        return jTextFieldCAFecha;
    }

    public void setjTextFieldCAFecha(JTextField jTextFieldCAFecha) {
        this.jTextFieldCAFecha = jTextFieldCAFecha;
    }

    public JTextField getjTextFieldCAGenero() {
        return jTextFieldCAGenero;
    }

    public void setjTextFieldCAGenero(JTextField jTextFieldCAGenero) {
        this.jTextFieldCAGenero = jTextFieldCAGenero;
    }

    public JTextField getjTextFieldCANacionalidad() {
        return jTextFieldCANacionalidad;
    }

    public void setjTextFieldCANacionalidad(JTextField jTextFieldCANacionalidad) {
        this.jTextFieldCANacionalidad = jTextFieldCANacionalidad;
    }

    public JTextField getjTextFieldCANombre() {
        return jTextFieldCANombre;
    }

    public void setjTextFieldCANombre(JTextField jTextFieldCANombre) {
        this.jTextFieldCANombre = jTextFieldCANombre;
    }

    public JTextField getjTextFieldCATelefono() {
        return jTextFieldCATelefono;
    }

    public void setjTextFieldCATelefono(JTextField jTextFieldCATelefono) {
        this.jTextFieldCATelefono = jTextFieldCATelefono;
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextFieldCATelefono = new javax.swing.JTextField();
        jLabelCAGenero = new javax.swing.JLabel();
        jLabelCACedula = new javax.swing.JLabel();
        jTextFieldCAGenero = new javax.swing.JTextField();
        jTextFieldCACedula = new javax.swing.JTextField();
        jLabelCAFecha = new javax.swing.JLabel();
        jLabelCANombre = new javax.swing.JLabel();
        jTextFieldCAFecha = new javax.swing.JTextField();
        jTextFieldCANombre = new javax.swing.JTextField();
        jButtonCACancelar = new javax.swing.JButton();
        jLabelCAApellido = new javax.swing.JLabel();
        jButtonCACrear = new javax.swing.JButton();
        jTextFieldCAApellido = new javax.swing.JTextField();
        jTextFieldCABibliografia = new javax.swing.JTextField();
        jLabelCANacionalidad = new javax.swing.JLabel();
        jLabelCABibliotecario = new javax.swing.JLabel();
        jTextFieldCANacionalidad = new javax.swing.JTextField();
        jLabelCATelefono = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabelCrearAutor = new javax.swing.JLabel();

        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Crear Autor");

        jLabelCAGenero.setText("Genero Literario:");

        jLabelCACedula.setText("Cedula:");

        jLabelCAFecha.setText("Fecha de Nacimiento:");

        jLabelCANombre.setText("Nombre:");

        jButtonCACancelar.setText("Cancelar");
        jButtonCACancelar.addActionListener(this::jButtonCACancelarActionPerformed);

        jLabelCAApellido.setText("Apellido:");

        jButtonCACrear.setBackground(new java.awt.Color(0, 102, 153));
        jButtonCACrear.setForeground(new java.awt.Color(255, 255, 255));
        jButtonCACrear.setText("Guardar");
        jButtonCACrear.addActionListener(this::jButtonCACrearActionPerformed);

        jLabelCANacionalidad.setText("Nacionalidad:");

        jLabelCABibliotecario.setText("Bibliografia:");

        jLabelCATelefono.setText("Telefono:");

        jPanel4.setBackground(new java.awt.Color(204, 204, 204));

        jLabelCrearAutor.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabelCrearAutor.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelCrearAutor.setText(" CREAR UN AUTOR");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelCrearAutor, javax.swing.GroupLayout.DEFAULT_SIZE, 249, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelCrearAutor)
                .addContainerGap(16, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabelCANombre)
                            .addGap(217, 217, 217))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabelCACedula)
                            .addGap(224, 224, 224))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabelCAApellido)
                            .addGap(217, 217, 217))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabelCANacionalidad)
                            .addGap(191, 191, 191))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabelCATelefono)
                            .addGap(214, 214, 214))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabelCAGenero)
                            .addGap(177, 177, 177))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabelCABibliotecario)
                            .addGap(201, 201, 201)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelCAFecha)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jTextFieldCACedula, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jTextFieldCANombre, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jTextFieldCAApellido, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jTextFieldCANacionalidad, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jTextFieldCATelefono, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jTextFieldCAGenero, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jTextFieldCAFecha, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jTextFieldCABibliografia, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGap(40, 40, 40))))
            .addGroup(layout.createSequentialGroup()
                .addGap(54, 54, 54)
                .addComponent(jButtonCACrear, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButtonCACancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabelCACedula)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextFieldCACedula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelCANombre)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextFieldCANombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelCAApellido)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextFieldCAApellido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelCANacionalidad)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextFieldCANacionalidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelCATelefono)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextFieldCATelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelCAGenero)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextFieldCAGenero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelCAFecha)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextFieldCAFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelCABibliotecario)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextFieldCABibliografia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonCACrear, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonCACancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonCACancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCACancelarActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_jButtonCACancelarActionPerformed

    private void jButtonCACrearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCACrearActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonCACrearActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonCACancelar;
    private javax.swing.JButton jButtonCACrear;
    private javax.swing.JLabel jLabelCAApellido;
    private javax.swing.JLabel jLabelCABibliotecario;
    private javax.swing.JLabel jLabelCACedula;
    private javax.swing.JLabel jLabelCAFecha;
    private javax.swing.JLabel jLabelCAGenero;
    private javax.swing.JLabel jLabelCANacionalidad;
    private javax.swing.JLabel jLabelCANombre;
    private javax.swing.JLabel jLabelCATelefono;
    private javax.swing.JLabel jLabelCrearAutor;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JTextField jTextFieldCAApellido;
    private javax.swing.JTextField jTextFieldCABibliografia;
    private javax.swing.JTextField jTextFieldCACedula;
    private javax.swing.JTextField jTextFieldCAFecha;
    private javax.swing.JTextField jTextFieldCAGenero;
    private javax.swing.JTextField jTextFieldCANacionalidad;
    private javax.swing.JTextField jTextFieldCANombre;
    private javax.swing.JTextField jTextFieldCATelefono;
    // End of variables declaration//GEN-END:variables
}
