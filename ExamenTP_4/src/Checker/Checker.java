package Checker;

import Maquinas.Maquina;

/**
 * Esta es la clase Checker que proporciona un método para verificar si una máquina se detendrá o no.
 */
public class Checker {

    /**
     * Verifica si una máquina se detendrá o no.
     * @param maquina la máquina a verificar.
     * @param input el número de entrada para la máquina.
     * @return true si la máquina se detendrá, false en caso contrario.
     */
    public static boolean willHalt(final Maquina maquina, int input) {
        return !maquina.isInfiniteLoop();
    }
}
