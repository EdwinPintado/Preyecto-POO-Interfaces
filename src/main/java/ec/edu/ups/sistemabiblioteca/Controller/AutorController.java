
package ec.edu.ups.sistemabiblioteca.Controller;

import ec.edu.ups.sistemabiblioteca.DAO.AutorDAOMemoria;
import ec.edu.ups.sistemabiblioteca.models.Autor;
import ec.edu.ups.sistemabiblioteca.view.autor.ActualizarAutor;
import ec.edu.ups.sistemabiblioteca.view.autor.BorrarAutor;
import ec.edu.ups.sistemabiblioteca.view.autor.BuscarAutor;
import ec.edu.ups.sistemabiblioteca.view.autor.CrearAutor;
import ec.edu.ups.sistemabiblioteca.view.autor.ListarAutor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;
import javax.swing.JOptionPane;

public class AutorController {
    
    //Dao
    private AutorDAOMemoria autorDAO; 
    //Autores
    private CrearAutor crearAutor;
    private BorrarAutor borrarAutor;
    private BuscarAutor buscarAutor;
    private ActualizarAutor actualizarAutor;
    private ListarAutor listarAutor;

    public AutorController(AutorDAOMemoria autorDAO, CrearAutor crearAutor, BorrarAutor borrarAutor, BuscarAutor buscarAutor, ActualizarAutor actualizarAutor, ListarAutor listarAutor) {
        this.autorDAO = autorDAO;
        this.crearAutor = crearAutor;
        this.borrarAutor = borrarAutor;
        this.buscarAutor = buscarAutor;
        this.actualizarAutor = actualizarAutor;
        this.listarAutor = listarAutor;
        configurarEventosAgregarAutor();
        configurarEventosBuscarAutor();
        configurarEventosActualizarAutor();
        configurarEventosEliminarAutor();
        configurarEventosListarAutor();
    }



    
    //Agregar autor
    public void agregarAutor() {
        int respuesta = JOptionPane.showConfirmDialog(crearAutor, "¿Quieres crear un nuevo autor?", "Confirmar", JOptionPane.YES_NO_OPTION);
        if (respuesta == 0) {
            try {
                String cedula = crearAutor.getjTextFieldCACedula().getText();
                String nombre = crearAutor.getjTextFieldCANombre().getText();
                String apellido = crearAutor.getjTextFieldCAApellido().getText();
                String telefono = crearAutor.getjTextFieldCATelefono().getText();
                Date fechaNacimiento = Date.valueOf(crearAutor.getjTextFieldCAFecha().getText());
                String nacionalidad = crearAutor.getjTextFieldCANacionalidad().getText();
                String generoLiterario = crearAutor.getjTextFieldCAGenero().getText();
                String bibliografia = crearAutor.getjTextFieldCABibliografia().getText();
                Autor autor = new Autor(nacionalidad, generoLiterario, bibliografia, cedula, nombre, apellido, telefono, fechaNacimiento);
                
                autorDAO.agregar(autor);
                crearAutor.mostrarInformacion1("Autor creado exitosamente :)");
                
                crearAutor.getjTextFieldCANombre().setText("");
                crearAutor.getjTextFieldCAApellido().setText("");
                crearAutor.getjTextFieldCANacionalidad().setText("");
                crearAutor.getjTextFieldCATelefono().setText("");
                crearAutor.getjTextFieldCAGenero().setText("");
                crearAutor.getjTextFieldCAFecha().setText("");
                crearAutor.getjTextFieldCABibliografia().setText("");
                
            } catch (IllegalArgumentException e) {
                //Por si el formato no es año-mes-disa
                crearAutor.mostrarInformacion("Error: El formato de fecha debe ser AAAA-MM-DD.");
            }
        } else {
            crearAutor.mostrarInformacion1("Accion cancelada :(");
        }
    }
    
    

    public void buscarEliminarAutor() {
        String cedulaBuscar = borrarAutor.getjTextFieldEACedula().getText();
        Autor autor = autorDAO.buscar(cedulaBuscar);

        if (autor != null) {
            borrarAutor.getjTextFieldEANombre().setText(autor.getNombre());
            borrarAutor.getjTextFieldEAApellido().setText(autor.getApellido());
            borrarAutor.getjTextFieldEANacionalidad().setText(autor.getNacionalidad());
            borrarAutor.getjTextFieldEATelefono().setText(autor.getTelefono());
            borrarAutor.getjTextFieldEAGenero().setText(autor.getGeneroLiterario());
            borrarAutor.getjTextFieldEAFecha().setText(String.valueOf(autor.getFechaNacimiento()));
            borrarAutor.getjTextFieldEABibliografia().setText(autor.getBibliografia());
        } else {
            borrarAutor.getjTextFieldEANombre().setText("");
            borrarAutor.getjTextFieldEAApellido().setText("");
            borrarAutor.getjTextFieldEANacionalidad().setText("");
            borrarAutor.getjTextFieldEATelefono().setText("");
            borrarAutor.getjTextFieldEAGenero().setText("");
            borrarAutor.getjTextFieldEAFecha().setText("");
            borrarAutor.getjTextFieldEABibliografia().setText("");
            borrarAutor.mostrarInformacion( "No se encontro el autor (autor no existe)");
        }
    }

    public void eliminarAutor() {
        String cedulaEliminar = borrarAutor.getjTextFieldEACedula().getText();
        Autor autor = autorDAO.buscar(cedulaEliminar);
        if (autor != null) {
            int respuesta = JOptionPane.showConfirmDialog(borrarAutor, "¿Quieres eliminar este autor: " + autor.getNombre() + " ?", "Confirmar", JOptionPane.YES_NO_OPTION);
            if (respuesta == 0) {
                autorDAO.eliminar(cedulaEliminar);
                borrarAutor.mostrarInformacion1("Autor eliminado con exito :)");

                borrarAutor.getjTextFieldEACedula().setText("");
            } else {
                borrarAutor.mostrarInformacion1("Accion cancelada :(");
            }
        } else {
            borrarAutor.mostrarInformacion("No se encontro el autor (cedula no existe)");
        }
    }

    public void buscarAutor() {
        String cedulaBuscar = buscarAutor.getjTextFieldBACedula().getText();
        Autor autor = autorDAO.buscar(cedulaBuscar);

        if (autor != null) {
            buscarAutor.getjTextFieldBANombre().setText(autor.getNombre());
            buscarAutor.getjTextFieldBAApellido().setText(autor.getApellido());
            buscarAutor.getjTextFieldBANacionalidad().setText(autor.getNacionalidad());
            buscarAutor.getjTextFieldBATelefono().setText(autor.getTelefono());
            buscarAutor.getjTextFieldBAGenero().setText(autor.getGeneroLiterario());
            buscarAutor.getjTextFieldBAFecha().setText(String.valueOf(autor.getFechaNacimiento()));
            buscarAutor.getjTextFieldBABibliografia().setText(autor.getBibliografia());
        } else {
            buscarAutor.getjTextFieldBANombre().setText("");
            buscarAutor.getjTextFieldBAApellido().setText("");
            buscarAutor.getjTextFieldBANacionalidad().setText("");
            buscarAutor.getjTextFieldBATelefono().setText("");
            buscarAutor.getjTextFieldBAGenero().setText("");
            buscarAutor.getjTextFieldBAFecha().setText("");
            buscarAutor.getjTextFieldBABibliografia().setText("");
            buscarAutor.mostrarInformacion("No se encontro el autor (autor no existe)");
        }
    }

    public void buscarActualizarAutor() {
        String cedulaBuscar = actualizarAutor.getjTextFieldActACedula().getText();
        Autor autor = autorDAO.buscar(cedulaBuscar);

        if (autor != null) {
            actualizarAutor.getjTextFieldActANombre().setText(autor.getNombre());
            actualizarAutor.getjTextFieldActAApellido().setText(autor.getApellido());
            actualizarAutor.getjTextFieldActANacionalidad().setText(autor.getNacionalidad());
            actualizarAutor.getjTextFieldActATelefono().setText(autor.getTelefono());
            actualizarAutor.getjTextFieldActAGenero().setText(autor.getGeneroLiterario());
            actualizarAutor.getjTextFieldActAFecha().setText(String.valueOf(autor.getFechaNacimiento()));
            actualizarAutor.getjTextFieldActABibliografia().setText(autor.getBibliografia());
        } else {
            actualizarAutor.getjTextFieldActANombre().setText("");
            actualizarAutor.getjTextFieldActAApellido().setText("");
            actualizarAutor.getjTextFieldActANacionalidad().setText("");
            actualizarAutor.getjTextFieldActATelefono().setText("");
            actualizarAutor.getjTextFieldActAGenero().setText("");
            actualizarAutor.getjTextFieldActAFecha().setText("");
            actualizarAutor.getjTextFieldActABibliografia().setText("");
            buscarAutor.mostrarInformacion( "No se encontro el autor (autor no existe)");
        }
    }

    public void actualizarAutor() {
        String cedulaBuscar = actualizarAutor.getjTextFieldActACedula().getText();
        Autor autorExt = autorDAO.buscar(cedulaBuscar);

        if (autorExt != null) {
            int respuesta = JOptionPane.showConfirmDialog(actualizarAutor, "¿Quieres actualizar este autor: " + autorExt.getNombre() + " ?", "Confirmar", JOptionPane.YES_NO_OPTION);
            if (respuesta == 0) {
                String nuevoNombre = actualizarAutor.getjTextFieldActANombre().getText();
                String nuevoApellido = actualizarAutor.getjTextFieldActAApellido().getText();
                String nuevoNacionalidad = actualizarAutor.getjTextFieldActANacionalidad().getText();
                String nuevoTelefono = actualizarAutor.getjTextFieldActATelefono().getText();
                String nuevoGenero = actualizarAutor.getjTextFieldActAGenero().getText();
                Date nuevoFechaN = Date.valueOf(actualizarAutor.getjTextFieldActAFecha().getText());
                String nuevoBlibliografia = actualizarAutor.getjTextFieldActABibliografia().getText();
                Autor autorAct = new Autor(nuevoNacionalidad, nuevoGenero, nuevoBlibliografia, cedulaBuscar, nuevoNombre, nuevoApellido, nuevoTelefono, nuevoFechaN);
                autorDAO.actualizar(autorAct);

                actualizarAutor.mostrarInformacion1( "Autor actualizado correctamente :)");

                actualizarAutor.getjTextFieldActACedula().setText("");
                actualizarAutor.getjTextFieldActANombre().setText("");
                actualizarAutor.getjTextFieldActAApellido().setText("");
                actualizarAutor.getjTextFieldActANacionalidad().setText("");
                actualizarAutor.getjTextFieldActATelefono().setText("");
                actualizarAutor.getjTextFieldActAGenero().setText("");
                actualizarAutor.getjTextFieldActAFecha().setText("");
                actualizarAutor.getjTextFieldActABibliografia().setText("");
            } else {
                actualizarAutor.mostrarInformacion1( "Actualizacion candelada");
            }
        } else {
            actualizarAutor.mostrarInformacion1("No se encontro el autor (cedula no existe)");
        }
    }

    public void listarAutores() {
        List<Autor> lista = autorDAO.listar();
        listarAutor.cargarDatos(lista);
    }

    public void mostrarContadorAutores() {

        int total = autorDAO.contar();

        listarAutor.getTxtContadordeAutores().setText(String.valueOf(total));
    }

    public void configurarEventosAgregarAutor() {
        crearAutor.getjButtonCACrear().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                agregarAutor();
            }
        });
    }

    public void configurarEventosBuscarAutor() {
        buscarAutor.getjButtonBACedula().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                buscarAutor();
            }
        });
    }

    public void configurarEventosActualizarAutor() {
        actualizarAutor.getjButtonActABCedula().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                buscarActualizarAutor();
            }
        });
        actualizarAutor.getjButtonActAActualizar().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                actualizarAutor();
            }
        });
    }

    public void configurarEventosEliminarAutor() {
        borrarAutor.getjButtonEABCedula().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                buscarEliminarAutor();
            }
        });
        borrarAutor.getjButtonEAEliminar().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                eliminarAutor();
            }
        });
    }

    public void configurarEventosListarAutor() {

        listarAutor.getBtnMostrarListaAutores().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                listarAutores();
                mostrarContadorAutores();
            }
        });
    }
    
    
/*
    public void cambiarIdioma(Locale locale){
        ResourceBundle bundle = new ResourceBundle("ec.edu.ups.sistemabiblioteca.i18n", locale);
        
        
    }
    */
    
    
}
