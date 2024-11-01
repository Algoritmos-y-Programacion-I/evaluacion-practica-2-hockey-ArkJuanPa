package model;

public class Equipo {

    private final int CANTIDAD_JUGADORES = 6;

    protected String nombreEquipo;

    private JugadorHockey[] jugadores = new JugadorHockey[CANTIDAD_JUGADORES];

    public Equipo(String nombreEquipo) {
        this.nombreEquipo = nombreEquipo;
    }

    public String getNombreEquipo() {
        return nombreEquipo;
    }

    public JugadorHockey crearJugador(String nombre, int edad, Posicion posicion) {
        JugadorHockey jugador = new JugadorHockey(nombre, edad, posicion);
        return jugador;
    }

    public void agregarJugador(JugadorHockey jugador) {
        for (int i = 0; i < jugadores.length; i++) {
            if (jugadores[i] == null) {
                jugadores[i] = jugador;
                break;
            }
        }
    }

    public JugadorHockey[] getJugadores() {
        return jugadores;
    }
}