package ec.edu.ups.sistemabiblioteca.DAOArchivo;

import ec.edu.ups.sistemabiblioteca.DAO.LibroDAO;
import ec.edu.ups.sistemabiblioteca.models.Autor;
import ec.edu.ups.sistemabiblioteca.models.Libro;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class LibroDAOArchivo implements LibroDAO {

    private static final int TAM_ISBN = 15;
    private static final int TAM_TITULO = 50;
    private static final int TAM_EDITORIAL = 40;
    private static final int TAM_CEDULA_AUTOR = 10;

    private static final int TAM_REGISTRO
            = (TAM_ISBN * 2)
            + (TAM_TITULO * 2)
            + (TAM_EDITORIAL * 2)
            + 8
            + (TAM_CEDULA_AUTOR * 2)
            + 1
            + 1;

    private String ruta = "Archivos/libros.ups";

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

    private void escribirLibro(RandomAccessFile archivo,
            Libro libro)
            throws IOException {

        escribirTexto(
                archivo,
                libro.getIsbn(),
                TAM_ISBN
        );

        escribirTexto(
                archivo,
                libro.getTitulo(),
                TAM_TITULO
        );

        escribirTexto(
                archivo,
                libro.getEditorial(),
                TAM_EDITORIAL
        );

        archivo.writeLong(
                libro.getAnioPublicacion().getTime()
        );

        escribirTexto(
                archivo,
                libro.getAutor().getCedula(),
                TAM_CEDULA_AUTOR
        );

        archivo.writeBoolean(
                libro.isDisponible()
        );

        archivo.writeBoolean(true);

    }

    @Override
    public void agregar(Libro libro) {

        try (RandomAccessFile archivo
                = new RandomAccessFile(ruta, "rw")) {

            archivo.seek(
                    archivo.length()
            );

            escribirLibro(
                    archivo,
                    libro
            );

        } catch (IOException e) {

            System.out.println(
                    "Error al guardar libro"
            );

        }

    }

    @Override
    public Libro buscar(String isbn) throws Exception {

        try (RandomAccessFile archivo
                = new RandomAccessFile(ruta, "r")) {

            long cantidad
                    = archivo.length()
                    / TAM_REGISTRO;

            for (long i = 0; i < cantidad; i++) {

                archivo.seek(
                        i * TAM_REGISTRO
                );

                String isbnLeido
                        = leerTexto(
                                archivo,
                                TAM_ISBN
                        );

                String titulo
                        = leerTexto(
                                archivo,
                                TAM_TITULO
                        );

                String editorial
                        = leerTexto(
                                archivo,
                                TAM_EDITORIAL
                        );

                Date anio
                        = new Date(
                                archivo.readLong()
                        );

                String cedulaAutor
                        = leerTexto(
                                archivo,
                                TAM_CEDULA_AUTOR
                        );

                boolean disponible
                        = archivo.readBoolean();

                boolean activo
                        = archivo.readBoolean();

                if (activo
                        && isbnLeido.equals(isbn)) {

                    return new Libro(
                            isbnLeido,
                            titulo,
                            editorial,
                            anio,
                            null
                    );

                }

            }

        }

        return null;

    }

    @Override
    public void actualizar(Libro libro) {

        try (RandomAccessFile archivo
                = new RandomAccessFile(ruta, "rw")) {

            long cantidad
                    = archivo.length()
                    / TAM_REGISTRO;

            for (long i = 0; i < cantidad; i++) {

                long posicion
                        = i * TAM_REGISTRO;

                archivo.seek(
                        posicion
                );

                String isbnLeido
                        = leerTexto(
                                archivo,
                                TAM_ISBN
                        );

                if (isbnLeido.equals(
                        libro.getIsbn())) {

                    archivo.seek(
                            posicion
                    );

                    escribirLibro(
                            archivo,
                            libro
                    );

                    break;

                }

            }

        } catch (IOException e) {

            System.out.println(
                    "Error al actualizar libro"
            );

        }

    }

    @Override
    public void eliminar(String isbn) {

        try (RandomAccessFile archivo
                = new RandomAccessFile(ruta, "rw")) {

            long cantidad
                    = archivo.length()
                    / TAM_REGISTRO;

            for (long i = 0; i < cantidad; i++) {

                long posicion
                        = i * TAM_REGISTRO;

                archivo.seek(
                        posicion
                );

                String isbnLeido
                        = leerTexto(
                                archivo,
                                TAM_ISBN
                        );

                if (isbnLeido.equals(isbn)) {

                    archivo.seek(
                            posicion
                            + (TAM_ISBN * 2)
                            + (TAM_TITULO * 2)
                            + (TAM_EDITORIAL * 2)
                            + 8
                            + (TAM_CEDULA_AUTOR * 2)
                            + 1
                    );

                    archivo.writeBoolean(false);

                    break;

                }

            }

        } catch (IOException e) {

            System.out.println(
                    "Error al eliminar libro"
            );

        }

    }

    @Override
    public List<Libro> listar() {

        List<Libro> lista
                = new ArrayList<>();

        try (RandomAccessFile archivo
                = new RandomAccessFile(ruta, "r")) {

            long cantidad
                    = archivo.length()
                    / TAM_REGISTRO;

            for (long i = 0; i < cantidad; i++) {

                archivo.seek(
                        i * TAM_REGISTRO
                );

                String isbn
                        = leerTexto(
                                archivo,
                                TAM_ISBN
                        );

                String titulo
                        = leerTexto(
                                archivo,
                                TAM_TITULO
                        );

                String editorial
                        = leerTexto(
                                archivo,
                                TAM_EDITORIAL
                        );

                Date anio
                        = new Date(
                                archivo.readLong()
                        );

                String cedulaAutor
                        = leerTexto(
                                archivo,
                                TAM_CEDULA_AUTOR
                        );

                boolean disponible
                        = archivo.readBoolean();

                boolean activo
                        = archivo.readBoolean();

                if (activo) {

                    Libro libro
                            = new Libro(
                                    isbn,
                                    titulo,
                                    editorial,
                                    anio,
                                    null
                            );

                    libro.setDisponible(
                            disponible
                    );

                    lista.add(libro);

                }

            }

        } catch (IOException e) {

            System.out.println(
                    "Error al listar libros"
            );

        }

        return lista;

    }

    @Override
    public int contar() {

        return listar().size();

    }

}
