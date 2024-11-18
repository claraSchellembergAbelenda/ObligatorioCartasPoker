
package controladores;

import java.util.ArrayList;
import modelFachada.Fachada;
import modelJuego.Mesa;
import utilidades.Observable;
import utilidades.Observador;
import vista.VistaAdministrarMesa;


public class AdministrarMesaController {
    private VistaAdministrarMesa vista;
    private ArrayList<Mesa> mesas=new ArrayList<>();
    private boolean cargandoComboMesas=false;

    public AdministrarMesaController(VistaAdministrarMesa vistaAdmin) {
        this.mesas=Fachada.getInstancia().getMesas();
        vista = vistaAdmin;
        CargarCombo();
        CargarDatosEnLista();
    }
    
    public void mostrarTitulo(){
        vista.mostrarTitulo("Administrar mesas");
    }
    
    public void CargarDatosEnLista(){
        vista.CargarDatosEnLista(mesas);
    }
    public void CargarCombo(){
        ArrayList<Mesa> mesas = Fachada.getInstancia().getMesas();
        vista.CargarCombo(mesas);
    }
    public void actualizarMesas(){
        this.mesas = Fachada.getInstancia().getMesas();
        CargarCombo();
        CargarDatosEnLista();
    }

    
    
}
