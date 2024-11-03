package Excepciones;

public class MaterialInexistente extends RuntimeException {
    public MaterialInexistente(String message) {
        super(message);
    }
}
