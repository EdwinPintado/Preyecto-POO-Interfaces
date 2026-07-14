
package ec.edu.ups.sistemabiblioteca.models;

import java.util.Date;

public class Devolucion {
    
    private Prestamo prestamo; 
    private Date fechaDevolucion;

    public Devolucion() {
    }

    public Devolucion(Prestamo prestamo, Date fechaDevolucion) {
        this.prestamo = prestamo;
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


    
}
