package Maquinas.MaquinaA;

import Maquinas.NegativeNumberException;
import Maquinas.Prototype;
import Maquinas.Maquina;

/**
 * Esta es la clase CuentaAtras que implementa las interfaces Prototype y Maquina.
 * Esta clase se utiliza para realizar una cuenta atrás desde un número dado hasta cero.
 */
public class CuentaAtras implements Prototype, Maquina {
    private int number;
    private Maquina next;
    private boolean isInfiniteLoop = false;

    /**
     * Constructor de la clase CuentaAtras.
     * @param number el número desde el cual comenzará la cuenta atrás.
     * @throws NegativeNumberException si el número proporcionado es negativo.
     */
    public CuentaAtras(int number) throws NegativeNumberException {
        if (number < 0) {
            throw new NegativeNumberException("El número para la cuenta atrás no puede ser negativo.");
        }
        this.number = number;
    }

    /**
     * Método para clonar el objeto CuentaAtras.
     * @return una nueva instancia de CuentaAtras con el mismo número inicial.
     */
    @Override
    public Maquina clone() {
        try {
            return new CuentaAtras(this.number);
        } catch (NegativeNumberException e) {
            throw new RuntimeException(e);
        }
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
     * Si el número es mayor o igual a cero, la cuenta atrás comienza.
     * Si el número es menor que cero, la cuenta atrás pasa el número a la siguiente máquina en la cadena de responsabilidad.
     * @param number el número a manejar.
     * @return true si el número es mayor o igual a cero, false en caso contrario.
     */
    @Override
    public boolean handle(int number) {
        if (canHandle(number)) {
            count();
            return true; // Devuelve true si pudo manejar el número
        } else if (next != null) {
            return next.handle(number);
        }
        return false;
    }

    /**
     * Método para verificar si la cuenta atrás está en un bucle infinito.
     * @return siempre devuelve false ya que la cuenta atrás nunca entra en un bucle infinito.
     */
    @Override
    public boolean isInfiniteLoop() {
        return false;
    }


    /**
     * Método para verificar si la cuenta atrás puede manejar un número.
     * La cuenta atrás puede manejar cualquier número mayor o igual a cero.
     * @param number el número a verificar.
     * @return true si el número es mayor o igual a cero, false en caso contrario.
     */
    private boolean canHandle(int number) {
        // Countdown no maneja números negativos
        return number >= 0;
    }

    /**
     * Método para comenzar la cuenta atrás.
     * Imprime en la consola desde el número inicial hasta cero.
     */
    public void count() {
        for (int i = number; i >= 0; i--) {
            System.out.println(i);
        }
    }
}
