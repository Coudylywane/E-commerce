package cours.ecole221.exeptions;

public class InvalidCurrencyException extends RuntimeException{
    public InvalidCurrencyException(String message){
        super(message);
    }
}
