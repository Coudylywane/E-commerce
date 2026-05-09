package cours.ecole221.exeptions;

public class CurrencyMismatchException
        extends RuntimeException {

    public CurrencyMismatchException(String message) {
        super(message);
    }
}
