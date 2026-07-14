
package ec.edu.ups.sistemabiblioteca.controllers;

import ec.edu.ups.sistemabiblioteca.DAO.UsuarioDAOMemoria;
import ec.edu.ups.sistemabiblioteca.models.Usuario;
import ec.edu.ups.sistemabiblioteca.view.usuario.ActualizarUsuario;
import ec.edu.ups.sistemabiblioteca.view.usuario.BorrarUsuario;
import ec.edu.ups.sistemabiblioteca.view.usuario.BuscarUsuario;
import ec.edu.ups.sistemabiblioteca.view.usuario.ListarUsuario;
import ec.edu.ups.sistemabiblioteca.view.usuario.CrearUsuario;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.event.InternalFrameAdapter;
import javax.swing.event.InternalFrameEvent;

public class UsuarioController {

    //Dao
    private UsuarioDAOMemoria usuarioDao;

    private CrearUsuario crearUsuario;
    private BorrarUsuario eliminarUsuario;
    private BuscarUsuario buscarUsuario;
    private ActualizarUsuario actualizarUsuario;
    private ListarUsuario listaUsuarios;

    public UsuarioController(
            UsuarioDAOMemoria usuarioDao,
            CrearUsuario crearUsuario,
            BorrarUsuario eliminarUsuario,
            BuscarUsuario buscarUsuario,
            ActualizarUsuario actualizarUsuario,
            ListarUsuario listaUsuarios) {

        this.usuarioDao = usuarioDao;
        this.crearUsuario = crearUsuario;
        this.eliminarUsuario = eliminarUsuario;
        this.buscarUsuario = buscarUsuario;
        this.actualizarUsuario = actualizarUsuario;
        this.listaUsuarios = listaUsuarios;

        configurarEventosAgregarUsuario();
        configurarEventosBuscarUsuario();
        configurarEventosEliminarUsuario();
        configurarEventosActualizarUsuario();
        configurarEventosListarUsuarios();
    }
    
    public void mostrarInformacion(java.awt.Component ventana, String mensaje) {
        JOptionPane.showMessageDialog(ventana, mensaje);
        java.awt.Window win = javax.swing.SwingUtilities.getWindowAncestor(ventana);
        if (win != null) {
            win.dispose();
        }
    }
    public void mostrarMensaje(java.awt.Component ventana, String mensaje, String titulo, int tipoMensaje) {
        JOptionPane.showMessageDialog(ventana, mensaje, titulo, tipoMensaje);
    }

    public void agregarUsuario() {

        int respuesta = JOptionPane.showConfirmDialog(
                crearUsuario,
                "¿Quieres crear un nuevo usuario?",
                "Confirmar",
                JOptionPane.YES_NO_OPTION);

        if (respuesta == 0) {

            try {

                String cedula = crearUsuario.getTxtAgregarUsuarioCedula().getText();
                String nombre = crearUsuario.getTxtNombreUsuario().getText();
                String apellido = crearUsuario.getTxtApellidoUsuario().getText();
                String telefono = crearUsuario.getTxtTelefonoUsuario().getText();
                String correo = crearUsuario.getTxtCorreoUsuario().getText();
                String direccion = crearUsuario.getTxtDireccionUsuaria().getText();
                Date fecha = Date.valueOf(crearUsuario.getTxtFechaUsuario().getText());

                Usuario usuario = new Usuario(correo, direccion, cedula, nombre, apellido, telefono, fecha);

                usuarioDao.agregar(usuario);

                crearUsuario.mostrarInformacion("Usuario creado exitosamente :)");
                crearUsuario.getTxtAgregarUsuarioCedula().setText("");
                crearUsuario.getTxtNombreUsuario().setText("");
                crearUsuario.getTxtApellidoUsuario().setText("");
                crearUsuario.getTxtTelefonoUsuario().setText("");
                crearUsuario.getTxtCorreoUsuario().setText("");
                crearUsuario.getTxtDireccionUsuaria().setText("");
                crearUsuario.getTxtFechaUsuario().setText("");

            } catch (IllegalArgumentException e) {
                mostrarMensaje(crearUsuario, "Error: El formato de fecha debe ser AAAA-MM-DD.", "Error", JOptionPane.ERROR_MESSAGE);
            }

        } else {
            mostrarInformacion(crearUsuario, "Acción cancelada :(");
        }
    }

    public void configurarEventosAgregarUsuario() {
        crearUsuario.getBtbAgregarUsuario().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                agregarUsuario();
            }
        });
    }

    public void buscarUsuario() {

        String cedula = buscarUsuarioView.getTxtBuscarUsuario().getText();
        Usuario usuario = usuarioDao.buscar(cedula);

        if (usuario != null) {

            buscarUsuarioView.getTxtBuscarUsuario().setText(usuario.getCedula());
            buscarUsuarioView.getTxtNombreUsuarioBuscado().setText(usuario.getNombre());
            buscarUsuarioView.getTxtApellidoUsuarioBuscado().setText(usuario.getApellido());
            buscarUsuarioView.getTxtTelefonoUsuarioBuscado().setText(usuario.getTelefono());
            buscarUsuarioView.getTxtCorreoUsuarioBuscado().setText(usuario.getCorreoElectronico());
            buscarUsuarioView.getTxtFechaUsuarioBuscado().setText(String.valueOf(usuario.getFechaNacimiento()));

        } else {

            buscarUsuarioView.getTxtBuscarUsuario().setText("");
            buscarUsuarioView.getTxtNombreUsuarioBuscado().setText("");
            buscarUsuarioView.getTxtApellidoUsuarioBuscado().setText("");
            buscarUsuarioView.getTxtTelefonoUsuarioBuscado().setText("");
            buscarUsuarioView.getTxtCorreoUsuarioBuscado().setText("");
            buscarUsuarioView.getTxtFechaUsuarioBuscado().setText("");

            buscarUsuarioView.mostrarInformacion("No se encontró el usuario");
        }
    }

    public void configurarEventosBuscarUsuario() {
        buscarUsuarioView.getBtnBuscarBUsuario().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                buscarUsuario();
            }
        });
    }

    public void buscarActualizarUsuario() {

        String cedula = actualizarUsuarioView.getTxtActualizarUsuarioCedula().getText();
        Usuario usuario = usuarioDao.buscar(cedula);

        if (usuario != null) {

            actualizarUsuarioView.getTxtNombreUsuarioActualizar().setText(usuario.getNombre());
            actualizarUsuarioView.getTxtApellidoUsuarioActualizar().setText(usuario.getApellido());
            actualizarUsuarioView.getTxtTelefonoUsuarioActualizar().setText(usuario.getTelefono());
            actualizarUsuarioView.getTxtCorreoUsuarioActualizar().setText(usuario.getCorreoElectronico());
            actualizarUsuarioView.getTxtDireccionUsuarioActualizar().setText(usuario.getDireccion());
            actualizarUsuarioView.getTxtFechaUsuarioActualizar().setText(String.valueOf(usuario.getFechaNacimiento()));

        } else {

            actualizarUsuarioView.getTxtNombreUsuarioActualizar().setText("");
            actualizarUsuarioView.getTxtApellidoUsuarioActualizar().setText("");
            actualizarUsuarioView.getTxtTelefonoUsuarioActualizar().setText("");
            actualizarUsuarioView.getTxtCorreoUsuarioActualizar().setText("");
            actualizarUsuarioView.getTxtDireccionUsuarioActualizar().setText("");
            actualizarUsuarioView.getTxtFechaUsuarioActualizar().setText("");

            actualizarUsuarioView.mostrarInformacion("No se encontró el usuario");
        }
    }

    public void actualizarUsuario() {

        String cedula = actualizarUsuarioView.getTxtActualizarUsuarioCedula().getText();
        Usuario existe = usuarioDao.buscar(cedula);

        if (existe != null) {

            int respuesta = JOptionPane.showConfirmDialog(
                    actualizarUsuarioView,
                    "¿Quieres actualizar este usuario?",
                    "Confirmar",
                    JOptionPane.YES_NO_OPTION);

            if (respuesta == 0) {

                String nombre = actualizarUsuarioView.getTxtNombreUsuarioActualizar().getText();
                String apellido = actualizarUsuarioView.getTxtApellidoUsuarioActualizar().getText();
                String telefono = actualizarUsuarioView.getTxtTelefonoUsuarioActualizar().getText();
                String correo = actualizarUsuarioView.getTxtCorreoUsuarioActualizar().getText();
                String direccion = actualizarUsuarioView.getTxtDireccionUsuarioActualizar().getText();
                Date fecha = Date.valueOf(actualizarUsuarioView.getTxtFechaUsuarioActualizar().getText());

                Usuario nuevo = new Usuario(correo, direccion, cedula, nombre, apellido, telefono, fecha);

                usuarioDao.actualizar(nuevo);

                actualizarUsuarioView.mostrarInformacion("Usuario actualizado correctamente :)");
            }
        } else {
            actualizarUsuarioView.mostrarInformacion("No se encontró el usuario");
        }
    }

    public void buscarEliminarUsuario() {

        String cedula = eliminarUsuarioView.getTxtEliminarUsuarioCedula().getText();
        Usuario usuario = usuarioDao.buscar(cedula);

        if (usuario != null) {

            eliminarUsuarioView.getTxtEliminarUsuarioNombre().setText(usuario.getNombre());
            eliminarUsuarioView.getTxtApellidoUsuarioEliminado().setText(usuario.getApellido());
            eliminarUsuarioView.getTxtTelefonoUsuarioEliminado().setText(usuario.getTelefono());
            eliminarUsuarioView.getTxtCorreoUsuarioEliminado().setText(usuario.getCorreoElectronico());
            eliminarUsuarioView.getTxtFechaUsuarioEliminado().setText(String.valueOf(usuario.getFechaNacimiento()));

        } else {
            eliminarUsuarioView.mostrarInformacion("No se encontró el usuario");
        }
    }

    public void eliminarUsuario() {

        String cedula = eliminarUsuarioView.getTxtEliminarUsuarioCedula().getText();
        Usuario usuario = usuarioDao.buscar(cedula);

        if (usuario != null) {

            int respuesta = JOptionPane.showConfirmDialog(
                    eliminarUsuarioView,
                    "¿Desea eliminar este usuario?",
                    "Confirmar",
                    JOptionPane.YES_NO_OPTION);

            if (respuesta == 0) {

                usuarioDao.eliminar(cedula);

                eliminarUsuarioView.mostrarInformacion("Usuario eliminado correctamente :)");
                agregarUsuarioView.getTxtAgregarUsuarioCedula().setText("");
                agregarUsuarioView.getTxtNombreUsuario().setText("");
                agregarUsuarioView.getTxtApellidoUsuario().setText("");
                agregarUsuarioView.getTxtTelefonoUsuario().setText("");
                agregarUsuarioView.getTxtCorreoUsuario().setText("");
                agregarUsuarioView.getTxtDireccionUsuaria().setText("");
                agregarUsuarioView.getTxtFechaUsuario().setText("");
            }

        } else {
            eliminarUsuarioView.mostrarInformacion("No se encontró el usuario");
        }
    }

    public void configurarEventosActualizarUsuario() {
        actualizarUsuarioView.getBtnBuscarActualizarUsuario().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                buscarActualizarUsuario();
            }
        });

        actualizarUsuarioView.getBtnActualizarUsuario().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                actualizarUsuario();
            }
        });
    }

    public void buscarUsuarioParaEliminar() {

        String cedula = eliminarUsuarioView.getTxtEliminarUsuarioCedula().getText();
        Usuario usuario = usuarioDao.buscar(cedula);

        if (usuario != null) {

            eliminarUsuarioView.getTxtEliminarUsuarioNombre().setText(usuario.getNombre());
            eliminarUsuarioView.getTxtApellidoUsuarioEliminado().setText(usuario.getApellido());
            eliminarUsuarioView.getTxtTelefonoUsuarioEliminado().setText(usuario.getTelefono());
            eliminarUsuarioView.getTxtCorreoUsuarioEliminado().setText(usuario.getCorreoElectronico());
            eliminarUsuarioView.getTxtFechaUsuarioEliminado().setText(String.valueOf(usuario.getFechaNacimiento()));

        } else {
            eliminarUsuarioView.mostrarInformacion("No se encontró el usuario");
        }
    }

    public void configurarEventosEliminarUsuario() {
        eliminarUsuarioView.getBtbBuscarEliminarUsuario().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                buscarEliminarUsuario();
            }
        });

        eliminarUsuarioView.getBtbEliminarUsuario().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                eliminarUsuario();
            }
        });
    }

    public void listarUsuarios() {
        List<Usuario> lista = usuarioDao.listar();
        listaUsuariosView.cargarDatos(lista);
    }
        public void mostrarContadorAutores() {

        int total = usuarioDao.contar();

        listaUsuariosView.getTxtContadordeUsuarios().setText(String.valueOf(total));
    }

    public void configurarEventosListarUsuarios() {

        listaUsuariosView.addInternalFrameListener(new InternalFrameAdapter() {
            @Override
            public void internalFrameActivated(InternalFrameEvent e) {
                listarUsuarios();
                mostrarContadorAutores();
            }
        });

    }
