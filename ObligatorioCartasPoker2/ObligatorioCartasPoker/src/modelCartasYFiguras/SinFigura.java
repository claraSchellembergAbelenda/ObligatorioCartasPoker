package modelCartasYFiguras;

import modelCartasYFiguras.Carta;
import java.util.List;

public class SinFigura extends TipoFigura {

    public SinFigura() {
        super("Sin Figura", 1);
    }

    @Override
    public boolean esFigura(List<Carta> cartas) {
        return true; // SinFigura se cumple cuando ninguna de las otras figuras aplica
    }
}