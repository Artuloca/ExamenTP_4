package Maquinas;

import Maquinas.Maquina;
import Maquinas.MaquinaA.CuentaAtras;
import Maquinas.MaquinaB.Contador;

/**
 * Esta es la clase MaquinaFactory que proporciona un método estático para obtener una instancia de una máquina.
 * La máquina que se devuelve depende del tipo de máquina proporcionado.
 */
public class MaquinaFactory {
    /**
     * Método para obtener una instancia de una máquina.
     * @param type el tipo de máquina que se desea obtener. Los tipos válidos son "Contador" y "CuentaAtras".
     * @param number el número que se pasará al constructor de la máquina.
     * @return una nueva instancia de la máquina solicitada.
     * @throws InvalidMachineTypeException si se proporciona un tipo de máquina no válido.
     */
    public static Maquina getMaquina(String type, int number) throws InvalidMachineTypeException {
        if ("Contador".equals(type)) {
            return new Contador(number);
        } else if ("CuentaAtras".equals(type)) {
            try {
                return new CuentaAtras(number);
            } catch (NegativeNumberException e) {
                throw new RuntimeException(e);
            }
        } else {
            throw new InvalidMachineTypeException("Tipo de máquina no válido: " + type);
        }
    }
}
