
package ec.edu.ups.sistemabiblioteca.models;

import java.util.Date;

public class Bibliotecario extends Persona {
    
    private String codigo;
    private String turno;
    private String cargo;

    public Bibliotecario() {
    }

    public Bibliotecario(String codigo, String turno, String cargo, String cedula, String nombre, String apellido, String telefono, Date fechaNacimiento) {
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

    public String getTurno() {
        return turno;
    }

    public void setTurno(String turno) {
        this.turno = turno;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }
    
}
