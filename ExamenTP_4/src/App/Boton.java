package App;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

/**
 * Esta es la clase Boton que extiende a JButton.
 * Se utiliza para crear botones personalizados para la interfaz de usuario.
 */
public class Boton extends JButton {
    /**
     * Constructor de la clase Boton.
     * @param text el texto que se mostrará en el botón.
     * @param actionListener el oyente de acción que se activará cuando se presione el botón.
     */
    public Boton(String text, ActionListener actionListener) {
        super(text);
        this.setAlignmentX(Component.CENTER_ALIGNMENT);
        this.setPreferredSize(new Dimension(200, 50));
        this.addActionListener(actionListener);
    }
}
