
package pokerApp;

import java.util.ArrayList;

public class Mazo {
    private ArrayList<Carta> cartas;

    public Mazo() {
        this.cartas = new ArrayList<>();
        precargarCartas();
    }

    // Método que precarga las 52 cartas en el mazo
    private void precargarCartas() {
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
}
