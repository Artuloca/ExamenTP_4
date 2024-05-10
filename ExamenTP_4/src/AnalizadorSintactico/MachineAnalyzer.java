package AnalizadorSintactico;

import Maquinas.Maquina;
import AnalizadorSintactico.Lexer;
import AnalizadorSintactico.Parser;
import java.util.List;

/**
 * Esta es la clase MachineAnalyzer.
 * Se utiliza para analizar una máquina y determinar si su código fuente es válido.
 */
public class MachineAnalyzer {

    private Lexer lexer;
    private Parser parser;

    public MachineAnalyzer() {
        lexer = new Lexer();
        parser = new Parser();
    }

    public boolean analyze(Maquina machine) {
        // Obtiene el código fuente del método count de la máquina
        String sourceCode = lexer.tokenize(machine);

        // Realiza el análisis sintáctico del código fuente
        return parser.parse(sourceCode);
    }
}
