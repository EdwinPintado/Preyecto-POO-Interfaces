
package ec.edu.ups.sistemabiblioteca.models;

import java.util.Date;

public class Devolucion {
    
    private Prestamo prestamo; 
    private String isbnLibro;
    private Date fechaDevolucion;

    public Devolucion() {
    }

    public Devolucion(Prestamo prestamo, String isbnLibro, Date fechaDevolucion) {
        this.prestamo = prestamo;
        this.isbnLibro = isbnLibro;
        this.fechaDevolucion = fechaDevolucion;
    }
    public Prestamo getPrestamo() {
        return prestamo;
    }

    public void setPrestamo(Prestamo prestamo) {
        this.prestamo = prestamo;
    }

    public Date getFechaDevolucion() {
        return fechaDevolucion;
    }

    public void setFechaDevolucion(Date fechaDevolucion) {
        this.fechaDevolucion = fechaDevolucion;
    }

    public String getIsbnLibro() {
        return isbnLibro;
    }

    public void setIsbnLibro(String isbnLibro) {
        this.isbnLibro = isbnLibro;
    }
    
}
