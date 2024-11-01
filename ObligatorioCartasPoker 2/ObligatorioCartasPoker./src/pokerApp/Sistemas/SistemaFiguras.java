package pokerApp.Sistemas;

import pokerApp.figurasYCartas.*;
import java.util.ArrayList;
import java.util.List;

public class SistemaFiguras {
    private List<TipoFigura> figuras;

    public SistemaFiguras() {
        figuras = new ArrayList<>();
        precargarFiguras();
    }

    private void precargarFiguras() {
        figuras.add(new Poker());
        figuras.add(new Escalera());
        figuras.add(new Pierna());
        figuras.add(new Par());
        figuras.add(new SinFigura());
    }

    public TipoFigura determinarFigura(List<Carta> cartas) {
        for (TipoFigura figura : figuras) {
            if (figura.esFigura(cartas)) {
                return figura;
            }
        }
        return new SinFigura();
    }

    public TipoFigura compararFiguras(List<TipoFigura> figuras) {
    TipoFigura mejorFigura = figuras.get(0);

    for (int i = 1; i < figuras.size(); i++) {
        mejorFigura = compararDosFiguras(mejorFigura, figuras.get(i));
    }
    return mejorFigura;
    }

    public TipoFigura compararDosFiguras(TipoFigura figura1, TipoFigura figura2) {
        int resultado = figura1.compararCon(figura2);
        if (resultado > 0) {
            return figura1;
        } else if (resultado < 0) {
            return figura2;
        } else {
            return compararPorValor(figura1, figura2); // Resolver empate
        }
    }

    // Método para resolver el empate basado en el valor de las cartas
    private TipoFigura compararPorValor(TipoFigura figura1, TipoFigura figura2) {
        int resultado = figura1.compararCon(figura2);
        if (resultado > 0) {
            return figura1;
        } else if (resultado < 0) {
            return figura2;
        } else {
            // Aquí puedes añadir la lógica de desempate específica
            return figura1; // Placeholder, asume que ambas figuras son iguales en valor
        }
    }

    public List<TipoFigura> getFiguras() {
        return figuras;
    }

    
}