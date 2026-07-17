/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.ups.sistemabiblioteca.Controller;

import ec.edu.ups.sistemabiblioteca.DAO.BibliotecarioDAO;
import ec.edu.ups.sistemabiblioteca.DAOMemoria.BibliotecarioDAOMemoria;
import ec.edu.ups.sistemabiblioteca.Exceptions.BibliotecarioNoExiste;
import ec.edu.ups.sistemabiblioteca.enums.Cargo;
import ec.edu.ups.sistemabiblioteca.enums.Turno;
import ec.edu.ups.sistemabiblioteca.models.Bibliotecario;
import ec.edu.ups.sistemabiblioteca.view.bibliotecario.ActualizarBibliotecario;
import ec.edu.ups.sistemabiblioteca.view.bibliotecario.BorrarBibliotecario;
import ec.edu.ups.sistemabiblioteca.view.bibliotecario.BuscarBibliotecario;
import ec.edu.ups.sistemabiblioteca.view.bibliotecario.CrearBibliotecario;
import ec.edu.ups.sistemabiblioteca.view.bibliotecario.ListarBibliotecario;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;
import javax.swing.JOptionPane;
import javax.swing.event.AncestorListener;

/**
 *
 * @author katherine
 */
public class BibliotecarioController {

    private BibliotecarioDAO bibliotecarioDAO;
    private CrearBibliotecario crearBibliotecario;
    private BuscarBibliotecario buscarBibliotecario;
    private BorrarBibliotecario eliminarBibliotecario;
    private ActualizarBibliotecario actualizarBibliotecario;
    private ListarBibliotecario listarBibliotecario;
    private String cBmsj;
    private String exCBmsj;
    private String sCBmsj;
    private String canCBmsj;
    private String dBmsj;
    private String sBmsj;
    private String bDBmsj;
    private String bABmsj;
    private String acBmsj;
    private String sABmsj;
    private String cfmLmsj;
    private String fchmsj;
    private String bCBBmsj;
    private String IDmsj;
    private String  TFmsj;
    private String  Nmsj; 
    private String  Amsj;
    private String  NAmsj; 
    private String  CLmsj; 
    private String  dfsAmsj; 
    private String  mAmsj;
    private String lBmsj;

    public BibliotecarioController(BibliotecarioDAO bibliotecarioDAOMemoria, CrearBibliotecario crearBibliotecario, BuscarBibliotecario buscarBibliotecario, BorrarBibliotecario eliminarBibliotecario, ActualizarBibliotecario actualizarBibliotecario, ListarBibliotecario listarBibliotecario) {
        this.bibliotecarioDAO = bibliotecarioDAOMemoria;
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
        //mensajes
        cBmsj = "¿Quieres crear un nuevo bibliotecario?";
        exCBmsj = "Todos los campos deben estar llenos para guardar el bibliotecario.";
        sCBmsj = "Bibliotecario creado exitosamente";
        canCBmsj = "Acccion Cancelada";
        dBmsj = "¿Quieres eliminar este bibliotecario: ";
        sBmsj = "Bibliotecario eliminado exitosamente";
        bDBmsj = "No se encontro el bibliotecario";
        bABmsj = "No se encontro el bibliotecario(no existe)";
        acBmsj = "¿Quieres actualizar este bibliotecario: ";
        sABmsj = "Bibliotecario actualizado correctamente";
        cfmLmsj = "Confirmar";
        fchmsj = "Error: El formato de fecha debe ser DD-MM-YYYY";
        bCBBmsj = "No se encontro el bilbiotecario (cedula no existe)";
        IDmsj="La cédula debe contener exactamente 10 dígitos.";
        TFmsj ="El teléfono debe contener exactamente 10 dígitos.";
        Nmsj ="El nombre solo puede contener letras.";
        Amsj="El apellido solo puede contener letras.";
        NAmsj = "La nacionalidad solo puede contener letras.";
        CLmsj ="El cargo solo puede contener letras.";
        dfsAmsj = "Debe ingresar una cédula.";
        mAmsj = "Todos los campos deben estar llenos.";
        lBmsj = "No existen bibliotecarios registrados.";
    }
    
    private SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");

    public void crearBibliotecario() {
        int respuesta = JOptionPane.showConfirmDialog(crearBibliotecario, cBmsj,cfmLmsj,JOptionPane.YES_NO_OPTION);
        if (respuesta == JOptionPane.YES_OPTION) {
            try {
                String cedula = crearBibliotecario.getjTextFieldCBCedula().getText().trim();
                String nombre = crearBibliotecario.getjTextFieldCBNombre().getText().trim();
                String apellido = crearBibliotecario.getjTextFieldCBApellido().getText().trim();
                Cargo cargo = Cargo.valueOf(crearBibliotecario.getjComboBoxCargo().getSelectedItem().toString());
                String telefono = crearBibliotecario.getjTextFieldCBTelefono().getText().trim();
                String codigo = crearBibliotecario.getjTextFieldCBCodigo().getText().trim();
                String fechaTexto = crearBibliotecario.getjTextFieldCBFecha().getText().trim();
                Turno turno = Turno.valueOf(crearBibliotecario.getjComboBoxTurno().getSelectedItem().toString());

                if (cedula.isEmpty() || nombre.isEmpty() || apellido.isEmpty() || telefono.isEmpty() || codigo.isEmpty() || fechaTexto.isEmpty() || cargo== null || turno == null) {
                    throw new IllegalArgumentException("Todos los campos deben estar llenos para guardar el bibliotecario.");}

                    if (!cedula.matches("\\d{10}")) {
                        throw new IllegalArgumentException(IDmsj);
                    }
                    if (!telefono.matches("\\d{10}")) {
                        throw new IllegalArgumentException(TFmsj);
                    }
                    if (!nombre.matches("[a-zA-ZÁÉÍÓÚáéíóúÑñ ]+")) {
                        throw new IllegalArgumentException(Nmsj);
                    }
                    if (!apellido.matches("[a-zA-ZÁÉÍÓÚáéíóúÑñ ]+")) {
                        throw new IllegalArgumentException(Amsj);
                    }
                    
                    Date fechaNacimiento;
                    
                    try {     
                    fechaNacimiento = Date.valueOf(fechaTexto);
                    
                    } catch (IllegalArgumentException e) {
                    crearBibliotecario.mostrarInformacion(fchmsj);
                    return;
                }

                Bibliotecario bibliotecario = new Bibliotecario(codigo,turno, cargo, cedula, nombre, apellido, telefono, fechaNacimiento);

                bibliotecarioDAO.agregar(bibliotecario);
                crearBibliotecario.mostrarInformacion1(sCBmsj);
                buscarBibliotecario.getjTextFieldBBCedula().setText("");
                buscarBibliotecario.getjTextFieldBBNombre().setText("");
                buscarBibliotecario.getjTextFieldBBApellido().setText("");
                buscarBibliotecario.getjTextFieldBBCargo().setText("");
                buscarBibliotecario.getjTextFieldBBTelefono().setText("");
                buscarBibliotecario.getjTextFieldBBCodigo().setText("");
                buscarBibliotecario.getjTextFieldBBFecha().setText("");
                buscarBibliotecario.getjTextFieldBBTurno().setText("");

            } catch (IllegalArgumentException e) {
                crearBibliotecario.mostrarInformacion(e.getMessage());
            }
        } else {
            crearBibliotecario.mostrarInformacion(canCBmsj);
        }
    }

    public void buscarBibliotecario() {
        try {
            String cedula = buscarBibliotecario.getjTextFieldBBCedula().getText().trim();
            if (cedula.isEmpty()) {
                throw new IllegalArgumentException(dfsAmsj);
            }
            if (!cedula.matches("\\d{10}")) {
                throw new IllegalArgumentException(IDmsj);
            }

            Bibliotecario bibliotecario = bibliotecarioDAO.buscar(cedula);

            buscarBibliotecario.getjTextFieldBBNombre().setText(bibliotecario.getNombre());
            buscarBibliotecario.getjTextFieldBBApellido().setText(bibliotecario.getApellido());
            buscarBibliotecario.getjTextFieldBBCodigo().setText(bibliotecario.getCodigo());
            buscarBibliotecario.getjTextFieldBBCargo().setText(bibliotecario.getCargo().toString());
            buscarBibliotecario.getjTextFieldBBTelefono().setText(bibliotecario.getTelefono());
            buscarBibliotecario.getjTextFieldBBFecha().setText(formato.format(bibliotecario.getFechaNacimiento()));
            buscarBibliotecario.getjTextFieldBBTurno().setText(bibliotecario.getTurno().toString());

        } catch (BibliotecarioNoExiste e) {

            buscarBibliotecario.getjTextFieldBBNombre().setText("");
            buscarBibliotecario.getjTextFieldBBApellido().setText("");
            buscarBibliotecario.getjTextFieldBBCodigo().setText("");
            buscarBibliotecario.getjTextFieldBBCargo().setText("");
            buscarBibliotecario.getjTextFieldBBTelefono().setText("");
            buscarBibliotecario.getjTextFieldBBFecha().setText("");
            buscarBibliotecario.getjTextFieldBBTurno().setText("");

            buscarBibliotecario.mostrarInformacion(bABmsj);

        } catch (IllegalArgumentException e) {
            buscarBibliotecario.mostrarInformacion(e.getMessage());
        }
    }

    public void eliminarBibliotecario() {

        try {
            String cedula = eliminarBibliotecario.getjTextFieldEBCedula().getText().trim();
            if (cedula.isEmpty()) {
                throw new IllegalArgumentException(dfsAmsj);
            }
            if (!cedula.matches("\\d{10}")) {
                throw new IllegalArgumentException(IDmsj);
            }
            Bibliotecario bibliotecario = bibliotecarioDAO.buscar(cedula);
            
            int respuesta = JOptionPane.showConfirmDialog(eliminarBibliotecario,dBmsj + bibliotecario.getNombre() + " ?",cfmLmsj,JOptionPane.YES_NO_OPTION);

            if (respuesta == JOptionPane.YES_OPTION) {

                bibliotecarioDAO.eliminar(cedula);
                eliminarBibliotecario.mostrarInformacion1(sBmsj);
                eliminarBibliotecario.getjButtonEBBCedula().setText("");
                eliminarBibliotecario.getjTextFieldEBNombre().setText("");
                eliminarBibliotecario.getjTextFieldEBApellido().setText("");
                eliminarBibliotecario.getjTextFieldEBCargo().setText("");
                eliminarBibliotecario.getjTextFieldEBTelefono().setText("");
                eliminarBibliotecario.getjTextFieldEBCodigo().setText("");
                eliminarBibliotecario.getjTextFieldEBFecha().setText("");
                eliminarBibliotecario.getjTextFieldEBTurno().setText("");

            } else {
                eliminarBibliotecario.mostrarInformacion(canCBmsj);
            }
        } catch (BibliotecarioNoExiste e) {
            eliminarBibliotecario.mostrarInformacion(bCBBmsj);
        } catch (IllegalArgumentException e) {
            eliminarBibliotecario.mostrarInformacion(e.getMessage());
        }
    }

    public void buscarEliminado() {

        try {
            String cedula = eliminarBibliotecario.getjTextFieldEBCedula().getText().trim();
            if (cedula.isEmpty()) {
                throw new IllegalArgumentException(dfsAmsj);
            }
            if (!cedula.matches("\\d{10}")) {
                throw new IllegalArgumentException(IDmsj);
            }

            Bibliotecario bibliotecario = bibliotecarioDAO.buscar(cedula);

            eliminarBibliotecario.getjTextFieldEBNombre().setText(bibliotecario.getNombre());
            eliminarBibliotecario.getjTextFieldEBApellido().setText(bibliotecario.getApellido());
            eliminarBibliotecario.getjTextFieldEBCargo().setText(bibliotecario.getCargo().toString());
            eliminarBibliotecario.getjTextFieldEBTelefono().setText(bibliotecario.getTelefono());
            eliminarBibliotecario.getjTextFieldEBCodigo().setText(bibliotecario.getCodigo());
            eliminarBibliotecario.getjTextFieldEBFecha().setText(formato.format(bibliotecario.getFechaNacimiento()));
            eliminarBibliotecario.getjTextFieldEBTurno().setText(bibliotecario.getTurno().toString());

        } catch (BibliotecarioNoExiste e) {

            eliminarBibliotecario.getjTextFieldEBNombre().setText("");
            eliminarBibliotecario.getjTextFieldEBApellido().setText("");
            eliminarBibliotecario.getjTextFieldEBCargo().setText("");
            eliminarBibliotecario.getjTextFieldEBTelefono().setText("");
            eliminarBibliotecario.getjTextFieldEBCodigo().setText("");
            eliminarBibliotecario.getjTextFieldEBFecha().setText("");
            eliminarBibliotecario.getjTextFieldEBTurno().setText("");

            eliminarBibliotecario.mostrarInformacion(bDBmsj);

        } catch (IllegalArgumentException e) {
            eliminarBibliotecario.mostrarInformacion(e.getMessage());
        }
    }

    public void buscarActualizarBibliotecario() {
        try {
            String cedula = actualizarBibliotecario.getjTextFieldActBCedula().getText().trim();

            if (cedula.isEmpty()) {
                throw new IllegalArgumentException(dfsAmsj);
            }
            if (!cedula.matches("\\d{10}")) {
                throw new IllegalArgumentException(IDmsj);
            }

            Bibliotecario bibliotecario = bibliotecarioDAO.buscar(cedula);

            actualizarBibliotecario.getjTextFieldActBNombre().setText(bibliotecario.getNombre());
            actualizarBibliotecario.getjTextFieldActBApellido().setText(bibliotecario.getApellido());
            actualizarBibliotecario.getjComboBoxCargoAc().setSelectedItem(bibliotecario.getCargo().name());
            actualizarBibliotecario.getjTextFieldActBTelefono().setText(bibliotecario.getTelefono());
            actualizarBibliotecario.getjTextFieldActBCodigo().setText(bibliotecario.getCodigo());
            actualizarBibliotecario.getjTextFieldActBFecha().setText(formato.format(bibliotecario.getFechaNacimiento()));
            actualizarBibliotecario.getjComboBoxTurnoAc().setSelectedItem(bibliotecario.getTurno().name());

        } catch (BibliotecarioNoExiste e) {

            actualizarBibliotecario.getjTextFieldActBNombre().setText("");
            actualizarBibliotecario.getjTextFieldActBApellido().setText("");
            actualizarBibliotecario.getjTextFieldActBTelefono().setText("");
            actualizarBibliotecario.getjTextFieldActBCodigo().setText("");
            actualizarBibliotecario.getjTextFieldActBFecha().setText("");

            actualizarBibliotecario.mostrarInformacion(bABmsj);

        } catch (IllegalArgumentException e) {
            actualizarBibliotecario.mostrarInformacion(e.getMessage());
        }
    }

    public void actualizarBibliotecario() {
        try {
            String cedula = actualizarBibliotecario.getjTextFieldActBCedula().getText().trim();

            if (cedula.isEmpty()) {
                throw new IllegalArgumentException(dfsAmsj);
            }
            if (!cedula.matches("\\d{10}")) {
                throw new IllegalArgumentException(IDmsj);
            }

            Bibliotecario bibliotecario = bibliotecarioDAO.buscar(cedula);

            int respuesta = JOptionPane.showConfirmDialog(actualizarBibliotecario,acBmsj + bibliotecario.getNombre() + " ?",cfmLmsj,JOptionPane.YES_NO_OPTION);

            if (respuesta == JOptionPane.YES_OPTION) {

                String nombre = actualizarBibliotecario.getjTextFieldActBNombre().getText().trim();
                String apellido = actualizarBibliotecario.getjTextFieldActBApellido().getText().trim();
                Cargo cargo = Cargo.valueOf(actualizarBibliotecario.getjComboBoxCargoAc().getSelectedItem().toString());
                String telefono = actualizarBibliotecario.getjTextFieldActBTelefono().getText().trim();
                String codigo = actualizarBibliotecario.getjTextFieldActBCodigo().getText().trim();
                String fechaTexto = actualizarBibliotecario.getjTextFieldActBFecha().getText().trim();
                Turno turno = Turno.valueOf(actualizarBibliotecario.getjComboBoxTurnoAc().getSelectedItem().toString());

                if (nombre.isEmpty() || apellido.isEmpty() || cargo== null || telefono.isEmpty() || codigo.isEmpty() || fechaTexto.isEmpty() || turno == null) {
                    throw new IllegalArgumentException(mAmsj);
                }

                if (!nombre.matches("[a-zA-ZÁÉÍÓÚáéíóúÑñ ]+")) {
                    throw new IllegalArgumentException(Nmsj);
                }
                if (!apellido.matches("[a-zA-ZÁÉÍÓÚáéíóúÑñ ]+")) {
                    throw new IllegalArgumentException(Amsj);
                }
                if (!telefono.matches("\\d{10}")) {
                    throw new IllegalArgumentException(TFmsj);
                }

                Date fechaNa;

                try {
                    fechaNa = Date.valueOf(fechaTexto);
                } catch (IllegalArgumentException e) {
                    throw new IllegalArgumentException(fchmsj);
                }

                Bibliotecario bibliotecarioActualizado = new Bibliotecario(codigo,turno,cargo,cedula,nombre,apellido,telefono,fechaNa);

                bibliotecarioDAO.actualizar(bibliotecarioActualizado);
                actualizarBibliotecario.mostrarInformacion1(sABmsj);
                actualizarBibliotecario.getjTextFieldActBNombre().setText("");
                actualizarBibliotecario.getjTextFieldActBApellido().setText("");
                actualizarBibliotecario.getjTextFieldActBTelefono().setText("");
                actualizarBibliotecario.getjTextFieldActBCodigo().setText("");
                actualizarBibliotecario.getjTextFieldActBFecha().setText("");

            } else {

                actualizarBibliotecario.mostrarInformacion(canCBmsj);
            }

        } catch (BibliotecarioNoExiste e) {

            actualizarBibliotecario.mostrarInformacion(bCBBmsj);

        } catch (IllegalArgumentException e) {

            actualizarBibliotecario.mostrarInformacion(e.getMessage());
        }
    }

    public void listarBibliotecario() {

        try {

            List<Bibliotecario> lista = bibliotecarioDAO.listar();

            if (lista == null || lista.isEmpty()) {
                throw new IllegalArgumentException(lBmsj);
            }

            listarBibliotecario.cargarDatos(lista);

        } catch (IllegalArgumentException e) {
            listarBibliotecario.mostrarInformacion(e.getMessage());
        }
    }

    public void mostrarContadorBibliotecarios() {

        int total = bibliotecarioDAO.contar();

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

    public void cambiarIdioma(Locale locale) {
        ResourceBundle bundle = ResourceBundle.getBundle("ec.edu.ups.sistemabiblioteca.i18n.mensajes", locale);
        cBmsj = (bundle.getString("cBmsj"));
        exCBmsj = (bundle.getString("exCBmsj"));
        sCBmsj = (bundle.getString("sCBmsj"));
        canCBmsj = (bundle.getString("canCBmsj"));
        dBmsj = (bundle.getString("dBmsj"));
        sBmsj = (bundle.getString("sBmsj"));
        bDBmsj = (bundle.getString("bDBmsj"));
        bABmsj = (bundle.getString("bABmsj"));
        acBmsj = (bundle.getString("acBmsj"));
        sABmsj = (bundle.getString("sABmsj"));
        cfmLmsj = (bundle.getString("cfmLmsj"));
        fchmsj = (bundle.getString("fchmsj"));
        bCBBmsj = (bundle.getString("bCBBmsj"));
        IDmsj= (bundle.getString("IDmsj"));
        TFmsj = (bundle.getString("TFmsj"));
        Nmsj = (bundle.getString("Nmsj"));
        Amsj= (bundle.getString("Amsj"));
        NAmsj = (bundle.getString("NAmsj"));
        CLmsj = (bundle.getString("CLmsj"));
        dfsAmsj = (bundle.getString("dfsAmsj"));
        mAmsj = (bundle.getString("mAmsj"));
        lBmsj = (bundle.getString("lBmsj"));

    }
}
