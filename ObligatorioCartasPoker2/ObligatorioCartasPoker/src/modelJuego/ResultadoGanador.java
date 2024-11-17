
package modelJuego;

import modelCartasYFiguras.TipoFigura;
import modelUsuario.Jugador;


public class ResultadoGanador {
    private Jugador jugador;
    private TipoFigura figura;

    public ResultadoGanador(Jugador jugador, TipoFigura figura) {
        this.jugador = jugador;
        this.figura = figura;
    }

    public Jugador getJugador() {
        return jugador;
    }

    public TipoFigura getFigura() {
        return figura;
    }
}
