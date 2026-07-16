package ec.edu.ups.sistemabiblioteca.view.libro;

import ec.edu.ups.sistemabiblioteca.models.Libro;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class ListarLibro extends javax.swing.JInternalFrame {

    private DefaultTableModel modelo;

    public ListarLibro() {
        initComponents();
        configuracion();
    }

    public void configuracion() {
        modelo = new DefaultTableModel();
        modelo.addColumn("ISBN");
        modelo.addColumn("Titulo");
        modelo.addColumn("Editorial");
        modelo.addColumn("Fecha de Publicacion");

        tblListadoLibro.setModel(modelo);
    }

    public void cargarDatos(List<Libro> lista) {
        modelo.setRowCount(0);

        for (Libro libro : lista) {

            Object[] fila = {
                libro.getIsbn(),
                libro.getTitulo(),
                libro.getEditorial(),
                libro.getAnioPublicacion(),};
            modelo.addRow(fila);
        }
    }

    public JButton getBtnMostrarListaLibro() {
        return btnMostrarListaLibro;
    }

    public void setBtnMostrarListaLibro(JButton btnMostrarListaLibro) {
        this.btnMostrarListaLibro = btnMostrarListaLibro;
    }

    public JTable getTblListadoLibro() {
        return tblListadoLibro;
    }

    public void setTblListadoLibro(JTable tblListadoLibro) {
        this.tblListadoLibro = tblListadoLibro;
    }

    public JTextField getTxtContadordeLibro() {
        return txtContadordeLibro;
    }

    public void setTxtContadordeLibro(JTextField txtContadordeLibro) {
        this.txtContadordeLibro = txtContadordeLibro;
    }

    public void mostrarInformacion(String mensaje) {
        JOptionPane.showMessageDialog(this, mensaje);

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel4 = new javax.swing.JPanel();
        btnMostrarListaLibro = new javax.swing.JButton();
        jLabelURListaLibro = new javax.swing.JLabel();
        txtContadordeLibro = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblListadoLibro = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jLabelListaLibro = new javax.swing.JLabel();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Lista Libros");

        jPanel4.setBackground(new java.awt.Color(153, 153, 153));

        btnMostrarListaLibro.setBackground(new java.awt.Color(0, 102, 153));
        btnMostrarListaLibro.setForeground(new java.awt.Color(255, 255, 255));
        btnMostrarListaLibro.setText("Mostrar");

        jLabelURListaLibro.setFont(new java.awt.Font("Segoe UI Variable", 1, 12)); // NOI18N
        jLabelURListaLibro.setText("Libros Registrados");

        txtContadordeLibro.addActionListener(this::txtContadordeLibroActionPerformed);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnMostrarListaLibro, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 201, Short.MAX_VALUE)
                .addComponent(jLabelURListaLibro, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtContadordeLibro, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(17, 17, 17))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnMostrarListaLibro, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelURListaLibro)
                    .addComponent(txtContadordeLibro, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        tblListadoLibro.setBackground(new java.awt.Color(196, 220, 220));
        tblListadoLibro.setModel(new javax.swing.table.DefaultTableModel(
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
        tblListadoLibro.setEnabled(false);
        jScrollPane1.setViewportView(tblListadoLibro);

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));

        jLabelListaLibro.setBackground(new java.awt.Color(255, 255, 255));
        jLabelListaLibro.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        jLabelListaLibro.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelListaLibro.setText("LISTA DE LIBRO REGISTRADOS");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabelListaLibro, javax.swing.GroupLayout.PREFERRED_SIZE, 360, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(59, 59, 59))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelListaLibro)
                .addContainerGap(18, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(16, Short.MAX_VALUE))
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

    private void txtContadordeLibroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtContadordeLibroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtContadordeLibroActionPerformed

    public void cambiarIdioma(Locale locale){
        ResourceBundle bundle =ResourceBundle.getBundle("ec.edu.ups.sistemabiblioteca.i18n", locale);
        jLabelListaLibro.setText(bundle.getString("TLlis"));
        btnMostrarListaLibro.setText(bundle.getString("bttnMostrar"));
        jLabelURListaLibro.setText(bundle.getString("labelBR"));
        modelo = new DefaultTableModel();
        modelo.addColumn(bundle.getString("labelISBN"));
        modelo.addColumn(bundle.getString("labelTitulo"));
        modelo.addColumn(bundle.getString("labelEditorial"));
        modelo.addColumn(bundle.getString("labelLfb"));
        tblListadoLibro.setModel(modelo);
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnMostrarListaLibro;
    private javax.swing.JLabel jLabelListaLibro;
    private javax.swing.JLabel jLabelURListaLibro;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblListadoLibro;
    private javax.swing.JTextField txtContadordeLibro;
    // End of variables declaration//GEN-END:variables
}
