package pokerApp.juego;

import estados.EstadoMano;
import java.util.ArrayList;
import dominioMesaYMano.Mesa;
import dominiousuario.Jugador;
import estados.EstadoPartida;
import dominioMesaYMano.ManoException;
import dominiousuario.UsuarioException;
import dominiocartasyfiguras.Carta;
import dominiocartasyfiguras.Mazo;

public class JuegoPoker {
    private Mesa mesa;
    private Mano mano;
    private Mazo mazo;
    
    public JuegoPoker(Mesa mesa) {
        this.mesa = mesa;
        this.mazo = mesa.getMazo();
        this.mano = mesa.getManoActual();
    }

    public Mesa getMesa() {
        return mesa;
    }

    public void iniciarJuego() {
        if (mesa.getEstadoPartida() != EstadoPartida.ABIERTA) {
            System.out.println("Esperando inicio del juego, hay " + mesa.getJugadoresEnMesa().size()
                               + " jugadores de " + mesa.getCantidadJugadoresRequeridos() + " en la mesa.");
        } else {
            System.out.println("El juego ha comenzado en la mesa " + mesa.getNumeroMesa());
            mesa.setEstadoPartida(EstadoPartida.JUGANDO);  // Cambia el estado de la mesa a 'Jugando'
            mesa.descontarSaldo();
        }
    }

    private void repartirCartas() {
        for (Jugador jugador : mesa.getJugadoresEnMesa()) {
                ArrayList<Carta> mano = mazo.sacarCartas(5); // Suponiendo que `sacarCartas` devuelve una lista de 5 cartas
                jugador.setCartas(mano); // Asigna las cartas a través de `setCartas`
                System.out.println(jugador.getNombre() + " ha recibido sus cartas: " + mano);
        }
    }



    public void realizarApuesta(Jugador jugador, float monto) throws UsuarioException{
            jugador.tieneSaldoSuficiente(monto);
            jugador.descontarSaldo(monto);
            mesa.incrementarPozo(monto);
            System.out.println(jugador.getNombre() + " ha realizado una apuesta de $" + monto);
        
        
    }

    public void finalizarMano() {
        Jugador ganador = determinarGanador();
        if (ganador != null) {
            System.out.println("El ganador es " + ganador.getNombre() + " con un pozo de $" + mesa.getMontoTotalApostado());
            ganador.aumentarSaldo(mesa.getMontoTotalApostado());
            mesa.setMontoTotalApostado(0);
        } else {
            System.out.println("No se ha determinado un ganador para esta mano.");
        }
    }

    private Jugador determinarGanador() {
        if (mesa.getManoActual() != null) {
            return mesa.getManoActual().determinarGanador();  // Llamada al método `determinarGanador` en la clase `Mano`
        }
        return null;
    }

    public boolean mesaEstaIniciada() {
        return mesa.getEstadoPartida() == EstadoPartida.JUGANDO;
    }

    public void abandonarMesa(Jugador jugador) {
        mesa.removerJugador(jugador);
        System.out.println(jugador.getNombre() + " ha abandonado la mesa.");
    }

    public void cambiarCartas(Jugador jugador, ArrayList<Carta> cartasACambiar) {
        ArrayList<Carta> nuevasCartas = mazo.sacarCartas(cartasACambiar.size());
        jugador.cambiarCartas(cartasACambiar, nuevasCartas); // Asume que el jugador tiene un método `cambiarCartas`
        System.out.println(jugador.getNombre() + " ha cambiado " + cartasACambiar.size() + " cartas.");
    }

    public boolean pagarApuesta(Jugador jugador, double monto) throws UsuarioException {
        float montoApuesta = (float) monto;  // Convertimos monto a float si es necesario
        if (jugador.tieneSaldoSuficiente(montoApuesta)) {
            jugador.descontarSaldo(montoApuesta);
            mesa.incrementarPozo(montoApuesta);
            System.
                    out.println(jugador.getNombre() + " ha pagado una apuesta de $" + montoApuesta);
            return true;
        }
        return false;
    }

    public double getMontoApuesta() {
        return this.mano.getPozoApuestas();
    }

    public void iniciarApuesta(float monto) throws UsuarioException, ManoException{
        
        Jugador jugador = mano.getJugadorActual(); 
        // Suponiendo que obtienes el jugador actual de la mesa
            if(mano.getEstadoMano()!=EstadoMano.ESPERANDO_APUESTA){
                throw new ManoException("No es posible realizar una apuesta en este momento");
            }
            jugador.tieneSaldoSuficiente(monto);
            jugador.descontarSaldo(monto);
            mesa.incrementarPozo(monto); // Incrementa el pozo de la mesa con el monto apostado
            // Saldo insuficiente
        
    }

    public void iniciarMano() throws UsuarioException {
            if (mesa.getCantidadJugadoresActual() == mesa.getCantidadJugadoresRequeridos()) {
                mesa.validarSaldos();
                mesa.iniciarNuevaMano();
            } else {
                throw new UsuarioException("No hay suficientes jugadores para iniciar la mano.");
            }
        }


}