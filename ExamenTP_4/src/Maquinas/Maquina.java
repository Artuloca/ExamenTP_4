package Maquinas;

/**
 * Esta es la interfaz Maquina que define los métodos que deben implementar las máquinas.
 */
public interface Maquina {
    /**
     * Establece la siguiente máquina en la cadena de responsabilidad.
     * @param maquina la siguiente máquina en la cadena.
     */
    void setNext(Maquina maquina);

    /**
     * Maneja un número. El comportamiento específico depende de la implementación de la máquina.
     * @param number el número a manejar.
     * @return true si la máquina pudo manejar el número, false en caso contrario.
     */
    boolean handle(int number);

    /**
     * Verifica si la máquina está en un bucle infinito.
     * @return true si la máquina está en un bucle infinito, false en caso contrario.
     */
    boolean isInfiniteLoop();

}
