/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package ec.edu.ups.sistemabiblioteca.view.autor;

import java.util.Locale;
import java.util.ResourceBundle;
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

    public void mostrarInformacion(String mensaje) {
        JOptionPane.showMessageDialog(this, mensaje);

    }

    public void mostrarInformacion1(String mensaje) {
        JOptionPane.showMessageDialog(this, mensaje);
        dispose();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel4 = new javax.swing.JPanel();
        jLabelCrearAutor = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();
        jButtonCACrear = new javax.swing.JButton();
        jButtonCACancelar = new javax.swing.JButton();
        jTextFieldCABibliografia = new javax.swing.JTextField();
        jLabelCABibliotecario = new javax.swing.JLabel();
        jLabelCAFecha = new javax.swing.JLabel();
        jTextFieldCAFecha = new javax.swing.JTextField();
        jTextFieldCAGenero = new javax.swing.JTextField();
        jLabelCAGenero = new javax.swing.JLabel();
        jTextFieldCATelefono = new javax.swing.JTextField();
        jLabelCATelefono = new javax.swing.JLabel();
        jTextFieldCANacionalidad = new javax.swing.JTextField();
        jLabelCANacionalidad = new javax.swing.JLabel();
        jTextFieldCAApellido = new javax.swing.JTextField();
        jLabelCAApellido = new javax.swing.JLabel();
        jTextFieldCANombre = new javax.swing.JTextField();
        jLabelCANombre = new javax.swing.JLabel();
        jLabelCACedula = new javax.swing.JLabel();
        jTextFieldCACedula = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();

        setBorder(null);
        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Crear Autor");
        setMaximumSize(new java.awt.Dimension(223456677, 232456899));
        setMinimumSize(new java.awt.Dimension(400, 12334));
        setPreferredSize(new java.awt.Dimension(565, 410));

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
                .addComponent(jLabelCrearAutor, javax.swing.GroupLayout.PREFERRED_SIZE, 299, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelCrearAutor)
                .addContainerGap(16, Short.MAX_VALUE))
        );

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jButtonCACrear.setBackground(new java.awt.Color(0, 102, 153));
        jButtonCACrear.setForeground(new java.awt.Color(255, 255, 255));
        jButtonCACrear.setText("Crear");
        jButtonCACrear.addActionListener(this::jButtonCACrearActionPerformed);

        jButtonCACancelar.setText("Cancelar");
        jButtonCACancelar.addActionListener(this::jButtonCACancelarActionPerformed);

        jLabelCABibliotecario.setText("Bibliografia:");

        jLabelCAFecha.setText("Fecha de Nacimiento:");

        jLabelCAGenero.setText("Genero Literario:");

        jLabelCATelefono.setText("Telefono:");

        jLabelCANacionalidad.setText("Nacionalidad:");

        jLabelCAApellido.setText("Apellido:");

        jLabelCANombre.setText("Nombre:");

        jLabelCACedula.setText("Cedula:");

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        jLabel1.setText("AAAA-MM-DD");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelCANombre)
                    .addComponent(jLabelCAApellido)
                    .addComponent(jLabelCANacionalidad)
                    .addComponent(jLabelCATelefono)
                    .addComponent(jLabelCAGenero)
                    .addComponent(jLabelCABibliotecario)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(jButtonCACrear, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButtonCACancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabelCAFecha)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel1))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jTextFieldCACedula, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jTextFieldCANombre, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jTextFieldCAApellido, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jTextFieldCANacionalidad, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jTextFieldCATelefono, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jTextFieldCAGenero, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jTextFieldCAFecha, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jTextFieldCABibliografia, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 261, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabelCACedula))
                .addContainerGap(83, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelCACedula)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
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
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelCAFecha)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextFieldCAFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelCABibliotecario)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextFieldCABibliografia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonCACrear, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonCACancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20))
        );

        jScrollPane1.setViewportView(jPanel1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(117, 117, 117)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 308, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(137, 137, 137))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 294, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33))
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

    public void cambiarIdioma(Locale locale) {
        ResourceBundle bundle = ResourceBundle.getBundle("ec.edu.ups.sistemabiblioteca.i18n", locale);
        jLabelCrearAutor.setText(bundle.getString("TAcrear"));
        jButtonCACrear.setText(bundle.getString("bttnCrear"));
        jButtonCACancelar.setText(bundle.getString("bttnCancelar"));
        jLabelCACedula.setText(bundle.getString("labelCACedula"));
        jLabelCANombre.setText(bundle.getString("labelCANombre"));
        jLabelCAApellido.setText(bundle.getString("labelCAApellido"));
        jLabelCANacionalidad.setText(bundle.getString("labelCANacionalidad"));
        jLabelCATelefono.setText(bundle.getString("labelCATelefono"));
        jLabelCAGenero.setText(bundle.getString("labelCAGT"));
        jLabelCAFecha.setText(bundle.getString("labelCAFN"));
        jLabelCABibliotecario.setText(bundle.getString("labelCAbL"));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonCACancelar;
    private javax.swing.JButton jButtonCACrear;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabelCAApellido;
    private javax.swing.JLabel jLabelCABibliotecario;
    private javax.swing.JLabel jLabelCACedula;
    private javax.swing.JLabel jLabelCAFecha;
    private javax.swing.JLabel jLabelCAGenero;
    private javax.swing.JLabel jLabelCANacionalidad;
    private javax.swing.JLabel jLabelCANombre;
    private javax.swing.JLabel jLabelCATelefono;
    private javax.swing.JLabel jLabelCrearAutor;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
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
