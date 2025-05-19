package exception;

public class EmptyStructureException extends RuntimeException {
    public EmptyStructureException() {
        super("La estructura de datos está vacía");
    }

    public EmptyStructureException(String message) {
        super(message);
    }
}

