package pokerApp.iu;

import inicio.DatosPrueba;
import java.util.ArrayList;
import java.util.List;
import pokerApp.juego.IniciarApuesta;
import pokerApp.juego.JuegoPoker;
import javax.swing.JOptionPane;
import panelCartasPoker.CartaPoker;
import panelCartasPoker.PanelCartasListener;
import panelCartasPoker.PanelCartasPokerException;
import pokerApp.Exceptions.UsuarioException;
import pokerApp.Fachada.Fachada;
import pokerApp.figurasYCartas.Carta;
import pokerApp.juego.Mesa;
import pokerApp.usuarios.Jugador;

public class PanelDeCartas extends javax.swing.JFrame implements PanelCartasListener {

    private JuegoPoker juegoPoker;
    private Jugador jugador;
    
    public PanelDeCartas() {
        initComponents();
        Mesa mesa = new Mesa(5,200,23);//ejemplo de mesa
        juegoPoker = new JuegoPoker(mesa);
        lblMensaje.setText("Usuario -----------------------------------------------------------");
        
        // Añadir un jugador de ejemplo con cartas
        jugador = new Jugador("12345678","viki2009","Maxi",5000);  // Crear jugador de ejemplo
        mesa.agregarJugador(jugador);  // Añadir jugador a la mesa

        // Asignar cartas de ejemplo al jugador, usando un ArrayList en lugar de List.of
        List<Carta> cartasJugador = new ArrayList<>();
        cartasJugador.add(new Carta(1, "CORAZON"));
        cartasJugador.add(new Carta(2, "DIAMANTE"));
        cartasJugador.add(new Carta(3, "TREBOL"));
        cartasJugador.add(new Carta(4, "PIQUE"));
        cartasJugador.add(new Carta(8, "PIQUE"));
        jugador.setCartas((ArrayList<Carta>) cartasJugador);

        inicializarPanelCartas();
        cargarCartasEnPanel(jugador.getCartas());  // Cargar cartas en el panel
        
    }
    
    
    private void inicializarPanelCartas() {
        panelCartasPoker.setListener(this); // Configura el listener del panel!
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelCartas1 = new pokerApp.iu.PanelCartas();
        panelCartasPoker = new panelCartasPoker.PanelCartasPoker();
        btnIniciarApuesta = new javax.swing.JButton();
        btnPasar = new javax.swing.JButton();
        btnCambiarCartas = new javax.swing.JButton();
        btnAbandonarMesa = new javax.swing.JButton();
        btnJugar = new javax.swing.JButton();
        btnPagarApuesta = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        lblSaldoJugador = new javax.swing.JLabel();
        lblMensaje = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btnIniciarApuesta.setText("Iniciar Apuesta");
        btnIniciarApuesta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIniciarApuestaActionPerformed(evt);
            }
        });

        btnPasar.setText("Pasar");
        btnPasar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPasarActionPerformed(evt);
            }
        });

        btnCambiarCartas.setText("Cambiar Cartas");
        btnCambiarCartas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCambiarCartasActionPerformed(evt);
            }
        });

        btnAbandonarMesa.setText("Abandonar Mesa");
        btnAbandonarMesa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAbandonarMesaActionPerformed(evt);
            }
        });

        btnJugar.setText("Jugar");
        btnJugar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnJugarActionPerformed(evt);
            }
        });

        btnPagarApuesta.setText("Pagar Apuesta");
        btnPagarApuesta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPagarApuestaActionPerformed(evt);
            }
        });

        lblSaldoJugador.setText("Saldo:");

        lblMensaje.setText("No se encontro usuario hbsdbjadsbjabdjbldalbj");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(56, 56, 56)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(lblSaldoJugador, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 464, Short.MAX_VALUE))
                            .addComponent(btnIniciarApuesta))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnPagarApuesta, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnCambiarCartas))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(btnPasar)
                                .addGap(161, 161, 161)))
                        .addGap(86, 86, 86)
                        .addComponent(btnJugar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnAbandonarMesa)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(119, 119, 119)
                        .addComponent(panelCartasPoker, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 158, Short.MAX_VALUE))))
            .addGroup(layout.createSequentialGroup()
                .addGap(89, 89, 89)
                .addComponent(lblMensaje, javax.swing.GroupLayout.PREFERRED_SIZE, 829, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(lblMensaje, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(125, 125, 125)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addComponent(panelCartasPoker, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(80, 80, 80)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnAbandonarMesa)
                        .addComponent(btnJugar))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnIniciarApuesta)
                            .addComponent(btnPagarApuesta)
                            .addComponent(btnCambiarCartas))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnPasar)
                            .addComponent(lblSaldoJugador, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addGap(34, 34, 34))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnJugarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnJugarActionPerformed
        //logica para iniciar el juego, si la mesa esta iniciada entonces... sino...
        //una vez que ya todos los jugadores pagaron las apuestas o pasaron y ya se cambiaron las cartas
        //TERMINA MANO, se determina el ganador de la mano
        //se incrementa su saldo x el valor del pozo-% de comision
        //se le muestra cartel y cambia el estado de la mano y si les da el saldo aparece cartel de que decidan 
        //si seguir jugando
        //si no le da la plata se sale y va a la interfaz de ingresar a mesa
    }//GEN-LAST:event_btnJugarActionPerformed

    private void btnIniciarApuestaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIniciarApuestaActionPerformed

    IniciarApuesta iniciarApuesta = new IniciarApuesta(this, false, jugador);
    iniciarApuesta.setVisible(true);

    float montoApuesta = iniciarApuesta.getApuesta();

        try {
                juegoPoker.iniciarApuesta(montoApuesta);
                lblMensaje.setText( "Apuesta de $" + montoApuesta + " iniciada.");
                actualizarInterfaz(); // Actualiza la interfaz para reflejar los cambios

                // Mostrar el pozo actual en un JOptionPane
                double pozoActual = juegoPoker.getMesa().getMontoTotalApostado();
                lblMensaje.setText( "El pozo actual es: $" + pozoActual);
            
                lblMensaje.setText( "Saldo insuficiente para iniciar la apuesta.");
            }
            catch (UsuarioException ue) {
            lblMensaje.setText("No hay jugadores en la mesa. No se puede iniciar la apuesta.");
        }
    }
    
    private void btnPasarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPasarActionPerformed
        //logica para pasar 
    }

    private void btnPagarApuestaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPagarApuestaActionPerformed
        //uno apuesta, se le resta de su saldo el valor de la apuesta hecha y les aparece un dialogo al resto de los 
        //jugadores que dice "tal jugador hizo una apuesta, desea pagar, si o no"
        //si ponen que si se les descuenta
        //si no pagan la apuesta se cierra esa ventana y se le desabilitan todos los botones excepto el de abandonar mesa
        
    }//GEN-LAST:event_btnPagarApuestaActionPerformed

    private void btnCambiarCartasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCambiarCartasActionPerformed
        //logica para cambiar cartas
    }//GEN-LAST:event_btnCambiarCartasActionPerformed

    private void btnAbandonarMesaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAbandonarMesaActionPerformed
        juegoPoker.abandonarMesa();
        JOptionPane.showMessageDialog(this, "Has abandonado la mesa.");
        this.dispose(); // Cierra la ventana
    }//GEN-LAST:event_btnAbandonarMesaActionPerformed

    
    // Método para actualizar la interfaz con el estado actual del juego
    private void actualizarInterfaz() {
        // Actualiza paneles o etiquetas con la información actual del juego
        //panelCartasPoker.actualizarCartas(juegoPoker.getCartasJugador());//hay que ver como actualizar ya que esta en el package libreria y no deja editar el PanelCartasPoker
        // Aquí podrías actualizar otros elementos de la interfaz, como el saldo o el pozo.
        // Por ejemplo:
        Mesa mesa = juegoPoker.getMesa(); // Obtener la mesa desde juegoPoker
        double pozo = mesa.getMontoTotalApostado(); // Obtener el pozo desde mesa
        JOptionPane.showMessageDialog(this, "El pozo actual es: $" + pozo, "Pozo Actual", JOptionPane.INFORMATION_MESSAGE);
    }

    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(() -> new PanelDeCartas().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAbandonarMesa;
    private javax.swing.JButton btnCambiarCartas;
    private javax.swing.JButton btnIniciarApuesta;
    private javax.swing.JButton btnJugar;
    private javax.swing.JButton btnPagarApuesta;
    private javax.swing.JButton btnPasar;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lblMensaje;
    private javax.swing.JLabel lblSaldoJugador;
    private pokerApp.iu.PanelCartas panelCartas1;
    private panelCartasPoker.PanelCartasPoker panelCartasPoker;
    // End of variables declaration//GEN-END:variables

   @Override
    public void clickEnCarta(CartaPoker carta) {
        JOptionPane.showMessageDialog(this, carta.toString(), "Click en carta", JOptionPane.INFORMATION_MESSAGE);
    }
        
    public void cargarCartasEnPanel(List<Carta> cartas) {
    ArrayList<CartaPoker> cartasPoker = new ArrayList<>();

    for (Carta carta : cartas) {
        CartaPoker cartaPoker = new CartaPoker() {
            @Override
            public int getValorCarta() {
                return carta.getValorCarta();  // Asegúrate de devolver el valor correcto
            }

            @Override
            public String getPaloCarta() {
                // Asegúrate de devolver el palo como "C", "D", "T", o "P" para que coincida con la imagen
                switch (carta.getPaloCarta().toUpperCase()) {
                    case "CORAZON":
                        return CartaPoker.CORAZON;
                    case "DIAMANTE":
                        return CartaPoker.DIAMANTE;
                    case "TREBOL":
                        return CartaPoker.TREBOL;
                    case "PIQUE":
                        return CartaPoker.PIQUE;
                    default:
                        return "P";  // valor por defecto
                }
            }

            @Override
            public boolean estaVisible() {
                return true;  // Determina la visibilidad
            }

            @Override
            public void setVisible(boolean b) {
                // Implementa la visibilidad si es necesario
            }
        };
        cartasPoker.add(cartaPoker);
    }

    try {
        panelCartasPoker.cargarCartas(cartasPoker);
    } catch (PanelCartasPokerException ex) {
        JOptionPane.showMessageDialog(this, ex.getMessage(), "Error al cargar cartas", JOptionPane.ERROR_MESSAGE);
    }
}
    
    
}
