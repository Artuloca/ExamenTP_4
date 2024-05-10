package Maquinas.MaquinaA.Test;

import Maquinas.MaquinaA.CuentaAtras;
import Maquinas.NegativeNumberException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CuentaAtrasTest {

    @Test
    void testHandlePositiveNumber() throws NegativeNumberException {
        CuentaAtras cuentaAtras = new CuentaAtras(3);
        assertTrue(cuentaAtras.handle(3));
    }

    @Test
    void testHandleZero() throws NegativeNumberException {
        CuentaAtras cuentaAtras = new CuentaAtras(3);
        assertTrue(cuentaAtras.handle(0));
    }

    @Test
    void testHandleNegativeNumber() throws NegativeNumberException {
        CuentaAtras cuentaAtras = new CuentaAtras(3);
        assertFalse(cuentaAtras.handle(-1));
    }

    @Test
    void testIsInfiniteLoop() throws NegativeNumberException {
        CuentaAtras cuentaAtras = new CuentaAtras(3);
        assertFalse(cuentaAtras.isInfiniteLoop());
    }
}
