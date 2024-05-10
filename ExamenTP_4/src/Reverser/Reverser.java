package Reverser;

import Checker.Checker;
import Maquinas.Maquina;
import Maquinas.MaquinaA.CuentaAtras;
import Maquinas.MaquinaB.Contador;
import Maquinas.NegativeNumberException;

/**
 * Esta es la clase Reverser que proporciona un método principal para ejecutar una máquina y verificar si se detendrá o no.
 */
public class Reverser {
    public static void main(String[] args) throws NegativeNumberException {
        if (args.length < 2) {
            System.out.println("Por favor, proporciona el tipo de máquina y la entrada como argumentos.");
            return;
        }

        int number = Integer.parseInt(args[1]);
        Maquina maquina = args[0].equals("Contador") ? new Contador(number) : new CuentaAtras(number);
        if (Checker.willHalt(maquina, number)) {
            while (true) {
                // Si HaltChecker indica que el programa se detendrá, entonces Reverser debería entrar en un bucle infinito
            }
        } else {
            // Si HaltChecker indica que no se detendrá, entonces debería terminar inmediatamente
            return;
        }
    }
}
