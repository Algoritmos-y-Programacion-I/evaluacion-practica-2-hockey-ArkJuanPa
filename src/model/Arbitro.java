package model;

public class Arbitro extends Persona implements IDesplazarseEnPistaSinPalo {
    public Arbitro(String nombre, int edad) {
        super(nombre, edad);
    }

    public String desplazarse() {
        return " " + nombre + " se desplaza en la pista como árbitro.";
    }
}
