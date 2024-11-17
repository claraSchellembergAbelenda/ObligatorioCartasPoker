package pokerApp.iuJuego;

import interfazusuario.IniciarApuesta;
import estados.EstadoPartida;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import modelJuego.JuegoPoker;
import panelCartasPoker.CartaPoker;
import panelCartasPoker.PanelCartasListener;
import panelCartasPoker.PanelCartasPokerException;
import modelJuego.ManoException;
import modelUsuario.UsuarioException;
import modelFachada.Fachada;
import modelCartasYFiguras.Carta;
import modelCartasYFiguras.TipoFigura;
import modelJuego.Mesa;
import pokerApp.listeners.ApuestaListener;
import pokerApp.listeners.ApuestaManager;
import pokerApp.listeners.EventoApuesta;
import interfazusuario.IngresarAMesa;
import modelUsuario.Jugador;
import utilidades.Observable;
import utilidades.Observador;

public class PanelDeCartas extends javax.swing.JFrame implements PanelCartasListener, 
        ApuestaListener, Observador {

    private JuegoPoker juegoPoker;
    private Jugador jugador;
    private Mesa mesa;
    private List<String>figuras;
    private List<Carta> cartasSeleccionadas = new ArrayList<>();
    private ArrayList<Jugador>jugadoresEnMano= new ArrayList<>();
    
    
    public PanelDeCartas(JuegoPoker juegoPoker, Jugador jugador, Mesa mesa) {
        initComponents();
        this.juegoPoker = juegoPoker;
        this.jugador = jugador;
        this.mesa = mesa;
        //this.mesa.agregarJugador(jugador);
        jugadoresEnMano=mesa.getJugadoresEnMesa();
        inicializarPanelCartas();
        Fachada.getInstancia().precargarFiguras();
        figuras=TipoFigura.getTodasFiguras();
        cargarFiguras();
        ApuestaManager.getInstancia().agregar(this);
        
        // Asignar cartas aleatorias al jugador desde el mazo
        List<Carta> cartasJugador = mesa.getMazo().sacarCartas(5);
        jugador.setCartas((ArrayList<Carta>) cartasJugador);
        cargarCartasEnPanel(jugador.getCartas());
//        cargarCartasEnPanel(jugador.getCartas()); 
        lblSaldoJugador.setText("Saldo: $" + jugador.getSaldo());
        lblMensaje.setText("El juego ha comenzado en la mesa " 
                + juegoPoker.getMesa().getNumeroMesa() + "bienvenido jugador: "
                + jugador.getNombre());
        mostrarFiguraFormada();
    }
    
    
    private void inicializarPanelCartas() {
        panelCartasPoker.setListener(this); // Configura el listener del panel!
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        panelCartasPoker = new panelCartasPoker.PanelCartasPoker();
        btnIniciarApuesta = new javax.swing.JButton();
        btnPasar = new javax.swing.JButton();
        btnCambiarCartas = new javax.swing.JButton();
        btnAbandonarMesa = new javax.swing.JButton();
        btnJugar = new javax.swing.JButton();
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
                                .addGap(37, 37, 37)))
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
                juegoPoker.iniciarApuesta(montoApuesta, jugador);
                lblMensaje.setText( "Apuesta de $" + montoApuesta + " iniciada.");

                float pozoActual = juegoPoker.getMesa().getMontoTotalApostado();
                mesa.setApuestaBase(pozoActual);
                //jugador.descontarSaldo(montoApuesta);
                // Notifica al ApuestaManager que un jugador ha hecho una apuesta
                ApuestaManager.getInstancia().registrarApuesta(jugador, montoApuesta);

                actualizarInterfaz(); // Actualiza la interfaz para reflejar los cambios
                
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
        btnJugar.setEnabled(false);
        btnPasar.setEnabled(false);
        //logica para pasar 
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
        actualizarSaldoJugador();
        lblMensaje.setText("El pozo actual es: $" + pozo);
    }



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAbandonarMesa;
    private javax.swing.JButton btnCambiarCartas;
    private javax.swing.JButton btnIniciarApuesta;
    private javax.swing.JButton btnJugar;
    private javax.swing.JButton btnPasar;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lblFiguraMayor;
    private javax.swing.JLabel lblFigurasDefinidas;
    private javax.swing.JLabel lblMensaje;
    private javax.swing.JLabel lblSaldoJugador;
    private javax.swing.JList lstFiguras;
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
        System.out.println("cargando cartas: "+ cartasPoker.size()
                +"A partir de: "+cartas.size()+
                " nombre jugador: "+ jugador.getNombreCompleto()
        );
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

    public void actualizarEvento(Observable origen, EventoApuesta evento) {
        if(evento.getJugador()!=jugador){
            int respuesta = JOptionPane.showConfirmDialog(this, 
                    evento.getJugador().getNombreCompleto() + " ha realizado una apuesta de $" + evento.getMonto() +
                    ". ¿Deseas pagar la apuesta?", "Pagar Apuesta", 
                    JOptionPane.YES_NO_OPTION);
                if (respuesta == JOptionPane.YES_OPTION && jugador.tieneSaldoSuficiente(evento.getMonto())) {
                    jugador.descontarSaldo(evento.getMonto());
                    mesa.incrementarPozo(evento.getMonto());
                    lblMensaje.setText(jugador.getNombreCompleto() + " ha pagado la apuesta.");
                    actualizarInterfaz();
                } else {
                lblMensaje.setText(jugador.getNombreCompleto() + " ha decidido no pagar la apuesta.");
                // Desactiva botones si el jugador no paga
                btnCambiarCartas.setEnabled(false);
                btnJugar.setEnabled(false);
                btnPasar.setEnabled(false);
            }
        }
               
    }

    @Override
    public void actualizar(Observable origen, Object evento) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    
    
    
}
