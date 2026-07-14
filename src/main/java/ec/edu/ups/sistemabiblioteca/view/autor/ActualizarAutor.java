
package ec.edu.ups.sistemabiblioteca.view.autor;

import javax.swing.JButton;
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

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextFieldActANombre = new javax.swing.JTextField();
        jLabelActANacionalidad = new javax.swing.JLabel();
        jButtonActACancelar = new javax.swing.JButton();
        jTextFieldActACedula = new javax.swing.JTextField();
        jLabelActABibliotecario = new javax.swing.JLabel();
        jButtonActABCedula = new javax.swing.JButton();
        jLabelActAApellido = new javax.swing.JLabel();
        jLabelActAFecha = new javax.swing.JLabel();
        jTextFieldActATelefono = new javax.swing.JTextField();
        jTextFieldActANacionalidad = new javax.swing.JTextField();
        jButtonActAActualizar = new javax.swing.JButton();
        jLabelActANombre = new javax.swing.JLabel();
        jLabelActAGenero = new javax.swing.JLabel();
        jLabelActATelefono = new javax.swing.JLabel();
        jTextFieldActAApellido = new javax.swing.JTextField();
        jTextFieldActAFecha = new javax.swing.JTextField();
        jLabelActACedula = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabelActualizarrAutor = new javax.swing.JLabel();
        jTextFieldActABibliografia = new javax.swing.JTextField();
        jTextFieldActAGenero = new javax.swing.JTextField();

        jLabelActANacionalidad.setText("Nacionalidad:");

        jButtonActACancelar.setText("Cancelar");
        jButtonActACancelar.addActionListener(this::jButtonActACancelarActionPerformed);

        jLabelActABibliotecario.setText("Bibliografia:");

        jButtonActABCedula.setBackground(new java.awt.Color(0, 102, 153));
        jButtonActABCedula.setForeground(new java.awt.Color(255, 255, 255));
        jButtonActABCedula.setText("Buscar");
        jButtonActABCedula.addActionListener(this::jButtonActABCedulaActionPerformed);

        jLabelActAApellido.setText("Apellido:");

        jLabelActAFecha.setText("Fecha de Nacimiento:");

        jButtonActAActualizar.setBackground(new java.awt.Color(0, 102, 153));
        jButtonActAActualizar.setForeground(new java.awt.Color(255, 255, 255));
        jButtonActAActualizar.setText("ACTUALIZAR");
        jButtonActAActualizar.addActionListener(this::jButtonActAActualizarActionPerformed);

        jLabelActANombre.setText("Nombre:");

        jLabelActAGenero.setText("Genero Literario:");

        jLabelActATelefono.setText("Telefono:");

        jLabelActACedula.setText("Cedula:");

        jPanel4.setBackground(new java.awt.Color(204, 204, 204));

        jLabelActualizarrAutor.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabelActualizarrAutor.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelActualizarrAutor.setText(" ACTUALIZAR UN AUTOR");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelActualizarrAutor, javax.swing.GroupLayout.DEFAULT_SIZE, 249, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelActualizarrAutor)
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
                            .addComponent(jLabelActANombre)
                            .addGap(217, 217, 217))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabelActACedula)
                            .addGap(224, 224, 224))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabelActAApellido)
                            .addGap(217, 217, 217))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabelActANacionalidad)
                            .addGap(191, 191, 191))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabelActATelefono)
                            .addGap(214, 214, 214))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabelActAGenero)
                            .addGap(177, 177, 177))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabelActABibliotecario)
                            .addGap(201, 201, 201)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelActAFecha)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jTextFieldActANombre, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jTextFieldActAApellido, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jTextFieldActANacionalidad, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jTextFieldActATelefono, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jTextFieldActAGenero, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jTextFieldActAFecha, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jTextFieldActABibliografia, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jTextFieldActACedula)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(jButtonActABCedula, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(40, 40, 40))))
            .addGroup(layout.createSequentialGroup()
                .addGap(54, 54, 54)
                .addComponent(jButtonActAActualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButtonActACancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabelActACedula)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldActACedula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonActABCedula))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelActANombre)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextFieldActANombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelActAApellido)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextFieldActAApellido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelActANacionalidad)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextFieldActANacionalidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelActATelefono)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextFieldActATelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelActAGenero)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextFieldActAGenero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelActAFecha)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextFieldActAFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelActABibliotecario)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextFieldActABibliografia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonActAActualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonActACancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20))
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
    private javax.swing.JPanel jPanel4;
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
