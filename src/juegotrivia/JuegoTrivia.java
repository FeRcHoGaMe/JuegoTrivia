/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
    
Autor Luis Fernando Forero Beltran
*/

package juegotrivia;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class JuegoTrivia extends JFrame implements ActionListener {

    private JTextField txtNombreJugador1;
    private JTextField txtNombreJugador2;
    private JComboBox<String> comboTemas;
    private JButton btnIniciar;
    private String jugador1;
    private String jugador2;
    private int puntajeJugador1;
    private int puntajeJugador2;
    private JButton btnSalir;

    public JuegoTrivia() {
        setTitle("Juego de TRIVIANAUTAS");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        JPanel panelInicial = new JPanel(new BorderLayout());

        JLabel lblTitulo = new JLabel("Bienvenido al Juego de TRIVIANAUTAS");
        panelInicial.add(lblTitulo, BorderLayout.NORTH);
        
        
        JPanel panelNombres = new JPanel(new FlowLayout());
                
        JLabel lblNombreJugador1 = new JLabel("Nombre del jugador 1:");
        panelNombres.add(lblNombreJugador1);

        txtNombreJugador1 = new JTextField(15);
        panelNombres.add(txtNombreJugador1);

        JLabel lblNombreJugador2 = new JLabel("Nombre del jugador 2:");
        panelNombres.add(lblNombreJugador2);

        txtNombreJugador2 = new JTextField(15);
        panelNombres.add(txtNombreJugador2);

        JLabel lblSeleccion = new JLabel("Selecciona un tema:");
        panelNombres.add(lblSeleccion);

        comboTemas = new JComboBox<>();
        comboTemas.addItem("Deportes");
        comboTemas.addItem("Cine");
        comboTemas.addItem("Historia");
        panelNombres.add(comboTemas);

        panelInicial.add(panelNombres, BorderLayout.CENTER);
        
        JPanel panelBotones = new JPanel(new FlowLayout());
        
        btnIniciar = new JButton("Iniciar Juego");
        btnIniciar.addActionListener(this);
        panelBotones.add(btnIniciar);
                
        btnSalir = new JButton("Salir del Juego"); // Botón de salida
        btnSalir.addActionListener(this); // Agregar el ActionListener
        panelBotones.add(btnSalir); // Agregar el botón de salida al panel
        
        panelInicial.add(panelBotones, BorderLayout.SOUTH);
        
        add(panelInicial);
        setVisible(true);
        
        
    }

    @Override
public void actionPerformed(ActionEvent e) {
    if (e.getSource() == btnIniciar) {
        iniciarJuego();
    } else if (e.getSource() == btnSalir) { // Verificar si se hizo clic en el botón de salida
        salirDelJuego();
    }
}


    private void iniciarJuego() {
        jugador1 = txtNombreJugador1.getText();
        jugador2 = txtNombreJugador2.getText();

        if (jugador1.isEmpty() || jugador2.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Debes ingresar el nombre de ambos jugadores.");
            return;
        }

        JOptionPane.showMessageDialog(this, "¡Que comience el juego!");

        String temaSeleccionado = (String) comboTemas.getSelectedItem();

        preguntas(temaSeleccionado);
    }

    private void preguntas(String tema) {
        int puntajeActual = 0;

        if (tema.equals("Deportes")) {
            // Preguntas sobre deportes
            String pregunta1 = "¿En qué país se inventó el fútbol?";
            String respuesta1 = "Inglaterra";

            String pregunta2 = "¿Cuál es el deporte más popular en Estados Unidos?";
            String respuesta2 = "Futbol americano";

            // Preguntar la pregunta 1 al jugador 1
            String respuestaJugador1 = JOptionPane.showInputDialog(this, jugador1 + ", " + pregunta1);

            if (respuestaJugador1.equalsIgnoreCase(respuesta1)) {
                puntajeJugador1++;
                puntajeActual++;
                JOptionPane.showMessageDialog(this, "¡Respuesta correcta! Ganaste 1 punto.");
            } else {
                JOptionPane.showMessageDialog(this, "Respuesta incorrecta.");
            }

            // Preguntar la pregunta 1 al jugador 2
            String respuestaJugador2 = JOptionPane.showInputDialog(this, jugador2 + ", " + pregunta1);

            if (respuestaJugador2.equalsIgnoreCase(respuesta1)) {
                puntajeJugador2++;
                puntajeActual++;
                JOptionPane.showMessageDialog(this, "¡Respuesta correcta! Ganaste 1 punto.");
            } else {
                JOptionPane.showMessageDialog(this, "Respuesta incorrecta.");
            }

            // Preguntar la pregunta 2 al jugador 1
            String respuestaJugador1_2 = JOptionPane.showInputDialog(this, jugador1 + ", " + pregunta2);

            if (respuestaJugador1_2.equalsIgnoreCase(respuesta2)) {
                puntajeJugador1++;
                puntajeActual++;
                JOptionPane.showMessageDialog(this, "¡Respuesta correcta! Ganaste 1 punto.");
            } else {
                JOptionPane.showMessageDialog(this, "Respuesta incorrecta.");
            }

            // Preguntar la pregunta 2 al jugador 2
            String respuestaJugador2_2 = JOptionPane.showInputDialog(this, jugador2 + ", " + pregunta2);

            if (respuestaJugador2_2.equalsIgnoreCase(respuesta2)) {
                puntajeJugador2++;
                puntajeActual++;
                JOptionPane.showMessageDialog(this, "¡Respuesta correcta! Ganaste 1 punto.");
            } else {
                JOptionPane.showMessageDialog(this, "Respuesta incorrecta.");
            }

        } else if (tema.equals("Cine")) {
            // Preguntas sobre cine
            String pregunta1 = "¿Quién dirigió la película 'El Padrino'?";
            String respuesta1 = "Francis Ford Coppola";

            String pregunta2 = "¿En qué año se estrenó la película 'Titanic'?";
            String respuesta2 = "1997";

            // Preguntar la pregunta 1 al jugador 1
            String respuestaJugador1 = JOptionPane.showInputDialog(this, jugador1 + ", " + pregunta1);

            if (respuestaJugador1.equalsIgnoreCase(respuesta1)) {
                puntajeJugador1++;
                puntajeActual++;
                JOptionPane.showMessageDialog(this, "¡Respuesta correcta! Ganaste 1 punto.");
            } else {
                JOptionPane.showMessageDialog(this, "Respuesta incorrecta.");
            }

            // Preguntar la pregunta 1 al jugador 2
            String respuestaJugador2 = JOptionPane.showInputDialog(this, jugador2 + ", " + pregunta1);

            if (respuestaJugador2.equalsIgnoreCase(respuesta1)) {
                puntajeJugador2++;
                puntajeActual++;
                JOptionPane.showMessageDialog(this, "¡Respuesta correcta! Ganaste 1 punto.");
            } else {
                JOptionPane.showMessageDialog(this, "Respuesta incorrecta.");
            }

            // Preguntar la pregunta 2 al jugador 1
            String respuestaJugador1_2 = JOptionPane.showInputDialog(this, jugador1 + ", " + pregunta2);

            if (respuestaJugador1_2.equalsIgnoreCase(respuesta2)) {
                puntajeJugador1++;
                puntajeActual++;
                JOptionPane.showMessageDialog(this, "¡Respuesta correcta! Ganaste 1 punto.");
            } else {
                JOptionPane.showMessageDialog(this, "Respuesta incorrecta.");
            }

            // Preguntar la pregunta 2 al jugador 2
            String respuestaJugador2_2 = JOptionPane.showInputDialog(this, jugador2 + ", " + pregunta2);

            if (respuestaJugador2_2.equalsIgnoreCase(respuesta2)) {
                puntajeJugador2++;
                puntajeActual++;
                JOptionPane.showMessageDialog(this, "¡Respuesta correcta! Ganaste 1 punto.");
            } else {
                JOptionPane.showMessageDialog(this, "Respuesta incorrecta.");
            }
        
        } else if (tema.equals("Historia")) {
            // Preguntas sobre cine
            String pregunta1 = "¿Quien fue el primer presidente de Colombia?";
            String respuesta1 = "Simon Bolivar";

            String pregunta2 = "¿Cuando, en que año inicio la segunda guerra mundial?";
            String respuesta2 = "1939";

            // Preguntar la pregunta 1 al jugador 1
            String respuestaJugador1 = JOptionPane.showInputDialog(this, jugador1 + ", " + pregunta1);

            if (respuestaJugador1.equalsIgnoreCase(respuesta1)) {
                puntajeJugador1++;
                puntajeActual++;
                JOptionPane.showMessageDialog(this, "¡Respuesta correcta! Ganaste 1 punto.");
            } else {
                JOptionPane.showMessageDialog(this, "Respuesta incorrecta.");
            }

            // Preguntar la pregunta 1 al jugador 2
            String respuestaJugador2 = JOptionPane.showInputDialog(this, jugador2 + ", " + pregunta1);

            if (respuestaJugador2.equalsIgnoreCase(respuesta1)) {
                puntajeJugador2++;
                puntajeActual++;
                JOptionPane.showMessageDialog(this, "¡Respuesta correcta! Ganaste 1 punto.");
            } else {
                JOptionPane.showMessageDialog(this, "Respuesta incorrecta.");
            }

            // Preguntar la pregunta 2 al jugador 1
            String respuestaJugador1_2 = JOptionPane.showInputDialog(this, jugador1 + ", " + pregunta2);

            if (respuestaJugador1_2.equalsIgnoreCase(respuesta2)) {
                puntajeJugador1++;
                puntajeActual++;
                JOptionPane.showMessageDialog(this, "¡Respuesta correcta! Ganaste 1 punto.");
            } else {
                JOptionPane.showMessageDialog(this, "Respuesta incorrecta.");
            }

            // Preguntar la pregunta 2 al jugador 2
            String respuestaJugador2_2 = JOptionPane.showInputDialog(this, jugador2 + ", " + pregunta2);

            if (respuestaJugador2_2.equalsIgnoreCase(respuesta2)) {
                puntajeJugador2++;
                puntajeActual++;
                JOptionPane.showMessageDialog(this, "¡Respuesta correcta! Ganaste 1 punto.");
            } else {
                JOptionPane.showMessageDialog(this, "Respuesta incorrecta.");
            }
        }
        if (puntajeJugador1 > puntajeJugador2) {
            JOptionPane.showMessageDialog(this, "¡El ganador es " + jugador1 + "! Puntaje final: " + puntajeJugador1);
        } else if (puntajeJugador2 > puntajeJugador1) {
            JOptionPane.showMessageDialog(this, "¡El ganador es " + jugador2 + "! Puntaje final: " + puntajeJugador2);
        } else {
            JOptionPane.showMessageDialog(this, "¡Empate! Ambos jugadores tienen el mismo puntaje final: " + puntajeJugador1);
        }

        reiniciarJuego();
    }
    private void salirDelJuego() {
    int confirmacion = JOptionPane.showConfirmDialog(this, "¿Estás seguro que quieres salir del juego?", "Salir del juego", JOptionPane.YES_NO_OPTION);
    if (confirmacion == JOptionPane.YES_OPTION) {
        System.exit(0);
    }
    }
    private void reiniciarJuego() {
        txtNombreJugador1.setText("");
        txtNombreJugador2.setText("");
        comboTemas.setSelectedIndex(0);
        puntajeJugador1 = 0;
        puntajeJugador2 = 0;
    }

    public static void main(String[] args) {
        JuegoTrivia juego = new JuegoTrivia();
    }

}
