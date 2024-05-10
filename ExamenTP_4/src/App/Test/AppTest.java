package App.Test;

import AnalizadorSintactico.MachineAnalyzer;
import App.App;
import Maquinas.InvalidMachineTypeException;
import Maquinas.Maquina;
import Maquinas.MaquinaA.CuentaAtras;
import Maquinas.MaquinaB.Contador;
import Maquinas.MaquinaFactory;
import Maquinas.NegativeNumberException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MachineAnalyzerTest {

    @Test
    void testAnalyze() {
        MachineAnalyzer analyzer = new MachineAnalyzer();
        try {
            Maquina maquina = MaquinaFactory.getMaquina("Contador", 3);
            assertTrue(analyzer.analyze(maquina));

            maquina = MaquinaFactory.getMaquina("CuentaAtras", 3);
            assertFalse(analyzer.analyze(maquina));
        } catch (InvalidMachineTypeException e) {
            fail("Unexpected InvalidMachineTypeException: " + e.getMessage());
        }
    }
}
