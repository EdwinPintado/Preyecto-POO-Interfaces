
package ec.edu.ups.sistemabiblioteca.view.usuario;

import javax.swing.JButton;
import javax.swing.JTextField;

public class BorrarUsuario extends javax.swing.JInternalFrame {

    public BorrarUsuario() {
        initComponents();
    }

    public JButton getjButtonEUActualizar() {
        return jButtonEUActualizar;
    }

    public void setjButtonEUActualizar(JButton jButtonEUActualizar) {
        this.jButtonEUActualizar = jButtonEUActualizar;
    }

    public JButton getjButtonEUBuscar() {
        return jButtonEUBuscar;
    }

    public void setjButtonEUBuscar(JButton jButtonEUBuscar) {
        this.jButtonEUBuscar = jButtonEUBuscar;
    }

    public JButton getjButtonEUCancelar() {
        return jButtonEUCancelar;
    }

    public void setjButtonEUCancelar(JButton jButtonEUCancelar) {
        this.jButtonEUCancelar = jButtonEUCancelar;
    }

    public JTextField getjTextFieldEUApellido() {
        return jTextFieldEUApellido;
    }

    public void setjTextFieldEUApellido(JTextField jTextFieldEUApellido) {
        this.jTextFieldEUApellido = jTextFieldEUApellido;
    }

    public JTextField getjTextFieldEUCElectronico() {
        return jTextFieldEUCElectronico;
    }

    public void setjTextFieldEUCElectronico(JTextField jTextFieldEUCElectronico) {
        this.jTextFieldEUCElectronico = jTextFieldEUCElectronico;
    }

    public JTextField getjTextFieldEUCedula() {
        return jTextFieldEUCedula;
    }

    public void setjTextFieldEUCedula(JTextField jTextFieldEUCedula) {
        this.jTextFieldEUCedula = jTextFieldEUCedula;
    }

    public JTextField getjTextFieldEUDireccion() {
        return jTextFieldEUDireccion;
    }

    public void setjTextFieldEUDireccion(JTextField jTextFieldEUDireccion) {
        this.jTextFieldEUDireccion = jTextFieldEUDireccion;
    }

    public JTextField getjTextFieldEUFNacimiento() {
        return jTextFieldEUFNacimiento;
    }

    public void setjTextFieldEUFNacimiento(JTextField jTextFieldEUFNacimiento) {
        this.jTextFieldEUFNacimiento = jTextFieldEUFNacimiento;
    }

    public JTextField getjTextFieldEUNombre() {
        return jTextFieldEUNombre;
    }

    public void setjTextFieldEUNombre(JTextField jTextFieldEUNombre) {
        this.jTextFieldEUNombre = jTextFieldEUNombre;
    }

    public JTextField getjTextFieldEUTelefono() {
        return jTextFieldEUTelefono;
    }

    public void setjTextFieldEUTelefono(JTextField jTextFieldEUTelefono) {
        this.jTextFieldEUTelefono = jTextFieldEUTelefono;
    }

    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButtonEUBuscar = new javax.swing.JButton();
        jLabelEUApellido = new javax.swing.JLabel();
        jButtonEUActualizar = new javax.swing.JButton();
        jTextFieldEUCElectronico = new javax.swing.JTextField();
        jLabelEUDireccion = new javax.swing.JLabel();
        jLabelEUCElectronico = new javax.swing.JLabel();
        jTextFieldEUCedula = new javax.swing.JTextField();
        jTextFieldEUTelefono = new javax.swing.JTextField();
        jTextFieldEUFNacimiento = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        jLabelBorrarUsuario = new javax.swing.JLabel();
        jTextFieldEUNombre = new javax.swing.JTextField();
        jLabelEUFNacimiento = new javax.swing.JLabel();
        jLabelEUTelefono = new javax.swing.JLabel();
        jLabelEUNombre = new javax.swing.JLabel();
        jTextFieldEUDireccion = new javax.swing.JTextField();
        jTextFieldEUApellido = new javax.swing.JTextField();
        jLabelEUCedula = new javax.swing.JLabel();
        jButtonEUCancelar = new javax.swing.JButton();

        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Borrar Usuario");

        jButtonEUBuscar.setBackground(new java.awt.Color(0, 102, 153));
        jButtonEUBuscar.setForeground(new java.awt.Color(255, 255, 255));
        jButtonEUBuscar.setText("Buscar");
        jButtonEUBuscar.addActionListener(this::jButtonEUBuscarActionPerformed);

        jLabelEUApellido.setText("Apellido:");
        jLabelEUApellido.setMaximumSize(null);
        jLabelEUApellido.setMinimumSize(new java.awt.Dimension(104, 36));

        jButtonEUActualizar.setBackground(new java.awt.Color(0, 102, 153));
        jButtonEUActualizar.setForeground(new java.awt.Color(255, 255, 255));
        jButtonEUActualizar.setText("BORRAR");
        jButtonEUActualizar.setMinimumSize(new java.awt.Dimension(104, 36));
        jButtonEUActualizar.addActionListener(this::jButtonEUActualizarActionPerformed);

        jTextFieldEUCElectronico.setMaximumSize(null);
        jTextFieldEUCElectronico.setMinimumSize(new java.awt.Dimension(104, 36));

        jLabelEUDireccion.setText("Dirección:");
        jLabelEUDireccion.setMaximumSize(null);
        jLabelEUDireccion.setMinimumSize(new java.awt.Dimension(104, 36));

        jLabelEUCElectronico.setText("Correo Electrónico: ");
        jLabelEUCElectronico.setMaximumSize(null);
        jLabelEUCElectronico.setMinimumSize(new java.awt.Dimension(104, 36));

        jTextFieldEUCedula.setMaximumSize(null);
        jTextFieldEUCedula.setMinimumSize(new java.awt.Dimension(104, 36));

        jTextFieldEUTelefono.setMaximumSize(null);
        jTextFieldEUTelefono.setMinimumSize(new java.awt.Dimension(104, 36));

        jTextFieldEUFNacimiento.setMaximumSize(null);
        jTextFieldEUFNacimiento.setMinimumSize(new java.awt.Dimension(104, 36));

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));
        jPanel1.setMinimumSize(new java.awt.Dimension(100, 100));

        jLabelBorrarUsuario.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 18)); // NOI18N
        jLabelBorrarUsuario.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelBorrarUsuario.setText("ELIMINAR UN USUARIO");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelBorrarUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 279, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelBorrarUsuario)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTextFieldEUNombre.setMaximumSize(null);
        jTextFieldEUNombre.setMinimumSize(new java.awt.Dimension(104, 36));

        jLabelEUFNacimiento.setText("Fecha de nacimiento:");
        jLabelEUFNacimiento.setMaximumSize(null);
        jLabelEUFNacimiento.setMinimumSize(new java.awt.Dimension(104, 36));

        jLabelEUTelefono.setText("Teléfono:");
        jLabelEUTelefono.setMaximumSize(null);
        jLabelEUTelefono.setMinimumSize(new java.awt.Dimension(104, 36));

        jLabelEUNombre.setText("Nombre:");
        jLabelEUNombre.setMaximumSize(null);
        jLabelEUNombre.setMinimumSize(new java.awt.Dimension(104, 36));

        jTextFieldEUDireccion.setMaximumSize(null);
        jTextFieldEUDireccion.setMinimumSize(new java.awt.Dimension(104, 36));

        jTextFieldEUApellido.setMaximumSize(null);
        jTextFieldEUApellido.setMinimumSize(new java.awt.Dimension(104, 36));

        jLabelEUCedula.setText("Cedula:");
        jLabelEUCedula.setMaximumSize(null);
        jLabelEUCedula.setMinimumSize(new java.awt.Dimension(104, 36));

        jButtonEUCancelar.setText("CANCELAR");
        jButtonEUCancelar.setMaximumSize(null);
        jButtonEUCancelar.setMinimumSize(new java.awt.Dimension(104, 36));
        jButtonEUCancelar.addActionListener(this::jButtonEUCancelarActionPerformed);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabelEUFNacimiento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelEUDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelEUTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelEUCElectronico, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelEUApellido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelEUNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelEUCedula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jTextFieldEUNombre, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jTextFieldEUApellido, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jTextFieldEUCElectronico, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jTextFieldEUTelefono, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jTextFieldEUDireccion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jTextFieldEUFNacimiento, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jTextFieldEUCedula, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jButtonEUBuscar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(45, 45, 45)
                        .addComponent(jButtonEUActualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButtonEUCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(jLabelEUCedula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jTextFieldEUCedula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonEUBuscar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelEUNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextFieldEUNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelEUApellido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextFieldEUApellido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelEUCElectronico, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextFieldEUCElectronico, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelEUTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextFieldEUTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelEUDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextFieldEUDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelEUFNacimiento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextFieldEUFNacimiento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonEUCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonEUActualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonEUBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEUBuscarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonEUBuscarActionPerformed

    private void jButtonEUActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEUActualizarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonEUActualizarActionPerformed

    private void jButtonEUCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEUCancelarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonEUCancelarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonEUActualizar;
    private javax.swing.JButton jButtonEUBuscar;
    private javax.swing.JButton jButtonEUCancelar;
    private javax.swing.JLabel jLabelBorrarUsuario;
    private javax.swing.JLabel jLabelEUApellido;
    private javax.swing.JLabel jLabelEUCElectronico;
    private javax.swing.JLabel jLabelEUCedula;
    private javax.swing.JLabel jLabelEUDireccion;
    private javax.swing.JLabel jLabelEUFNacimiento;
    private javax.swing.JLabel jLabelEUNombre;
    private javax.swing.JLabel jLabelEUTelefono;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField jTextFieldEUApellido;
    private javax.swing.JTextField jTextFieldEUCElectronico;
    private javax.swing.JTextField jTextFieldEUCedula;
    private javax.swing.JTextField jTextFieldEUDireccion;
    private javax.swing.JTextField jTextFieldEUFNacimiento;
    private javax.swing.JTextField jTextFieldEUNombre;
    private javax.swing.JTextField jTextFieldEUTelefono;
    // End of variables declaration//GEN-END:variables
}
