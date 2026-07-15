package ec.edu.ups.sistemabiblioteca.DAOArchivo;

import ec.edu.ups.sistemabiblioteca.DAO.PrestamoDAO;
import ec.edu.ups.sistemabiblioteca.DAO.UsuarioDAO;
import ec.edu.ups.sistemabiblioteca.DAO.LibroDAO;
import ec.edu.ups.sistemabiblioteca.DAO.BibliotecarioDAO;

import ec.edu.ups.sistemabiblioteca.models.Prestamo;
import ec.edu.ups.sistemabiblioteca.models.Usuario;
import ec.edu.ups.sistemabiblioteca.models.Libro;
import ec.edu.ups.sistemabiblioteca.models.Bibliotecario;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PrestamoDAOArchivo implements PrestamoDAO {

    private static final int TAM_CODIGO = 10;
    private static final int TAM_CEDULA = 10;
    private static final int TAM_ISBN = 15;
    private static final int TAM_CODIGO_BIBLIOTECARIO = 10;

    private static final int TAM_REGISTRO
            = (TAM_CODIGO * 2)
            + (TAM_CEDULA * 2)
            + (TAM_ISBN * 2)
            + (TAM_CODIGO_BIBLIOTECARIO * 2)
            + 8
            + 8
            + 1;

    private String ruta = "Archivos/prestamos.ups";

    private UsuarioDAO usuarioDAO;
    private LibroDAO libroDAO;
    private BibliotecarioDAO bibliotecarioDAO;

    public PrestamoDAOArchivo(
            UsuarioDAO usuarioDAO,
            LibroDAO libroDAO,
            BibliotecarioDAO bibliotecarioDAO
    ) {

        this.usuarioDAO = usuarioDAO;
        this.libroDAO = libroDAO;
        this.bibliotecarioDAO = bibliotecarioDAO;

    }

    private void escribirTexto(RandomAccessFile archivo,
            String texto,
            int longitud)
            throws IOException {

        StringBuilder sb
                = new StringBuilder(
                        texto == null ? "" : texto
                );

        sb.setLength(longitud);

        archivo.writeChars(
                sb.toString()
        );

    }

    private String leerTexto(RandomAccessFile archivo,
            int longitud)
            throws IOException {

        char[] caracteres
                = new char[longitud];

        for (int i = 0; i < longitud; i++) {

            caracteres[i]
                    = archivo.readChar();

        }

        return new String(caracteres).trim();

    }

    private void escribirPrestamo(RandomAccessFile archivo,
            Prestamo prestamo)
            throws IOException {

        escribirTexto(
                archivo,
                prestamo.getCodigoPrestamo(),
                TAM_CODIGO
        );

        escribirTexto(
                archivo,
                prestamo.getUsuario().getCedula(),
                TAM_CEDULA
        );

        escribirTexto(
                archivo,
                prestamo.getLibro().getIsbn(),
                TAM_ISBN
        );

        escribirTexto(
                archivo,
                prestamo.getBibliotecario().getCodigo(),
                TAM_CODIGO_BIBLIOTECARIO
        );

        archivo.writeLong(
                prestamo.getFechaPrestamo().getTime()
        );

        archivo.writeLong(
                prestamo.getFechaDevolucion().getTime()
        );

        archivo.writeBoolean(true);

    }

    @Override
    public void agregar(Prestamo prestamo) {

        try (RandomAccessFile archivo
                = new RandomAccessFile(ruta, "rw")) {

            archivo.seek(
                    archivo.length()
            );

            escribirPrestamo(
                    archivo,
                    prestamo
            );

        } catch (IOException e) {

            System.out.println(
                    "Error al guardar préstamo"
            );

        }

    }

    @Override
    public Prestamo buscar(String codigo) throws Exception {

        try (RandomAccessFile archivo
                = new RandomAccessFile(ruta, "r")) {

            long cantidad
                    = archivo.length() / TAM_REGISTRO;

            for (long i = 0; i < cantidad; i++) {

                archivo.seek(
                        i * TAM_REGISTRO
                );

                String codigoPrestamo
                        = leerTexto(
                                archivo,
                                TAM_CODIGO
                        );

                String cedula
                        = leerTexto(
                                archivo,
                                TAM_CEDULA
                        );

                String isbn
                        = leerTexto(
                                archivo,
                                TAM_ISBN
                        );

                String codigoBibliotecario
                        = leerTexto(
                                archivo,
                                TAM_CODIGO_BIBLIOTECARIO
                        );

                Date fechaPrestamo
                        = new Date(
                                archivo.readLong()
                        );

                Date fechaDevolucion
                        = new Date(
                                archivo.readLong()
                        );

                boolean activo
                        = archivo.readBoolean();

                if (activo
                        && codigoPrestamo.equals(codigo)) {

                    Usuario usuario
                            = usuarioDAO.buscar(
                                    cedula
                            );

                    Libro libro
                            = libroDAO.buscar(
                                    isbn
                            );

                    Bibliotecario bibliotecario
                            = bibliotecarioDAO.buscar(
                                    codigoBibliotecario
                            );

                    return new Prestamo(
                            codigoPrestamo,
                            fechaPrestamo,
                            fechaDevolucion,
                            usuario,
                            libro,
                            bibliotecario
                    );

                }

            }

        }

        return null;

    }

    @Override
    public void actualizar(Prestamo prestamo) {

        try (RandomAccessFile archivo
                = new RandomAccessFile(ruta, "rw")) {

            long cantidad
                    = archivo.length() / TAM_REGISTRO;

            for (long i = 0; i < cantidad; i++) {

                long posicion
                        = i * TAM_REGISTRO;

                archivo.seek(posicion);

                String codigo
                        = leerTexto(
                                archivo,
                                TAM_CODIGO
                        );

                if (codigo.equals(
                        prestamo.getCodigoPrestamo())) {

                    archivo.seek(posicion);

                    escribirPrestamo(
                            archivo,
                            prestamo
                    );

                    break;

                }

            }

        } catch (IOException e) {

            System.out.println(
                    "Error al actualizar préstamo"
            );

        }

    }

    @Override
    public void eliminar(String codigo) {

        try (RandomAccessFile archivo
                = new RandomAccessFile(ruta, "rw")) {

            long cantidad
                    = archivo.length() / TAM_REGISTRO;

            for (long i = 0; i < cantidad; i++) {

                long posicion
                        = i * TAM_REGISTRO;

                archivo.seek(posicion);

                String codigoLeido
                        = leerTexto(
                                archivo,
                                TAM_CODIGO
                        );

                if (codigoLeido.equals(codigo)) {

                    archivo.seek(
                            posicion
                            + (TAM_CODIGO * 2)
                            + (TAM_CEDULA * 2)
                            + (TAM_ISBN * 2)
                            + (TAM_CODIGO_BIBLIOTECARIO * 2)
                            + 16
                    );

                    archivo.writeBoolean(false);

                    break;

                }

            }

        } catch (IOException e) {

            System.out.println(
                    "Error al eliminar préstamo"
            );

        }

    }

    @Override
    public List<Prestamo> listar() {

        List<Prestamo> lista
                = new ArrayList<>();

        try (RandomAccessFile archivo
                = new RandomAccessFile(ruta, "r")) {

            long cantidad
                    = archivo.length() / TAM_REGISTRO;

            for (long i = 0; i < cantidad; i++) {

                archivo.seek(
                        i * TAM_REGISTRO
                );

                String codigo
                        = leerTexto(
                                archivo,
                                TAM_CODIGO
                        );

                String cedula
                        = leerTexto(
                                archivo,
                                TAM_CEDULA
                        );

                String isbn
                        = leerTexto(
                                archivo,
                                TAM_ISBN
                        );

                String codigoBibliotecario
                        = leerTexto(
                                archivo,
                                TAM_CODIGO_BIBLIOTECARIO
                        );

                Date fechaPrestamo
                        = new Date(
                                archivo.readLong()
                        );

                Date fechaDevolucion
                        = new Date(
                                archivo.readLong()
                        );

                boolean activo
                        = archivo.readBoolean();

                if (activo) {

                    Usuario usuario
                            = usuarioDAO.buscar(
                                    cedula
                            );

                    Libro libro
                            = libroDAO.buscar(
                                    isbn
                            );

                    Bibliotecario bibliotecario
                            = bibliotecarioDAO.buscar(
                                    codigoBibliotecario
                            );

                    lista.add(
                            new Prestamo(
                                    codigo,
                                    fechaPrestamo,
                                    fechaDevolucion,
                                    usuario,
                                    libro,
                                    bibliotecario
                            )
                    );

                }

            }

        } catch (Exception e) {

            System.out.println(
                    "Error al listar préstamos"
            );

        }

        return lista;

    }

    @Override
    public int contar() {

        return listar().size();

    }

}
