package pokerApp.iu;

import java.util.ArrayList;
import java.util.List;
import pokerApp.juego.Mesa;
import pokerApp.usuarios.Jugador;
import estados.EstadoPartida;
import pokerApp.figurasYCartas.Carta;

public class JuegoPoker {
    private Mesa mesa;
    
    
    public JuegoPoker(Mesa mesa) {
        this.mesa = mesa;
        

    }

    public Mesa getMesa() {
        return mesa;
    }

//hay metodos repetidos o distintos que hacen lo mismo arreglarlos
    public void iniciarJuego() {
        if (mesa.getEstadoPartida().ABIERTA != EstadoPartida.ABIERTA) {
            System.out.println("Esperando inicio del juego, hay " + mesa.getJugadoresActuales() 
                               + " jugadores de " + mesa.getJugadoresRequeridos() + " en la mesa.");
        } else {
            System.out.println("El juego ha comenzado en la mesa " + mesa.getNumeroMesa());
            repartirCartas();
        }
    }

    private void repartirCartas() {
        List<String> mazo = generarMazo(); // Implementación de un mazo de cartas
        for (Jugador jugador : mesa.getJugadoresEnMesa()) {
            List<String> cartas = new ArrayList<>();
            for (int i = 0; i < 5; i++) {
                cartas.add(mazo.remove(0)); // Asigna 5 cartas al jugador
            }
            jugador.asignarCartas(cartas);
            System.out.println(jugador.getNombre() + " ha recibido sus cartas.");
        }
    }

    private List<String> generarMazo() {
        // Genera y baraja un mazo de cartas para el juego
        return new ArrayList<>(); // Implementa la lógica de creación del mazo aquí
    }

    public void realizarApuesta(Jugador jugador, double monto) {
        if (jugador.tieneSaldoSuficiente(monto)) {
            jugador.descontarSaldo(monto);
            mesa.incrementarPozo(monto);
            System.out.println(jugador.getNombre() + " ha realizado una apuesta de $" + monto);
        } else {
            System.out.println("Saldo insuficiente para realizar esta apuesta.");
        }
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
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
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

    public boolean iniciarApuesta(double monto) {
        Jugador jugador = mesa.getJugadorActual(); // Suponiendo que obtienes el jugador actual de la mesa

        if (jugador.tieneSaldoSuficiente(monto)) {
            jugador.descontarSaldo(monto);
            mesa.incrementarPozo(monto); // Incrementa el pozo de la mesa con el monto apostado
            return true;
        } else {
            return false; // Saldo insuficiente
        }
    }
    
    public ArrayList<Carta> getCartasJugador(){
        //retorna las cartas del jugador
        return Jugador.getCartas();
    }
    
    
}