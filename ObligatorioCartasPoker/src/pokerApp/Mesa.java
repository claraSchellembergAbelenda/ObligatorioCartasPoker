
package pokerApp;

import java.util.ArrayList;

public class Mesa {
    
    private ArrayList<Jugador>Jugadores = new ArrayList<>();
    private ArrayList<Mano> manosJugadas;
    private Mazo cartas;
    private float apuestaBase;
    private EstadoPartida estadoPartida;
    private int cantidadJugadoresRequeridos;
    private int cantidadJugadoresActual;
    private int numeroManoActual;
    private float montoTotalApostado;
    private float montoTotalRecaudado;
    private float comision;
    private Jugador ganador;
    private Figura figuraGanadora;

    //solo ingrese algunos atributos en el constructor porque hay cosas que no se van a saber hasta mas adelante
    public Mesa(ArrayList<Jugador> Jugadores, Mazo cartas, float apuestaBase,
            int cantidadJugadoresRequeridos, float comision) {
        this.Jugadores = Jugadores;
        this.cartas = cartas;
        this.apuestaBase = apuestaBase;
        this.cantidadJugadoresRequeridos = cantidadJugadoresRequeridos;
        this.comision = comision;
        estadoPartida=EstadoPartida.ABIERTA;
    }

    public ArrayList<Jugador> getJugadores() {
        return Jugadores;
    }

    public void setJugadores(ArrayList<Jugador> Jugadores) {
        this.Jugadores = Jugadores;
    }

    public ArrayList<Mano> getManosJugadas() {
        return manosJugadas;
    }

    public void setManosJugadas(ArrayList<Mano> manosJugadas) {
        this.manosJugadas = manosJugadas;
    }

    public Mazo getCartas() {
        return cartas;
    }

    public void setCartas(Mazo cartas) {
        this.cartas = cartas;
    }

    public float getApuestaBase() {
        return apuestaBase;
    }

    public void setApuestaBase(float apuestaBase) {
        this.apuestaBase = apuestaBase;
    }

    public EstadoPartida getEstadoPartida() {
        return estadoPartida;
    }

    public void setEstadoPartida(EstadoPartida estadoPartida) {
        this.estadoPartida = estadoPartida;
    }

    public int getCantidadJugadoresRequeridos() {
        return cantidadJugadoresRequeridos;
    }

    public void setCantidadJugadoresRequeridos(int cantidadJugadoresRequeridos) {
        this.cantidadJugadoresRequeridos = cantidadJugadoresRequeridos;
    }

    public int getCantidadJugadoresActual() {
        return cantidadJugadoresActual;
    }

    public void setCantidadJugadoresActual(int cantidadJugadoresActual) {
        this.cantidadJugadoresActual = cantidadJugadoresActual;
    }

    public int getNumeroManoActual() {
        return numeroManoActual;
    }

    public void setNumeroManoActual(int numeroManoActual) {
        this.numeroManoActual = numeroManoActual;
    }

    public float getMontoTotalApostado() {
        return montoTotalApostado;
    }

    public void setMontoTotalApostado(float montoTotalApostado) {
        this.montoTotalApostado = montoTotalApostado;
    }

    public float getMontoTotalRecaudado() {
        return montoTotalRecaudado;
    }

    public void setMontoTotalRecaudado(float montoTotalRecaudado) {
        this.montoTotalRecaudado = montoTotalRecaudado;
    }

    public float getComision() {
        return comision;
    }

    public void setComision(float comision) {
        this.comision = comision;
    }

    public Jugador getGanador() {
        return ganador;
    }

    public void setGanador(Jugador ganador) {
        this.ganador = ganador;
    }

    public Figura getFiguraGanadora() {
        return figuraGanadora;
    }

    public void setFiguraGanadora(Figura figuraGanadora) {
        this.figuraGanadora = figuraGanadora;
    }
    
    
    
}
