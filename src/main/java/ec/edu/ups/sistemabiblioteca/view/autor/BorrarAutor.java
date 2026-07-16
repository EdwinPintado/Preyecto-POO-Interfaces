package ec.edu.ups.sistemabiblioteca.view.autor;

import java.util.Locale;
import java.util.ResourceBundle;
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
        jLabelEliminarAutor = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel2 = new javax.swing.JPanel();
        jLabelEACedula = new javax.swing.JLabel();
        jTextFieldEACedula = new javax.swing.JTextField();
        jButtonEABCedula = new javax.swing.JButton();
        jLabelEANombre = new javax.swing.JLabel();
        jTextFieldEANombre = new javax.swing.JTextField();
        jLabelEAApellido = new javax.swing.JLabel();
        jTextFieldEAApellido = new javax.swing.JTextField();
        jLabelEANacionalidad = new javax.swing.JLabel();
        jTextFieldEANacionalidad = new javax.swing.JTextField();
        jLabelEATelefono = new javax.swing.JLabel();
        jTextFieldEATelefono = new javax.swing.JTextField();
        jLabelEAGenero = new javax.swing.JLabel();
        jTextFieldEAGenero = new javax.swing.JTextField();
        jLabelEAFecha = new javax.swing.JLabel();
        jTextFieldEAFecha = new javax.swing.JTextField();
        jLabelEABibliotecario = new javax.swing.JLabel();
        jTextFieldEABibliografia = new javax.swing.JTextField();
        jButtonEAEliminar = new javax.swing.JButton();
        jButtonEACancelar = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setTitle("Borrar Autor");

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
                .addComponent(jLabelEliminarAutor, javax.swing.GroupLayout.DEFAULT_SIZE, 366, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelEliminarAutor)
                .addContainerGap(16, Short.MAX_VALUE))
        );

        jScrollPane1.setBackground(new java.awt.Color(255, 255, 255));

        jLabelEACedula.setText("Cedula:");

        jButtonEABCedula.setBackground(new java.awt.Color(0, 102, 153));
        jButtonEABCedula.setForeground(new java.awt.Color(255, 255, 255));
        jButtonEABCedula.setText("Buscar");
        jButtonEABCedula.addActionListener(this::jButtonEABCedulaActionPerformed);

        jLabelEANombre.setText("Nombre:");

        jTextFieldEANombre.setEditable(false);

        jLabelEAApellido.setText("Apellido:");

        jTextFieldEAApellido.setEditable(false);

        jLabelEANacionalidad.setText("Nacionalidad:");

        jTextFieldEANacionalidad.setEditable(false);

        jLabelEATelefono.setText("Telefono:");

        jTextFieldEATelefono.setEditable(false);

        jLabelEAGenero.setText("Genero Literario:");

        jTextFieldEAGenero.setEditable(false);

        jLabelEAFecha.setText("Fecha de Nacimiento:");

        jTextFieldEAFecha.setEditable(false);

        jLabelEABibliotecario.setText("Bibliografia:");

        jTextFieldEABibliografia.setEditable(false);

        jButtonEAEliminar.setBackground(new java.awt.Color(0, 102, 153));
        jButtonEAEliminar.setForeground(new java.awt.Color(255, 255, 255));
        jButtonEAEliminar.setText("ELIMINAR");
        jButtonEAEliminar.addActionListener(this::jButtonEAEliminarActionPerformed);

        jButtonEACancelar.setText("Cancelar");
        jButtonEACancelar.addActionListener(this::jButtonEACancelarActionPerformed);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jTextFieldEACedula, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButtonEABCedula, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabelEACedula)
                    .addComponent(jLabelEANombre)
                    .addComponent(jLabelEAApellido)
                    .addComponent(jLabelEANacionalidad)
                    .addComponent(jLabelEATelefono)
                    .addComponent(jLabelEAGenero)
                    .addComponent(jLabelEABibliotecario)
                    .addComponent(jLabelEAFecha)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(jButtonEAEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButtonEACancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jTextFieldEANombre, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldEAApellido, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldEANacionalidad, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldEATelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldEAGenero, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldEAFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldEABibliografia, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(35, 58, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabelEACedula)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldEACedula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonEABCedula))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
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
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonEAEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonEACancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(71, 71, 71))
        );

        jScrollPane1.setViewportView(jPanel2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(81, 81, 81)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(94, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 286, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35))
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

    public void cambiarIdioma(Locale locale) {
        ResourceBundle bundle = ResourceBundle.getBundle("ec.edu.ups.sistemabiblioteca.i18n", locale);
        jLabelEliminarAutor.setText(bundle.getString("TAbo"));
        jButtonEABCedula.setText(bundle.getString("bttnBuscar"));
        jButtonEAEliminar.setText(bundle.getString("bttnEliminar"));
        jButtonEACancelar.setText(bundle.getString("bttnCancelar"));
        jLabelEACedula.setText(bundle.getString("labelBACedula"));
        jLabelEANombre.setText(bundle.getString("labelBANombre"));
        jLabelEAApellido.setText(bundle.getString("labelBAApellido"));
        jLabelEANacionalidad.setText(bundle.getString("labelBANacionalidad"));
        jLabelEATelefono.setText(bundle.getString("labelBATelefono"));
        jLabelEAGenero.setText(bundle.getString("labelBAGT"));
        jLabelEAFecha.setText(bundle.getString("labelBAFN"));
        jLabelEABibliotecario.setText(bundle.getString("labelBAbL"));

    }

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
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
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
