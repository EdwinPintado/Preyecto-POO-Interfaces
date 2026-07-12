
package ec.edu.ups.sistemabiblioteca.models;

import java.util.Date;

public class Prestamo {
    
    private String codigoPrestamo;
    private Date fechaPrestamo;
    private Date fechaDevolucion;
    private Usuario usuario;
    private Libro libro;
    private Bibliotecario bibliotecario;

    public Prestamo() {
    }

    public Prestamo(String codigoPrestamo, Date fechaPrestamo, Date fechaDevolucion, Usuario usuario, Libro libro, Bibliotecario bibliotecario) {
        this.codigoPrestamo = codigoPrestamo;
        this.fechaPrestamo = fechaPrestamo;
        this.fechaDevolucion = fechaDevolucion;
        
        this.usuario = usuario;
        this.libro = libro;
        this.bibliotecario = bibliotecario;
    }

    public Bibliotecario getBibliotecario() {
        return bibliotecario;
    }

    public void setBibliotecario(Bibliotecario bibliotecario) {
        this.bibliotecario = bibliotecario;
    }
    
    public String getCodigoPrestamo() {
        return codigoPrestamo;
    }

    public void setCodigoPrestamo(String codigo) {
        this.codigoPrestamo = codigo;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Libro getLibro() {
        return libro;
    }

    public void setLibro(Libro libro) {
        this.libro = libro;
    }

    public Date getFechaPrestamo() {
        return fechaPrestamo;
    }

    public void setFechaPrestamo(Date fechaPrestamo) {
        this.fechaPrestamo = fechaPrestamo;
    }

    public Date getFechaDevolucion() {
        return fechaDevolucion;
    }

    public void setFechaDevolucion(Date fechaDevolucion) {
        this.fechaDevolucion = fechaDevolucion;
    }
    
}
