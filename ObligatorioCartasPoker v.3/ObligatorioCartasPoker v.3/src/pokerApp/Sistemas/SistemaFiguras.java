package pokerApp.Sistemas;

import java.util.ArrayList;
import java.util.List;
import jdk.jshell.spi.ExecutionControl.NotImplementedException;
import pokerApp.Figura;

public class SistemaFiguras {
    private List<Figura> figuras;

    public SistemaFiguras() {
        figuras = new ArrayList<>();
        precargarFiguras();
    }

    private void precargarFiguras() {
        figuras.add(new Figura("Poker"));
        figuras.add(new Figura("Escalera"));
        figuras.add(new Figura("Pierna"));
        figuras.add(new Figura("Par"));
        figuras.add(new Figura("Sin Figura"));
    }

    public List<Figura> getFiguras() {
        return figuras;
    }
    public Figura compararFiguras(ArrayList<Figura> figuras){ 
        //en realidad esta funcion va a comparar una cantidad distinta de figuras dependiendo de cuantos 
        //jugadores haya en la mesa
        return null;
    }
    
}