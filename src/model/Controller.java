package model;

import java.util.Random;

public class Controller {

    private Equipo[] equipos;
    private Arbitro[] arbitros;

    private final int CANTIDAD_EQUIPOS = 4;
    private final int CANTIDAD_ARBITROS = 4;

    private int contadorEquipos = 0;

    /**
     * Constructor de la clase Controller para inicializar variables globales.
     *
     * @pre No se requieren precondiciones específicas.
     * @post Se crea una instancia de Controller con un arreglo de personas vacío.
     */
    public Controller() {
        equipos = new Equipo[CANTIDAD_EQUIPOS];
        arbitros = new Arbitro[CANTIDAD_ARBITROS];
    }

    public String fixture() {
        String fixture = "";
        Random random = new Random();
        int equipo1 = random.nextInt(CANTIDAD_EQUIPOS);
        int equipo2;
        do {
            equipo2 = random.nextInt(CANTIDAD_EQUIPOS);
        } while (equipo2 == equipo1);

        fixture += "Partido 1: " + equipos[equipo1].getNombreEquipo() + " vs " + equipos[equipo2].getNombreEquipo()
                + "\n";

        do {
            equipo1 = random.nextInt(CANTIDAD_EQUIPOS);
            equipo2 = random.nextInt(CANTIDAD_EQUIPOS);
        } while (equipo2 == equipo1);

        fixture += "Partido 2: " + equipos[equipo1].getNombreEquipo() + " vs " + equipos[equipo2].getNombreEquipo()
                + "\n";
        return fixture;
    }

    public void realizarPartido() {
        if (equipos[0] == null) {
            System.out.println("No hay equipos para realizar un partido.");
            return;
        }

        int pases = 0;
        Random random = new Random();
        JugadorHockey jugadorActual = equipos[0].getJugadores()[random.nextInt(6)];
        JugadorHockey jugadorSiguiente;
        int jugadoresParticipantesCount = 1;

        String partidoLog = "";

        while (pases < 5) {

            do {
                jugadorSiguiente = equipos[0].getJugadores()[random.nextInt(6)];
            } while (jugadorSiguiente == jugadorActual);

            partidoLog += "Jugador " + jugadorActual.getNombre() + " " + jugadorActual.pasar()
                    + jugadorSiguiente.getNombre() + "\n";

            Arbitro arbitro = arbitros[random.nextInt(arbitros.length)];
            partidoLog += arbitro.getNombre() + " " + arbitro.desplazarse();

            jugadorActual = jugadorSiguiente;
            pases++;

            jugadoresParticipantesCount++;
        }

        if (pases == 5 && jugadoresParticipantesCount >= 3) {
            partidoLog += "Jugador " + jugadorActual.getNombre() + jugadorActual.gol();
        }

        System.out.println(partidoLog);
    }

    public Equipo crearEquipo(String nombreEquipo) {
        return new Equipo(nombreEquipo);
    }

    public void agregarEquipo(Equipo equipo) {
        for (int i = 0; i < equipos.length; i++) {
            if (equipos[i] == null) {
                equipos[i] = equipo;
                System.out.println("Equipo agregado: " + equipo.getNombreEquipo());
                break;
            }
        }
    }

    public ArbitroPrincipal crearArbitro(String nombre, int edad) {
        return new ArbitroPrincipal(nombre, edad);
    }

    public void agregarArbitroPrincipal(ArbitroPrincipal arbitroPrincipal) {
        for (int i = 0; i < arbitros.length; i++) {
            if (arbitros[i] == null) {
                arbitros[i] = arbitroPrincipal;
                System.out.println("Árbitro principal agregado: " + arbitroPrincipal.getNombre());
                break;
            }
        }
    }

    public JuezDeLinea crearJuezDeLinea(String nombre, int edad) {
        return new JuezDeLinea(nombre, edad);
    }

    public void agregarJuezDeLinea(JuezDeLinea juezDeLinea) {
        for (int i = 0; i < arbitros.length; i++) {
            if (arbitros[i] == null) {
                arbitros[i] = juezDeLinea;
                System.out.println("Juez de línea agregado: " + juezDeLinea.getNombre());
                break;
            }
        }
    }

    public Equipo searchEquipo(String nombreEquipo) {
        for (Equipo equipo : equipos) {
            if (equipo != null && equipo.getNombreEquipo().equalsIgnoreCase(nombreEquipo)) {
                return equipo;
            }
        }
        return null;
    }

    public void agregarYcrearJugador(Equipo equipo, String nombre, int edad, Posicion posicion) {
        equipo.agregarJugador(equipo.crearJugador(nombre, edad, posicion));
    }

    public void precaragar() {
        agregarEquipo(crearEquipo("Chicago Blackhawks"));
        agregarEquipo(crearEquipo("Colorado Avalanche"));
        agregarEquipo(crearEquipo("Dallas Stars"));
        agregarEquipo(crearEquipo("Minnesota Wild"));

        Equipo chicago = searchEquipo("Chicago Blackhawks");
        agregarYcrearJugador(chicago, "Jonathan Toews", 19, Posicion.PORTERO);
        agregarYcrearJugador(chicago, "Patrick Kane", 25, Posicion.DEFENSA);
        agregarYcrearJugador(chicago, "Duncan Keith", 28, Posicion.DEFENSA);
        agregarYcrearJugador(chicago, "Brandon Saad", 20, Posicion.ALA);
        agregarYcrearJugador(chicago, "Dylan Strome", 18, Posicion.CENTRO);
        agregarYcrearJugador(chicago, "Alex DeBrincat", 22, Posicion.ALA);

        Equipo colorado = searchEquipo("Colorado Avalanche");
        agregarYcrearJugador(colorado, "Nathan MacKinnon", 29, Posicion.PORTERO);
        agregarYcrearJugador(colorado, "Gabriel Landeskog", 22, Posicion.DEFENSA);
        agregarYcrearJugador(colorado, "Cale Makar", 18, Posicion.DEFENSA);
        agregarYcrearJugador(colorado, "Mikko Rantanen", 26, Posicion.ALA);
        agregarYcrearJugador(colorado, "Nazem Kadri", 31, Posicion.CENTRO);
        agregarYcrearJugador(colorado, "Andre Burakovsky", 25, Posicion.ALA);

        Equipo dallas = searchEquipo("Dallas Stars");
        agregarYcrearJugador(dallas, "Jamie Benn", 19, Posicion.PORTERO);
        agregarYcrearJugador(dallas, "John Klingberg", 30, Posicion.DEFENSA);
        agregarYcrearJugador(dallas, "Esa Lindell", 23, Posicion.DEFENSA);
        agregarYcrearJugador(dallas, "Tyler Seguin", 29, Posicion.ALA);
        agregarYcrearJugador(dallas, "Roope Hintz", 24, Posicion.CENTRO);
        agregarYcrearJugador(dallas, "Joe Pavelski", 26, Posicion.ALA);

        Equipo minnesota = searchEquipo("Minnesota Wild");
        agregarYcrearJugador(minnesota, "Zach Parise", 21, Posicion.PORTERO);
        agregarYcrearJugador(minnesota, "Ryan Suter", 20, Posicion.DEFENSA);
        agregarYcrearJugador(minnesota, "Jonas Brodin", 25, Posicion.DEFENSA);
        agregarYcrearJugador(minnesota, "Kevin Fiala", 22, Posicion.ALA);
        agregarYcrearJugador(minnesota, "Joel Eriksson Ek", 24, Posicion.CENTRO);
        agregarYcrearJugador(minnesota, "Mats Zuccarello", 36, Posicion.ALA);

        agregarArbitroPrincipal(crearArbitro("Nahuel Morales", 25));
        agregarArbitroPrincipal(crearArbitro("Agostina Bustos", 24));
        agregarJuezDeLinea(crearJuezDeLinea("Amíra Montes", 27));
        agregarJuezDeLinea(crearJuezDeLinea("Saul Tevez", 23));
    }
}