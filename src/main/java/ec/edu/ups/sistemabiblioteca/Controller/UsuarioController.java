package ec.edu.ups.sistemabiblioteca.Controller;

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
import java.util.Locale;
import java.util.ResourceBundle;
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
    private String agUmsj; 
    private String sCUmsj;  
    private String canCUmsj;  
    private String actUmsj;  
    private String sAUmsj;  
    private String dlUmsj;  
    private String sDUmsj; 
    private String tCUmsj;
    private String cfmLmsj;
    private String fchmsj;
    private String nUmsj;

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
        //mensajes
        agUmsj = "¿Quieres crear un nuevo usuario?";
        sCUmsj = "Usuario creado exitosamente :)"; 
        canCUmsj = "Acción cancelada :(";
        actUmsj = "¿Quieres actualizar este usuario?";
        sAUmsj = "Usuario actualizado correctamente :)";
        dlUmsj = "¿Desea eliminar este usuario?";
        sDUmsj = "Usuario eliminado correctamente :)";
        tCUmsj = "Todos los campos deben estar llenos para guardar el usuario.";
        cfmLmsj = "Confirmar";
        fchmsj  = "Error: El formato de fecha debe ser AAAA-MM-DD.";
        nUmsj = "No se encontró el usuario";
    }

    public void mostrarMensaje(java.awt.Component ventana, String mensaje, String titulo, int tipoMensaje) {
        JOptionPane.showMessageDialog(ventana, mensaje, titulo, tipoMensaje);
    }

    public void agregarUsuario() {

        int respuesta = JOptionPane.showConfirmDialog(
                crearUsuario,
                agUmsj,
                cfmLmsj,
                JOptionPane.YES_NO_OPTION);

        if (respuesta == JOptionPane.YES_OPTION) {

            try {

                String cedula = crearUsuario.getjTextFieldCUCedula().getText().trim();
                String nombre = crearUsuario.getjTextFieldCUNombre().getText().trim();
                String apellido = crearUsuario.getjTextFieldCUApellido().getText().trim();
                String telefono = crearUsuario.getjTextFieldCUTelefono().getText().trim();
                String correo = crearUsuario.getjTextFieldCUCElectronico().getText().trim();
                String direccion = crearUsuario.getjTextFieldCUDireccion().getText().trim();
                String fechaTexto = crearUsuario.getjTextFieldCUFNacimiento().getText().trim();
                if (cedula.isEmpty() || nombre.isEmpty() || apellido.isEmpty()
                        || telefono.isEmpty() || correo.isEmpty()
                        || direccion.isEmpty() || fechaTexto.isEmpty()) {

                    crearUsuario.mostrarInformacion(
                            tCUmsj);
                    return;
                }
                Date fecha;

                try {

                    fecha = Date.valueOf(fechaTexto);

                } catch (IllegalArgumentException e) {

                    crearUsuario.mostrarInformacion(
                            fchmsj);
                    return;
                }
                Usuario usuario = new Usuario(correo, direccion, cedula, nombre, apellido, telefono, fecha);

                usuarioDao.agregar(usuario);

                crearUsuario.mostrarInformacion1(sCUmsj);
                crearUsuario.getjTextFieldCUCedula().setText("");
                crearUsuario.getjTextFieldCUNombre().setText("");
                crearUsuario.getjTextFieldCUApellido().setText("");
                crearUsuario.getjTextFieldCUTelefono().setText("");
                crearUsuario.getjTextFieldCUCElectronico().setText("");
                crearUsuario.getjTextFieldCUDireccion().setText("");
                crearUsuario.getjTextFieldCUFNacimiento().setText("");

            } catch (IllegalArgumentException e) {
                mostrarMensaje(crearUsuario, fchmsj, "Error", JOptionPane.ERROR_MESSAGE);
            }

        } else {
            crearUsuario.mostrarInformacion(canCUmsj);
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

            buscarUsuario.mostrarInformacion(nUmsj);
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

            actualizarUsuario.mostrarInformacion(nUmsj);
        }
    }

    public void actualizarUsuario() {

        String cedula = actualizarUsuario.getjTextFieldAUCedula().getText();
        Usuario existe = usuarioDao.buscar(cedula);

        if (existe != null) {

            int respuesta = JOptionPane.showConfirmDialog(
                    actualizarUsuario,
                    actUmsj,
                    cfmLmsj,
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

                actualizarUsuario.mostrarInformacion1(sAUmsj);
            }
        } else {
            actualizarUsuario.mostrarInformacion(nUmsj);
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
            eliminarUsuario.mostrarInformacion(nUmsj);
        }
    }

    public void eliminarUsuario() {

        String cedula = eliminarUsuario.getjTextFieldEUCedula().getText();
        Usuario usuario = usuarioDao.buscar(cedula);

        if (usuario != null) {

            int respuesta = JOptionPane.showConfirmDialog(
                    eliminarUsuario,
                    dlUmsj,
                    cfmLmsj,
                    JOptionPane.YES_NO_OPTION);

            if (respuesta == 0) {

                usuarioDao.eliminar(cedula);

                eliminarUsuario.mostrarInformacion(sDUmsj);
                crearUsuario.getjTextFieldCUCedula().setText("");
                crearUsuario.getjTextFieldCUNombre().setText("");
                crearUsuario.getjTextFieldCUApellido().setText("");
                crearUsuario.getjTextFieldCUTelefono().setText("");
                crearUsuario.getjTextFieldCUCElectronico().setText("");
                crearUsuario.getjTextFieldCUDireccion().setText("");
                crearUsuario.getjTextFieldCUFNacimiento().setText("");
            }

        } else {
            eliminarUsuario.mostrarInformacion(nUmsj);
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
            eliminarUsuario.mostrarInformacion(nUmsj);
        }
    }

    public void configurarEventosEliminarUsuario() {
        eliminarUsuario.getjButtonEUBuscar().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                buscarEliminarUsuario();
            }
        });

        eliminarUsuario.getjButtonEUABorrar().addActionListener(new ActionListener() {
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
    public void cambiarIdioma(Locale locale){
        ResourceBundle bundle =  ResourceBundle.getBundle("ec.edu.ups.sistemabiblioteca.i18n", locale);
        agUmsj = (bundle.getString("agUmsj"));
        sCUmsj = (bundle.getString("sCUmsj"));
        canCUmsj = (bundle.getString("canCUmsj"));
        actUmsj = (bundle.getString("actUmsj"));
        sAUmsj = (bundle.getString("sAUmsj"));
        dlUmsj = (bundle.getString("dlUmsj"));
        sDUmsj = (bundle.getString("sDUmsj"));
        tCUmsj = (bundle.getString("tCUmsj"));
        cfmLmsj = (bundle.getString("cfmLmsj"));
        fchmsj = (bundle.getString("fchmsj"));
        nUmsj = (bundle.getString("nUmsj"));
        
        
    }
}
