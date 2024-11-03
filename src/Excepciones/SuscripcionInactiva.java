package Excepciones;

public class SuscripcionInactiva extends RuntimeException {
    public SuscripcionInactiva(String message) {
        super(message);
    }
}
