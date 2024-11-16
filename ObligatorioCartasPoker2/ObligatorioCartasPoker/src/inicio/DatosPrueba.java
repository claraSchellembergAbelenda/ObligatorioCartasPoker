package inicio;

import modelFachada.Fachada;



public class DatosPrueba {
    
    
    public static void cargar(){
        Fachada fachada = Fachada.getInstancia();
        fachada.cargarUsuarios();
        fachada.precargaMesas();
        fachada.precargarFiguras();

    }
    
}
