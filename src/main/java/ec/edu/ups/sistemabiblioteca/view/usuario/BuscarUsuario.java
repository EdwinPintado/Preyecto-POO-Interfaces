package ec.edu.ups.sistemabiblioteca.view.usuario;

import java.util.Locale;
import java.util.ResourceBundle;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class BuscarUsuario extends javax.swing.JInternalFrame {

    public BuscarUsuario() {
        initComponents();
    }

    public JButton getjButtonBUBuscar() {
        return jButtonBUBuscar;
    }

    public void setjButtonBUBuscar(JButton jButtonBUBuscar) {
        this.jButtonBUBuscar = jButtonBUBuscar;
    }

    public JTextField getjTextFieldBUApellido() {
        return jTextFieldBUApellido;
    }

    public void setjTextFieldBUApellido(JTextField jTextFieldBUApellido) {
        this.jTextFieldBUApellido = jTextFieldBUApellido;
    }

    public JTextField getjTextFieldBUCElectronico() {
        return jTextFieldBUCElectronico;
    }

    public void setjTextFieldBUCElectronico(JTextField jTextFieldBUCElectronico) {
        this.jTextFieldBUCElectronico = jTextFieldBUCElectronico;
    }

    public JTextField getjTextFieldBUCedula() {
        return jTextFieldBUCedula;
    }

    public void setjTextFieldBUCedula(JTextField jTextFieldBUCedula) {
        this.jTextFieldBUCedula = jTextFieldBUCedula;
    }

    public JTextField getjTextFieldBUDireccion() {
        return jTextFieldBUDireccion;
    }

    public void setjTextFieldBUDireccion(JTextField jTextFieldBUDireccion) {
        this.jTextFieldBUDireccion = jTextFieldBUDireccion;
    }

    public JTextField getjTextFieldBUFNacimiento() {
        return jTextFieldBUFNacimiento;
    }

    public void setjTextFieldBUFNacimiento(JTextField jTextFieldBUFNacimiento) {
        this.jTextFieldBUFNacimiento = jTextFieldBUFNacimiento;
    }

    public JTextField getjTextFieldBUNombre() {
        return jTextFieldBUNombre;
    }

    public void setjTextFieldBUNombre(JTextField jTextFieldBUNombre) {
        this.jTextFieldBUNombre = jTextFieldBUNombre;
    }

    public JTextField getjTextFieldBUTelefono() {
        return jTextFieldBUTelefono;
    }

    public void setjTextFieldBUTelefono(JTextField jTextFieldBUTelefono) {
        this.jTextFieldBUTelefono = jTextFieldBUTelefono;
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

        jPanel1 = new javax.swing.JPanel();
        jLabelBuscarUsuario = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel2 = new javax.swing.JPanel();
        jLabelBUApellido = new javax.swing.JLabel();
        jLabelBUFNacimiento = new javax.swing.JLabel();
        jTextFieldBUDireccion = new javax.swing.JTextField();
        jTextFieldBUNombre = new javax.swing.JTextField();
        jLabelBUTelefono = new javax.swing.JLabel();
        jTextFieldBUFNacimiento = new javax.swing.JTextField();
        jTextFieldBUCedula = new javax.swing.JTextField();
        jLabelBUDireccion = new javax.swing.JLabel();
        jTextFieldBUTelefono = new javax.swing.JTextField();
        jLabelBUCElectronico = new javax.swing.JLabel();
        jTextFieldBUCElectronico = new javax.swing.JTextField();
        jButtonBUBuscar = new javax.swing.JButton();
        jTextFieldBUApellido = new javax.swing.JTextField();
        jLabelBUNombre = new javax.swing.JLabel();
        jLabelBUCedula = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Buscar Usuario");
        setPreferredSize(new java.awt.Dimension(348, 500));

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));

        jLabelBuscarUsuario.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 18)); // NOI18N
        jLabelBuscarUsuario.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelBuscarUsuario.setText("BUSCAR UN USUARIO");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelBuscarUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 279, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelBuscarUsuario)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabelBUApellido.setText("Apellido:");

        jLabelBUFNacimiento.setText("Fecha de nacimiento:");

        jTextFieldBUDireccion.setEditable(false);
        jTextFieldBUDireccion.addActionListener(this::jTextFieldBUDireccionActionPerformed);

        jTextFieldBUNombre.setEditable(false);

        jLabelBUTelefono.setText("Teléfono:");

        jTextFieldBUFNacimiento.setEditable(false);

        jLabelBUDireccion.setText("Dirección:");

        jTextFieldBUTelefono.setEditable(false);

        jLabelBUCElectronico.setText("Correo Electrónico: ");

        jTextFieldBUCElectronico.setEditable(false);

        jButtonBUBuscar.setBackground(new java.awt.Color(0, 102, 153));
        jButtonBUBuscar.setForeground(new java.awt.Color(255, 255, 255));
        jButtonBUBuscar.setText("BUSCAR");

        jTextFieldBUApellido.setEditable(false);

        jLabelBUNombre.setText("Nombre:");

        jLabelBUCedula.setText("Cedula:");

        jButton1.setBackground(new java.awt.Color(0, 102, 153));
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Cancelar");
        jButton1.addActionListener(this::jButton1ActionPerformed);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelBUCElectronico)
                    .addComponent(jLabelBUApellido)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jTextFieldBUCElectronico)
                        .addComponent(jTextFieldBUApellido, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabelBUTelefono)
                    .addComponent(jTextFieldBUTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelBUDireccion)
                    .addComponent(jTextFieldBUDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelBUFNacimiento)
                    .addComponent(jLabelBUCedula)
                    .addComponent(jLabelBUNombre)
                    .addComponent(jTextFieldBUNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextFieldBUCedula, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextFieldBUFNacimiento, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(27, 27, 27)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton1)
                            .addComponent(jButtonBUBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(30, Short.MAX_VALUE)
                .addComponent(jLabelBUCedula)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jTextFieldBUCedula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonBUBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabelBUNombre)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextFieldBUNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(17, 17, 17)
                .addComponent(jLabelBUApellido)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextFieldBUApellido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabelBUCElectronico)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextFieldBUCElectronico, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabelBUTelefono)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextFieldBUTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabelBUDireccion)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextFieldBUDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabelBUFNacimiento)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldBUFNacimiento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addContainerGap())
        );

        jScrollPane1.setViewportView(jPanel2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(9, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 274, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(37, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextFieldBUDireccionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldBUDireccionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldBUDireccionActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    public void cambiarIdioma(Locale locale){
        ResourceBundle bundle =ResourceBundle.getBundle("ec.edu.ups.sistemabiblioteca.i18n", locale);
        jLabelBuscarUsuario.setText(bundle.getString("TUbus"));
        jButtonBUBuscar.setText(bundle.getString("bttnBuscar"));
        jLabelBUCedula.setText(bundle.getString("labelUBCedula"));
        jLabelBUNombre.setText(bundle.getString("labelUBNombre"));
        jLabelBUApellido.setText(bundle.getString("labelUBApellido"));
        jLabelBUCElectronico.setText(bundle.getString("labelUBCorreo"));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButtonBUBuscar;
    private javax.swing.JLabel jLabelBUApellido;
    private javax.swing.JLabel jLabelBUCElectronico;
    private javax.swing.JLabel jLabelBUCedula;
    private javax.swing.JLabel jLabelBUDireccion;
    private javax.swing.JLabel jLabelBUFNacimiento;
    private javax.swing.JLabel jLabelBUNombre;
    private javax.swing.JLabel jLabelBUTelefono;
    private javax.swing.JLabel jLabelBuscarUsuario;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextFieldBUApellido;
    private javax.swing.JTextField jTextFieldBUCElectronico;
    private javax.swing.JTextField jTextFieldBUCedula;
    private javax.swing.JTextField jTextFieldBUDireccion;
    private javax.swing.JTextField jTextFieldBUFNacimiento;
    private javax.swing.JTextField jTextFieldBUNombre;
    private javax.swing.JTextField jTextFieldBUTelefono;
    // End of variables declaration//GEN-END:variables
}
