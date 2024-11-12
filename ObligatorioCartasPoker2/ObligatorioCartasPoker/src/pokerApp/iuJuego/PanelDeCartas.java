package pokerApp.iuJuego;

import inicio.DatosPrueba;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import javax.swing.DefaultListModel;
import pokerApp.juego.IniciarApuesta;
import pokerApp.juego.JuegoPoker;
import panelCartasPoker.CartaPoker;
import panelCartasPoker.PanelCartasListener;
import panelCartasPoker.PanelCartasPokerException;
import pokerApp.Exceptions.ManoException;
import pokerApp.Exceptions.UsuarioException;
import pokerApp.Fachada.Fachada;
import pokerApp.figurasYCartas.Carta;
import pokerApp.figurasYCartas.TipoFigura;
import pokerApp.juego.Mesa;
import pokerApp.usuarios.Jugador;

public class PanelDeCartas extends javax.swing.JFrame implements PanelCartasListener {

    private JuegoPoker juegoPoker;
    private Jugador jugador;
    private Mesa mesa;
    private List<String>figuras;
    
    
    public PanelDeCartas(JuegoPoker juegoPoker, Jugador jugador, Mesa mesa) {
        initComponents();
        this.juegoPoker = juegoPoker;
        this.jugador = jugador;
        this.mesa = mesa;
        this.mesa.agregarJugador(jugador);
        inicializarPanelCartas();
        Fachada.getInstancia().precargarFiguras();
        figuras=TipoFigura.getTodasFiguras();
        cargarFiguras();
                // Asignar cartas de ejemplo al jugador, usando un ArrayList en lugar de List.of
        List<Carta> cartasJugador = new ArrayList<>();
        cartasJugador.add(new Carta(1, "CORAZON"));
        cartasJugador.add(new Carta(1, "DIAMANTE"));
        cartasJugador.add(new Carta(3, "TREBOL"));
        cartasJugador.add(new Carta(4, "PIQUE"));
        cartasJugador.add(new Carta(5, "PIQUE"));
        jugador.setCartas((ArrayList<Carta>) cartasJugador);
        cargarCartasEnPanel(jugador.getCartas()); 
        lblSaldoJugador.setText("Saldo: $" + jugador.getSaldo());
        lblMensaje.setText("El juego ha comenzado en la mesa " 
                + juegoPoker.getMesa().getNumeroMesa());
        mostrarFiguraFormada();
    }
    
    
    private void inicializarPanelCartas() {
        panelCartasPoker.setListener(this); // Configura el listener del panel!
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelCartas1 = new pokerApp.iuJuego.PanelCartas();
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
        jScrollPane1 = new javax.swing.JScrollPane();
        lstFiguras = new javax.swing.JList();
        lblFigurasDefinidas = new javax.swing.JLabel();
        lblFiguraMayor = new javax.swing.JLabel();

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

        jScrollPane1.setViewportView(lstFiguras);

        lblFigurasDefinidas.setText("Figuras definidas:");

        lblFiguraMayor.setText("La figura mas grande formada es: ");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(56, 56, 56)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblSaldoJugador, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(371, 371, 371)
                                .addComponent(btnPasar)
                                .addGap(39, 39, 39))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnIniciarApuesta)
                                .addGap(37, 37, 37)
                                .addComponent(btnPagarApuesta, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(13, 13, 13)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(35, 35, 35)
                                .addComponent(btnCambiarCartas))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(204, 204, 204)
                                .addComponent(btnJugar)
                                .addGap(18, 18, 18)
                                .addComponent(btnAbandonarMesa))))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(panelCartasPoker, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(207, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(48, 48, 48)
                        .addComponent(lblMensaje, javax.swing.GroupLayout.PREFERRED_SIZE, 653, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(388, 388, 388)
                        .addComponent(lblFiguraMayor, javax.swing.GroupLayout.PREFERRED_SIZE, 284, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(106, 106, 106)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblFigurasDefinidas, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblFigurasDefinidas, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblMensaje, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(168, 168, 168)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblFiguraMayor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(39, 39, 39)))
                        .addGap(18, 18, 18)
                        .addComponent(panelCartasPoker, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 111, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnIniciarApuesta)
                            .addComponent(btnPagarApuesta)
                            .addComponent(btnCambiarCartas))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnPasar)
                            .addComponent(lblSaldoJugador, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(34, 34, 34))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnJugar)
                            .addComponent(btnAbandonarMesa))
                        .addGap(26, 26, 26))))
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

    private void btnIniciarApuestaActionPerformed(java.awt.event.ActionEvent evt) {                                                  

        IniciarApuesta iniciarApuesta = new IniciarApuesta(this, false, jugador);
        iniciarApuesta.setApuestaListener(monto -> {
            procesarApuesta(monto); // Procesar el monto recibido
        });
        iniciarApuesta.setVisible(true);

    
    }
    public void procesarApuesta(float montoApuesta){
        try {
                juegoPoker.iniciarApuesta(montoApuesta);
                lblMensaje.setText( "Apuesta de $" + montoApuesta + " iniciada.");
                actualizarInterfaz(); // Actualiza la interfaz para reflejar los cambios

                double pozoActual = juegoPoker.getMesa().getMontoTotalApostado();
                lblMensaje.setText( "El pozo actual es: $" + pozoActual);
                actializarSaldoJugador();
            }
            catch (UsuarioException ue) {
            lblMensaje.setText("No hay jugadores en la mesa. No se puede iniciar la apuesta.");
        }
        catch(ManoException me){
            lblMensaje.setText("Error: "+me.getMessage());
        }
    }
    
    public void actializarSaldoJugador(){
        lblSaldoJugador.setText("Saldo: $" + jugador.getSaldo());
    }
    
    
    private void btnPasarActionPerformed(java.awt.event.ActionEvent evt) {  
        btnAbandonarMesa.setEnabled(false);
        btnCambiarCartas.setEnabled(false);
        btnIniciarApuesta.setEnabled(false);
        btnPagarApuesta.setEnabled(false);
        btnJugar.setEnabled(false);
        btnPasar.setEnabled(false);
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
        lblMensaje.setText("Has abandonado la mesa.");
        this.dispose(); // Cierra la ventana
    }//GEN-LAST:event_btnAbandonarMesaActionPerformed

    
    // Método para actualizar la interfaz con el estado actual del juego
    private void actualizarInterfaz() {
        // Actualiza paneles o etiquetas con la información actual del juego
        //panelCartasPoker.actualizarCartas(juegoPoker.getCartasJugador());
        //hay que ver como actualizar ya que esta en el package libreria y no deja
        //editar el PanelCartasPoker
        // Aquí podrías actualizar otros elementos de la interfaz, como el saldo o el pozo.
        // Por ejemplo:
        Mesa mesa = juegoPoker.getMesa(); // Obtener la mesa desde juegoPoker
        double pozo = mesa.getMontoTotalApostado(); // Obtener el pozo desde mesa
        lblMensaje.setText("El pozo actual es: $" + pozo);
    }

public static void main(String[] args) {
    java.awt.EventQueue.invokeLater(() -> {
        // Crear una mesa y un jugador
        Mesa mesa = new Mesa(1, 1000, 5); // ID mesa, apuesta base, jugadores requeridos
        Jugador jugador = new Jugador("ID123", "jugador1", "Maximiliano", 5000); // Jugador de prueba

        // Inicializar el juego de póker con la mesa
        JuegoPoker juegoPoker = new JuegoPoker(mesa);
        
        // Crear y mostrar la ventana de PanelDeCartas
        PanelDeCartas panelCartas = new PanelDeCartas(juegoPoker, jugador, mesa);
        panelCartas.setVisible(true);
    });
}

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAbandonarMesa;
    private javax.swing.JButton btnCambiarCartas;
    private javax.swing.JButton btnIniciarApuesta;
    private javax.swing.JButton btnJugar;
    private javax.swing.JButton btnPagarApuesta;
    private javax.swing.JButton btnPasar;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lblFiguraMayor;
    private javax.swing.JLabel lblFigurasDefinidas;
    private javax.swing.JLabel lblMensaje;
    private javax.swing.JLabel lblSaldoJugador;
    private javax.swing.JList lstFiguras;
    private pokerApp.iuJuego.PanelCartas panelCartas1;
    private panelCartasPoker.PanelCartasPoker panelCartasPoker;
    // End of variables declaration//GEN-END:variables

   @Override
    public void clickEnCarta(CartaPoker carta) {
        lblMensaje.setText("Click en carta");
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
        lblMensaje.setText("Error al cargar cartas");
    }
}

    private void cargarFiguras() {
        List<String> auxiliar = new ArrayList<String>();
        
        for (String figura : figuras) {
            auxiliar.add(figura);
        }
        
        lstFiguras.setListData(auxiliar.toArray());
    }

    private void mostrarFiguraFormada() {
        //tenemos un arrayList con las cartas del jugador
        TipoFigura tipoFigura =Fachada.getInstancia().determinarFigura(jugador.getCartas());
        lblFiguraMayor.setText("La figura mas grande formada es: "+ tipoFigura.getNombre());
        
    }

    
    
    
}
