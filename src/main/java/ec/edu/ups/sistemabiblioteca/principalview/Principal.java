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
import ec.edu.ups.sistemabiblioteca.DAOArchivo.AutorDAOArchivo;
import ec.edu.ups.sistemabiblioteca.DAOArchivo.BibliotecarioDAOArchivo;
import ec.edu.ups.sistemabiblioteca.DAOArchivo.DevolucionDAOArchivo;
import ec.edu.ups.sistemabiblioteca.DAOArchivo.LibroDAOArchivo;
import ec.edu.ups.sistemabiblioteca.DAOArchivo.PrestamoDAOArchivo;
import ec.edu.ups.sistemabiblioteca.DAOArchivo.UsuarioDAOArchivo;
import ec.edu.ups.sistemabiblioteca.DAOMemoria.AutorDAOMemoria;
import ec.edu.ups.sistemabiblioteca.DAOMemoria.BibliotecarioDAOMemoria;
import ec.edu.ups.sistemabiblioteca.DAOMemoria.DevolucionDAOMemoria;
import ec.edu.ups.sistemabiblioteca.DAOMemoria.LibroDAOMemoria;
import ec.edu.ups.sistemabiblioteca.DAOMemoria.PrestamoDAOMemoria;
import ec.edu.ups.sistemabiblioteca.DAOMemoria.UsuarioDAOMemoria;
import ec.edu.ups.sistemabiblioteca.models.Autor;
import ec.edu.ups.sistemabiblioteca.models.Bibliotecario;
import ec.edu.ups.sistemabiblioteca.models.Devolucion;
import ec.edu.ups.sistemabiblioteca.models.Libro;
import ec.edu.ups.sistemabiblioteca.models.Prestamo;
import ec.edu.ups.sistemabiblioteca.models.Usuario;
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
import java.util.Locale;
import java.util.ResourceBundle;
import javax.swing.JDesktopPane;
import javax.swing.JOptionPane;

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
    private AutorDAOArchivo autorArchivos;
    private UsuarioDAOMemoria usuarioDAO;
    private UsuarioDAOArchivo usuarioArchivo;
    private BibliotecarioDAOMemoria bibliotecarioDAO;
    private BibliotecarioDAOArchivo bibliotecarioDAOArhivo;
    private LibroDAOMemoria libroDAO;
    private LibroDAOArchivo libroDAOArchivo;
    private DevolucionDAOMemoria devolucionDAO;
    private DevolucionDAOArchivo devolucionArchivo;
    private PrestamoDAOMemoria prestamoDAO;
    private PrestamoDAOArchivo prestamoArchivo;

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

        autorArchivos = new AutorDAOArchivo();
        autorDAO = new AutorDAOMemoria();
        usuarioDAO = new UsuarioDAOMemoria();
        usuarioArchivo = new UsuarioDAOArchivo();
        bibliotecarioDAO = new BibliotecarioDAOMemoria();
        bibliotecarioDAOArhivo = new BibliotecarioDAOArchivo();
        libroDAO = new LibroDAOMemoria();
        libroDAOArchivo = new LibroDAOArchivo();
        devolucionDAO = new DevolucionDAOMemoria();
        devolucionArchivo = new DevolucionDAOArchivo();
        prestamoDAO = new PrestamoDAOMemoria();
        prestamoArchivo = new PrestamoDAOArchivo(usuarioDAO, libroDAO, bibliotecarioDAO);

        crearAutor = new CrearAutor();
        borrarAutor = new BorrarAutor();
        buscarAutor = new BuscarAutor();
        actualizarAutor = new ActualizarAutor();
        listarAutor = new ListarAutor();

        crearBibliotecario = new CrearBibliotecario();
        borrarBibliotecario = new BorrarBibliotecario();
        buscarBibliotecario = new BuscarBibliotecario();
        actualizarBibliotecario = new ActualizarBibliotecario();
        listarBibliotecario = new ListarBibliotecario();

        crearLibro = new CrearLibro();
        borrarLibro = new BorrarLibro();
        buscarLibro = new BuscarLibro();
        actualizarLibro = new ActualizarLibro();
        listarLibro = new ListarLibro();

        crearPrestamo = new CrearPrestamo();
        buscarPrestamo = new BuscarPrestamo();
        listarPrestamo = new ListarPrestamo();

        realizarDevolucion = new RealizarDevolucion();
        listarDevolucion = new ListarDevolucion();

        crearUsuario = new CrearUsuario();
        borrarUsuario = new BorrarUsuario();
        buscarUsuario = new BuscarUsuario();
        actualizarUsuario = new ActualizarUsuario();
        listarUsuario = new ListarUsuario();

        autorController = new AutorController(autorDAO, crearAutor, borrarAutor, buscarAutor, actualizarAutor, listarAutor);
        usuarioController = new UsuarioController(usuarioDAO, crearUsuario, borrarUsuario, buscarUsuario, actualizarUsuario, listarUsuario);
        libroController = new LibroController(libroDAO, autorDAO, crearLibro, buscarLibro, borrarLibro, actualizarLibro, listarLibro);
        bibliotecarioController = new BibliotecarioController(bibliotecarioDAO, crearBibliotecario, buscarBibliotecario, borrarBibliotecario, actualizarBibliotecario, listarBibliotecario);
        prestamoController = new PrestamoController(prestamoDAO, usuarioDAO, libroDAO, bibliotecarioDAO, buscarPrestamo, crearPrestamo, listarPrestamo);
        devolucionController = new DevolucionController(devolucionDAO, prestamoDAO, realizarDevolucion, listarDevolucion);
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
        AutorMenu = new javax.swing.JMenu();
        CrearAItem = new javax.swing.JMenuItem();
        BuscarAItem = new javax.swing.JMenuItem();
        ActAItem = new javax.swing.JMenuItem();
        BorrarAItem = new javax.swing.JMenuItem();
        ListarAItem = new javax.swing.JMenuItem();
        LibroMenu = new javax.swing.JMenu();
        CrearLItem = new javax.swing.JMenuItem();
        BuscarLItem = new javax.swing.JMenuItem();
        ActLItem = new javax.swing.JMenuItem();
        BorrarLItem = new javax.swing.JMenuItem();
        LisLItem = new javax.swing.JMenuItem();
        BliMenu = new javax.swing.JMenu();
        BCrearItem = new javax.swing.JMenuItem();
        BBuscarItem = new javax.swing.JMenuItem();
        BActItem = new javax.swing.JMenuItem();
        BBorrarItem = new javax.swing.JMenuItem();
        BlisItem = new javax.swing.JMenuItem();
        UsuarioMenu = new javax.swing.JMenu();
        UCrearItem = new javax.swing.JMenuItem();
        UBuscarItem = new javax.swing.JMenuItem();
        UActItem = new javax.swing.JMenuItem();
        UBorrarItem = new javax.swing.JMenuItem();
        UListarItem = new javax.swing.JMenuItem();
        PrestamoMenu = new javax.swing.JMenu();
        PCrearItem = new javax.swing.JMenuItem();
        PBuscarItem = new javax.swing.JMenuItem();
        PListarItem = new javax.swing.JMenuItem();
        DevolucionMenu = new javax.swing.JMenu();
        DCrearItem = new javax.swing.JMenuItem();
        DListarItem = new javax.swing.JMenuItem();
        IdiomaMenu = new javax.swing.JMenu();
        openMenuItem7 = new javax.swing.JMenuItem();
        jMenuItem7 = new javax.swing.JMenuItem();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem8 = new javax.swing.JMenuItem();
        jMenuItem9 = new javax.swing.JMenuItem();
        jMenuItem10 = new javax.swing.JMenuItem();
        jMenuItem11 = new javax.swing.JMenuItem();
        jMenuItem12 = new javax.swing.JMenuItem();
        jMenuItem13 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        AutorMenu.setMnemonic('f');
        AutorMenu.setText("Autor");

        CrearAItem.setMnemonic('o');
        CrearAItem.setText("Crear");
        CrearAItem.addActionListener(this::CrearAItemActionPerformed);
        AutorMenu.add(CrearAItem);

        BuscarAItem.setMnemonic('s');
        BuscarAItem.setText("Buscar");
        BuscarAItem.addActionListener(this::BuscarAItemActionPerformed);
        AutorMenu.add(BuscarAItem);

        ActAItem.setMnemonic('a');
        ActAItem.setText("Actualizar");
        ActAItem.addActionListener(this::ActAItemActionPerformed);
        AutorMenu.add(ActAItem);

        BorrarAItem.setMnemonic('x');
        BorrarAItem.setText("Borrar");
        BorrarAItem.addActionListener(this::BorrarAItemActionPerformed);
        AutorMenu.add(BorrarAItem);

        ListarAItem.setText("Listar");
        ListarAItem.addActionListener(this::ListarAItemActionPerformed);
        AutorMenu.add(ListarAItem);

        menuBar.add(AutorMenu);

        LibroMenu.setMnemonic('f');
        LibroMenu.setText("Libro");

        CrearLItem.setMnemonic('o');
        CrearLItem.setText("Crear");
        CrearLItem.addActionListener(this::CrearLItemActionPerformed);
        LibroMenu.add(CrearLItem);

        BuscarLItem.setMnemonic('s');
        BuscarLItem.setText("Buscar");
        BuscarLItem.addActionListener(this::BuscarLItemActionPerformed);
        LibroMenu.add(BuscarLItem);

        ActLItem.setMnemonic('a');
        ActLItem.setText("Actualizar");
        ActLItem.addActionListener(this::ActLItemActionPerformed);
        LibroMenu.add(ActLItem);

        BorrarLItem.setMnemonic('x');
        BorrarLItem.setText("Borrar");
        BorrarLItem.addActionListener(this::BorrarLItemActionPerformed);
        LibroMenu.add(BorrarLItem);

        LisLItem.setText("Listar");
        LisLItem.addActionListener(this::LisLItemActionPerformed);
        LibroMenu.add(LisLItem);

        menuBar.add(LibroMenu);

        BliMenu.setMnemonic('f');
        BliMenu.setText("Bibliotecario");

        BCrearItem.setMnemonic('o');
        BCrearItem.setText("Crear");
        BCrearItem.addActionListener(this::BCrearItemActionPerformed);
        BliMenu.add(BCrearItem);

        BBuscarItem.setMnemonic('s');
        BBuscarItem.setText("Buscar");
        BBuscarItem.addActionListener(this::BBuscarItemActionPerformed);
        BliMenu.add(BBuscarItem);

        BActItem.setMnemonic('a');
        BActItem.setText("Actualizar");
        BActItem.addActionListener(this::BActItemActionPerformed);
        BliMenu.add(BActItem);

        BBorrarItem.setMnemonic('x');
        BBorrarItem.setText("Borrar");
        BBorrarItem.addActionListener(this::BBorrarItemActionPerformed);
        BliMenu.add(BBorrarItem);

        BlisItem.setText("Listar");
        BlisItem.addActionListener(this::BlisItemActionPerformed);
        BliMenu.add(BlisItem);

        menuBar.add(BliMenu);

        UsuarioMenu.setMnemonic('f');
        UsuarioMenu.setText("Usuario");

        UCrearItem.setMnemonic('o');
        UCrearItem.setText("Crear");
        UCrearItem.addActionListener(this::UCrearItemActionPerformed);
        UsuarioMenu.add(UCrearItem);

        UBuscarItem.setMnemonic('s');
        UBuscarItem.setText("Buscar");
        UBuscarItem.addActionListener(this::UBuscarItemActionPerformed);
        UsuarioMenu.add(UBuscarItem);

        UActItem.setMnemonic('a');
        UActItem.setText("Actualizar");
        UActItem.addActionListener(this::UActItemActionPerformed);
        UsuarioMenu.add(UActItem);

        UBorrarItem.setMnemonic('x');
        UBorrarItem.setText("Borrar");
        UBorrarItem.addActionListener(this::UBorrarItemActionPerformed);
        UsuarioMenu.add(UBorrarItem);

        UListarItem.setText("Listar");
        UListarItem.addActionListener(this::UListarItemActionPerformed);
        UsuarioMenu.add(UListarItem);

        menuBar.add(UsuarioMenu);

        PrestamoMenu.setMnemonic('f');
        PrestamoMenu.setText("Prestamo");

        PCrearItem.setMnemonic('o');
        PCrearItem.setText("Crear");
        PCrearItem.addActionListener(this::PCrearItemActionPerformed);
        PrestamoMenu.add(PCrearItem);

        PBuscarItem.setMnemonic('s');
        PBuscarItem.setText("Buscar");
        PBuscarItem.addActionListener(this::PBuscarItemActionPerformed);
        PrestamoMenu.add(PBuscarItem);

        PListarItem.setText("Listar");
        PListarItem.addActionListener(this::PListarItemActionPerformed);
        PrestamoMenu.add(PListarItem);

        menuBar.add(PrestamoMenu);

        DevolucionMenu.setMnemonic('f');
        DevolucionMenu.setText("Devolucion");

        DCrearItem.setMnemonic('o');
        DCrearItem.setText("Crear");
        DCrearItem.addActionListener(this::DCrearItemActionPerformed);
        DevolucionMenu.add(DCrearItem);

        DListarItem.setText("Listar");
        DListarItem.addActionListener(this::DListarItemActionPerformed);
        DevolucionMenu.add(DListarItem);

        menuBar.add(DevolucionMenu);

        IdiomaMenu.setMnemonic('f');
        IdiomaMenu.setText("Idioma");

        openMenuItem7.setMnemonic('o');
        openMenuItem7.setText("Español");
        IdiomaMenu.add(openMenuItem7);

        jMenuItem7.setText("Ingles");
        IdiomaMenu.add(jMenuItem7);

        menuBar.add(IdiomaMenu);

        jMenu1.setText("Archivos");

        jMenuItem8.setText("Exportar autores a Archivo,ups");
        jMenuItem8.addActionListener(this::jMenuItem8ActionPerformed);
        jMenu1.add(jMenuItem8);

        jMenuItem9.setText("Exportar libros a Archivos.ups");
        jMenuItem9.addActionListener(this::jMenuItem9ActionPerformed);
        jMenu1.add(jMenuItem9);

        jMenuItem10.setText("Exportar bibliotecario a Archivos.ups");
        jMenuItem10.addActionListener(this::jMenuItem10ActionPerformed);
        jMenu1.add(jMenuItem10);

        jMenuItem11.setText("Exportar usuarios a Archivos.ups");
        jMenuItem11.addActionListener(this::jMenuItem11ActionPerformed);
        jMenu1.add(jMenuItem11);

        jMenuItem12.setText("Exportar Prestamo a Archivo.ups");
        jMenuItem12.addActionListener(this::jMenuItem12ActionPerformed);
        jMenu1.add(jMenuItem12);

        jMenuItem13.setText("Exportar Devolucion a Archivos.ups");
        jMenuItem13.addActionListener(this::jMenuItem13ActionPerformed);
        jMenu1.add(jMenuItem13);

        menuBar.add(jMenu1);

        setJMenuBar(menuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(desktopPane, javax.swing.GroupLayout.DEFAULT_SIZE, 565, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(desktopPane, javax.swing.GroupLayout.PREFERRED_SIZE, 501, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BorrarAItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BorrarAItemActionPerformed
        if(borrarAutor== null||!borrarAutor.isVisible()){
            desktopPane.remove(borrarAutor);
            desktopPane.add(borrarAutor);
            borrarAutor.setVisible(true);
        }
    }//GEN-LAST:event_BorrarAItemActionPerformed

    private void BorrarLItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BorrarLItemActionPerformed
        // TODO add your handling code here:
        if (borrarLibro == null || !borrarLibro.isVisible()) {
            desktopPane.remove(borrarLibro);
            desktopPane.add(borrarLibro);
            borrarLibro.setVisible(true);
        }
    }//GEN-LAST:event_BorrarLItemActionPerformed

    private void BBorrarItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BBorrarItemActionPerformed
        // TODO add your handling code here:
        if (borrarBibliotecario == null || !buscarBibliotecario.isVisible()) {
            desktopPane.remove(borrarBibliotecario);
            desktopPane.add(borrarBibliotecario);
            borrarBibliotecario.setVisible(true);
        }
    }//GEN-LAST:event_BBorrarItemActionPerformed

    private void UBorrarItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UBorrarItemActionPerformed
        // TODO add your handling code here:
        if (borrarUsuario == null || !borrarUsuario.isVisible()) {
            desktopPane.remove(borrarUsuario);
            desktopPane.add(borrarUsuario);
            borrarUsuario.setVisible(true);
        }
    }//GEN-LAST:event_UBorrarItemActionPerformed

    private void CrearAItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CrearAItemActionPerformed
        // TODO add your handling code here:
        if (crearAutor == null || !crearAutor.isVisible()) {
            desktopPane.remove(crearAutor);
            desktopPane.add(crearAutor);
            crearAutor.setVisible(true);
        }
    }//GEN-LAST:event_CrearAItemActionPerformed

    private void BuscarAItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BuscarAItemActionPerformed
        // TODO add your handling code here:
        if (buscarAutor == null || !buscarAutor.isVisible()) {
            desktopPane.remove(buscarAutor);
            desktopPane.add(buscarAutor);
            buscarAutor.setVisible(true);

        }
    }//GEN-LAST:event_BuscarAItemActionPerformed

    private void ActAItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ActAItemActionPerformed
        // TODO add your handling code here:
        if (actualizarAutor == null || !actualizarAutor.isVisible()) {
            desktopPane.remove(actualizarAutor);
            desktopPane.add(actualizarAutor);
            actualizarAutor.setVisible(true);

        }
    }//GEN-LAST:event_ActAItemActionPerformed

    private void ListarAItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ListarAItemActionPerformed
        // TODO add your handling code here:
        if (listarAutor == null || !listarAutor.isVisible()) {
            desktopPane.remove(listarAutor);
            desktopPane.add(listarAutor);
            listarAutor.setVisible(true);
        }
    }//GEN-LAST:event_ListarAItemActionPerformed

    private void CrearLItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CrearLItemActionPerformed
        // TODO add your handling code here:
        if (crearLibro == null || !crearLibro.isVisible()) {
            desktopPane.remove(crearLibro);
            desktopPane.add(crearLibro);
            crearLibro.setVisible(true);
        }
    }//GEN-LAST:event_CrearLItemActionPerformed

    private void BuscarLItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BuscarLItemActionPerformed
        // TODO add your handling code here:
        if (buscarLibro == null || !buscarLibro.isVisible()) {
            desktopPane.remove(buscarLibro);
            desktopPane.add(buscarLibro);
            buscarLibro.setVisible(true);
        }
    }//GEN-LAST:event_BuscarLItemActionPerformed

    private void ActLItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ActLItemActionPerformed
        // TODO add your handling code here:
        if (actualizarLibro == null || !actualizarLibro.isVisible()) {
            desktopPane.remove(actualizarLibro);
            desktopPane.add(actualizarLibro);
            actualizarLibro.setVisible(true);
        }
    }//GEN-LAST:event_ActLItemActionPerformed

    private void LisLItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LisLItemActionPerformed
        // TODO add your handling code here:
        if (listarLibro == null || !listarLibro.isVisible()) {
            desktopPane.remove(listarLibro);
            desktopPane.add(listarLibro);
            listarLibro.setVisible(true);
        }
    }//GEN-LAST:event_LisLItemActionPerformed

    private void BCrearItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BCrearItemActionPerformed
        // TODO add your handling code here:
        if (crearBibliotecario == null || !crearBibliotecario.isVisible()) {
            desktopPane.remove(crearBibliotecario);
            desktopPane.add(crearBibliotecario);
            crearBibliotecario.setVisible(true);
        }
    }//GEN-LAST:event_BCrearItemActionPerformed

    private void BBuscarItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BBuscarItemActionPerformed
        // TODO add your handling code here:
        if (buscarBibliotecario == null || !buscarBibliotecario.isVisible()) {
            desktopPane.remove(buscarBibliotecario);
            desktopPane.add(buscarBibliotecario);
            buscarBibliotecario.setVisible(true);
        }
    }//GEN-LAST:event_BBuscarItemActionPerformed

    private void BActItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BActItemActionPerformed
        // TODO add your handling code here:
        if (actualizarBibliotecario == null || !actualizarBibliotecario.isVisible()) {
            desktopPane.remove(actualizarBibliotecario);
            desktopPane.add(actualizarBibliotecario);
            actualizarBibliotecario.setVisible(true);
        }
    }//GEN-LAST:event_BActItemActionPerformed

    private void BlisItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BlisItemActionPerformed
        // TODO add your handling code here:
        if (listarBibliotecario == null || !listarBibliotecario.isVisible()) {
            desktopPane.remove(listarBibliotecario);
            desktopPane.add(listarBibliotecario);
            listarBibliotecario.setVisible(true);
        }
    }//GEN-LAST:event_BlisItemActionPerformed

    private void UCrearItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UCrearItemActionPerformed
        // TODO add your handling code here:
        if (crearUsuario == null || !crearUsuario.isVisible()) {
            desktopPane.remove(crearUsuario);
            desktopPane.add(crearUsuario);
            crearUsuario.setVisible(true);
        }
    }//GEN-LAST:event_UCrearItemActionPerformed

    private void UBuscarItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UBuscarItemActionPerformed
        // TODO add your handling code here:
        if (buscarUsuario == null || !buscarUsuario.isVisible()) {
            desktopPane.remove(buscarUsuario);
            desktopPane.add(buscarUsuario);
            buscarUsuario.setVisible(true);
        }
    }//GEN-LAST:event_UBuscarItemActionPerformed

    private void UActItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UActItemActionPerformed
        // TODO add your handling code here:
        if (actualizarUsuario == null || !actualizarUsuario.isVisible()) {
            desktopPane.remove(actualizarUsuario);
            desktopPane.add(actualizarUsuario);
            actualizarUsuario.setVisible(true);
        }
    }//GEN-LAST:event_UActItemActionPerformed

    private void UListarItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UListarItemActionPerformed
        // TODO add your handling code here:
        if (listarUsuario == null || !listarUsuario.isVisible()) {
            desktopPane.remove(listarUsuario);
            desktopPane.add(listarUsuario);
            listarUsuario.setVisible(true);
        }
    }//GEN-LAST:event_UListarItemActionPerformed

    private void PCrearItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PCrearItemActionPerformed
        // TODO add your handling code here:
        if (crearPrestamo == null || !crearPrestamo.isVisible()) {
            desktopPane.remove(crearPrestamo);
            desktopPane.add(crearPrestamo);
            crearPrestamo.setVisible(true);
        }
    }//GEN-LAST:event_PCrearItemActionPerformed

    private void PBuscarItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PBuscarItemActionPerformed
        // TODO add your handling code here:
        if (buscarPrestamo == null || !buscarPrestamo.isVisible()) {
            desktopPane.remove(buscarPrestamo);
            desktopPane.add(buscarPrestamo);
            buscarPrestamo.setVisible(true);
        }
    }//GEN-LAST:event_PBuscarItemActionPerformed

    private void PListarItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PListarItemActionPerformed
        // TODO add your handling code here:
        if (listarPrestamo == null || !listarPrestamo.isVisible()) {
            desktopPane.remove(listarPrestamo);
            desktopPane.add(listarPrestamo);
            listarPrestamo.setVisible(true);
        }
    }//GEN-LAST:event_PListarItemActionPerformed

    private void DCrearItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DCrearItemActionPerformed
        // TODO add your handling code here:
        if (realizarDevolucion == null || !realizarDevolucion.isVisible()) {
            desktopPane.remove(realizarDevolucion);
            desktopPane.add(realizarDevolucion);
            realizarDevolucion.setVisible(true);
        }
    }//GEN-LAST:event_DCrearItemActionPerformed

    private void DListarItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DListarItemActionPerformed
        // TODO add your handling code here:
        if (listarDevolucion == null || !listarDevolucion.isVisible()) {
            desktopPane.remove(listarDevolucion);
            desktopPane.add(listarDevolucion);
            listarDevolucion.setVisible(true);
        }
    }//GEN-LAST:event_DListarItemActionPerformed

    private void jMenuItem8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem8ActionPerformed
        // TODO add your handling code here:
        for (Autor autor : autorDAO.listar()) {

            autorArchivos.agregar(autor);

        }

        JOptionPane.showMessageDialog(
                this,
                "Autores guardados en archivo"
        );
    }//GEN-LAST:event_jMenuItem8ActionPerformed

    private void jMenuItem10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem10ActionPerformed
        // TODO add your handling code here:
        for (Bibliotecario b : bibliotecarioDAO.listar()) {

            bibliotecarioDAOArhivo.agregar(b);

        }

        JOptionPane.showMessageDialog(
                this,
                "Bibliotecarios guardados en archivo"
        );
    }//GEN-LAST:event_jMenuItem10ActionPerformed

    private void jMenuItem11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem11ActionPerformed
        // TODO add your handling code here:
        for (Usuario u : usuarioDAO.listar()) {

            usuarioArchivo.agregar(u);

        }

        JOptionPane.showMessageDialog(
                this,
                "Usuarios guardados en archivo"
        );
    }//GEN-LAST:event_jMenuItem11ActionPerformed

    private void jMenuItem9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem9ActionPerformed
        // TODO add your handling code here:
        for (Libro libro : libroDAO.listar()) {

            libroDAOArchivo.agregar(libro);

        }

        JOptionPane.showMessageDialog(
                this,
                "Libros guardados en archivo"
        );
    }//GEN-LAST:event_jMenuItem9ActionPerformed

    private void jMenuItem12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem12ActionPerformed
        // TODO add your handling code here:
        for (Prestamo p : prestamoDAO.listar()) {

            prestamoArchivo.agregar(p);

        }

        JOptionPane.showMessageDialog(
                this,
                "Prestamos guardados en archivo"
        );
    }//GEN-LAST:event_jMenuItem12ActionPerformed

    private void jMenuItem13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem13ActionPerformed
        // TODO add your handling code here:
        for (Devolucion autor : devolucionDAO.listar()) {

            devolucionArchivo.agregar(autor);

        }

        JOptionPane.showMessageDialog(
                this,
                "Devolucion guardados en archivo"
        );
    }//GEN-LAST:event_jMenuItem13ActionPerformed

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

    public void cambiarIdioma(Locale locale){
        ResourceBundle bundle =ResourceBundle.getBundle("ec.edu.ups.sistemabiblioteca.i18n", locale);
        //Nombres Menu
        AutorMenu.setText(bundle.getString("au"));
        LibroMenu.setText(bundle.getString("lib"));
        BliMenu.setText(bundle.getString("bli"));
        UsuarioMenu.setText(bundle.getString("usu"));
        PrestamoMenu.setText(bundle.getString("pres"));
        DevolucionMenu.setText(bundle.getString("dev"));
        //Items Autor
        CrearAItem.setText(bundle.getString("iC"));
        BuscarAItem.setText(bundle.getString("iBus"));
        ActAItem.setText(bundle.getString("iAc"));
        BorrarAItem.setText(bundle.getString("iBo"));
        ListarAItem.setText(bundle.getString("iLis"));
        //Items Libro
        CrearLItem.setText(bundle.getString("iC"));
        BuscarLItem.setText(bundle.getString("iBus"));
        ActLItem.setText(bundle.getString("iAc"));
        BorrarLItem.setText(bundle.getString("iBo"));
        LisLItem.setText(bundle.getString("iLis"));
        //Item Bli
        BCrearItem.setText(bundle.getString("iC"));
        BBuscarItem.setText(bundle.getString("iBus"));
        BActItem.setText(bundle.getString("iAc"));
        BBorrarItem.setText(bundle.getString("iBo"));
        BlisItem.setText(bundle.getString("iLis"));
        //Item Usuario
        UCrearItem.setText(bundle.getString("iC"));
        UBuscarItem.setText(bundle.getString("iBus"));
        UActItem.setText(bundle.getString("iAc"));
        UBorrarItem.setText(bundle.getString("iBo"));
        UListarItem.setText(bundle.getString("iLis"));
        //Item Prestamo
        PCrearItem.setText(bundle.getString("iC"));
        PBuscarItem.setText(bundle.getString("iBus"));
        PListarItem.setText(bundle.getString("iLis"));
        //Item Devoluciones
        DCrearItem.setText(bundle.getString("iC"));
        DListarItem.setText(bundle.getString("iLis"));
        //Autor
        actualizarAutor.cambiarIdioma(locale);
        borrarAutor.cambiarIdioma(locale);
        buscarAutor.cambiarIdioma(locale);
        crearAutor.cambiarIdioma(locale);
        listarAutor.cambiarIdioma(locale);
        //Bibliotecario
        actualizarBibliotecario.cambiarIdioma(locale);
        borrarBibliotecario.cambiarIdioma(locale);
        buscarBibliotecario.cambiarIdioma(locale);
        crearBibliotecario.cambiarIdioma(locale);
        listarBibliotecario.cambiarIdioma(locale);
        //Devoluciones
        listarDevolucion.cambiarIdioma(locale);
        realizarDevolucion.cambiarIdioma(locale);
        //Libro
        actualizarLibro.cambiarIdioma(locale);
        borrarLibro.cambiarIdioma(locale);
        buscarLibro.cambiarIdioma(locale);
        crearLibro.cambiarIdioma(locale);
        listarLibro.cambiarIdioma(locale);
        //Prestamos
        buscarPrestamo.cambiarIdioma(locale);
        crearPrestamo.cambiarIdioma(locale);
        listarPrestamo.cambiarIdioma(locale);
        //Usuarios
        actualizarUsuario.cambiarIdioma(locale);
        borrarUsuario.cambiarIdioma(locale);
        buscarUsuario.cambiarIdioma(locale);
        crearUsuario.cambiarIdioma(locale);
        listarUsuario.cambiarIdioma(locale);
        
        
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem ActAItem;
    private javax.swing.JMenuItem ActLItem;
    private javax.swing.JMenu AutorMenu;
    private javax.swing.JMenuItem BActItem;
    private javax.swing.JMenuItem BBorrarItem;
    private javax.swing.JMenuItem BBuscarItem;
    private javax.swing.JMenuItem BCrearItem;
    private javax.swing.JMenu BliMenu;
    private javax.swing.JMenuItem BlisItem;
    private javax.swing.JMenuItem BorrarAItem;
    private javax.swing.JMenuItem BorrarLItem;
    private javax.swing.JMenuItem BuscarAItem;
    private javax.swing.JMenuItem BuscarLItem;
    private javax.swing.JMenuItem CrearAItem;
    private javax.swing.JMenuItem CrearLItem;
    private javax.swing.JMenuItem DCrearItem;
    private javax.swing.JMenuItem DListarItem;
    private javax.swing.JMenu DevolucionMenu;
    private javax.swing.JMenu IdiomaMenu;
    private javax.swing.JMenu LibroMenu;
    private javax.swing.JMenuItem LisLItem;
    private javax.swing.JMenuItem ListarAItem;
    private javax.swing.JMenuItem PBuscarItem;
    private javax.swing.JMenuItem PCrearItem;
    private javax.swing.JMenuItem PListarItem;
    private javax.swing.JMenu PrestamoMenu;
    private javax.swing.JMenuItem UActItem;
    private javax.swing.JMenuItem UBorrarItem;
    private javax.swing.JMenuItem UBuscarItem;
    private javax.swing.JMenuItem UCrearItem;
    private javax.swing.JMenuItem UListarItem;
    private javax.swing.JMenu UsuarioMenu;
    private javax.swing.JDesktopPane desktopPane;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuItem jMenuItem10;
    private javax.swing.JMenuItem jMenuItem11;
    private javax.swing.JMenuItem jMenuItem12;
    private javax.swing.JMenuItem jMenuItem13;
    private javax.swing.JMenuItem jMenuItem7;
    private javax.swing.JMenuItem jMenuItem8;
    private javax.swing.JMenuItem jMenuItem9;
    private javax.swing.JMenuBar menuBar;
    private javax.swing.JMenuItem openMenuItem7;
    // End of variables declaration//GEN-END:variables

}
