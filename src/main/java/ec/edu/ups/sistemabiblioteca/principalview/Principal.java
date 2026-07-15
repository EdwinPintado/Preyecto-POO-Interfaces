/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/MDIApplication.java to edit this template
 */
package ec.edu.ups.sistemabiblioteca.principalview;

import ec.edu.ups.sistemabiblioteca.Controller.AutorController;
import ec.edu.ups.sistemabiblioteca.Controller.BibliotecarioController;
import ec.edu.ups.sistemabiblioteca.Controller.DevolucionController;
import ec.edu.ups.sistemabiblioteca.Controller.LibroController;
import ec.edu.ups.sistemabiblioteca.Controller.PrestamoController;
import ec.edu.ups.sistemabiblioteca.Controller.UsuarioController;
import ec.edu.ups.sistemabiblioteca.DAO.AutorDAOMemoria;
import ec.edu.ups.sistemabiblioteca.DAO.BibliotecarioDAOMemoria;
import ec.edu.ups.sistemabiblioteca.DAO.DevolucionDAOMemoria;
import ec.edu.ups.sistemabiblioteca.DAO.LibroDAOMemoria;
import ec.edu.ups.sistemabiblioteca.DAO.PrestamoDAOMemoria;
import ec.edu.ups.sistemabiblioteca.DAO.UsuarioDAOMemoria;
import ec.edu.ups.sistemabiblioteca.view.autor.ActualizarAutor;
import ec.edu.ups.sistemabiblioteca.view.autor.BorrarAutor;
import ec.edu.ups.sistemabiblioteca.view.autor.BuscarAutor;
import ec.edu.ups.sistemabiblioteca.view.autor.CrearAutor;
import ec.edu.ups.sistemabiblioteca.view.autor.ListarAutor;
import ec.edu.ups.sistemabiblioteca.view.bibliotecario.ActualizarBibliotecario;
import ec.edu.ups.sistemabiblioteca.view.bibliotecario.BorrarBibliotecario;
import ec.edu.ups.sistemabiblioteca.view.bibliotecario.BuscarBibliotecario;
import ec.edu.ups.sistemabiblioteca.view.bibliotecario.CrearBibliotecario;
import ec.edu.ups.sistemabiblioteca.view.bibliotecario.ListarBibliotecario;
import ec.edu.ups.sistemabiblioteca.view.devolucion.ListarDevolucion;
import ec.edu.ups.sistemabiblioteca.view.devolucion.RealizarDevolucion;
import ec.edu.ups.sistemabiblioteca.view.libro.ActualizarLibro;
import ec.edu.ups.sistemabiblioteca.view.libro.BorrarLibro;
import ec.edu.ups.sistemabiblioteca.view.libro.BuscarLibro;
import ec.edu.ups.sistemabiblioteca.view.libro.CrearLibro;
import ec.edu.ups.sistemabiblioteca.view.libro.ListarLibro;
import ec.edu.ups.sistemabiblioteca.view.prestamo.BuscarPrestamo;
import ec.edu.ups.sistemabiblioteca.view.prestamo.CrearPrestamo;
import ec.edu.ups.sistemabiblioteca.view.prestamo.ListarPrestamo;
import ec.edu.ups.sistemabiblioteca.view.usuario.ActualizarUsuario;
import ec.edu.ups.sistemabiblioteca.view.usuario.BorrarUsuario;
import ec.edu.ups.sistemabiblioteca.view.usuario.BuscarUsuario;
import ec.edu.ups.sistemabiblioteca.view.usuario.CrearUsuario;
import ec.edu.ups.sistemabiblioteca.view.usuario.ListarUsuario;
import javax.swing.JDesktopPane;

/**
 *
 * @author Usuario
 */
public class Principal extends javax.swing.JFrame {

    private AutorController autorController;
    private LibroController libroController;
    private UsuarioController usuarioController;
    private PrestamoController prestamoController;
    private DevolucionController devolucionController;
    private BibliotecarioController bibliotecarioController;

    private AutorDAOMemoria autorDAO;
    private UsuarioDAOMemoria usuarioDAO;
    private BibliotecarioDAOMemoria bibliotecarioDAO;
    private LibroDAOMemoria libroDAO;
    private DevolucionDAOMemoria devolucionDAO;
    private PrestamoDAOMemoria prestamoDAO;

    private ActualizarAutor actualizarAutor;
    private BorrarAutor borrarAutor;
    private BuscarAutor buscarAutor;
    private CrearAutor crearAutor;
    private ListarAutor listarAutor;
    
    private ActualizarBibliotecario actualizarBibliotecario;
    private BorrarBibliotecario borrarBibliotecario;
    private BuscarBibliotecario buscarBibliotecario;
    private CrearBibliotecario crearBibliotecario;
    private ListarBibliotecario listarBibliotecario;
    
    private ListarDevolucion listarDevolucion;
    private RealizarDevolucion realizarDevolucion;
    
    private ActualizarLibro actualizarLibro;
    private BorrarLibro borrarLibro;
    private BuscarLibro buscarLibro;
    private CrearLibro crearLibro;
    private ListarLibro listarLibro;
    
    private BuscarPrestamo buscarPrestamo;
    private CrearPrestamo crearPrestamo;
    private ListarPrestamo listarPrestamo;
    
    private ActualizarUsuario actualizarUsuario;
    private BorrarUsuario borrarUsuario;
    private BuscarUsuario buscarUsuario;
    private CrearUsuario crearUsuario;
    private ListarUsuario listarUsuario;
    
    
    /**
     * Creates new form Principal
     */
    public Principal() {
        desktopPane = new JDesktopPane();
        this.setContentPane(desktopPane);
        initComponents();
        
        autorDAO= new AutorDAOMemoria();
        usuarioDAO= new UsuarioDAOMemoria();
        bibliotecarioDAO= new BibliotecarioDAOMemoria();
        libroDAO= new LibroDAOMemoria();
        devolucionDAO= new DevolucionDAOMemoria();
        prestamoDAO= new PrestamoDAOMemoria();
        
        crearAutor= new CrearAutor();
        borrarAutor= new BorrarAutor();
        buscarAutor= new BuscarAutor();
        actualizarAutor= new ActualizarAutor();
        listarAutor= new ListarAutor();
        
        crearBibliotecario= new CrearBibliotecario();
        borrarBibliotecario= new BorrarBibliotecario();
        buscarBibliotecario= new BuscarBibliotecario();
        actualizarBibliotecario= new ActualizarBibliotecario();
        listarBibliotecario= new ListarBibliotecario();
        
        crearLibro= new CrearLibro();
        borrarLibro= new BorrarLibro();
        buscarLibro= new BuscarLibro();
        actualizarLibro= new ActualizarLibro();
        listarLibro= new ListarLibro();
        
        crearPrestamo= new CrearPrestamo();
        buscarPrestamo= new BuscarPrestamo();
        listarPrestamo= new ListarPrestamo();
        
        realizarDevolucion= new RealizarDevolucion();
        listarDevolucion= new ListarDevolucion();
        
        crearUsuario= new CrearUsuario();
        borrarUsuario= new BorrarUsuario();
        buscarUsuario= new BuscarUsuario();
        actualizarUsuario= new ActualizarUsuario();
        listarUsuario= new ListarUsuario();
        
        autorController = new AutorController(autorDAO, crearAutor, borrarAutor, buscarAutor, actualizarAutor, listarAutor);
        usuarioController= new UsuarioController(usuarioDAO, crearUsuario, borrarUsuario, buscarUsuario, actualizarUsuario, listarUsuario);
        libroController= new LibroController(libroDAO, autorDAO, crearLibro, buscarLibro, borrarLibro, actualizarLibro, listarLibro);
        bibliotecarioController= new BibliotecarioController(bibliotecarioDAO, crearBibliotecario, buscarBibliotecario, borrarBibliotecario, actualizarBibliotecario, listarBibliotecario);
        prestamoController= new PrestamoController(prestamoDAO, usuarioDAO, libroDAO, bibliotecarioDAO, buscarPrestamo, crearPrestamo, listarPrestamo);
        devolucionController= new DevolucionController(devolucionDAO, prestamoDAO, realizarDevolucion, listarDevolucion);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        desktopPane = new javax.swing.JDesktopPane();
        menuBar = new javax.swing.JMenuBar();
        fileMenu = new javax.swing.JMenu();
        openMenuItem = new javax.swing.JMenuItem();
        Buscar = new javax.swing.JMenuItem();
        saveAsMenuItem = new javax.swing.JMenuItem();
        exitMenuItem = new javax.swing.JMenuItem();
        jMenuItem1 = new javax.swing.JMenuItem();
        fileMenu2 = new javax.swing.JMenu();
        openMenuItem2 = new javax.swing.JMenuItem();
        Buscar1 = new javax.swing.JMenuItem();
        saveAsMenuItem2 = new javax.swing.JMenuItem();
        exitMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        fileMenu3 = new javax.swing.JMenu();
        openMenuItem3 = new javax.swing.JMenuItem();
        Buscar2 = new javax.swing.JMenuItem();
        saveAsMenuItem3 = new javax.swing.JMenuItem();
        exitMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        fileMenu4 = new javax.swing.JMenu();
        openMenuItem4 = new javax.swing.JMenuItem();
        Buscar3 = new javax.swing.JMenuItem();
        saveAsMenuItem4 = new javax.swing.JMenuItem();
        exitMenuItem4 = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();
        Prestamo = new javax.swing.JMenu();
        openMenuItem5 = new javax.swing.JMenuItem();
        Buscar4 = new javax.swing.JMenuItem();
        jMenuItem5 = new javax.swing.JMenuItem();
        Devolucion = new javax.swing.JMenu();
        openMenuItem6 = new javax.swing.JMenuItem();
        jMenuItem6 = new javax.swing.JMenuItem();
        Devolucion1 = new javax.swing.JMenu();
        openMenuItem7 = new javax.swing.JMenuItem();
        jMenuItem7 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        fileMenu.setMnemonic('f');
        fileMenu.setText("Autor");

        openMenuItem.setMnemonic('o');
        openMenuItem.setText("Crear");
        openMenuItem.addActionListener(this::openMenuItemActionPerformed);
        fileMenu.add(openMenuItem);

        Buscar.setMnemonic('s');
        Buscar.setText("Buscar");
        Buscar.addActionListener(this::BuscarActionPerformed);
        fileMenu.add(Buscar);

        saveAsMenuItem.setMnemonic('a');
        saveAsMenuItem.setText("Actualizar");
        saveAsMenuItem.addActionListener(this::saveAsMenuItemActionPerformed);
        fileMenu.add(saveAsMenuItem);

        exitMenuItem.setMnemonic('x');
        exitMenuItem.setText("Borrar");
        exitMenuItem.addActionListener(this::exitMenuItemActionPerformed);
        fileMenu.add(exitMenuItem);

        jMenuItem1.setText("Listar");
        jMenuItem1.addActionListener(this::jMenuItem1ActionPerformed);
        fileMenu.add(jMenuItem1);

        menuBar.add(fileMenu);

        fileMenu2.setMnemonic('f');
        fileMenu2.setText("Libro");

        openMenuItem2.setMnemonic('o');
        openMenuItem2.setText("Crear");
        openMenuItem2.addActionListener(this::openMenuItem2ActionPerformed);
        fileMenu2.add(openMenuItem2);

        Buscar1.setMnemonic('s');
        Buscar1.setText("Buscar");
        Buscar1.addActionListener(this::Buscar1ActionPerformed);
        fileMenu2.add(Buscar1);

        saveAsMenuItem2.setMnemonic('a');
        saveAsMenuItem2.setText("Actualizar");
        saveAsMenuItem2.addActionListener(this::saveAsMenuItem2ActionPerformed);
        fileMenu2.add(saveAsMenuItem2);

        exitMenuItem2.setMnemonic('x');
        exitMenuItem2.setText("Borrar");
        exitMenuItem2.addActionListener(this::exitMenuItem2ActionPerformed);
        fileMenu2.add(exitMenuItem2);

        jMenuItem2.setText("Listar");
        jMenuItem2.addActionListener(this::jMenuItem2ActionPerformed);
        fileMenu2.add(jMenuItem2);

        menuBar.add(fileMenu2);

        fileMenu3.setMnemonic('f');
        fileMenu3.setText("Bibliotecario");

        openMenuItem3.setMnemonic('o');
        openMenuItem3.setText("Crear");
        openMenuItem3.addActionListener(this::openMenuItem3ActionPerformed);
        fileMenu3.add(openMenuItem3);

        Buscar2.setMnemonic('s');
        Buscar2.setText("Buscar");
        Buscar2.addActionListener(this::Buscar2ActionPerformed);
        fileMenu3.add(Buscar2);

        saveAsMenuItem3.setMnemonic('a');
        saveAsMenuItem3.setText("Actualizar");
        saveAsMenuItem3.addActionListener(this::saveAsMenuItem3ActionPerformed);
        fileMenu3.add(saveAsMenuItem3);

        exitMenuItem3.setMnemonic('x');
        exitMenuItem3.setText("Borrar");
        exitMenuItem3.addActionListener(this::exitMenuItem3ActionPerformed);
        fileMenu3.add(exitMenuItem3);

        jMenuItem3.setText("Listar");
        jMenuItem3.addActionListener(this::jMenuItem3ActionPerformed);
        fileMenu3.add(jMenuItem3);

        menuBar.add(fileMenu3);

        fileMenu4.setMnemonic('f');
        fileMenu4.setText("Usuario");

        openMenuItem4.setMnemonic('o');
        openMenuItem4.setText("Crear");
        openMenuItem4.addActionListener(this::openMenuItem4ActionPerformed);
        fileMenu4.add(openMenuItem4);

        Buscar3.setMnemonic('s');
        Buscar3.setText("Buscar");
        Buscar3.addActionListener(this::Buscar3ActionPerformed);
        fileMenu4.add(Buscar3);

        saveAsMenuItem4.setMnemonic('a');
        saveAsMenuItem4.setText("Actualizar");
        saveAsMenuItem4.addActionListener(this::saveAsMenuItem4ActionPerformed);
        fileMenu4.add(saveAsMenuItem4);

        exitMenuItem4.setMnemonic('x');
        exitMenuItem4.setText("Borrar");
        exitMenuItem4.addActionListener(this::exitMenuItem4ActionPerformed);
        fileMenu4.add(exitMenuItem4);

        jMenuItem4.setText("Listar");
        jMenuItem4.addActionListener(this::jMenuItem4ActionPerformed);
        fileMenu4.add(jMenuItem4);

        menuBar.add(fileMenu4);

        Prestamo.setMnemonic('f');
        Prestamo.setText("Prestamo");

        openMenuItem5.setMnemonic('o');
        openMenuItem5.setText("Crear");
        openMenuItem5.addActionListener(this::openMenuItem5ActionPerformed);
        Prestamo.add(openMenuItem5);

        Buscar4.setMnemonic('s');
        Buscar4.setText("Buscar");
        Buscar4.addActionListener(this::Buscar4ActionPerformed);
        Prestamo.add(Buscar4);

        jMenuItem5.setText("Listar");
        jMenuItem5.addActionListener(this::jMenuItem5ActionPerformed);
        Prestamo.add(jMenuItem5);

        menuBar.add(Prestamo);

        Devolucion.setMnemonic('f');
        Devolucion.setText("Devolucion");

        openMenuItem6.setMnemonic('o');
        openMenuItem6.setText("Crear");
        openMenuItem6.addActionListener(this::openMenuItem6ActionPerformed);
        Devolucion.add(openMenuItem6);

        jMenuItem6.setText("Listar");
        jMenuItem6.addActionListener(this::jMenuItem6ActionPerformed);
        Devolucion.add(jMenuItem6);

        menuBar.add(Devolucion);

        Devolucion1.setMnemonic('f');
        Devolucion1.setText("Idioma");

        openMenuItem7.setMnemonic('o');
        openMenuItem7.setText("Español");
        Devolucion1.add(openMenuItem7);

        jMenuItem7.setText("Ingles");
        Devolucion1.add(jMenuItem7);

        menuBar.add(Devolucion1);

        setJMenuBar(menuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(desktopPane, javax.swing.GroupLayout.PREFERRED_SIZE, 501, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(desktopPane, javax.swing.GroupLayout.PREFERRED_SIZE, 501, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void exitMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitMenuItemActionPerformed
        if(borrarAutor== null||!borrarAutor.isVisible()){
            desktopPane.remove(borrarAutor);
            desktopPane.add(borrarAutor);
            borrarAutor.setVisible(true);
        }
    }//GEN-LAST:event_exitMenuItemActionPerformed

    private void exitMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitMenuItem2ActionPerformed
        // TODO add your handling code here:
        if(borrarLibro== null|| ! borrarLibro.isVisible()){
            desktopPane.remove(borrarLibro);
            desktopPane.add(borrarLibro);
            borrarLibro.setVisible(true);
        }
    }//GEN-LAST:event_exitMenuItem2ActionPerformed

    private void exitMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitMenuItem3ActionPerformed
        // TODO add your handling code here:
        if(borrarBibliotecario== null|| !buscarBibliotecario.isVisible()){
            desktopPane.remove(borrarBibliotecario);
            desktopPane.add(borrarBibliotecario);
            borrarBibliotecario.setVisible(true);
        }
    }//GEN-LAST:event_exitMenuItem3ActionPerformed

    private void exitMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitMenuItem4ActionPerformed
        // TODO add your handling code here:
        if(borrarUsuario== null || !borrarUsuario.isVisible()){
            desktopPane.remove(borrarUsuario);
            desktopPane.add(borrarUsuario);
            borrarUsuario.setVisible(true);
        }
    }//GEN-LAST:event_exitMenuItem4ActionPerformed

    private void openMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_openMenuItemActionPerformed
        // TODO add your handling code here:
        if(crearAutor == null|| !crearAutor.isVisible()){
            desktopPane.remove(crearAutor);
            desktopPane.add(crearAutor);
            crearAutor.setVisible(true);
        }
    }//GEN-LAST:event_openMenuItemActionPerformed

    private void BuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BuscarActionPerformed
        // TODO add your handling code here:
        if(buscarAutor== null|| !buscarAutor.isVisible()){
            desktopPane.remove(buscarAutor);
            desktopPane.add(buscarAutor);
            buscarAutor.setVisible(true);
            
        }
    }//GEN-LAST:event_BuscarActionPerformed

    private void saveAsMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveAsMenuItemActionPerformed
        // TODO add your handling code here:
        if(actualizarAutor== null|| !actualizarAutor.isVisible()){
            desktopPane.remove(actualizarAutor);
            desktopPane.add(actualizarAutor);
            actualizarAutor.setVisible(true);
            
        }
    }//GEN-LAST:event_saveAsMenuItemActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        // TODO add your handling code here:
        if(listarAutor== null || !listarAutor.isVisible()){
            desktopPane.remove(listarAutor);
            desktopPane.add(listarAutor);
            listarAutor.setVisible(true);
        }
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void openMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_openMenuItem2ActionPerformed
        // TODO add your handling code here:
        if(crearLibro== null || !crearLibro.isVisible()){
            desktopPane.remove(crearLibro);
            desktopPane.add(crearLibro);
            crearLibro.setVisible(true);
        }
    }//GEN-LAST:event_openMenuItem2ActionPerformed

    private void Buscar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Buscar1ActionPerformed
        // TODO add your handling code here:
        if(buscarLibro== null|| !buscarLibro.isVisible()){
            desktopPane.remove(buscarLibro);
            desktopPane.add(buscarLibro);
            buscarLibro.setVisible(true);
        }
    }//GEN-LAST:event_Buscar1ActionPerformed

    private void saveAsMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveAsMenuItem2ActionPerformed
        // TODO add your handling code here:
        if(actualizarLibro== null ||!actualizarLibro.isVisible()){
            desktopPane.remove(actualizarLibro);
            desktopPane.add(actualizarLibro);
            actualizarLibro.setVisible(true);
        }
    }//GEN-LAST:event_saveAsMenuItem2ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        // TODO add your handling code here:
        if(listarLibro== null || ! listarLibro.isVisible()){
            desktopPane.remove(listarLibro);
            desktopPane.add(listarLibro);
            listarLibro.setVisible(true);
        }
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void openMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_openMenuItem3ActionPerformed
        // TODO add your handling code here:
        if(crearBibliotecario== null || ! crearBibliotecario.isVisible()){
            desktopPane.remove(crearBibliotecario);
            desktopPane.add(crearBibliotecario);
            crearBibliotecario.setVisible(true);
        }
    }//GEN-LAST:event_openMenuItem3ActionPerformed

    private void Buscar2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Buscar2ActionPerformed
        // TODO add your handling code here:
        if(buscarBibliotecario== null || !buscarBibliotecario.isVisible()){
            desktopPane.remove(buscarBibliotecario);
            desktopPane.add(buscarBibliotecario);
            buscarBibliotecario.setVisible(true);
        }
    }//GEN-LAST:event_Buscar2ActionPerformed

    private void saveAsMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveAsMenuItem3ActionPerformed
        // TODO add your handling code here:
        if(actualizarBibliotecario== null || !actualizarBibliotecario.isVisible()){
            desktopPane.remove(actualizarBibliotecario);
            desktopPane.add(actualizarBibliotecario);
            actualizarBibliotecario.setVisible(true);
        }
    }//GEN-LAST:event_saveAsMenuItem3ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        // TODO add your handling code here:
        if(listarBibliotecario== null|| !listarBibliotecario.isVisible()){
            desktopPane.remove(listarBibliotecario);
            desktopPane.add(listarBibliotecario);
            listarBibliotecario.setVisible(true);
        }
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void openMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_openMenuItem4ActionPerformed
        // TODO add your handling code here:
        if(crearUsuario== null || ! crearUsuario.isVisible()){
            desktopPane.remove(crearUsuario);
            desktopPane.add(crearUsuario);
            crearUsuario.setVisible(true);
        }
    }//GEN-LAST:event_openMenuItem4ActionPerformed

    private void Buscar3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Buscar3ActionPerformed
        // TODO add your handling code here:
        if(buscarUsuario==null||!buscarUsuario.isVisible()){
            desktopPane.remove(buscarUsuario);
            desktopPane.add(buscarUsuario);
            buscarUsuario.setVisible(true);
        }
    }//GEN-LAST:event_Buscar3ActionPerformed

    private void saveAsMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveAsMenuItem4ActionPerformed
        // TODO add your handling code here:
        if(actualizarUsuario== null || !actualizarUsuario.isVisible()){
            desktopPane.remove(actualizarUsuario);
            desktopPane.add(actualizarUsuario);
            actualizarUsuario.setVisible(true);
        }
    }//GEN-LAST:event_saveAsMenuItem4ActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
        // TODO add your handling code here:
        if(listarUsuario== null || !listarUsuario.isVisible()){
            desktopPane.remove(listarUsuario);
            desktopPane.add(listarUsuario);
            listarUsuario.setVisible(true);
        }
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private void openMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_openMenuItem5ActionPerformed
        // TODO add your handling code here:
        if(crearPrestamo== null || !crearPrestamo.isVisible()){
            desktopPane.remove(crearPrestamo);
            desktopPane.add(crearPrestamo);
            crearPrestamo.setVisible(true);
        }
    }//GEN-LAST:event_openMenuItem5ActionPerformed

    private void Buscar4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Buscar4ActionPerformed
        // TODO add your handling code here:
        if(buscarPrestamo== null ||! buscarPrestamo.isVisible()){
            desktopPane.remove(buscarPrestamo);
            desktopPane.add(buscarPrestamo);
            buscarPrestamo.setVisible(true);
        }
    }//GEN-LAST:event_Buscar4ActionPerformed

    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed
        // TODO add your handling code here:
        if(listarPrestamo== null || !listarPrestamo.isVisible()){
            desktopPane.remove(listarPrestamo);
            desktopPane.add(listarPrestamo);
            listarPrestamo.setVisible(true);
        }
    }//GEN-LAST:event_jMenuItem5ActionPerformed

    private void openMenuItem6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_openMenuItem6ActionPerformed
        // TODO add your handling code here:
        if(realizarDevolucion== null || !realizarDevolucion.isVisible()){
            desktopPane.remove(realizarDevolucion);
            desktopPane.add(realizarDevolucion);
            realizarDevolucion.setVisible(true);
        }
    }//GEN-LAST:event_openMenuItem6ActionPerformed

    private void jMenuItem6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem6ActionPerformed
        // TODO add your handling code here:
        if(listarDevolucion== null ||!listarDevolucion.isVisible()){
            desktopPane.remove(listarDevolucion);
            desktopPane.add(listarDevolucion);
            listarDevolucion.setVisible(true);
        }
    }//GEN-LAST:event_jMenuItem6ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Principal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem Buscar;
    private javax.swing.JMenuItem Buscar1;
    private javax.swing.JMenuItem Buscar2;
    private javax.swing.JMenuItem Buscar3;
    private javax.swing.JMenuItem Buscar4;
    private javax.swing.JMenu Devolucion;
    private javax.swing.JMenu Devolucion1;
    private javax.swing.JMenu Prestamo;
    private javax.swing.JDesktopPane desktopPane;
    private javax.swing.JMenuItem exitMenuItem;
    private javax.swing.JMenuItem exitMenuItem2;
    private javax.swing.JMenuItem exitMenuItem3;
    private javax.swing.JMenuItem exitMenuItem4;
    private javax.swing.JMenu fileMenu;
    private javax.swing.JMenu fileMenu2;
    private javax.swing.JMenu fileMenu3;
    private javax.swing.JMenu fileMenu4;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JMenuItem jMenuItem7;
    private javax.swing.JMenuBar menuBar;
    private javax.swing.JMenuItem openMenuItem;
    private javax.swing.JMenuItem openMenuItem2;
    private javax.swing.JMenuItem openMenuItem3;
    private javax.swing.JMenuItem openMenuItem4;
    private javax.swing.JMenuItem openMenuItem5;
    private javax.swing.JMenuItem openMenuItem6;
    private javax.swing.JMenuItem openMenuItem7;
    private javax.swing.JMenuItem saveAsMenuItem;
    private javax.swing.JMenuItem saveAsMenuItem2;
    private javax.swing.JMenuItem saveAsMenuItem3;
    private javax.swing.JMenuItem saveAsMenuItem4;
    // End of variables declaration//GEN-END:variables

}
