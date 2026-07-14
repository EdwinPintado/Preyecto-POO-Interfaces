
package ec.edu.ups.sistemabiblioteca.view.libro;

import javax.swing.JButton;
import javax.swing.JTextField;

public class BuscarLibro extends javax.swing.JInternalFrame {

    public BuscarLibro() {
        initComponents();
    }

    public JButton getjButtonBsBISBN() {
        return jButtonBsBISBN;
    }

    public void setjButtonBsBISBN(JButton jButtonBsBISBN) {
        this.jButtonBsBISBN = jButtonBsBISBN;
    }

    public JTextField getjTextFieldBsACedula() {
        return jTextFieldBsACedula;
    }

    public void setjTextFieldBsACedula(JTextField jTextFieldBsACedula) {
        this.jTextFieldBsACedula = jTextFieldBsACedula;
    }

    public JTextField getjTextFieldBsANombre() {
        return jTextFieldBsANombre;
    }

    public void setjTextFieldBsANombre(JTextField jTextFieldBsANombre) {
        this.jTextFieldBsANombre = jTextFieldBsANombre;
    }

    public JTextField getjTextFieldBsAnio() {
        return jTextFieldBsAnio;
    }

    public void setjTextFieldBsAnio(JTextField jTextFieldBsAnio) {
        this.jTextFieldBsAnio = jTextFieldBsAnio;
    }

    public JTextField getjTextFieldBsEditorial() {
        return jTextFieldBsEditorial;
    }

    public void setjTextFieldBsEditorial(JTextField jTextFieldBsEditorial) {
        this.jTextFieldBsEditorial = jTextFieldBsEditorial;
    }

    public JTextField getjTextFieldBsISBN() {
        return jTextFieldBsISBN;
    }

    public void setjTextFieldBsISBN(JTextField jTextFieldBsISBN) {
        this.jTextFieldBsISBN = jTextFieldBsISBN;
    }

    public JTextField getjTextFieldBsTitulo() {
        return jTextFieldBsTitulo;
    }

    public void setjTextFieldBsTitulo(JTextField jTextFieldBsTitulo) {
        this.jTextFieldBsTitulo = jTextFieldBsTitulo;
    }

    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabelBsAnio = new javax.swing.JLabel();
        jLabelBsUNombre = new javax.swing.JLabel();
        jLabelBsISBN = new javax.swing.JLabel();
        jTextFieldBsAnio = new javax.swing.JTextField();
        jTextFieldBsISBN = new javax.swing.JTextField();
        jLabelBsEditorial = new javax.swing.JLabel();
        jLabelBsACedula = new javax.swing.JLabel();
        jLabelBsTitulo = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jButtonBsBISBN = new javax.swing.JButton();
        jTextFieldBsEditorial = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        jLabelBuscarLibro = new javax.swing.JLabel();
        jTextFieldBsTitulo = new javax.swing.JTextField();
        jTextFieldBsANombre = new javax.swing.JTextField();
        jTextFieldBsACedula = new javax.swing.JTextField();

        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Buscar Libro");

        jLabelBsAnio.setText("Año de Publicacion:");

        jLabelBsUNombre.setText("Nombre:");

        jLabelBsISBN.setText("ISBN:");

        jTextFieldBsISBN.addActionListener(this::jTextFieldBsISBNActionPerformed);

        jLabelBsEditorial.setText("Editorial:");

        jLabelBsACedula.setText("Autor(cedula):");

        jLabelBsTitulo.setText("Titulo:");

        jButtonBsBISBN.setBackground(new java.awt.Color(0, 102, 153));
        jButtonBsBISBN.setForeground(new java.awt.Color(255, 255, 255));
        jButtonBsBISBN.setText("Buscar");

        jPanel4.setBackground(new java.awt.Color(204, 204, 204));

        jLabelBuscarLibro.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabelBuscarLibro.setText("BUSCAR UN LIBRO");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addComponent(jLabelBuscarLibro)
                .addContainerGap(58, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelBuscarLibro)
                .addContainerGap(16, Short.MAX_VALUE))
        );

        jTextFieldBsANombre.addActionListener(this::jTextFieldBsANombreActionPerformed);

        jTextFieldBsACedula.addActionListener(this::jTextFieldBsACedulaActionPerformed);

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
                            .addComponent(jLabelBsAnio)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jTextFieldBsAnio, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 265, Short.MAX_VALUE)
                                .addComponent(jTextFieldBsEditorial, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jTextFieldBsTitulo, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabelBsTitulo, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabelBsEditorial, javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jTextFieldBsISBN)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(jButtonBsBISBN)))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabelBsACedula)
                                        .addComponent(jLabelBsUNombre))
                                    .addGap(193, 193, 193))
                                .addComponent(jTextFieldBsANombre, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jTextFieldBsACedula, javax.swing.GroupLayout.Alignment.LEADING)))
                        .addContainerGap(33, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelBsISBN)
                            .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabelBsISBN)
                .addGap(7, 7, 7)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldBsISBN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonBsBISBN))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelBsTitulo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextFieldBsTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelBsEditorial)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextFieldBsEditorial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelBsAnio)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextFieldBsAnio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelBsACedula)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextFieldBsACedula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelBsUNombre)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextFieldBsANombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(42, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextFieldBsISBNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldBsISBNActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldBsISBNActionPerformed

    private void jTextFieldBsANombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldBsANombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldBsANombreActionPerformed

    private void jTextFieldBsACedulaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldBsACedulaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldBsACedulaActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonBsBISBN;
    private javax.swing.JLabel jLabelBsACedula;
    private javax.swing.JLabel jLabelBsAnio;
    private javax.swing.JLabel jLabelBsEditorial;
    private javax.swing.JLabel jLabelBsISBN;
    private javax.swing.JLabel jLabelBsTitulo;
    private javax.swing.JLabel jLabelBsUNombre;
    private javax.swing.JLabel jLabelBuscarLibro;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextField jTextFieldBsACedula;
    private javax.swing.JTextField jTextFieldBsANombre;
    private javax.swing.JTextField jTextFieldBsAnio;
    private javax.swing.JTextField jTextFieldBsEditorial;
    private javax.swing.JTextField jTextFieldBsISBN;
    private javax.swing.JTextField jTextFieldBsTitulo;
    // End of variables declaration//GEN-END:variables
}
