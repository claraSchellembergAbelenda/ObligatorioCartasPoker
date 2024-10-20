package iu;
import java.util.ArrayList;
import panelCartasPoker.CartaPoker;
import pokerApp.figurasYCartas.Carta;


public class PanelCartas {

    public static void main(String[] args) {
        // TODO code application logic here
        ArrayList<CartaPoker> cartas = new ArrayList();
        cartas.add(new Carta(1,CartaPoker.CORAZON));
        cartas.add(new Carta(1,CartaPoker.DIAMANTE));
        cartas.add(new Carta(1,CartaPoker.TREBOL));
        cartas.add(new Carta(1,CartaPoker.PIQUE));
        cartas.add(new Carta(11,CartaPoker.PIQUE));
        
        VisualizacionCartas dialogo = new VisualizacionCartas(null, false);
        dialogo.setVisible(true);  
       
        dialogo.cargarCartas(cartas);
        
     
        cartas.set(0, new Carta(10,CartaPoker.PIQUE));
        dialogo.cargarCartas(cartas);
        cartas.set(0, new Carta(9,CartaPoker.PIQUE));
        dialogo.cargarCartas(cartas);
        
        
    }
    
}
