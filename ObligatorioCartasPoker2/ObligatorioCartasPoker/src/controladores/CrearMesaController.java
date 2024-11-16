
package controladores;

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
    
    
    
    
    
}
