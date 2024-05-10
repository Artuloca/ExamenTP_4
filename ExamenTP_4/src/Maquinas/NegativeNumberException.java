package Maquinas;

/**
 * Esta es la clase NegativeNumberException que extiende a Exception.
 * Se lanza cuando se proporciona un número negativo donde no se espera.
 */
public class NegativeNumberException extends Exception {
    /**
     * Constructor de la clase NegativeNumberException.
     * @param message el mensaje de error que se mostrará cuando se lance la excepción.
     */
    public NegativeNumberException(String message) {
        super(message);
    }
}
