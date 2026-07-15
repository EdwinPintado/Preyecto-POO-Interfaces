/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.ups.sistemabiblioteca.DAOArchivo;

import ec.edu.ups.sistemabiblioteca.DAO.AutorDAO;
import ec.edu.ups.sistemabiblioteca.DAO.UsuarioDAO;
import ec.edu.ups.sistemabiblioteca.DAOMemoria.UsuarioDAOMemoria;
import ec.edu.ups.sistemabiblioteca.models.Usuario;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author kevin
 */
public class UsuarioDAOArchivo implements UsuarioDAO {

    private static final int TAM_CEDULA = 10;
    private static final int TAM_NOMBRE = 50;
    private static final int TAM_APELLIDO = 50;
    private static final int TAM_TELEFONO = 15;
    private static final int TAM_CORREO = 50;
    private static final int TAM_DIRECCION = 100;

    private static final int TAM_REGISTRO= (TAM_CEDULA * 2)+ (TAM_NOMBRE * 2)+ (TAM_APELLIDO * 2)+ (TAM_TELEFONO * 2)+ (TAM_CORREO * 2)+ (TAM_DIRECCION * 2)
            + 8 + 1;

    private String ruta = "Archivos/usuarios.ups";

    public UsuarioDAOArchivo() {
    }

    private void escribirTexto(RandomAccessFile archivo, String texto, int longitud) throws IOException {

        StringBuilder sb = new StringBuilder(texto == null ? "" : texto);

        sb.setLength(longitud);

        archivo.writeChars(sb.toString());

    }

    private String leerTexto(RandomAccessFile archivo, int longitud) throws IOException {

        char[] caracteres = new char[longitud];

        for (int i = 0; i < longitud; i++) {

            caracteres[i] = archivo.readChar();

        }

        return new String(caracteres).trim();

    }

    private void escribirUsuario(RandomAccessFile archivo, Usuario usuario) throws IOException {

        escribirTexto(archivo, usuario.getCedula(), TAM_CEDULA);
        escribirTexto(archivo, usuario.getNombre(), TAM_NOMBRE);
        escribirTexto(archivo, usuario.getApellido(), TAM_APELLIDO);
        escribirTexto(archivo, usuario.getTelefono(), TAM_TELEFONO);
        escribirTexto(archivo, usuario.getCorreoElectronico(), TAM_CORREO);
        escribirTexto(archivo, usuario.getDireccion(), TAM_DIRECCION);

        archivo.writeLong(
                usuario.getFechaNacimiento().getTime()
        );

        archivo.writeBoolean(true);

    }

    @Override
    public void agregar(Usuario usuario) {

        try (RandomAccessFile archivo = new RandomAccessFile(ruta, "rw")) {

            archivo.seek(archivo.length());

            escribirUsuario(archivo, usuario);

        } catch (IOException e) {

            System.out.println("Error al guardar usuario");

        }

    }

    @Override
    public Usuario buscar(String cedula) throws Exception {

        Usuario encontrado = null;

        try (RandomAccessFile archivo = new RandomAccessFile(ruta, "r")) {

            long cantidad = archivo.length() / TAM_REGISTRO;

            for (long i = 0; i < cantidad; i++) {

                archivo.seek(i * TAM_REGISTRO);

                String cedulaLeida = leerTexto(archivo, TAM_CEDULA);
                String nombre = leerTexto(archivo, TAM_NOMBRE);
                String apellido = leerTexto(archivo, TAM_APELLIDO);
                String telefono = leerTexto(archivo, TAM_TELEFONO);
                String correo = leerTexto(archivo, TAM_CORREO);
                String direccion = leerTexto(archivo, TAM_DIRECCION);

                Date fecha = new Date(
                        archivo.readLong()
                );

                boolean activo = archivo.readBoolean();

                if (activo && cedulaLeida.equals(cedula)) {

                    encontrado = new Usuario(
                            correo,
                            direccion,
                            cedulaLeida,
                            nombre,
                            apellido,
                            telefono,
                            fecha
                    );

                    break;

                }

            }

        }

        return encontrado;

    }

    @Override
    public void eliminar(String cedula) {

        try (RandomAccessFile archivo = new RandomAccessFile(ruta, "rw")) {

            long cantidad = archivo.length() / TAM_REGISTRO;

            for (long i = 0; i < cantidad; i++) {

                long posicion = i * TAM_REGISTRO;

                archivo.seek(posicion);

                String cedulaLeida = leerTexto(archivo, TAM_CEDULA);

                archivo.skipBytes(
                        (TAM_NOMBRE * 2)
                        + (TAM_APELLIDO * 2)
                        + (TAM_TELEFONO * 2)
                        + (TAM_CORREO * 2)
                        + (TAM_DIRECCION * 2)
                        + 8
                );

                boolean activo = archivo.readBoolean();

                if (activo && cedulaLeida.equals(cedula)) {

                    archivo.seek(
                            posicion
                            + (TAM_CEDULA * 2)
                            + (TAM_NOMBRE * 2)
                            + (TAM_APELLIDO * 2)
                            + (TAM_TELEFONO * 2)
                            + (TAM_CORREO * 2)
                            + (TAM_DIRECCION * 2)
                            + 8
                    );

                    archivo.writeBoolean(false);

                    break;

                }

            }

        } catch (IOException e) {

            System.out.println("Error al eliminar usuario");

        }

    }

    @Override
    public void actualizar(Usuario datos) {

        try (RandomAccessFile archivo = new RandomAccessFile(ruta, "rw")) {

            long cantidad = archivo.length() / TAM_REGISTRO;

            for (long i = 0; i < cantidad; i++) {

                long posicion = i * TAM_REGISTRO;

                archivo.seek(posicion);

                String cedulaLeida = leerTexto(archivo, TAM_CEDULA);

                if (cedulaLeida.equals(datos.getCedula())) {

                    archivo.seek(posicion);

                    escribirUsuario(archivo, datos);

                    break;

                }

            }

        } catch (IOException e) {

            System.out.println("Error al actualizar usuario");

        }

    }

    @Override
    public List<Usuario> listar() {

        List<Usuario> lista = new ArrayList<>();

        try (RandomAccessFile archivo = new RandomAccessFile(ruta, "r")) {

            long cantidad = archivo.length() / TAM_REGISTRO;

            for (long i = 0; i < cantidad; i++) {

                archivo.seek(i * TAM_REGISTRO);

                String cedula = leerTexto(archivo, TAM_CEDULA);
                String nombre = leerTexto(archivo, TAM_NOMBRE);
                String apellido = leerTexto(archivo, TAM_APELLIDO);
                String telefono = leerTexto(archivo, TAM_TELEFONO);
                String correo = leerTexto(archivo, TAM_CORREO);
                String direccion = leerTexto(archivo, TAM_DIRECCION);

                Date fecha = new Date(
                        archivo.readLong()
                );

                boolean activo = archivo.readBoolean();

                if (activo) {

                    lista.add(
                            new Usuario(
                                    correo,
                                    direccion,
                                    cedula,
                                    nombre,
                                    apellido,
                                    telefono,
                                    fecha
                            )
                    );

                }

            }

        } catch (IOException e) {

            System.out.println("Error al listar usuarios");

        }

        return lista;

    }

    @Override
    public int contar() {

        return listar().size();

    }

}
