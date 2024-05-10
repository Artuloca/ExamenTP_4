package Maquinas;

/**
 * Esta es la interfaz Prototype que define el método que deben implementar las máquinas para clonarse a sí mismas.
 */
public interface Prototype {
    /**
     * Clona la máquina.
     * @return una nueva instancia de la máquina.
     */
    Maquina clone();
}
