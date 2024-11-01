package pokerApp.figurasYCartas;

public class Figura {
    private String nombre;
    private TipoFigura tipo;

    public Figura(String nombre) {
        this.nombre = nombre;
    }
        
    public String getNombre() {
        return nombre;
    }

    public TipoFigura getTipo() {
        return tipo;
    }

    public void setTipo(TipoFigura tipo) {
        this.tipo = tipo;
    }

    
    
    @Override
    public String toString() {
        return "Figura{" + "nombre='" + nombre + '\'' + '}';
    }
}