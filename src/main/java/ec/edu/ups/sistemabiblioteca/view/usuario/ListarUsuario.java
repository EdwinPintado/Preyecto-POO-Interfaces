package ec.edu.ups.sistemabiblioteca.view.usuario;

import ec.edu.ups.sistemabiblioteca.models.Autor;
import ec.edu.ups.sistemabiblioteca.models.Usuario;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class ListarUsuario extends javax.swing.JInternalFrame {

    private DefaultTableModel modelo;

    public ListarUsuario() {
        initComponents();
        configuracionTabla();
    }

    public void configuracionTabla() {
        modelo = new DefaultTableModel();

        modelo.addColumn("Cédula");
        modelo.addColumn("Nombre");
        modelo.addColumn("Apellido");
        modelo.addColumn("Teléfono");
        modelo.addColumn("Correo");
        modelo.addColumn("Fecha");

        tblListadoUsuarios.setModel(modelo);
    }

    public void cargarDatos(List<Usuario> lista) {

        modelo.setRowCount(0);

        for (Usuario b : lista) {

            Object[] fila = {
                b.getCedula(),
                b.getNombre(),
                b.getApellido(),
                b.getTelefono(),
                b.getCorreoElectronico(),
                b.getFechaNacimiento()
            };
            modelo.addRow(fila);

        }
    }

    public JButton getBtnMostrarListaUsuarios() {
        return btnMostrarListaUsuarios;
    }

    public void setBtnMostrarListaUsuarios(JButton btnMostrarListaUsuarios) {
        this.btnMostrarListaUsuarios = btnMostrarListaUsuarios;
    }

    public JTable getTblListadoUsuarios() {
        return tblListadoUsuarios;
    }

    public void setTblListadoUsuarios(JTable tblListadoUsuarios) {
        this.tblListadoUsuarios = tblListadoUsuarios;
    }

    public JTextField getTxtContadordeUsuarios() {
        return txtContadordeUsuarios;
    }

    public void setTxtContadordeUsuarios(JTextField txtContadordeUsuarios) {
        this.txtContadordeUsuarios = txtContadordeUsuarios;
    }

    public void mostrarInformacion(String mensaje) {
        JOptionPane.showMessageDialog(this, mensaje);

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel4 = new javax.swing.JPanel();
        btnMostrarListaUsuarios = new javax.swing.JButton();
        jLabelURListaUsuarios = new javax.swing.JLabel();
        txtContadordeUsuarios = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblListadoUsuarios = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jLabelListaUsuarios = new javax.swing.JLabel();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Lista Usuario");

        jPanel4.setBackground(new java.awt.Color(153, 153, 153));

        btnMostrarListaUsuarios.setBackground(new java.awt.Color(0, 102, 153));
        btnMostrarListaUsuarios.setForeground(new java.awt.Color(255, 255, 255));
        btnMostrarListaUsuarios.setText("Mostrar");

        jLabelURListaUsuarios.setFont(new java.awt.Font("Segoe UI Variable", 1, 12)); // NOI18N
        jLabelURListaUsuarios.setText("Usuarios Registrados");

        txtContadordeUsuarios.addActionListener(this::txtContadordeUsuariosActionPerformed);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnMostrarListaUsuarios, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(59, 59, 59)
                .addComponent(jLabelURListaUsuarios, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtContadordeUsuarios, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(17, 17, 17))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnMostrarListaUsuarios, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelURListaUsuarios)
                    .addComponent(txtContadordeUsuarios, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        tblListadoUsuarios.setBackground(new java.awt.Color(196, 220, 220));
        tblListadoUsuarios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tblListadoUsuarios);

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));

        jLabelListaUsuarios.setBackground(new java.awt.Color(255, 255, 255));
        jLabelListaUsuarios.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        jLabelListaUsuarios.setText("LISTA DE USUARIOS REGISTRADOS");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(58, 58, 58)
                .addComponent(jLabelListaUsuarios)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelListaUsuarios)
                .addContainerGap(18, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(33, 33, 33))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 285, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtContadordeUsuariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtContadordeUsuariosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtContadordeUsuariosActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnMostrarListaUsuarios;
    private javax.swing.JLabel jLabelListaUsuarios;
    private javax.swing.JLabel jLabelURListaUsuarios;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblListadoUsuarios;
    private javax.swing.JTextField txtContadordeUsuarios;
    // End of variables declaration//GEN-END:variables
}
