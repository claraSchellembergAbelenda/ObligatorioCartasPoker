
package vista;

import java.util.ArrayList;
import modelJuego.Mesa;


public interface VistaAdministrarMesa {
    public void mostrarTitulo(String mensaje);
    public void CargarDatosEnLista(ArrayList<Mesa> mesas);
    public void CargarCombo(ArrayList<Mesa> mesas);
    public void actualizarMesas();
    public void mostrarMensajeExitoso(String mensaje);
    public void mostrarMensajeError(String mensaje);
    
}
