package Maquinas.MaquinaB.Test;

import Maquinas.MaquinaB.Contador;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ContadorTest {

    @Test
    void testHandlePositiveNumber() {
        Contador contador = new Contador(3);
        assertTrue(contador.handle(3));
    }

    @Test
    void testHandleZero() {
        Contador contador = new Contador(3);
        assertTrue(contador.handle(0));
    }

    @Test
    void testHandleNegativeNumber() {
        Contador contador = new Contador(3);
        assertFalse(contador.handle(-1));
    }

    @Test
    void testIsInfiniteLoop() {
        Contador contador = new Contador(3);
        assertTrue(contador.isInfiniteLoop());
    }
}
