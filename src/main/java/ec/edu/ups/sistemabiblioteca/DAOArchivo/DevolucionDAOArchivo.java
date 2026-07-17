package ec.edu.ups.sistemabiblioteca.DAOArchivo;

import ec.edu.ups.sistemabiblioteca.DAO.DevolucionDAO;
import ec.edu.ups.sistemabiblioteca.DAO.PrestamoDAO;
import ec.edu.ups.sistemabiblioteca.Exceptions.DevolucionNoEncontradaException;
import ec.edu.ups.sistemabiblioteca.models.*;
import ec.edu.ups.sistemabiblioteca.Exceptions.PrestamoNoEncontrado;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DevolucionDAOArchivo implements DevolucionDAO {

    private static final int TAM_CODIGO_PRESTAMO = 10;
    private static final int TAM_CEDULA = 10;
    private static final int TAM_CODIGO_LIBRO = 10;
    private static final int TAM_CODIGO_BIBLIOTECARIO = 10;

    private static final int TAM_REGISTRO
            = (TAM_CODIGO_PRESTAMO * 2)
            + (TAM_CEDULA * 2)
            + (TAM_CODIGO_LIBRO * 2)
            + (TAM_CODIGO_BIBLIOTECARIO * 2)
            + 8
            + 8
            + 1;

    private PrestamoDAO prestamoDAO;

    public DevolucionDAOArchivo(PrestamoDAO prestamoDAO) {
        this.prestamoDAO = prestamoDAO;
    }
    
    private String ruta = "Archivos/devoluciones.ups";

    private void escribirTexto(RandomAccessFile archivo,String texto,int longitud) throws IOException {

        StringBuilder sb = new StringBuilder(texto == null ? "" : texto);

        sb.setLength(longitud);

        archivo.writeChars(sb.toString());
    }

    private String leerTexto(RandomAccessFile archivo,int longitud)throws IOException {

        char[] caracteres = new char[longitud];

        for (int i = 0; i < longitud; i++) {
            caracteres[i] = archivo.readChar();
        }

        return new String(caracteres).trim();
    }

    private void escribirDevolucion(RandomAccessFile archivo,Devolucion devolucion) throws IOException {

        Prestamo prestamo = devolucion.getPrestamo();

        escribirTexto(archivo,prestamo.getCodigoPrestamo(),TAM_CODIGO_PRESTAMO);

        escribirTexto(archivo,prestamo.getUsuario().getCedula(),TAM_CEDULA);

        escribirTexto(archivo,prestamo.getLibro().getIsbn(),TAM_CODIGO_LIBRO);

        escribirTexto(archivo,prestamo.getBibliotecario().getCodigo(),TAM_CODIGO_BIBLIOTECARIO);

        archivo.writeLong(prestamo.getFechaPrestamo().getTime());

        archivo.writeLong(devolucion.getFechaDevolucion().getTime());

        archivo.writeBoolean(true);
    }

    @Override
    public void agregar(Devolucion devolucion) {

        try (RandomAccessFile archivo = new RandomAccessFile(ruta, "rw")) {

            archivo.seek(archivo.length());

            escribirDevolucion(archivo,devolucion);

        } catch (IOException e) {

            System.out.println("Error al guardar devolución");
        }
    }

    @Override
    public Devolucion buscar(String codigo) throws DevolucionNoEncontradaException {

        try (RandomAccessFile archivo = new RandomAccessFile(ruta, "r")) {

            long cantidad = archivo.length() / TAM_REGISTRO;

            for (long i = 0; i < cantidad; i++) {

                archivo.seek(i * TAM_REGISTRO);
                
                String codigoPrestamo = leerTexto(archivo, TAM_CODIGO_PRESTAMO);

                String cedula = leerTexto(archivo, TAM_CEDULA);

                String codigoLibro = leerTexto(archivo, TAM_CODIGO_LIBRO);

                String codigoBibliotecario = leerTexto(archivo, TAM_CODIGO_BIBLIOTECARIO);

                Date fechaPrestamo = new Date(archivo.readLong());

                Date fechaDevolucion = new Date(archivo.readLong());

                boolean activo = archivo.readBoolean();

                if (activo && codigoPrestamo.equals(codigo)) {
                    try {

                        Prestamo prestamo = prestamoDAO.buscar(codigoPrestamo);
                        return new Devolucion(prestamo, fechaDevolucion);

                    } catch (PrestamoNoEncontrado e) {
                        throw new DevolucionNoEncontradaException("No existe el préstamo " + codigoPrestamo);
                    }
                }
            }
        } catch (IOException e) {
            throw new DevolucionNoEncontradaException("no existe el archivo");
        }
        throw new DevolucionNoEncontradaException("No existe un bibliotecario con la cédula: " + codigo);
    }

    @Override
    public void eliminar(String codigo) {

        try (RandomAccessFile archivo = new RandomAccessFile(ruta, "rw")) {

            long cantidad = archivo.length() / TAM_REGISTRO;

            for (long i = 0; i < cantidad; i++) {

                long posicion = i * TAM_REGISTRO;

                archivo.seek(posicion);

                String codigoLeido = leerTexto(archivo,TAM_CODIGO_PRESTAMO );

                if (codigoLeido.equals(codigo)) {
                    
                    archivo.seek(
                            posicion
                            + (TAM_CODIGO_PRESTAMO * 2)
                            + (TAM_CEDULA * 2)
                            + (TAM_CODIGO_LIBRO * 2)
                            + (TAM_CODIGO_BIBLIOTECARIO * 2)
                            + 16
                    );
                    archivo.writeBoolean(false);
                    break;
                }
            }
        } catch (IOException e) {
            System.out.println("Error al eliminar devolución");
        }
    }

    @Override
    public List<Devolucion> listar() {

        List<Devolucion> lista = new ArrayList<>();

        try (RandomAccessFile archivo = new RandomAccessFile(ruta, "r")) {

            long cantidad = archivo.length() / TAM_REGISTRO;

            for (long i = 0; i < cantidad; i++) {

                archivo.seek(i * TAM_REGISTRO);

                String codigoPrestamo = leerTexto(archivo, TAM_CODIGO_PRESTAMO);

                archivo.skipBytes(
                        (TAM_CEDULA * 2)
                        + (TAM_CODIGO_LIBRO * 2)
                        + (TAM_CODIGO_BIBLIOTECARIO * 2)
                );

                archivo.skipBytes(8);

                Date fechaDevolucion = new Date(archivo.readLong());

                boolean activo = archivo.readBoolean();

                if (activo) {

                    try {

                        Prestamo prestamo = prestamoDAO.buscar(codigoPrestamo);

                        lista.add(new Devolucion(prestamo, fechaDevolucion));

                    } catch (PrestamoNoEncontrado e) {

                        System.out.println("No existe el préstamo " + codigoPrestamo);
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("Error al listar devoluciones");
        }
        return lista;
    }

    @Override
    public void actualizar(Devolucion devolucion) {
    }

    @Override
    public int contar() {
        return listar().size();
    }
}
