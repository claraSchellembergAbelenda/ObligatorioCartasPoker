
package pokerApp.juego;

import pokerApp.figurasYCartas.Figura;
import pokerApp.usuarios.Jugador;
import java.util.ArrayList;


public class Mano {
    /*Muestra la lista de manos jugadas en la 
mesa con la siguiente información para cada 
mano:
-Número de mano
-Cantidad de jugadores participantes
-Total apostado en la mano
-Estado actual de la mano (*2)
-Nombre del jugador ganador
-Nombre de la figura con la que ganó
    */
    private ArrayList<Figura> figurasJugadas;
    private float pozoApuestas;
    private int numeroMano;
    private int cantJugadores;
    private EstadoMano estadoMano;
    private Jugador jugadorGanador;
    private Figura figuraGanadora;

    public Mano(ArrayList<Figura> figurasJugadas, float pozoApuestas, int numeroMano) {
        this.figurasJugadas = figurasJugadas;
        this.pozoApuestas = pozoApuestas;
        this.numeroMano = numeroMano;
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

    public void setPozoApuestas(float pozoApuestas) {
        this.pozoApuestas = pozoApuestas;
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
    
    
    public void realizarApuestas(Jugador j){
        
    }
    
    public void realizarApuesta(Jugador j){
        //me parece que tal vez en todo caso esta funcion deberia recibir el
        //monto para agregarlo al pozo
        
    }
    
    
}
