package App;

import AnalizadorSintactico.MachineAnalyzer;
import Maquinas.InvalidMachineTypeException;
import AnalizadorSintactico.MachineAnalyzer;
import Checker.Checker;
import Maquinas.Maquina;
import Maquinas.MaquinaFactory;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

/**
 * Esta es la clase App que proporciona una interfaz gráfica de usuario para interactuar con las máquinas.
 * La interfaz permite al usuario seleccionar una máquina y un número de entrada para la máquina.
 * Luego, la aplicación ejecuta la máquina y muestra los resultados en la interfaz de usuario.
 */
public class App extends JFrame {
    // Constantes
    private static final String CONTADOR = "Contador";
    private static final String CUENTA_ATRAS = "CuentaAtras";
    private static final String MAIN_PAGE = "MainPage";
    private static final String RESULT_PAGE = "ResultPage";


    // Variables
    private Thread maquinaThread;
    private JPanel cards;
    private CardLayout cardLayout;
    private JButton button1;
    private JButton button2;
    private JButton backButton;
    private JTextArea resultArea;
    private JButton analyzeButton;
    private MachineAnalyzer analyzer;

    /**
     * Constructor de la clase App.
     * Inicializa la interfaz de usuario.
     */
    public App() {
        setupUI();
    }

    /**
     * Método para configurar la interfaz de usuario.
     */    private void setupUI() {
        setTitle("Reverser App");
        setSize(1000, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        cardLayout = new CardLayout();
        cards = new JPanel(cardLayout);

        analyzer = new MachineAnalyzer();

        JPanel mainPage = createMainPage();
        JPanel resultPage = createResultPage();

        cards.add(mainPage, MAIN_PAGE);
        cards.add(resultPage, RESULT_PAGE);

        add(cards);
    }

    /**
     * Método para crear la página principal.
     * @return JPanel que representa la página principal.
     */
    private JPanel createMainPage() {
        JPanel mainPage = new JPanel();
        mainPage.setLayout(new BoxLayout(mainPage, BoxLayout.Y_AXIS));

        button1 = createButton(CONTADOR, 3);
        button2 = createButton(CUENTA_ATRAS, 3);
        analyzeButton = createAnalyzeButton();


        // Agregar componentes a la página principal
        mainPage.add(Box.createVerticalGlue());
        mainPage.add(button1);
        mainPage.add(Box.createRigidArea(new Dimension(0, 10)));
        mainPage.add(button2);
        mainPage.add(Box.createRigidArea(new Dimension(0, 10)));
        mainPage.add(analyzeButton);
        mainPage.add(Box.createVerticalGlue());

        return mainPage;
    }

    /**
     * Método para crear un botón.
     * @param machineType el tipo de máquina que se ejecutará cuando se presione el botón.
     * @param number el número que se pasará a la máquina cuando se presione el botón.
     * @return JButton que representa el botón creado.
     */
    private JButton createButton(String machineType, int number) {
        return new Boton(machineType, e -> {
            try {
                Maquina maquina = MaquinaFactory.getMaquina(machineType, number);
                executeMachine(maquina, number);
                cardLayout.show(cards, RESULT_PAGE);
            } catch (InvalidMachineTypeException ex) {
                JOptionPane.showMessageDialog(this, "Tipo de máquina no válido: " + machineType);
            }
        });
    }

    /**
     * Método para crear un botón de análisis.
        * @return JButton que representa el botón de análisis.
        */
    private JButton createAnalyzeButton() {
        ActionListener actionListener = e -> {
            String machineName = JOptionPane.showInputDialog("Ingrese el nombre de la máquina que desea revisar:");

            try {
                Maquina machine = MaquinaFactory.getMaquina(machineName, 0);
                boolean result = analyzer.analyze(machine);
                JOptionPane.showMessageDialog(null, "El resultado del análisis es: " + (result ? "válido" : "no válido"));
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
            }
        };

        JButton analyzeButton = new Boton("Analizador Sintáctico", actionListener);
        return analyzeButton;
    }

    /**
     * Método para crear la página de resultados.
     * @return JPanel que representa la página de resultados.
     */    private JPanel createResultPage() {
        JPanel resultPage = new JPanel();
        resultPage.setLayout(new BoxLayout(resultPage, BoxLayout.Y_AXIS));

        backButton = new JButton("Atras");
        backButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        backButton.setPreferredSize(new Dimension(200, 50));
        backButton.addActionListener(e -> cardLayout.show(cards, MAIN_PAGE));

        resultArea = new JTextArea();
        resultArea.setEditable(false);

        resultPage.add(backButton);
        resultPage.add(resultArea);

        return resultPage;
    }

    /**
     * Método que nos permitirá ejecutar la máquina que hemos elegido.
     * @param maquina la máquina a ejecutar.
     * @param input el número de entrada para la máquina.
     */    private void executeMachine(Maquina maquina, int input) {
        if (willEnterInfiniteLoop(maquina, input)) {
            startMachineInNewThread(maquina, input);
        } else {
            executeMachineDirectly(maquina, input);
        }
    }

    /**
     * Método para verificar si una máquina entrará en un bucle infinito.
     * @param maquina la máquina a verificar.
     * @param input el número de entrada para la máquina.
     * @return true si la máquina entrará en un bucle infinito, false en caso contrario.
     */
    public boolean willEnterInfiniteLoop(Maquina maquina, int input) {
        if (!Checker.willHalt(maquina, input)) {
            JOptionPane.showMessageDialog(this, "La máquina entrará en un bucle infinito.");
            return true;
        }
        return false;
    }

    /**
     * Método para iniciar una máquina en un nuevo hilo.
     * @param maquina la máquina a iniciar.
     * @param input el número de entrada para la máquina.
     */
    private void startMachineInNewThread(Maquina maquina, int input) {
        maquinaThread = new Thread(() -> maquina.handle(input));
        maquinaThread.start();
    }

    /**
     * Método para ejecutar una máquina directamente.
     * @param maquina la máquina a ejecutar.
     * @param input el número de entrada para la máquina.
     */
    private void executeMachineDirectly(Maquina maquina, int input) {
        maquina.handle(input);
    }


    /**
     * Método principal para iniciar la aplicación.
     * @param args argumentos de la línea de comandos.
     */
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            App app = new App();
            app.setVisible(true);
        });
    }
}
