/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.ups.sistemabiblioteca.Controller;

import ec.edu.ups.sistemabiblioteca.DAO.BibliotecarioDAOMemoria;
import ec.edu.ups.sistemabiblioteca.models.Bibliotecario;
import ec.edu.ups.sistemabiblioteca.view.bibliotecario.ActualizarBibliotecario;
import ec.edu.ups.sistemabiblioteca.view.bibliotecario.BorrarBibliotecario;
import ec.edu.ups.sistemabiblioteca.view.bibliotecario.BuscarBibliotecario;
import ec.edu.ups.sistemabiblioteca.view.bibliotecario.CrearBibliotecario;
import ec.edu.ups.sistemabiblioteca.view.bibliotecario.ListarBibliotecario;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.event.AncestorListener;

/**
 *
 * @author katherine
 */
public class BibliotecarioController {

    private BibliotecarioDAOMemoria bibliotecarioDAOMemoria;

    private CrearBibliotecario crearBibliotecario;
    private BuscarBibliotecario buscarBibliotecario;
    private BorrarBibliotecario eliminarBibliotecario;
    private ActualizarBibliotecario actualizarBibliotecario;
    private ListarBibliotecario listarBibliotecario;

    public BibliotecarioController(BibliotecarioDAOMemoria bibliotecarioDAOMemoria, CrearBibliotecario crearBibliotecario, BuscarBibliotecario buscarBibliotecario, BorrarBibliotecario eliminarBibliotecario, ActualizarBibliotecario actualizarBibliotecario, ListarBibliotecario listarBibliotecario) {
        this.bibliotecarioDAOMemoria = bibliotecarioDAOMemoria;
        this.crearBibliotecario = crearBibliotecario;
        this.buscarBibliotecario = buscarBibliotecario;
        this.eliminarBibliotecario = eliminarBibliotecario;
        this.actualizarBibliotecario = actualizarBibliotecario;
        this.listarBibliotecario = listarBibliotecario;

        configurarCrearBibliotecario();
        configurarEventosBuscarBibliotecario();
        configurarEventosEliminarBibliotecario();
        configurarEventosActualizarBibliotecario();
        configurarEventosListarBibliotecario();
    }

    public void crearBibliotecario() {
        int respuesta = JOptionPane.showConfirmDialog(crearBibliotecario, "¿Quieres crear un nuevo bibliotecario?",
                "Confirmar",
                JOptionPane.YES_NO_OPTION);

        if (respuesta == JOptionPane.YES_OPTION) {
            try {
                String cedula = crearBibliotecario.getjTextFieldCBCedula().getText().trim();
                String nombre = crearBibliotecario.getjTextFieldCBNombre().getText().trim();
                String apellido = crearBibliotecario.getjTextFieldCBApellido().getText().trim();
                String cargo = crearBibliotecario.getjTextFieldCBCargo().getText().trim();
                String telefono = crearBibliotecario.getjTextFieldCBTelefono().getText().trim();
                String codigo = crearBibliotecario.getjTextFieldCBCodigo().getText().trim();
                String fechaTexto = crearBibliotecario.getjTextFieldCBFecha().getText().trim();
                String turno = crearBibliotecario.getjTextFieldCBTurno().getText().trim();

                if (cedula.isEmpty() || nombre.isEmpty() || apellido.isEmpty()|| cargo.isEmpty() || telefono.isEmpty()|| codigo.isEmpty() || fechaTexto.isEmpty()|| turno.isEmpty()) {
                    
                    crearBibliotecario.mostrarInformacion(
                            "Todos los campos deben estar llenos para guardar el bibliotecario.");
                    return;
                }
                Date fechaNacimiento;

                try {

                    fechaNacimiento = Date.valueOf(fechaTexto);

                } catch (IllegalArgumentException e) {

                    crearBibliotecario.mostrarInformacion(
                            "Error: El formato de fecha debe ser AAAA-MM-DD.");
                    return;
                }
                Bibliotecario bibliotecario = new Bibliotecario(codigo, turno, cargo, cedula, nombre, apellido, telefono, fechaNacimiento);

                bibliotecarioDAOMemoria.agregar(bibliotecario);

                crearBibliotecario.mostrarInformacion1("Bibliotecario creado exitosamente");
                buscarBibliotecario.getjTextFieldBBCedula().setText("");
                buscarBibliotecario.getjTextFieldBBNombre().setText("");
                buscarBibliotecario.getjTextFieldBBApellido().setText("");
                buscarBibliotecario.getjTextFieldBBCargo().setText("");
                buscarBibliotecario.getjTextFieldBBTelefono().setText("");
                buscarBibliotecario.getjTextFieldBBCodigo().setText("");
                buscarBibliotecario.getjTextFieldBBFecha().setText("");
                buscarBibliotecario.getjTextFieldBBTurno().setText("");

            } catch (IllegalArgumentException e) {
                crearBibliotecario.mostrarInformacion("Error : El formato de la fech deber ser AAA-MM-DD");

            }
        } else {
            crearBibliotecario.mostrarInformacion("Acccion Cancelada");

        }
    }

    public void buscarBibliotecario() {
        String cedula = buscarBibliotecario.getjTextFieldBBCedula().getText().trim();
        Bibliotecario bibliotecario = bibliotecarioDAOMemoria.buscar(cedula);

        if (bibliotecario != null) {
            buscarBibliotecario.getjTextFieldBBNombre().setText(bibliotecario.getNombre());
            buscarBibliotecario.getjTextFieldBBApellido().setText(bibliotecario.getApellido());
            buscarBibliotecario.getjTextFieldBBCodigo().setText(bibliotecario.getCodigo());
            buscarBibliotecario.getjTextFieldBBCargo().setText(bibliotecario.getCargo());
            buscarBibliotecario.getjTextFieldBBTelefono().setText(bibliotecario.getTelefono());
            buscarBibliotecario.getjTextFieldBBFecha().setText(String.valueOf(bibliotecario.getFechaNacimiento()));
            buscarBibliotecario.getjTextFieldBBTurno().setText(bibliotecario.getTurno());

        } else {
            buscarBibliotecario.getjTextFieldBBNombre().setText(" ");
            buscarBibliotecario.getjTextFieldBBApellido().setText(" ");
            buscarBibliotecario.getjTextFieldBBCargo().setText(" ");
            buscarBibliotecario.getjTextFieldBBTelefono().setText(" ");
            buscarBibliotecario.getjTextFieldBBFecha().setText(" ");
            buscarBibliotecario.getjTextFieldBBTurno().setText(" ");

            buscarBibliotecario.mostrarInformacion("No se encontro bibliotecario(Bibliotecario no existe)");
        }
    }

    public void eliminarBibliotecario() {
        String cedula = eliminarBibliotecario.getjTextFieldEBCedula().getText();
        Bibliotecario bibliotecario = bibliotecarioDAOMemoria.buscar(cedula);

        if (bibliotecario != null) {
            int respuesta = JOptionPane.showConfirmDialog(
                    eliminarBibliotecario,
                    "¿Quieres eliminar este bibliotecario: " + bibliotecario.getNombre() + " ?",
                    "Confirmar",
                    JOptionPane.YES_NO_OPTION);
            if (respuesta == JOptionPane.YES_OPTION) {
                bibliotecarioDAOMemoria.eliminar(cedula);

                eliminarBibliotecario.mostrarInformacion1("Bibliotecario eliminado exitosamente");
                eliminarBibliotecario.getjButtonEBBCedula().setText(" ");
                eliminarBibliotecario.getjTextFieldEBNombre().setText(" ");
                eliminarBibliotecario.getjTextFieldEBApellido().setText(" ");
                eliminarBibliotecario.getjTextFieldEBCargo().setText(" ");
                eliminarBibliotecario.getjTextFieldEBTelefono().setText(" ");
                eliminarBibliotecario.getjTextFieldEBCodigo().setText(" ");
                eliminarBibliotecario.getjTextFieldEBFecha().setText(" ");
                eliminarBibliotecario.getjTextFieldEBTurno().setText(" ");

            } else {
                eliminarBibliotecario.mostrarInformacion("Accion cancelada");

            }
        } else {
            eliminarBibliotecario.mostrarInformacion("No se encontro el bilbiotecario (cedula no existe)");

        }
    }

    public void buscarEliminado() {
        String cedula = eliminarBibliotecario.getjTextFieldEBCedula().getText();
        Bibliotecario bibliotecario = bibliotecarioDAOMemoria.buscar(cedula);

        if (bibliotecario != null) {

            eliminarBibliotecario.getjTextFieldEBNombre().setText(bibliotecario.getNombre());
            eliminarBibliotecario.getjTextFieldEBApellido().setText(bibliotecario.getApellido());
            eliminarBibliotecario.getjTextFieldEBCargo().setText(bibliotecario.getCargo());
            eliminarBibliotecario.getjTextFieldEBTelefono().setText(bibliotecario.getTelefono());
            eliminarBibliotecario.getjTextFieldEBCodigo().setText(bibliotecario.getCodigo());
            eliminarBibliotecario.getjTextFieldEBFecha().setText(String.valueOf(bibliotecario.getFechaNacimiento()));
            eliminarBibliotecario.getjTextFieldEBTurno().setText(bibliotecario.getTurno());
        } else {
            eliminarBibliotecario.getjTextFieldEBNombre().setText(" ");
            eliminarBibliotecario.getjTextFieldEBApellido().setText(" ");
            eliminarBibliotecario.getjTextFieldEBCargo().setText(" ");
            eliminarBibliotecario.getjTextFieldEBTelefono().setText(" ");
            eliminarBibliotecario.getjTextFieldEBCodigo().setText(" ");
            eliminarBibliotecario.getjTextFieldEBFecha().setText(" ");
            eliminarBibliotecario.getjTextFieldEBTurno().setText(" ");

            eliminarBibliotecario.mostrarInformacion("No se encontro el bibliotecario");

        }
    }

    public void buscarActualizarBibliotecario() {
        String cedula = actualizarBibliotecario.getjTextFieldActBCedula().getText();
        Bibliotecario bibliotecario = bibliotecarioDAOMemoria.buscar(cedula);
        if (bibliotecario != null) {
            actualizarBibliotecario.getjTextFieldActBNombre().setText(bibliotecario.getNombre());
            actualizarBibliotecario.getjTextFieldActBApellido().setText(bibliotecario.getApellido());
            actualizarBibliotecario.getjTextFieldActBCargo().setText(bibliotecario.getCargo());
            actualizarBibliotecario.getjTextFieldActBTelefono().setText(bibliotecario.getTelefono());
            actualizarBibliotecario.getjTextFieldActBCodigo().setText(bibliotecario.getCodigo());
            actualizarBibliotecario.getjTextFieldActBFecha().setText(String.valueOf(bibliotecario.getFechaNacimiento()));
            actualizarBibliotecario.getjTextFieldActBTurno().setText(bibliotecario.getTurno());

        } else {
            actualizarBibliotecario.getjTextFieldActBNombre().setText(" ");
            actualizarBibliotecario.getjTextFieldActBApellido().setText(" ");
            actualizarBibliotecario.getjTextFieldActBCargo().setText(" ");
            actualizarBibliotecario.getjTextFieldActBTelefono().setText(" ");
            actualizarBibliotecario.getjTextFieldActBCodigo().setText(" ");
            actualizarBibliotecario.getjTextFieldActBFecha().setText(" ");
            actualizarBibliotecario.getjTextFieldActBTurno().setText(" ");
            actualizarBibliotecario.mostrarInformacion("No se encontro el bibliotecario(no existe)");

        }
    }

    public void actualizarBibliotecario() {
        String cedula = actualizarBibliotecario.getjTextFieldActBCedula().getText();
        Bibliotecario bibliotecario = bibliotecarioDAOMemoria.buscar(cedula);
        if (bibliotecario != null) {

            int respuesta = JOptionPane.showConfirmDialog(
                    actualizarBibliotecario,
                    "¿Quieres actualizar este bibliotecario: " + bibliotecario.getNombre() + " ?",
                    "Confirmar",
                    JOptionPane.YES_NO_OPTION);
            if (respuesta == JOptionPane.YES_OPTION) {
                String nombre = actualizarBibliotecario.getjTextFieldActBNombre().getText();
                String apellido = actualizarBibliotecario.getjTextFieldActBApellido().getText();
                String cargo = actualizarBibliotecario.getjTextFieldActBCargo().getText();
                String telefono = actualizarBibliotecario.getjTextFieldActBTelefono().getText();
                String codigo = actualizarBibliotecario.getjTextFieldActBCodigo().getText();
                Date fechaNa = Date.valueOf(actualizarBibliotecario.getjTextFieldActBFecha().getText());
                String turno = actualizarBibliotecario.getjTextFieldActBTurno().getText();

                Bibliotecario bibliotecarioActualizado = new Bibliotecario(codigo, turno, cargo, cedula, nombre, apellido, telefono, fechaNa);
                bibliotecarioDAOMemoria.actualizar(bibliotecarioActualizado);
                actualizarBibliotecario.mostrarInformacion1("Bibliotecarip actualizado correctamente");

                actualizarBibliotecario.getjTextFieldActBNombre().setText(" ");
                actualizarBibliotecario.getjTextFieldActBApellido().setText(" ");
                actualizarBibliotecario.getjTextFieldActBCargo().setText(" ");
                actualizarBibliotecario.getjTextFieldActBTelefono().setText(" ");
                actualizarBibliotecario.getjTextFieldActBCodigo().setText(" ");
                actualizarBibliotecario.getjTextFieldActBFecha().setText(" ");
                actualizarBibliotecario.getjTextFieldActBTurno().setText(" ");
            } else {
                actualizarBibliotecario.mostrarInformacion("Accion cancelada");
                buscarBibliotecario.getjTextFieldBBNombre().setText(" ");
                buscarBibliotecario.getjTextFieldBBApellido().setText(" ");
                buscarBibliotecario.getjTextFieldBBCargo().setText(" ");
                buscarBibliotecario.getjTextFieldBBTelefono().setText(" ");
                buscarBibliotecario.getjTextFieldBBFecha().setText(" ");
                buscarBibliotecario.getjTextFieldBBTurno().setText(" ");
            }
        } else {
            actualizarBibliotecario.mostrarInformacion("No se encontro el bibliotecario(cedula no existe)");
        }
    }

    public void listarBibliotecario() {
        List<Bibliotecario> lista = bibliotecarioDAOMemoria.listar();
        listarBibliotecario.cargarDatos(lista);
    }

    public void mostrarContadorBibliotecarios() {

        int total = bibliotecarioDAOMemoria.contar();

        listarBibliotecario.getTxtContadordeBibliotecarios().setText(String.valueOf(total));
    }

    public void configurarCrearBibliotecario() {
        crearBibliotecario.getjButtonCBCrear().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                crearBibliotecario();
            }

        });
    }

    public void configurarEventosBuscarBibliotecario() {
        buscarBibliotecario.getjButtonBBBCedula().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                buscarBibliotecario();
            }

        });
    }

    public void configurarEventosEliminarBibliotecario() {

        eliminarBibliotecario.getjButtonEBBCedula().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                buscarEliminado();
            }
        });
        eliminarBibliotecario.getjButtonEBEliminar().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                eliminarBibliotecario();
            }
        });

    }

    public void configurarEventosActualizarBibliotecario() {

        actualizarBibliotecario.getjButtonActBBCedula().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                buscarActualizarBibliotecario();
            }
        });
        actualizarBibliotecario.getjButtonActualizarB().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                actualizarBibliotecario();
            }
        });
    }

    public void configurarEventosListarBibliotecario() {
        listarBibliotecario.getBtnMostrarListaBibliotecarios().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                listarBibliotecario();
                mostrarContadorBibliotecarios();

            }

        });
    }
}
