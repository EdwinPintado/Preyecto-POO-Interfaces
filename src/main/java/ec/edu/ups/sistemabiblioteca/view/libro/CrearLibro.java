package ec.edu.ups.sistemabiblioteca.view.libro;

import java.util.Locale;
import java.util.ResourceBundle;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class CrearLibro extends javax.swing.JInternalFrame {

    public CrearLibro() {
        initComponents();
    }

    public JButton getjButtonLbBAutor() {
        return jButtonLbBAutor;
    }

    public void setjButtonLbBAutor(JButton jButtonLbBAutor) {
        this.jButtonLbBAutor = jButtonLbBAutor;
    }

    public JButton getjButtonLbCLibro() {
        return jButtonLbCLibro;
    }

    public void setjButtonLbCLibro(JButton jButtonLbCLibro) {
        this.jButtonLbCLibro = jButtonLbCLibro;
    }

    public JButton getjButtonLbCancelar() {
        return jButtonLbCancelar;
    }

    public void setjButtonLbCancelar(JButton jButtonLbCancelar) {
        this.jButtonLbCancelar = jButtonLbCancelar;
    }

    public JTextField getjTextFieldLbACedula() {
        return jTextFieldLbACedula;
    }

    public void setjTextFieldLbACedula(JTextField jTextFieldLbACedula) {
        this.jTextFieldLbACedula = jTextFieldLbACedula;
    }

    public JTextField getjTextFieldLbANombre() {
        return jTextFieldLbANombre;
    }

    public void setjTextFieldLbANombre(JTextField jTextFieldLbANombre) {
        this.jTextFieldLbANombre = jTextFieldLbANombre;
    }

    public JTextField getjTextFieldLbAnio() {
        return jTextFieldLbAnio;
    }

    public void setjTextFieldLbAnio(JTextField jTextFieldLbAnio) {
        this.jTextFieldLbAnio = jTextFieldLbAnio;
    }

    public JTextField getjTextFieldLbEditorial() {
        return jTextFieldLbEditorial;
    }

    public void setjTextFieldLbEditorial(JTextField jTextFieldLbEditorial) {
        this.jTextFieldLbEditorial = jTextFieldLbEditorial;
    }

    public JTextField getjTextFieldLbISBN() {
        return jTextFieldLbISBN;
    }

    public void setjTextFieldLbISBN(JTextField jTextFieldLbISBN) {
        this.jTextFieldLbISBN = jTextFieldLbISBN;
    }

    public JTextField getjTextFieldLbTitulo() {
        return jTextFieldLbTitulo;
    }

    public void setjTextFieldLbTitulo(JTextField jTextFieldLbTitulo) {
        this.jTextFieldLbTitulo = jTextFieldLbTitulo;
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

        jLabelLbAnio = new javax.swing.JLabel();
        jButtonLbCancelar = new javax.swing.JButton();
        jTextFieldLbAnio = new javax.swing.JTextField();
        jLabelLbACedula = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jPanel4 = new javax.swing.JPanel();
        jLabelCrearLibro = new javax.swing.JLabel();
        jTextFieldLbANombre = new javax.swing.JTextField();
        jTextFieldLbACedula = new javax.swing.JTextField();
        jLabelLbUNombre = new javax.swing.JLabel();
        jLabelLbISBN = new javax.swing.JLabel();
        jTextFieldLbISBN = new javax.swing.JTextField();
        jLabelLbEditorial = new javax.swing.JLabel();
        jLabelLbTitulo = new javax.swing.JLabel();
        jTextFieldLbEditorial = new javax.swing.JTextField();
        jTextFieldLbTitulo = new javax.swing.JTextField();
        jButtonLbCLibro = new javax.swing.JButton();
        jButtonLbBAutor = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Crear Libro");

        jLabelLbAnio.setText("Año de Publicacion:");

        jButtonLbCancelar.setText("CANCELAR");
        jButtonLbCancelar.addActionListener(this::jButtonLbCancelarActionPerformed);

        jLabelLbACedula.setText("Autor(cedula):");

        jPanel4.setBackground(new java.awt.Color(204, 204, 204));

        jLabelCrearLibro.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabelCrearLibro.setText("CREAR UN LIBRO");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(59, 59, 59)
                .addComponent(jLabelCrearLibro)
                .addContainerGap(63, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelCrearLibro)
                .addContainerGap(16, Short.MAX_VALUE))
        );

        jTextFieldLbANombre.addActionListener(this::jTextFieldLbANombreActionPerformed);

        jTextFieldLbACedula.addActionListener(this::jTextFieldLbACedulaActionPerformed);

        jLabelLbUNombre.setText("Nombre:");

        jLabelLbISBN.setText("ISBN:");

        jTextFieldLbISBN.addActionListener(this::jTextFieldLbISBNActionPerformed);

        jLabelLbEditorial.setText("Editorial:");

        jLabelLbTitulo.setText("Titulo:");

        jButtonLbCLibro.setBackground(new java.awt.Color(0, 102, 153));
        jButtonLbCLibro.setForeground(new java.awt.Color(255, 255, 255));
        jButtonLbCLibro.setText("CREAR");
        jButtonLbCLibro.addActionListener(this::jButtonLbCLibroActionPerformed);

        jButtonLbBAutor.setBackground(new java.awt.Color(0, 102, 153));
        jButtonLbBAutor.setForeground(new java.awt.Color(255, 255, 255));
        jButtonLbBAutor.setText("Buscar");

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        jLabel1.setText("AAAA-MM-DD");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(140, 140, 140)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabelLbAnio)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel1))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jTextFieldLbAnio, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jTextFieldLbEditorial, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jTextFieldLbTitulo, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabelLbTitulo, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabelLbEditorial, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jTextFieldLbISBN, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 265, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelLbACedula)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(1, 1, 1)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabelLbUNombre)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jTextFieldLbACedula, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jButtonLbBAutor))
                                    .addComponent(jTextFieldLbANombre, javax.swing.GroupLayout.PREFERRED_SIZE, 259, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabelLbISBN)
                        .addGap(242, 242, 242))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addComponent(jButtonLbCLibro, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonLbCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(29, 29, 29)))
                .addContainerGap(143, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabelLbISBN)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextFieldLbISBN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelLbTitulo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextFieldLbTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelLbEditorial)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextFieldLbEditorial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelLbAnio)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextFieldLbAnio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelLbACedula)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldLbACedula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonLbBAutor))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelLbUNombre)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextFieldLbANombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonLbCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonLbCLibro, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonLbCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonLbCancelarActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_jButtonLbCancelarActionPerformed

    private void jButtonLbCLibroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonLbCLibroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonLbCLibroActionPerformed

    private void jTextFieldLbISBNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldLbISBNActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldLbISBNActionPerformed

    private void jTextFieldLbACedulaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldLbACedulaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldLbACedulaActionPerformed

    private void jTextFieldLbANombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldLbANombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldLbANombreActionPerformed

    public void cambiarIdioma(Locale locale){
        ResourceBundle bundle =ResourceBundle.getBundle("ec.edu.ups.sistemabiblioteca.i18n", locale);
        jLabelCrearLibro.setText(bundle.getString("TLct"));
        jButtonLbBAutor.setText(bundle.getString("bttnBuscar"));
        jButtonLbCLibro.setText(bundle.getString("bttnCrear"));
        jButtonLbCancelar.setText(bundle.getString("bttnCancelar"));
        jLabelLbISBN.setText(bundle.getString("labelCTISBN"));
        jLabelLbTitulo.setText(bundle.getString("labelCtTitulo"));
        jLabelLbEditorial.setText(bundle.getString("labelCTEditorial"));
        jLabelLbAnio.setText(bundle.getString("labelCTFB"));
        jLabelLbACedula.setText(bundle.getString("labelCTAutor"));
        jLabelLbUNombre.setText(bundle.getString("labelCTNombre"));
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonLbBAutor;
    private javax.swing.JButton jButtonLbCLibro;
    private javax.swing.JButton jButtonLbCancelar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabelCrearLibro;
    private javax.swing.JLabel jLabelLbACedula;
    private javax.swing.JLabel jLabelLbAnio;
    private javax.swing.JLabel jLabelLbEditorial;
    private javax.swing.JLabel jLabelLbISBN;
    private javax.swing.JLabel jLabelLbTitulo;
    private javax.swing.JLabel jLabelLbUNombre;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextField jTextFieldLbACedula;
    private javax.swing.JTextField jTextFieldLbANombre;
    private javax.swing.JTextField jTextFieldLbAnio;
    private javax.swing.JTextField jTextFieldLbEditorial;
    private javax.swing.JTextField jTextFieldLbISBN;
    private javax.swing.JTextField jTextFieldLbTitulo;
    // End of variables declaration//GEN-END:variables
}
