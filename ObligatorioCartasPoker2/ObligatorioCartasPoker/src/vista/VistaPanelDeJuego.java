
package vista;

import estados.EstadoMano;
import java.util.ArrayList;
import modelUsuario.Jugador;
import pokerApp.listeners.EventoApuesta;
import utilidades.Observable;


public interface VistaPanelDeJuego {
    public void mostrarSaldoJugador(String saldo);
    public void mostrarMensaje(String mensaje);
    public void mostrarNombreJugador(String nombre);
    public void mostrarEstadoMano(String estadoMano);
    public void mostrarNumeroMesa(String numeroMesa);
    public void mostrarNumeroMano(String numeroMano);
    public void mostrarMayorFiguraFormada(String tipoFigura);
    public void cargarJugadores(ArrayList<Jugador>jugadores);
    public void mostrarPozoActual(String pozoActual);
    public void cargarFiguras(ArrayList<String> figuras);
    
    //================================a arreglar:====================================
    public void actualizarApuesta(Observable origen, EventoApuesta evento);
    public void actualizarJugadorSinSaldo();
    public void actualizarManoIniciada();
    public void actualizarManoTerminada();
    public void actualizarPartidaTerminada();
}
