
package pokerApp.iuJuego;

import pokerApp.Exceptions.UsuarioException;
import pokerApp.juego.JuegoPoker;
import pokerApp.juego.Mesa;
import pokerApp.usuarios.Jugador;


public class SalaEsperaPoker extends javax.swing.JDialog {

    private Jugador jugador;
    private Mesa mesa;
    private JuegoPoker juegoPoker;

    
    public SalaEsperaPoker(java.awt.Frame parent, boolean modal, Mesa mesa, Jugador jugador) {
        super(parent, modal);
        this.jugador = jugador;
        this.mesa = mesa;
        this.mesa.agregarJugador(jugador);
        initComponents();
        cargarMensaje();
        
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

    /**
     * @param args the command line arguments
     */
public static void main(String[] args) {
    java.awt.EventQueue.invokeLater(() -> {
        // Crear objetos necesarios para inicializar SalaEsperaPoker
        Mesa mesa = new Mesa(1, 1000, 5); // Número de mesa, apuesta base y jugadores requeridos
        Jugador jugador = new Jugador("ID123", "jugador1", "Maximiliano", 5000); // Inicializa el jugador con un saldo

        // Crear y mostrar la ventana de SalaEsperaPoker
        SalaEsperaPoker dialog = new SalaEsperaPoker(new javax.swing.JFrame(), true, mesa, jugador);
        dialog.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent e) {
                System.exit(0);
            }
        });
        dialog.setVisible(true);
    });
}

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel lblMensaje;
    // End of variables declaration//GEN-END:variables

    private void cargarMensaje() {
        lblMensaje.setText(jugador.getNombreCompleto()+" "+mesa.getNumeroMesa()
        +"Esperando inicio del juego, hay "+ mesa.getCantidadJugadoresActual()+" de "
        +mesa.getCantidadJugadoresRequeridos()+" en la mesa");
    }
    
    private void verificarInicioJuego() {
    if (mesa.getCantidadJugadoresActual() == mesa.getCantidadJugadoresRequeridos()) {
        iniciarJuegoPoker();
    } else {
        lblMensaje.setText("Esperando a que lleguen más jugadores...");
    }
}

    private void iniciarJuegoPoker() {
        try{
            JuegoPoker juegoPoker = new JuegoPoker(mesa); // Inicializa el juego con la mesa configurada
            juegoPoker.iniciarJuego(); // Cambia el estado y reparte cartas
            juegoPoker.iniciarMano();
            // Cierra la sala de espera e inicia el panel de cartas
            PanelDeCartas panelCartas = new PanelDeCartas(juegoPoker, jugador, mesa); // Pasa juego y jugador al panel
            panelCartas.setVisible(true);
            this.dispose(); // Cierra la sala de espera
        }catch(UsuarioException ue){
            lblMensaje.setText("Error: "+ue.getMessage());
        }
        
    }
    
    
}
