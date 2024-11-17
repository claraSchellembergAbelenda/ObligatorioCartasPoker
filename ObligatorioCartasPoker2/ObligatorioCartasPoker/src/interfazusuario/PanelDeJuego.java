
package interfazusuario;

import estados.EstadoMano;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import modelCartasYFiguras.TipoFigura;
import modelFachada.Fachada;
import modelJuego.JuegoPoker;
import modelJuego.ManoException;
import modelJuego.Mesa;
import modelUsuario.Jugador;
import modelUsuario.UsuarioException;
import panelCartasPoker.CartaPoker;
import panelCartasPoker.PanelCartasListener;
import panelCartasPoker.PanelCartasPokerException;
import pokerApp.listeners.ApuestaListener;
import pokerApp.listeners.ApuestaManager;
import pokerApp.listeners.EventoApuesta;
import utilidades.Observable;
import utilidades.Observador;
import modelCartasYFiguras.Carta;
import modelJuego.ResultadoGanador;
import pokerApp.listeners.EventoJugador;
import pokerApp.listeners.EventoMesa;


public class PanelDeJuego extends javax.swing.JFrame implements PanelCartasListener,
        ApuestaListener, Observador{

    private JuegoPoker juegoPoker;
    private Jugador jugador;
    private Mesa mesa;
    private List<String> figuras;
    private List<Carta> cartasSeleccionadas= new ArrayList<>();
    private ArrayList<Jugador> jugadoresEnMano= new ArrayList<>();
    private boolean cambioCartas;
    
    public PanelDeJuego( Jugador jugador, Mesa mesa){
        initComponents();
        this.mesa = mesa;
        this.juegoPoker = mesa.getJuegoPoker();
        this.jugador=jugador;
        jugadoresEnMano = mesa.getJugadoresEnMesa();
        cambioCartas=false;
        inicializarPanelJuego();
        Fachada.getInstancia().precargarFiguras();
        figuras=TipoFigura.getTodasFiguras();
        cargarFiguras();
        juegoPoker.agregar(this);
        mesa.agregar(this);
        ApuestaManager.getInstancia().agregar(this);//arreglar esto
        MostrarSaldoJugador();
        MostrarMensaje();
        MostrarNombreJugador();
        MostrarEstadoMano();
        MostrarNumeroMesa();
        MostrarNumeroMano();
        MostrarMayorFiguraFormada();
        CargarJugadores();
        MostrarPozoActual();
        cargarCartasEnPanel(jugador.getCartas());
        btnSeguirJugando.setVisible(false);
        
    }
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelCartasPoker1 = new panelCartasPoker.PanelCartasPoker();
        lblMensaje = new javax.swing.JLabel();
        lblNumeroMano = new javax.swing.JLabel();
        lblFiguraMayor = new javax.swing.JLabel();
        lblFigurasDefinidas = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        lstFiguras = new javax.swing.JList();
        lblJugadoresEnMano = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        lstJugadoresMismaSituacion = new javax.swing.JList();
        lblNumeroMesa = new javax.swing.JLabel();
        lblSaldoJugador = new javax.swing.JLabel();
        lblNombreJugador = new javax.swing.JLabel();
        lblEstadoMano = new javax.swing.JLabel();
        lblValorActualPozo = new javax.swing.JLabel();
        btnIniciarApuesta = new javax.swing.JButton();
        btnPasarMano = new javax.swing.JButton();
        btnCambiarCartas = new javax.swing.JButton();
        btnAbandonarMesa = new javax.swing.JButton();
        lblSeguirJugando = new javax.swing.JLabel();
        btnSeguirJugando = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblMensaje.setText("LblMensaje");

        lblNumeroMano.setText("lblNumeroMano");

        lblFiguraMayor.setText("La figura mayor formada es:");

        lblFigurasDefinidas.setText("Figuras definidas:");

        jScrollPane2.setViewportView(lstFiguras);

        lblJugadoresEnMano.setText("Jugadores en mano:");

        jScrollPane3.setViewportView(lstJugadoresMismaSituacion);

        lblNumeroMesa.setText("lblNumeroMesa");

        lblSaldoJugador.setText("lblSaldoJugador");

        lblNombreJugador.setText("lblNombreJugador");

        lblEstadoMano.setText("lblEstadoMano");

        lblValorActualPozo.setText("lblValorActualPozo");

        btnIniciarApuesta.setText("Iniciar apuesta");
        btnIniciarApuesta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIniciarApuestaActionPerformed(evt);
            }
        });

        btnPasarMano.setText("Pasar mano");
        btnPasarMano.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPasarManoActionPerformed(evt);
            }
        });

        btnCambiarCartas.setText("Cambiar cartas");
        btnCambiarCartas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCambiarCartasActionPerformed(evt);
            }
        });

        btnAbandonarMesa.setText("Abandonar mesa");
        btnAbandonarMesa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAbandonarMesaActionPerformed(evt);
            }
        });

        lblSeguirJugando.setText("lblSeguirJugando");

        btnSeguirJugando.setText("Continuar jugando");
        btnSeguirJugando.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSeguirJugandoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(lblSaldoJugador, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(btnIniciarApuesta, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(92, 92, 92)
                            .addComponent(btnPasarMano, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(330, 330, 330))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(327, 327, 327)
                            .addComponent(btnCambiarCartas, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnSeguirJugando)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(btnAbandonarMesa)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(0, 0, Short.MAX_VALUE)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(lblNombreJugador, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(85, 85, 85)
                                                .addComponent(lblEstadoMano, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(232, 232, 232))
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(lblSeguirJugando, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(47, 47, 47))))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(lblNumeroMano, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(lblNumeroMesa, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addGroup(layout.createSequentialGroup()
                                                        .addGap(213, 213, 213)
                                                        .addComponent(lblFiguraMayor, javax.swing.GroupLayout.PREFERRED_SIZE, 274, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                        .addComponent(lblValorActualPozo, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addGap(103, 103, 103))))
                                            .addComponent(lblMensaje, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 437, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblFigurasDefinidas, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(31, 31, 31)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblJugadoresEnMano, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(31, 31, 31)
                                .addComponent(panelCartasPoker1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblFigurasDefinidas, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblJugadoresEnMano, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 110, Short.MAX_VALUE)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lblEstadoMano, javax.swing.GroupLayout.DEFAULT_SIZE, 29, Short.MAX_VALUE)
                            .addComponent(lblNombreJugador, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(11, 11, 11)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblMensaje, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblSeguirJugando, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(41, 41, 41)
                                .addComponent(lblNumeroMesa, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblNumeroMano, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(42, 42, 42)
                                .addComponent(lblValorActualPozo, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblFiguraMayor, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelCartasPoker1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblSaldoJugador, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnIniciarApuesta, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnPasarMano, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCambiarCartas, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                    .addComponent(btnAbandonarMesa)
                    .addComponent(btnSeguirJugando, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnIniciarApuestaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIniciarApuestaActionPerformed
        // TODO add your handling code here:
        
        IniciarApuesta iniciarApuesta = new IniciarApuesta(this, false, jugador);
        iniciarApuesta.setApuestaListener(this);
        iniciarApuesta.setVisible(true);
    }//GEN-LAST:event_btnIniciarApuestaActionPerformed

    private void btnAbandonarMesaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAbandonarMesaActionPerformed
        juegoPoker.abandonarMesa(jugador);
        lblMensaje.setText("Has abandonado la mesa.");
        this.dispose(); 
    }//GEN-LAST:event_btnAbandonarMesaActionPerformed

    private void btnPasarManoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPasarManoActionPerformed

        btnCambiarCartas.setEnabled(false);
        btnIniciarApuesta.setEnabled(false);
        btnPasarMano.setEnabled(false);
        //logica para pasar 
        //crear una funcion en juegoPoker que notifique/guarde el dato de que el 
        //jugador paso de mano
        juegoPoker.pasoMano(jugador);
        //en juego poker cuando hago ese checkeo tengo que verificar si hay 
        //jugadores uqe no han pasado de mano
        //si no hay jugadores entonces sigue
        //si todos los jugadores pasaron de mano, hacer un evento que sea finDeMano
        //tengo que vincular ese evento con el panel de cartas
        //en juegoPoker hacer lo correspondiente a si ese evento sucediera(empieza una mano nueva)
    }//GEN-LAST:event_btnPasarManoActionPerformed

    private void btnSeguirJugandoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSeguirJugandoActionPerformed
        // TODO add your handling code here:
        //empezar aca una siguiente mano
    }//GEN-LAST:event_btnSeguirJugandoActionPerformed

private void btnCambiarCartasActionPerformed(java.awt.event.ActionEvent evt) {
    try {
        if (cartasSeleccionadas.isEmpty()) {
            lblMensaje.setText("No se han seleccionado cartas para cambiar.");
            return;
        }
        if(!cambioCartas){
            // Obtén nuevas cartas para reemplazar
            ArrayList<Carta> nuevasCartas = juegoPoker.getMesa().getMazo().sacarCartas(cartasSeleccionadas.size());

            // Cambia las cartas seleccionadas en el jugador
            jugador.cambiarCartas(new ArrayList<>(cartasSeleccionadas), nuevasCartas);

            // Limpia la selección y recarga el panel visualmente
            cartasSeleccionadas.clear();
            cargarCartasEnPanel(jugador.getCartas());

            // Actualiza la figura del jugador y muestra el mensaje correspondiente
            MostrarMayorFiguraFormada();

            lblMensaje.setText("Pediste "+nuevasCartas.size()+" nuevas");
        }else{
            lblMensaje.setText("Solo puede cambiar cartas 1 vez por turno");
        }
        
    } catch (Exception ex) {
        lblMensaje.setText("Error al cambiar cartas: " + ex.getMessage());
    }
}

    
    public void apuestaIngresada(float montoApuesta){
        try {
                juegoPoker.iniciarApuesta(montoApuesta, jugador);
                lblMensaje.setText( "Apuesta de $" + montoApuesta + " iniciada.");

                float pozoActual = juegoPoker.getMesa().getMontoTotalApostado();
                mesa.setApuestaBase(pozoActual);
                //jugador.descontarSaldo(montoApuesta);
                // Notifica al ApuestaManager que un jugador ha hecho una apuesta
                ApuestaManager.getInstancia().registrarApuesta(jugador, montoApuesta);

                actualizarInterfaz(); // Actualiza la interfaz para reflejar los cambios
                
                lblMensaje.setText( "El pozo actual es: $" + pozoActual);
                MostrarSaldoJugador();
            }
            catch (UsuarioException ue) {
            lblMensaje.setText("No hay jugadores en la mesa. No se puede iniciar la apuesta.");
        }
        catch(ManoException me){
            lblMensaje.setText("Error: "+me.getMessage());
        }
    }
    
    
    
    // Método para actualizar la interfaz con el estado actual del juego
    private void actualizarInterfaz() {
        // Actualiza paneles o etiquetas con la información actual del juego
        //panelCartasPoker.actualizarCartas(juegoPoker.getCartasJugador());
        //hay que ver como actualizar ya que esta en el package libreria y no deja
        //editar el PanelCartasPoker
        // Aquí podrías actualizar otros elementos de la interfaz, como el saldo o el pozo.
        // Por ejemplo:
        this.MostrarEstadoMano();
        this.MostrarMayorFiguraFormada();
        this.MostrarMensaje();
        this.MostrarNumeroMano();
        this.MostrarPozoActual();
        this.MostrarSaldoJugador();
//        Mesa mesa = juegoPoker.getMesa(); // Obtener la mesa desde juegoPoker
//        float pozo = mesa.getMontoTotalApostado(); // Obtener el pozo desde mesa
//        MostrarSaldoJugador();
//        lblValorActualPozo.setText("El pozo actual es: $" + pozo);
    }
    
    


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAbandonarMesa;
    private javax.swing.JButton btnCambiarCartas;
    private javax.swing.JButton btnIniciarApuesta;
    private javax.swing.JButton btnPasarMano;
    private javax.swing.JButton btnSeguirJugando;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel lblEstadoMano;
    private javax.swing.JLabel lblFiguraMayor;
    private javax.swing.JLabel lblFigurasDefinidas;
    private javax.swing.JLabel lblJugadoresEnMano;
    private javax.swing.JLabel lblMensaje;
    private javax.swing.JLabel lblNombreJugador;
    private javax.swing.JLabel lblNumeroMano;
    private javax.swing.JLabel lblNumeroMesa;
    private javax.swing.JLabel lblSaldoJugador;
    private javax.swing.JLabel lblSeguirJugando;
    private javax.swing.JLabel lblValorActualPozo;
    private javax.swing.JList lstFiguras;
    private javax.swing.JList lstJugadoresMismaSituacion;
    private panelCartasPoker.PanelCartasPoker panelCartasPoker1;
    // End of variables declaration//GEN-END:variables

    
    //---------------------------------------------mostrar mensajes----------------------------------------------------------------------------------------------
    private void inicializarPanelJuego() {
        panelCartasPoker1.setListener(this); // Configura el listener del panel!
    }

    private void cargarFiguras() {
        List<String> auxiliar = new ArrayList<String>();

                for (String figura : figuras) {
                    auxiliar.add(figura);
                }
        
        lstFiguras.setListData(auxiliar.toArray());
    }

    private void MostrarSaldoJugador() {
        lblSaldoJugador.setText("Saldo: $" + jugador.getSaldo());
    }

    private void MostrarMensaje() {
        lblMensaje.setText("El juego ha comenzado en la mesa " 
                + juegoPoker.getMesa().getNumeroMesa() );
    }

    private void MostrarNombreJugador() {
        lblNombreJugador.setText( "bienvenido jugador: "+ jugador.getNombre());
    }

    private void MostrarEstadoMano() {
        lblEstadoMano.setText("Estado mano actual: "+mesa.getEstadoMano());
    }

    private void MostrarNumeroMesa() {
        lblNumeroMesa.setText("Numero de mesa: "+ mesa.getNumeroMesa());
    }

    private void MostrarNumeroMano() {
        lblNumeroMano.setText("Numero de mano actual: "+mesa.getNumeroManoActual());
    }

    private void MostrarMayorFiguraFormada() {
        TipoFigura figuraActual = Fachada.getInstancia().determinarFigura(jugador.getCartas());
        lblFiguraMayor.setText("La figura más grande formada es: " + figuraActual.getNombre());
    }

    private void CargarJugadores() {
        //crear un arrayList con los jugadores que estan en la misma mesa y 
        //misma situacion de mano
        ArrayList<Jugador> jugadoresMismaSituacion = new ArrayList<>();
        for (Jugador j : jugadoresEnMano) {
            if(j.getEstadoJugadorEnMano()==jugador.getEstadoJugadorEnMano()){
                jugadoresMismaSituacion.add(j);
            }
        }
        
        lstJugadoresMismaSituacion.setListData(jugadoresMismaSituacion.toArray());
    }

    private void MostrarPozoActual() {
        lblValorActualPozo.setText("Pozo actual"+mesa.getApuestaBase());
    }

    
    
    
    
    //--------------------------------------override methods------------------------------------------------------------------------------
    
@Override
public void clickEnCarta(CartaPoker cartaPoker) {
    // Encuentra la carta correspondiente al objeto CartaPoker
    for (Carta carta : jugador.getCartas()) {
        if (carta.getValorCarta() == cartaPoker.getValorCarta() &&
            carta.getPaloCarta().equals(cartaPoker.getPaloCarta())) {
            
            if (carta.isSeleccionada()) {
                carta.setSeleccionada(false); // Deseleccionar
                cartasSeleccionadas.remove(carta);
            } else {
                carta.setSeleccionada(true); // Seleccionar
                cartasSeleccionadas.add(carta);
            }
            break; // Sal del bucle después de encontrar la carta
        }
    }

    // Recarga las cartas en el panel visualmente
    cargarCartasEnPanel(jugador.getCartas());
    lblMensaje.setText("Cartas seleccionadas: " + cartasSeleccionadas.size());
}
    
    
    
    public void cargarCartasEnPanel(ArrayList<Carta> cartas) {
    try {
        ArrayList<CartaPoker> cartasPoker = new ArrayList<>();

        for (Carta carta : cartas) {
            carta.setVisible(!carta.isSeleccionada()); // Oculta las cartas seleccionadas visualmente
            cartasPoker.add(carta); // Agrega la carta a la lista
        }

        panelCartasPoker1.cargarCartas(cartasPoker);
    } catch (PanelCartasPokerException ex) {
        lblMensaje.setText("Error al cargar cartas en el panel: " + ex.getMessage());
    }
}
    

    public void actualizarApuesta(Observable origen, EventoApuesta evento) {
        if(evento.getJugador()!=jugador){
                   int respuesta = JOptionPane.showConfirmDialog(this, 
                           evento.getJugador().getNombreCompleto()
                                   + " ha realizado una apuesta de $" + evento.getMonto() +
                           ". ¿Deseas pagar la apuesta?", "Pagar Apuesta", 
                           JOptionPane.YES_NO_OPTION);
                       if (respuesta == JOptionPane.YES_OPTION && 
                               jugador.tieneSaldoSuficiente(evento.getMonto())) {
                           jugador.descontarSaldo(evento.getMonto());
                           mesa.incrementarPozo(evento.getMonto());
                           lblMensaje.setText(jugador.getNombreCompleto() + " ha pagado la apuesta.");
                           actualizarInterfaz();
                       } else {
                       lblMensaje.setText(jugador.getNombreCompleto() 
                               + " ha decidido no pagar la apuesta.");
                       // Desactiva botones si el jugador no paga
                       btnCambiarCartas.setEnabled(false);
                       //btnJugar.setEnabled(false);
                       btnPasarMano.setEnabled(false);
                   }
               }
           }
    
    
    

    @Override
    public void actualizar(Observable origen, Object evento) {
        if(evento instanceof EventoApuesta){
            actualizarApuesta(origen, (EventoApuesta) evento);
        }
        if(evento.equals(EventoJugador.NO_TIENE_SALDO_SUFICIENTE)){
            actualizarJugadorSinSaldo();
            //mostrar mensaje de error y cerrar ventana
        }
        if(evento.equals(EventoMesa.NUEVA_MANO_INICIADA)){
            actualizarManoIniciada();
            System.out.println("empezo mano nueva");
        }
        if(evento.equals(EstadoMano.TERMINADA)){
            actualizarManoTerminada();
        }
        //en evento mano_terminada se crea un dialogo que diga quien es el ganador y con que figura
    }

    public void actualizarJugadorSinSaldo(){
        IngresarAMesa ingresarAMesa=new IngresarAMesa(null, false, jugador);
        ingresarAMesa.setVisible(true);
        this.dispose();
    }

    private void actualizarManoIniciada() {
        this.btnAbandonarMesa.setEnabled(true); 
        btnCambiarCartas.setEnabled(true);
        btnIniciarApuesta.setEnabled(true);
        btnPasarMano.setEnabled(true);
        this.MostrarNumeroMano();
        this.actualizarInterfaz();
    }

    private void actualizarManoTerminada() {
        ResultadoGanador resultado = mesa.getResultadoMano();
        lblMensaje.setText("El ganador de la mano es: "+ resultado.getJugador().getNombre()
        +" con la figura: "+resultado.getFigura().getNombre());
        btnCambiarCartas.setEnabled(false);
        btnIniciarApuesta.setEnabled(false);
        btnPasarMano.setEnabled(false);
        lblSeguirJugando.setText("Desea continuar jugando: ");
        btnSeguirJugando.setVisible(true);
        
    }

   
}
