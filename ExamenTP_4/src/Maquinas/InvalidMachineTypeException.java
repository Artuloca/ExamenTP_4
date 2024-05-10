package Maquinas;

/**
 * Esta es la clase InvalidMachineTypeException que extiende a Exception.
 * Se lanza cuando se proporciona un tipo de máquina no válido.
 */
public class InvalidMachineTypeException extends Exception {
    /**
     * Constructor de la clase InvalidMachineTypeException.
     * @param message el mensaje de error que se mostrará cuando se lance la excepción.
     */
    public InvalidMachineTypeException(String message) {
        super(message);
    }
}

