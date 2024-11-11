package pokerApp.juego;

import estados.EstadoMano;
import java.util.ArrayList;
import pokerApp.juego.Mesa;
import pokerApp.usuarios.Jugador;
import estados.EstadoPartida;
import pokerApp.Exceptions.ManoException;
import pokerApp.Exceptions.UsuarioException;
import pokerApp.figurasYCartas.Carta;
import pokerApp.figurasYCartas.Mazo;

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

//hay metodos repetidos o distintos que hacen lo mismo arreglarlos
    public void iniciarJuego() {
        if (mesa.getEstadoPartida().ABIERTA != EstadoPartida.ABIERTA) {
            System.out.println("Esperando inicio del juego, hay " + mesa.getJugadoresEnMesa()
                               + " jugadores de " + mesa.getCantidadJugadoresRequeridos() + " en la mesa.");
        } else {
            System.out.println("El juego ha comenzado en la mesa " + mesa.getNumeroMesa());
            
            //cambiar el estado de la mesa.
            mesa.descontarSaldo();
            mesa.iniciarNuevaMano();
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
        // Lógica para determinar el ganador y redistribuir el pozo
        Jugador ganador = determinarGanador();
        System.out.println("El ganador es " + ganador.getNombre() + " con un pozo de $" + mesa.getMontoTotalApostado());
        //en el sout aca va un get Pozo, pero monto total apostado seria el pozo no?
    }

    private Jugador determinarGanador() {
        // Lógica para determinar el ganador de la mano
        return null;
    }

    public boolean mesaEstaIniciada() {
        if(mesa.getEstadoPartida()!=EstadoPartida.JUGANDO){
            return false;
        }
        return true;
    }

    public void abandonarMesa() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    void cambiarCartas(int cartasACambiar) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    boolean pagarApuesta(double monto) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    double getMontoApuesta() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public void iniciarApuesta(float monto) throws UsuarioException, ManoException{
        
        Jugador jugador = mesa.getJugadorActual(); 
// Suponiendo que obtienes el jugador actual de la mesa
            if(mano.getEstadoMano()!=EstadoMano.ESPERANDO_APUESTA){
                throw new ManoException("No es posible realizar una apuesta en este momento");
            }
            jugador.tieneSaldoSuficiente(monto);
            jugador.descontarSaldo(monto);
            mesa.incrementarPozo(monto); // Incrementa el pozo de la mesa con el monto apostado
            // Saldo insuficiente
        
    }

    public void iniciarMano() throws UsuarioException{
        if(mesa.getCantidadJugadoresActual()==mesa.getCantidadJugadoresRequeridos()){
            mesa.validarSaldos();
            
            mesa.iniciarNuevaMano();
        }
    }


}