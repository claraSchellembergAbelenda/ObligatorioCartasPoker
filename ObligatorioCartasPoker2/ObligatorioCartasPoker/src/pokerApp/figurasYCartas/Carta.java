package pokerApp.figurasYCartas;

import panelCartasPoker.CartaPoker;


public class Carta implements CartaPoker{

    private int numero;
    private String palo;
    private String nombre;
    private boolean visible = true;

    public Carta(int num, String palo) {
        this.numero = num;
        this.palo = palo;
    }
    
    @Override
    public int getValorCarta() {
        return numero;
    }

    @Override
    public String getPaloCarta() {
        return palo;
    }

    @Override
    public boolean estaVisible() {
        return visible;
    }

    @Override
    public void setVisible(boolean b) {
        visible = b;
        System.out.println(toString());
    }

    public String getNombre() {
        return nombre;
    }

     public void asignarNombre() {
        if (numero > 10) {
            switch (numero) {
                case 11: nombre = "J"; break;
                case 12: nombre = "Q"; break;
                case 13: nombre = "K"; break;
                case 14: nombre = "A"; break;
                default: nombre = String.valueOf(numero);
            }
        } else {
            nombre = String.valueOf(numero);  // Para cartas de valor 2 a 10
        }
    }
    

    @Override
    public String toString() {
        return "Carta Ejemplo{" + "numero=" + numero + ", palo=" + palo + ", visible=" + visible + '}';
    }
    
    
}
