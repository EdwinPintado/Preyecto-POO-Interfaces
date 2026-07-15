
package ec.edu.ups.sistemabiblioteca.view.libro;

import javax.swing.JButton;
import javax.swing.JTextField;

public class ActualizarLibro extends javax.swing.JInternalFrame {

    public ActualizarLibro() {
        initComponents();
    }

    public JButton getjButtonActLCancelar() {
        return jButtonActLCancelar;
    }

    public void setjButtonActLCancelar(JButton jButtonActLCancelar) {
        this.jButtonActLCancelar = jButtonActLCancelar;
    }

    public JButton getjButtonActLibro() {
        return jButtonActLibro;
    }

    public void setjButtonActLibro(JButton jButtonActLibro) {
        this.jButtonActLibro = jButtonActLibro;
    }

    public JButton getjButtonBsLISBN() {
        return jButtonBsLISBN;
    }

    public void setjButtonBsLISBN(JButton jButtonBsLISBN) {
        this.jButtonBsLISBN = jButtonBsLISBN;
    }

    public JTextField getjTextFieldActISBN() {
        return jTextFieldActISBN;
    }

    public void setjTextFieldActISBN(JTextField jTextFieldActISBN) {
        this.jTextFieldActISBN = jTextFieldActISBN;
    }

    public JTextField getjTextFieldActLACedula() {
        return jTextFieldActLACedula;
    }

    public void setjTextFieldActLACedula(JTextField jTextFieldActLACedula) {
        this.jTextFieldActLACedula = jTextFieldActLACedula;
    }

    public JTextField getjTextFieldActLANombre() {
        return jTextFieldActLANombre;
    }

    public void setjTextFieldActLANombre(JTextField jTextFieldActLANombre) {
        this.jTextFieldActLANombre = jTextFieldActLANombre;
    }

    public JTextField getjTextFieldActLAnio() {
        return jTextFieldActLAnio;
    }

    public void setjTextFieldActLAnio(JTextField jTextFieldActLAnio) {
        this.jTextFieldActLAnio = jTextFieldActLAnio;
    }

    public JTextField getjTextFieldActLEditorial() {
        return jTextFieldActLEditorial;
    }

    public void setjTextFieldActLEditorial(JTextField jTextFieldActLEditorial) {
        this.jTextFieldActLEditorial = jTextFieldActLEditorial;
    }

    public JTextField getjTextFieldActLTitulo() {
        return jTextFieldActLTitulo;
    }

    public void setjTextFieldActLTitulo(JTextField jTextFieldActLTitulo) {
        this.jTextFieldActLTitulo = jTextFieldActLTitulo;
    }
    
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextFieldActLACedula = new javax.swing.JTextField();
        jLabelActLACedula = new javax.swing.JLabel();
        jLabelActLTitulo = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jButtonBsLISBN = new javax.swing.JButton();
        jLabelActLAnio = new javax.swing.JLabel();
        jButtonActLibro = new javax.swing.JButton();
        jLabelActLANombre = new javax.swing.JLabel();
        jTextFieldActLEditorial = new javax.swing.JTextField();
        jButtonActLCancelar = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jLabelActualizarLibro = new javax.swing.JLabel();
        jLabelActISBN = new javax.swing.JLabel();
        jTextFieldActLAnio = new javax.swing.JTextField();
        jTextFieldActLTitulo = new javax.swing.JTextField();
        jTextFieldActISBN = new javax.swing.JTextField();
        jTextFieldActLANombre = new javax.swing.JTextField();
        jLabelActLEditorial = new javax.swing.JLabel();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Actualizar Libro");

        jTextFieldActLACedula.addActionListener(this::jTextFieldActLACedulaActionPerformed);

        jLabelActLACedula.setText("Autor(cedula):");

        jLabelActLTitulo.setText("Titulo:");

        jButtonBsLISBN.setBackground(new java.awt.Color(0, 102, 153));
        jButtonBsLISBN.setForeground(new java.awt.Color(255, 255, 255));
        jButtonBsLISBN.setText("Buscar");

        jLabelActLAnio.setText("Año de Publicacion:");

        jButtonActLibro.setBackground(new java.awt.Color(0, 102, 153));
        jButtonActLibro.setForeground(new java.awt.Color(255, 255, 255));
        jButtonActLibro.setText("ACTUALIZAR");
        jButtonActLibro.addActionListener(this::jButtonActLibroActionPerformed);

        jLabelActLANombre.setText("Nombre:");

        jButtonActLCancelar.setText("CANCELAR");
        jButtonActLCancelar.addActionListener(this::jButtonActLCancelarActionPerformed);

        jPanel4.setBackground(new java.awt.Color(204, 204, 204));

        jLabelActualizarLibro.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabelActualizarLibro.setText("ACTUALIZAR UN LIBRO");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jLabelActualizarLibro)
                .addContainerGap(36, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelActualizarLibro)
                .addContainerGap(16, Short.MAX_VALUE))
        );

        jLabelActISBN.setText("ISBN:");

        jTextFieldActISBN.addActionListener(this::jTextFieldActISBNActionPerformed);

        jTextFieldActLANombre.addActionListener(this::jTextFieldActLANombreActionPerformed);

        jLabelActLEditorial.setText("Editorial:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelActLAnio)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jTextFieldActLAnio, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 265, Short.MAX_VALUE)
                                .addComponent(jTextFieldActLEditorial, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jTextFieldActLTitulo, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabelActLTitulo, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabelActLEditorial, javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jTextFieldActISBN)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(jButtonBsLISBN)))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabelActLACedula)
                                        .addComponent(jLabelActLANombre))
                                    .addGap(193, 193, 193))
                                .addComponent(jTextFieldActLANombre, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jTextFieldActLACedula, javax.swing.GroupLayout.Alignment.LEADING)))
                        .addContainerGap(36, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelActISBN)
                            .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))))
            .addGroup(layout.createSequentialGroup()
                .addGap(58, 58, 58)
                .addComponent(jButtonActLibro, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonActLCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabelActISBN)
                .addGap(7, 7, 7)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldActISBN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonBsLISBN))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelActLTitulo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextFieldActLTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelActLEditorial)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextFieldActLEditorial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelActLAnio)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextFieldActLAnio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelActLACedula)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextFieldActLACedula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelActLANombre)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextFieldActLANombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonActLCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonActLibro, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextFieldActLACedulaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldActLACedulaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldActLACedulaActionPerformed

    private void jButtonActLibroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonActLibroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonActLibroActionPerformed

    private void jButtonActLCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonActLCancelarActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_jButtonActLCancelarActionPerformed

    private void jTextFieldActISBNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldActISBNActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldActISBNActionPerformed

    private void jTextFieldActLANombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldActLANombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldActLANombreActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonActLCancelar;
    private javax.swing.JButton jButtonActLibro;
    private javax.swing.JButton jButtonBsLISBN;
    private javax.swing.JLabel jLabelActISBN;
    private javax.swing.JLabel jLabelActLACedula;
    private javax.swing.JLabel jLabelActLANombre;
    private javax.swing.JLabel jLabelActLAnio;
    private javax.swing.JLabel jLabelActLEditorial;
    private javax.swing.JLabel jLabelActLTitulo;
    private javax.swing.JLabel jLabelActualizarLibro;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextField jTextFieldActISBN;
    private javax.swing.JTextField jTextFieldActLACedula;
    private javax.swing.JTextField jTextFieldActLANombre;
    private javax.swing.JTextField jTextFieldActLAnio;
    private javax.swing.JTextField jTextFieldActLEditorial;
    private javax.swing.JTextField jTextFieldActLTitulo;
    // End of variables declaration//GEN-END:variables
}
