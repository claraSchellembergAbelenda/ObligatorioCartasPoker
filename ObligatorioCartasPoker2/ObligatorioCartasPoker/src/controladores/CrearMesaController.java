
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
    }

    public void mostrarTitulo() {
        vista.mostrarTitulo("Crear mesa");
    }

    public void limpiarCampos() {
        vista.limpiarTextos();
    }
    
    
    public void crearMesa(int cantJugadores, float apuestaBase, float comision){
        try{
            Fachada.getInstancia().crearMesa(cantJugadores ,apuestaBase ,comision);
            vista.mostrarMensajeExitoso("Mesa creada con exito");
        }catch(MesaException me){
            vista.mostrarMensajeError("error: "+ me.getMessage());
        }
    }
    
    
}
