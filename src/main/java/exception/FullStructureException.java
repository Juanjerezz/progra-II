package exception;

public class FullStructureException extends RuntimeException {
  public FullStructureException() {
    super("La estructura de datos está llena");
  }

  public FullStructureException(String message) {
    super(message);
  }
}

