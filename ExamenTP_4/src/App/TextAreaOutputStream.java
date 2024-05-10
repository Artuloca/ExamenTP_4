package App;

import java.io.IOException;
import java.io.OutputStream;
import javax.swing.JTextArea;

/**
 * Esta es la clase TextAreaOutputStream que extiende a OutputStream.
 * Se utiliza para redirigir la salida de la consola a una JTextArea.
 */
public class TextAreaOutputStream extends OutputStream {
    private JTextArea textArea;

    /**
     * Constructor de la clase TextAreaOutputStream.
     * @param textArea la JTextArea a la que se redirigirá la salida de la consola.
     */
    public TextAreaOutputStream(JTextArea textArea) {
        this.textArea = textArea;
    }

    /**
     * Método para escribir un byte en la JTextArea.
     * @param b el byte a escribir.
     * @throws IOException si ocurre un error de entrada/salida.
     */
    @Override
    public void write(int b) throws IOException {
        // redirige los datos a la JTextArea
        textArea.append(String.valueOf((char)b));
        // asegura que la JTextArea siempre esté actualizada
        textArea.setCaretPosition(textArea.getDocument().getLength());
    }
}
