package ec.edu.ups.sistemabiblioteca.view.usuario;

import java.util.Locale;
import java.util.ResourceBundle;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class CrearUsuario extends javax.swing.JInternalFrame {

    public CrearUsuario() {
        initComponents();
    }

    public JButton getjButtonCUCancelar() {
        return jButtonCUCancelar;
    }

    public void setjButtonCUCancelar(JButton jButtonCUCancelar) {
        this.jButtonCUCancelar = jButtonCUCancelar;
    }

    public JButton getjButtonCUCrear() {
        return jButtonCUCrear;
    }

    public void setjButtonCUCrear(JButton jButtonCUCrear) {
        this.jButtonCUCrear = jButtonCUCrear;
    }

    public JTextField getjTextFieldCUApellido() {
        return jTextFieldCUApellido;
    }

    public void setjTextFieldCUApellido(JTextField jTextFieldCUApellido) {
        this.jTextFieldCUApellido = jTextFieldCUApellido;
    }

    public JTextField getjTextFieldCUCElectronico() {
        return jTextFieldCUCElectronico;
    }

    public void setjTextFieldCUCElectronico(JTextField jTextFieldCUCElectronico) {
        this.jTextFieldCUCElectronico = jTextFieldCUCElectronico;
    }

    public JTextField getjTextFieldCUCedula() {
        return jTextFieldCUCedula;
    }

    public void setjTextFieldCUCedula(JTextField jTextFieldCUCedula) {
        this.jTextFieldCUCedula = jTextFieldCUCedula;
    }

    public JTextField getjTextFieldCUDireccion() {
        return jTextFieldCUDireccion;
    }

    public void setjTextFieldCUDireccion(JTextField jTextFieldCUDireccion) {
        this.jTextFieldCUDireccion = jTextFieldCUDireccion;
    }

    public JTextField getjTextFieldCUFNacimiento() {
        return jTextFieldCUFNacimiento;
    }

    public void setjTextFieldCUFNacimiento(JTextField jTextFieldCUFNacimiento) {
        this.jTextFieldCUFNacimiento = jTextFieldCUFNacimiento;
    }

    public JTextField getjTextFieldCUNombre() {
        return jTextFieldCUNombre;
    }

    public void setjTextFieldCUNombre(JTextField jTextFieldCUNombre) {
        this.jTextFieldCUNombre = jTextFieldCUNombre;
    }

    public JTextField getjTextFieldCUTelefono() {
        return jTextFieldCUTelefono;
    }

    public void setjTextFieldCUTelefono(JTextField jTextFieldCUTelefono) {
        this.jTextFieldCUTelefono = jTextFieldCUTelefono;
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
        jLabelCrearUsuario = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel2 = new javax.swing.JPanel();
        jButtonCUCrear = new javax.swing.JButton();
        jTextFieldCUCedula = new javax.swing.JTextField();
        jTextFieldCUFNacimiento = new javax.swing.JTextField();
        jLabelCUCedula = new javax.swing.JLabel();
        jLabelCUDireccion = new javax.swing.JLabel();
        jTextFieldCUDireccion = new javax.swing.JTextField();
        jLabelCUTelefono = new javax.swing.JLabel();
        jTextFieldCUTelefono = new javax.swing.JTextField();
        jLabelCUCElectronico = new javax.swing.JLabel();
        jTextFieldCUCElectronico = new javax.swing.JTextField();
        jLabelCUApellido = new javax.swing.JLabel();
        jTextFieldCUApellido = new javax.swing.JTextField();
        jLabelCUNombre = new javax.swing.JLabel();
        jButtonCUCancelar = new javax.swing.JButton();
        jTextFieldCUNombre = new javax.swing.JTextField();
        jLabelCUFNacimiento = new javax.swing.JLabel();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Crear Usuario");
        setPreferredSize(new java.awt.Dimension(348, 500));

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));

        jLabelCrearUsuario.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 18)); // NOI18N
        jLabelCrearUsuario.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelCrearUsuario.setText("CREE UN NUEVO USUARIO");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabelCrearUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 279, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(14, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelCrearUsuario)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jButtonCUCrear.setBackground(new java.awt.Color(0, 102, 153));
        jButtonCUCrear.setForeground(new java.awt.Color(255, 255, 255));
        jButtonCUCrear.setText("CREAR");

        jLabelCUCedula.setText("Cedula:");

        jLabelCUDireccion.setText("Dirección:");

        jLabelCUTelefono.setText("Teléfono:");

        jLabelCUCElectronico.setText("Correo Electrónico: ");

        jLabelCUApellido.setText("Apellido:");

        jLabelCUNombre.setText("Nombre:");

        jButtonCUCancelar.setText("CANCELAR");

        jLabelCUFNacimiento.setText("Fecha de nacimiento:");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabelCUFNacimiento)
                    .addComponent(jLabelCUDireccion)
                    .addComponent(jLabelCUTelefono)
                    .addComponent(jLabelCUCElectronico)
                    .addComponent(jLabelCUApellido)
                    .addComponent(jLabelCUNombre)
                    .addComponent(jLabelCUCedula)
                    .addComponent(jTextFieldCUCedula)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addComponent(jButtonCUCrear, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButtonCUCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jTextFieldCUNombre)
                    .addComponent(jTextFieldCUApellido)
                    .addComponent(jTextFieldCUCElectronico)
                    .addComponent(jTextFieldCUTelefono)
                    .addComponent(jTextFieldCUDireccion)
                    .addComponent(jTextFieldCUFNacimiento))
                .addContainerGap(57, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(28, Short.MAX_VALUE)
                .addComponent(jLabelCUCedula)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextFieldCUCedula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelCUNombre)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextFieldCUNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(jLabelCUApellido)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextFieldCUApellido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelCUCElectronico)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextFieldCUCElectronico, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelCUTelefono)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextFieldCUTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelCUDireccion)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextFieldCUDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelCUFNacimiento)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextFieldCUFNacimiento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonCUCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonCUCrear, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jScrollPane1.setViewportView(jPanel2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 447, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(18, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public void cambiarIdioma(Locale locale){
        ResourceBundle bundle =ResourceBundle.getBundle("ec.edu.ups.sistemabiblioteca.i18n", locale);
        jLabelCrearUsuario.setText(bundle.getString("TUcr"));
        jButtonCUCrear.setText(bundle.getString("bttnCrear"));
        jButtonCUCancelar.setText(bundle.getString("bttnCancelar"));
        jLabelCUCedula.setText(bundle.getString("labelUCCedula"));
        jLabelCUNombre.setText(bundle.getString("labelUCNombre"));
        jLabelCUApellido.setText(bundle.getString("labelUCApellido"));
        jLabelCUCElectronico.setText(bundle.getString("labelUCCorreo"));
        jLabelCUTelefono.setText(bundle.getString("labelTelUC"));
        jLabelCUDireccion.setText(bundle.getString("labelDc"));
        jLabelCUFNacimiento.setText(bundle.getString("labelFN"));
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonCUCancelar;
    private javax.swing.JButton jButtonCUCrear;
    private javax.swing.JLabel jLabelCUApellido;
    private javax.swing.JLabel jLabelCUCElectronico;
    private javax.swing.JLabel jLabelCUCedula;
    private javax.swing.JLabel jLabelCUDireccion;
    private javax.swing.JLabel jLabelCUFNacimiento;
    private javax.swing.JLabel jLabelCUNombre;
    private javax.swing.JLabel jLabelCUTelefono;
    private javax.swing.JLabel jLabelCrearUsuario;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextFieldCUApellido;
    private javax.swing.JTextField jTextFieldCUCElectronico;
    private javax.swing.JTextField jTextFieldCUCedula;
    private javax.swing.JTextField jTextFieldCUDireccion;
    private javax.swing.JTextField jTextFieldCUFNacimiento;
    private javax.swing.JTextField jTextFieldCUNombre;
    private javax.swing.JTextField jTextFieldCUTelefono;
    // End of variables declaration//GEN-END:variables
}
