
package ec.edu.ups.sistemabiblioteca.view.autor;

import java.util.Locale;
import java.util.ResourceBundle;
import javax.swing.JButton;
import javax.swing.JTextField;

public class BuscarAutor extends javax.swing.JInternalFrame {

    public BuscarAutor() {
        initComponents();
    }

    public JButton getjButtonBACedula() {
        return jButtonBACedula;
    }

    public void setjButtonBACedula(JButton jButtonBACedula) {
        this.jButtonBACedula = jButtonBACedula;
    }

    public JTextField getjTextFieldBAApellido() {
        return jTextFieldBAApellido;
    }

    public void setjTextFieldBAApellido(JTextField jTextFieldBAApellido) {
        this.jTextFieldBAApellido = jTextFieldBAApellido;
    }

    public JTextField getjTextFieldBABibliografia() {
        return jTextFieldBABibliografia;
    }

    public void setjTextFieldBABibliografia(JTextField jTextFieldBABibliografia) {
        this.jTextFieldBABibliografia = jTextFieldBABibliografia;
    }

    public JTextField getjTextFieldBACedula() {
        return jTextFieldBACedula;
    }

    public void setjTextFieldBACedula(JTextField jTextFieldBACedula) {
        this.jTextFieldBACedula = jTextFieldBACedula;
    }

    public JTextField getjTextFieldBAFecha() {
        return jTextFieldBAFecha;
    }

    public void setjTextFieldBAFecha(JTextField jTextFieldBAFecha) {
        this.jTextFieldBAFecha = jTextFieldBAFecha;
    }

    public JTextField getjTextFieldBAGenero() {
        return jTextFieldBAGenero;
    }

    public void setjTextFieldBAGenero(JTextField jTextFieldBAGenero) {
        this.jTextFieldBAGenero = jTextFieldBAGenero;
    }

    public JTextField getjTextFieldBANacionalidad() {
        return jTextFieldBANacionalidad;
    }

    public void setjTextFieldBANacionalidad(JTextField jTextFieldBANacionalidad) {
        this.jTextFieldBANacionalidad = jTextFieldBANacionalidad;
    }

    public JTextField getjTextFieldBANombre() {
        return jTextFieldBANombre;
    }

    public void setjTextFieldBANombre(JTextField jTextFieldBANombre) {
        this.jTextFieldBANombre = jTextFieldBANombre;
    }

    public JTextField getjTextFieldBATelefono() {
        return jTextFieldBATelefono;
    }

    public void setjTextFieldBATelefono(JTextField jTextFieldBATelefono) {
        this.jTextFieldBATelefono = jTextFieldBATelefono;
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabelBAApellido = new javax.swing.JLabel();
        jTextFieldBATelefono = new javax.swing.JTextField();
        jButtonBACedula = new javax.swing.JButton();
        jLabelBAGenero = new javax.swing.JLabel();
        jTextFieldBAApellido = new javax.swing.JTextField();
        jLabelBACedula = new javax.swing.JLabel();
        jTextFieldBABibliografia = new javax.swing.JTextField();
        jTextFieldBAGenero = new javax.swing.JTextField();
        jLabelBANacionalidad = new javax.swing.JLabel();
        jTextFieldBACedula = new javax.swing.JTextField();
        jLabelBABibliotecario = new javax.swing.JLabel();
        jLabelBAFecha = new javax.swing.JLabel();
        jTextFieldBANacionalidad = new javax.swing.JTextField();
        jLabelBANombre = new javax.swing.JLabel();
        jLabelBATelefono = new javax.swing.JLabel();
        jTextFieldBAFecha = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        jLabelBuscarAutor = new javax.swing.JLabel();
        jTextFieldBANombre = new javax.swing.JTextField();

        setClosable(true);
        setTitle("Buscar Autor");
        setToolTipText("");

        jLabelBAApellido.setText("Apellido:");

        jTextFieldBATelefono.setEditable(false);

        jButtonBACedula.setBackground(new java.awt.Color(0, 102, 153));
        jButtonBACedula.setForeground(new java.awt.Color(255, 255, 255));
        jButtonBACedula.setText("Buscar");
        jButtonBACedula.addActionListener(this::jButtonBACedulaActionPerformed);

        jLabelBAGenero.setText("Genero Literario:");

        jTextFieldBAApellido.setEditable(false);

        jLabelBACedula.setText("Cedula:");

        jTextFieldBABibliografia.setEditable(false);

        jTextFieldBAGenero.setEditable(false);

        jLabelBANacionalidad.setText("Nacionalidad:");

        jLabelBABibliotecario.setText("Bibliografia:");

        jLabelBAFecha.setText("Fecha de Nacimiento:");

        jTextFieldBANacionalidad.setEditable(false);

        jLabelBANombre.setText("Nombre:");

        jLabelBATelefono.setText("Telefono:");

        jTextFieldBAFecha.setEditable(false);

        jPanel4.setBackground(new java.awt.Color(204, 204, 204));

        jLabelBuscarAutor.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabelBuscarAutor.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelBuscarAutor.setText(" BUSCAR UN AUTOR");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelBuscarAutor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelBuscarAutor)
                .addContainerGap(16, Short.MAX_VALUE))
        );

        jTextFieldBANombre.setEditable(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelBANombre)
                    .addComponent(jLabelBACedula)
                    .addComponent(jLabelBAApellido)
                    .addComponent(jLabelBANacionalidad)
                    .addComponent(jLabelBATelefono)
                    .addComponent(jLabelBAGenero)
                    .addComponent(jLabelBABibliotecario)
                    .addComponent(jLabelBAFecha)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jTextFieldBANombre, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jTextFieldBAApellido, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jTextFieldBANacionalidad, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jTextFieldBATelefono, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jTextFieldBAGenero, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jTextFieldBAFecha, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jTextFieldBABibliografia, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addComponent(jTextFieldBACedula, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(jButtonBACedula, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(40, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabelBACedula)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldBACedula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonBACedula))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelBANombre)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextFieldBANombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelBAApellido)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextFieldBAApellido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelBANacionalidad)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextFieldBANacionalidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelBATelefono)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextFieldBATelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelBAGenero)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextFieldBAGenero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelBAFecha)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextFieldBAFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelBABibliotecario)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextFieldBABibliografia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonBACedulaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonBACedulaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonBACedulaActionPerformed
    public void cambiarIdioma(Locale locale){
        ResourceBundle bundle =ResourceBundle.getBundle("ec.edu.ups.sistemabiblioteca.i18n", locale);
        jLabelBuscarAutor.setText(bundle.getString("TAsc"));
        jButtonBACedula.setText(bundle.getString("bttnBuscar"));
        jLabelBACedula.setText(bundle.getString("labelBuACedula"));
        jLabelBANombre.setText(bundle.getString("labelBuANombre"));
        jLabelBAApellido.setText(bundle.getString("labelBuAApellido"));
        jLabelBANacionalidad.setText(bundle.getString("labelBuANacionalidad"));
        jLabelBATelefono.setText(bundle.getString("labelBuATelefono"));
        jLabelBAGenero.setText(bundle.getString("labelBuAGT"));
        jLabelBAFecha.setText(bundle.getString("labelBuAFN"));
        jLabelBABibliotecario.setText(bundle.getString("labelBuAbL"));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonBACedula;
    private javax.swing.JLabel jLabelBAApellido;
    private javax.swing.JLabel jLabelBABibliotecario;
    private javax.swing.JLabel jLabelBACedula;
    private javax.swing.JLabel jLabelBAFecha;
    private javax.swing.JLabel jLabelBAGenero;
    private javax.swing.JLabel jLabelBANacionalidad;
    private javax.swing.JLabel jLabelBANombre;
    private javax.swing.JLabel jLabelBATelefono;
    private javax.swing.JLabel jLabelBuscarAutor;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JTextField jTextFieldBAApellido;
    private javax.swing.JTextField jTextFieldBABibliografia;
    private javax.swing.JTextField jTextFieldBACedula;
    private javax.swing.JTextField jTextFieldBAFecha;
    private javax.swing.JTextField jTextFieldBAGenero;
    private javax.swing.JTextField jTextFieldBANacionalidad;
    private javax.swing.JTextField jTextFieldBANombre;
    private javax.swing.JTextField jTextFieldBATelefono;
    // End of variables declaration//GEN-END:variables
}
