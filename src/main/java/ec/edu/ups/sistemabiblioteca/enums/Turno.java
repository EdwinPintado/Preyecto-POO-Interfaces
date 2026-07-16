
package ec.edu.ups.sistemabiblioteca.enums;

public enum Turno {
    DIURNO, 
    NOCTURNO, 
    MIXTO;
    
    @Override
    public String toString() {
        return name()
                .replace("_", " ");
    }
}
