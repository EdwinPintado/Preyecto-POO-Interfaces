
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

                String cedula = crearUsuario.getjTextFieldCUCedula().getText();
                String nombre = crearUsuario.getjTextFieldCUNombre().getText();
                String apellido = crearUsuario.getjTextFieldCUApellido().getText();
                String telefono = crearUsuario.getjTextFieldCUTelefono().getText();
                String correo = crearUsuario.getjTextFieldCUCElectronico().getText();
                String direccion = crearUsuario.getjTextFieldCUDireccion().getText();
                Date fecha = Date.valueOf(crearUsuario.getjTextFieldCUFNacimiento().getText());

                Usuario usuario = new Usuario(correo, direccion, cedula, nombre, apellido, telefono, fecha);

                usuarioDao.agregar(usuario);

                mostrarInformacion(crearUsuario, "Usuario creado exitosamente :)");
                crearUsuario.getjTextFieldCUCedula().setText("");
                crearUsuario.getjTextFieldCUNombre().setText("");
                crearUsuario.getjTextFieldCUApellido().setText("");
                crearUsuario.getjTextFieldCUTelefono().setText("");
                crearUsuario.getjTextFieldCUCElectronico().setText("");
                crearUsuario.getjTextFieldCUDireccion().setText("");
                crearUsuario.getjTextFieldCUFNacimiento().setText("");

            } catch (IllegalArgumentException e) {
                mostrarMensaje(crearUsuario, "Error: El formato de fecha debe ser AAAA-MM-DD.", "Error", JOptionPane.ERROR_MESSAGE);
            }

        } else {
            mostrarInformacion(crearUsuario, "Acción cancelada :(");
        }
    }

    public void configurarEventosAgregarUsuario() {
        crearUsuario.getjButtonCUCrear().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                agregarUsuario();
            }
        });
    }

    public void buscarUsuario() {

        String cedula = buscarUsuario.getjTextFieldBUCedula().getText();
        Usuario usuario = usuarioDao.buscar(cedula);

        if (usuario != null) {

            buscarUsuario.getjTextFieldBUCedula().setText(usuario.getCedula());
            buscarUsuario.getjTextFieldBUNombre().setText(usuario.getNombre());
            buscarUsuario.getjTextFieldBUApellido().setText(usuario.getApellido());
            buscarUsuario.getjTextFieldBUTelefono().setText(usuario.getTelefono());
            buscarUsuario.getjTextFieldBUCElectronico().setText(usuario.getCorreoElectronico());
            buscarUsuario.getjTextFieldBUFNacimiento().setText(String.valueOf(usuario.getFechaNacimiento()));

        } else {

            buscarUsuario.getjTextFieldBUCedula().setText("");
            buscarUsuario.getjTextFieldBUNombre().setText("");
            buscarUsuario.getjTextFieldBUApellido().setText("");
            buscarUsuario.getjTextFieldBUTelefono().setText("");
            buscarUsuario.getjTextFieldBUCElectronico().setText("");
            buscarUsuario.getjTextFieldBUFNacimiento().setText("");

            mostrarInformacion(buscarUsuario, "No se encontró el usuario");
        }
    }

    public void configurarEventosBuscarUsuario() {
        buscarUsuario.getjButtonBUBuscar().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                buscarUsuario();
            }
        });
    }

    public void buscarActualizarUsuario() {

        String cedula = actualizarUsuario.getjTextFieldAUCedula().getText();
        Usuario usuario = usuarioDao.buscar(cedula);

        if (usuario != null) {

            actualizarUsuario.getjTextFieldAUNombre().setText(usuario.getNombre());
            actualizarUsuario.getjTextFieldAUApellido().setText(usuario.getApellido());
            actualizarUsuario.getjTextFieldAUTelefono().setText(usuario.getTelefono());
            actualizarUsuario.getjTextFieldAUCElectronico().setText(usuario.getCorreoElectronico());
            actualizarUsuario.getjTextFieldAUDireccion().setText(usuario.getDireccion());
            actualizarUsuario.getjTextFieldAUFNacimiento().setText(String.valueOf(usuario.getFechaNacimiento()));

        } else {

            actualizarUsuario.getjTextFieldAUNombre().setText("");
            actualizarUsuario.getjTextFieldAUApellido().setText("");
            actualizarUsuario.getjTextFieldAUTelefono().setText("");
            actualizarUsuario.getjTextFieldAUCElectronico().setText("");
            actualizarUsuario.getjTextFieldAUDireccion().setText("");
            actualizarUsuario.getjTextFieldAUFNacimiento().setText("");

            mostrarInformacion(actualizarUsuario, "No se encontró el usuario");
        }
    }

    public void actualizarUsuario() {

        String cedula = actualizarUsuario.getjTextFieldAUCedula().getText();
        Usuario existe = usuarioDao.buscar(cedula);

        if (existe != null) {

            int respuesta = JOptionPane.showConfirmDialog(
                    actualizarUsuario,
                    "¿Quieres actualizar este usuario?",
                    "Confirmar",
                    JOptionPane.YES_NO_OPTION);

            if (respuesta == 0) {

                String nombre = actualizarUsuario.getjTextFieldAUNombre().getText();
                String apellido = actualizarUsuario.getjTextFieldAUApellido().getText();
                String telefono = actualizarUsuario.getjTextFieldAUTelefono().getText();
                String correo = actualizarUsuario.getjTextFieldAUCElectronico().getText();
                String direccion = actualizarUsuario.getjTextFieldAUDireccion().getText();
                Date fecha = Date.valueOf(actualizarUsuario.getjTextFieldAUFNacimiento().getText());

                Usuario nuevo = new Usuario(correo, direccion, cedula, nombre, apellido, telefono, fecha);

                usuarioDao.actualizar(nuevo);

                mostrarInformacion(actualizarUsuario,"Usuario actualizado correctamente :)");
            }
        } else {
            mostrarInformacion(actualizarUsuario, "No se encontró el usuario");
        }
    }

    public void buscarEliminarUsuario() {

        String cedula = eliminarUsuario.getjTextFieldEUCedula().getText();
        Usuario usuario = usuarioDao.buscar(cedula);

        if (usuario != null) {

            eliminarUsuario.getjTextFieldEUNombre().setText(usuario.getNombre());
            eliminarUsuario.getjTextFieldEUApellido().setText(usuario.getApellido());
            eliminarUsuario.getjTextFieldEUTelefono().setText(usuario.getTelefono());
            eliminarUsuario.getjTextFieldEUCElectronico().setText(usuario.getCorreoElectronico());
            eliminarUsuario.getjTextFieldEUFNacimiento().setText(String.valueOf(usuario.getFechaNacimiento()));

        } else {
            mostrarInformacion(eliminarUsuario, "No se encontró el usuario");
        }
    }

    public void eliminarUsuario() {

        String cedula = eliminarUsuario.getjTextFieldEUCedula().getText();
        Usuario usuario = usuarioDao.buscar(cedula);

        if (usuario != null) {

            int respuesta = JOptionPane.showConfirmDialog(
                    eliminarUsuario,
                    "¿Desea eliminar este usuario?",
                    "Confirmar",
                    JOptionPane.YES_NO_OPTION);

            if (respuesta == 0) {

                usuarioDao.eliminar(cedula);

                mostrarInformacion(eliminarUsuario, "Usuario eliminado correctamente :)");
                crearUsuario.getjTextFieldCUCedula().setText("");
                crearUsuario.getjTextFieldCUNombre().setText("");
                crearUsuario.getjTextFieldCUApellido().setText("");
                crearUsuario.getjTextFieldCUTelefono().setText("");
                crearUsuario.getjTextFieldCUCElectronico().setText("");
                crearUsuario.getjTextFieldCUDireccion().setText("");
                crearUsuario.getjTextFieldCUFNacimiento().setText("");
            }

        } else {
            mostrarInformacion(eliminarUsuario, "No se encontró el usuario");
        }
    }

    public void configurarEventosActualizarUsuario() {
        actualizarUsuario.getjButtonAUBuscar().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                buscarActualizarUsuario();
            }
        });

        actualizarUsuario.getjButtonAUActualizar().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                actualizarUsuario();
            }
        });
    }

    public void buscarUsuarioParaEliminar() {

        String cedula = eliminarUsuario.getjTextFieldEUCedula().getText();
        Usuario usuario = usuarioDao.buscar(cedula);

        if (usuario != null) {

            eliminarUsuario.getjTextFieldEUNombre().setText(usuario.getNombre());
            eliminarUsuario.getjTextFieldEUApellido().setText(usuario.getApellido());
            eliminarUsuario.getjTextFieldEUTelefono().setText(usuario.getTelefono());
            eliminarUsuario.getjTextFieldEUCElectronico().setText(usuario.getCorreoElectronico());
            eliminarUsuario.getjTextFieldEUFNacimiento().setText(String.valueOf(usuario.getFechaNacimiento()));

        } else {
            mostrarInformacion(eliminarUsuario, "No se encontró el usuario");
        }
    }

    public void configurarEventosEliminarUsuario() {
        eliminarUsuario.getjButtonEUBuscar().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                buscarEliminarUsuario();
            }
        });

        eliminarUsuario.getjButtonEUBorrar().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                eliminarUsuario();
            }
        });
    }

    public void listarUsuarios() {
        List<Usuario> lista = usuarioDao.listar();
        listaUsuarios.cargarDatos(lista);
    }
        public void mostrarContadorAutores() {

        int total = usuarioDao.contar();

        listaUsuarios.getTxtContadordeUsuarios().setText(String.valueOf(total));
    }

    public void configurarEventosListarUsuarios() {

        listaUsuarios.addInternalFrameListener(new InternalFrameAdapter() {
            @Override
            public void internalFrameActivated(InternalFrameEvent e) {
                listarUsuarios();
                mostrarContadorAutores();
            }
        });
    }
}
