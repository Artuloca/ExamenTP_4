package Checker.Test;

import Maquinas.Maquina;
import Maquinas.MaquinaA.CuentaAtras;
import Maquinas.MaquinaB.Contador;
import Maquinas.NegativeNumberException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CheckerTest {

    @Test
    void testWillHalt() throws NegativeNumberException {
        Maquina maquinaA = new CuentaAtras(3);
        assertTrue(Checker.Checker.willHalt(maquinaA, 3));

        Maquina maquinaB = new Contador(3);
        assertFalse(Checker.Checker.willHalt(maquinaB, 3));
    }
}
