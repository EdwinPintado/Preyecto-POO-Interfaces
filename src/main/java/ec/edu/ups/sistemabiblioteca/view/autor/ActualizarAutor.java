package ec.edu.ups.sistemabiblioteca.view.autor;

import java.util.Locale;
import java.util.ResourceBundle;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class ActualizarAutor extends javax.swing.JInternalFrame {

    public ActualizarAutor() {
        initComponents();
    }

    public JButton getjButtonActABCedula() {
        return jButtonActABCedula;
    }

    public void setjButtonActABCedula(JButton jButtonActABCedula) {
        this.jButtonActABCedula = jButtonActABCedula;
    }

    public JButton getjButtonActACancelar() {
        return jButtonActACancelar;
    }

    public void setjButtonActACancelar(JButton jButtonActACancelar) {
        this.jButtonActACancelar = jButtonActACancelar;
    }

    public JButton getjButtonActAActualizar() {
        return jButtonActAActualizar;
    }

    public void setjButtonActAActualizar(JButton jButtonActAEliminar) {
        this.jButtonActAActualizar = jButtonActAEliminar;
    }

    public JTextField getjTextFieldActAApellido() {
        return jTextFieldActAApellido;
    }

    public void setjTextFieldActAApellido(JTextField jTextFieldActAApellido) {
        this.jTextFieldActAApellido = jTextFieldActAApellido;
    }

    public JTextField getjTextFieldActABibliografia() {
        return jTextFieldActABibliografia;
    }

    public void setjTextFieldActABibliografia(JTextField jTextFieldActABibliografia) {
        this.jTextFieldActABibliografia = jTextFieldActABibliografia;
    }

    public JTextField getjTextFieldActACedula() {
        return jTextFieldActACedula;
    }

    public void setjTextFieldActACedula(JTextField jTextFieldActACedula) {
        this.jTextFieldActACedula = jTextFieldActACedula;
    }

    public JTextField getjTextFieldActAFecha() {
        return jTextFieldActAFecha;
    }

    public void setjTextFieldActAFecha(JTextField jTextFieldActAFecha) {
        this.jTextFieldActAFecha = jTextFieldActAFecha;
    }

    public JTextField getjTextFieldActAGenero() {
        return jTextFieldActAGenero;
    }

    public void setjTextFieldActAGenero(JTextField jTextFieldActAGenero) {
        this.jTextFieldActAGenero = jTextFieldActAGenero;
    }

    public JTextField getjTextFieldActANacionalidad() {
        return jTextFieldActANacionalidad;
    }

    public void setjTextFieldActANacionalidad(JTextField jTextFieldActANacionalidad) {
        this.jTextFieldActANacionalidad = jTextFieldActANacionalidad;
    }

    public JTextField getjTextFieldActANombre() {
        return jTextFieldActANombre;
    }

    public void setjTextFieldActANombre(JTextField jTextFieldActANombre) {
        this.jTextFieldActANombre = jTextFieldActANombre;
    }

    public JTextField getjTextFieldActATelefono() {
        return jTextFieldActATelefono;
    }

    public void setjTextFieldActATelefono(JTextField jTextFieldActATelefono) {
        this.jTextFieldActATelefono = jTextFieldActATelefono;
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

        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel4 = new javax.swing.JPanel();
        jLabelActACedula = new javax.swing.JLabel();
        jTextFieldActACedula = new javax.swing.JTextField();
        jButtonActABCedula = new javax.swing.JButton();
        jLabelActANombre = new javax.swing.JLabel();
        jTextFieldActANombre = new javax.swing.JTextField();
        jLabelActAApellido = new javax.swing.JLabel();
        jTextFieldActAApellido = new javax.swing.JTextField();
        jLabelActANacionalidad = new javax.swing.JLabel();
        jTextFieldActANacionalidad = new javax.swing.JTextField();
        jLabelActATelefono = new javax.swing.JLabel();
        jTextFieldActATelefono = new javax.swing.JTextField();
        jLabelActAGenero = new javax.swing.JLabel();
        jTextFieldActAGenero = new javax.swing.JTextField();
        jLabelActAFecha = new javax.swing.JLabel();
        jTextFieldActAFecha = new javax.swing.JTextField();
        jLabelActABibliotecario = new javax.swing.JLabel();
        jTextFieldActABibliografia = new javax.swing.JTextField();
        jButtonActAActualizar = new javax.swing.JButton();
        jButtonActACancelar = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabelActualizarrAutor = new javax.swing.JLabel();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);

        jScrollPane1.setBackground(new java.awt.Color(153, 153, 153));
        jScrollPane1.setForeground(new java.awt.Color(102, 255, 255));

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));

        jLabelActACedula.setText("Cedula:");

        jButtonActABCedula.setBackground(new java.awt.Color(0, 102, 153));
        jButtonActABCedula.setForeground(new java.awt.Color(255, 255, 255));
        jButtonActABCedula.setText("Buscar");
        jButtonActABCedula.addActionListener(this::jButtonActABCedulaActionPerformed);

        jLabelActANombre.setText("Nombre:");

        jLabelActAApellido.setText("Apellido:");

        jLabelActANacionalidad.setText("Nacionalidad:");

        jLabelActATelefono.setText("Telefono:");

        jLabelActAGenero.setText("Genero Literario:");

        jLabelActAFecha.setText("Fecha de Nacimiento:");

        jLabelActABibliotecario.setText("Bibliografia:");

        jButtonActAActualizar.setBackground(new java.awt.Color(0, 102, 153));
        jButtonActAActualizar.setForeground(new java.awt.Color(255, 255, 255));
        jButtonActAActualizar.setText("ACTUALIZAR");
        jButtonActAActualizar.addActionListener(this::jButtonActAActualizarActionPerformed);

        jButtonActACancelar.setText("Cancelar");
        jButtonActACancelar.addActionListener(this::jButtonActACancelarActionPerformed);

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));

        jLabelActualizarrAutor.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabelActualizarrAutor.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelActualizarrAutor.setText(" ACTUALIZAR UN AUTOR");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabelActualizarrAutor, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(25, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelActualizarrAutor)
                .addContainerGap(13, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelActATelefono)
                            .addComponent(jLabelActAFecha)
                            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jTextFieldActAGenero, javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabelActANacionalidad)
                                    .addComponent(jTextFieldActANacionalidad, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jLabelActAGenero)
                            .addComponent(jTextFieldActATelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextFieldActAFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jTextFieldActANombre)
                                .addComponent(jLabelActANombre)
                                .addGroup(jPanel4Layout.createSequentialGroup()
                                    .addComponent(jTextFieldActACedula, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(jButtonActABCedula, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(jLabelActACedula))
                            .addComponent(jLabelActABibliotecario)
                            .addComponent(jTextFieldActABibliografia, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGap(1, 1, 1)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabelActAApellido)
                                    .addComponent(jTextFieldActAApellido, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(112, 112, 112)
                        .addComponent(jButtonActAActualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButtonActACancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 409, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addComponent(jLabelActACedula)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldActACedula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonActABCedula))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabelActANombre)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextFieldActANombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(jLabelActANacionalidad)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextFieldActANacionalidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabelActAGenero)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextFieldActAGenero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabelActABibliotecario)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextFieldActABibliografia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabelActAApellido)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextFieldActAApellido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(62, 62, 62))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabelActATelefono)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextFieldActATelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabelActAFecha)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextFieldActAFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 19, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonActAActualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonActACancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30))
        );

        jScrollPane1.setViewportView(jPanel4);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 311, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(62, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 423, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(61, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonActACancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonActACancelarActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_jButtonActACancelarActionPerformed

    private void jButtonActABCedulaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonActABCedulaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonActABCedulaActionPerformed

    private void jButtonActAActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonActAActualizarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonActAActualizarActionPerformed
    public void cambiarIdioma(Locale locale) {
        ResourceBundle bundle = ResourceBundle.getBundle("ec.edu.ups.sistemabiblioteca.i18n", locale);
        jButtonActABCedula.setText(bundle.getString("bttnBuscar"));
        jButtonActAActualizar.setText(bundle.getString("bttnUpd"));
        jButtonActACancelar.setText(bundle.getString("bttnCancelar"));
        jLabelActACedula.setText(bundle.getString("labelCedula"));
        jLabelActANombre.setText(bundle.getString("labelNombre "));
        jLabelActAApellido.setText(bundle.getString("labelApellido "));
        jLabelActANacionalidad.setText(bundle.getString("labelNacionalidad "));
        jLabelActATelefono.setText(bundle.getString("labelTelefono"));
        jLabelActAGenero.setText(bundle.getString("labelGT"));
        jLabelActAFecha.setText(bundle.getString("labelFN"));
        jLabelActABibliotecario.setText(bundle.getString("labelbL"));
        jLabelActualizarrAutor.setText(bundle.getString("TAudp"));

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonActAActualizar;
    private javax.swing.JButton jButtonActABCedula;
    private javax.swing.JButton jButtonActACancelar;
    private javax.swing.JLabel jLabelActAApellido;
    private javax.swing.JLabel jLabelActABibliotecario;
    private javax.swing.JLabel jLabelActACedula;
    private javax.swing.JLabel jLabelActAFecha;
    private javax.swing.JLabel jLabelActAGenero;
    private javax.swing.JLabel jLabelActANacionalidad;
    private javax.swing.JLabel jLabelActANombre;
    private javax.swing.JLabel jLabelActATelefono;
    private javax.swing.JLabel jLabelActualizarrAutor;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextFieldActAApellido;
    private javax.swing.JTextField jTextFieldActABibliografia;
    private javax.swing.JTextField jTextFieldActACedula;
    private javax.swing.JTextField jTextFieldActAFecha;
    private javax.swing.JTextField jTextFieldActAGenero;
    private javax.swing.JTextField jTextFieldActANacionalidad;
    private javax.swing.JTextField jTextFieldActANombre;
    private javax.swing.JTextField jTextFieldActATelefono;
    // End of variables declaration//GEN-END:variables
}
