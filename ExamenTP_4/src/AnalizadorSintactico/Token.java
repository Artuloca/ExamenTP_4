package AnalizadorSintactico;


/**
 * Esta es la clase Token.
 * Se utiliza para representar un token en el código fuente de un método.
 */
public class Token {

    public enum TokenType {
        MACHINE_TYPE, NUMBER, INVALID
    }

    private TokenType type;
    private String value;

    public Token(TokenType type, String value) {
        this.type = type;
        this.value = value;
    }

    public TokenType getType() {
        return type;
    }

    public String getValue() {
        return value;
    }
}
