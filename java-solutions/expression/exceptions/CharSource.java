package expression.exceptions;

/**
 * @author Georgiy Korneev (kgeorgiy@kgeorgiy.info)
 */
public interface CharSource {
    boolean hasNext();
    boolean hasNext(int len);
    char next();
    char next(int len);
    int getPosition();
    IllegalArgumentException error(final String message);
    char checkNext();

}
