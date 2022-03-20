package expression.exceptions;

/**
 * @author Georgiy Korneev (kgeorgiy@kgeorgiy.info)
 */
public class StringSource implements CharSource {
    private final String data;
    protected int pos;

    public StringSource(final String data) {
        this.data = data;
    }

    @Override
    public boolean hasNext() {
        return pos < data.length();
    }

    @Override
    public boolean hasNext(int len) {
        return pos + len - 1 < data.length();
    }


    @Override
    public char next() {
        return data.charAt(pos++);
    }

    @Override
    public char next(int len) {
        return data.charAt(pos + len - 1);
    }

    public char checkNext() {
        return data.charAt(pos + 1);
    }

    @Override
    public int getPosition() {
        return pos;
    }

    @Override
    public IllegalArgumentException error(final String message) {
        return new IllegalArgumentException(pos + ": " + message);
    }


}
