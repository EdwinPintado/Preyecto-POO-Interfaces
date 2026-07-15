package ec.edu.ups.sistemabiblioteca.view.libro;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class BorrarLibro extends javax.swing.JInternalFrame {

    public BorrarLibro() {
        initComponents();
    }

    public JButton getjButtonBrALibro() {
        return jButtonBrALibro;
    }

    public void setjButtonBrALibro(JButton jButtonBrALibro) {
        this.jButtonBrALibro = jButtonBrALibro;
    }

    public JButton getjButtonBrBISBN() {
        return jButtonBrBISBN;
    }

    public void setjButtonBrBISBN(JButton jButtonBrBISBN) {
        this.jButtonBrBISBN = jButtonBrBISBN;
    }

    public JButton getjButtonBrCancelar() {
        return jButtonBrCancelar;
    }

    public void setjButtonBrCancelar(JButton jButtonBrCancelar) {
        this.jButtonBrCancelar = jButtonBrCancelar;
    }

    public JTextField getjTextFieldActACedula() {
        return jTextFieldActACedula;
    }

    public void setjTextFieldActACedula(JTextField jTextFieldActACedula) {
        this.jTextFieldActACedula = jTextFieldActACedula;
    }

    public JTextField getjTextFieldBrANombre() {
        return jTextFieldBrANombre;
    }

    public void setjTextFieldBrANombre(JTextField jTextFieldBrANombre) {
        this.jTextFieldBrANombre = jTextFieldBrANombre;
    }

    public JTextField getjTextFieldBrAnio() {
        return jTextFieldBrAnio;
    }

    public void setjTextFieldBrAnio(JTextField jTextFieldBrAnio) {
        this.jTextFieldBrAnio = jTextFieldBrAnio;
    }

    public JTextField getjTextFieldBrEditorial() {
        return jTextFieldBrEditorial;
    }

    public void setjTextFieldBrEditorial(JTextField jTextFieldBrEditorial) {
        this.jTextFieldBrEditorial = jTextFieldBrEditorial;
    }

    public JTextField getjTextFieldBrISBN() {
        return jTextFieldBrISBN;
    }

    public void setjTextFieldBrISBN(JTextField jTextFieldBrISBN) {
        this.jTextFieldBrISBN = jTextFieldBrISBN;
    }

    public JTextField getjTextFieldBrTitulo() {
        return jTextFieldBrTitulo;
    }

    public void setjTextFieldBrTitulo(JTextField jTextFieldBrTitulo) {
        this.jTextFieldBrTitulo = jTextFieldBrTitulo;
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

        jTextFieldBrEditorial = new javax.swing.JTextField();
        jButtonBrCancelar = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jLabelBorrarLibro = new javax.swing.JLabel();
        jTextFieldActACedula = new javax.swing.JTextField();
        jLabelBrACedula = new javax.swing.JLabel();
        jLabelBrISBN = new javax.swing.JLabel();
        jLabelBrTitulo = new javax.swing.JLabel();
        jTextFieldBrAnio = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        jTextFieldBrTitulo = new javax.swing.JTextField();
        jButtonBrBISBN = new javax.swing.JButton();
        jTextFieldBrISBN = new javax.swing.JTextField();
        jLabelBrAnio = new javax.swing.JLabel();
        jTextFieldBrANombre = new javax.swing.JTextField();
        jButtonBrALibro = new javax.swing.JButton();
        jLabelBrEditorial = new javax.swing.JLabel();
        jLabelBrUNombre = new javax.swing.JLabel();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Borrar Libro");

        jTextFieldBrEditorial.setEditable(false);

        jButtonBrCancelar.setText("CANCELAR");
        jButtonBrCancelar.addActionListener(this::jButtonBrCancelarActionPerformed);

        jPanel4.setBackground(new java.awt.Color(204, 204, 204));

        jLabelBorrarLibro.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabelBorrarLibro.setText("BORRAR UN LIBRO");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(51, Short.MAX_VALUE)
                .addComponent(jLabelBorrarLibro)
                .addGap(49, 49, 49))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelBorrarLibro)
                .addContainerGap(16, Short.MAX_VALUE))
        );

        jTextFieldActACedula.setEditable(false);
        jTextFieldActACedula.addActionListener(this::jTextFieldActACedulaActionPerformed);

        jLabelBrACedula.setText("Autor(cedula):");

        jLabelBrISBN.setText("ISBN:");

        jLabelBrTitulo.setText("Titulo:");

        jTextFieldBrAnio.setEditable(false);

        jTextFieldBrTitulo.setEditable(false);

        jButtonBrBISBN.setBackground(new java.awt.Color(0, 102, 153));
        jButtonBrBISBN.setForeground(new java.awt.Color(255, 255, 255));
        jButtonBrBISBN.setText("Buscar");

        jTextFieldBrISBN.addActionListener(this::jTextFieldBrISBNActionPerformed);

        jLabelBrAnio.setText("Año de Publicacion:");

        jTextFieldBrANombre.setEditable(false);
        jTextFieldBrANombre.addActionListener(this::jTextFieldBrANombreActionPerformed);

        jButtonBrALibro.setBackground(new java.awt.Color(0, 102, 153));
        jButtonBrALibro.setForeground(new java.awt.Color(255, 255, 255));
        jButtonBrALibro.setText("BORRAR");
        jButtonBrALibro.addActionListener(this::jButtonBrALibroActionPerformed);

        jLabelBrEditorial.setText("Editorial:");

        jLabelBrUNombre.setText("Nombre:");

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
                            .addComponent(jLabelBrAnio)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jTextFieldBrAnio, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 265, Short.MAX_VALUE)
                                .addComponent(jTextFieldBrEditorial, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jTextFieldBrTitulo, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabelBrTitulo, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabelBrEditorial, javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jTextFieldBrISBN)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(jButtonBrBISBN)))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabelBrACedula)
                                        .addComponent(jLabelBrUNombre))
                                    .addGap(193, 193, 193))
                                .addComponent(jTextFieldBrANombre, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jTextFieldActACedula, javax.swing.GroupLayout.Alignment.LEADING)))
                        .addContainerGap(33, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelBrISBN)
                            .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))))
            .addGroup(layout.createSequentialGroup()
                .addGap(58, 58, 58)
                .addComponent(jButtonBrALibro, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonBrCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabelBrISBN)
                .addGap(7, 7, 7)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldBrISBN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonBrBISBN))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelBrTitulo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextFieldBrTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelBrEditorial)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextFieldBrEditorial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelBrAnio)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextFieldBrAnio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelBrACedula)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextFieldActACedula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelBrUNombre)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextFieldBrANombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonBrCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonBrALibro, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonBrCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonBrCancelarActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_jButtonBrCancelarActionPerformed

    private void jTextFieldActACedulaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldActACedulaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldActACedulaActionPerformed

    private void jTextFieldBrISBNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldBrISBNActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldBrISBNActionPerformed

    private void jTextFieldBrANombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldBrANombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldBrANombreActionPerformed

    private void jButtonBrALibroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonBrALibroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonBrALibroActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonBrALibro;
    private javax.swing.JButton jButtonBrBISBN;
    private javax.swing.JButton jButtonBrCancelar;
    private javax.swing.JLabel jLabelBorrarLibro;
    private javax.swing.JLabel jLabelBrACedula;
    private javax.swing.JLabel jLabelBrAnio;
    private javax.swing.JLabel jLabelBrEditorial;
    private javax.swing.JLabel jLabelBrISBN;
    private javax.swing.JLabel jLabelBrTitulo;
    private javax.swing.JLabel jLabelBrUNombre;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextField jTextFieldActACedula;
    private javax.swing.JTextField jTextFieldBrANombre;
    private javax.swing.JTextField jTextFieldBrAnio;
    private javax.swing.JTextField jTextFieldBrEditorial;
    private javax.swing.JTextField jTextFieldBrISBN;
    private javax.swing.JTextField jTextFieldBrTitulo;
    // End of variables declaration//GEN-END:variables
}
