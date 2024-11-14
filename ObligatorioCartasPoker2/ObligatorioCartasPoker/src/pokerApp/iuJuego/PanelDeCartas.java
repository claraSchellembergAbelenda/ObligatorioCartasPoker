package pokerApp.iuJuego;

import estados.EstadoPartida;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
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
import pokerApp.listeners.ApuestaListener;
import pokerApp.listeners.ApuestaManager;
import pokerApp.listeners.EventoApuesta;
import pokerApp.uiMesas.IngresarAMesa;
import pokerApp.usuarios.Jugador;
import utilidades.Observable;
import utilidades.Observador;

public class PanelDeCartas extends javax.swing.JFrame implements PanelCartasListener, 
        ApuestaListener, Observador<EventoApuesta> {

    private JuegoPoker juegoPoker;
    private Jugador jugador;
    private Mesa mesa;
    private List<String>figuras;
    private List<Carta> cartasSeleccionadas = new ArrayList<>();
    private ArrayList<Jugador>jugadoresEnMano= new ArrayList<>();
    
    
    public PanelDeCartas(JuegoPoker juegoPoker, Jugador jugador, Mesa mesa, ArrayList<Jugador>jugadores) {
        initComponents();
        this.juegoPoker = juegoPoker;
        this.jugador = jugador;
        this.mesa = mesa;
        this.mesa.agregarJugador(jugador);
        inicializarPanelCartas();
        Fachada.getInstancia().precargarFiguras();
        figuras=TipoFigura.getTodasFiguras();
        cargarFiguras();
        jugadoresEnMano=jugadores;
        ApuestaManager.getInstancia().agregar(this);
        
        // Asignar cartas aleatorias al jugador desde el mazo
        List<Carta> cartasJugador = mesa.getMazo().sacarCartas(5);
        jugador.setCartas((ArrayList<Carta>) cartasJugador);
        cargarCartasEnPanel(jugador.getCartas());
//        cargarCartasEnPanel(jugador.getCartas()); 
        lblSaldoJugador.setText("Saldo: $" + jugador.getSaldo());
        lblMensaje.setText("El juego ha comenzado en la mesa " 
                + juegoPoker.getMesa().getNumeroMesa() + "bienvenido jugador: "+ jugador.getNombre());
        mostrarFiguraFormada();
    }
    
    
    private void inicializarPanelCartas() {
        panelCartasPoker.setListener(this); // Configura el listener del panel!
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
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
    }

    private void btnJugarActionPerformed(java.awt.event.ActionEvent evt) {
        try {
        // Verificar si la mesa está en estado 'Iniciada'
        if (mesa.getEstadoPartida() == EstadoPartida.ABIERTA) {
            // Todos los jugadores han hecho sus apuestas o han pasado, así que termina la mano actual
            mesa.terminarMano();
            // Determina el ganador de la mano actual
            Jugador ganador = mesa.determinarJugadorDeMano();
            
            if (ganador != null) {
                // Calcular el pozo total menos la comisión de la mesa
                float pozo = mesa.getMontoTotalApostado();
                float montoGanado = pozo * (1 - mesa.getComision() / 100);
                
                // Aumentar el saldo del jugador ganador y mostrar mensaje
                ganador.aumentarSaldo(montoGanado);
                lblMensaje.setText("¡Felicidades " + ganador.getNombreCompleto() + "! Has ganado $" + montoGanado + ".");
                
                // Actualizar el saldo en la interfaz
                actualizarSaldoJugador();
            } else {
                // Si no hay ganador, acumula el pozo para la próxima mano
                lblMensaje.setText("La mano ha terminado sin ganador. El pozo se acumula para la siguiente mano.");
            }
            
            // Verificar si cada jugador tiene saldo suficiente para seguir jugando
            List<Jugador> jugadoresParaRetirar = new ArrayList<>();
            for (Jugador jugador : mesa.getJugadoresEnMesa()) {
                if (!jugador.tieneSaldoSuficiente(mesa.getApuestaBase())) {
                    jugadoresParaRetirar.add(jugador);
                }
            }
            
            // Retirar jugadores sin saldo y mostrar mensajes
            for (Jugador jugador : jugadoresParaRetirar) {
                mesa.removerJugador(jugador);
                lblMensaje.setText("El jugador " + jugador.getNombreCompleto() + " ha sido retirado por saldo insuficiente.");
            }
            
            
            
            
            // Iniciar la siguiente mano si quedan jugadores
            if (mesa.getCantidadJugadoresActual() > 1) {
                mesa.iniciarNuevaMano();
                lblMensaje.setText("Nueva mano iniciada. ¡Buena suerte!");
            } else {
                // Si solo queda un jugador, finaliza la mesa
                mesa.finalizarMesa();
                lblMensaje.setText("La mesa ha finalizado. Solo queda un jugador.");
                
                // Redirigir al jugador restante a la interfaz de selección de mesa
                this.dispose();
                IngresarAMesa seleccionarMesa = new IngresarAMesa(new javax.swing.JFrame(), true, ganador);
                seleccionarMesa.setVisible(true);
            }
        } else {
            lblMensaje.setText("La mesa no está lista para jugar. Por favor, espere a que se inicie.");
        }
    } catch (Exception ex) {
        lblMensaje.setText("Error durante el juego: " + ex.getMessage());
    }
    
    
    }

    private void btnIniciarApuestaActionPerformed(java.awt.event.ActionEvent evt) {                                                  

        IniciarApuesta iniciarApuesta = new IniciarApuesta(this, false, jugador);
        iniciarApuesta.setApuestaListener(this);
        iniciarApuesta.setVisible(true);

    
    }
    public void apuestaIngresada(float montoApuesta){
        try {
                juegoPoker.iniciarApuesta(montoApuesta);
                lblMensaje.setText( "Apuesta de $" + montoApuesta + " iniciada.");
                actualizarInterfaz(); // Actualiza la interfaz para reflejar los cambios

                // Notifica al ApuestaManager que un jugador ha hecho una apuesta
                ApuestaManager.getInstancia().registrarApuesta(jugador, montoApuesta);

                float pozoActual = juegoPoker.getMesa().getMontoTotalApostado();
                mesa.setApuestaBase(pozoActual);
                
                 // Notifica a los demás jugadores
                for (Jugador j : jugadoresEnMano) {
                    if (j != jugador) {
                        // Muestra diálogo de confirmación para los demás jugadores
                        int respuesta = JOptionPane.showConfirmDialog(this, 
                            jugador.getNombreCompleto() + " ha apostado $" + montoApuesta +
                            ". ¿Deseas pagar la apuesta?", "Pagar Apuesta", 
                            JOptionPane.YES_NO_OPTION);
                        if (respuesta == JOptionPane.YES_OPTION && j.tieneSaldoSuficiente(montoApuesta)) {
                            j.descontarSaldo(montoApuesta);
                            mesa.incrementarPozo(montoApuesta);
                            lblMensaje.setText(j.getNombreCompleto() + " ha pagado la apuesta.");
                        }
                    }
                }
                lblMensaje.setText( "El pozo actual es: $" + pozoActual);
                actualizarSaldoJugador();
            }
            catch (UsuarioException ue) {
            lblMensaje.setText("No hay jugadores en la mesa. No se puede iniciar la apuesta.");
        }
        catch(ManoException me){
            lblMensaje.setText("Error: "+me.getMessage());
        }
    }
    
    public void actualizarSaldoJugador(){
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

    private void btnPagarApuestaActionPerformed(java.awt.event.ActionEvent evt) {
        //uno apuesta, se le resta de su saldo el valor de la apuesta hecha y les aparece un dialogo al resto de los 
        //jugadores que dice "tal jugador hizo una apuesta, desea pagar, si o no"
        //si ponen que si se les descuenta
        //si no pagan la apuesta se cierra esa ventana y se le desabilitan todos los botones excepto el de abandonar mesa
        // Obtener el monto de la apuesta actual
    float montoApuesta = mesa.getApuestaBase();

    // Descontar el saldo al jugador que hace la apuesta
    try {
        juegoPoker.realizarApuesta(jugador, (float) montoApuesta);
        lblMensaje.setText("Has realizado una apuesta de $" + montoApuesta + ".");
        actualizarInterfaz();

        // Preguntar al resto de los jugadores si desean pagar la apuesta
        for (Jugador jugadorRestante : mesa.getJugadoresEnMesa()) {
            if (jugadorRestante != jugador) {
                // Crear una ventana de confirmación para el jugador restante
                int respuesta = javax.swing.JOptionPane.showConfirmDialog(this, 
                    jugador.getNombreCompleto() + " ha realizado una apuesta de $" + montoApuesta + 
                    ". ¿Deseas pagar la apuesta?", "Pagar Apuesta", 
                    javax.swing.JOptionPane.YES_NO_OPTION);

                if (respuesta == javax.swing.JOptionPane.YES_OPTION) {
                    // Si el jugador decide pagar, descontar saldo y actualizar el pozo
                    if (jugadorRestante.tieneSaldoSuficiente((float) montoApuesta)) {
                        jugadorRestante.descontarSaldo((float) montoApuesta);
                        mesa.incrementarPozo(montoApuesta);
                        lblMensaje.setText(jugadorRestante.getNombreCompleto() + 
                                " ha pagado la apuesta.");
                        actualizarInterfaz();
                    } else {
                        lblMensaje.setText(jugadorRestante.getNombreCompleto() + 
                                " no tiene saldo suficiente para pagar la apuesta.");
                    }
                } else {
                    // Si el jugador decide no pagar, se le deshabilitan los botones excepto 'Abandonar Mesa'
                    if (jugadorRestante == this.jugador) {
                        btnPagarApuesta.setEnabled(false);
                        btnCambiarCartas.setEnabled(false);
                        btnJugar.setEnabled(false);
                        btnPasar.setEnabled(false);
                    }
                    lblMensaje.setText(jugadorRestante.getNombreCompleto() + 
                            " ha decidido no pagar la apuesta.");
                }
            }
        }
    } catch (UsuarioException ex) {
        lblMensaje.setText("Error al realizar la apuesta: " + ex.getMessage());
    }
        
        
    }

    private void btnCambiarCartasActionPerformed(java.awt.event.ActionEvent evt) {                                                 
        //logica para cambiar cartas
        //se cambian las cartad del jugador, y en el panel se visualizan las cartas nuevas tambien
        try {
        if (!cartasSeleccionadas.isEmpty()) {
            ArrayList<Carta> nuevasCartas = juegoPoker.getMesa().getMazo().sacarCartas(cartasSeleccionadas.size());
            jugador.cambiarCartas(new ArrayList<>(cartasSeleccionadas), nuevasCartas);
            
            // Recargar cartas en el panel y limpiar selección
            cargarCartasEnPanel(jugador.getCartas());  // Actualiza las cartas en el panel
            cartasSeleccionadas.clear();
            lblMensaje.setText("Cartas cambiadas exitosamente.");
            } else {
            lblMensaje.setText("No se han seleccionado cartas para cambiar.");
            }
        } catch (Exception ex) {
            lblMensaje.setText("Error al cambiar cartas: " + ex.getMessage());
        }
    }

    private void btnAbandonarMesaActionPerformed(java.awt.event.ActionEvent evt) {                                                 
        juegoPoker.abandonarMesa(jugador);
        lblMensaje.setText("Has abandonado la mesa.");
        this.dispose(); // Cierra la ventana
    }

    
    // Método para actualizar la interfaz con el estado actual del juego
    private void actualizarInterfaz() {
        // Actualiza paneles o etiquetas con la información actual del juego
        //panelCartasPoker.actualizarCartas(juegoPoker.getCartasJugador());
        //hay que ver como actualizar ya que esta en el package libreria y no deja
        //editar el PanelCartasPoker
        // Aquí podrías actualizar otros elementos de la interfaz, como el saldo o el pozo.
        // Por ejemplo:
        Mesa mesa = juegoPoker.getMesa(); // Obtener la mesa desde juegoPoker
        float pozo = mesa.getMontoTotalApostado(); // Obtener el pozo desde mesa
        lblMensaje.setText("El pozo actual es: $" + pozo);
    }

public static void main(String[] args) {
    java.awt.EventQueue.invokeLater(() -> {
        // Crear una mesa y un jugador
        Mesa mesa = new Mesa(1, 1000, 5); // ID mesa, apuesta base, jugadores requeridos
        Jugador jugador = new Jugador("ID123", "jugador1", "Maximiliano", 5000); // Jugador de prueba

        // Inicializar el juego de póker con la mesa
        JuegoPoker juegoPoker = new JuegoPoker(mesa);
        ArrayList<Jugador>jugadores=new ArrayList<>();
        
        // Crear y mostrar la ventana de PanelDeCartas
        PanelDeCartas panelCartas = new PanelDeCartas(juegoPoker, jugador, mesa, jugadores);
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
    public void clickEnCarta(CartaPoker cartaPoker) {
        Carta carta = new Carta(cartaPoker.getValorCarta(), cartaPoker.getPaloCarta());

        // Verificar si la carta ya está seleccionada y quitarla si es necesario
        if (cartasSeleccionadas.contains(carta)) {
            cartasSeleccionadas.remove(carta);
        } else {
            cartasSeleccionadas.add(carta);
        }

        lblMensaje.setText("Cartas seleccionadas: " + cartasSeleccionadas.size());
    }
        
    public void cargarCartasEnPanel(List<Carta> cartas) {
    ArrayList<CartaPoker> cartasPoker = new ArrayList<>();

    // Crear instancias de CartaPoker para cada Carta y agregar a la lista
    for (Carta carta : cartas) {
        CartaPoker cartaPoker = new CartaPoker() {
            @Override
            public int getValorCarta() {
                return carta.getValorCarta();
            }

            @Override
            public String getPaloCarta() {
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
                return true;
            }

            @Override
            public void setVisible(boolean b) {
                // Controla la visibilidad si es necesario
            }
        };
        cartasPoker.add(cartaPoker);
    }

    // Recargar las cartas en el panel visualmente
    try {
        panelCartasPoker.cargarCartas(cartasPoker);
    } catch (PanelCartasPokerException ex) {
        lblMensaje.setText("Error al cargar cartas en el panel: " + ex.getMessage());
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

    @Override
    public void actualizar(Observable origen, EventoApuesta evento) {
        if(evento.getJugador()!=jugador){
            int respuesta = JOptionPane.showConfirmDialog(this, 
                    evento.getJugador().getNombreCompleto() + " ha realizado una apuesta de $" + evento.getMonto() +
                    ". ¿Deseas pagar la apuesta?", "Pagar Apuesta", 
                    JOptionPane.YES_NO_OPTION);
                if (respuesta == JOptionPane.YES_OPTION && jugador.tieneSaldoSuficiente(evento.getMonto())) {
                    jugador.descontarSaldo(evento.getMonto());
                    mesa.incrementarPozo(evento.getMonto());
                    lblMensaje.setText(jugador.getNombreCompleto() + " ha pagado la apuesta.");
                } else {
                lblMensaje.setText(jugador.getNombreCompleto() + " ha decidido no pagar la apuesta.");
                // Desactiva botones si el jugador no paga
                btnPagarApuesta.setEnabled(false);
                btnCambiarCartas.setEnabled(false);
                btnJugar.setEnabled(false);
                btnPasar.setEnabled(false);
            }
        }
               
    }

    
    
    
}
