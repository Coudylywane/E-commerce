package cours.ecole221.exeptions;

public class InvalidPhoneNumberException
        extends RuntimeException {

    public InvalidPhoneNumberException(String message) {
        super(message);
    }
}
