package expression.exceptions;

public class ArithmeticException extends RuntimeException {
    public ArithmeticException(String message, int x, int y, String tag ){
        super(String.format("%s occurred with %d %s %d", message, x, tag, y));
    }
    public ArithmeticException(String message, int x, String tag){
        super(String.format("%s occurred with %s %d", message, tag, x));
    }
}
