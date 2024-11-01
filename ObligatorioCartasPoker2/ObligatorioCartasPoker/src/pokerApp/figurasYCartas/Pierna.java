package pokerApp.figurasYCartas;

import java.util.List;

public class Pierna extends TipoFigura {

    public Pierna() {
        super("Pierna", 3);
    }

    @Override
    public boolean esFigura(List<Carta> cartas) {
        for (Carta carta : cartas) {
            int valor = carta.getValorCarta();
            if (cartas.stream().filter(c -> c.getValorCarta() == valor).count() >= 3) {
                return true;
            }
        }
        return false;
    }
}