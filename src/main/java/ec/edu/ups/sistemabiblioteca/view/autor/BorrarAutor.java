
package ec.edu.ups.sistemabiblioteca.view.autor;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class BorrarAutor extends javax.swing.JInternalFrame {

    public BorrarAutor() {
        initComponents();
    }

    public JButton getjButtonEABCedula() {
        return jButtonEABCedula;
    }

    public void setjButtonEABCedula(JButton jButtonEABCedula) {
        this.jButtonEABCedula = jButtonEABCedula;
    }

    public JButton getjButtonEACancelar() {
        return jButtonEACancelar;
    }

    public void setjButtonEACancelar(JButton jButtonEACancelar) {
        this.jButtonEACancelar = jButtonEACancelar;
    }

    public JButton getjButtonEAEliminar() {
        return jButtonEAEliminar;
    }

    public void setjButtonEAEliminar(JButton jButtonEAEliminar) {
        this.jButtonEAEliminar = jButtonEAEliminar;
    }

    public JTextField getjTextFieldEAApellido() {
        return jTextFieldEAApellido;
    }

    public void setjTextFieldEAApellido(JTextField jTextFieldEAApellido) {
        this.jTextFieldEAApellido = jTextFieldEAApellido;
    }

    public JTextField getjTextFieldEABibliografia() {
        return jTextFieldEABibliografia;
    }

    public void setjTextFieldEABibliografia(JTextField jTextFieldEABibliografia) {
        this.jTextFieldEABibliografia = jTextFieldEABibliografia;
    }

    public JTextField getjTextFieldEACedula() {
        return jTextFieldEACedula;
    }

    public void setjTextFieldEACedula(JTextField jTextFieldEACedula) {
        this.jTextFieldEACedula = jTextFieldEACedula;
    }

    public JTextField getjTextFieldEAFecha() {
        return jTextFieldEAFecha;
    }

    public void setjTextFieldEAFecha(JTextField jTextFieldEAFecha) {
        this.jTextFieldEAFecha = jTextFieldEAFecha;
    }

    public JTextField getjTextFieldEAGenero() {
        return jTextFieldEAGenero;
    }

    public void setjTextFieldEAGenero(JTextField jTextFieldEAGenero) {
        this.jTextFieldEAGenero = jTextFieldEAGenero;
    }

    public JTextField getjTextFieldEANacionalidad() {
        return jTextFieldEANacionalidad;
    }

    public void setjTextFieldEANacionalidad(JTextField jTextFieldEANacionalidad) {
        this.jTextFieldEANacionalidad = jTextFieldEANacionalidad;
    }

    public JTextField getjTextFieldEANombre() {
        return jTextFieldEANombre;
    }

    public void setjTextFieldEANombre(JTextField jTextFieldEANombre) {
        this.jTextFieldEANombre = jTextFieldEANombre;
    }

    public JTextField getjTextFieldEATelefono() {
        return jTextFieldEATelefono;
    }

    public void setjTextFieldEATelefono(JTextField jTextFieldEATelefono) {
        this.jTextFieldEATelefono = jTextFieldEATelefono;
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabelEAApellido = new javax.swing.JLabel();
        jTextFieldEATelefono = new javax.swing.JTextField();
        jButtonEAEliminar = new javax.swing.JButton();
        jLabelEAGenero = new javax.swing.JLabel();
        jTextFieldEAApellido = new javax.swing.JTextField();
        jLabelEACedula = new javax.swing.JLabel();
        jTextFieldEABibliografia = new javax.swing.JTextField();
        jTextFieldEAGenero = new javax.swing.JTextField();
        jLabelEANacionalidad = new javax.swing.JLabel();
        jTextFieldEACedula = new javax.swing.JTextField();
        jLabelEABibliotecario = new javax.swing.JLabel();
        jLabelEAFecha = new javax.swing.JLabel();
        jTextFieldEANacionalidad = new javax.swing.JTextField();
        jLabelEANombre = new javax.swing.JLabel();
        jLabelEATelefono = new javax.swing.JLabel();
        jTextFieldEAFecha = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        jLabelEliminarAutor = new javax.swing.JLabel();
        jTextFieldEANombre = new javax.swing.JTextField();
        jButtonEACancelar = new javax.swing.JButton();
        jButtonEABCedula = new javax.swing.JButton();

        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Borrar Autor");

        jLabelEAApellido.setText("Apellido:");

        jTextFieldEATelefono.setEditable(false);

        jButtonEAEliminar.setBackground(new java.awt.Color(0, 102, 153));
        jButtonEAEliminar.setForeground(new java.awt.Color(255, 255, 255));
        jButtonEAEliminar.setText("ELIMINAR");
        jButtonEAEliminar.addActionListener(this::jButtonEAEliminarActionPerformed);

        jLabelEAGenero.setText("Genero Literario:");

        jTextFieldEAApellido.setEditable(false);

        jLabelEACedula.setText("Cedula:");

        jTextFieldEABibliografia.setEditable(false);

        jTextFieldEAGenero.setEditable(false);

        jLabelEANacionalidad.setText("Nacionalidad:");

        jLabelEABibliotecario.setText("Bibliografia:");

        jLabelEAFecha.setText("Fecha de Nacimiento:");

        jTextFieldEANacionalidad.setEditable(false);

        jLabelEANombre.setText("Nombre:");

        jLabelEATelefono.setText("Telefono:");

        jTextFieldEAFecha.setEditable(false);

        jPanel4.setBackground(new java.awt.Color(204, 204, 204));

        jLabelEliminarAutor.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabelEliminarAutor.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelEliminarAutor.setText(" BORRAR UN AUTOR");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelEliminarAutor, javax.swing.GroupLayout.DEFAULT_SIZE, 249, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelEliminarAutor)
                .addContainerGap(16, Short.MAX_VALUE))
        );

        jTextFieldEANombre.setEditable(false);

        jButtonEACancelar.setText("Cancelar");
        jButtonEACancelar.addActionListener(this::jButtonEACancelarActionPerformed);

        jButtonEABCedula.setBackground(new java.awt.Color(0, 102, 153));
        jButtonEABCedula.setForeground(new java.awt.Color(255, 255, 255));
        jButtonEABCedula.setText("Buscar");
        jButtonEABCedula.addActionListener(this::jButtonEABCedulaActionPerformed);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabelEANombre)
                                    .addGap(217, 217, 217))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabelEACedula)
                                    .addGap(224, 224, 224))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabelEAApellido)
                                    .addGap(217, 217, 217))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabelEANacionalidad)
                                    .addGap(191, 191, 191))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabelEATelefono)
                                    .addGap(214, 214, 214))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabelEAGenero)
                                    .addGap(177, 177, 177))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabelEABibliotecario)
                                    .addGap(201, 201, 201)))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabelEAFecha)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(jTextFieldEANombre, javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jTextFieldEAApellido, javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jTextFieldEANacionalidad, javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jTextFieldEATelefono, javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jTextFieldEAGenero, javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jTextFieldEAFecha, javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jTextFieldEABibliografia, javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(jTextFieldEACedula)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addComponent(jButtonEABCedula, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addGap(40, 40, 40))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(54, 54, 54)
                        .addComponent(jButtonEAEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButtonEACancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabelEACedula)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldEACedula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonEABCedula))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelEANombre)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextFieldEANombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelEAApellido)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextFieldEAApellido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelEANacionalidad)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextFieldEANacionalidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelEATelefono)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextFieldEATelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelEAGenero)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextFieldEAGenero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelEAFecha)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextFieldEAFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelEABibliotecario)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextFieldEABibliografia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonEAEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonEACancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonEAEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEAEliminarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonEAEliminarActionPerformed

    private void jButtonEACancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEACancelarActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_jButtonEACancelarActionPerformed

    private void jButtonEABCedulaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEABCedulaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonEABCedulaActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonEABCedula;
    private javax.swing.JButton jButtonEACancelar;
    private javax.swing.JButton jButtonEAEliminar;
    private javax.swing.JLabel jLabelEAApellido;
    private javax.swing.JLabel jLabelEABibliotecario;
    private javax.swing.JLabel jLabelEACedula;
    private javax.swing.JLabel jLabelEAFecha;
    private javax.swing.JLabel jLabelEAGenero;
    private javax.swing.JLabel jLabelEANacionalidad;
    private javax.swing.JLabel jLabelEANombre;
    private javax.swing.JLabel jLabelEATelefono;
    private javax.swing.JLabel jLabelEliminarAutor;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JTextField jTextFieldEAApellido;
    private javax.swing.JTextField jTextFieldEABibliografia;
    private javax.swing.JTextField jTextFieldEACedula;
    private javax.swing.JTextField jTextFieldEAFecha;
    private javax.swing.JTextField jTextFieldEAGenero;
    private javax.swing.JTextField jTextFieldEANacionalidad;
    private javax.swing.JTextField jTextFieldEANombre;
    private javax.swing.JTextField jTextFieldEATelefono;
    // End of variables declaration//GEN-END:variables
}
