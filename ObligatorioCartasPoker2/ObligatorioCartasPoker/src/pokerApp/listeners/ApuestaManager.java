
package pokerApp.listeners;

import pokerApp.usuarios.Jugador;
import utilidades.Observable;


public class ApuestaManager extends Observable<EventoApuesta>{
    private static ApuestaManager instancia;

    private ApuestaManager() {}

    public static ApuestaManager getInstancia() {
        if (instancia == null) {
            instancia = new ApuestaManager();
        }
        return instancia;
    }
    
    public void registrarApuesta(Jugador jugador, float monto) {
       // Notifica a todos los observadores (jugadores) de que se ha realizado una apuesta
        avisar(new EventoApuesta(jugador, monto)); // EventoApuesta contiene la info de jugador y monto
    }
}
