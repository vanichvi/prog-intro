import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class ReverseHexDec2 {
    public static void main(String[] args) throws IOException {
        FastScanner scanner = new FastScanner(System.in, StandardCharsets.UTF_8);
        // :NOTE: Строки вместо чисел
        List<String> ar = new ArrayList<>();

        while (scanner.hasNext()) {

            ar.add(System.lineSeparator());

            while (scanner.hasNextInLine()) {
                String next = scanner.next();

                if (next.toLowerCase().startsWith("0x")) {
                    ar.add(next.concat(" "));
                } else {
                    int number = Integer.parseInt(next);
                    ar.add("0x" + Integer.toHexString(number).concat(" "));
                }
            }

            scanner.toNextLine();
        }

        for (int i = ar.size() - 1; i >= 0; i--) {
            System.out.print(ar.get(i));
        }
    }
}