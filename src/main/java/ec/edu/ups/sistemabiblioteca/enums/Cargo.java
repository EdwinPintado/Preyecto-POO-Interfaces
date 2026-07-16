
package ec.edu.ups.sistemabiblioteca.enums;

public enum Cargo {
    
    SUPERVISOR, BIBLIOTECARIO, SECRETARIO, CONSERJE ;
    
    @Override
    public String toString() {
        return name()
                .replace("_", " ");
    }
}
