
package pokerApp.juego;

import estados.EstadoMano;
import pokerApp.figurasYCartas.Figura;
import pokerApp.usuarios.Jugador;
import java.util.ArrayList;
import java.util.List;
import pokerApp.Exceptions.UsuarioException;
import pokerApp.Sistemas.SistemaFiguras;
import pokerApp.figurasYCartas.Carta;
import pokerApp.figurasYCartas.TipoFigura;


public class Mano {
    private ArrayList<Figura> figurasJugadas;
    private float pozoApuestas;
    private int numeroMano;
    private int cantJugadores;
    private EstadoMano estadoMano;
    private Jugador jugadorGanador;
    private Figura figuraGanadora;
    private SistemaFiguras sistemaFiguras;
    private List<Jugador> jugadoresEnMano;
    private List<List<Carta>> cartasPorJugador;  // Cartas asignadas para cada jugador


    public Mano(ArrayList<Figura> figurasJugadas, int numeroMano) {
        this.figurasJugadas = figurasJugadas;
        this.pozoApuestas = 0;
        this.numeroMano = numeroMano;
        this.estadoMano=EstadoMano.ESPERANDO_APUESTA;
    }

// Constructor que recibe la lista de jugadoresEnMano y crea las listas necesarias
    public Mano(List<Jugador> jugadores) {
        this.jugadoresEnMano = jugadores;
        this.cartasPorJugador = new ArrayList<>();  // Inicializamos la lista de cartas para cada jugador
        this.sistemaFiguras = new SistemaFiguras();  // Inicializamos el sistema de figuras

        // Añadir listas vacías para cada jugador en cartasPorJugador
        for (int i = 0; i < jugadores.size(); i++) {
            cartasPorJugador.add(new ArrayList<>());
        }
    }
    
    public ArrayList<Figura> getFigurasJugadas() {
        return figurasJugadas;
    }

    public void setFigurasJugadas(ArrayList<Figura> figurasJugadas) {
        this.figurasJugadas = figurasJugadas;
    }

    public float getPozoApuestas() {
        return pozoApuestas;
    }

    public void incrementarPozoApuestas(float pozoApuestas) {
        this.pozoApuestas += pozoApuestas;
    }

    public int getNumeroMano() {
        return numeroMano;
    }

    public void setNumeroMano(int numeroMano) {
        this.numeroMano = numeroMano;
    }

    public int getCantJugadores() {
        return cantJugadores;
    }

    public void setCantJugadores(int cantJugadores) {
        this.cantJugadores = cantJugadores;
    }

    public EstadoMano getEstadoMano() {
        return estadoMano;
    }

    public void setEstadoMano(EstadoMano estadoMano) {
        this.estadoMano = estadoMano;
    }

    public Jugador getJugadorGanador() {
        return jugadorGanador;
    }

    public void setJugadorGanador(Jugador jugadorGanador) {
        this.jugadorGanador = jugadorGanador;
    }

    public Figura getFiguraGanadora() {
        return figuraGanadora;
    }

    public void setFiguraGanadora(Figura figuraGanadora) {
        this.figuraGanadora = figuraGanadora;
    }
    public int getNumeroManoActual() {
        return this.numeroMano;
    }
    
    
    public void realizarApuestas(Jugador j){
        
    }
    
    public void realizarApuesta(Jugador j){
        //me parece que tal vez en todo caso esta funcion deberia recibir el
        //monto para agregarlo al pozo
        
    }
    
    
    
    // Método para repartir las cartas (suponiendo que el mazo ha sido inicializado externamente)
    public void repartirCartas(List<Carta> mazo) {
        int cartasPorJugador = 5; // Ajustar según las reglas del juego
        for (int i = 0; i < jugadoresEnMano.size(); i++) {
            List<Carta> manoJugador = this.cartasPorJugador.get(i);  // Obtén la lista correspondiente al jugador
            for (int j = 0; j < cartasPorJugador; j++) {
                manoJugador.add(mazo.remove(0));  // Extrae las cartas del mazo para cada jugador
            }
        }
    }


    public Jugador determinarGanador() {
        Jugador ganador = null;
        TipoFigura mejorFigura = null;

        for (int i = 0; i < jugadoresEnMano.size(); i++) {
            Jugador jugador = jugadoresEnMano.get(i);
            List<Carta> cartas = cartasPorJugador.get(i);  // Cartas asignadas al jugador
            TipoFigura figura = sistemaFiguras.determinarFigura(cartas);

            // Utilizamos el método compararDosFiguras para comparar la figura actual con la mejor figura hasta ahora
            if (mejorFigura == null || sistemaFiguras.compararDosFiguras(figura, mejorFigura) == figura) {
                mejorFigura = figura;
                ganador = jugador;
            }
        }
        return ganador;
    }
  
    //Sesion 
    public Jugador getJugadorActual() throws UsuarioException{
        if (jugadoresEnMano != null && !jugadoresEnMano.isEmpty()) {
        // Suponiendo que el primer jugador en la lista es el actual
        return jugadoresEnMano.get(0); 
        }
        throw new UsuarioException("No hay jugadores en la mesa.");
        //excepcion de java, hace una y personalizarla
    }

    
    
    
    
}
