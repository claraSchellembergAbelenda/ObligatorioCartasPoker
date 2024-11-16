
package inicio;

import modelFachada.Fachada;
import pokerApp.iuJuego.PanelDeCartas;
import interfazusuario.Login;
import interfazusuario.LoginAdministrador;
import interfazusuario.LoginJugador;
import modelUsuario.Sesion;
import modelUsuario.Usuario;


public class Test {
 
    public static void main(String[] args){
        DatosPrueba.cargar();
        Principal principal = new Principal();
        principal.setVisible(true);
        
    }
}
