
package ec.edu.ups.sistemabiblioteca.models;

import java.util.Date;

public class Libro {
    
    private String isbn;
    private String titulo;
    private String editorial;
    private Date anioPublicacion;
    private boolean disponible;
    
    private Autor autor;
    public Libro() {
    }

    public Libro(String isbn, String titulo, String editorial, Date anioPublicacion, Autor autor) {
        this.isbn = isbn;
        this.titulo = titulo;
        this.editorial = editorial;
        this.anioPublicacion = anioPublicacion;
        this.autor= autor;
        this.disponible = true;
    }

    public Autor getAutor() {
        return autor;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }
    
    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getEditorial() {
        return editorial;
    }

    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }

    public Date getAnioPublicacion() {
        return anioPublicacion;
    }

    public void setAnioPublicacion(Date anioPublicacion) {
        this.anioPublicacion = anioPublicacion;
    }

    public boolean isDisponible() {
        return disponible;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }
    
    
}
