package modelCartasYFiguras;

import modelCartasYFiguras.Carta;
import java.util.List;

public class Par extends TipoFigura {

    public Par() {
        super("Par", 2);
    }

    @Override
    public boolean esFigura(List<Carta> cartas) {
        for (Carta carta : cartas) {
            int valor = carta.getValorCarta();
            if (cartas.stream().filter(c -> c.getValorCarta() == valor).count() >= 2) {
                return true;
            }
        }
        return false;
    }
}