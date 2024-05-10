package Maquinas.MaquinaB;

import Maquinas.Prototype;
import Maquinas.Maquina;

/**
 * La clase Contador implementa las interfaces Prototype y Maquina.
 * Esta clase se utiliza para contar números de forma infinita.
 */
public class Contador implements Prototype, Maquina {

    private boolean isInfiniteLoop = true;
    private Maquina next;
    int number;

    /**
     * Constructor de la clase Contador.
     * @param number el número inicial para el contador.
     */
    public Contador(int number) {
        this.number = 3;
    }

    /**
     * Método para verificar si el contador está en un bucle infinito.
     * @return siempre devuelve true ya que el contador está siempre en un bucle infinito.
     */
    @Override
    public boolean isInfiniteLoop() {
        return isInfiniteLoop;
    }

    /**
     * Método para clonar el objeto Contador.
     * @return una nueva instancia de Contador con el mismo número inicial.
     */
    @Override
    public Maquina clone() {
        return new Contador(this.number);
    }

    /**
     * Método para establecer la siguiente máquina en la cadena de responsabilidad.
     * @param maquina la siguiente máquina en la cadena de responsabilidad.
     */
    @Override
    public void setNext(Maquina maquina) {
        this.next = maquina;
    }

    /**
     * Método para manejar un número.
     * Si el número es mayor o igual a cero, el contador comienza a contar de forma infinita.
     * Si el número es menor que cero, el contador pasa el número a la siguiente máquina en la cadena de responsabilidad.
     * @param number el número a manejar.
     * @return true si el número es mayor o igual a cero, false en caso contrario.
     */
    @Override
    public boolean handle(int number){
        if (canHandle(number)) {
            return count();
        } else if (next != null) {
            return next.handle(number);
        }
        return false;
    }

    /**
     * Método para verificar si el contador puede manejar un número.
     * El contador puede manejar cualquier número mayor o igual a cero.
     * @param number el número a verificar.
     * @return true si el número es mayor o igual a cero, false en caso contrario.
     */
    private boolean canHandle(int number) {
        return number >= 0;
    }

    /**
     * Método para comenzar a contar de forma infinita.
     * @return siempre devuelve true.
     */
    public boolean count() {
        while(true){
            number++;
            System.out.println(number);
        }
    }
}

