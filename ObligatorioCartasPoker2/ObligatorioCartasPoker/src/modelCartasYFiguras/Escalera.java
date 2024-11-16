package modelCartasYFiguras;

import modelCartasYFiguras.Carta;
import java.util.List;
import java.util.ArrayList;

public class Escalera extends TipoFigura {

    public Escalera() {
        super("Escalera", 4);
    }

    @Override
    public boolean esFigura(List<Carta> cartas) {
        if (cartas.size() < 5) return false;

        // Copiamos los valores de las cartas en una lista de enteros
        List<Integer> valores = new ArrayList<>();
        for (Carta carta : cartas) {
            valores.add(carta.getValorCarta());
        }

        // Ordenamos los valores de las cartas en orden ascendente usando un
        //simple algoritmo de ordenamiento
        ordenarValores(valores);

        // Comprobamos si los valores están en secuencia
        for (int i = 1; i < valores.size(); i++) {
            if (valores.get(i) != valores.get(i - 1) + 1) {
                return false;
            }
        }
        return true;
    }

    // Método para ordenar la lista de valores usando un algoritmo simple de ordenamiento (ejemplo: burbuja)
    private void ordenarValores(List<Integer> valores) {
        int n = valores.size();
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (valores.get(j) > valores.get(j + 1)) {
                    // Intercambiamos los valores
                    int temp = valores.get(j);
                    valores.set(j, valores.get(j + 1));
                    valores.set(j + 1, temp);
                }
            }
        }
    }
}