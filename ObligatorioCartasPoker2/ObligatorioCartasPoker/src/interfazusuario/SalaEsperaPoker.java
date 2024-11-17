
package interfazusuario;

import interfazusuario.PanelDeJuego;
import java.util.ArrayList;
import javax.swing.Timer;
import modelUsuario.UsuarioException;
import modelJuego.JuegoPoker;
import modelJuego.Mesa;
import modelUsuario.Jugador;
import pokerApp.listeners.EventoMesa;
import utilidades.Observable;
import utilidades.Observador;


public class SalaEsperaPoker extends javax.swing.JDialog implements Observador{

    private Jugador jugador;
    private Mesa mesa;
    private JuegoPoker juegoPoker;
    private static ArrayList<Jugador>jugadores = new ArrayList<>();

    
    public SalaEsperaPoker(java.awt.Frame parent, boolean modal, Mesa mesa, Jugador jugador) {
        super(parent, modal);
        initComponents();
        this.jugador = jugador;
        this.mesa = mesa;
        this.mesa.agregar(this);
        this.mesa.agregarJugador(jugador);
        jugadores.add(jugador);
        cargarMensaje();
        
        //temporizador que verifica el inicio del juego cada 3 segundos
        
        if(this.jugadores.equals(mesa.getJugadoresEnMesa())){
            this.dispose();
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblMensaje = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addComponent(lblMensaje, javax.swing.GroupLayout.PREFERRED_SIZE, 278, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(76, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(lblMensaje, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(171, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel lblMensaje;
    // End of variables declaration//GEN-END:variables

    private void cargarMensaje() {
        lblMensaje.setText(jugador.getNombreCompleto()+" "+mesa.getNumeroMesa()
        +"Esperando inicio del juego, hay "+ mesa.getCantidadJugadoresActual()+" de "
        +mesa.getCantidadJugadoresRequeridos()+" en la mesa");
    }
    

    public void actualizarMesa(Observable origen, EventoMesa evento) {
            if (evento == EventoMesa.MESA_COMPLETA) {
            // La mesa está completa, inicializar JuegoPoker y abrir PanelDeCartas
            //this.juegoPoker = new JuegoPoker(mesa);
            PanelDeJuego panelDeJuego = new PanelDeJuego(jugador, mesa);
            panelDeJuego.setVisible(true);
            
//            PanelDeCartas panelDeCartas = new PanelDeCartas(juegoPoker,jugador, mesa);
//            panelDeCartas.setVisible(true);

            // Cerrar la sala de espera
            this.dispose();
            }
        
    }

    @Override
    public void actualizar(Observable origen, Object evento) {
        if(evento instanceof EventoMesa){
            actualizarMesa(origen, (EventoMesa)evento);
        }
    }
    
    
    
    
}
