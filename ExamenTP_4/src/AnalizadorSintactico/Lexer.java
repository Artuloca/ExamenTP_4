package AnalizadorSintactico;
import Maquinas.Maquina;

import java.lang.reflect.Method;

public class Lexer {
    /**
     * Método para obtener el código fuente de un método de una máquina.
        * @param machine la máquina de la que se obtendrá el código fuente.
        * @return el código fuente del método count de la máquina.
        */
    public String tokenize(Maquina machine) {
        try {
            // Obtener el método count de la máquina
            Method countMethod = machine.getClass().getMethod("count");

            // Obtener el código fuente del método count
            // Esto dependerá de cómo estés almacenando el código fuente de tus métodos
            String sourceCode = getSourceCode(countMethod);

            return sourceCode;
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        }
    }

    // Este método deberá implementarse para obtener el código fuente de un método
    private String getSourceCode(Method method) {
        // Implementación depende de cómo estés almacenando el código fuente de tus métodos
        return null;
    }
}
