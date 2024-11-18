
package vista;

import java.util.ArrayList;
import modelJuego.Mesa;
import modelUsuario.Jugador;

public interface VistaIngresarAMesa {
    public void cargarMesas(ArrayList<Mesa> mesas);
    public void mostrarDatosJugador(Jugador jugador);
    public void ingresarAMesa();
    public void mostrarMensajeError(String mensaje);
}
