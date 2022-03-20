import java.io.*;
import java.nio.charset.Charset;
import java.util.Arrays;

public class FastScanner implements AutoCloseable {

    private final InputStreamReader reader;
    private final char[] buffer = new char[5];
    private int nextChar = 0;
    private int nChars = 0;


    public FastScanner(InputStream stream, Charset charset) {
        reader = new InputStreamReader(stream, charset);
    }

    private void checkBuffer() throws IOException {
        if (nextChar >= nChars) {
            nextChar = 0;
            nChars = reader.read(buffer);
        }
    }

    private boolean isGoodChar(String type) {
        switch (type) {
            case "int":
                return Character.isDigit(buffer[nextChar]) || buffer[nextChar] == '-';
            case "word":
                return Character.isLetter(buffer[nextChar]) ||
                        Character.DASH_PUNCTUATION == Character.getType(buffer[nextChar]) ||
                        buffer[nextChar] == '\'';
            default:
                return !Character.isWhitespace(buffer[nextChar]);
        }
    }

    private String nextAny(String type) throws IOException {
        StringBuilder word = new StringBuilder();

        int startChar = nextChar;

        while (isGoodChar(type) && hasNext()) {
            nextChar++;

            if (nextChar >= nChars) {
                word.append(buffer, startChar, nextChar - startChar);
                checkBuffer();
                startChar = 0;
            }
        }
        word.append(buffer, startChar, nextChar - startChar);
        return word.toString();
    }

    private boolean hasNextAnyInLine(String type) throws IOException {
        while (!isGoodChar(type)) {
            if (endOfLine()) {
                return false;
            }
            nextChar++;
            checkBuffer();
        }
        return true;
    }

    public boolean hasNextInLine() throws IOException {
        return hasNextAnyInLine("default");
    }

    public boolean hasNextIntInLine() throws IOException {
        return hasNextAnyInLine("int");
    }

    public boolean hasNextWordInLine() throws IOException {
        return hasNextAnyInLine("word");
    }


    public String next() throws IOException {
        return nextAny("default");
    }

    public int nextInt() throws IOException {
        return Integer.parseInt(nextAny("int"));
    }

    public String nextWord() throws IOException {
        return nextAny("word");
    }


    private boolean endOfLine() {
        return Arrays.asList('\n', '\r', '\f', '\u0085', '\u2028', '\u2029').contains(buffer[nextChar]);
    }

    public void toNextLine() throws IOException {

        if (buffer[nextChar] == '\r') {
            if (nextChar + 1 >= nChars) {
                nextChar++;
                checkBuffer();
                if (buffer[nextChar] == '\n') {
                    nextChar++;
                }
            } else {
                if(buffer[nextChar+1]=='\n') {
                    nextChar += 2;
                }
                else{
                    nextChar+=1;
                }
            }
        } else {
            nextChar += 1;
        }
    }

    public boolean hasNext() throws IOException {
        checkBuffer();
        return nextChar <= nChars;
    }

    public void close() throws IOException {
        reader.close();
    }
}
