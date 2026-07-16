
package ec.edu.ups.sistemabiblioteca.models;

import ec.edu.ups.sistemabiblioteca.enums.Cargo;
import ec.edu.ups.sistemabiblioteca.enums.Turno;
import java.util.Date;

public class Bibliotecario extends Persona {
    
    private String codigo;
    private Turno turno;
    private Cargo cargo;

    public Bibliotecario() {
    }

    public Bibliotecario(String codigo, Turno turno, Cargo cargo, String cedula, String nombre, String apellido, String telefono, Date fechaNacimiento) {
        super(cedula, nombre, apellido, telefono, fechaNacimiento);
        this.codigo = codigo;
        this.turno = turno;
        this.cargo = cargo;
    }
    
    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public Turno getTurno() {
        return turno;
    }

    public void setTurno(Turno turno) {
        this.turno = turno;
    }

    public Cargo getCargo() {
        return cargo;
    }

    public void setCargo(Cargo cargo) {
        this.cargo = cargo;
    }

}
