
package ec.edu.ups.sistemabiblioteca.enums;

public enum Nacionalidades {
    
    ECUATORIANA,
    COLOMBIANA,
    PERUANA,
    VENEZOLANA,
    ARGENTINA,
    CHILENA,
    BOLIVIANA,
    BRASILENA,
    URUGUAYA,
    PARAGUAYA,
    MEXICANA,
    ESTADOUNIDENSE,
    CANADIENSE,
    ESPANOLA,
    FRANCESA,
    ITALIANA,
    ALEMANA,
    PORTUGUESA,
    CHINA,
    JAPONESA;

    @Override
    public String toString() {
        return name()
                .replace("_", " ");
    }
}
