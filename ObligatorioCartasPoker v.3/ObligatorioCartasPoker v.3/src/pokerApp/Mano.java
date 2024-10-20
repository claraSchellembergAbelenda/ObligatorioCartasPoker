
package pokerApp;

import java.util.ArrayList;


public class Mano {
    
    private ArrayList<Figura> figurasJugadas;
    private float pozoApuestas;
    private int numeroMano;

    public Mano(ArrayList<Figura> figurasJugadas, float pozoApuestas, int numeroMano) {
        this.figurasJugadas = figurasJugadas;
        this.pozoApuestas = pozoApuestas;
        this.numeroMano = numeroMano;
    }

    public ArrayList<Figura> getFigurasJugadas() {
        return figurasJugadas;
    }

    public void setFigurasJugadas(ArrayList<Figura> figurasJugadas) {
        this.figurasJugadas = figurasJugadas;
    }

    public float getPozoApuestas() {
        return pozoApuestas;
    }

    public void setPozoApuestas(float pozoApuestas) {
        this.pozoApuestas = pozoApuestas;
    }

    public int getNumeroMano() {
        return numeroMano;
    }

    public void setNumeroMano(int numeroMano) {
        this.numeroMano = numeroMano;
    }
    
    
    public void realizarApuestas(Jugador j){
        
    }
    
    public void realizarApuesta(Jugador j){
        //me parece que tal vez en todo caso esta funcion deberia recibir el
        //monto para agregarlo al pozo
        
    }
    
}
