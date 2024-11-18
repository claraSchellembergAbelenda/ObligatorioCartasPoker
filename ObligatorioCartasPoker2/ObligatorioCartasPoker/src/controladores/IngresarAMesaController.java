
package controladores;

import interfazusuario.SalaEsperaPoker;
import java.util.ArrayList;
import modelFachada.Fachada;
import modelJuego.Mesa;
import modelUsuario.Jugador;
import modelUsuario.UsuarioException;
import vista.VistaIngresarAMesa;

public class IngresarAMesaController {
    Jugador jugador;
    VistaIngresarAMesa vista;

    public IngresarAMesaController(Jugador jugador, VistaIngresarAMesa vista) {
        this.jugador = jugador;
        this.vista = vista;
    }
    public void mostrarDatosJugador(){
        vista.mostrarDatosJugador(jugador);
    }
    public void cargarMesas(){
        ArrayList<Mesa>mesas=Fachada.getInstancia().obtenerMesasAbiertas() ;
        vista.cargarMesas(mesas);
    }
    
    public boolean ingresarAMesa(Mesa mesaSeleccionada){
        try{
            // Verifica el saldo del jugador antes de entrar a la sala de espera
            Fachada.getInstancia().validarSaldoDeJugador(jugador, mesaSeleccionada);
            
            // Ingresar a la sala de espera
            SalaEsperaPoker salaEspera = new SalaEsperaPoker(null, false, mesaSeleccionada, jugador);
            salaEspera.setVisible(true);
            return true;
            
        }catch(UsuarioException ue){
            vista.mostrarMensajeError(ue.getMessage());
            return false;
        }
    }
    
    
}
