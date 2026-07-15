
package ec.edu.ups.sistemabiblioteca.view.usuario;

import javax.swing.JButton;
import javax.swing.JTextField;

public class ActualizarUsuario extends javax.swing.JInternalFrame {

    public ActualizarUsuario() {
        initComponents();
    }

    public JButton getjButtonAUActualizar() {
        return jButtonAUActualizar;
    }

    public void setjButtonAUActualizar(JButton jButtonAUActualizar) {
        this.jButtonAUActualizar = jButtonAUActualizar;
    }

    public JButton getjButtonAUBuscar() {
        return jButtonAUBuscar;
    }

    public void setjButtonAUBuscar(JButton jButtonAUBuscar) {
        this.jButtonAUBuscar = jButtonAUBuscar;
    }

    public JButton getjButtonAUCancelar() {
        return jButtonAUCancelar;
    }

    public void setjButtonAUCancelar(JButton jButtonAUCancelar) {
        this.jButtonAUCancelar = jButtonAUCancelar;
    }

    public JTextField getjTextFieldAUApellido() {
        return jTextFieldAUApellido;
    }

    public void setjTextFieldAUApellido(JTextField jTextFieldAUApellido) {
        this.jTextFieldAUApellido = jTextFieldAUApellido;
    }

    public JTextField getjTextFieldAUCElectronico() {
        return jTextFieldAUCElectronico;
    }

    public void setjTextFieldAUCElectronico(JTextField jTextFieldAUCElectronico) {
        this.jTextFieldAUCElectronico = jTextFieldAUCElectronico;
    }

    public JTextField getjTextFieldAUCedula() {
        return jTextFieldAUCedula;
    }

    public void setjTextFieldAUCedula(JTextField jTextFieldAUCedula) {
        this.jTextFieldAUCedula = jTextFieldAUCedula;
    }

    public JTextField getjTextFieldAUDireccion() {
        return jTextFieldAUDireccion;
    }

    public void setjTextFieldAUDireccion(JTextField jTextFieldAUDireccion) {
        this.jTextFieldAUDireccion = jTextFieldAUDireccion;
    }

    public JTextField getjTextFieldAUFNacimiento() {
        return jTextFieldAUFNacimiento;
    }

    public void setjTextFieldAUFNacimiento(JTextField jTextFieldAUFNacimiento) {
        this.jTextFieldAUFNacimiento = jTextFieldAUFNacimiento;
    }

    public JTextField getjTextFieldAUNombre() {
        return jTextFieldAUNombre;
    }

    public void setjTextFieldAUNombre(JTextField jTextFieldAUNombre) {
        this.jTextFieldAUNombre = jTextFieldAUNombre;
    }

    public JTextField getjTextFieldAUTelefono() {
        return jTextFieldAUTelefono;
    }

    public void setjTextFieldAUTelefono(JTextField jTextFieldAUTelefono) {
        this.jTextFieldAUTelefono = jTextFieldAUTelefono;
    }

    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabelActualizarUsuario = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel2 = new javax.swing.JPanel();
        jLabelAUNombre = new javax.swing.JLabel();
        jTextFieldAUDireccion = new javax.swing.JTextField();
        jLabelAUFNacimiento = new javax.swing.JLabel();
        jLabelAUTelefono = new javax.swing.JLabel();
        jTextFieldAUNombre = new javax.swing.JTextField();
        jTextFieldAUFNacimiento = new javax.swing.JTextField();
        jTextFieldAUTelefono = new javax.swing.JTextField();
        jTextFieldAUCedula = new javax.swing.JTextField();
        jLabelAUDireccion = new javax.swing.JLabel();
        jLabelAUCElectronico = new javax.swing.JLabel();
        jTextFieldAUCElectronico = new javax.swing.JTextField();
        jButtonAUActualizar = new javax.swing.JButton();
        jLabelAUApellido = new javax.swing.JLabel();
        jButtonAUCancelar = new javax.swing.JButton();
        jButtonAUBuscar = new javax.swing.JButton();
        jTextFieldAUApellido = new javax.swing.JTextField();
        jLabelAUCedula = new javax.swing.JLabel();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Actualizar Usuario");
        setPreferredSize(new java.awt.Dimension(348, 500));

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));
        jPanel1.setMinimumSize(new java.awt.Dimension(100, 100));

        jLabelActualizarUsuario.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 18)); // NOI18N
        jLabelActualizarUsuario.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelActualizarUsuario.setText("ACTUALICE UN USUARIO");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelActualizarUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 279, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelActualizarUsuario)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabelAUNombre.setText("Nombre:");
        jLabelAUNombre.setMaximumSize(null);
        jLabelAUNombre.setMinimumSize(new java.awt.Dimension(104, 36));

        jTextFieldAUDireccion.setMaximumSize(null);
        jTextFieldAUDireccion.setMinimumSize(new java.awt.Dimension(104, 36));

        jLabelAUFNacimiento.setText("Fecha de nacimiento:");
        jLabelAUFNacimiento.setMaximumSize(null);
        jLabelAUFNacimiento.setMinimumSize(new java.awt.Dimension(104, 36));

        jLabelAUTelefono.setText("Teléfono:");
        jLabelAUTelefono.setMaximumSize(null);
        jLabelAUTelefono.setMinimumSize(new java.awt.Dimension(104, 36));

        jTextFieldAUNombre.setMaximumSize(null);
        jTextFieldAUNombre.setMinimumSize(new java.awt.Dimension(104, 36));

        jTextFieldAUFNacimiento.setMaximumSize(null);
        jTextFieldAUFNacimiento.setMinimumSize(new java.awt.Dimension(104, 36));

        jTextFieldAUTelefono.setMaximumSize(null);
        jTextFieldAUTelefono.setMinimumSize(new java.awt.Dimension(104, 36));

        jTextFieldAUCedula.setMaximumSize(null);
        jTextFieldAUCedula.setMinimumSize(new java.awt.Dimension(104, 36));

        jLabelAUDireccion.setText("Dirección:");
        jLabelAUDireccion.setMaximumSize(null);
        jLabelAUDireccion.setMinimumSize(new java.awt.Dimension(104, 36));

        jLabelAUCElectronico.setText("Correo Electrónico: ");
        jLabelAUCElectronico.setMaximumSize(null);
        jLabelAUCElectronico.setMinimumSize(new java.awt.Dimension(104, 36));

        jTextFieldAUCElectronico.setMaximumSize(null);
        jTextFieldAUCElectronico.setMinimumSize(new java.awt.Dimension(104, 36));

        jButtonAUActualizar.setBackground(new java.awt.Color(0, 102, 153));
        jButtonAUActualizar.setForeground(new java.awt.Color(255, 255, 255));
        jButtonAUActualizar.setText("ACTUALIZAR");
        jButtonAUActualizar.setMinimumSize(new java.awt.Dimension(104, 36));
        jButtonAUActualizar.addActionListener(this::jButtonAUActualizarActionPerformed);

        jLabelAUApellido.setText("Apellido:");
        jLabelAUApellido.setMaximumSize(null);
        jLabelAUApellido.setMinimumSize(new java.awt.Dimension(104, 36));

        jButtonAUCancelar.setText("CANCELAR");
        jButtonAUCancelar.setMaximumSize(null);
        jButtonAUCancelar.setMinimumSize(new java.awt.Dimension(104, 36));
        jButtonAUCancelar.addActionListener(this::jButtonAUCancelarActionPerformed);

        jButtonAUBuscar.setBackground(new java.awt.Color(0, 102, 153));
        jButtonAUBuscar.setForeground(new java.awt.Color(255, 255, 255));
        jButtonAUBuscar.setText("Buscar");
        jButtonAUBuscar.addActionListener(this::jButtonAUBuscarActionPerformed);

        jTextFieldAUApellido.setMaximumSize(null);
        jTextFieldAUApellido.setMinimumSize(new java.awt.Dimension(104, 36));

        jLabelAUCedula.setText("Cedula:");
        jLabelAUCedula.setMaximumSize(null);
        jLabelAUCedula.setMinimumSize(new java.awt.Dimension(104, 36));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addComponent(jButtonAUActualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButtonAUCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabelAUFNacimiento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabelAUDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabelAUTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabelAUCElectronico, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabelAUApellido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabelAUNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabelAUCedula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jTextFieldAUNombre, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jTextFieldAUApellido, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jTextFieldAUCElectronico, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jTextFieldAUTelefono, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jTextFieldAUDireccion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jTextFieldAUFNacimiento, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addComponent(jTextFieldAUCedula, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(jButtonAUBuscar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(27, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(18, Short.MAX_VALUE)
                .addComponent(jLabelAUCedula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jTextFieldAUCedula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonAUBuscar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelAUNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextFieldAUNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(11, 11, 11)
                .addComponent(jLabelAUApellido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextFieldAUApellido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelAUCElectronico, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextFieldAUCElectronico, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelAUTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextFieldAUTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelAUDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextFieldAUDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelAUFNacimiento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextFieldAUFNacimiento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonAUCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonAUActualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(33, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(42, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonAUCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAUCancelarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonAUCancelarActionPerformed

    private void jButtonAUBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAUBuscarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonAUBuscarActionPerformed

    private void jButtonAUActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAUActualizarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonAUActualizarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAUActualizar;
    private javax.swing.JButton jButtonAUBuscar;
    private javax.swing.JButton jButtonAUCancelar;
    private javax.swing.JLabel jLabelAUApellido;
    private javax.swing.JLabel jLabelAUCElectronico;
    private javax.swing.JLabel jLabelAUCedula;
    private javax.swing.JLabel jLabelAUDireccion;
    private javax.swing.JLabel jLabelAUFNacimiento;
    private javax.swing.JLabel jLabelAUNombre;
    private javax.swing.JLabel jLabelAUTelefono;
    private javax.swing.JLabel jLabelActualizarUsuario;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextFieldAUApellido;
    private javax.swing.JTextField jTextFieldAUCElectronico;
    private javax.swing.JTextField jTextFieldAUCedula;
    private javax.swing.JTextField jTextFieldAUDireccion;
    private javax.swing.JTextField jTextFieldAUFNacimiento;
    private javax.swing.JTextField jTextFieldAUNombre;
    private javax.swing.JTextField jTextFieldAUTelefono;
    // End of variables declaration//GEN-END:variables
}
