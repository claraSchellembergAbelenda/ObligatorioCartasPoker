package dominiocartasyfiguras;

import java.util.ArrayList;
import java.util.List;
import dominiocartasyfiguras.Carta;

public abstract class TipoFigura {
    private String nombre;
    private int prioridad; // La prioridad indica qué figura es más fuerte.
    private static List<String> figuras = new ArrayList<>();
    
    public TipoFigura(String nombre, int prioridad) {
        this.nombre = nombre;
        this.prioridad = prioridad;
        if (!figuras.contains(nombre)) { // Evitar duplicados
            figuras.add(this.nombre);
        }
    }

    public static List<String> getTodasFiguras() {
        return figuras;
    }
    
    public String getNombre() {
        return nombre;
    }

    public int getPrioridad() {
        return prioridad;
    }

    // Método abstracto para verificar si las cartas cumplen con esta figura
    public abstract boolean esFigura(List<Carta> cartas);


    public int compararCon(TipoFigura otraFigura) {
        return Integer.compare(this.prioridad, otraFigura.getPrioridad());
    }

    public List<Carta> getCartas() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}