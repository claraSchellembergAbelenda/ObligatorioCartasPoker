
package controladores;

import modelFachada.Fachada;
import modelJuego.MesaException;
import vista.VistaCrearMesa;

public class CrearMesaController {
    VistaCrearMesa vista;
    //Administrador administrador;

    public CrearMesaController(VistaCrearMesa vista) {
        this.vista = vista;
        //this.administrador = administrador;
        mostrarTitulo();
        limpiarCampos();
    }

    private void mostrarTitulo() {
        vista.mostrarTitulo("Crear mesa");
    }

    private void limpiarCampos() {
        vista.limpiarTextos();
    }
    
    
    private void crearMesa(int cantJugadores, float apuestaBase, float comision){
        try{
            Fachada.getInstancia().crearMesa(cantJugadores ,apuestaBase ,comision);
        }catch(MesaException me){
            vista.mostrarMensajeError("error: "+ me.getMessage());
        }
    }
    
    
}
