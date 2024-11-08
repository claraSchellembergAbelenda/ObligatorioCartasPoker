
package pokerApp.figurasYCartas;

import pokerApp.figurasYCartas.Carta;
import java.util.ArrayList;
import java.util.Collections;

public class Mazo {
    private ArrayList<Carta> cartas;

    public Mazo() {
        this.cartas = new ArrayList<>();
        precargarCartas();
        barajarCartas();
    }

    // Método que precarga las 52 cartas en el mazo
    public void precargarCartas() {
        String[] palos = {"Corazón", "Diamante", "Trébol", "Pique"};
        int[] valores = {14, 13, 12, 11, 10, 9, 8, 7, 6, 5,4,3,2};

        for (String palo : palos) {
            for (int valor : valores) {
                Carta carta = new Carta(valor, palo);
                carta.asignarNombre();
                cartas.add(carta);
                
            }
        }
    }

    public ArrayList<Carta> getCartas() {
        return cartas;
    }

    public void mostrarCartas() {
        for (Carta carta : cartas) {
            System.out.println(carta);
        }
    }
    
    public void barajarCartas(){
        Collections.shuffle(cartas);
    }
    
    public ArrayList<Carta> sacarCartas(int n){
        ArrayList<Carta> mano = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            mano.add(cartas.remove(0)); // Saca una carta de la "parte superior"
        }
        return mano;
    }
    
}
