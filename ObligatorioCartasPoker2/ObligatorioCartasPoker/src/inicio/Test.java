
package inicio;

import dominio.Fachada.Fachada;
import pokerApp.iuJuego.PanelDeCartas;
import interfazusuario.Login;
import interfazusuario.LoginAdministrador;
import interfazusuario.LoginJugador;
import dominiousuario.Sesion;
import dominiousuario.Usuario;


public class Test {
 
    public static void main(String[] args){
        DatosPrueba.cargar();
        Principal principal = new Principal();
        principal.setVisible(true);
        
    }
}
