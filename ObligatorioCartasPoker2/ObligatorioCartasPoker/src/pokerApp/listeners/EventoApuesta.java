
package pokerApp.listeners;

import dominiousuario.Jugador;


public class EventoApuesta {
    private Jugador jugador;
    private float monto;

    public EventoApuesta(Jugador jugador, float monto) {
        this.jugador = jugador;
        this.monto = monto;
    }

    public Jugador getJugador() {
        return jugador;
    }

    public float getMonto() {
        return monto;
    }
    
    
}
