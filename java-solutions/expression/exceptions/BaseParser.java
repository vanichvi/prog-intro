package expression.exceptions;

import expression.exceptions.CharSource;
import expression.exceptions.StringSource;

/**
 * @author Georgiy Korneev (kgeorgiy@kgeorgiy.info)
 */
public class BaseParser {
    private static final char END = '\0';
    protected CharSource source;
    protected char ch = 0xffff;


    protected void makeSource(String exp){
       source= new StringSource(exp);
       take();
    }
    protected char take() {
        final char result = ch;
        ch = source.hasNext() ? source.next() : END;
        return result;
    }

    protected boolean test(final char expected) {
        return ch == expected;
    }
    protected boolean test(final String expected){
        int len = expected.length();
        if (!source.hasNext(len - 1)) {
            return false;
        }

        for (int i = 0; i < len; i++) {
            if (source.hasNext(i) && source.next(i) == expected.charAt(i) == false) {
                return false;
            }
        }
        if (Character.isLetter(expected.charAt(len - 1)) && source.hasNext(len) &&
                (Character.isDigit(source.next(len)) || Character.isLetter(source.next(len)))) {
            return false;
        }
        return true;

}
    protected char next(){
        return source.checkNext();
    }
    protected boolean take(final char expected) {
        if (test(expected)) {
            take();
            return true;
        }
        return false;
    }

    protected void expect(final char expected) {
        if (!take(expected)) {
            throw error("Expected '" + expected + "', found '" + ch + "'");
        }

    }

    protected void expect(final String value) {
        for (final char c : value.toCharArray()) {
            expect(c);
        }

    }
    protected int getPosition(){
        return source.getPosition();
    }
    protected boolean isLetter(){
        return Character.isLetter(ch);
    }
    protected boolean eof() {
        return take(END);
    }

    protected IllegalArgumentException error(final String message) {
        return source.error(message);
    }

    protected boolean between(final char from, final char to) {
        return from <= ch && ch <= to;
    }
}

