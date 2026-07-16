package ec.edu.ups.sistemabiblioteca.view.autor;

import ec.edu.ups.sistemabiblioteca.models.Autor;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class ListarAutor extends javax.swing.JInternalFrame {

    private DefaultTableModel modelo;

    public ListarAutor() {
        initComponents();
        configurarTabla();
    }

    public void configurarTabla() {
        modelo = new DefaultTableModel();
        modelo.addColumn("Cédula");
        modelo.addColumn("Nombre");
        modelo.addColumn("Teléfono");
        modelo.addColumn("Fecha");

        tblListadoAutores.setModel(modelo);
    }

    public void cargarDatos(List<Autor> lista) {

        modelo.setRowCount(0);

        for (Autor a : lista) {

            Object[] fila = {
                a.getCedula(),
                a.getNombre(),
                a.getTelefono(),
                a.getFechaNacimiento()
            };
            modelo.addRow(fila);
        }
    }

    public JButton getBtnMostrarListaAutores() {
        return btnMostrarListaAutores;
    }

    public void setBtnMostrarListaAutores(JButton btnMostrarListaAutores) {
        this.btnMostrarListaAutores = btnMostrarListaAutores;
    }

    public JTextField getTxtContadordeAutores() {
        return txtContadordeAutores;
    }

    public void setTxtContadordeAutores(JTextField txtContadordeAutores) {
        this.txtContadordeAutores = txtContadordeAutores;
    }

    public JTable getTblListadoAutores() {
        return tblListadoAutores;
    }

    public void setTblListadoAutores(JTable tblListadoAutores) {
        this.tblListadoAutores = tblListadoAutores;
    }

    public void mostrarInformacion(String mensaje) {
        JOptionPane.showMessageDialog(this, mensaje);

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tblListadoAutores = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jLabelListaAutores = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        btnMostrarListaAutores = new javax.swing.JButton();
        jLabelURListaAutores = new javax.swing.JLabel();
        txtContadordeAutores = new javax.swing.JTextField();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setTitle("Lista Autores");
        setMinimumSize(new java.awt.Dimension(150, 36));

        tblListadoAutores.setBackground(new java.awt.Color(196, 220, 220));
        tblListadoAutores.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Cedula", "Nombre", "Telefono", "Fecha de Nacimiento"
            }
        ));
        tblListadoAutores.setEnabled(false);
        jScrollPane1.setViewportView(tblListadoAutores);

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));

        jLabelListaAutores.setBackground(new java.awt.Color(255, 255, 255));
        jLabelListaAutores.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        jLabelListaAutores.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelListaAutores.setText("LISTA DE AUTORES REGISTRADOS");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(62, 62, 62)
                .addComponent(jLabelListaAutores, javax.swing.GroupLayout.PREFERRED_SIZE, 360, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelListaAutores)
                .addContainerGap(18, Short.MAX_VALUE))
        );

        jPanel4.setBackground(new java.awt.Color(153, 153, 153));

        btnMostrarListaAutores.setBackground(new java.awt.Color(0, 102, 153));
        btnMostrarListaAutores.setForeground(new java.awt.Color(255, 255, 255));
        btnMostrarListaAutores.setText("Mostrar");

        jLabelURListaAutores.setFont(new java.awt.Font("Segoe UI Variable", 1, 12)); // NOI18N
        jLabelURListaAutores.setText("Autores Registrados");

        txtContadordeAutores.addActionListener(this::txtContadordeAutoresActionPerformed);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnMostrarListaAutores, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabelURListaAutores, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtContadordeAutores, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnMostrarListaAutores, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelURListaAutores)
                    .addComponent(txtContadordeAutores, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 496, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(34, 34, 34))
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

    private void txtContadordeAutoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtContadordeAutoresActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtContadordeAutoresActionPerformed
    public void cambiarIdioma(Locale locale) {
        ResourceBundle bundle = ResourceBundle.getBundle("ec.edu.ups.sistemabiblioteca.i18n", locale);
        jLabelListaAutores.setText(bundle.getString("TAlist"));
        btnMostrarListaAutores.setText(bundle.getString("bttnMostrar"));
        modelo = new DefaultTableModel();
        modelo.addColumn(bundle.getString("listarACedula"));
        modelo.addColumn(bundle.getString("listarAnombre"));
        modelo.addColumn(bundle.getString("listarAapellido"));
        modelo.addColumn(bundle.getString("listarATL"));
        modelo.addColumn(bundle.getString("listarAn"));
        modelo.addColumn(bundle.getString("listarAg"));
        modelo.addColumn(bundle.getString("listarAb"));
        modelo.addColumn(bundle.getString("listarAFN "));
        tblListadoAutores.setModel(modelo);
        jLabelURListaAutores.setText(bundle.getString("labelMA"));

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnMostrarListaAutores;
    private javax.swing.JLabel jLabelListaAutores;
    private javax.swing.JLabel jLabelURListaAutores;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblListadoAutores;
    private javax.swing.JTextField txtContadordeAutores;
    // End of variables declaration//GEN-END:variables
}
