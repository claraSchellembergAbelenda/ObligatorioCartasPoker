
package modelJuego;

import estados.EstadoMano;
import modelCartasYFiguras.Figura;
import modelUsuario.Jugador;
import java.util.ArrayList;
import java.util.List;
import modelUsuario.UsuarioException;
import modelCartasYFiguras.SistemaFiguras;
import modelCartasYFiguras.Mazo;
import modelCartasYFiguras.TipoFigura;


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
    private Mazo mazo=new Mazo();
    private ResultadoGanador resultadoGanador;


// Constructor que recibe la lista de jugadoresEnMano y crea las listas necesarias
    public Mano(List<Jugador> jugadores, int numeroMano) {
        this.jugadoresEnMano = jugadores; 
        this.sistemaFiguras = new SistemaFiguras();  // Inicializamos el sistema de figuras
        this.figurasJugadas = figurasJugadas;
        this.pozoApuestas = 0;
        this.numeroMano = numeroMano;
        this.estadoMano=EstadoMano.ESPERANDO_APUESTA;
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
    public void repartirCartas() {
        int cartasPorJugador = 5; // Ajustar según las reglas del juego
        for (int i = 0; i < jugadoresEnMano.size(); i++) {
            Jugador jugador = jugadoresEnMano.get(i);
                jugador.setCartas(mazo.sacarCartas(cartasPorJugador));
        }
    }


    public Jugador determinarGanador() {
        return determinarResultadoGanador().getJugador();
    }
    public TipoFigura determinarFiguraGanadora(){
        return determinarResultadoGanador().getFigura();
    }
  
    

    public ResultadoGanador terminarMano() {
        this.resultadoGanador = determinarResultadoGanador();
        this.setEstadoMano(EstadoMano.TERMINADA);
        return resultadoGanador;
    }
    
    public ResultadoGanador determinarResultadoGanador(){
        Jugador ganador = null;
        TipoFigura mejorFigura = null;
        for (Jugador jugador : jugadoresEnMano) {
            TipoFigura figura = sistemaFiguras.determinarFigura(jugador.getCartas());

            if (mejorFigura == null 
                    || sistemaFiguras.compararDosFiguras(figura, mejorFigura) == figura) {
                mejorFigura = figura;
                ganador = jugador;
            }
        }
        
        return new ResultadoGanador(ganador, mejorFigura);
    }
    

    
}
