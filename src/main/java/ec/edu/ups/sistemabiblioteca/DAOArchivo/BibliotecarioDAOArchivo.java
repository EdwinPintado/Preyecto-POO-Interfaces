package ec.edu.ups.sistemabiblioteca.DAOArchivo;

import ec.edu.ups.sistemabiblioteca.DAO.BibliotecarioDAO;
import ec.edu.ups.sistemabiblioteca.Exceptions.BibliotecarioNoExiste;
import ec.edu.ups.sistemabiblioteca.enums.Cargo;
import ec.edu.ups.sistemabiblioteca.enums.Turno;
import ec.edu.ups.sistemabiblioteca.models.Bibliotecario;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class BibliotecarioDAOArchivo implements BibliotecarioDAO {

    private static final int TAM_CODIGO = 10;
    private static final int TAM_TURNO = 20;
    private static final int TAM_CARGO = 30;
    private static final int TAM_CEDULA = 10;
    private static final int TAM_NOMBRE = 50;
    private static final int TAM_APELLIDO = 50;
    private static final int TAM_TELEFONO = 15;

    private static final int TAM_REGISTRO
            = (TAM_CODIGO * 2)
            + (TAM_TURNO * 2)
            + (TAM_CARGO * 2)
            + (TAM_CEDULA * 2)
            + (TAM_NOMBRE * 2)
            + (TAM_APELLIDO * 2)
            + (TAM_TELEFONO * 2)
            + 8 + 1;

    private String ruta = "Archivos/bibliotecarios.ups";

    private void escribirTexto(RandomAccessFile archivo, String texto, int longitud)
            throws IOException {

        StringBuilder sb = new StringBuilder(texto == null ? "" : texto);

        sb.setLength(longitud);

        archivo.writeChars(sb.toString());
    }

    private String leerTexto(RandomAccessFile archivo, int longitud)throws IOException {

        char[] caracteres = new char[longitud];

        for (int i = 0; i < longitud; i++) {
            caracteres[i] = archivo.readChar();
        }
        return new String(caracteres).trim();
    }

    private void escribirBibliotecario(RandomAccessFile archivo,Bibliotecario b)throws IOException {

        escribirTexto(archivo, b.getCodigo(), TAM_CODIGO);

        escribirTexto(archivo, b.getTurno().name(), TAM_TURNO);

        escribirTexto(archivo, b.getCargo().name(), TAM_CARGO);

        escribirTexto(archivo, b.getCedula(), TAM_CEDULA);

        escribirTexto(archivo, b.getNombre(), TAM_NOMBRE);

        escribirTexto(archivo, b.getApellido(), TAM_APELLIDO);

        escribirTexto(archivo, b.getTelefono(), TAM_TELEFONO);

        archivo.writeLong(b.getFechaNacimiento().getTime());

        archivo.writeBoolean(true);
    }

    @Override
    public void agregar(Bibliotecario bibliotecario) {
        try (RandomAccessFile archivo= new RandomAccessFile(ruta, "rw")) {

            archivo.seek(archivo.length());

            escribirBibliotecario(
                    archivo,
                    bibliotecario
            );
        } catch (IOException e) {
            System.out.println("Error al guardar bibliotecario");
        }
    }

    @Override
    public Bibliotecario buscar(String cedula) throws BibliotecarioNoExiste {

        try (RandomAccessFile archivo = new RandomAccessFile(ruta, "r")) {

            long cantidad = archivo.length() / TAM_REGISTRO;

            for (long i = 0; i < cantidad; i++) {

                archivo.seek(i * TAM_REGISTRO);

                String codigo = leerTexto(archivo, TAM_CODIGO);
                Turno turno = Turno.valueOf(leerTexto(archivo, TAM_TURNO));
                Cargo cargo = Cargo.valueOf(leerTexto(archivo, TAM_CARGO));
                String cedulaLeida = leerTexto(archivo, TAM_CEDULA);
                String nombre = leerTexto(archivo, TAM_NOMBRE);
                String apellido = leerTexto(archivo, TAM_APELLIDO);
                String telefono = leerTexto(archivo, TAM_TELEFONO);

                Date fecha = new Date(archivo.readLong());

                boolean activo = archivo.readBoolean();

                if (activo && cedulaLeida.equals(cedula)) {

                    return new Bibliotecario(
                            codigo,
                            turno,
                            cargo,
                            cedulaLeida,
                            nombre,
                            apellido,
                            telefono,
                            fecha
                    );
                }
            }

        } catch (IOException e) {
            throw new BibliotecarioNoExiste("Error al leer el archivo de bibliotecarios.");
        }
        throw new BibliotecarioNoExiste("No existe un bibliotecario con la cédula: " + cedula);
    }

    @Override
    public void actualizar(Bibliotecario bibliotecario) {

        try (RandomAccessFile archivo = new RandomAccessFile(ruta, "rw")) {

            long cantidad = archivo.length() / TAM_REGISTRO;

            for (long i = 0; i < cantidad; i++) {

                long posicion = i * TAM_REGISTRO;

                archivo.seek(posicion);

                archivo.skipBytes(
                        TAM_CODIGO * 2
                        + TAM_TURNO * 2
                        + TAM_CARGO * 2
                );

                String cedulaLeida = leerTexto(archivo, TAM_CEDULA);

                if (cedulaLeida.equals(bibliotecario.getCedula())) {
                    archivo.seek(posicion);
                    escribirBibliotecario(
                            archivo,
                            bibliotecario
                    );
                    break;
                }
            }
        } catch (IOException e) {

            System.out.println("Error al actualizar bibliotecario");
        }
    }

    @Override
    public void eliminar(String cedula) {

        try (RandomAccessFile archivo = new RandomAccessFile(ruta, "rw")) {

            long cantidad = archivo.length() / TAM_REGISTRO;

            for (long i = 0; i < cantidad; i++) {

                long posicion = i * TAM_REGISTRO;

                archivo.seek(posicion);

                archivo.skipBytes(
                        TAM_CODIGO * 2
                        + TAM_TURNO * 2
                        + TAM_CARGO * 2
                );

                String cedulaLeida = leerTexto(archivo, TAM_CEDULA);

                archivo.skipBytes(
                        TAM_NOMBRE * 2
                        + TAM_APELLIDO * 2
                        + TAM_TELEFONO * 2
                        + 8);

                boolean activo = archivo.readBoolean();

                if (activo && cedulaLeida.equals(cedula)) {

                    archivo.seek(
                            posicion
                            + (TAM_CODIGO * 2)
                            + (TAM_TURNO * 2)
                            + (TAM_CARGO * 2)
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

            System.out.println("Error al eliminar bibliotecario");
        }
    }

    @Override
    public List<Bibliotecario> listar() {

        List<Bibliotecario> lista = new ArrayList<>();

        try (RandomAccessFile archivo = new RandomAccessFile(ruta, "r")) {

            long cantidad = archivo.length() / TAM_REGISTRO;

            for (long i = 0; i < cantidad; i++) {

                archivo.seek(i * TAM_REGISTRO);

                String codigo = leerTexto(archivo, TAM_CODIGO);

                Turno turno = Turno.valueOf(leerTexto(archivo, TAM_TURNO));

                Cargo cargo = Cargo.valueOf(leerTexto(archivo, TAM_CARGO));

                String cedula = leerTexto(archivo, TAM_CEDULA);

                String nombre = leerTexto(archivo, TAM_NOMBRE);

                String apellido = leerTexto(archivo, TAM_APELLIDO);

                String telefono = leerTexto(archivo, TAM_TELEFONO);

                Date fecha = new Date(archivo.readLong());

                boolean activo = archivo.readBoolean();

                if (activo) {
                    lista.add(new Bibliotecario(
                                    codigo,
                                    turno,
                                    cargo,
                                    cedula,
                                    nombre,
                                    apellido,
                                    telefono,
                                    fecha)
                    );
                }
            }
        } catch (IOException e) {

            System.out.println("Error al listar bibliotecarios");
        }
        return lista;
    }

    @Override
    public int contar() {
        return listar().size();
    }
}
