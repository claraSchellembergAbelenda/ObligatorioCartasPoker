package dominiocartasyfiguras;

import dominiocartasyfiguras.Carta;
import java.util.List;

public class Poker extends TipoFigura {

    public Poker() {
        super("Poker", 5); // 5 es la prioridad máxima
    }

    @Override
    public boolean esFigura(List<Carta> cartas) {
        if (cartas.size() < 4) return false;
        int valor = cartas.get(0).getValorCarta();
        return cartas.stream().filter(c -> c.getValorCarta() == valor).count() >= 4;
    }
}