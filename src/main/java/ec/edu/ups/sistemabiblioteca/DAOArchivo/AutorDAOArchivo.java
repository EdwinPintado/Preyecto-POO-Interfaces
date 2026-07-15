package ec.edu.ups.sistemabiblioteca.DAOArchivo;

import ec.edu.ups.sistemabiblioteca.DAO.AutorDAO;
import ec.edu.ups.sistemabiblioteca.Exceptions.AutorNoEncontradoException;
import ec.edu.ups.sistemabiblioteca.models.Autor;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AutorDAOArchivo implements AutorDAO {

    private static final int TAM_NACIONALIDAD = 30;
    private static final int TAM_GENERO = 30;
    private static final int TAM_BIBLIOGRAFIA = 100;
    private static final int TAM_CEDULA = 10;
    private static final int TAM_NOMBRE = 50;
    private static final int TAM_APELLIDO = 50;
    private static final int TAM_TELEFONO = 15;

    private static final int TAM_REGISTRO
            = (TAM_NACIONALIDAD * 2)
            + (TAM_GENERO * 2)
            + (TAM_BIBLIOGRAFIA * 2)
            + (TAM_CEDULA * 2)
            + (TAM_NOMBRE * 2)
            + (TAM_APELLIDO * 2)
            + (TAM_TELEFONO * 2)
            + 8 + 1;

    private String ruta;

    public AutorDAOArchivo() {
        this.ruta="Archivos/autores.ups";
    }

    public AutorDAOArchivo(String ruta) {
        this.ruta = ruta;
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

        archivo.writeChars(sb.toString());

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

    private void escribirAutor(RandomAccessFile archivo,
            Autor autor)
            throws IOException {

        escribirTexto(archivo,
                autor.getNacionalidad(),
                TAM_NACIONALIDAD);

        escribirTexto(archivo,
                autor.getGeneroLiterario(),
                TAM_GENERO);

        escribirTexto(archivo,
                autor.getBibliografia(),
                TAM_BIBLIOGRAFIA);

        escribirTexto(archivo,
                autor.getCedula(),
                TAM_CEDULA);

        escribirTexto(archivo,
                autor.getNombre(),
                TAM_NOMBRE);

        escribirTexto(archivo,
                autor.getApellido(),
                TAM_APELLIDO);

        escribirTexto(archivo,
                autor.getTelefono(),
                TAM_TELEFONO);

        archivo.writeLong(
                autor.getFechaNacimiento().getTime()
        );

        archivo.writeBoolean(true);

    }

    @Override
    public void agregar(Autor autor) {

        try (RandomAccessFile archivo
                = new RandomAccessFile(ruta, "rw")) {

            archivo.seek(archivo.length());

            escribirAutor(
                    archivo,
                    autor
            );

        } catch (IOException e) {

            System.out.println(
                    "Error al guardar autor"
            );

        }

    }

    @Override
    public Autor buscar(String cedula)
            throws AutorNoEncontradoException {

        try (RandomAccessFile archivo
                = new RandomAccessFile(ruta, "r")) {

            long cantidad
                    = archivo.length() / TAM_REGISTRO;

            for (long i = 0; i < cantidad; i++) {

                archivo.seek(
                        i * TAM_REGISTRO
                );

                String nacionalidad
                        = leerTexto(archivo, TAM_NACIONALIDAD);

                String genero
                        = leerTexto(archivo, TAM_GENERO);

                String bibliografia
                        = leerTexto(archivo, TAM_BIBLIOGRAFIA);

                String cedulaLeida
                        = leerTexto(archivo, TAM_CEDULA);

                String nombre
                        = leerTexto(archivo, TAM_NOMBRE);

                String apellido
                        = leerTexto(archivo, TAM_APELLIDO);

                String telefono
                        = leerTexto(archivo, TAM_TELEFONO);

                Date fecha
                        = new Date(
                                archivo.readLong()
                        );

                boolean activo
                        = archivo.readBoolean();

                if (activo
                        && cedulaLeida.equals(cedula)) {

                    return new Autor(
                            nacionalidad,
                            genero,
                            bibliografia,
                            cedulaLeida,
                            nombre,
                            apellido,
                            telefono, (java.sql.Date) fecha);

                }

            }

        } catch (IOException e) {

            System.out.println(
                    "Error al buscar autor"
            );

        }

        throw new AutorNoEncontradoException(
                "Autor no encontrado"
        );

    }

    @Override
    public void actualizar(Autor autor) {

        try (RandomAccessFile archivo
                = new RandomAccessFile(ruta, "rw")) {

            long cantidad
                    = archivo.length() / TAM_REGISTRO;

            for (long i = 0; i < cantidad; i++) {

                long posicion
                        = i * TAM_REGISTRO;

                archivo.seek(posicion);

                archivo.skipBytes(
                        (TAM_NACIONALIDAD * 2)
                        + (TAM_GENERO * 2)
                        + (TAM_BIBLIOGRAFIA * 2)
                );

                String cedula
                        = leerTexto(
                                archivo,
                                TAM_CEDULA
                        );

                if (cedula.equals(
                        autor.getCedula())) {

                    archivo.seek(posicion);

                    escribirAutor(
                            archivo,
                            autor
                    );

                    break;

                }

            }

        } catch (IOException e) {

            System.out.println(
                    "Error al actualizar autor"
            );

        }

    }

    @Override
    public void eliminar(String cedula) {

        try (RandomAccessFile archivo
                = new RandomAccessFile(ruta, "rw")) {

            long cantidad
                    = archivo.length() / TAM_REGISTRO;

            for (long i = 0; i < cantidad; i++) {

                long posicion
                        = i * TAM_REGISTRO;

                archivo.seek(posicion);

                archivo.skipBytes(
                        (TAM_NACIONALIDAD * 2)
                        + (TAM_GENERO * 2)
                        + (TAM_BIBLIOGRAFIA * 2)
                );

                String cedulaLeida
                        = leerTexto(
                                archivo,
                                TAM_CEDULA
                        );

                archivo.skipBytes(
                        (TAM_NOMBRE * 2)
                        + (TAM_APELLIDO * 2)
                        + (TAM_TELEFONO * 2)
                        + 8
                );

                boolean activo
                        = archivo.readBoolean();

                if (activo
                        && cedulaLeida.equals(cedula)) {

                    archivo.seek(
                            posicion
                            + (TAM_NACIONALIDAD * 2)
                            + (TAM_GENERO * 2)
                            + (TAM_BIBLIOGRAFIA * 2)
                            + (TAM_CEDULA * 2)
                            + (TAM_NOMBRE * 2)
                            + (TAM_APELLIDO * 2)
                            + (TAM_TELEFONO * 2)
                            + 8
                    );

                    archivo.writeBoolean(false);

                    break;

                }

            }

        } catch (IOException e) {

            System.out.println(
                    "Error al eliminar autor"
            );

        }

    }

    @Override
    public List<Autor> listar() {

        List<Autor> lista
                = new ArrayList<>();

        try (RandomAccessFile archivo
                = new RandomAccessFile(ruta, "r")) {

            long cantidad
                    = archivo.length() / TAM_REGISTRO;

            for (long i = 0; i < cantidad; i++) {

                archivo.seek(
                        i * TAM_REGISTRO
                );

                String nacionalidad
                        = leerTexto(archivo, TAM_NACIONALIDAD);

                String genero
                        = leerTexto(archivo, TAM_GENERO);

                String bibliografia
                        = leerTexto(archivo, TAM_BIBLIOGRAFIA);

                String cedula
                        = leerTexto(archivo, TAM_CEDULA);

                String nombre
                        = leerTexto(archivo, TAM_NOMBRE);

                String apellido
                        = leerTexto(archivo, TAM_APELLIDO);

                String telefono
                        = leerTexto(archivo, TAM_TELEFONO);

                Date fecha
                        = new Date(
                                archivo.readLong()
                        );

                boolean activo
                        = archivo.readBoolean();

                if (activo) {

                    lista.add(
                            new Autor(
                                    nacionalidad,
                                    genero,
                                    bibliografia,
                                    cedula,
                                    nombre,
                                    apellido,
                                    telefono, (java.sql.Date) fecha)
                    );

                }

            }

        } catch (IOException e) {

            System.out.println(
                    "Error al listar autores"
            );

        }

        return lista;

    }

    @Override
    public int contar() {

        return listar().size();

    }

}
